package io.reactivex.internal.util;
/* loaded from: classes3.dex */
public final class h {
    public static int Tk(int i) {
        return 1 << (32 - Integer.numberOfLeadingZeros(i - 1));
    }
}
