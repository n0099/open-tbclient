package d.b.g0.g.i.l;

import com.baidu.searchbox.v8engine.V8Engine;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public V8Engine f48190a;

    public b(V8Engine v8Engine) {
        this.f48190a = v8Engine;
    }

    public void a() {
        this.f48190a.destroyOpenDataContext();
    }

    public void b(String str, String str2) {
        this.f48190a.requireJSFileForOpenData(str, str2);
    }
}
