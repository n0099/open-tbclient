package com.facebook.drawee.a.a;

import android.content.Context;
import com.facebook.common.b.i;
import com.facebook.common.internal.j;
import java.util.Set;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class f implements j<e> {
    private final g lJL;
    private final com.facebook.imagepipeline.d.g lKa;
    private final Set<com.facebook.drawee.controller.c> lKd;
    private final Context mContext;

    public f(Context context, @Nullable b bVar) {
        this(context, com.facebook.imagepipeline.d.j.dpw(), bVar);
    }

    public f(Context context, com.facebook.imagepipeline.d.j jVar, @Nullable b bVar) {
        this(context, jVar, null, bVar);
    }

    public f(Context context, com.facebook.imagepipeline.d.j jVar, Set<com.facebook.drawee.controller.c> set, @Nullable b bVar) {
        this.mContext = context;
        this.lKa = jVar.dlA();
        if (bVar != null && bVar.dlu() != null) {
            this.lJL = bVar.dlu();
        } else {
            this.lJL = new g();
        }
        this.lJL.a(context.getResources(), com.facebook.drawee.components.a.dlS(), jVar.gm(context), i.dkF(), this.lKa.doK(), bVar != null ? bVar.dlt() : null, bVar != null ? bVar.dlw() : null);
        this.lKd = set;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.j
    /* renamed from: dlL */
    public e get() {
        return new e(this.mContext, this.lJL, this.lKa, this.lKd);
    }
}
