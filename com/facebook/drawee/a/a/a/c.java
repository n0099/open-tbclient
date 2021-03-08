package com.facebook.drawee.a.a.a;

import javax.annotation.Nullable;
/* loaded from: classes14.dex */
public class c extends com.facebook.imagepipeline.g.a {
    private String pDl;
    @Nullable
    private final b pDm;

    public c(String str, @Nullable b bVar) {
        this.pDm = bVar;
        init(str);
    }

    public void init(String str) {
        this.pDl = str;
    }

    @Override // com.facebook.imagepipeline.g.a, com.facebook.imagepipeline.producers.am
    public void M(String str, String str2, boolean z) {
        if (this.pDm != null) {
            this.pDm.g(this.pDl, d.ZH(str2), z);
        }
    }
}
