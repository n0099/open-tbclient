package com.mofamulu.tieba.ch;

import android.content.DialogInterface;
import com.baidu.tieba.person.PersonInfoActivity;
/* loaded from: classes.dex */
class h implements DialogInterface.OnClickListener {
    final /* synthetic */ g a;
    private final /* synthetic */ PersonInfoActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar, PersonInfoActivity personInfoActivity) {
        this.a = gVar;
        this.b = personInfoActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == 0) {
            au.a(this.b, "http://book.mofamulu.com/usr/modifyRenders.do");
        } else if (i == 1) {
            au.a(this.b, "http://book.mofamulu.com/usr/userPanel.do");
        } else if (i == 2) {
            au.a(this.b, "http://code.google.com/p/tieba-helper/wiki/FAQForAll");
        }
    }
}
