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
    private final q<? super ContentDataSource> mEV;
    private boolean mEW;
    private final ContentResolver mEX;
    private AssetFileDescriptor mEY;
    private FileInputStream mEZ;
    private Uri uri;

    /* loaded from: classes5.dex */
    public static class ContentDataSourceException extends IOException {
        public ContentDataSourceException(IOException iOException) {
            super(iOException);
        }
    }

    public ContentDataSource(Context context, q<? super ContentDataSource> qVar) {
        this.mEX = context.getContentResolver();
        this.mEV = qVar;
    }

    @Override // com.google.android.exoplayer2.upstream.e
    public long a(g gVar) throws ContentDataSourceException {
        try {
            this.uri = gVar.uri;
            this.mEY = this.mEX.openAssetFileDescriptor(this.uri, "r");
            if (this.mEY == null) {
                throw new FileNotFoundException("Could not open file descriptor for: " + this.uri);
            }
            this.mEZ = new FileInputStream(this.mEY.getFileDescriptor());
            long startOffset = this.mEY.getStartOffset();
            long skip = this.mEZ.skip(gVar.fLD + startOffset) - startOffset;
            if (skip != gVar.fLD) {
                throw new EOFException();
            }
            if (gVar.length != -1) {
                this.bytesRemaining = gVar.length;
            } else {
                long length = this.mEY.getLength();
                if (length == -1) {
                    FileChannel channel = this.mEZ.getChannel();
                    long size = channel.size();
                    this.bytesRemaining = size != 0 ? size - channel.position() : -1L;
                } else {
                    this.bytesRemaining = length - skip;
                }
            }
            this.mEW = true;
            if (this.mEV != null) {
                this.mEV.a(this, gVar);
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
                int read = this.mEZ.read(bArr, i, i2);
                if (read == -1) {
                    if (this.bytesRemaining != -1) {
                        throw new ContentDataSourceException(new EOFException());
                    }
                    return -1;
                }
                if (this.bytesRemaining != -1) {
                    this.bytesRemaining -= read;
                }
                if (this.mEV != null) {
                    this.mEV.h(this, read);
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
                if (this.mEZ != null) {
                    this.mEZ.close();
                }
                this.mEZ = null;
                try {
                    try {
                        if (this.mEY != null) {
                            this.mEY.close();
                        }
                    } catch (IOException e) {
                        throw new ContentDataSourceException(e);
                    }
                } finally {
                    this.mEY = null;
                    if (this.mEW) {
                        this.mEW = false;
                        if (this.mEV != null) {
                            this.mEV.bz(this);
                        }
                    }
                }
            } catch (IOException e2) {
                throw new ContentDataSourceException(e2);
            }
        } catch (Throwable th) {
            this.mEZ = null;
            try {
                try {
                    if (this.mEY != null) {
                        this.mEY.close();
                    }
                    this.mEY = null;
                    if (this.mEW) {
                        this.mEW = false;
                        if (this.mEV != null) {
                            this.mEV.bz(this);
                        }
                    }
                    throw th;
                } catch (IOException e3) {
                    throw new ContentDataSourceException(e3);
                }
            } finally {
                this.mEY = null;
                if (this.mEW) {
                    this.mEW = false;
                    if (this.mEV != null) {
                        this.mEV.bz(this);
                    }
                }
            }
        }
    }
}
