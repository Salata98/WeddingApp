const inBar = document.querySelector('.in');
const heartText = document.querySelector('.heart--text');
const now = Date.now();
const begin = Date.parse("January 1, 2021");
const end = Date.parse("May 13, 2022");
const progress = +(((begin - now) / (begin - end)) * 100).toFixed(0);
let barWidth = 0;

const loadProgress = () => {
  inBar.style.width = `${barWidth / 5}%`;
  heartText.textContent = `${(barWidth / 5).toFixed(0)}%`;
  if (barWidth / 5 === 100) clearInterval(loading);
  if (barWidth / 5 === progress) clearInterval(loading);
  barWidth++;
};

loading = window.setInterval(loadProgress, 7);