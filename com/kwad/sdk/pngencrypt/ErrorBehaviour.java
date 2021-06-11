package com.kwad.sdk.pngencrypt;
/* loaded from: classes7.dex */
public enum ErrorBehaviour {
    STRICT(0),
    LENIENT1_CRC(1),
    LENIENT2_ANCILLARY(3),
    SUPER_LENIENT(5);
    

    /* renamed from: c  reason: collision with root package name */
    public final int f36807c;

    ErrorBehaviour(int i2) {
        this.f36807c = i2;
    }
}
