package com.facebook.drawee.a.a;

import android.content.Context;
import com.facebook.common.b.i;
import com.facebook.common.internal.j;
import java.util.Set;
import javax.annotation.Nullable;
/* loaded from: classes11.dex */
public class f implements j<e> {
    private final com.facebook.imagepipeline.d.g lFO;
    private final Set<com.facebook.drawee.controller.c> lFR;
    private final g lFz;
    private final Context mContext;

    public f(Context context, @Nullable b bVar) {
        this(context, com.facebook.imagepipeline.d.j.dmZ(), bVar);
    }

    public f(Context context, com.facebook.imagepipeline.d.j jVar, @Nullable b bVar) {
        this(context, jVar, null, bVar);
    }

    public f(Context context, com.facebook.imagepipeline.d.j jVar, Set<com.facebook.drawee.controller.c> set, @Nullable b bVar) {
        this.mContext = context;
        this.lFO = jVar.dji();
        if (bVar != null && bVar.djc() != null) {
            this.lFz = bVar.djc();
        } else {
            this.lFz = new g();
        }
        this.lFz.a(context.getResources(), com.facebook.drawee.components.a.djA(), jVar.gm(context), i.din(), this.lFO.dmn(), bVar != null ? bVar.djb() : null, bVar != null ? bVar.dje() : null);
        this.lFR = set;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.j
    /* renamed from: djt */
    public e get() {
        return new e(this.mContext, this.lFz, this.lFO, this.lFR);
    }
}
