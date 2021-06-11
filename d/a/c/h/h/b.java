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
    public static final Map<String, b> f42763d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    public static final Object f42764e = new Object();

    /* renamed from: f  reason: collision with root package name */
    public static DateFormat f42765f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.CHINESE);

    /* renamed from: a  reason: collision with root package name */
    public LinkedList<a> f42766a = new LinkedList<>();

    /* renamed from: b  reason: collision with root package name */
    public String f42767b;

    /* renamed from: c  reason: collision with root package name */
    public long f42768c;

    public b(String str) {
        this.f42767b = str;
    }

    public static b c() {
        return d("plugin_load");
    }

    public static b d(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "Default";
        }
        if (!f42763d.containsKey(str)) {
            synchronized (f42764e) {
                if (!f42763d.containsKey(str)) {
                    b bVar = new b(str);
                    f42763d.put(str, bVar);
                    return bVar;
                }
            }
        }
        return f42763d.get(str);
    }

    public static void e(String str, String str2) {
        c().f(str, str2);
    }

    public final void a() {
        while (this.f42766a.size() >= 70) {
            this.f42766a.poll();
        }
    }

    public final void b() {
        if (this.f42768c == 0) {
            this.f42768c = System.currentTimeMillis();
        }
    }

    public void f(String str, String str2) {
        b();
        a();
        this.f42766a.add(new a(str, str2));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("trace_" + this.f42767b + "{begin@" + f42765f.format(new Date(this.f42768c)) + "->");
        for (int i2 = 0; i2 < this.f42766a.size(); i2++) {
            a aVar = this.f42766a.get(i2);
            sb.append(String.format("%s(%s)@%s", aVar.f42769a, aVar.f42770b, f42765f.format(new Date(aVar.f42771c))));
            if (i2 < this.f42766a.size() - 1) {
                sb.append("->");
            }
        }
        sb.append("->end}");
        return sb.toString();
    }

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f42769a;

        /* renamed from: b  reason: collision with root package name */
        public String f42770b;

        /* renamed from: c  reason: collision with root package name */
        public long f42771c;

        public a(String str, String str2, long j) {
            this.f42769a = str;
            this.f42770b = str2;
            this.f42771c = j;
        }

        public a(String str, String str2) {
            this(str, str2, System.currentTimeMillis());
        }
    }
}
