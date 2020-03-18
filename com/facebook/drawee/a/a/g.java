package com.facebook.drawee.a.a;

import android.content.res.Resources;
import com.facebook.common.internal.ImmutableList;
import com.facebook.common.internal.j;
import com.facebook.imagepipeline.c.p;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class g {
    private com.facebook.imagepipeline.f.a lLA;
    @Nullable
    private j<Boolean> lLD;
    private p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> lLL;
    private com.facebook.drawee.components.a lLV;
    private Executor lLW;
    @Nullable
    private ImmutableList<com.facebook.imagepipeline.f.a> lLX;
    private Resources mResources;

    public void a(Resources resources, com.facebook.drawee.components.a aVar, com.facebook.imagepipeline.f.a aVar2, Executor executor, p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, @Nullable ImmutableList<com.facebook.imagepipeline.f.a> immutableList, @Nullable j<Boolean> jVar) {
        this.mResources = resources;
        this.lLV = aVar;
        this.lLA = aVar2;
        this.lLW = executor;
        this.lLL = pVar;
        this.lLX = immutableList;
        this.lLD = jVar;
    }

    public d dmk() {
        d a = a(this.mResources, this.lLV, this.lLA, this.lLW, this.lLL, this.lLX);
        if (this.lLD != null) {
            a.vh(this.lLD.get().booleanValue());
        }
        return a;
    }

    protected d a(Resources resources, com.facebook.drawee.components.a aVar, com.facebook.imagepipeline.f.a aVar2, Executor executor, p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, @Nullable ImmutableList<com.facebook.imagepipeline.f.a> immutableList) {
        return new d(resources, aVar, aVar2, executor, pVar, immutableList);
    }
}
