package com.facebook.drawee.a.a.a;

import javax.annotation.Nullable;
/* loaded from: classes15.dex */
public class c extends com.facebook.imagepipeline.g.a {
    private String pAG;
    @Nullable
    private final b pAH;

    public c(String str, @Nullable b bVar) {
        this.pAH = bVar;
        init(str);
    }

    public void init(String str) {
        this.pAG = str;
    }

    @Override // com.facebook.imagepipeline.g.a, com.facebook.imagepipeline.producers.am
    public void M(String str, String str2, boolean z) {
        if (this.pAH != null) {
            this.pAH.g(this.pAG, d.Zp(str2), z);
        }
    }
}
