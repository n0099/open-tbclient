package com.facebook.drawee.a.a;

import android.content.res.Resources;
import com.facebook.common.internal.ImmutableList;
import com.facebook.common.internal.j;
import com.facebook.imagepipeline.c.p;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
/* loaded from: classes9.dex */
public class g {
    private Resources mResources;
    private com.facebook.imagepipeline.f.a nmd;
    @Nullable
    private j<Boolean> nmg;
    private p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> nmn;
    private com.facebook.drawee.components.a nmx;
    private Executor nmy;
    @Nullable
    private ImmutableList<com.facebook.imagepipeline.f.a> nmz;

    public void a(Resources resources, com.facebook.drawee.components.a aVar, com.facebook.imagepipeline.f.a aVar2, Executor executor, p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, @Nullable ImmutableList<com.facebook.imagepipeline.f.a> immutableList, @Nullable j<Boolean> jVar) {
        this.mResources = resources;
        this.nmx = aVar;
        this.nmd = aVar2;
        this.nmy = executor;
        this.nmn = pVar;
        this.nmz = immutableList;
        this.nmg = jVar;
    }

    public d dPB() {
        d a = a(this.mResources, this.nmx, this.nmd, this.nmy, this.nmn, this.nmz);
        if (this.nmg != null) {
            a.xN(this.nmg.get().booleanValue());
        }
        return a;
    }

    protected d a(Resources resources, com.facebook.drawee.components.a aVar, com.facebook.imagepipeline.f.a aVar2, Executor executor, p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, @Nullable ImmutableList<com.facebook.imagepipeline.f.a> immutableList) {
        return new d(resources, aVar, aVar2, executor, pVar, immutableList);
    }
}
