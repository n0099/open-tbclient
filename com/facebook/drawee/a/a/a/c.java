package com.facebook.drawee.a.a.a;

import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class c extends com.facebook.imagepipeline.h.a {
    private String lTt;
    @Nullable
    private final b lTu;

    public c(String str, @Nullable b bVar) {
        this.lTu = bVar;
        init(str);
    }

    public void init(String str) {
        this.lTt = str;
    }

    @Override // com.facebook.imagepipeline.h.a, com.facebook.imagepipeline.producers.am
    public void D(String str, String str2, boolean z) {
        if (this.lTu != null) {
            this.lTu.g(this.lTt, d.Oe(str2), z);
        }
    }
}
