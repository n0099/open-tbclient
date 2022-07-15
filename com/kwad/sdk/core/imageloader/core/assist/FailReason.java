package com.kwad.sdk.core.imageloader.core.assist;
/* loaded from: classes5.dex */
public class FailReason {
    public final Throwable cause;
    public final FailType type;

    /* loaded from: classes5.dex */
    public enum FailType {
        IO_ERROR,
        DECODING_ERROR,
        NETWORK_DENIED,
        OUT_OF_MEMORY,
        UNKNOWN
    }

    public FailReason(FailType failType, Throwable th) {
        this.type = failType;
        this.cause = th;
    }

    public Throwable getCause() {
        return this.cause;
    }

    public FailType getType() {
        return this.type;
    }

    public String toString() {
        return "FailReason{type=" + this.type + ", cause=" + this.cause + '}';
    }
}
