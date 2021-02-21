package com.facebook.drawee.a.a.a;

import javax.annotation.Nullable;
/* loaded from: classes15.dex */
public class c extends com.facebook.imagepipeline.g.a {
    private String pBg;
    @Nullable
    private final b pBh;

    public c(String str, @Nullable b bVar) {
        this.pBh = bVar;
        init(str);
    }

    public void init(String str) {
        this.pBg = str;
    }

    @Override // com.facebook.imagepipeline.g.a, com.facebook.imagepipeline.producers.am
    public void M(String str, String str2, boolean z) {
        if (this.pBh != null) {
            this.pBh.g(this.pBg, d.ZB(str2), z);
        }
    }
}
