package com.kwad.sdk.api.loader;
/* loaded from: classes5.dex */
public final class SecurityChecker {
    public static volatile State a;

    /* loaded from: classes5.dex */
    public enum State {
        INIT,
        DATA_VALID,
        MD5,
        SUCCESS
    }

    /* loaded from: classes5.dex */
    public interface a {
        void a(boolean z, State state);
    }
}
