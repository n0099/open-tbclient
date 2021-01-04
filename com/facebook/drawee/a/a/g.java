package com.facebook.drawee.a.a;

import android.content.res.Resources;
import com.facebook.common.internal.ImmutableList;
import com.facebook.common.internal.j;
import com.facebook.imagepipeline.b.p;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
/* loaded from: classes6.dex */
public class g {
    private Resources mResources;
    private p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> puD;
    private com.facebook.drawee.components.a puN;
    private Executor puO;
    @Nullable
    private ImmutableList<com.facebook.imagepipeline.e.a> puP;
    private com.facebook.imagepipeline.e.a puu;
    @Nullable
    private j<Boolean> pux;

    public void a(Resources resources, com.facebook.drawee.components.a aVar, com.facebook.imagepipeline.e.a aVar2, Executor executor, p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pVar, @Nullable ImmutableList<com.facebook.imagepipeline.e.a> immutableList, @Nullable j<Boolean> jVar) {
        this.mResources = resources;
        this.puN = aVar;
        this.puu = aVar2;
        this.puO = executor;
        this.puD = pVar;
        this.puP = immutableList;
        this.pux = jVar;
    }

    public d euW() {
        d a2 = a(this.mResources, this.puN, this.puu, this.puO, this.puD, this.puP);
        if (this.pux != null) {
            a2.AR(this.pux.get().booleanValue());
        }
        return a2;
    }

    protected d a(Resources resources, com.facebook.drawee.components.a aVar, com.facebook.imagepipeline.e.a aVar2, Executor executor, p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pVar, @Nullable ImmutableList<com.facebook.imagepipeline.e.a> immutableList) {
        return new d(resources, aVar, aVar2, executor, pVar, immutableList);
    }
}
