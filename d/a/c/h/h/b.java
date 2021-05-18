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
    public static final Map<String, b> f39446d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    public static final Object f39447e = new Object();

    /* renamed from: f  reason: collision with root package name */
    public static DateFormat f39448f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.CHINESE);

    /* renamed from: a  reason: collision with root package name */
    public LinkedList<a> f39449a = new LinkedList<>();

    /* renamed from: b  reason: collision with root package name */
    public String f39450b;

    /* renamed from: c  reason: collision with root package name */
    public long f39451c;

    public b(String str) {
        this.f39450b = str;
    }

    public static b c() {
        return d("plugin_load");
    }

    public static b d(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "Default";
        }
        if (!f39446d.containsKey(str)) {
            synchronized (f39447e) {
                if (!f39446d.containsKey(str)) {
                    b bVar = new b(str);
                    f39446d.put(str, bVar);
                    return bVar;
                }
            }
        }
        return f39446d.get(str);
    }

    public static void e(String str, String str2) {
        c().f(str, str2);
    }

    public final void a() {
        while (this.f39449a.size() >= 70) {
            this.f39449a.poll();
        }
    }

    public final void b() {
        if (this.f39451c == 0) {
            this.f39451c = System.currentTimeMillis();
        }
    }

    public void f(String str, String str2) {
        b();
        a();
        this.f39449a.add(new a(str, str2));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("trace_" + this.f39450b + "{begin@" + f39448f.format(new Date(this.f39451c)) + "->");
        for (int i2 = 0; i2 < this.f39449a.size(); i2++) {
            a aVar = this.f39449a.get(i2);
            sb.append(String.format("%s(%s)@%s", aVar.f39452a, aVar.f39453b, f39448f.format(new Date(aVar.f39454c))));
            if (i2 < this.f39449a.size() - 1) {
                sb.append("->");
            }
        }
        sb.append("->end}");
        return sb.toString();
    }

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f39452a;

        /* renamed from: b  reason: collision with root package name */
        public String f39453b;

        /* renamed from: c  reason: collision with root package name */
        public long f39454c;

        public a(String str, String str2, long j) {
            this.f39452a = str;
            this.f39453b = str2;
            this.f39454c = j;
        }

        public a(String str, String str2) {
            this(str, str2, System.currentTimeMillis());
        }
    }
}
