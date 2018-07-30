package com.davemorrissey.labs.subscaleview.decoder;
/* loaded from: classes2.dex */
public interface DecoderFactory<T> {
    T make() throws IllegalAccessException, InstantiationException;
}
