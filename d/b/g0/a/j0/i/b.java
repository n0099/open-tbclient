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
    public static final Set<String> f44824a = Sets.newHashSet(ZeusWebViewPreloadClass.ZEUS_FILE_DIR);

    /* renamed from: b  reason: collision with root package name */
    public static final Set<String> f44825b = new HashSet(f44824a);

    /* renamed from: c  reason: collision with root package name */
    public static final Set<String> f44826c = new HashSet(f44825b);

    /* renamed from: d  reason: collision with root package name */
    public static final Map<String, a> f44827d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    public static boolean f44828e = false;

    public static a a(String str) {
        c();
        return f44827d.get(str);
    }

    public static a b() {
        a.b bVar = new a.b();
        bVar.d(ZeusWebViewPreloadClass.ZEUS_FILE_DIR);
        bVar.e(d.b.g0.a.w0.a.b0().a());
        bVar.b(d.b.g0.a.w0.a.b0().b());
        return bVar.a();
    }

    public static void c() {
        if (!f44828e) {
            for (String str : f44826c) {
                if (ZeusWebViewPreloadClass.ZEUS_FILE_DIR.equals(str)) {
                    f44827d.put(str, b());
                }
            }
        }
        f44828e = true;
    }
}
