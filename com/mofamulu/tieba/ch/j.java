package com.mofamulu.tieba.ch;

import android.content.Context;
import android.widget.ImageView;
import com.baidu.tieba.person.PersonInfoActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements ba {
    private final /* synthetic */ PersonInfoActivity a;
    private final /* synthetic */ ImageView b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(PersonInfoActivity personInfoActivity, ImageView imageView) {
        this.a = personInfoActivity;
        this.b = imageView;
    }

    @Override // com.mofamulu.tieba.ch.ba
    public void a(av avVar) {
        if (avVar != null && !bf.a(avVar.i)) {
            com.baidu.tieba.util.a aVar = new com.baidu.tieba.util.a(this.a);
            aVar.a(com.baidu.tieba.util.aa.a((Context) this.a), com.baidu.tieba.util.aa.a(this.a, 150.0f));
            com.baidu.adp.widget.a.b c = aVar.c(avVar.i);
            if (c == null) {
                aVar.a(avVar.i, new k(this, this.b));
            } else {
                c.b(this.b);
            }
        }
    }
}
