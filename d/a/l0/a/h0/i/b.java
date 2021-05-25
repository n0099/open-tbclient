package d.a.l0.a.h0.i;

import android.text.TextUtils;
import android.util.Log;
import d.a.l0.a.k;
import d.a.l0.a.v2.q;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f42159a = k.f43199a;

    /* loaded from: classes2.dex */
    public static class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f42160e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ File f42161f;

        public a(String str, File file) {
            this.f42160e = str;
            this.f42161f = file;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (b.class) {
                d.a.l0.t.d.R(this.f42160e, this.f42161f, true);
            }
            b.c();
        }
    }

    /* renamed from: d.a.l0.a.h0.i.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0667b implements Comparator<Long> {
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
            d.a.l0.t.d.K(file);
        }
        d.a.l0.t.d.h(file);
        return file;
    }

    public static void c() {
        d.a.l0.a.a2.e Q = d.a.l0.a.a2.e.Q();
        if (Q == null || TextUtils.isEmpty(Q.getAppId())) {
            return;
        }
        File file = new File(d.a.l0.a.a1.e.g().getPath() + File.separator + "launch_tips");
        if (file.exists() && file.isDirectory()) {
            d.a.l0.t.d.i(file);
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
                        d.a.l0.t.d.i(file2);
                    }
                } catch (NumberFormatException unused) {
                    d.a.l0.t.d.i(file2);
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
        TreeMap treeMap = new TreeMap(new C0667b());
        long i2 = i(System.currentTimeMillis());
        for (File file : g2) {
            try {
                long parseLong = Long.parseLong(file.getName());
                if (i2 - parseLong >= 259200000) {
                    d.a.l0.t.d.i(file);
                } else {
                    List<String> E = d.a.l0.t.d.E(file);
                    if (E != null && E.size() > 0) {
                        treeMap.put(Long.valueOf(parseLong), E);
                    }
                }
            } catch (NumberFormatException unused) {
                d.a.l0.t.d.i(file);
            }
        }
        if (treeMap.size() == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder("\n（二）历史日志");
        for (Map.Entry entry : treeMap.entrySet()) {
            sb.append("\n----------【");
            sb.append(new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date(((Long) entry.getKey()).longValue())));
            sb.append("】----------");
            for (String str : (List) entry.getValue()) {
                if (!TextUtils.isEmpty(str)) {
                    sb.append("\n");
                    sb.append(str);
                }
            }
        }
        sb.append("\n");
        return sb.toString();
    }

    public static String f() {
        d.a.l0.a.a2.e Q = d.a.l0.a.a2.e.Q();
        if (Q == null) {
            return null;
        }
        String appId = Q.getAppId();
        if (TextUtils.isEmpty(appId)) {
            return null;
        }
        return d.a.l0.a.a1.e.g().getPath() + File.separator + "launch_tips_v2" + File.separator + appId;
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
        long i2 = i(j);
        if (i2 == -1) {
            if (f42159a) {
                Log.e("LaunchTipsFileHelper", "get timestampByDay failed");
                return;
            }
            return;
        }
        File d2 = d(i2);
        if (d2 == null || !d2.exists()) {
            return;
        }
        q.j(new a(str, d2), "saveLaunchTipsLog");
    }

    public static long i(long j) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        try {
            Date parse = simpleDateFormat.parse(simpleDateFormat.format(new Date(j)));
            if (parse == null) {
                return -1L;
            }
            return parse.getTime();
        } catch (ParseException e2) {
            if (k.f43199a) {
                e2.printStackTrace();
            }
            return -1L;
        }
    }
}
