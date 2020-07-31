package io.reactivex.internal.util;
/* loaded from: classes7.dex */
public final class h {
    public static int Lo(int i) {
        return 1 << (32 - Integer.numberOfLeadingZeros(i - 1));
    }
}
