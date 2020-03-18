package com.facebook.drawee.a.a;

import android.content.Context;
import com.facebook.common.b.i;
import com.facebook.common.internal.j;
import java.util.Set;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class f implements j<e> {
    private final g lLC;
    private final com.facebook.imagepipeline.d.g lLR;
    private final Set<com.facebook.drawee.controller.c> lLU;
    private final Context mContext;

    public f(Context context, @Nullable b bVar) {
        this(context, com.facebook.imagepipeline.d.j.dpU(), bVar);
    }

    public f(Context context, com.facebook.imagepipeline.d.j jVar, @Nullable b bVar) {
        this(context, jVar, null, bVar);
    }

    public f(Context context, com.facebook.imagepipeline.d.j jVar, Set<com.facebook.drawee.controller.c> set, @Nullable b bVar) {
        this.mContext = context;
        this.lLR = jVar.dlY();
        if (bVar != null && bVar.dlS() != null) {
            this.lLC = bVar.dlS();
        } else {
            this.lLC = new g();
        }
        this.lLC.a(context.getResources(), com.facebook.drawee.components.a.dmq(), jVar.gl(context), i.dld(), this.lLR.dpi(), bVar != null ? bVar.dlR() : null, bVar != null ? bVar.dlU() : null);
        this.lLU = set;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.j
    /* renamed from: dmj */
    public e get() {
        return new e(this.mContext, this.lLC, this.lLR, this.lLU);
    }
}
