package com.facebook.drawee.a.a.a;

import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class c extends com.facebook.imagepipeline.h.a {
    @Nullable
    private final b lJA;
    private String lJz;

    public c(String str, @Nullable b bVar) {
        this.lJA = bVar;
        init(str);
    }

    public void init(String str) {
        this.lJz = str;
    }

    @Override // com.facebook.imagepipeline.h.a, com.facebook.imagepipeline.producers.am
    public void C(String str, String str2, boolean z) {
        if (this.lJA != null) {
            this.lJA.h(this.lJz, d.OJ(str2), z);
        }
    }
}
