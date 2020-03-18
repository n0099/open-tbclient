package com.google.android.exoplayer2.upstream;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes6.dex */
public final class RawResourceDataSource implements e {
    private long bytesRemaining;
    private InputStream inputStream;
    private final q<? super RawResourceDataSource> mHA;
    private boolean mHB;
    private AssetFileDescriptor mHD;
    private final Resources resources;
    private Uri uri;

    /* loaded from: classes6.dex */
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
                this.mHD = this.resources.openRawResourceFd(Integer.parseInt(this.uri.getLastPathSegment()));
                this.inputStream = new FileInputStream(this.mHD.getFileDescriptor());
                this.inputStream.skip(this.mHD.getStartOffset());
                if (this.inputStream.skip(gVar.fOW) < gVar.fOW) {
                    throw new EOFException();
                }
                if (gVar.length != -1) {
                    this.bytesRemaining = gVar.length;
                } else {
                    long length = this.mHD.getLength();
                    this.bytesRemaining = length != -1 ? length - gVar.fOW : -1L;
                }
                this.mHB = true;
                if (this.mHA != null) {
                    this.mHA.a(this, gVar);
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
                if (this.mHA != null) {
                    this.mHA.h(this, read);
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
                        if (this.mHD != null) {
                            this.mHD.close();
                        }
                    } catch (IOException e) {
                        throw new RawResourceDataSourceException(e);
                    }
                } finally {
                    this.mHD = null;
                    if (this.mHB) {
                        this.mHB = false;
                        if (this.mHA != null) {
                            this.mHA.bB(this);
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
                    if (this.mHD != null) {
                        this.mHD.close();
                    }
                    this.mHD = null;
                    if (this.mHB) {
                        this.mHB = false;
                        if (this.mHA != null) {
                            this.mHA.bB(this);
                        }
                    }
                    throw th;
                } catch (IOException e3) {
                    throw new RawResourceDataSourceException(e3);
                }
            } finally {
                this.mHD = null;
                if (this.mHB) {
                    this.mHB = false;
                    if (this.mHA != null) {
                        this.mHA.bB(this);
                    }
                }
            }
        }
    }
}
