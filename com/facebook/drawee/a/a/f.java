package com.facebook.drawee.a.a;

import android.content.Context;
import com.facebook.common.b.i;
import com.facebook.common.internal.j;
import java.util.Set;
import javax.annotation.Nullable;
/* loaded from: classes15.dex */
public class f implements j<e> {
    private final Context mContext;
    private final com.facebook.imagepipeline.d.g nwL;
    private final Set<com.facebook.drawee.controller.c> nwO;
    private final g nwx;

    public f(Context context, @Nullable b bVar) {
        this(context, com.facebook.imagepipeline.d.j.dXv(), bVar);
    }

    public f(Context context, com.facebook.imagepipeline.d.j jVar, @Nullable b bVar) {
        this(context, jVar, null, bVar);
    }

    public f(Context context, com.facebook.imagepipeline.d.j jVar, Set<com.facebook.drawee.controller.c> set, @Nullable b bVar) {
        this.mContext = context;
        this.nwL = jVar.dTw();
        if (bVar != null && bVar.dTs() != null) {
            this.nwx = bVar.dTs();
        } else {
            this.nwx = new g();
        }
        this.nwx.a(context.getResources(), com.facebook.drawee.components.a.dTO(), jVar.gy(context), i.dSC(), this.nwL.dWJ(), bVar != null ? bVar.dTr() : null, bVar != null ? bVar.dTt() : null);
        this.nwO = set;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.j
    /* renamed from: dTH */
    public e get() {
        return new e(this.mContext, this.nwx, this.nwL, this.nwO);
    }
}
