package com.facebook.drawee.a.a;

import android.content.res.Resources;
import com.facebook.common.internal.ImmutableList;
import com.facebook.common.internal.j;
import com.facebook.imagepipeline.c.p;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class g {
    private com.facebook.imagepipeline.f.a lSV;
    @Nullable
    private j<Boolean> lSY;
    private p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> lTf;
    private com.facebook.drawee.components.a lTp;
    private Executor lTq;
    @Nullable
    private ImmutableList<com.facebook.imagepipeline.f.a> lTr;
    private Resources mResources;

    public void a(Resources resources, com.facebook.drawee.components.a aVar, com.facebook.imagepipeline.f.a aVar2, Executor executor, p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, @Nullable ImmutableList<com.facebook.imagepipeline.f.a> immutableList, @Nullable j<Boolean> jVar) {
        this.mResources = resources;
        this.lTp = aVar;
        this.lSV = aVar2;
        this.lTq = executor;
        this.lTf = pVar;
        this.lTr = immutableList;
        this.lSY = jVar;
    }

    public d dod() {
        d a = a(this.mResources, this.lTp, this.lSV, this.lTq, this.lTf, this.lTr);
        if (this.lSY != null) {
            a.vv(this.lSY.get().booleanValue());
        }
        return a;
    }

    protected d a(Resources resources, com.facebook.drawee.components.a aVar, com.facebook.imagepipeline.f.a aVar2, Executor executor, p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, @Nullable ImmutableList<com.facebook.imagepipeline.f.a> immutableList) {
        return new d(resources, aVar, aVar2, executor, pVar, immutableList);
    }
}
