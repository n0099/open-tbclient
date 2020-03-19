package com.facebook.drawee.a.a.a;

import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class c extends com.facebook.imagepipeline.h.a {
    private String lLZ;
    @Nullable
    private final b lMa;

    public c(String str, @Nullable b bVar) {
        this.lMa = bVar;
        init(str);
    }

    public void init(String str) {
        this.lLZ = str;
    }

    @Override // com.facebook.imagepipeline.h.a, com.facebook.imagepipeline.producers.am
    public void D(String str, String str2, boolean z) {
        if (this.lMa != null) {
            this.lMa.g(this.lLZ, d.OX(str2), z);
        }
    }
}
