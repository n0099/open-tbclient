package com.mofamulu.tieba.ch;

import android.view.View;
import android.widget.Toast;
import com.baidu.tieba.person.PersonInfoActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnLongClickListener {
    private final /* synthetic */ String a;
    private final /* synthetic */ PersonInfoActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(String str, PersonInfoActivity personInfoActivity) {
        this.a = str;
        this.b = personInfoActivity;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        String str = "@" + this.a + " ";
        if (com.mofamulu.tieba.tail.an.a == null) {
            com.mofamulu.tieba.tail.an.a = str;
        } else if (!com.mofamulu.tieba.tail.an.a.contains(str)) {
            com.mofamulu.tieba.tail.an.a = String.valueOf(com.mofamulu.tieba.tail.an.a) + str;
        }
        Toast.makeText(this.b, "已保存：" + str, 0).show();
        return true;
    }
}
