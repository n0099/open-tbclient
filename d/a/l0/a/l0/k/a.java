package d.a.l0.a.l0.k;

import com.baidu.searchbox.v8engine.V8Engine;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public V8Engine f46988a;

    public a(V8Engine v8Engine) {
        this.f46988a = v8Engine;
    }

    public void a(String str) {
        c(4, str);
    }

    public void b(String str) {
        c(1, str);
    }

    public final void c(int i2, String str) {
        this.f46988a.onConsoleCallBack(i2, str);
    }
}
