package com.repackage;

import com.baidu.searchbox.unitedscheme.TypedCallbackHandler;
import com.baidu.searchbox.v8engine.JSExceptionType;
import com.baidu.searchbox.v8engine.JSRuntime;
import com.baidu.searchbox.v8engine.JsSerializeValue;
import com.baidu.searchbox.v8engine.event.EventTarget;
import com.baidu.searchbox.v8engine.event.JSEvent;
/* loaded from: classes5.dex */
public interface e82 extends JSRuntime, sz1, TypedCallbackHandler {
    n82 A();

    JsSerializeValue D(byte[] bArr, boolean z);

    byte[] O(JsSerializeValue jsSerializeValue, boolean z);

    void a0(String str, String str2);

    boolean dispatchEvent(JSEvent jSEvent);

    r82 g0();

    String getInitBasePath();

    int getInvokeSourceType();

    EventTarget p();

    boolean post(Runnable runnable);

    @Override // com.baidu.searchbox.v8engine.JSRuntime
    void postOnJSThread(Runnable runnable);

    @Override // com.baidu.searchbox.v8engine.JSRuntime
    void runOnJSThread(Runnable runnable);

    void setPreferredFramesPerSecond(short s);

    void throwJSException(JSExceptionType jSExceptionType, String str);

    EventTarget x();
}
