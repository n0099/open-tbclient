package d.b.g0.l.i;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.baidu.swan.pms.model.PMSAppInfo;
import d.b.g0.l.k.d;
import d.b.g0.l.k.e;
import d.b.g0.l.k.f;
import d.b.g0.l.k.g;
import d.b.g0.l.k.h;
import d.b.g0.l.k.i;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f48890a;

    public static a h() {
        if (f48890a == null) {
            synchronized (a.class) {
                if (f48890a == null) {
                    f48890a = new b();
                }
            }
        }
        return f48890a;
    }

    public abstract boolean a(f fVar, PMSAppInfo pMSAppInfo);

    public abstract boolean b(f fVar, List<g> list, d dVar, d.b.g0.l.k.b bVar, PMSAppInfo pMSAppInfo);

    public abstract void c(String str);

    public abstract void d(String str, String str2);

    public abstract <T extends e> boolean e(Class<T> cls, String str);

    public abstract boolean f(h hVar);

    public abstract boolean g(String str);

    @WorkerThread
    public abstract int i(@NonNull String str);

    @NonNull
    @WorkerThread
    public abstract List<g> j(@NonNull String str, int i);

    public abstract boolean k(PMSAppInfo pMSAppInfo);

    public abstract <T extends e> boolean l(T t);

    public abstract boolean m(String str, String str2, String str3);

    public abstract <T extends e> T n(Class<T> cls, String str);

    public abstract Map<String, f> o();

    public abstract h p(String str, String str2);

    @Nullable
    public abstract i q(String str);

    public abstract PMSAppInfo r(String str);

    public abstract Map<String, PMSAppInfo> s();

    public abstract boolean t(h hVar);

    public abstract boolean u(PMSAppInfo pMSAppInfo);

    public abstract boolean v(String str, int i);
}
