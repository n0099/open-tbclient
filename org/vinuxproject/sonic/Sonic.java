package org.vinuxproject.sonic;
/* loaded from: classes9.dex */
public class Sonic {
    public long a;

    private native int availableBytesNative(long j);

    private native void closeNative(long j);

    private native void flushNative(long j);

    private native boolean getChordPitchNative(long j);

    private native int getNumChannelsNative(long j);

    private native float getPitchNative(long j);

    private native float getRateNative(long j);

    private native int getSampleRateNative(long j);

    private native float getSpeedNative(long j);

    private native float getVolumeNative(long j);

    private native long initNative(int i, int i2);

    private native boolean putBytesNative(long j, byte[] bArr, int i);

    private native int receiveBytesNative(long j, byte[] bArr, int i);

    private native void setChordPitchNative(long j, boolean z);

    private native void setNumChannelsNative(long j, int i);

    private native void setPitchNative(long j, float f);

    private native void setRateNative(long j, float f);

    private native void setSampleRateNative(long j, int i);

    private native void setSpeedNative(long j, float f);

    private native void setVolumeNative(long j, float f);

    static {
        System.loadLibrary("sonic");
    }

    public int a() {
        return availableBytesNative(this.a);
    }

    public void b() {
        long j = this.a;
        if (j != 0) {
            closeNative(j);
            this.a = 0L;
        }
    }

    public void c() {
        flushNative(this.a);
    }

    public void finalize() {
        b();
    }

    public Sonic(int i, int i2) {
        this.a = 0L;
        b();
        this.a = initNative(i, i2);
    }

    public boolean d(byte[] bArr, int i) {
        return putBytesNative(this.a, bArr, i);
    }

    public int e(byte[] bArr, int i) {
        return receiveBytesNative(this.a, bArr, i);
    }

    public void f(float f) {
        setSpeedNative(this.a, f);
    }
}
