package com.facebook.drawee.a.a;

import android.content.res.Resources;
import com.facebook.common.internal.ImmutableList;
import com.facebook.common.internal.j;
import com.facebook.imagepipeline.c.p;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class g {
    private com.facebook.imagepipeline.f.a mKb;
    @Nullable
    private j<Boolean> mKe;
    private p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> mKl;
    private com.facebook.drawee.components.a mKv;
    private Executor mKw;
    @Nullable
    private ImmutableList<com.facebook.imagepipeline.f.a> mKx;
    private Resources mResources;

    public void a(Resources resources, com.facebook.drawee.components.a aVar, com.facebook.imagepipeline.f.a aVar2, Executor executor, p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, @Nullable ImmutableList<com.facebook.imagepipeline.f.a> immutableList, @Nullable j<Boolean> jVar) {
        this.mResources = resources;
        this.mKv = aVar;
        this.mKb = aVar2;
        this.mKw = executor;
        this.mKl = pVar;
        this.mKx = immutableList;
        this.mKe = jVar;
    }

    public d dAk() {
        d a = a(this.mResources, this.mKv, this.mKb, this.mKw, this.mKl, this.mKx);
        if (this.mKe != null) {
            a.wr(this.mKe.get().booleanValue());
        }
        return a;
    }

    protected d a(Resources resources, com.facebook.drawee.components.a aVar, com.facebook.imagepipeline.f.a aVar2, Executor executor, p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, @Nullable ImmutableList<com.facebook.imagepipeline.f.a> immutableList) {
        return new d(resources, aVar, aVar2, executor, pVar, immutableList);
    }
}
