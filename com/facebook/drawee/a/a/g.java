package com.facebook.drawee.a.a;

import android.content.res.Resources;
import com.facebook.common.internal.ImmutableList;
import com.facebook.common.internal.j;
import com.facebook.imagepipeline.b.p;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
/* loaded from: classes14.dex */
public class g {
    private Resources mResources;
    private com.facebook.imagepipeline.e.a pCO;
    @Nullable
    private j<Boolean> pCR;
    private p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pCX;
    private com.facebook.drawee.components.a pDh;
    private Executor pDi;
    @Nullable
    private ImmutableList<com.facebook.imagepipeline.e.a> pDj;

    public void a(Resources resources, com.facebook.drawee.components.a aVar, com.facebook.imagepipeline.e.a aVar2, Executor executor, p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pVar, @Nullable ImmutableList<com.facebook.imagepipeline.e.a> immutableList, @Nullable j<Boolean> jVar) {
        this.mResources = resources;
        this.pDh = aVar;
        this.pCO = aVar2;
        this.pDi = executor;
        this.pCX = pVar;
        this.pDj = immutableList;
        this.pCR = jVar;
    }

    public d etT() {
        d a2 = a(this.mResources, this.pDh, this.pCO, this.pDi, this.pCX, this.pDj);
        if (this.pCR != null) {
            a2.Be(this.pCR.get().booleanValue());
        }
        return a2;
    }

    protected d a(Resources resources, com.facebook.drawee.components.a aVar, com.facebook.imagepipeline.e.a aVar2, Executor executor, p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pVar, @Nullable ImmutableList<com.facebook.imagepipeline.e.a> immutableList) {
        return new d(resources, aVar, aVar2, executor, pVar, immutableList);
    }
}
