package com.facebook.drawee.a.a.a;

import javax.annotation.Nullable;
/* loaded from: classes6.dex */
public class c extends com.facebook.imagepipeline.g.a {
    private String puY;
    @Nullable
    private final b puZ;

    public c(String str, @Nullable b bVar) {
        this.puZ = bVar;
        init(str);
    }

    public void init(String str) {
        this.puY = str;
    }

    @Override // com.facebook.imagepipeline.g.a, com.facebook.imagepipeline.producers.am
    public void M(String str, String str2, boolean z) {
        if (this.puZ != null) {
            this.puZ.g(this.puY, d.Zv(str2), z);
        }
    }
}
