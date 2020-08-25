package com.facebook.drawee.a.a;

import android.content.Context;
import com.facebook.common.b.i;
import com.facebook.common.internal.j;
import java.util.Set;
import javax.annotation.Nullable;
/* loaded from: classes9.dex */
public class f implements j<e> {
    private final Context mContext;
    private final g nmf;
    private final com.facebook.imagepipeline.d.g nmt;
    private final Set<com.facebook.drawee.controller.c> nmw;

    public f(Context context, @Nullable b bVar) {
        this(context, com.facebook.imagepipeline.d.j.dTo(), bVar);
    }

    public f(Context context, com.facebook.imagepipeline.d.j jVar, @Nullable b bVar) {
        this(context, jVar, null, bVar);
    }

    public f(Context context, com.facebook.imagepipeline.d.j jVar, Set<com.facebook.drawee.controller.c> set, @Nullable b bVar) {
        this.mContext = context;
        this.nmt = jVar.dPp();
        if (bVar != null && bVar.dPl() != null) {
            this.nmf = bVar.dPl();
        } else {
            this.nmf = new g();
        }
        this.nmf.a(context.getResources(), com.facebook.drawee.components.a.dPH(), jVar.gs(context), i.dOv(), this.nmt.dSC(), bVar != null ? bVar.dPk() : null, bVar != null ? bVar.dPm() : null);
        this.nmw = set;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.j
    /* renamed from: dPA */
    public e get() {
        return new e(this.mContext, this.nmf, this.nmt, this.nmw);
    }
}
