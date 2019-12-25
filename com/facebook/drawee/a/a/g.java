package com.facebook.drawee.a.a;

import android.content.res.Resources;
import com.facebook.common.internal.ImmutableList;
import com.facebook.common.internal.j;
import com.facebook.imagepipeline.c.p;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
/* loaded from: classes11.dex */
public class g {
    @Nullable
    private j<Boolean> lFA;
    private p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> lFI;
    private com.facebook.drawee.components.a lFS;
    private Executor lFT;
    @Nullable
    private ImmutableList<com.facebook.imagepipeline.f.a> lFU;
    private com.facebook.imagepipeline.f.a lFx;
    private Resources mResources;

    public void a(Resources resources, com.facebook.drawee.components.a aVar, com.facebook.imagepipeline.f.a aVar2, Executor executor, p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, @Nullable ImmutableList<com.facebook.imagepipeline.f.a> immutableList, @Nullable j<Boolean> jVar) {
        this.mResources = resources;
        this.lFS = aVar;
        this.lFx = aVar2;
        this.lFT = executor;
        this.lFI = pVar;
        this.lFU = immutableList;
        this.lFA = jVar;
    }

    public d dju() {
        d a = a(this.mResources, this.lFS, this.lFx, this.lFT, this.lFI, this.lFU);
        if (this.lFA != null) {
            a.uL(this.lFA.get().booleanValue());
        }
        return a;
    }

    protected d a(Resources resources, com.facebook.drawee.components.a aVar, com.facebook.imagepipeline.f.a aVar2, Executor executor, p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, @Nullable ImmutableList<com.facebook.imagepipeline.f.a> immutableList) {
        return new d(resources, aVar, aVar2, executor, pVar, immutableList);
    }
}
