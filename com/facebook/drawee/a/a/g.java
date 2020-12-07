package com.facebook.drawee.a.a;

import android.content.res.Resources;
import com.facebook.common.internal.ImmutableList;
import com.facebook.common.internal.j;
import com.facebook.imagepipeline.b.p;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
/* loaded from: classes9.dex */
public class g {
    private Resources mResources;
    private com.facebook.drawee.components.a pdF;
    private Executor pdG;
    @Nullable
    private ImmutableList<com.facebook.imagepipeline.e.a> pdH;
    private com.facebook.imagepipeline.e.a pdm;
    @Nullable
    private j<Boolean> pdp;
    private p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pdv;

    public void a(Resources resources, com.facebook.drawee.components.a aVar, com.facebook.imagepipeline.e.a aVar2, Executor executor, p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pVar, @Nullable ImmutableList<com.facebook.imagepipeline.e.a> immutableList, @Nullable j<Boolean> jVar) {
        this.mResources = resources;
        this.pdF = aVar;
        this.pdm = aVar2;
        this.pdG = executor;
        this.pdv = pVar;
        this.pdH = immutableList;
        this.pdp = jVar;
    }

    public d eqT() {
        d a2 = a(this.mResources, this.pdF, this.pdm, this.pdG, this.pdv, this.pdH);
        if (this.pdp != null) {
            a2.AJ(this.pdp.get().booleanValue());
        }
        return a2;
    }

    protected d a(Resources resources, com.facebook.drawee.components.a aVar, com.facebook.imagepipeline.e.a aVar2, Executor executor, p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pVar, @Nullable ImmutableList<com.facebook.imagepipeline.e.a> immutableList) {
        return new d(resources, aVar, aVar2, executor, pVar, immutableList);
    }
}
