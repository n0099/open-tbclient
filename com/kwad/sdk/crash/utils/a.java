package com.kwad.sdk.crash.utils;

import java.nio.charset.Charset;
/* loaded from: classes5.dex */
public final class a {
    public static final Charset a = Charset.forName("US-ASCII");
    public static final Charset b = Charset.forName("UTF-8");

    public static Charset a(Charset charset) {
        return charset == null ? Charset.defaultCharset() : charset;
    }
}
