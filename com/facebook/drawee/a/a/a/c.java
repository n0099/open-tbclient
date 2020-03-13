package com.facebook.drawee.a.a.a;

import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class c extends com.facebook.imagepipeline.h.a {
    private String lKt;
    @Nullable
    private final b lKu;

    public c(String str, @Nullable b bVar) {
        this.lKu = bVar;
        init(str);
    }

    public void init(String str) {
        this.lKt = str;
    }

    @Override // com.facebook.imagepipeline.h.a, com.facebook.imagepipeline.producers.am
    public void D(String str, String str2, boolean z) {
        if (this.lKu != null) {
            this.lKu.h(this.lKt, d.OX(str2), z);
        }
    }
}
