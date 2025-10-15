// ローン申し込み確認画面で申込ボタン(submitボタン)が押された場合にダイアログを出す実装
const form = document.getElementById("confirmationForm");
    form.addEventListener("submit", function (e) {
    　// ダイアログのOKボタンが押された場合は次の処理へ、キャンセルの場合は次の処理へ行かないようにする実装
      const result = confirm("注文を確定してよろしいでしょうか？");
      if (!result) {
        e.preventDefault();
      }
    });