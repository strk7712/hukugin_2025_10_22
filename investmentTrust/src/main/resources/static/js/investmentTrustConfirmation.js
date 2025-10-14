const form = document.getElementById("confirmationForm");
    form.addEventListener("submit", function (e) {
      const result = confirm("注文を確定してよろしいでしょうか？");
      if (!result) {
        e.preventDefault();
      }
    });