package com.yy.audioengine;
/* loaded from: classes6.dex */
public class AudioFileReader {
    private static final String TAG = "AudioFileReader";
    private long mCtx;

    private native void nativeClose(long j);

    private native long nativeOpen(String str, String str2);

    private native byte[] nativeRead(long j, long j2);

    private native int nativeSeek(long j, long j2, int i);

    public boolean open(String str, String str2) {
        this.mCtx = nativeOpen(str, str2);
        return this.mCtx != 0;
    }

    public byte[] read(long j) {
        return nativeRead(this.mCtx, j);
    }

    public int seek(long j, int i) {
        return nativeSeek(this.mCtx, j, i);
    }

    public void close() {
        nativeClose(this.mCtx);
    }
}
