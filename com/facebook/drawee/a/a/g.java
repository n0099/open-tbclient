package com.facebook.drawee.a.a;

import android.content.res.Resources;
import com.facebook.common.internal.ImmutableList;
import com.facebook.common.internal.j;
import com.facebook.imagepipeline.c.p;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class g {
    private com.facebook.imagepipeline.f.a lIV;
    @Nullable
    private j<Boolean> lIY;
    private p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> lJg;
    private com.facebook.drawee.components.a lJq;
    private Executor lJr;
    @Nullable
    private ImmutableList<com.facebook.imagepipeline.f.a> lJs;
    private Resources mResources;

    public void a(Resources resources, com.facebook.drawee.components.a aVar, com.facebook.imagepipeline.f.a aVar2, Executor executor, p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, @Nullable ImmutableList<com.facebook.imagepipeline.f.a> immutableList, @Nullable j<Boolean> jVar) {
        this.mResources = resources;
        this.lJq = aVar;
        this.lIV = aVar2;
        this.lJr = executor;
        this.lJg = pVar;
        this.lJs = immutableList;
        this.lIY = jVar;
    }

    public d dkv() {
        d a = a(this.mResources, this.lJq, this.lIV, this.lJr, this.lJg, this.lJs);
        if (this.lIY != null) {
            a.uW(this.lIY.get().booleanValue());
        }
        return a;
    }

    protected d a(Resources resources, com.facebook.drawee.components.a aVar, com.facebook.imagepipeline.f.a aVar2, Executor executor, p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, @Nullable ImmutableList<com.facebook.imagepipeline.f.a> immutableList) {
        return new d(resources, aVar, aVar2, executor, pVar, immutableList);
    }
}
