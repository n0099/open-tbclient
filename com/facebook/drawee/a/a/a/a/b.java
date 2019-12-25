package com.facebook.drawee.a.a.a.a;

import com.facebook.drawee.a.a.a.g;
import com.facebook.drawee.a.a.a.h;
/* loaded from: classes11.dex */
public class b implements com.facebook.drawee.a.a.a.b {
    private final g lFL;
    private final h lGo;

    public b(h hVar, g gVar) {
        this.lGo = hVar;
        this.lFL = gVar;
    }

    @Override // com.facebook.drawee.a.a.a.b
    public void h(String str, int i, boolean z) {
        this.lGo.Hp(i);
        this.lGo.uN(z);
        this.lFL.a(this.lGo, 1);
    }
}
