package io.reactivex.internal.util;
/* loaded from: classes4.dex */
public final class h {
    public static int MK(int i) {
        return 1 << (32 - Integer.numberOfLeadingZeros(i - 1));
    }
}
