package com.facebook.drawee.a.a;

import android.content.res.Resources;
import com.facebook.common.internal.ImmutableList;
import com.facebook.common.internal.j;
import com.facebook.imagepipeline.c.p;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
/* loaded from: classes15.dex */
public class g {
    private Resources mResources;
    private p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> nwF;
    private com.facebook.drawee.components.a nwP;
    private Executor nwQ;
    @Nullable
    private ImmutableList<com.facebook.imagepipeline.f.a> nwR;
    private com.facebook.imagepipeline.f.a nwv;
    @Nullable
    private j<Boolean> nwy;

    public void a(Resources resources, com.facebook.drawee.components.a aVar, com.facebook.imagepipeline.f.a aVar2, Executor executor, p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, @Nullable ImmutableList<com.facebook.imagepipeline.f.a> immutableList, @Nullable j<Boolean> jVar) {
        this.mResources = resources;
        this.nwP = aVar;
        this.nwv = aVar2;
        this.nwQ = executor;
        this.nwF = pVar;
        this.nwR = immutableList;
        this.nwy = jVar;
    }

    public d dTI() {
        d a = a(this.mResources, this.nwP, this.nwv, this.nwQ, this.nwF, this.nwR);
        if (this.nwy != null) {
            a.xY(this.nwy.get().booleanValue());
        }
        return a;
    }

    protected d a(Resources resources, com.facebook.drawee.components.a aVar, com.facebook.imagepipeline.f.a aVar2, Executor executor, p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, @Nullable ImmutableList<com.facebook.imagepipeline.f.a> immutableList) {
        return new d(resources, aVar, aVar2, executor, pVar, immutableList);
    }
}
