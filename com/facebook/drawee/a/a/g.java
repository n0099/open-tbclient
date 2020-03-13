package com.facebook.drawee.a.a;

import android.content.res.Resources;
import com.facebook.common.internal.ImmutableList;
import com.facebook.common.internal.j;
import com.facebook.imagepipeline.c.p;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class g {
    private com.facebook.imagepipeline.f.a lJU;
    @Nullable
    private j<Boolean> lJX;
    private p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> lKf;
    private com.facebook.drawee.components.a lKp;
    private Executor lKq;
    @Nullable
    private ImmutableList<com.facebook.imagepipeline.f.a> lKr;
    private Resources mResources;

    public void a(Resources resources, com.facebook.drawee.components.a aVar, com.facebook.imagepipeline.f.a aVar2, Executor executor, p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, @Nullable ImmutableList<com.facebook.imagepipeline.f.a> immutableList, @Nullable j<Boolean> jVar) {
        this.mResources = resources;
        this.lKp = aVar;
        this.lJU = aVar2;
        this.lKq = executor;
        this.lKf = pVar;
        this.lKr = immutableList;
        this.lJX = jVar;
    }

    public d dlN() {
        d a = a(this.mResources, this.lKp, this.lJU, this.lKq, this.lKf, this.lKr);
        if (this.lJX != null) {
            a.va(this.lJX.get().booleanValue());
        }
        return a;
    }

    protected d a(Resources resources, com.facebook.drawee.components.a aVar, com.facebook.imagepipeline.f.a aVar2, Executor executor, p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, @Nullable ImmutableList<com.facebook.imagepipeline.f.a> immutableList) {
        return new d(resources, aVar, aVar2, executor, pVar, immutableList);
    }
}
