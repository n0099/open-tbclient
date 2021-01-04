package com.facebook.drawee.a.a;

import android.content.Context;
import com.facebook.common.internal.j;
import java.util.Set;
import javax.annotation.Nullable;
/* loaded from: classes6.dex */
public class f implements j<e> {
    private final Context mContext;
    private final com.facebook.imagepipeline.c.g puJ;
    private final Set<com.facebook.drawee.controller.c> puM;
    private final g puw;

    public f(Context context, @Nullable b bVar) {
        this(context, com.facebook.imagepipeline.c.j.eyi(), bVar);
    }

    public f(Context context, com.facebook.imagepipeline.c.j jVar, @Nullable b bVar) {
        this(context, jVar, null, bVar);
    }

    public f(Context context, com.facebook.imagepipeline.c.j jVar, Set<com.facebook.drawee.controller.c> set, @Nullable b bVar) {
        this.mContext = context;
        this.puJ = jVar.euK();
        if (bVar != null && bVar.euG() != null) {
            this.puw = bVar.euG();
        } else {
            this.puw = new g();
        }
        this.puw.a(context.getResources(), com.facebook.drawee.components.a.evc(), jVar.ij(context), com.facebook.common.b.f.etR(), this.puJ.exw(), bVar != null ? bVar.euF() : null, bVar != null ? bVar.euH() : null);
        this.puM = set;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.j
    /* renamed from: euV */
    public e get() {
        return new e(this.mContext, this.puw, this.puJ, this.puM);
    }
}
