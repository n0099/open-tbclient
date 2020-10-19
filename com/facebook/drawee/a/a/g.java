package com.facebook.drawee.a.a;

import android.content.res.Resources;
import com.facebook.common.internal.ImmutableList;
import com.facebook.common.internal.j;
import com.facebook.imagepipeline.c.p;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
/* loaded from: classes18.dex */
public class g {
    private Resources mResources;
    private com.facebook.imagepipeline.f.a nLO;
    @Nullable
    private j<Boolean> nLR;
    private p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> nLY;
    private com.facebook.drawee.components.a nMi;
    private Executor nMj;
    @Nullable
    private ImmutableList<com.facebook.imagepipeline.f.a> nMk;

    public void a(Resources resources, com.facebook.drawee.components.a aVar, com.facebook.imagepipeline.f.a aVar2, Executor executor, p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, @Nullable ImmutableList<com.facebook.imagepipeline.f.a> immutableList, @Nullable j<Boolean> jVar) {
        this.mResources = resources;
        this.nMi = aVar;
        this.nLO = aVar2;
        this.nMj = executor;
        this.nLY = pVar;
        this.nMk = immutableList;
        this.nLR = jVar;
    }

    public d dXt() {
        d a2 = a(this.mResources, this.nMi, this.nLO, this.nMj, this.nLY, this.nMk);
        if (this.nLR != null) {
            a2.yF(this.nLR.get().booleanValue());
        }
        return a2;
    }

    protected d a(Resources resources, com.facebook.drawee.components.a aVar, com.facebook.imagepipeline.f.a aVar2, Executor executor, p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, @Nullable ImmutableList<com.facebook.imagepipeline.f.a> immutableList) {
        return new d(resources, aVar, aVar2, executor, pVar, immutableList);
    }
}
