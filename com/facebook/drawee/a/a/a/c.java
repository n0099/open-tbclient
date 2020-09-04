package com.facebook.drawee.a.a.a;

import javax.annotation.Nullable;
/* loaded from: classes9.dex */
public class c extends com.facebook.imagepipeline.h.a {
    private String nmT;
    @Nullable
    private final b nmU;

    public c(String str, @Nullable b bVar) {
        this.nmU = bVar;
        init(str);
    }

    public void init(String str) {
        this.nmT = str;
    }

    @Override // com.facebook.imagepipeline.h.a, com.facebook.imagepipeline.producers.am
    public void F(String str, String str2, boolean z) {
        if (this.nmU != null) {
            this.nmU.g(this.nmT, d.Uy(str2), z);
        }
    }
}
