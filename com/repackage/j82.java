package com.repackage;

import com.baidu.searchbox.unitedscheme.TypedCallbackHandler;
import com.baidu.searchbox.v8engine.JSExceptionType;
import com.baidu.searchbox.v8engine.JSRuntime;
import com.baidu.searchbox.v8engine.JsSerializeValue;
import com.baidu.searchbox.v8engine.event.EventTarget;
import com.baidu.searchbox.v8engine.event.JSEvent;
/* loaded from: classes6.dex */
public interface j82 extends JSRuntime, xz1, TypedCallbackHandler {
    JsSerializeValue A(byte[] bArr, boolean z);

    byte[] I(JsSerializeValue jsSerializeValue, boolean z);

    void Z(String str, String str2);

    w82 d0();

    boolean dispatchEvent(JSEvent jSEvent);

    String getInitBasePath();

    int getInvokeSourceType();

    EventTarget m();

    boolean post(Runnable runnable);

    @Override // com.baidu.searchbox.v8engine.JSRuntime
    void postOnJSThread(Runnable runnable);

    @Override // com.baidu.searchbox.v8engine.JSRuntime
    void runOnJSThread(Runnable runnable);

    void setPreferredFramesPerSecond(short s);

    void throwJSException(JSExceptionType jSExceptionType, String str);

    EventTarget w();

    s82 x();
}
