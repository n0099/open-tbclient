package d.b.g0.a.j0.i;

import com.baidu.webkit.sdk.ZeusWebViewPreloadClass;
import com.facebook.common.internal.Sets;
import d.b.g0.a.j0.i.a;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final Set<String> f45216a = Sets.newHashSet(ZeusWebViewPreloadClass.ZEUS_FILE_DIR);

    /* renamed from: b  reason: collision with root package name */
    public static final Set<String> f45217b = new HashSet(f45216a);

    /* renamed from: c  reason: collision with root package name */
    public static final Set<String> f45218c = new HashSet(f45217b);

    /* renamed from: d  reason: collision with root package name */
    public static final Map<String, a> f45219d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    public static boolean f45220e = false;

    public static a a(String str) {
        c();
        return f45219d.get(str);
    }

    public static a b() {
        a.b bVar = new a.b();
        bVar.d(ZeusWebViewPreloadClass.ZEUS_FILE_DIR);
        bVar.e(d.b.g0.a.w0.a.b0().a());
        bVar.b(d.b.g0.a.w0.a.b0().b());
        return bVar.a();
    }

    public static void c() {
        if (!f45220e) {
            for (String str : f45218c) {
                if (ZeusWebViewPreloadClass.ZEUS_FILE_DIR.equals(str)) {
                    f45219d.put(str, b());
                }
            }
        }
        f45220e = true;
    }
}
