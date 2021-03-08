package com.yy.audioengine;
/* loaded from: classes6.dex */
public class AudioFileWriter {
    private static final String TAG = "AudioFileWriter";
    private long mCtx;

    private native void nativeClose(long j);

    private native long nativeOpen(String str, String str2);

    private native long nativeWrite(long j, byte[] bArr);

    public boolean open(String str, String str2) {
        this.mCtx = nativeOpen(str, str2);
        return this.mCtx != 0;
    }

    public long write(byte[] bArr) {
        return nativeWrite(this.mCtx, bArr);
    }

    public void close() {
        nativeClose(this.mCtx);
    }
}
