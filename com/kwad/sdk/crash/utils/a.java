package com.kwad.sdk.crash.utils;

import java.nio.charset.Charset;
/* loaded from: classes8.dex */
public class a {
    public static Charset a(Charset charset) {
        return charset == null ? Charset.defaultCharset() : charset;
    }
}
