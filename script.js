document.addEventListener("DOMContentLoaded", function () {
  const botao = document.getElementById("ver-cardapio");
  const header = document.querySelector("header");
  const menuCardapio = document.getElementById("menu-cardapio");

  botao.addEventListener("click", function (e) {
    e.preventDefault();

    // Fade out header
    header.style.transition = "opacity 0.5s ease";
    header.style.opacity = 0;

    setTimeout(() => {
      header.style.display = "none";
      menuCardapio.style.display = "block";
      menuCardapio.style.opacity = 0;
      menuCardapio.style.transition = "opacity 0.5s ease";

      setTimeout(() => {
        menuCardapio.style.opacity = 1;
        window.scrollTo(0, 0);
      }, 50);
    }, 500);
  });
});
