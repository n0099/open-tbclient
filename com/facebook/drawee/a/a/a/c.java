package com.facebook.drawee.a.a.a;

import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class c extends com.facebook.imagepipeline.h.a {
    private String lTx;
    @Nullable
    private final b lTy;

    public c(String str, @Nullable b bVar) {
        this.lTy = bVar;
        init(str);
    }

    public void init(String str) {
        this.lTx = str;
    }

    @Override // com.facebook.imagepipeline.h.a, com.facebook.imagepipeline.producers.am
    public void D(String str, String str2, boolean z) {
        if (this.lTy != null) {
            this.lTy.g(this.lTx, d.Oh(str2), z);
        }
    }
}
