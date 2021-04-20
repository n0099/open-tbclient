package d.b.c.h.h;

import android.text.TextUtils;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;
/* loaded from: classes.dex */
public class b {

    /* renamed from: d  reason: collision with root package name */
    public static final Map<String, b> f42740d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    public static final Object f42741e = new Object();

    /* renamed from: f  reason: collision with root package name */
    public static DateFormat f42742f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.CHINESE);

    /* renamed from: a  reason: collision with root package name */
    public LinkedList<a> f42743a = new LinkedList<>();

    /* renamed from: b  reason: collision with root package name */
    public String f42744b;

    /* renamed from: c  reason: collision with root package name */
    public long f42745c;

    public b(String str) {
        this.f42744b = str;
    }

    public static b c() {
        return d("plugin_load");
    }

    public static b d(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "Default";
        }
        if (!f42740d.containsKey(str)) {
            synchronized (f42741e) {
                if (!f42740d.containsKey(str)) {
                    b bVar = new b(str);
                    f42740d.put(str, bVar);
                    return bVar;
                }
            }
        }
        return f42740d.get(str);
    }

    public static void e(String str, String str2) {
        c().f(str, str2);
    }

    public final void a() {
        while (this.f42743a.size() >= 70) {
            this.f42743a.poll();
        }
    }

    public final void b() {
        if (this.f42745c == 0) {
            this.f42745c = System.currentTimeMillis();
        }
    }

    public void f(String str, String str2) {
        b();
        a();
        this.f42743a.add(new a(str, str2));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("trace_" + this.f42744b + "{begin@" + f42742f.format(new Date(this.f42745c)) + "->");
        for (int i = 0; i < this.f42743a.size(); i++) {
            a aVar = this.f42743a.get(i);
            sb.append(String.format("%s(%s)@%s", aVar.f42746a, aVar.f42747b, f42742f.format(new Date(aVar.f42748c))));
            if (i < this.f42743a.size() - 1) {
                sb.append("->");
            }
        }
        sb.append("->end}");
        return sb.toString();
    }

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f42746a;

        /* renamed from: b  reason: collision with root package name */
        public String f42747b;

        /* renamed from: c  reason: collision with root package name */
        public long f42748c;

        public a(String str, String str2, long j) {
            this.f42746a = str;
            this.f42747b = str2;
            this.f42748c = j;
        }

        public a(String str, String str2) {
            this(str, str2, System.currentTimeMillis());
        }
    }
}
