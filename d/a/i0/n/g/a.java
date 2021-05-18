package d.a.i0.n.g;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.baidu.swan.pms.model.PMSAppInfo;
import d.a.i0.n.h.d;
import d.a.i0.n.h.e;
import d.a.i0.n.h.f;
import d.a.i0.n.h.g;
import d.a.i0.n.h.h;
import d.a.i0.n.h.i;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f47809a;

    public static a h() {
        if (f47809a == null) {
            synchronized (a.class) {
                if (f47809a == null) {
                    f47809a = new b();
                }
            }
        }
        return f47809a;
    }

    public abstract boolean a(f fVar, PMSAppInfo pMSAppInfo);

    public abstract boolean b(f fVar, List<g> list, d dVar, d.a.i0.n.h.b bVar, PMSAppInfo pMSAppInfo);

    public abstract void c(String str);

    public abstract void d(String str, String str2);

    public abstract <T extends e> boolean e(Class<T> cls, String str);

    public abstract boolean f(h hVar);

    public abstract boolean g(String str);

    @WorkerThread
    public abstract int i(@NonNull String str);

    @NonNull
    @WorkerThread
    public abstract List<g> j(@NonNull String str, int i2);

    public abstract boolean k(PMSAppInfo pMSAppInfo);

    public abstract <T extends e> boolean l(T t);

    public abstract boolean m(String str, String str2, String str3);

    public abstract List<h> n(int i2);

    public abstract <T extends e> T o(Class<T> cls, String str);

    public abstract Map<String, f> p();

    public abstract List<h> q(String str, String[] strArr);

    @Nullable
    public abstract i r(String str);

    public abstract PMSAppInfo s(String str);

    public abstract Map<String, PMSAppInfo> t();

    public abstract List<h> u(String str);

    public abstract boolean v(h hVar);

    public abstract boolean w(PMSAppInfo pMSAppInfo);

    public abstract boolean x(String str, int i2);
}
