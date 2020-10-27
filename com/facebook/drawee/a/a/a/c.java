package com.facebook.drawee.a.a.a;

import javax.annotation.Nullable;
/* loaded from: classes18.dex */
public class c extends com.facebook.imagepipeline.h.a {
    private String oDF;
    @Nullable
    private final b oDG;

    public c(String str, @Nullable b bVar) {
        this.oDG = bVar;
        init(str);
    }

    public void init(String str) {
        this.oDF = str;
    }

    @Override // com.facebook.imagepipeline.h.a, com.facebook.imagepipeline.producers.am
    public void G(String str, String str2, boolean z) {
        if (this.oDG != null) {
            this.oDG.g(this.oDF, d.XB(str2), z);
        }
    }
}
