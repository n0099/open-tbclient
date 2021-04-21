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
    public static final Map<String, b> f42980d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    public static final Object f42981e = new Object();

    /* renamed from: f  reason: collision with root package name */
    public static DateFormat f42982f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.CHINESE);

    /* renamed from: a  reason: collision with root package name */
    public LinkedList<a> f42983a = new LinkedList<>();

    /* renamed from: b  reason: collision with root package name */
    public String f42984b;

    /* renamed from: c  reason: collision with root package name */
    public long f42985c;

    public b(String str) {
        this.f42984b = str;
    }

    public static b c() {
        return d("plugin_load");
    }

    public static b d(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "Default";
        }
        if (!f42980d.containsKey(str)) {
            synchronized (f42981e) {
                if (!f42980d.containsKey(str)) {
                    b bVar = new b(str);
                    f42980d.put(str, bVar);
                    return bVar;
                }
            }
        }
        return f42980d.get(str);
    }

    public static void e(String str, String str2) {
        c().f(str, str2);
    }

    public final void a() {
        while (this.f42983a.size() >= 70) {
            this.f42983a.poll();
        }
    }

    public final void b() {
        if (this.f42985c == 0) {
            this.f42985c = System.currentTimeMillis();
        }
    }

    public void f(String str, String str2) {
        b();
        a();
        this.f42983a.add(new a(str, str2));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("trace_" + this.f42984b + "{begin@" + f42982f.format(new Date(this.f42985c)) + "->");
        for (int i = 0; i < this.f42983a.size(); i++) {
            a aVar = this.f42983a.get(i);
            sb.append(String.format("%s(%s)@%s", aVar.f42986a, aVar.f42987b, f42982f.format(new Date(aVar.f42988c))));
            if (i < this.f42983a.size() - 1) {
                sb.append("->");
            }
        }
        sb.append("->end}");
        return sb.toString();
    }

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f42986a;

        /* renamed from: b  reason: collision with root package name */
        public String f42987b;

        /* renamed from: c  reason: collision with root package name */
        public long f42988c;

        public a(String str, String str2, long j) {
            this.f42986a = str;
            this.f42987b = str2;
            this.f42988c = j;
        }

        public a(String str, String str2) {
            this(str, str2, System.currentTimeMillis());
        }
    }
}
