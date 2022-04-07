package com.tachikoma.core.api;
/* loaded from: classes8.dex */
public interface ITKExceptionHandlerInner {
    void handleException(Throwable th, int i);

    void handleJSException(Throwable th, int i);

    void handleJSException(Throwable th, String str, int i);
}
