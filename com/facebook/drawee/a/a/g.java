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
    private com.facebook.imagepipeline.e.a pqa;
    @Nullable
    private j<Boolean> pqd;
    private p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pqj;
    private com.facebook.drawee.components.a pqt;
    private Executor pqu;
    @Nullable
    private ImmutableList<com.facebook.imagepipeline.e.a> pqv;

    public void a(Resources resources, com.facebook.drawee.components.a aVar, com.facebook.imagepipeline.e.a aVar2, Executor executor, p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pVar, @Nullable ImmutableList<com.facebook.imagepipeline.e.a> immutableList, @Nullable j<Boolean> jVar) {
        this.mResources = resources;
        this.pqt = aVar;
        this.pqa = aVar2;
        this.pqu = executor;
        this.pqj = pVar;
        this.pqv = immutableList;
        this.pqd = jVar;
    }

    public d erj() {
        d a2 = a(this.mResources, this.pqt, this.pqa, this.pqu, this.pqj, this.pqv);
        if (this.pqd != null) {
            a2.AN(this.pqd.get().booleanValue());
        }
        return a2;
    }

    protected d a(Resources resources, com.facebook.drawee.components.a aVar, com.facebook.imagepipeline.e.a aVar2, Executor executor, p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pVar, @Nullable ImmutableList<com.facebook.imagepipeline.e.a> immutableList) {
        return new d(resources, aVar, aVar2, executor, pVar, immutableList);
    }
}
