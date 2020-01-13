package com.google.android.exoplayer2.upstream;

import android.content.Context;
import com.google.android.exoplayer2.upstream.e;
/* loaded from: classes5.dex */
public final class k implements e.a {
    private final Context context;
    private final q<? super e> mEV;
    private final e.a mFE;

    public k(Context context, String str) {
        this(context, str, (q<? super e>) null);
    }

    public k(Context context, String str, q<? super e> qVar) {
        this(context, qVar, new m(str, qVar));
    }

    public k(Context context, q<? super e> qVar, e.a aVar) {
        this.context = context.getApplicationContext();
        this.mEV = qVar;
        this.mFE = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.e.a
    /* renamed from: dxQ */
    public j dxH() {
        return new j(this.context, this.mEV, this.mFE.dxH());
    }
}
