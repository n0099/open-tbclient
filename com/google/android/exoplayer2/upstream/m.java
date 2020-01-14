package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.upstream.HttpDataSource;
/* loaded from: classes5.dex */
public final class m extends HttpDataSource.a {
    private final boolean mFM;
    private final int mFN;
    private final int mFO;
    private final q<? super e> mFa;
    private final String userAgent;

    public m(String str, q<? super e> qVar) {
        this(str, qVar, 8000, 8000, false);
    }

    public m(String str, q<? super e> qVar, int i, int i2, boolean z) {
        this.userAgent = str;
        this.mFa = qVar;
        this.mFN = i;
        this.mFO = i2;
        this.mFM = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.upstream.HttpDataSource.a
    /* renamed from: a */
    public l b(HttpDataSource.b bVar) {
        return new l(this.userAgent, null, this.mFa, this.mFN, this.mFO, this.mFM, bVar);
    }
}
