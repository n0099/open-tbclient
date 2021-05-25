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
    public static final Map<String, b> f39110d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    public static final Object f39111e = new Object();

    /* renamed from: f  reason: collision with root package name */
    public static DateFormat f39112f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.CHINESE);

    /* renamed from: a  reason: collision with root package name */
    public LinkedList<a> f39113a = new LinkedList<>();

    /* renamed from: b  reason: collision with root package name */
    public String f39114b;

    /* renamed from: c  reason: collision with root package name */
    public long f39115c;

    public b(String str) {
        this.f39114b = str;
    }

    public static b c() {
        return d("plugin_load");
    }

    public static b d(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "Default";
        }
        if (!f39110d.containsKey(str)) {
            synchronized (f39111e) {
                if (!f39110d.containsKey(str)) {
                    b bVar = new b(str);
                    f39110d.put(str, bVar);
                    return bVar;
                }
            }
        }
        return f39110d.get(str);
    }

    public static void e(String str, String str2) {
        c().f(str, str2);
    }

    public final void a() {
        while (this.f39113a.size() >= 70) {
            this.f39113a.poll();
        }
    }

    public final void b() {
        if (this.f39115c == 0) {
            this.f39115c = System.currentTimeMillis();
        }
    }

    public void f(String str, String str2) {
        b();
        a();
        this.f39113a.add(new a(str, str2));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("trace_" + this.f39114b + "{begin@" + f39112f.format(new Date(this.f39115c)) + "->");
        for (int i2 = 0; i2 < this.f39113a.size(); i2++) {
            a aVar = this.f39113a.get(i2);
            sb.append(String.format("%s(%s)@%s", aVar.f39116a, aVar.f39117b, f39112f.format(new Date(aVar.f39118c))));
            if (i2 < this.f39113a.size() - 1) {
                sb.append("->");
            }
        }
        sb.append("->end}");
        return sb.toString();
    }

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f39116a;

        /* renamed from: b  reason: collision with root package name */
        public String f39117b;

        /* renamed from: c  reason: collision with root package name */
        public long f39118c;

        public a(String str, String str2, long j) {
            this.f39116a = str;
            this.f39117b = str2;
            this.f39118c = j;
        }

        public a(String str, String str2) {
            this(str, str2, System.currentTimeMillis());
        }
    }
}
