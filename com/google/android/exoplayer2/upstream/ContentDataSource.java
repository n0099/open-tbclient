package com.google.android.exoplayer2.upstream;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.FileChannel;
/* loaded from: classes5.dex */
public final class ContentDataSource implements e {
    private long bytesRemaining;
    private final q<? super ContentDataSource> mFa;
    private boolean mFb;
    private final ContentResolver mFc;
    private AssetFileDescriptor mFe;
    private FileInputStream mFf;
    private Uri uri;

    /* loaded from: classes5.dex */
    public static class ContentDataSourceException extends IOException {
        public ContentDataSourceException(IOException iOException) {
            super(iOException);
        }
    }

    public ContentDataSource(Context context, q<? super ContentDataSource> qVar) {
        this.mFc = context.getContentResolver();
        this.mFa = qVar;
    }

    @Override // com.google.android.exoplayer2.upstream.e
    public long a(g gVar) throws ContentDataSourceException {
        try {
            this.uri = gVar.uri;
            this.mFe = this.mFc.openAssetFileDescriptor(this.uri, "r");
            if (this.mFe == null) {
                throw new FileNotFoundException("Could not open file descriptor for: " + this.uri);
            }
            this.mFf = new FileInputStream(this.mFe.getFileDescriptor());
            long startOffset = this.mFe.getStartOffset();
            long skip = this.mFf.skip(gVar.fLD + startOffset) - startOffset;
            if (skip != gVar.fLD) {
                throw new EOFException();
            }
            if (gVar.length != -1) {
                this.bytesRemaining = gVar.length;
            } else {
                long length = this.mFe.getLength();
                if (length == -1) {
                    FileChannel channel = this.mFf.getChannel();
                    long size = channel.size();
                    this.bytesRemaining = size != 0 ? size - channel.position() : -1L;
                } else {
                    this.bytesRemaining = length - skip;
                }
            }
            this.mFb = true;
            if (this.mFa != null) {
                this.mFa.a(this, gVar);
            }
            return this.bytesRemaining;
        } catch (IOException e) {
            throw new ContentDataSourceException(e);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.e
    public int read(byte[] bArr, int i, int i2) throws ContentDataSourceException {
        if (i2 == 0) {
            return 0;
        }
        if (this.bytesRemaining != 0) {
            try {
                if (this.bytesRemaining != -1) {
                    i2 = (int) Math.min(this.bytesRemaining, i2);
                }
                int read = this.mFf.read(bArr, i, i2);
                if (read == -1) {
                    if (this.bytesRemaining != -1) {
                        throw new ContentDataSourceException(new EOFException());
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
                throw new ContentDataSourceException(e);
            }
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.upstream.e
    public Uri getUri() {
        return this.uri;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IPUT, IGET]}, finally: {[IPUT, IGET, IGET, INVOKE, IF, IPUT, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [168=4, 169=4, 170=4, 171=4, 172=4] */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 3, expect 1 */
    @Override // com.google.android.exoplayer2.upstream.e
    public void close() throws ContentDataSourceException {
        this.uri = null;
        try {
            try {
                if (this.mFf != null) {
                    this.mFf.close();
                }
                this.mFf = null;
                try {
                    try {
                        if (this.mFe != null) {
                            this.mFe.close();
                        }
                    } catch (IOException e) {
                        throw new ContentDataSourceException(e);
                    }
                } finally {
                    this.mFe = null;
                    if (this.mFb) {
                        this.mFb = false;
                        if (this.mFa != null) {
                            this.mFa.bz(this);
                        }
                    }
                }
            } catch (IOException e2) {
                throw new ContentDataSourceException(e2);
            }
        } catch (Throwable th) {
            this.mFf = null;
            try {
                try {
                    if (this.mFe != null) {
                        this.mFe.close();
                    }
                    this.mFe = null;
                    if (this.mFb) {
                        this.mFb = false;
                        if (this.mFa != null) {
                            this.mFa.bz(this);
                        }
                    }
                    throw th;
                } catch (IOException e3) {
                    throw new ContentDataSourceException(e3);
                }
            } finally {
                this.mFe = null;
                if (this.mFb) {
                    this.mFb = false;
                    if (this.mFa != null) {
                        this.mFa.bz(this);
                    }
                }
            }
        }
    }
}
