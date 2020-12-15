package com.facebook.drawee.a.a;

import android.content.Context;
import com.facebook.common.b.i;
import com.facebook.common.internal.j;
import java.util.Set;
import javax.annotation.Nullable;
/* loaded from: classes9.dex */
public class f implements j<e> {
    private final Context mContext;
    private final com.facebook.imagepipeline.c.g pdD;
    private final Set<com.facebook.drawee.controller.c> pdG;
    private final g pdq;

    public f(Context context, @Nullable b bVar) {
        this(context, com.facebook.imagepipeline.c.j.euz(), bVar);
    }

    public f(Context context, com.facebook.imagepipeline.c.j jVar, @Nullable b bVar) {
        this(context, jVar, null, bVar);
    }

    public f(Context context, com.facebook.imagepipeline.c.j jVar, Set<com.facebook.drawee.controller.c> set, @Nullable b bVar) {
        this.mContext = context;
        this.pdD = jVar.eqI();
        if (bVar != null && bVar.eqE() != null) {
            this.pdq = bVar.eqE();
        } else {
            this.pdq = new g();
        }
        this.pdq.a(context.getResources(), com.facebook.drawee.components.a.era(), jVar.hH(context), i.epO(), this.pdD.etN(), bVar != null ? bVar.eqD() : null, bVar != null ? bVar.eqF() : null);
        this.pdG = set;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.j
    /* renamed from: eqT */
    public e get() {
        return new e(this.mContext, this.pdq, this.pdD, this.pdG);
    }
}
