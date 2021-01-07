package com.facebook.drawee.a.a;

import android.content.Context;
import com.facebook.common.b.i;
import com.facebook.common.internal.j;
import java.util.Set;
import javax.annotation.Nullable;
/* loaded from: classes6.dex */
public class f implements j<e> {
    private final Context mContext;
    private final g puD;
    private final com.facebook.imagepipeline.c.g puQ;
    private final Set<com.facebook.drawee.controller.c> puT;

    public f(Context context, @Nullable b bVar) {
        this(context, com.facebook.imagepipeline.c.j.eyK(), bVar);
    }

    public f(Context context, com.facebook.imagepipeline.c.j jVar, @Nullable b bVar) {
        this(context, jVar, null, bVar);
    }

    public f(Context context, com.facebook.imagepipeline.c.j jVar, Set<com.facebook.drawee.controller.c> set, @Nullable b bVar) {
        this.mContext = context;
        this.puQ = jVar.euR();
        if (bVar != null && bVar.euN() != null) {
            this.puD = bVar.euN();
        } else {
            this.puD = new g();
        }
        this.puD.a(context.getResources(), com.facebook.drawee.components.a.evj(), jVar.ij(context), i.etX(), this.puQ.exY(), bVar != null ? bVar.euM() : null, bVar != null ? bVar.euO() : null);
        this.puT = set;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.j
    /* renamed from: evc */
    public e get() {
        return new e(this.mContext, this.puD, this.puQ, this.puT);
    }
}
