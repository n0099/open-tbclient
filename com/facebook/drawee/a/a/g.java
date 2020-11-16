package com.facebook.drawee.a.a;

import android.content.res.Resources;
import com.facebook.common.internal.ImmutableList;
import com.facebook.common.internal.j;
import com.facebook.imagepipeline.c.p;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
/* loaded from: classes10.dex */
public class g {
    private Resources mResources;
    @Nullable
    private ImmutableList<com.facebook.imagepipeline.f.a> oOA;
    private com.facebook.imagepipeline.f.a oOe;
    @Nullable
    private j<Boolean> oOh;
    private p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> oOo;
    private com.facebook.drawee.components.a oOy;
    private Executor oOz;

    public void a(Resources resources, com.facebook.drawee.components.a aVar, com.facebook.imagepipeline.f.a aVar2, Executor executor, p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, @Nullable ImmutableList<com.facebook.imagepipeline.f.a> immutableList, @Nullable j<Boolean> jVar) {
        this.mResources = resources;
        this.oOy = aVar;
        this.oOe = aVar2;
        this.oOz = executor;
        this.oOo = pVar;
        this.oOA = immutableList;
        this.oOh = jVar;
    }

    public d ele() {
        d a2 = a(this.mResources, this.oOy, this.oOe, this.oOz, this.oOo, this.oOA);
        if (this.oOh != null) {
            a2.Af(this.oOh.get().booleanValue());
        }
        return a2;
    }

    protected d a(Resources resources, com.facebook.drawee.components.a aVar, com.facebook.imagepipeline.f.a aVar2, Executor executor, p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, @Nullable ImmutableList<com.facebook.imagepipeline.f.a> immutableList) {
        return new d(resources, aVar, aVar2, executor, pVar, immutableList);
    }
}
