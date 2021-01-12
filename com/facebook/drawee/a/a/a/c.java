package com.facebook.drawee.a.a.a;

import javax.annotation.Nullable;
/* loaded from: classes6.dex */
public class c extends com.facebook.imagepipeline.g.a {
    private String pqw;
    @Nullable
    private final b pqx;

    public c(String str, @Nullable b bVar) {
        this.pqx = bVar;
        init(str);
    }

    public void init(String str) {
        this.pqw = str;
    }

    @Override // com.facebook.imagepipeline.g.a, com.facebook.imagepipeline.producers.am
    public void M(String str, String str2, boolean z) {
        if (this.pqx != null) {
            this.pqx.g(this.pqw, d.Yn(str2), z);
        }
    }
}
