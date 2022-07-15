package com.repackage;

import com.baidu.searchbox.unitedscheme.TypedCallbackHandler;
import com.baidu.searchbox.v8engine.JSExceptionType;
import com.baidu.searchbox.v8engine.JSRuntime;
import com.baidu.searchbox.v8engine.JsSerializeValue;
import com.baidu.searchbox.v8engine.event.EventTarget;
import com.baidu.searchbox.v8engine.event.JSEvent;
/* loaded from: classes7.dex */
public interface r72 extends JSRuntime, fz1, TypedCallbackHandler {
    JsSerializeValue C(byte[] bArr, boolean z);

    byte[] K(JsSerializeValue jsSerializeValue, boolean z);

    void Z(String str, String str2);

    boolean dispatchEvent(JSEvent jSEvent);

    e82 f0();

    String getInitBasePath();

    int getInvokeSourceType();

    EventTarget o();

    boolean post(Runnable runnable);

    @Override // com.baidu.searchbox.v8engine.JSRuntime
    void postOnJSThread(Runnable runnable);

    @Override // com.baidu.searchbox.v8engine.JSRuntime
    void runOnJSThread(Runnable runnable);

    void setPreferredFramesPerSecond(short s);

    void throwJSException(JSExceptionType jSExceptionType, String str);

    EventTarget y();

    a82 z();
}
