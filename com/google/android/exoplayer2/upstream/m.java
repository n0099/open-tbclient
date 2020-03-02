package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.upstream.HttpDataSource;
/* loaded from: classes6.dex */
public final class m extends HttpDataSource.a {
    private final q<? super e> mFJ;
    private final boolean mGu;
    private final int mGv;
    private final int mGw;
    private final String userAgent;

    public m(String str, q<? super e> qVar) {
        this(str, qVar, 8000, 8000, false);
    }

    public m(String str, q<? super e> qVar, int i, int i2, boolean z) {
        this.userAgent = str;
        this.mFJ = qVar;
        this.mGv = i;
        this.mGw = i2;
        this.mGu = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.upstream.HttpDataSource.a
    /* renamed from: a */
    public l b(HttpDataSource.b bVar) {
        return new l(this.userAgent, null, this.mFJ, this.mGv, this.mGw, this.mGu, bVar);
    }
}
