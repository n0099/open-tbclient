package com.facebook.drawee.a.a;

import android.content.Context;
import com.facebook.common.b.i;
import com.facebook.common.internal.j;
import java.util.Set;
import javax.annotation.Nullable;
/* loaded from: classes9.dex */
public class f implements j<e> {
    private final Context mContext;
    private final com.facebook.imagepipeline.c.g pdB;
    private final Set<com.facebook.drawee.controller.c> pdE;
    private final g pdo;

    public f(Context context, @Nullable b bVar) {
        this(context, com.facebook.imagepipeline.c.j.euy(), bVar);
    }

    public f(Context context, com.facebook.imagepipeline.c.j jVar, @Nullable b bVar) {
        this(context, jVar, null, bVar);
    }

    public f(Context context, com.facebook.imagepipeline.c.j jVar, Set<com.facebook.drawee.controller.c> set, @Nullable b bVar) {
        this.mContext = context;
        this.pdB = jVar.eqH();
        if (bVar != null && bVar.eqD() != null) {
            this.pdo = bVar.eqD();
        } else {
            this.pdo = new g();
        }
        this.pdo.a(context.getResources(), com.facebook.drawee.components.a.eqZ(), jVar.hH(context), i.epN(), this.pdB.etM(), bVar != null ? bVar.eqC() : null, bVar != null ? bVar.eqE() : null);
        this.pdE = set;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.j
    /* renamed from: eqS */
    public e get() {
        return new e(this.mContext, this.pdo, this.pdB, this.pdE);
    }
}
