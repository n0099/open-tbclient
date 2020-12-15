package com.facebook.drawee.a.a.a;

import javax.annotation.Nullable;
/* loaded from: classes9.dex */
public class c extends com.facebook.imagepipeline.g.a {
    private String pdL;
    @Nullable
    private final b pdM;

    public c(String str, @Nullable b bVar) {
        this.pdM = bVar;
        init(str);
    }

    public void init(String str) {
        this.pdL = str;
    }

    @Override // com.facebook.imagepipeline.g.a, com.facebook.imagepipeline.producers.am
    public void J(String str, String str2, boolean z) {
        if (this.pdM != null) {
            this.pdM.g(this.pdL, d.Zl(str2), z);
        }
    }
}
