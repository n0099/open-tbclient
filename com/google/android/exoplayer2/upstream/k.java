package com.google.android.exoplayer2.upstream;

import android.content.Context;
import com.google.android.exoplayer2.upstream.e;
/* loaded from: classes4.dex */
public final class k implements e.a {
    private final Context context;
    private final e.a mBM;
    private final q<? super e> mBd;

    public k(Context context, String str) {
        this(context, str, (q<? super e>) null);
    }

    public k(Context context, String str, q<? super e> qVar) {
        this(context, qVar, new m(str, qVar));
    }

    public k(Context context, q<? super e> qVar, e.a aVar) {
        this.context = context.getApplicationContext();
        this.mBd = qVar;
        this.mBM = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.e.a
    /* renamed from: dwF */
    public j dww() {
        return new j(this.context, this.mBd, this.mBM.dww());
    }
}
