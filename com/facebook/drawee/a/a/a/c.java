package com.facebook.drawee.a.a.a;

import javax.annotation.Nullable;
/* loaded from: classes4.dex */
public class c extends com.facebook.imagepipeline.h.a {
    private String mSH;
    @Nullable
    private final b mSI;

    public c(String str, @Nullable b bVar) {
        this.mSI = bVar;
        init(str);
    }

    public void init(String str) {
        this.mSH = str;
    }

    @Override // com.facebook.imagepipeline.h.a, com.facebook.imagepipeline.producers.am
    public void G(String str, String str2, boolean z) {
        if (this.mSI != null) {
            this.mSI.g(this.mSH, d.Ru(str2), z);
        }
    }
}
