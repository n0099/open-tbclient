package com.facebook.drawee.a.a.a;

import javax.annotation.Nullable;
/* loaded from: classes18.dex */
public class c extends com.facebook.imagepipeline.h.a {
    private String oMY;
    @Nullable
    private final b oMZ;

    public c(String str, @Nullable b bVar) {
        this.oMZ = bVar;
        init(str);
    }

    public void init(String str) {
        this.oMY = str;
    }

    @Override // com.facebook.imagepipeline.h.a, com.facebook.imagepipeline.producers.am
    public void H(String str, String str2, boolean z) {
        if (this.oMZ != null) {
            this.oMZ.g(this.oMY, d.Yf(str2), z);
        }
    }
}
