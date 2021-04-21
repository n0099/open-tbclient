package d.b.h0.a.j0.i;

import com.baidu.webkit.sdk.ZeusWebViewPreloadClass;
import com.facebook.common.internal.Sets;
import d.b.h0.a.j0.i.a;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final Set<String> f45545a = Sets.newHashSet(ZeusWebViewPreloadClass.ZEUS_FILE_DIR);

    /* renamed from: b  reason: collision with root package name */
    public static final Set<String> f45546b = new HashSet(f45545a);

    /* renamed from: c  reason: collision with root package name */
    public static final Set<String> f45547c = new HashSet(f45546b);

    /* renamed from: d  reason: collision with root package name */
    public static final Map<String, a> f45548d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    public static boolean f45549e = false;

    public static a a(String str) {
        c();
        return f45548d.get(str);
    }

    public static a b() {
        a.b bVar = new a.b();
        bVar.d(ZeusWebViewPreloadClass.ZEUS_FILE_DIR);
        bVar.e(d.b.h0.a.w0.a.b0().a());
        bVar.b(d.b.h0.a.w0.a.b0().b());
        return bVar.a();
    }

    public static void c() {
        if (!f45549e) {
            for (String str : f45547c) {
                if (ZeusWebViewPreloadClass.ZEUS_FILE_DIR.equals(str)) {
                    f45548d.put(str, b());
                }
            }
        }
        f45549e = true;
    }
}
