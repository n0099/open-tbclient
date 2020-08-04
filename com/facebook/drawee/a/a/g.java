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
    private com.facebook.drawee.components.a mSF;
    private Executor mSG;
    @Nullable
    private ImmutableList<com.facebook.imagepipeline.f.a> mSH;
    private com.facebook.imagepipeline.f.a mSj;
    @Nullable
    private j<Boolean> mSm;
    private p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> mSu;

    public void a(Resources resources, com.facebook.drawee.components.a aVar, com.facebook.imagepipeline.f.a aVar2, Executor executor, p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, @Nullable ImmutableList<com.facebook.imagepipeline.f.a> immutableList, @Nullable j<Boolean> jVar) {
        this.mResources = resources;
        this.mSF = aVar;
        this.mSj = aVar2;
        this.mSG = executor;
        this.mSu = pVar;
        this.mSH = immutableList;
        this.mSm = jVar;
    }

    public d dDB() {
        d a = a(this.mResources, this.mSF, this.mSj, this.mSG, this.mSu, this.mSH);
        if (this.mSm != null) {
            a.wW(this.mSm.get().booleanValue());
        }
        return a;
    }

    protected d a(Resources resources, com.facebook.drawee.components.a aVar, com.facebook.imagepipeline.f.a aVar2, Executor executor, p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, @Nullable ImmutableList<com.facebook.imagepipeline.f.a> immutableList) {
        return new d(resources, aVar, aVar2, executor, pVar, immutableList);
    }
}
