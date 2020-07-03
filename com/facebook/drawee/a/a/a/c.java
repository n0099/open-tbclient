package com.facebook.drawee.a.a.a;

import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class c extends com.facebook.imagepipeline.h.a {
    @Nullable
    private final b mKA;
    private String mKz;

    public c(String str, @Nullable b bVar) {
        this.mKA = bVar;
        init(str);
    }

    public void init(String str) {
        this.mKz = str;
    }

    @Override // com.facebook.imagepipeline.h.a, com.facebook.imagepipeline.producers.am
    public void G(String str, String str2, boolean z) {
        if (this.mKA != null) {
            this.mKA.g(this.mKz, d.QI(str2), z);
        }
    }
}
