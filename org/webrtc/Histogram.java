package org.webrtc;
/* loaded from: classes7.dex */
public class Histogram {
    public final long handle;

    public Histogram(long j) {
        this.handle = j;
    }

    public static Histogram createCounts(String str, int i2, int i3, int i4) {
        return new Histogram(nativeCreateCounts(str, i2, i3, i4));
    }

    public static Histogram createEnumeration(String str, int i2) {
        return new Histogram(nativeCreateEnumeration(str, i2));
    }

    public static native void nativeAddSample(long j, int i2);

    public static native long nativeCreateCounts(String str, int i2, int i3, int i4);

    public static native long nativeCreateEnumeration(String str, int i2);

    public void addSample(int i2) {
        nativeAddSample(this.handle, i2);
    }
}
