package io.reactivex.internal.util;
/* loaded from: classes5.dex */
public final class h {
    public static int Nx(int i) {
        return 1 << (32 - Integer.numberOfLeadingZeros(i - 1));
    }
}
