package com.facebook.drawee.a.a.a;

import javax.annotation.Nullable;
/* loaded from: classes9.dex */
public class c extends com.facebook.imagepipeline.h.a {
    private String nmB;
    @Nullable
    private final b nmC;

    public c(String str, @Nullable b bVar) {
        this.nmC = bVar;
        init(str);
    }

    public void init(String str) {
        this.nmB = str;
    }

    @Override // com.facebook.imagepipeline.h.a, com.facebook.imagepipeline.producers.am
    public void F(String str, String str2, boolean z) {
        if (this.nmC != null) {
            this.nmC.g(this.nmB, d.Uy(str2), z);
        }
    }
}
