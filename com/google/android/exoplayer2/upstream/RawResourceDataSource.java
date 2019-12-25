package com.google.android.exoplayer2.upstream;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes4.dex */
public final class RawResourceDataSource implements e {
    private long bytesRemaining;
    private InputStream inputStream;
    private final q<? super RawResourceDataSource> mBd;
    private boolean mBe;
    private AssetFileDescriptor mBh;
    private final Resources resources;
    private Uri uri;

    /* loaded from: classes4.dex */
    public static class RawResourceDataSourceException extends IOException {
        public RawResourceDataSourceException(String str) {
            super(str);
        }

        public RawResourceDataSourceException(IOException iOException) {
            super(iOException);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.e
    public long a(g gVar) throws RawResourceDataSourceException {
        try {
            this.uri = gVar.uri;
            if (!TextUtils.equals("rawresource", this.uri.getScheme())) {
                throw new RawResourceDataSourceException("URI must use scheme rawresource");
            }
            try {
                this.mBh = this.resources.openRawResourceFd(Integer.parseInt(this.uri.getLastPathSegment()));
                this.inputStream = new FileInputStream(this.mBh.getFileDescriptor());
                this.inputStream.skip(this.mBh.getStartOffset());
                if (this.inputStream.skip(gVar.fIt) < gVar.fIt) {
                    throw new EOFException();
                }
                if (gVar.length != -1) {
                    this.bytesRemaining = gVar.length;
                } else {
                    long length = this.mBh.getLength();
                    this.bytesRemaining = length != -1 ? length - gVar.fIt : -1L;
                }
                this.mBe = true;
                if (this.mBd != null) {
                    this.mBd.a(this, gVar);
                }
                return this.bytesRemaining;
            } catch (NumberFormatException e) {
                throw new RawResourceDataSourceException("Resource identifier must be an integer.");
            }
        } catch (IOException e2) {
            throw new RawResourceDataSourceException(e2);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.e
    public int read(byte[] bArr, int i, int i2) throws RawResourceDataSourceException {
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
                        throw new RawResourceDataSourceException(new EOFException());
                    }
                    return -1;
                }
                if (this.bytesRemaining != -1) {
                    this.bytesRemaining -= read;
                }
                if (this.mBd != null) {
                    this.mBd.h(this, read);
                }
                return read;
            } catch (IOException e) {
                throw new RawResourceDataSourceException(e);
            }
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.upstream.e
    public Uri getUri() {
        return this.uri;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IPUT, IGET]}, finally: {[IPUT, IGET, IGET, INVOKE, IF, IPUT, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [192=4, 193=4, 189=4, 190=4, 191=4] */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 3, expect 1 */
    @Override // com.google.android.exoplayer2.upstream.e
    public void close() throws RawResourceDataSourceException {
        this.uri = null;
        try {
            try {
                if (this.inputStream != null) {
                    this.inputStream.close();
                }
                this.inputStream = null;
                try {
                    try {
                        if (this.mBh != null) {
                            this.mBh.close();
                        }
                    } catch (IOException e) {
                        throw new RawResourceDataSourceException(e);
                    }
                } finally {
                    this.mBh = null;
                    if (this.mBe) {
                        this.mBe = false;
                        if (this.mBd != null) {
                            this.mBd.by(this);
                        }
                    }
                }
            } catch (IOException e2) {
                throw new RawResourceDataSourceException(e2);
            }
        } catch (Throwable th) {
            this.inputStream = null;
            try {
                try {
                    if (this.mBh != null) {
                        this.mBh.close();
                    }
                    this.mBh = null;
                    if (this.mBe) {
                        this.mBe = false;
                        if (this.mBd != null) {
                            this.mBd.by(this);
                        }
                    }
                    throw th;
                } catch (IOException e3) {
                    throw new RawResourceDataSourceException(e3);
                }
            } finally {
                this.mBh = null;
                if (this.mBe) {
                    this.mBe = false;
                    if (this.mBd != null) {
                        this.mBd.by(this);
                    }
                }
            }
        }
    }
}
