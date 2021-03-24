package d.b.g0.g.i.k;

import com.baidu.searchbox.v8engine.V8Engine;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public V8Engine f48179a;

    public a(V8Engine v8Engine) {
        this.f48179a = v8Engine;
    }

    public void a(String str) {
        c(4, str);
    }

    public void b(String str) {
        c(1, str);
    }

    public final void c(int i, String str) {
        this.f48179a.onConsoleCallBack(i, str);
    }
}
