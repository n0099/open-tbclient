package com.facebook.drawee.a.a;

import android.content.Context;
import com.facebook.common.internal.i;
import com.facebook.imagepipeline.d.j;
import java.util.Set;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class f implements i<e> {
    private final g kbF;
    private final com.facebook.imagepipeline.d.g kbQ;
    private final Set<com.facebook.drawee.controller.c> kbS;
    private final Context mContext;

    public f(Context context, @Nullable b bVar) {
        this(context, j.cGQ(), bVar);
    }

    public f(Context context, j jVar, @Nullable b bVar) {
        this(context, jVar, null, bVar);
    }

    public f(Context context, j jVar, Set<com.facebook.drawee.controller.c> set, @Nullable b bVar) {
        this.mContext = context;
        this.kbQ = jVar.cDB();
        com.facebook.imagepipeline.a.a.b cGR = jVar.cGR();
        com.facebook.imagepipeline.a.a.a et = cGR != null ? cGR.et(context) : null;
        if (bVar != null && bVar.cDx() != null) {
            this.kbF = bVar.cDx();
        } else {
            this.kbF = new g();
        }
        this.kbF.a(context.getResources(), com.facebook.drawee.components.a.cDL(), et, com.facebook.common.b.f.cCG(), this.kbQ.cGi(), bVar != null ? bVar.cDw() : null, bVar != null ? bVar.cDy() : null);
        this.kbS = set;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.i
    /* renamed from: cDK */
    public e get() {
        return new e(this.mContext, this.kbF, this.kbQ, this.kbS);
    }
}
