package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.upstream.HttpDataSource;
/* loaded from: classes4.dex */
public final class m extends HttpDataSource.a {
    private final boolean mBP;
    private final int mBQ;
    private final int mBR;
    private final q<? super e> mBd;
    private final String userAgent;

    public m(String str, q<? super e> qVar) {
        this(str, qVar, 8000, 8000, false);
    }

    public m(String str, q<? super e> qVar, int i, int i2, boolean z) {
        this.userAgent = str;
        this.mBd = qVar;
        this.mBQ = i;
        this.mBR = i2;
        this.mBP = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.upstream.HttpDataSource.a
    /* renamed from: a */
    public l b(HttpDataSource.b bVar) {
        return new l(this.userAgent, null, this.mBd, this.mBQ, this.mBR, this.mBP, bVar);
    }
}
