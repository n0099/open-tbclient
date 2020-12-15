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
    private com.facebook.drawee.components.a pdH;
    private Executor pdI;
    @Nullable
    private ImmutableList<com.facebook.imagepipeline.e.a> pdJ;
    private com.facebook.imagepipeline.e.a pdo;
    @Nullable
    private j<Boolean> pdr;
    private p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pdx;

    public void a(Resources resources, com.facebook.drawee.components.a aVar, com.facebook.imagepipeline.e.a aVar2, Executor executor, p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pVar, @Nullable ImmutableList<com.facebook.imagepipeline.e.a> immutableList, @Nullable j<Boolean> jVar) {
        this.mResources = resources;
        this.pdH = aVar;
        this.pdo = aVar2;
        this.pdI = executor;
        this.pdx = pVar;
        this.pdJ = immutableList;
        this.pdr = jVar;
    }

    public d eqU() {
        d a2 = a(this.mResources, this.pdH, this.pdo, this.pdI, this.pdx, this.pdJ);
        if (this.pdr != null) {
            a2.AJ(this.pdr.get().booleanValue());
        }
        return a2;
    }

    protected d a(Resources resources, com.facebook.drawee.components.a aVar, com.facebook.imagepipeline.e.a aVar2, Executor executor, p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pVar, @Nullable ImmutableList<com.facebook.imagepipeline.e.a> immutableList) {
        return new d(resources, aVar, aVar2, executor, pVar, immutableList);
    }
}
