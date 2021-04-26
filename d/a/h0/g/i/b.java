package d.a.h0.g.i;

import com.baidu.searchbox.unitedscheme.TypedCallbackHandler;
import com.baidu.searchbox.v8engine.JSExceptionType;
import com.baidu.searchbox.v8engine.JSRuntime;
import com.baidu.searchbox.v8engine.JsSerializeValue;
import com.baidu.searchbox.v8engine.event.EventTarget;
/* loaded from: classes3.dex */
public interface b extends JSRuntime, d.a.h0.a.e0.k.a, TypedCallbackHandler {
    JsSerializeValue B(byte[] bArr, boolean z);

    byte[] L(JsSerializeValue jsSerializeValue, boolean z);

    void U(String str, String str2);

    d.a.h0.g.i.l.b c0();

    String getInitBasePath();

    EventTarget o();

    boolean post(Runnable runnable);

    @Override // com.baidu.searchbox.v8engine.JSRuntime
    void postOnJSThread(Runnable runnable);

    @Override // com.baidu.searchbox.v8engine.JSRuntime
    void runOnJSThread(Runnable runnable);

    void setPreferredFramesPerSecond(short s);

    void throwJSException(JSExceptionType jSExceptionType, String str);

    EventTarget x();

    d.a.h0.g.i.k.a y();
}
