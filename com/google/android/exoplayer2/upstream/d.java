package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import android.util.Base64;
import com.google.android.exoplayer2.ParserException;
import com.xiaomi.mipush.sdk.Constants;
import java.io.IOException;
import java.net.URLDecoder;
/* loaded from: classes5.dex */
public final class d implements e {
    private byte[] data;
    private g dataSpec;
    private int mlR;

    @Override // com.google.android.exoplayer2.upstream.e
    public long a(g gVar) throws IOException {
        this.dataSpec = gVar;
        Uri uri = gVar.uri;
        String scheme = uri.getScheme();
        if (!"data".equals(scheme)) {
            throw new ParserException("Unsupported scheme: " + scheme);
        }
        String[] split = uri.getSchemeSpecificPart().split(Constants.ACCEPT_TIME_SEPARATOR_SP);
        if (split.length > 2) {
            throw new ParserException("Unexpected URI format: " + uri);
        }
        String str = split[1];
        if (split[0].contains(";base64")) {
            try {
                this.data = Base64.decode(str, 0);
            } catch (IllegalArgumentException e) {
                throw new ParserException("Error while parsing Base64 encoded string: " + str, e);
            }
        } else {
            this.data = URLDecoder.decode(str, "US-ASCII").getBytes();
        }
        return this.data.length;
    }

    @Override // com.google.android.exoplayer2.upstream.e
    public int read(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        int length = this.data.length - this.mlR;
        if (length == 0) {
            return -1;
        }
        int min = Math.min(i2, length);
        System.arraycopy(this.data, this.mlR, bArr, i, min);
        this.mlR += min;
        return min;
    }

    @Override // com.google.android.exoplayer2.upstream.e
    public Uri getUri() {
        if (this.dataSpec != null) {
            return this.dataSpec.uri;
        }
        return null;
    }

    @Override // com.google.android.exoplayer2.upstream.e
    public void close() throws IOException {
        this.dataSpec = null;
        this.data = null;
    }
}
