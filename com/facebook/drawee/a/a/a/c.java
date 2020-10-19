package com.facebook.drawee.a.a.a;

import javax.annotation.Nullable;
/* loaded from: classes18.dex */
public class c extends com.facebook.imagepipeline.h.a {
    private String nMm;
    @Nullable
    private final b nMn;

    public c(String str, @Nullable b bVar) {
        this.nMn = bVar;
        init(str);
    }

    public void init(String str) {
        this.nMm = str;
    }

    @Override // com.facebook.imagepipeline.h.a, com.facebook.imagepipeline.producers.am
    public void F(String str, String str2, boolean z) {
        if (this.nMn != null) {
            this.nMn.g(this.nMm, d.VO(str2), z);
        }
    }
}
