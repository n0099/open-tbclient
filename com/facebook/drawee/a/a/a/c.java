package com.facebook.drawee.a.a.a;

import javax.annotation.Nullable;
/* loaded from: classes9.dex */
public class c extends com.facebook.imagepipeline.g.a {
    private String pdJ;
    @Nullable
    private final b pdK;

    public c(String str, @Nullable b bVar) {
        this.pdK = bVar;
        init(str);
    }

    public void init(String str) {
        this.pdJ = str;
    }

    @Override // com.facebook.imagepipeline.g.a, com.facebook.imagepipeline.producers.am
    public void J(String str, String str2, boolean z) {
        if (this.pdK != null) {
            this.pdK.g(this.pdJ, d.Zl(str2), z);
        }
    }
}
