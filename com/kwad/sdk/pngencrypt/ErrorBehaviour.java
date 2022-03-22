package com.kwad.sdk.pngencrypt;
/* loaded from: classes7.dex */
public enum ErrorBehaviour {
    STRICT(0),
    LENIENT1_CRC(1),
    LENIENT2_ANCILLARY(3),
    SUPER_LENIENT(5);
    

    /* renamed from: c  reason: collision with root package name */
    public final int f40604c;

    ErrorBehaviour(int i) {
        this.f40604c = i;
    }
}
