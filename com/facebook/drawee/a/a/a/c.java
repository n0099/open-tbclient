package com.facebook.drawee.a.a.a;

import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class c extends com.facebook.imagepipeline.h.a {
    private String mKC;
    @Nullable
    private final b mKD;

    public c(String str, @Nullable b bVar) {
        this.mKD = bVar;
        init(str);
    }

    public void init(String str) {
        this.mKC = str;
    }

    @Override // com.facebook.imagepipeline.h.a, com.facebook.imagepipeline.producers.am
    public void G(String str, String str2, boolean z) {
        if (this.mKD != null) {
            this.mKD.g(this.mKC, d.QJ(str2), z);
        }
    }
}
