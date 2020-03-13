package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.upstream.HttpDataSource;
/* loaded from: classes6.dex */
public final class m extends HttpDataSource.a {
    private final q<? super e> mFU;
    private final boolean mGF;
    private final int mGG;
    private final int mGH;
    private final String userAgent;

    public m(String str, q<? super e> qVar) {
        this(str, qVar, 8000, 8000, false);
    }

    public m(String str, q<? super e> qVar, int i, int i2, boolean z) {
        this.userAgent = str;
        this.mFU = qVar;
        this.mGG = i;
        this.mGH = i2;
        this.mGF = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.upstream.HttpDataSource.a
    /* renamed from: a */
    public l b(HttpDataSource.b bVar) {
        return new l(this.userAgent, null, this.mFU, this.mGG, this.mGH, this.mGF, bVar);
    }
}
