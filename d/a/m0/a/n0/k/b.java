package d.a.m0.a.n0.k;

import com.baidu.webkit.sdk.ZeusWebViewPreloadClass;
import com.facebook.common.internal.Sets;
import d.a.m0.a.n0.k.a;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final Set<String> f47421a = Sets.newHashSet(ZeusWebViewPreloadClass.ZEUS_FILE_DIR);

    /* renamed from: b  reason: collision with root package name */
    public static final Set<String> f47422b = new HashSet(f47421a);

    /* renamed from: c  reason: collision with root package name */
    public static final Set<String> f47423c = new HashSet(f47422b);

    /* renamed from: d  reason: collision with root package name */
    public static final Map<String, a> f47424d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    public static boolean f47425e = false;

    public static a a(String str) {
        c();
        return f47424d.get(str);
    }

    public static a b() {
        a.b bVar = new a.b();
        bVar.d(ZeusWebViewPreloadClass.ZEUS_FILE_DIR);
        bVar.e(d.a.m0.a.c1.a.n0().a());
        bVar.b(d.a.m0.a.c1.a.n0().d());
        return bVar.a();
    }

    public static void c() {
        if (!f47425e) {
            for (String str : f47423c) {
                if (ZeusWebViewPreloadClass.ZEUS_FILE_DIR.equals(str)) {
                    f47424d.put(str, b());
                }
            }
        }
        f47425e = true;
    }
}
