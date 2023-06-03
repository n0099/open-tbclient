package com.kwad.sdk.core.videocache;
/* loaded from: classes10.dex */
public class ProxyCacheException extends Exception {
    public static final String LIBRARY_VERSION = ". Version: 3.3.26";

    public ProxyCacheException(String str) {
        super(str + LIBRARY_VERSION);
    }

    public ProxyCacheException(String str, Throwable th) {
        super(str + LIBRARY_VERSION, th);
    }

    public ProxyCacheException(Throwable th) {
        super("No explanation error. Version: 3.3.26", th);
    }
}
