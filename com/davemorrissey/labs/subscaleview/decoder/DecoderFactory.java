package com.davemorrissey.labs.subscaleview.decoder;
/* loaded from: classes9.dex */
public interface DecoderFactory<T> {
    T make() throws IllegalAccessException, InstantiationException;
}
