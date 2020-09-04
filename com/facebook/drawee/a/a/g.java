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
    private p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> nmF;
    private com.facebook.drawee.components.a nmP;
    private Executor nmQ;
    @Nullable
    private ImmutableList<com.facebook.imagepipeline.f.a> nmR;
    private com.facebook.imagepipeline.f.a nmv;
    @Nullable
    private j<Boolean> nmy;

    public void a(Resources resources, com.facebook.drawee.components.a aVar, com.facebook.imagepipeline.f.a aVar2, Executor executor, p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, @Nullable ImmutableList<com.facebook.imagepipeline.f.a> immutableList, @Nullable j<Boolean> jVar) {
        this.mResources = resources;
        this.nmP = aVar;
        this.nmv = aVar2;
        this.nmQ = executor;
        this.nmF = pVar;
        this.nmR = immutableList;
        this.nmy = jVar;
    }

    public d dPK() {
        d a = a(this.mResources, this.nmP, this.nmv, this.nmQ, this.nmF, this.nmR);
        if (this.nmy != null) {
            a.xP(this.nmy.get().booleanValue());
        }
        return a;
    }

    protected d a(Resources resources, com.facebook.drawee.components.a aVar, com.facebook.imagepipeline.f.a aVar2, Executor executor, p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, @Nullable ImmutableList<com.facebook.imagepipeline.f.a> immutableList) {
        return new d(resources, aVar, aVar2, executor, pVar, immutableList);
    }
}
