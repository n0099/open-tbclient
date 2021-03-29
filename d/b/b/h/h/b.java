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
    public static final Map<String, b> f42243d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    public static final Object f42244e = new Object();

    /* renamed from: f  reason: collision with root package name */
    public static DateFormat f42245f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.CHINESE);

    /* renamed from: a  reason: collision with root package name */
    public LinkedList<a> f42246a = new LinkedList<>();

    /* renamed from: b  reason: collision with root package name */
    public String f42247b;

    /* renamed from: c  reason: collision with root package name */
    public long f42248c;

    public b(String str) {
        this.f42247b = str;
    }

    public static b c() {
        return d("plugin_load");
    }

    public static b d(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "Default";
        }
        if (!f42243d.containsKey(str)) {
            synchronized (f42244e) {
                if (!f42243d.containsKey(str)) {
                    b bVar = new b(str);
                    f42243d.put(str, bVar);
                    return bVar;
                }
            }
        }
        return f42243d.get(str);
    }

    public static void e(String str, String str2) {
        c().f(str, str2);
    }

    public final void a() {
        while (this.f42246a.size() >= 70) {
            this.f42246a.poll();
        }
    }

    public final void b() {
        if (this.f42248c == 0) {
            this.f42248c = System.currentTimeMillis();
        }
    }

    public void f(String str, String str2) {
        b();
        a();
        this.f42246a.add(new a(str, str2));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("trace_" + this.f42247b + "{begin@" + f42245f.format(new Date(this.f42248c)) + "->");
        for (int i = 0; i < this.f42246a.size(); i++) {
            a aVar = this.f42246a.get(i);
            sb.append(String.format("%s(%s)@%s", aVar.f42249a, aVar.f42250b, f42245f.format(new Date(aVar.f42251c))));
            if (i < this.f42246a.size() - 1) {
                sb.append("->");
            }
        }
        sb.append("->end}");
        return sb.toString();
    }

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f42249a;

        /* renamed from: b  reason: collision with root package name */
        public String f42250b;

        /* renamed from: c  reason: collision with root package name */
        public long f42251c;

        public a(String str, String str2, long j) {
            this.f42249a = str;
            this.f42250b = str2;
            this.f42251c = j;
        }

        public a(String str, String str2) {
            this(str, str2, System.currentTimeMillis());
        }
    }
}
