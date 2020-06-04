package com.facebook.drawee.a.a;

import android.content.Context;
import com.facebook.common.b.i;
import com.facebook.common.internal.j;
import java.util.Set;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class f implements j<e> {
    private final Context mContext;
    private final g mod;
    private final com.facebook.imagepipeline.d.g mos;
    private final Set<com.facebook.drawee.controller.c> mov;

    public f(Context context, @Nullable b bVar) {
        this(context, com.facebook.imagepipeline.d.j.dzw(), bVar);
    }

    public f(Context context, com.facebook.imagepipeline.d.j jVar, @Nullable b bVar) {
        this(context, jVar, null, bVar);
    }

    public f(Context context, com.facebook.imagepipeline.d.j jVar, Set<com.facebook.drawee.controller.c> set, @Nullable b bVar) {
        this.mContext = context;
        this.mos = jVar.dvv();
        if (bVar != null && bVar.dvr() != null) {
            this.mod = bVar.dvr();
        } else {
            this.mod = new g();
        }
        this.mod.a(context.getResources(), com.facebook.drawee.components.a.dvN(), jVar.fV(context), i.duB(), this.mos.dyK(), bVar != null ? bVar.dvq() : null, bVar != null ? bVar.dvs() : null);
        this.mov = set;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.j
    /* renamed from: dvG */
    public e get() {
        return new e(this.mContext, this.mod, this.mos, this.mov);
    }
}
