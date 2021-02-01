package com.facebook.drawee.a.a;

import android.content.res.Resources;
import com.facebook.common.internal.ImmutableList;
import com.facebook.common.internal.j;
import com.facebook.imagepipeline.b.p;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
/* loaded from: classes15.dex */
public class g {
    private Resources mResources;
    private com.facebook.drawee.components.a pAC;
    private Executor pAD;
    @Nullable
    private ImmutableList<com.facebook.imagepipeline.e.a> pAE;
    private com.facebook.imagepipeline.e.a pAj;
    @Nullable
    private j<Boolean> pAm;
    private p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pAs;

    public void a(Resources resources, com.facebook.drawee.components.a aVar, com.facebook.imagepipeline.e.a aVar2, Executor executor, p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pVar, @Nullable ImmutableList<com.facebook.imagepipeline.e.a> immutableList, @Nullable j<Boolean> jVar) {
        this.mResources = resources;
        this.pAC = aVar;
        this.pAj = aVar2;
        this.pAD = executor;
        this.pAs = pVar;
        this.pAE = immutableList;
        this.pAm = jVar;
    }

    public d etC() {
        d a2 = a(this.mResources, this.pAC, this.pAj, this.pAD, this.pAs, this.pAE);
        if (this.pAm != null) {
            a2.Bg(this.pAm.get().booleanValue());
        }
        return a2;
    }

    protected d a(Resources resources, com.facebook.drawee.components.a aVar, com.facebook.imagepipeline.e.a aVar2, Executor executor, p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pVar, @Nullable ImmutableList<com.facebook.imagepipeline.e.a> immutableList) {
        return new d(resources, aVar, aVar2, executor, pVar, immutableList);
    }
}
