package com.facebook.drawee.a.a;

import android.content.res.Resources;
import com.facebook.common.internal.ImmutableList;
import com.facebook.common.internal.j;
import com.facebook.imagepipeline.c.p;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class g {
    @Nullable
    private ImmutableList<com.facebook.imagepipeline.f.a> mKA;
    private com.facebook.imagepipeline.f.a mKe;
    @Nullable
    private j<Boolean> mKh;
    private p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> mKo;
    private com.facebook.drawee.components.a mKy;
    private Executor mKz;
    private Resources mResources;

    public void a(Resources resources, com.facebook.drawee.components.a aVar, com.facebook.imagepipeline.f.a aVar2, Executor executor, p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, @Nullable ImmutableList<com.facebook.imagepipeline.f.a> immutableList, @Nullable j<Boolean> jVar) {
        this.mResources = resources;
        this.mKy = aVar;
        this.mKe = aVar2;
        this.mKz = executor;
        this.mKo = pVar;
        this.mKA = immutableList;
        this.mKh = jVar;
    }

    public d dAo() {
        d a = a(this.mResources, this.mKy, this.mKe, this.mKz, this.mKo, this.mKA);
        if (this.mKh != null) {
            a.wr(this.mKh.get().booleanValue());
        }
        return a;
    }

    protected d a(Resources resources, com.facebook.drawee.components.a aVar, com.facebook.imagepipeline.f.a aVar2, Executor executor, p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, @Nullable ImmutableList<com.facebook.imagepipeline.f.a> immutableList) {
        return new d(resources, aVar, aVar2, executor, pVar, immutableList);
    }
}
