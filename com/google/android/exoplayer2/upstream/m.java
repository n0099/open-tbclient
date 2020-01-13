package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.upstream.HttpDataSource;
/* loaded from: classes5.dex */
public final class m extends HttpDataSource.a {
    private final q<? super e> mEV;
    private final boolean mFH;
    private final int mFI;
    private final int mFJ;
    private final String userAgent;

    public m(String str, q<? super e> qVar) {
        this(str, qVar, 8000, 8000, false);
    }

    public m(String str, q<? super e> qVar, int i, int i2, boolean z) {
        this.userAgent = str;
        this.mEV = qVar;
        this.mFI = i;
        this.mFJ = i2;
        this.mFH = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.upstream.HttpDataSource.a
    /* renamed from: a */
    public l b(HttpDataSource.b bVar) {
        return new l(this.userAgent, null, this.mEV, this.mFI, this.mFJ, this.mFH, bVar);
    }
}
