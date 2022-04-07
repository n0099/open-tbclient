package com.kwad.sdk.utils;
/* loaded from: classes5.dex */
public class ai {
    public static int a(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, int i) {
        int i2 = z ? 1 : 0;
        if (z2) {
            i2 |= 2;
        }
        if (z3) {
            i2 |= 4;
        }
        if (z4) {
            i2 |= 8;
        }
        if (z5) {
            i2 |= 16;
        }
        if (z6) {
            i2 |= 32;
        }
        return i == 2 ? i2 | 64 : i2;
    }
}
