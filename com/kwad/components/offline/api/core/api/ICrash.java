package com.kwad.components.offline.api.core.api;
/* loaded from: classes10.dex */
public interface ICrash {
    void addCustomKeyValue(ICrashCustomKeyValue iCrashCustomKeyValue);

    void addOnCrashListener(ICrashOccurListener iCrashOccurListener);

    void gatherException(Throwable th);
}
