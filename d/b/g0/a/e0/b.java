package d.b.g0.a.e0;

import android.text.TextUtils;
import android.util.Log;
import d.b.g0.a.i2.p;
import d.b.g0.a.k;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f44254a = k.f45443a;

    /* loaded from: classes2.dex */
    public static class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f44255e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ File f44256f;

        public a(String str, File file) {
            this.f44255e = str;
            this.f44256f = file;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (b.class) {
                d.b.g0.p.d.D(this.f44255e, this.f44256f, true);
            }
            b.c();
        }
    }

    /* renamed from: d.b.g0.a.e0.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0657b implements Comparator<Long> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(Long l, Long l2) {
            return l2.compareTo(l);
        }
    }

    public static File b(long j) {
        String f2 = f();
        if (f2 == null) {
            return null;
        }
        File file = new File(f2 + File.separator + j);
        if (file.exists()) {
            d.b.g0.p.d.w(file);
        }
        d.b.g0.p.d.e(file);
        return file;
    }

    public static void c() {
        d.b.g0.a.r1.e O = d.b.g0.a.r1.e.O();
        if (O == null || TextUtils.isEmpty(O.getAppId())) {
            return;
        }
        File file = new File(d.b.g0.a.u0.d.d().getPath() + File.separator + "launch_tips");
        if (file.exists() && file.isDirectory()) {
            d.b.g0.p.d.f(file);
        }
    }

    public static File d(long j) {
        File[] g2 = g();
        if (g2 != null && g2.length != 0) {
            File file = null;
            for (File file2 : g2) {
                try {
                    long parseLong = Long.parseLong(file2.getName());
                    if (parseLong == j) {
                        file = file2;
                    } else if (j - parseLong >= 259200000) {
                        d.b.g0.p.d.f(file2);
                    }
                } catch (NumberFormatException unused) {
                    d.b.g0.p.d.f(file2);
                }
            }
            return file == null ? b(j) : file;
        }
        return b(j);
    }

    public static String e() {
        File[] g2 = g();
        if (g2 == null) {
            return null;
        }
        TreeMap treeMap = new TreeMap(new C0657b());
        long i = i(System.currentTimeMillis());
        for (File file : g2) {
            try {
                long parseLong = Long.parseLong(file.getName());
                if (i - parseLong >= 259200000) {
                    d.b.g0.p.d.f(file);
                } else {
                    List<String> s = d.b.g0.p.d.s(file);
                    if (s != null && s.size() > 0) {
                        treeMap.put(Long.valueOf(parseLong), s);
                    }
                }
            } catch (NumberFormatException unused) {
                d.b.g0.p.d.f(file);
            }
        }
        if (treeMap.size() == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder("（二）历史日志\n");
        for (Map.Entry entry : treeMap.entrySet()) {
            sb.append("「");
            sb.append(new SimpleDateFormat("yyyy-MM-dd").format(new Date(((Long) entry.getKey()).longValue())));
            sb.append("」\n");
            for (String str : (List) entry.getValue()) {
                sb.append(str);
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public static String f() {
        d.b.g0.a.r1.e O = d.b.g0.a.r1.e.O();
        if (O == null) {
            return null;
        }
        String appId = O.getAppId();
        if (TextUtils.isEmpty(appId)) {
            return null;
        }
        return d.b.g0.a.u0.d.d().getPath() + File.separator + "launch_tips_v2" + File.separator + appId;
    }

    public static File[] g() {
        String f2 = f();
        if (f2 == null) {
            return null;
        }
        File file = new File(f2);
        if (file.exists() && file.isDirectory()) {
            return file.listFiles();
        }
        return null;
    }

    public static void h(long j, String str) {
        long i = i(j);
        if (i == -1) {
            if (f44254a) {
                Log.e("LaunchTipsFileHelper", "get timestampByDay failed");
                return;
            }
            return;
        }
        File d2 = d(i);
        if (d2 == null || !d2.exists()) {
            return;
        }
        p.k(new a(str, d2), "saveLaunchTipsLog");
    }

    public static long i(long j) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date parse = simpleDateFormat.parse(simpleDateFormat.format(new Date(j)));
            if (parse == null) {
                return -1L;
            }
            return parse.getTime();
        } catch (ParseException e2) {
            if (k.f45443a) {
                e2.printStackTrace();
            }
            return -1L;
        }
    }
}
