package kotlin.random;

import kotlin.h;
@h
/* loaded from: classes9.dex */
public final class c {
    public static final int RY(int i) {
        return 31 - Integer.numberOfLeadingZeros(i);
    }

    public static final double es(int i, int i2) {
        return ((i << 27) + i2) / 9007199254740992L;
    }
}
