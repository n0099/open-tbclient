package com.facebook.drawee.a.a;

import android.content.Context;
import com.facebook.common.b.i;
import com.facebook.common.internal.j;
import java.util.Set;
import javax.annotation.Nullable;
/* loaded from: classes15.dex */
public class f implements j<e> {
    private final Context mContext;
    private final g pAL;
    private final com.facebook.imagepipeline.c.g pAY;
    private final Set<com.facebook.drawee.controller.c> pBb;

    public f(Context context, @Nullable b bVar) {
        this(context, com.facebook.imagepipeline.c.j.ext(), bVar);
    }

    public f(Context context, com.facebook.imagepipeline.c.j jVar, @Nullable b bVar) {
        this(context, jVar, null, bVar);
    }

    public f(Context context, com.facebook.imagepipeline.c.j jVar, Set<com.facebook.drawee.controller.c> set, @Nullable b bVar) {
        this.mContext = context;
        this.pAY = jVar.ety();
        if (bVar != null && bVar.etu() != null) {
            this.pAL = bVar.etu();
        } else {
            this.pAL = new g();
        }
        this.pAL.a(context.getResources(), com.facebook.drawee.components.a.etQ(), jVar.ik(context), i.esE(), this.pAY.ewH(), bVar != null ? bVar.ett() : null, bVar != null ? bVar.etv() : null);
        this.pBb = set;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.j
    /* renamed from: etJ */
    public e get() {
        return new e(this.mContext, this.pAL, this.pAY, this.pBb);
    }
}
