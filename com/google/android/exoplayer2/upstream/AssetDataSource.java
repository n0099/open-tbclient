package com.google.android.exoplayer2.upstream;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes5.dex */
public final class AssetDataSource implements e {
    private final AssetManager assetManager;
    private long bytesRemaining;
    private InputStream inputStream;
    private final q<? super AssetDataSource> mFa;
    private boolean mFb;
    private Uri uri;

    /* loaded from: classes5.dex */
    public static final class AssetDataSourceException extends IOException {
        public AssetDataSourceException(IOException iOException) {
            super(iOException);
        }
    }

    public AssetDataSource(Context context, q<? super AssetDataSource> qVar) {
        this.assetManager = context.getAssets();
        this.mFa = qVar;
    }

    @Override // com.google.android.exoplayer2.upstream.e
    public long a(g gVar) throws AssetDataSourceException {
        try {
            this.uri = gVar.uri;
            String path = this.uri.getPath();
            if (path.startsWith("/android_asset/")) {
                path = path.substring(15);
            } else if (path.startsWith("/")) {
                path = path.substring(1);
            }
            this.inputStream = this.assetManager.open(path, 1);
            if (this.inputStream.skip(gVar.fLD) < gVar.fLD) {
                throw new EOFException();
            }
            if (gVar.length != -1) {
                this.bytesRemaining = gVar.length;
            } else {
                this.bytesRemaining = this.inputStream.available();
                if (this.bytesRemaining == 2147483647L) {
                    this.bytesRemaining = -1L;
                }
            }
            this.mFb = true;
            if (this.mFa != null) {
                this.mFa.a(this, gVar);
            }
            return this.bytesRemaining;
        } catch (IOException e) {
            throw new AssetDataSourceException(e);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.e
    public int read(byte[] bArr, int i, int i2) throws AssetDataSourceException {
        if (i2 == 0) {
            return 0;
        }
        if (this.bytesRemaining != 0) {
            try {
                if (this.bytesRemaining != -1) {
                    i2 = (int) Math.min(this.bytesRemaining, i2);
                }
                int read = this.inputStream.read(bArr, i, i2);
                if (read == -1) {
                    if (this.bytesRemaining != -1) {
                        throw new AssetDataSourceException(new EOFException());
                    }
                    return -1;
                }
                if (this.bytesRemaining != -1) {
                    this.bytesRemaining -= read;
                }
                if (this.mFa != null) {
                    this.mFa.h(this, read);
                }
                return read;
            } catch (IOException e) {
                throw new AssetDataSourceException(e);
            }
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.upstream.e
    public Uri getUri() {
        return this.uri;
    }

    @Override // com.google.android.exoplayer2.upstream.e
    public void close() throws AssetDataSourceException {
        this.uri = null;
        try {
            try {
                if (this.inputStream != null) {
                    this.inputStream.close();
                }
            } catch (IOException e) {
                throw new AssetDataSourceException(e);
            }
        } finally {
            this.inputStream = null;
            if (this.mFb) {
                this.mFb = false;
                if (this.mFa != null) {
                    this.mFa.bz(this);
                }
            }
        }
    }
}
