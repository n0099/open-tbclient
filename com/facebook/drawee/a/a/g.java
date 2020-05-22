package com.facebook.drawee.a.a;

import android.content.res.Resources;
import com.facebook.common.internal.ImmutableList;
import com.facebook.common.internal.j;
import com.facebook.imagepipeline.c.p;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class g {
    private Resources mResources;
    private com.facebook.imagepipeline.f.a mmR;
    @Nullable
    private j<Boolean> mmU;
    private p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> mnb;
    private com.facebook.drawee.components.a mnl;
    private Executor mnm;
    @Nullable
    private ImmutableList<com.facebook.imagepipeline.f.a> mnn;

    public void a(Resources resources, com.facebook.drawee.components.a aVar, com.facebook.imagepipeline.f.a aVar2, Executor executor, p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, @Nullable ImmutableList<com.facebook.imagepipeline.f.a> immutableList, @Nullable j<Boolean> jVar) {
        this.mResources = resources;
        this.mnl = aVar;
        this.mmR = aVar2;
        this.mnm = executor;
        this.mnb = pVar;
        this.mnn = immutableList;
        this.mmU = jVar;
    }

    public d dvt() {
        d a = a(this.mResources, this.mnl, this.mmR, this.mnm, this.mnb, this.mnn);
        if (this.mmU != null) {
            a.vT(this.mmU.get().booleanValue());
        }
        return a;
    }

    protected d a(Resources resources, com.facebook.drawee.components.a aVar, com.facebook.imagepipeline.f.a aVar2, Executor executor, p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, @Nullable ImmutableList<com.facebook.imagepipeline.f.a> immutableList) {
        return new d(resources, aVar, aVar2, executor, pVar, immutableList);
    }
}
