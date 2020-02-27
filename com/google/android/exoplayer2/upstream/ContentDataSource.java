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
/* loaded from: classes6.dex */
public final class ContentDataSource implements e {
    private long bytesRemaining;
    private final q<? super ContentDataSource> mFH;
    private boolean mFI;
    private final ContentResolver mFJ;
    private AssetFileDescriptor mFK;
    private FileInputStream mFL;
    private Uri uri;

    /* loaded from: classes6.dex */
    public static class ContentDataSourceException extends IOException {
        public ContentDataSourceException(IOException iOException) {
            super(iOException);
        }
    }

    public ContentDataSource(Context context, q<? super ContentDataSource> qVar) {
        this.mFJ = context.getContentResolver();
        this.mFH = qVar;
    }

    @Override // com.google.android.exoplayer2.upstream.e
    public long a(g gVar) throws ContentDataSourceException {
        try {
            this.uri = gVar.uri;
            this.mFK = this.mFJ.openAssetFileDescriptor(this.uri, "r");
            if (this.mFK == null) {
                throw new FileNotFoundException("Could not open file descriptor for: " + this.uri);
            }
            this.mFL = new FileInputStream(this.mFK.getFileDescriptor());
            long startOffset = this.mFK.getStartOffset();
            long skip = this.mFL.skip(gVar.fNZ + startOffset) - startOffset;
            if (skip != gVar.fNZ) {
                throw new EOFException();
            }
            if (gVar.length != -1) {
                this.bytesRemaining = gVar.length;
            } else {
                long length = this.mFK.getLength();
                if (length == -1) {
                    FileChannel channel = this.mFL.getChannel();
                    long size = channel.size();
                    this.bytesRemaining = size != 0 ? size - channel.position() : -1L;
                } else {
                    this.bytesRemaining = length - skip;
                }
            }
            this.mFI = true;
            if (this.mFH != null) {
                this.mFH.a(this, gVar);
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
                int read = this.mFL.read(bArr, i, i2);
                if (read == -1) {
                    if (this.bytesRemaining != -1) {
                        throw new ContentDataSourceException(new EOFException());
                    }
                    return -1;
                }
                if (this.bytesRemaining != -1) {
                    this.bytesRemaining -= read;
                }
                if (this.mFH != null) {
                    this.mFH.h(this, read);
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
                if (this.mFL != null) {
                    this.mFL.close();
                }
                this.mFL = null;
                try {
                    try {
                        if (this.mFK != null) {
                            this.mFK.close();
                        }
                    } catch (IOException e) {
                        throw new ContentDataSourceException(e);
                    }
                } finally {
                    this.mFK = null;
                    if (this.mFI) {
                        this.mFI = false;
                        if (this.mFH != null) {
                            this.mFH.bB(this);
                        }
                    }
                }
            } catch (IOException e2) {
                throw new ContentDataSourceException(e2);
            }
        } catch (Throwable th) {
            this.mFL = null;
            try {
                try {
                    if (this.mFK != null) {
                        this.mFK.close();
                    }
                    this.mFK = null;
                    if (this.mFI) {
                        this.mFI = false;
                        if (this.mFH != null) {
                            this.mFH.bB(this);
                        }
                    }
                    throw th;
                } catch (IOException e3) {
                    throw new ContentDataSourceException(e3);
                }
            } finally {
                this.mFK = null;
                if (this.mFI) {
                    this.mFI = false;
                    if (this.mFH != null) {
                        this.mFH.bB(this);
                    }
                }
            }
        }
    }
}
