package com.facebook.drawee.a.a.a;

import javax.annotation.Nullable;
/* loaded from: classes15.dex */
public class c extends com.facebook.imagepipeline.h.a {
    private String nwT;
    @Nullable
    private final b nwU;

    public c(String str, @Nullable b bVar) {
        this.nwU = bVar;
        init(str);
    }

    public void init(String str) {
        this.nwT = str;
    }

    @Override // com.facebook.imagepipeline.h.a, com.facebook.imagepipeline.producers.am
    public void F(String str, String str2, boolean z) {
        if (this.nwU != null) {
            this.nwU.g(this.nwT, d.Va(str2), z);
        }
    }
}
