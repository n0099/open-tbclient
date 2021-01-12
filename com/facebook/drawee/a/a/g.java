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
    private com.facebook.imagepipeline.e.a ppZ;
    @Nullable
    private j<Boolean> pqc;
    private p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pqi;
    private com.facebook.drawee.components.a pqs;
    private Executor pqt;
    @Nullable
    private ImmutableList<com.facebook.imagepipeline.e.a> pqu;

    public void a(Resources resources, com.facebook.drawee.components.a aVar, com.facebook.imagepipeline.e.a aVar2, Executor executor, p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pVar, @Nullable ImmutableList<com.facebook.imagepipeline.e.a> immutableList, @Nullable j<Boolean> jVar) {
        this.mResources = resources;
        this.pqs = aVar;
        this.ppZ = aVar2;
        this.pqt = executor;
        this.pqi = pVar;
        this.pqu = immutableList;
        this.pqc = jVar;
    }

    public d erj() {
        d a2 = a(this.mResources, this.pqs, this.ppZ, this.pqt, this.pqi, this.pqu);
        if (this.pqc != null) {
            a2.AN(this.pqc.get().booleanValue());
        }
        return a2;
    }

    protected d a(Resources resources, com.facebook.drawee.components.a aVar, com.facebook.imagepipeline.e.a aVar2, Executor executor, p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pVar, @Nullable ImmutableList<com.facebook.imagepipeline.e.a> immutableList) {
        return new d(resources, aVar, aVar2, executor, pVar, immutableList);
    }
}
