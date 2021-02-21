package com.facebook.drawee.a.a;

import android.content.res.Resources;
import com.facebook.common.internal.ImmutableList;
import com.facebook.common.internal.j;
import com.facebook.imagepipeline.b.p;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
/* loaded from: classes15.dex */
public class g {
    private Resources mResources;
    private com.facebook.imagepipeline.e.a pAJ;
    @Nullable
    private j<Boolean> pAM;
    private p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pAS;
    private com.facebook.drawee.components.a pBc;
    private Executor pBd;
    @Nullable
    private ImmutableList<com.facebook.imagepipeline.e.a> pBe;

    public void a(Resources resources, com.facebook.drawee.components.a aVar, com.facebook.imagepipeline.e.a aVar2, Executor executor, p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pVar, @Nullable ImmutableList<com.facebook.imagepipeline.e.a> immutableList, @Nullable j<Boolean> jVar) {
        this.mResources = resources;
        this.pBc = aVar;
        this.pAJ = aVar2;
        this.pBd = executor;
        this.pAS = pVar;
        this.pBe = immutableList;
        this.pAM = jVar;
    }

    public d etK() {
        d a2 = a(this.mResources, this.pBc, this.pAJ, this.pBd, this.pAS, this.pBe);
        if (this.pAM != null) {
            a2.Bg(this.pAM.get().booleanValue());
        }
        return a2;
    }

    protected d a(Resources resources, com.facebook.drawee.components.a aVar, com.facebook.imagepipeline.e.a aVar2, Executor executor, p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pVar, @Nullable ImmutableList<com.facebook.imagepipeline.e.a> immutableList) {
        return new d(resources, aVar, aVar2, executor, pVar, immutableList);
    }
}
