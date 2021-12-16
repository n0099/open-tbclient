package com.tachikoma.core.api;
/* loaded from: classes3.dex */
public interface ITKExceptionHandlerInner {
    void handleException(Throwable th, int i2);

    void handleJSException(Throwable th, int i2);

    void handleJSException(Throwable th, String str, int i2);
}
