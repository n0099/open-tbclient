package com.facebook.drawee.a.a.a;

import javax.annotation.Nullable;
/* loaded from: classes10.dex */
public class c extends com.facebook.imagepipeline.h.a {
    private String oOC;
    @Nullable
    private final b oOD;

    public c(String str, @Nullable b bVar) {
        this.oOD = bVar;
        init(str);
    }

    public void init(String str) {
        this.oOC = str;
    }

    @Override // com.facebook.imagepipeline.h.a, com.facebook.imagepipeline.producers.am
    public void I(String str, String str2, boolean z) {
        if (this.oOD != null) {
            this.oOD.g(this.oOC, d.XQ(str2), z);
        }
    }
}
