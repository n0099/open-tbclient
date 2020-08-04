package com.facebook.drawee.a.a.a;

import javax.annotation.Nullable;
/* loaded from: classes4.dex */
public class c extends com.facebook.imagepipeline.h.a {
    private String mSJ;
    @Nullable
    private final b mSK;

    public c(String str, @Nullable b bVar) {
        this.mSK = bVar;
        init(str);
    }

    public void init(String str) {
        this.mSJ = str;
    }

    @Override // com.facebook.imagepipeline.h.a, com.facebook.imagepipeline.producers.am
    public void G(String str, String str2, boolean z) {
        if (this.mSK != null) {
            this.mSK.g(this.mSJ, d.Ru(str2), z);
        }
    }
}
