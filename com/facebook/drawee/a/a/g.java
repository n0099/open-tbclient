package com.facebook.drawee.a.a;

import android.content.res.Resources;
import com.facebook.common.internal.ImmutableList;
import com.facebook.common.internal.j;
import com.facebook.imagepipeline.c.p;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class g {
    private com.facebook.imagepipeline.f.a lSZ;
    @Nullable
    private j<Boolean> lTc;
    private p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> lTj;
    private com.facebook.drawee.components.a lTt;
    private Executor lTu;
    @Nullable
    private ImmutableList<com.facebook.imagepipeline.f.a> lTv;
    private Resources mResources;

    public void a(Resources resources, com.facebook.drawee.components.a aVar, com.facebook.imagepipeline.f.a aVar2, Executor executor, p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, @Nullable ImmutableList<com.facebook.imagepipeline.f.a> immutableList, @Nullable j<Boolean> jVar) {
        this.mResources = resources;
        this.lTt = aVar;
        this.lSZ = aVar2;
        this.lTu = executor;
        this.lTj = pVar;
        this.lTv = immutableList;
        this.lTc = jVar;
    }

    public d doa() {
        d a = a(this.mResources, this.lTt, this.lSZ, this.lTu, this.lTj, this.lTv);
        if (this.lTc != null) {
            a.vv(this.lTc.get().booleanValue());
        }
        return a;
    }

    protected d a(Resources resources, com.facebook.drawee.components.a aVar, com.facebook.imagepipeline.f.a aVar2, Executor executor, p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, @Nullable ImmutableList<com.facebook.imagepipeline.f.a> immutableList) {
        return new d(resources, aVar, aVar2, executor, pVar, immutableList);
    }
}
