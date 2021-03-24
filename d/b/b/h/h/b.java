package d.b.b.h.h;

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
    public static final Map<String, b> f42242d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    public static final Object f42243e = new Object();

    /* renamed from: f  reason: collision with root package name */
    public static DateFormat f42244f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.CHINESE);

    /* renamed from: a  reason: collision with root package name */
    public LinkedList<a> f42245a = new LinkedList<>();

    /* renamed from: b  reason: collision with root package name */
    public String f42246b;

    /* renamed from: c  reason: collision with root package name */
    public long f42247c;

    public b(String str) {
        this.f42246b = str;
    }

    public static b c() {
        return d("plugin_load");
    }

    public static b d(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "Default";
        }
        if (!f42242d.containsKey(str)) {
            synchronized (f42243e) {
                if (!f42242d.containsKey(str)) {
                    b bVar = new b(str);
                    f42242d.put(str, bVar);
                    return bVar;
                }
            }
        }
        return f42242d.get(str);
    }

    public static void e(String str, String str2) {
        c().f(str, str2);
    }

    public final void a() {
        while (this.f42245a.size() >= 70) {
            this.f42245a.poll();
        }
    }

    public final void b() {
        if (this.f42247c == 0) {
            this.f42247c = System.currentTimeMillis();
        }
    }

    public void f(String str, String str2) {
        b();
        a();
        this.f42245a.add(new a(str, str2));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("trace_" + this.f42246b + "{begin@" + f42244f.format(new Date(this.f42247c)) + "->");
        for (int i = 0; i < this.f42245a.size(); i++) {
            a aVar = this.f42245a.get(i);
            sb.append(String.format("%s(%s)@%s", aVar.f42248a, aVar.f42249b, f42244f.format(new Date(aVar.f42250c))));
            if (i < this.f42245a.size() - 1) {
                sb.append("->");
            }
        }
        sb.append("->end}");
        return sb.toString();
    }

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f42248a;

        /* renamed from: b  reason: collision with root package name */
        public String f42249b;

        /* renamed from: c  reason: collision with root package name */
        public long f42250c;

        public a(String str, String str2, long j) {
            this.f42248a = str;
            this.f42249b = str2;
            this.f42250c = j;
        }

        public a(String str, String str2) {
            this(str, str2, System.currentTimeMillis());
        }
    }
}
