package d.b.g0.g.i.l;

import com.baidu.searchbox.v8engine.V8Engine;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public V8Engine f48582a;

    public b(V8Engine v8Engine) {
        this.f48582a = v8Engine;
    }

    public void a() {
        this.f48582a.destroyOpenDataContext();
    }

    public void b(String str, String str2) {
        this.f48582a.requireJSFileForOpenData(str, str2);
    }
}
