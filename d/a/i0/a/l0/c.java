package d.a.i0.a.l0;

import com.baidu.searchbox.unitedscheme.TypedCallbackHandler;
import com.baidu.searchbox.v8engine.JSExceptionType;
import com.baidu.searchbox.v8engine.JSRuntime;
import com.baidu.searchbox.v8engine.JsSerializeValue;
import com.baidu.searchbox.v8engine.event.EventTarget;
/* loaded from: classes2.dex */
public interface c extends JSRuntime, d.a.i0.a.h0.f.a, TypedCallbackHandler {
    d.a.i0.a.l0.k.a A();

    JsSerializeValue C(byte[] bArr, boolean z);

    byte[] N(JsSerializeValue jsSerializeValue, boolean z);

    void b0(String str, String str2);

    d.a.i0.a.l0.l.b e0();

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

    EventTarget z();
}
