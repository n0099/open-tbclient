package com.facebook.drawee.a.a;

import android.content.Context;
import com.facebook.common.b.i;
import com.facebook.common.internal.j;
import java.util.Set;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class f implements j<e> {
    private final Context mContext;
    private final g mmT;
    private final com.facebook.imagepipeline.d.g mnh;
    private final Set<com.facebook.drawee.controller.c> mnk;

    public f(Context context, @Nullable b bVar) {
        this(context, com.facebook.imagepipeline.d.j.dzi(), bVar);
    }

    public f(Context context, com.facebook.imagepipeline.d.j jVar, @Nullable b bVar) {
        this(context, jVar, null, bVar);
    }

    public f(Context context, com.facebook.imagepipeline.d.j jVar, Set<com.facebook.drawee.controller.c> set, @Nullable b bVar) {
        this.mContext = context;
        this.mnh = jVar.dvh();
        if (bVar != null && bVar.dvd() != null) {
            this.mmT = bVar.dvd();
        } else {
            this.mmT = new g();
        }
        this.mmT.a(context.getResources(), com.facebook.drawee.components.a.dvz(), jVar.fV(context), i.dun(), this.mnh.dyw(), bVar != null ? bVar.dvc() : null, bVar != null ? bVar.dve() : null);
        this.mnk = set;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.j
    /* renamed from: dvs */
    public e get() {
        return new e(this.mContext, this.mmT, this.mnh, this.mnk);
    }
}
