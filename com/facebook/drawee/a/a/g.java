package com.facebook.drawee.a.a;

import android.content.res.Resources;
import com.facebook.common.internal.ImmutableList;
import com.facebook.common.internal.j;
import com.facebook.imagepipeline.c.p;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class g {
    private com.facebook.imagepipeline.f.a lJa;
    @Nullable
    private j<Boolean> lJd;
    private p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> lJl;
    private com.facebook.drawee.components.a lJv;
    private Executor lJw;
    @Nullable
    private ImmutableList<com.facebook.imagepipeline.f.a> lJx;
    private Resources mResources;

    public void a(Resources resources, com.facebook.drawee.components.a aVar, com.facebook.imagepipeline.f.a aVar2, Executor executor, p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, @Nullable ImmutableList<com.facebook.imagepipeline.f.a> immutableList, @Nullable j<Boolean> jVar) {
        this.mResources = resources;
        this.lJv = aVar;
        this.lJa = aVar2;
        this.lJw = executor;
        this.lJl = pVar;
        this.lJx = immutableList;
        this.lJd = jVar;
    }

    public d dkx() {
        d a = a(this.mResources, this.lJv, this.lJa, this.lJw, this.lJl, this.lJx);
        if (this.lJd != null) {
            a.uW(this.lJd.get().booleanValue());
        }
        return a;
    }

    protected d a(Resources resources, com.facebook.drawee.components.a aVar, com.facebook.imagepipeline.f.a aVar2, Executor executor, p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, @Nullable ImmutableList<com.facebook.imagepipeline.f.a> immutableList) {
        return new d(resources, aVar, aVar2, executor, pVar, immutableList);
    }
}
