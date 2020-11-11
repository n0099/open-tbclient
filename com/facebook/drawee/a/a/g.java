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
    private com.facebook.imagepipeline.f.a oMA;
    @Nullable
    private j<Boolean> oMD;
    private p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> oMK;
    private com.facebook.drawee.components.a oMU;
    private Executor oMV;
    @Nullable
    private ImmutableList<com.facebook.imagepipeline.f.a> oMW;

    public void a(Resources resources, com.facebook.drawee.components.a aVar, com.facebook.imagepipeline.f.a aVar2, Executor executor, p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, @Nullable ImmutableList<com.facebook.imagepipeline.f.a> immutableList, @Nullable j<Boolean> jVar) {
        this.mResources = resources;
        this.oMU = aVar;
        this.oMA = aVar2;
        this.oMV = executor;
        this.oMK = pVar;
        this.oMW = immutableList;
        this.oMD = jVar;
    }

    public d elg() {
        d a2 = a(this.mResources, this.oMU, this.oMA, this.oMV, this.oMK, this.oMW);
        if (this.oMD != null) {
            a2.zY(this.oMD.get().booleanValue());
        }
        return a2;
    }

    protected d a(Resources resources, com.facebook.drawee.components.a aVar, com.facebook.imagepipeline.f.a aVar2, Executor executor, p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, @Nullable ImmutableList<com.facebook.imagepipeline.f.a> immutableList) {
        return new d(resources, aVar, aVar2, executor, pVar, immutableList);
    }
}
