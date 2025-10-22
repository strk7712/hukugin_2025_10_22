 const tokyo = [
   {cd:"1", label:"本支店"},
   {cd:"2", label:"千代田支店"},
   {cd:"3", label:"丸の内支店"}
 ];
 const hachioji = [
   {cd:"1", label:"高尾支店"},
   {cd:"2", label:"西八王子支店"},
   {cd:"3", label:"みなみ野支店"},
   {cd:"4", label:"昭島支店"}
 ];
 const castle = [
   {cd:"1", label:"姫路支店"},
   {cd:"2", label:"大阪支店"},
   {cd:"3", label:"名古屋支店"},
   {cd:"4", label:"熊本支店"}
 ];

const bankname = document.getElementById("bankname");
bankname.addEventListener("change",function(){
   siten = document.getElementById("siten");
   siten.options.length = 0
   var changedPref = bankname.value;
   if (changedPref == "東京中央銀行") {
       tokyo.forEach(function(value) {
         var op = document.createElement("option");
         op.value = value.cd;
         op.text = value.label;
         siten.appendChild(op);
       });
   } else if (changedPref == "八王子銀行") {
        hachioji.forEach(function(value) {
            var op = document.createElement("option");
            op.value = value.cd;
            op.text = value.label;
            siten.appendChild(op);
          });

   } else if (changedPref == "キャッスル銀行") {
        castle.forEach(function(value) {
            var op = document.createElement("option");
            op.value = value.cd;
            op.text = value.label;
            siten.appendChild(op);
        });
   }
});
 // 投資信託注文確認画面で申込ボタン(submitボタン)が押された場合にダイアログを出す実装
 const form = document.getElementById("confirmationForm");
     form.addEventListener("submit", function (e) {
     　// ダイアログのOKボタンが押された場合は次の処理へ、キャンセルの場合は次の処理へ行かないようにする実装
       const result = confirm("注文を確定してよろしいでしょうか？");
       if (!result) {
         e.preventDefault();
       }
     });

