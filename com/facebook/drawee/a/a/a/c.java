package com.facebook.drawee.a.a.a;

import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class c extends com.facebook.imagepipeline.h.a {
    private String mnp;
    @Nullable
    private final b mnq;

    public c(String str, @Nullable b bVar) {
        this.mnq = bVar;
        init(str);
    }

    public void init(String str) {
        this.mnp = str;
    }

    @Override // com.facebook.imagepipeline.h.a, com.facebook.imagepipeline.producers.am
    public void F(String str, String str2, boolean z) {
        if (this.mnq != null) {
            this.mnq.g(this.mnp, d.PV(str2), z);
        }
    }
}
