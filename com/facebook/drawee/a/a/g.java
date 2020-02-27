package com.facebook.drawee.a.a;

import android.content.res.Resources;
import com.facebook.common.internal.ImmutableList;
import com.facebook.common.internal.j;
import com.facebook.imagepipeline.c.p;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class g {
    private com.facebook.imagepipeline.f.a lJH;
    @Nullable
    private j<Boolean> lJK;
    private p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> lJS;
    private com.facebook.drawee.components.a lKc;
    private Executor lKd;
    @Nullable
    private ImmutableList<com.facebook.imagepipeline.f.a> lKe;
    private Resources mResources;

    public void a(Resources resources, com.facebook.drawee.components.a aVar, com.facebook.imagepipeline.f.a aVar2, Executor executor, p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, @Nullable ImmutableList<com.facebook.imagepipeline.f.a> immutableList, @Nullable j<Boolean> jVar) {
        this.mResources = resources;
        this.lKc = aVar;
        this.lJH = aVar2;
        this.lKd = executor;
        this.lJS = pVar;
        this.lKe = immutableList;
        this.lJK = jVar;
    }

    public d dlK() {
        d a = a(this.mResources, this.lKc, this.lJH, this.lKd, this.lJS, this.lKe);
        if (this.lJK != null) {
            a.va(this.lJK.get().booleanValue());
        }
        return a;
    }

    protected d a(Resources resources, com.facebook.drawee.components.a aVar, com.facebook.imagepipeline.f.a aVar2, Executor executor, p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, @Nullable ImmutableList<com.facebook.imagepipeline.f.a> immutableList) {
        return new d(resources, aVar, aVar2, executor, pVar, immutableList);
    }
}
