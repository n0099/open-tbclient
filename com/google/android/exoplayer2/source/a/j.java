package com.google.android.exoplayer2.source.a;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.v;
import java.io.IOException;
import java.util.Arrays;
/* loaded from: classes5.dex */
public abstract class j extends c {
    private byte[] data;
    private int limit;
    private volatile boolean mrm;

    protected abstract void z(byte[] bArr, int i) throws IOException;

    public j(com.google.android.exoplayer2.upstream.e eVar, com.google.android.exoplayer2.upstream.g gVar, int i, Format format, int i2, Object obj, byte[] bArr) {
        super(eVar, gVar, i, format, i2, obj, -9223372036854775807L, -9223372036854775807L);
        this.data = bArr;
    }

    public byte[] dvG() {
        return this.data;
    }

    @Override // com.google.android.exoplayer2.source.a.c
    public long dvz() {
        return this.limit;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public final void cancelLoad() {
        this.mrm = true;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public final boolean dvh() {
        return this.mrm;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public final void load() throws IOException, InterruptedException {
        int i = 0;
        try {
            this.mdo.a(this.dataSpec);
            this.limit = 0;
            while (i != -1 && !this.mrm) {
                dvH();
                i = this.mdo.read(this.data, this.limit, 16384);
                if (i != -1) {
                    this.limit += i;
                }
            }
            if (!this.mrm) {
                z(this.data, this.limit);
            }
        } finally {
            v.a(this.mdo);
        }
    }

    private void dvH() {
        if (this.data == null) {
            this.data = new byte[16384];
        } else if (this.data.length < this.limit + 16384) {
            this.data = Arrays.copyOf(this.data, this.data.length + 16384);
        }
    }
}
