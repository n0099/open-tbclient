package com.mofamulu.tieba.ch;

import android.widget.ImageView;
/* loaded from: classes.dex */
class k implements com.baidu.tbadk.a.d {
    final /* synthetic */ j a;
    private final /* synthetic */ ImageView b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar, ImageView imageView) {
        this.a = jVar;
        this.b = imageView;
    }

    @Override // com.baidu.tbadk.a.d
    public void a(com.baidu.adp.widget.a.b bVar, String str, boolean z) {
        if (bVar != null) {
            bVar.b(this.b);
        }
    }
}
