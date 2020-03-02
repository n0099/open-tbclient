package com.facebook.drawee.a.a.a;

import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class c extends com.facebook.imagepipeline.h.a {
    private String lKi;
    @Nullable
    private final b lKj;

    public c(String str, @Nullable b bVar) {
        this.lKj = bVar;
        init(str);
    }

    public void init(String str) {
        this.lKi = str;
    }

    @Override // com.facebook.imagepipeline.h.a, com.facebook.imagepipeline.producers.am
    public void D(String str, String str2, boolean z) {
        if (this.lKj != null) {
            this.lKj.h(this.lKi, d.OW(str2), z);
        }
    }
}
