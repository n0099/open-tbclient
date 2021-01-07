package com.facebook.drawee.a.a;

import android.content.res.Resources;
import com.facebook.common.internal.ImmutableList;
import com.facebook.common.internal.j;
import com.facebook.imagepipeline.b.p;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
/* loaded from: classes6.dex */
public class g {
    private Resources mResources;
    private com.facebook.imagepipeline.e.a puB;
    @Nullable
    private j<Boolean> puE;
    private p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> puK;
    private com.facebook.drawee.components.a puU;
    private Executor puV;
    @Nullable
    private ImmutableList<com.facebook.imagepipeline.e.a> puW;

    public void a(Resources resources, com.facebook.drawee.components.a aVar, com.facebook.imagepipeline.e.a aVar2, Executor executor, p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pVar, @Nullable ImmutableList<com.facebook.imagepipeline.e.a> immutableList, @Nullable j<Boolean> jVar) {
        this.mResources = resources;
        this.puU = aVar;
        this.puB = aVar2;
        this.puV = executor;
        this.puK = pVar;
        this.puW = immutableList;
        this.puE = jVar;
    }

    public d evd() {
        d a2 = a(this.mResources, this.puU, this.puB, this.puV, this.puK, this.puW);
        if (this.puE != null) {
            a2.AR(this.puE.get().booleanValue());
        }
        return a2;
    }

    protected d a(Resources resources, com.facebook.drawee.components.a aVar, com.facebook.imagepipeline.e.a aVar2, Executor executor, p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pVar, @Nullable ImmutableList<com.facebook.imagepipeline.e.a> immutableList) {
        return new d(resources, aVar, aVar2, executor, pVar, immutableList);
    }
}
