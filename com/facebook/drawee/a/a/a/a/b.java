package com.facebook.drawee.a.a.a.a;

import com.facebook.drawee.a.a.a.g;
import com.facebook.drawee.a.a.a.h;
/* loaded from: classes15.dex */
public class b implements com.facebook.drawee.a.a.a.b {
    private final g pAV;
    private final h pBy;

    public b(h hVar, g gVar) {
        this.pBy = hVar;
        this.pAV = gVar;
    }

    @Override // com.facebook.drawee.a.a.a.b
    public void g(String str, int i, boolean z) {
        this.pBy.Pb(i);
        this.pBy.Bi(z);
        this.pAV.a(this.pBy, 1);
    }
}
