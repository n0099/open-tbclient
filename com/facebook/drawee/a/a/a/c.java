package com.facebook.drawee.a.a.a;

import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class c extends com.facebook.imagepipeline.h.a {
    private String moA;
    @Nullable
    private final b moB;

    public c(String str, @Nullable b bVar) {
        this.moB = bVar;
        init(str);
    }

    public void init(String str) {
        this.moA = str;
    }

    @Override // com.facebook.imagepipeline.h.a, com.facebook.imagepipeline.producers.am
    public void F(String str, String str2, boolean z) {
        if (this.moB != null) {
            this.moB.g(this.moA, d.PW(str2), z);
        }
    }
}
