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
    public static final Map<String, b> f40201d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    public static final Object f40202e = new Object();

    /* renamed from: f  reason: collision with root package name */
    public static DateFormat f40203f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.CHINESE);

    /* renamed from: a  reason: collision with root package name */
    public LinkedList<a> f40204a = new LinkedList<>();

    /* renamed from: b  reason: collision with root package name */
    public String f40205b;

    /* renamed from: c  reason: collision with root package name */
    public long f40206c;

    public b(String str) {
        this.f40205b = str;
    }

    public static b c() {
        return d("plugin_load");
    }

    public static b d(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "Default";
        }
        if (!f40201d.containsKey(str)) {
            synchronized (f40202e) {
                if (!f40201d.containsKey(str)) {
                    b bVar = new b(str);
                    f40201d.put(str, bVar);
                    return bVar;
                }
            }
        }
        return f40201d.get(str);
    }

    public static void e(String str, String str2) {
        c().f(str, str2);
    }

    public final void a() {
        while (this.f40204a.size() >= 70) {
            this.f40204a.poll();
        }
    }

    public final void b() {
        if (this.f40206c == 0) {
            this.f40206c = System.currentTimeMillis();
        }
    }

    public void f(String str, String str2) {
        b();
        a();
        this.f40204a.add(new a(str, str2));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("trace_" + this.f40205b + "{begin@" + f40203f.format(new Date(this.f40206c)) + "->");
        for (int i2 = 0; i2 < this.f40204a.size(); i2++) {
            a aVar = this.f40204a.get(i2);
            sb.append(String.format("%s(%s)@%s", aVar.f40207a, aVar.f40208b, f40203f.format(new Date(aVar.f40209c))));
            if (i2 < this.f40204a.size() - 1) {
                sb.append("->");
            }
        }
        sb.append("->end}");
        return sb.toString();
    }

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f40207a;

        /* renamed from: b  reason: collision with root package name */
        public String f40208b;

        /* renamed from: c  reason: collision with root package name */
        public long f40209c;

        public a(String str, String str2, long j) {
            this.f40207a = str;
            this.f40208b = str2;
            this.f40209c = j;
        }

        public a(String str, String str2) {
            this(str, str2, System.currentTimeMillis());
        }
    }
}
