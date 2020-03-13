package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes6.dex */
public final class FileDataSource implements e {
    private long bytesRemaining;
    private RandomAccessFile file;
    private final q<? super FileDataSource> mFU;
    private boolean mFV;
    private Uri uri;

    /* loaded from: classes6.dex */
    public static class FileDataSourceException extends IOException {
        public FileDataSourceException(IOException iOException) {
            super(iOException);
        }
    }

    public FileDataSource() {
        this(null);
    }

    public FileDataSource(q<? super FileDataSource> qVar) {
        this.mFU = qVar;
    }

    @Override // com.google.android.exoplayer2.upstream.e
    public long a(g gVar) throws FileDataSourceException {
        try {
            this.uri = gVar.uri;
            this.file = new RandomAccessFile(gVar.uri.getPath(), "r");
            this.file.seek(gVar.fOo);
            this.bytesRemaining = gVar.length == -1 ? this.file.length() - gVar.fOo : gVar.length;
            if (this.bytesRemaining < 0) {
                throw new EOFException();
            }
            this.mFV = true;
            if (this.mFU != null) {
                this.mFU.a(this, gVar);
            }
            return this.bytesRemaining;
        } catch (IOException e) {
            throw new FileDataSourceException(e);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.e
    public int read(byte[] bArr, int i, int i2) throws FileDataSourceException {
        if (i2 == 0) {
            return 0;
        }
        if (this.bytesRemaining == 0) {
            return -1;
        }
        try {
            int read = this.file.read(bArr, i, (int) Math.min(this.bytesRemaining, i2));
            if (read > 0) {
                this.bytesRemaining -= read;
                if (this.mFU != null) {
                    this.mFU.h(this, read);
                    return read;
                }
                return read;
            }
            return read;
        } catch (IOException e) {
            throw new FileDataSourceException(e);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.e
    public Uri getUri() {
        return this.uri;
    }

    @Override // com.google.android.exoplayer2.upstream.e
    public void close() throws FileDataSourceException {
        this.uri = null;
        try {
            try {
                if (this.file != null) {
                    this.file.close();
                }
            } catch (IOException e) {
                throw new FileDataSourceException(e);
            }
        } finally {
            this.file = null;
            if (this.mFV) {
                this.mFV = false;
                if (this.mFU != null) {
                    this.mFU.bB(this);
                }
            }
        }
    }
}
