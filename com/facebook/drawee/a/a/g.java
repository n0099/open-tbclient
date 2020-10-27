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
    private com.facebook.drawee.components.a oDB;
    private Executor oDC;
    @Nullable
    private ImmutableList<com.facebook.imagepipeline.f.a> oDD;
    private com.facebook.imagepipeline.f.a oDh;
    @Nullable
    private j<Boolean> oDk;
    private p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> oDr;

    public void a(Resources resources, com.facebook.drawee.components.a aVar, com.facebook.imagepipeline.f.a aVar2, Executor executor, p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, @Nullable ImmutableList<com.facebook.imagepipeline.f.a> immutableList, @Nullable j<Boolean> jVar) {
        this.mResources = resources;
        this.oDB = aVar;
        this.oDh = aVar2;
        this.oDC = executor;
        this.oDr = pVar;
        this.oDD = immutableList;
        this.oDk = jVar;
    }

    public d ehr() {
        d a2 = a(this.mResources, this.oDB, this.oDh, this.oDC, this.oDr, this.oDD);
        if (this.oDk != null) {
            a2.zN(this.oDk.get().booleanValue());
        }
        return a2;
    }

    protected d a(Resources resources, com.facebook.drawee.components.a aVar, com.facebook.imagepipeline.f.a aVar2, Executor executor, p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, @Nullable ImmutableList<com.facebook.imagepipeline.f.a> immutableList) {
        return new d(resources, aVar, aVar2, executor, pVar, immutableList);
    }
}
