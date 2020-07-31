package com.facebook.drawee.a.a;

import android.content.res.Resources;
import com.facebook.common.internal.ImmutableList;
import com.facebook.common.internal.j;
import com.facebook.imagepipeline.c.p;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
/* loaded from: classes4.dex */
public class g {
    private Resources mResources;
    private com.facebook.drawee.components.a mSD;
    private Executor mSE;
    @Nullable
    private ImmutableList<com.facebook.imagepipeline.f.a> mSF;
    private com.facebook.imagepipeline.f.a mSh;
    @Nullable
    private j<Boolean> mSk;
    private p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> mSs;

    public void a(Resources resources, com.facebook.drawee.components.a aVar, com.facebook.imagepipeline.f.a aVar2, Executor executor, p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, @Nullable ImmutableList<com.facebook.imagepipeline.f.a> immutableList, @Nullable j<Boolean> jVar) {
        this.mResources = resources;
        this.mSD = aVar;
        this.mSh = aVar2;
        this.mSE = executor;
        this.mSs = pVar;
        this.mSF = immutableList;
        this.mSk = jVar;
    }

    public d dDA() {
        d a = a(this.mResources, this.mSD, this.mSh, this.mSE, this.mSs, this.mSF);
        if (this.mSk != null) {
            a.wW(this.mSk.get().booleanValue());
        }
        return a;
    }

    protected d a(Resources resources, com.facebook.drawee.components.a aVar, com.facebook.imagepipeline.f.a aVar2, Executor executor, p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, @Nullable ImmutableList<com.facebook.imagepipeline.f.a> immutableList) {
        return new d(resources, aVar, aVar2, executor, pVar, immutableList);
    }
}
