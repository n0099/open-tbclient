package com.facebook.drawee.a.a;

import android.content.Context;
import com.facebook.common.b.i;
import com.facebook.common.internal.j;
import java.util.Set;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class f implements j<e> {
    private final g lJJ;
    private final com.facebook.imagepipeline.d.g lJY;
    private final Set<com.facebook.drawee.controller.c> lKb;
    private final Context mContext;

    public f(Context context, @Nullable b bVar) {
        this(context, com.facebook.imagepipeline.d.j.dpu(), bVar);
    }

    public f(Context context, com.facebook.imagepipeline.d.j jVar, @Nullable b bVar) {
        this(context, jVar, null, bVar);
    }

    public f(Context context, com.facebook.imagepipeline.d.j jVar, Set<com.facebook.drawee.controller.c> set, @Nullable b bVar) {
        this.mContext = context;
        this.lJY = jVar.dly();
        if (bVar != null && bVar.dls() != null) {
            this.lJJ = bVar.dls();
        } else {
            this.lJJ = new g();
        }
        this.lJJ.a(context.getResources(), com.facebook.drawee.components.a.dlQ(), jVar.gm(context), i.dkD(), this.lJY.doI(), bVar != null ? bVar.dlr() : null, bVar != null ? bVar.dlu() : null);
        this.lKb = set;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.j
    /* renamed from: dlJ */
    public e get() {
        return new e(this.mContext, this.lJJ, this.lJY, this.lKb);
    }
}
