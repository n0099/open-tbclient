package com.google.android.exoplayer2.upstream;

import android.content.Context;
import com.google.android.exoplayer2.upstream.e;
/* loaded from: classes5.dex */
public final class k implements e.a {
    private final Context context;
    private final e.a mFJ;
    private final q<? super e> mFa;

    public k(Context context, String str) {
        this(context, str, (q<? super e>) null);
    }

    public k(Context context, String str, q<? super e> qVar) {
        this(context, qVar, new m(str, qVar));
    }

    public k(Context context, q<? super e> qVar, e.a aVar) {
        this.context = context.getApplicationContext();
        this.mFa = qVar;
        this.mFJ = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.e.a
    /* renamed from: dxS */
    public j dxJ() {
        return new j(this.context, this.mFa, this.mFJ.dxJ());
    }
}
