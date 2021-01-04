package com.facebook.drawee.a.a.a;

import javax.annotation.Nullable;
/* loaded from: classes6.dex */
public class c extends com.facebook.imagepipeline.g.a {
    private String puR;
    @Nullable
    private final b puS;

    public c(String str, @Nullable b bVar) {
        this.puS = bVar;
        init(str);
    }

    public void init(String str) {
        this.puR = str;
    }

    @Override // com.facebook.imagepipeline.g.a, com.facebook.imagepipeline.producers.am
    public void M(String str, String str2, boolean z) {
        if (this.puS != null) {
            this.puS.g(this.puR, d.Zw(str2), z);
        }
    }
}
