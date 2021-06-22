package d.a.m0.a.h0.m.p;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import com.facebook.common.internal.Sets;
import d.a.m0.a.k;
import d.a.m0.a.v2.e1.c;
import d.a.m0.n.i.m.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f46185a = k.f46983a;

    /* renamed from: b  reason: collision with root package name */
    public static final Set<Integer> f46186b = Sets.newHashSet(0, 1010, 1011, 1012, 1020, 1015);

    /* renamed from: c  reason: collision with root package name */
    public static final Map<String, Long> f46187c = new ConcurrentHashMap();

    /* renamed from: d  reason: collision with root package name */
    public static int f46188d = 1800;

    /* renamed from: e  reason: collision with root package name */
    public static final c<String, String> f46189e = new C0742a();

    /* renamed from: f  reason: collision with root package name */
    public static final c<b.a, String> f46190f = new b();

    /* renamed from: d.a.m0.a.h0.m.p.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0742a implements c<String, String> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.m0.a.v2.e1.c
        public /* bridge */ /* synthetic */ String a(String str) {
            String str2 = str;
            b(str2);
            return str2;
        }

        public String b(String str) {
            return str;
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements c<b.a, String> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.a.v2.e1.c
        /* renamed from: b */
        public String a(b.a aVar) {
            return aVar == null ? "" : aVar.b();
        }
    }

    public static <T> T a(String str, T t) {
        if (f46185a) {
            Log.i("PreDownloadUtils", "Recorded=" + f46187c.size() + " # " + str + " => " + t);
        }
        return t;
    }

    public static boolean b(@NonNull String str) {
        Long l = f46187c.get(str);
        return l == null || System.currentTimeMillis() - l.longValue() > ((long) (f46188d * 1000));
    }

    public static boolean c(String str) {
        return g(str, true);
    }

    public static boolean d(@NonNull String str, @Nullable String str2) {
        if (str2 != null) {
            str = str + str2;
        }
        return c(str);
    }

    public static boolean e(String str) {
        return g(str, false);
    }

    public static boolean f(@Nullable String str, @Nullable String str2) {
        if (str2 != null && str != null) {
            str = str + str2;
        }
        return e(str);
    }

    public static boolean g(@Nullable String str, boolean z) {
        boolean z2;
        String str2 = "shouldDownloadItem app=" + str + " record=" + z + ZeusCrashHandler.NAME_SEPERATOR;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (z) {
            f46187c.put(str, Long.valueOf(System.currentTimeMillis()));
            z2 = true;
        } else {
            z2 = !f46187c.containsKey(str);
        }
        Boolean valueOf = Boolean.valueOf(z2);
        a(str2 + " should", valueOf);
        if (!valueOf.booleanValue()) {
            Boolean valueOf2 = Boolean.valueOf(b(str));
            a(str2 + " AB", valueOf2);
            if (!valueOf2.booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static List<String> h(Collection<String> collection) {
        return j(f46189e, collection);
    }

    public static List<b.a> i(Collection<b.a> collection) {
        return j(f46190f, collection);
    }

    public static <SwanItemT> List<SwanItemT> j(@NonNull c<SwanItemT, String> cVar, Collection<SwanItemT> collection) {
        return k(cVar, collection, false);
    }

    public static <SwanItemT> List<SwanItemT> k(@NonNull c<SwanItemT, String> cVar, Collection<SwanItemT> collection, boolean z) {
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            Iterator<SwanItemT> it = collection.iterator();
            while (it.hasNext()) {
                SwanItemT next = it.next();
                if (g(next == null ? "" : cVar.a(next), z)) {
                    arrayList.add(next);
                }
            }
            a("shouldDownloadSet", "record=" + z + " targets=" + collection.size() + " should=" + arrayList.size());
        }
        return arrayList;
    }

    public static boolean l(int i2) {
        return f46186b.contains(Integer.valueOf(i2));
    }

    public static boolean m(d.a.m0.n.h.a aVar) {
        return aVar != null && l(aVar.f51784a);
    }

    public static boolean n(@Nullable String str) {
        if (str == null) {
            return false;
        }
        Iterator<Map.Entry<String, Long>> it = f46187c.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Long> next = it.next();
            if (next != null && next.getKey() != null && next.getKey().startsWith(str)) {
                it.remove();
            }
        }
        return true;
    }
}
