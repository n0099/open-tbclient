package com.facebook.drawee.a.a;

import android.content.Context;
import com.facebook.common.internal.i;
import com.facebook.imagepipeline.d.j;
import java.util.Set;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class f implements i<e> {
    private final Set<com.facebook.drawee.controller.c> keB;
    private final g ken;
    private final com.facebook.imagepipeline.d.g kez;
    private final Context mContext;

    public f(Context context, @Nullable b bVar) {
        this(context, j.cJV(), bVar);
    }

    public f(Context context, j jVar, @Nullable b bVar) {
        this(context, jVar, null, bVar);
    }

    public f(Context context, j jVar, Set<com.facebook.drawee.controller.c> set, @Nullable b bVar) {
        this.mContext = context;
        this.kez = jVar.cGF();
        com.facebook.imagepipeline.a.a.b cJW = jVar.cJW();
        com.facebook.imagepipeline.a.a.a eE = cJW != null ? cJW.eE(context) : null;
        if (bVar != null && bVar.cGB() != null) {
            this.ken = bVar.cGB();
        } else {
            this.ken = new g();
        }
        this.ken.a(context.getResources(), com.facebook.drawee.components.a.cGP(), eE, com.facebook.common.b.f.cFK(), this.kez.cJn(), bVar != null ? bVar.cGA() : null, bVar != null ? bVar.cGC() : null);
        this.keB = set;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.i
    /* renamed from: cGO */
    public e get() {
        return new e(this.mContext, this.ken, this.kez, this.keB);
    }
}
