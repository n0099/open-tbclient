package d.a.m0.a.l0.l;

import com.baidu.searchbox.v8engine.V8Engine;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public V8Engine f47106a;

    public b(V8Engine v8Engine) {
        this.f47106a = v8Engine;
    }

    public void a() {
        this.f47106a.destroyOpenDataContext();
    }

    public void b(String str, String str2) {
        this.f47106a.requireJSFileForOpenData(str, str2);
    }
}
