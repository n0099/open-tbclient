package com.facebook.drawee.a.a;

import android.content.res.Resources;
import com.facebook.common.internal.ImmutableList;
import com.facebook.common.internal.j;
import com.facebook.imagepipeline.c.p;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class g {
    private com.facebook.imagepipeline.f.a lJJ;
    @Nullable
    private j<Boolean> lJM;
    private p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> lJU;
    private com.facebook.drawee.components.a lKe;
    private Executor lKf;
    @Nullable
    private ImmutableList<com.facebook.imagepipeline.f.a> lKg;
    private Resources mResources;

    public void a(Resources resources, com.facebook.drawee.components.a aVar, com.facebook.imagepipeline.f.a aVar2, Executor executor, p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, @Nullable ImmutableList<com.facebook.imagepipeline.f.a> immutableList, @Nullable j<Boolean> jVar) {
        this.mResources = resources;
        this.lKe = aVar;
        this.lJJ = aVar2;
        this.lKf = executor;
        this.lJU = pVar;
        this.lKg = immutableList;
        this.lJM = jVar;
    }

    public d dlM() {
        d a = a(this.mResources, this.lKe, this.lJJ, this.lKf, this.lJU, this.lKg);
        if (this.lJM != null) {
            a.va(this.lJM.get().booleanValue());
        }
        return a;
    }

    protected d a(Resources resources, com.facebook.drawee.components.a aVar, com.facebook.imagepipeline.f.a aVar2, Executor executor, p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, @Nullable ImmutableList<com.facebook.imagepipeline.f.a> immutableList) {
        return new d(resources, aVar, aVar2, executor, pVar, immutableList);
    }
}
