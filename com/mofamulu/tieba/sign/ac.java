package com.mofamulu.tieba.sign;

import android.view.View;
import com.mofamulu.tieba.ch.bf;
import java.util.LinkedList;
/* loaded from: classes.dex */
class ac implements View.OnClickListener {
    final /* synthetic */ MoreIgnoredTiebasActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(MoreIgnoredTiebasActivity moreIgnoredTiebasActivity) {
        this.a = moreIgnoredTiebasActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String[] b = bf.b(this.a.g.getText().toString().trim(), "\n");
        LinkedList linkedList = new LinkedList();
        for (String str : b) {
            String trim = str.trim();
            if (trim.length() != 0) {
                linkedList.addLast(trim);
            }
        }
        this.a.k.a(linkedList);
        this.a.setResult(1);
        this.a.finish();
    }
}
