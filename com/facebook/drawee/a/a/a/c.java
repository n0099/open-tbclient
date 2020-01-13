package com.facebook.drawee.a.a.a;

import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class c extends com.facebook.imagepipeline.h.a {
    private String lJu;
    @Nullable
    private final b lJv;

    public c(String str, @Nullable b bVar) {
        this.lJv = bVar;
        init(str);
    }

    public void init(String str) {
        this.lJu = str;
    }

    @Override // com.facebook.imagepipeline.h.a, com.facebook.imagepipeline.producers.am
    public void C(String str, String str2, boolean z) {
        if (this.lJv != null) {
            this.lJv.h(this.lJu, d.OJ(str2), z);
        }
    }
}
