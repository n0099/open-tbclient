package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import com.baidu.android.common.others.lang.StringUtil;
import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;
/* loaded from: classes9.dex */
public final class ByteArrayDataSource implements DataSource {
    public int bytesRemaining;
    public final byte[] data;
    public int readPosition;
    public Uri uri;

    public ByteArrayDataSource(byte[] bArr) {
        boolean z;
        Assertions.checkNotNull(bArr);
        if (bArr.length > 0) {
            z = true;
        } else {
            z = false;
        }
        Assertions.checkArgument(z);
        this.data = bArr;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void close() throws IOException {
        this.uri = null;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public Uri getUri() {
        return this.uri;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public long open(DataSpec dataSpec) throws IOException {
        this.uri = dataSpec.uri;
        long j = dataSpec.position;
        this.readPosition = (int) j;
        long j2 = dataSpec.length;
        if (j2 == -1) {
            j2 = this.data.length - j;
        }
        int i = (int) j2;
        this.bytesRemaining = i;
        if (i > 0 && this.readPosition + i <= this.data.length) {
            return i;
        }
        throw new IOException("Unsatisfiable range: [" + this.readPosition + StringUtil.ARRAY_ELEMENT_SEPARATOR + dataSpec.length + "], length: " + this.data.length);
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (i2 == 0) {
            return 0;
        }
        int i3 = this.bytesRemaining;
        if (i3 == 0) {
            return -1;
        }
        int min = Math.min(i2, i3);
        System.arraycopy(this.data, this.readPosition, bArr, i, min);
        this.readPosition += min;
        this.bytesRemaining -= min;
        return min;
    }
}
