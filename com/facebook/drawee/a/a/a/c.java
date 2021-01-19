package com.facebook.drawee.a.a.a;

import javax.annotation.Nullable;
/* loaded from: classes6.dex */
public class c extends com.facebook.imagepipeline.g.a {
    private String pqx;
    @Nullable
    private final b pqy;

    public c(String str, @Nullable b bVar) {
        this.pqy = bVar;
        init(str);
    }

    public void init(String str) {
        this.pqx = str;
    }

    @Override // com.facebook.imagepipeline.g.a, com.facebook.imagepipeline.producers.am
    public void M(String str, String str2, boolean z) {
        if (this.pqy != null) {
            this.pqy.g(this.pqx, d.Yo(str2), z);
        }
    }
}
