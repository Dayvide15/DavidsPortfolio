package edu.wcupa.csc461.shodipe.myapplication.ui.project2.ui

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import edu.wcupa.csc461.shodipe.myapplication.ui.project2.GameUiState
import edu.wcupa.csc461.shodipe.myapplication.ui.project2.data.allWords
import edu.wcupa.csc461.shodipe.myapplication.ui.project2.data.MAX_NO_OF_WORDS
import edu.wcupa.csc461.shodipe.myapplication.ui.project2.data.SCORE_INCREASE
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class GameViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(GameUiState())
    val uiState: StateFlow<GameUiState> = _uiState.asStateFlow()

    private lateinit var currentWord: String

    private var usedWords: MutableSet<String> = mutableSetOf()

    var userGuess by mutableStateOf("")
        private set

    init {
        resetGame()
    }

    private fun pickRandomWordAndShuffle(): String {
        var newWord: String
        do {
            newWord = allWords.random()
        } while (usedWords.contains(newWord))
        currentWord = newWord
        usedWords.add(currentWord)
        return shuffleCurrentWord(currentWord)
    }

    private fun shuffleCurrentWord(word: String): String {
        val tempWord = word.toCharArray()
        do {
            tempWord.shuffle()
        } while (String(tempWord).equals(word, ignoreCase = true))
        return String(tempWord)
    }

    fun updateUserGuess(guessedWord: String) {
        userGuess = guessedWord
    }

    fun checkUserGuess() {
        if (userGuess.equals(currentWord, ignoreCase = true)) {
            val updatedScore = _uiState.value.score + SCORE_INCREASE
            updateGameState(updatedScore)
        } else {
            _uiState.value = _uiState.value.copy(isGuessedWordWrong = true)
        }
        userGuess = ""
    }

    fun skipWord() {
        updateGameState(_uiState.value.score)
        userGuess = ""
    }

    private fun updateGameState(updatedScore: Int) {
        if (usedWords.size >= MAX_NO_OF_WORDS) {
            _uiState.value = _uiState.value.copy(
                isGuessedWordWrong = false,
                score = updatedScore,
                isGameOver = true
            )
        } else {
            _uiState.value = _uiState.value.copy(
                isGuessedWordWrong = false,
                currentScrambledWord = pickRandomWordAndShuffle(),
                currentWordCount = _uiState.value.currentWordCount + 1,
                score = updatedScore
            )
        }
    }

    fun resetGame() {
        usedWords.clear()
        _uiState.value = GameUiState(currentScrambledWord = pickRandomWordAndShuffle())
        userGuess = ""
    }
}