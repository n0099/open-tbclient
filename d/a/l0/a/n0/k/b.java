package d.a.l0.a.n0.k;

import com.baidu.webkit.sdk.ZeusWebViewPreloadClass;
import com.facebook.common.internal.Sets;
import d.a.l0.a.n0.k.a;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final Set<String> f47313a = Sets.newHashSet(ZeusWebViewPreloadClass.ZEUS_FILE_DIR);

    /* renamed from: b  reason: collision with root package name */
    public static final Set<String> f47314b = new HashSet(f47313a);

    /* renamed from: c  reason: collision with root package name */
    public static final Set<String> f47315c = new HashSet(f47314b);

    /* renamed from: d  reason: collision with root package name */
    public static final Map<String, a> f47316d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    public static boolean f47317e = false;

    public static a a(String str) {
        c();
        return f47316d.get(str);
    }

    public static a b() {
        a.b bVar = new a.b();
        bVar.d(ZeusWebViewPreloadClass.ZEUS_FILE_DIR);
        bVar.e(d.a.l0.a.c1.a.n0().a());
        bVar.b(d.a.l0.a.c1.a.n0().d());
        return bVar.a();
    }

    public static void c() {
        if (!f47317e) {
            for (String str : f47315c) {
                if (ZeusWebViewPreloadClass.ZEUS_FILE_DIR.equals(str)) {
                    f47316d.put(str, b());
                }
            }
        }
        f47317e = true;
    }
}
