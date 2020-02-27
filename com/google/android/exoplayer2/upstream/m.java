package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.upstream.HttpDataSource;
/* loaded from: classes6.dex */
public final class m extends HttpDataSource.a {
    private final q<? super e> mFH;
    private final boolean mGs;
    private final int mGt;
    private final int mGu;
    private final String userAgent;

    public m(String str, q<? super e> qVar) {
        this(str, qVar, 8000, 8000, false);
    }

    public m(String str, q<? super e> qVar, int i, int i2, boolean z) {
        this.userAgent = str;
        this.mFH = qVar;
        this.mGt = i;
        this.mGu = i2;
        this.mGs = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.upstream.HttpDataSource.a
    /* renamed from: a */
    public l b(HttpDataSource.b bVar) {
        return new l(this.userAgent, null, this.mFH, this.mGt, this.mGu, this.mGs, bVar);
    }
}
