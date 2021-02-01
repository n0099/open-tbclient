package com.kwad.sdk.crash;
/* loaded from: classes3.dex */
class SdkCaughtException extends RuntimeException {
    public SdkCaughtException() {
    }

    public SdkCaughtException(String str) {
        super(str);
    }

    public SdkCaughtException(String str, Throwable th) {
        super(str, th);
    }

    public SdkCaughtException(Throwable th) {
        super(th);
    }
}
