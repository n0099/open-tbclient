package d.a.i0.a.l0.l;

import com.baidu.searchbox.v8engine.V8Engine;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public V8Engine f43148a;

    public b(V8Engine v8Engine) {
        this.f43148a = v8Engine;
    }

    public void a() {
        this.f43148a.destroyOpenDataContext();
    }

    public void b(String str, String str2) {
        this.f43148a.requireJSFileForOpenData(str, str2);
    }
}
