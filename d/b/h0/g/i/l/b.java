package d.b.h0.g.i.l;

import com.baidu.searchbox.v8engine.V8Engine;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public V8Engine f48911a;

    public b(V8Engine v8Engine) {
        this.f48911a = v8Engine;
    }

    public void a() {
        this.f48911a.destroyOpenDataContext();
    }

    public void b(String str, String str2) {
        this.f48911a.requireJSFileForOpenData(str, str2);
    }
}
