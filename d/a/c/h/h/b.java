package d.a.c.h.h;

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
    public static final Map<String, b> f42866d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    public static final Object f42867e = new Object();

    /* renamed from: f  reason: collision with root package name */
    public static DateFormat f42868f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.CHINESE);

    /* renamed from: a  reason: collision with root package name */
    public LinkedList<a> f42869a = new LinkedList<>();

    /* renamed from: b  reason: collision with root package name */
    public String f42870b;

    /* renamed from: c  reason: collision with root package name */
    public long f42871c;

    public b(String str) {
        this.f42870b = str;
    }

    public static b c() {
        return d("plugin_load");
    }

    public static b d(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "Default";
        }
        if (!f42866d.containsKey(str)) {
            synchronized (f42867e) {
                if (!f42866d.containsKey(str)) {
                    b bVar = new b(str);
                    f42866d.put(str, bVar);
                    return bVar;
                }
            }
        }
        return f42866d.get(str);
    }

    public static void e(String str, String str2) {
        c().f(str, str2);
    }

    public final void a() {
        while (this.f42869a.size() >= 70) {
            this.f42869a.poll();
        }
    }

    public final void b() {
        if (this.f42871c == 0) {
            this.f42871c = System.currentTimeMillis();
        }
    }

    public void f(String str, String str2) {
        b();
        a();
        this.f42869a.add(new a(str, str2));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("trace_" + this.f42870b + "{begin@" + f42868f.format(new Date(this.f42871c)) + "->");
        for (int i2 = 0; i2 < this.f42869a.size(); i2++) {
            a aVar = this.f42869a.get(i2);
            sb.append(String.format("%s(%s)@%s", aVar.f42872a, aVar.f42873b, f42868f.format(new Date(aVar.f42874c))));
            if (i2 < this.f42869a.size() - 1) {
                sb.append("->");
            }
        }
        sb.append("->end}");
        return sb.toString();
    }

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f42872a;

        /* renamed from: b  reason: collision with root package name */
        public String f42873b;

        /* renamed from: c  reason: collision with root package name */
        public long f42874c;

        public a(String str, String str2, long j) {
            this.f42872a = str;
            this.f42873b = str2;
            this.f42874c = j;
        }

        public a(String str, String str2) {
            this(str, str2, System.currentTimeMillis());
        }
    }
}
