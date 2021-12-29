package com.kwad.sdk.utils;
/* loaded from: classes3.dex */
public class ai {
    public static int a(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, int i2) {
        int i3 = z ? 1 : 0;
        if (z2) {
            i3 |= 2;
        }
        if (z3) {
            i3 |= 4;
        }
        if (z4) {
            i3 |= 8;
        }
        if (z5) {
            i3 |= 16;
        }
        if (z6) {
            i3 |= 32;
        }
        return i2 == 2 ? i3 | 64 : i3;
    }
}
