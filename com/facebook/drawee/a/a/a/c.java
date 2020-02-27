package com.facebook.drawee.a.a.a;

import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class c extends com.facebook.imagepipeline.h.a {
    private String lKg;
    @Nullable
    private final b lKh;

    public c(String str, @Nullable b bVar) {
        this.lKh = bVar;
        init(str);
    }

    public void init(String str) {
        this.lKg = str;
    }

    @Override // com.facebook.imagepipeline.h.a, com.facebook.imagepipeline.producers.am
    public void D(String str, String str2, boolean z) {
        if (this.lKh != null) {
            this.lKh.h(this.lKg, d.OW(str2), z);
        }
    }
}
