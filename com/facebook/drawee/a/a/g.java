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
    private com.facebook.imagepipeline.f.a mob;
    @Nullable
    private j<Boolean> moe;
    private p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> mol;
    private com.facebook.drawee.components.a mow;
    private Executor mox;
    @Nullable
    private ImmutableList<com.facebook.imagepipeline.f.a> moy;

    public void a(Resources resources, com.facebook.drawee.components.a aVar, com.facebook.imagepipeline.f.a aVar2, Executor executor, p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, @Nullable ImmutableList<com.facebook.imagepipeline.f.a> immutableList, @Nullable j<Boolean> jVar) {
        this.mResources = resources;
        this.mow = aVar;
        this.mob = aVar2;
        this.mox = executor;
        this.mol = pVar;
        this.moy = immutableList;
        this.moe = jVar;
    }

    public d dvH() {
        d a = a(this.mResources, this.mow, this.mob, this.mox, this.mol, this.moy);
        if (this.moe != null) {
            a.vV(this.moe.get().booleanValue());
        }
        return a;
    }

    protected d a(Resources resources, com.facebook.drawee.components.a aVar, com.facebook.imagepipeline.f.a aVar2, Executor executor, p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, @Nullable ImmutableList<com.facebook.imagepipeline.f.a> immutableList) {
        return new d(resources, aVar, aVar2, executor, pVar, immutableList);
    }
}
