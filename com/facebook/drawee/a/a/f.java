package com.facebook.drawee.a.a;

import android.content.Context;
import com.facebook.common.b.i;
import com.facebook.common.internal.j;
import java.util.Set;
import javax.annotation.Nullable;
/* loaded from: classes10.dex */
public class f implements j<e> {
    private final Context mContext;
    private final g oOg;
    private final com.facebook.imagepipeline.d.g oOu;
    private final Set<com.facebook.drawee.controller.c> oOx;

    public f(Context context, @Nullable b bVar) {
        this(context, com.facebook.imagepipeline.d.j.eoT(), bVar);
    }

    public f(Context context, com.facebook.imagepipeline.d.j jVar, @Nullable b bVar) {
        this(context, jVar, null, bVar);
    }

    public f(Context context, com.facebook.imagepipeline.d.j jVar, Set<com.facebook.drawee.controller.c> set, @Nullable b bVar) {
        this.mContext = context;
        this.oOu = jVar.ekS();
        if (bVar != null && bVar.ekO() != null) {
            this.oOg = bVar.ekO();
        } else {
            this.oOg = new g();
        }
        this.oOg.a(context.getResources(), com.facebook.drawee.components.a.elk(), jVar.gY(context), i.ejY(), this.oOu.eoh(), bVar != null ? bVar.ekN() : null, bVar != null ? bVar.ekP() : null);
        this.oOx = set;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.j
    /* renamed from: eld */
    public e get() {
        return new e(this.mContext, this.oOg, this.oOu, this.oOx);
    }
}
