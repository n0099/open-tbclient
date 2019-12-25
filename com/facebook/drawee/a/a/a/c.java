package com.facebook.drawee.a.a.a;

import javax.annotation.Nullable;
/* loaded from: classes11.dex */
public class c extends com.facebook.imagepipeline.h.a {
    private String lFW;
    @Nullable
    private final b lFX;

    public c(String str, @Nullable b bVar) {
        this.lFX = bVar;
        init(str);
    }

    public void init(String str) {
        this.lFW = str;
    }

    @Override // com.facebook.imagepipeline.h.a, com.facebook.imagepipeline.producers.am
    public void C(String str, String str2, boolean z) {
        if (this.lFX != null) {
            this.lFX.h(this.lFW, d.Oz(str2), z);
        }
    }
}
