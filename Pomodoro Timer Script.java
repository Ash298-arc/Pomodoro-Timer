document.addEventListener('DOMContentLoaded', () => {
    const timeDisplay = document.getElementById('time');
    const startButton = document.getElementById('start');
    const pauseButton = document.getElementById('pause');
    const resetButton = document.getElementById('reset');

    let timer;
    let isRunning = false;
    let time = 25 * 60; // 25 minutes in seconds

    function updateTimeDisplay() {
        const minutes = Math.floor(time / 60);
        const seconds = time % 60;
        timeDisplay.textContent = `${minutes.toString().padStart(2, '0')}:${seconds.toString().padStart(2, '0')}`;
    }

    function startTimer() {
        if (isRunning) return;
        isRunning = true;
        timer = setInterval(() => {
            time--;
            if (time <= 0) {
                clearInterval(timer);
                alert('Time is up!');
                resetTimer();
            }
            updateTimeDisplay();
        }, 1000);
    }

    function pauseTimer() {
        clearInterval(timer);
        isRunning = false;
    }

    function resetTimer() {
        pauseTimer();
        time = 25 * 60;
        updateTimeDisplay();
    }

    startButton.addEventListener('click', startTimer);
    pauseButton.addEventListener('click', pauseTimer);
    resetButton.addEventListener('click', resetTimer);

    updateTimeDisplay();
});
