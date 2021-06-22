package common.network;
/* loaded from: classes7.dex */
public class Inet {
    static {
        System.loadLibrary("inet");
    }

    public static native long ping4(int i2, int i3, short s);
}
