package d.b.i0.o;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.UrlManager;
import d.b.b.e.m.e;
import d.b.b.e.p.l;
import d.b.i0.r2.j;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;
/* loaded from: classes4.dex */
public final class a implements j {

    /* renamed from: d  reason: collision with root package name */
    public static final Pattern f57159d = Pattern.compile(UrlManager.patternText, 2);

    /* renamed from: e  reason: collision with root package name */
    public static a f57160e = new a();

    /* renamed from: a  reason: collision with root package name */
    public final List<j.a> f57161a = new LinkedList();

    /* renamed from: b  reason: collision with root package name */
    public final ConcurrentHashMap<String, j.b> f57162b = new ConcurrentHashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public j.c f57163c = null;

    /* renamed from: d.b.i0.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class RunnableC1360a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j.a f57164e;

        public RunnableC1360a(j.a aVar) {
            this.f57164e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f(this.f57164e);
        }
    }

    public static a l() {
        return f57160e;
    }

    @Override // d.b.i0.r2.j
    public boolean a(String str) {
        return f57159d.matcher(str).find();
    }

    @Override // d.b.i0.r2.j
    public void b(Context context, String[] strArr, boolean z, Bundle bundle) {
        h(context, strArr, false, null, z, bundle);
    }

    @Override // d.b.i0.r2.j
    public boolean c(Context context, String[] strArr, Bundle bundle) {
        return h(context, strArr, false, null, false, bundle);
    }

    public void e(j.a aVar) {
        if (l.B()) {
            f(aVar);
        } else {
            e.a().post(new RunnableC1360a(aVar));
        }
    }

    public final void f(j.a aVar) {
        if (this.f57161a.contains(aVar)) {
            return;
        }
        this.f57161a.add(aVar);
    }

    public boolean g(Context context, String str, String[] strArr, boolean z, j.d dVar, boolean z2, Bundle bundle) {
        boolean z3;
        if (strArr == null || strArr.length == 0 || TextUtils.isEmpty(strArr[0])) {
            return false;
        }
        String str2 = strArr[0];
        j.b bVar = this.f57162b.get(m(str2));
        if (bVar != null) {
            bVar.a(context, j(k(str2)));
            return true;
        }
        Iterator<j.a> it = this.f57161a.iterator();
        while (true) {
            if (!it.hasNext()) {
                z3 = false;
                break;
            }
            j.a next = it.next();
            if (next != null && next.a(context, strArr) != 3) {
                z3 = true;
                break;
            }
        }
        if (!z3 && this.f57163c != null) {
            if (str2.contains("nohead:url") || str2.contains("booktown") || str2.contains("bookreader")) {
                return true;
            }
            n(context, str, strArr[0], z, dVar, z2, bundle);
        }
        return z3;
    }

    public boolean h(Context context, String[] strArr, boolean z, j.d dVar, boolean z2, Bundle bundle) {
        return g(context, "", strArr, z, dVar, z2, bundle);
    }

    public int i(Context context, String[] strArr) {
        int a2;
        if (strArr != null && strArr.length != 0) {
            for (j.a aVar : this.f57161a) {
                if (aVar != null && (a2 = aVar.a(context, strArr)) != 3) {
                    return a2;
                }
            }
        }
        return 3;
    }

    public final Map<String, String> j(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        HashMap hashMap = new HashMap();
        String[] split = str.split("[&]");
        if (split == null) {
            hashMap.put(UrlManager.DEFAULT_PARAM, str);
            return hashMap;
        }
        for (String str2 : split) {
            String[] split2 = str2.split("[=]");
            if (split2.length > 1) {
                hashMap.put(split2[0], split2[1]);
            }
        }
        return hashMap;
    }

    public final String k(String str) {
        int lastIndexOf;
        if (!StringUtils.isNull(str) && (lastIndexOf = str.lastIndexOf(":")) >= 0) {
            return str.substring(lastIndexOf + 1);
        }
        return null;
    }

    public final String m(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        return str.contains(":") ? str.substring(0, str.lastIndexOf(":")) : str;
    }

    public final void n(Context context, String str, String str2, boolean z, j.d dVar, boolean z2, Bundle bundle) {
        if (f57159d.matcher(str2).find()) {
            this.f57163c.a(context, str, str2, z, dVar, z2, bundle);
        }
    }

    public void o(j.c cVar) {
        this.f57163c = cVar;
    }
}
