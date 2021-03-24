package d.b.g0.g.i;

import com.baidu.searchbox.unitedscheme.TypedCallbackHandler;
import com.baidu.searchbox.v8engine.JSExceptionType;
import com.baidu.searchbox.v8engine.JSRuntime;
import com.baidu.searchbox.v8engine.JsSerializeValue;
import com.baidu.searchbox.v8engine.event.EventTarget;
/* loaded from: classes3.dex */
public interface b extends JSRuntime, d.b.g0.a.e0.k.a, TypedCallbackHandler {
    void N(String str, String str2);

    d.b.g0.g.i.l.b V();

    EventTarget Z();

    d.b.g0.g.i.k.a a0();

    JsSerializeValue d0(byte[] bArr, boolean z);

    String getInitBasePath();

    boolean post(Runnable runnable);

    @Override // com.baidu.searchbox.v8engine.JSRuntime
    void postOnJSThread(Runnable runnable);

    @Override // com.baidu.searchbox.v8engine.JSRuntime
    void runOnJSThread(Runnable runnable);

    void setPreferredFramesPerSecond(short s);

    EventTarget t();

    void throwJSException(JSExceptionType jSExceptionType, String str);

    byte[] y(JsSerializeValue jsSerializeValue, boolean z);
}
