package com.facebook.drawee.a.a;

import android.content.Context;
import com.facebook.common.internal.i;
import com.facebook.imagepipeline.d.j;
import java.util.Set;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class f implements i<e> {
    private final g kaK;
    private final com.facebook.imagepipeline.d.g kaV;
    private final Set<com.facebook.drawee.controller.c> kaX;
    private final Context mContext;

    public f(Context context, @Nullable b bVar) {
        this(context, j.cIM(), bVar);
    }

    public f(Context context, j jVar, @Nullable b bVar) {
        this(context, jVar, null, bVar);
    }

    public f(Context context, j jVar, Set<com.facebook.drawee.controller.c> set, @Nullable b bVar) {
        this.mContext = context;
        this.kaV = jVar.cFw();
        com.facebook.imagepipeline.a.a.b cIN = jVar.cIN();
        com.facebook.imagepipeline.a.a.a eC = cIN != null ? cIN.eC(context) : null;
        if (bVar != null && bVar.cFs() != null) {
            this.kaK = bVar.cFs();
        } else {
            this.kaK = new g();
        }
        this.kaK.a(context.getResources(), com.facebook.drawee.components.a.cFG(), eC, com.facebook.common.b.f.cEB(), this.kaV.cIe(), bVar != null ? bVar.cFr() : null, bVar != null ? bVar.cFt() : null);
        this.kaX = set;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.i
    /* renamed from: cFF */
    public e get() {
        return new e(this.mContext, this.kaK, this.kaV, this.kaX);
    }
}
