package d.o.a.d.f;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import d.o.a.d.j;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public static volatile c f70615b;

    /* renamed from: a  reason: collision with root package name */
    public Handler f70616a = null;

    /* loaded from: classes7.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f70617e;

        public a(c cVar, String str) {
            this.f70617e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            n.n().a(3, n.a(), null, "下载失败，请重试！", null, 0);
            d.o.a.d.f.i a2 = d.o.a.d.k.b().a(this.f70617e);
            if (a2 != null) {
                a2.z();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public long f70618a;

        /* renamed from: b  reason: collision with root package name */
        public long f70619b;

        /* renamed from: c  reason: collision with root package name */
        public long f70620c;

        /* renamed from: d  reason: collision with root package name */
        public String f70621d;

        /* renamed from: e  reason: collision with root package name */
        public String f70622e;

        /* renamed from: f  reason: collision with root package name */
        public String f70623f;

        /* renamed from: g  reason: collision with root package name */
        public String f70624g;

        /* renamed from: h  reason: collision with root package name */
        public volatile long f70625h;

        public b() {
        }

        public static b a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            b bVar = new b();
            try {
                bVar.f70618a = d.o.a.d.n.k.g(jSONObject, "mDownloadId");
                bVar.f70619b = d.o.a.d.n.k.g(jSONObject, "mAdId");
                bVar.f70620c = d.o.a.d.n.k.g(jSONObject, "mExtValue");
                bVar.f70621d = jSONObject.optString("mPackageName");
                bVar.f70622e = jSONObject.optString("mAppName");
                bVar.f70623f = jSONObject.optString("mLogExtra");
                bVar.f70624g = jSONObject.optString("mFileName");
                bVar.f70625h = d.o.a.d.n.k.g(jSONObject, "mTimeStamp");
                return bVar;
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }

        public JSONObject b() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("mDownloadId", this.f70618a);
                jSONObject.put("mAdId", this.f70619b);
                jSONObject.put("mExtValue", this.f70620c);
                jSONObject.put("mPackageName", this.f70621d);
                jSONObject.put("mAppName", this.f70622e);
                jSONObject.put("mLogExtra", this.f70623f);
                jSONObject.put("mFileName", this.f70624g);
                jSONObject.put("mTimeStamp", this.f70625h);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }

        public b(long j, long j2, long j3, String str, String str2, String str3, String str4) {
            this.f70618a = j;
            this.f70619b = j2;
            this.f70620c = j3;
            this.f70621d = str;
            this.f70622e = str2;
            this.f70623f = str3;
            this.f70624g = str4;
        }
    }

    /* renamed from: d.o.a.d.f.c$c  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1929c {

        /* renamed from: a  reason: collision with root package name */
        public long f70626a;

        /* renamed from: b  reason: collision with root package name */
        public long f70627b;

        /* renamed from: c  reason: collision with root package name */
        public String f70628c;

        /* renamed from: d  reason: collision with root package name */
        public String f70629d;

        /* renamed from: e  reason: collision with root package name */
        public String f70630e;

        /* renamed from: f  reason: collision with root package name */
        public String f70631f;

        /* renamed from: g  reason: collision with root package name */
        public final List<Pair<String, String>> f70632g = new ArrayList();

        /* renamed from: h  reason: collision with root package name */
        public String f70633h;

        public static long b(long j, long j2) {
            return j > 0 ? j : j2;
        }

        public long a() {
            return b(this.f70626a, this.f70627b);
        }
    }

    /* loaded from: classes7.dex */
    public class d {

        /* renamed from: c  reason: collision with root package name */
        public static int f70634c = 0;

        /* renamed from: d  reason: collision with root package name */
        public static int f70635d = 1;

        /* renamed from: e  reason: collision with root package name */
        public static int f70636e = 2;

        /* renamed from: a  reason: collision with root package name */
        public int f70637a = f70634c;

        /* renamed from: b  reason: collision with root package name */
        public int f70638b = 0;

        public d a(int i2) {
            this.f70637a = i2;
            return this;
        }

        public boolean b() {
            return this.f70637a == f70635d;
        }

        public int c() {
            return this.f70638b;
        }

        public d d(int i2) {
            this.f70638b = i2;
            return this;
        }
    }

    /* loaded from: classes7.dex */
    public class e {

        /* renamed from: b  reason: collision with root package name */
        public static volatile e f70639b;

        /* renamed from: c  reason: collision with root package name */
        public static final String[] f70640c = {"com", "android", "ss"};

        /* renamed from: d  reason: collision with root package name */
        public static final int[] f70641d = {3101, 3102, 3103, 3201, 3202, 3203};

        /* renamed from: a  reason: collision with root package name */
        public final LinkedList<b> f70642a = new LinkedList<>();

        /* loaded from: classes7.dex */
        public static class b {

            /* renamed from: a  reason: collision with root package name */
            public final String f70643a;

            /* renamed from: b  reason: collision with root package name */
            public final int f70644b;

            /* renamed from: c  reason: collision with root package name */
            public final String f70645c;

            /* renamed from: d  reason: collision with root package name */
            public final String f70646d;

            /* renamed from: e  reason: collision with root package name */
            public final long f70647e;

            public b(String str, int i2, String str2, String str3, long j) {
                this.f70643a = str;
                this.f70644b = i2;
                this.f70645c = str2 != null ? str2.toLowerCase() : null;
                this.f70646d = str3 != null ? str3.toLowerCase() : null;
                this.f70647e = j;
            }
        }

        public static e b() {
            if (f70639b == null) {
                synchronized (e.class) {
                    if (f70639b == null) {
                        f70639b = new e();
                    }
                }
            }
            return f70639b;
        }

        public static boolean d(String str, String str2) {
            String[] split;
            String[] split2;
            boolean z;
            try {
                split = str.split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX);
                split2 = str2.split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (split.length != 0 && split2.length != 0) {
                int i2 = 0;
                int i3 = 0;
                for (String str3 : split) {
                    String[] strArr = f70640c;
                    int length = strArr.length;
                    int i4 = 0;
                    while (true) {
                        if (i4 >= length) {
                            z = false;
                            break;
                        }
                        String str4 = strArr[i4];
                        if (str4.equals(str3)) {
                            if (i2 < split2.length && str4.equals(split2[i2])) {
                                i2++;
                            }
                            z = true;
                        } else {
                            i4++;
                        }
                    }
                    if (!z) {
                        int i5 = i3;
                        int i6 = i2;
                        while (i2 < split2.length) {
                            if (str3.equals(split2[i2])) {
                                if (i2 == i6) {
                                    i6++;
                                }
                                i5++;
                                if (i5 >= 2) {
                                    return true;
                                }
                            }
                            i2++;
                        }
                        i2 = i6;
                        i3 = i5;
                    }
                }
                return false;
            }
            return false;
        }

        public b a(d.o.a.b.a.c.b bVar) {
            if (bVar == null) {
                return null;
            }
            f();
            synchronized (this.f70642a) {
                Iterator<b> it = this.f70642a.iterator();
                while (it.hasNext()) {
                    b next = it.next();
                    if (next.f70647e > bVar.x()) {
                        return next;
                    }
                }
                return null;
            }
        }

        public void c(String str) {
            b h2;
            f();
            if (TextUtils.isEmpty(str) || (h2 = h(str)) == null) {
                return;
            }
            synchronized (this.f70642a) {
                this.f70642a.add(h2);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:34:0x0096, code lost:
            r7[1] = r11;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Pair<b, Integer> e(d.o.a.b.a.c.b bVar) {
            int i2;
            b next;
            if (bVar == null) {
                return null;
            }
            try {
                f();
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (this.f70642a.isEmpty()) {
                return null;
            }
            String I = bVar.I();
            String e2 = bVar.e();
            String E = bVar.E();
            int D = bVar.D();
            int length = f70641d.length;
            b[] bVarArr = new b[length];
            synchronized (this.f70642a) {
                Iterator<b> it = this.f70642a.iterator();
                PackageInfo packageInfo = null;
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    next = it.next();
                    if (next.f70647e >= bVar.x()) {
                        if (TextUtils.isEmpty(I)) {
                            if (packageInfo == null) {
                                packageInfo = d.o.a.d.n.k.h(bVar);
                            }
                            if (packageInfo != null) {
                                try {
                                    I = (String) n.a().getPackageManager().getApplicationLabel(packageInfo.applicationInfo);
                                } catch (Throwable unused) {
                                }
                            }
                        }
                        if (!TextUtils.isEmpty(I) && !TextUtils.isEmpty(next.f70646d)) {
                            I = I.toLowerCase();
                            if (I.equals(next.f70646d)) {
                                bVarArr[0] = next;
                                break;
                            } else if (I.contains(next.f70646d) || next.f70646d.contains(I)) {
                                break;
                            }
                        }
                        if (TextUtils.isEmpty(e2)) {
                            if (packageInfo == null) {
                                packageInfo = d.o.a.d.n.k.h(bVar);
                            }
                            if (packageInfo != null) {
                                e2 = packageInfo.packageName;
                            }
                        }
                        if (!TextUtils.isEmpty(e2) && !TextUtils.isEmpty(next.f70643a)) {
                            e2 = e2.toLowerCase();
                            if (e2.contains(next.f70643a) || next.f70643a.contains(e2)) {
                                break;
                            } else if (bVarArr[3] == null) {
                                if (d(e2, next.f70643a)) {
                                    bVarArr[3] = next;
                                }
                            }
                        }
                        if (bVarArr[4] == null) {
                            if (TextUtils.isEmpty(E)) {
                                if (packageInfo == null) {
                                    packageInfo = d.o.a.d.n.k.h(bVar);
                                }
                                if (packageInfo != null) {
                                    E = packageInfo.versionName;
                                }
                            }
                            if (!TextUtils.isEmpty(E) && !TextUtils.isEmpty(next.f70645c)) {
                                E = E.toLowerCase();
                                if (E.equals(next.f70645c)) {
                                    bVarArr[4] = next;
                                }
                            }
                            if (bVarArr[5] == null) {
                                if (D <= 0) {
                                    if (packageInfo == null) {
                                        packageInfo = d.o.a.d.n.k.h(bVar);
                                    }
                                    if (packageInfo != null) {
                                        D = packageInfo.versionCode;
                                    }
                                }
                                if (D == next.f70644b) {
                                    bVarArr[5] = next;
                                }
                            }
                        }
                    }
                }
                bVarArr[2] = next;
            }
            for (i2 = 0; i2 < length; i2++) {
                if (bVarArr[i2] != null) {
                    return new Pair<>(bVarArr[i2], Integer.valueOf(f70641d[i2]));
                }
            }
            return null;
        }

        public final void f() {
            long currentTimeMillis = System.currentTimeMillis();
            synchronized (this.f70642a) {
                Iterator<b> it = this.f70642a.iterator();
                while (it.hasNext() && currentTimeMillis - it.next().f70647e > 1800000) {
                    it.remove();
                }
            }
        }

        public void g(String str) {
            f();
            if (TextUtils.isEmpty(str)) {
                return;
            }
            synchronized (this.f70642a) {
                Iterator<b> it = this.f70642a.iterator();
                while (it.hasNext()) {
                    if (str.equals(it.next().f70643a)) {
                        it.remove();
                        return;
                    }
                }
            }
        }

        public final b h(String str) {
            try {
                PackageManager packageManager = n.a().getPackageManager();
                PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
                if (packageInfo != null) {
                    return new b(str, packageInfo.versionCode, packageInfo.versionName, (String) packageManager.getApplicationLabel(packageInfo.applicationInfo), System.currentTimeMillis());
                }
                return null;
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements d.o.a.b.a.c.a {

        /* renamed from: a  reason: collision with root package name */
        public long f70648a;

        /* renamed from: b  reason: collision with root package name */
        public d.o.a.a.a.c.d f70649b;

        /* renamed from: c  reason: collision with root package name */
        public d.o.a.a.a.c.c f70650c;

        /* renamed from: d  reason: collision with root package name */
        public d.o.a.a.a.c.b f70651d;

        public f() {
        }

        @Override // d.o.a.b.a.c.a
        public String a() {
            return this.f70649b.a();
        }

        @Override // d.o.a.b.a.c.a
        public long b() {
            return this.f70649b.d();
        }

        @Override // d.o.a.b.a.c.a
        public boolean c() {
            return this.f70649b.t();
        }

        @Override // d.o.a.b.a.c.a
        public String d() {
            return this.f70649b.u();
        }

        @Override // d.o.a.b.a.c.a
        public String e() {
            return this.f70649b.v();
        }

        @Override // d.o.a.b.a.c.a
        public String f() {
            if (this.f70649b.x() != null) {
                return this.f70649b.x().d();
            }
            return null;
        }

        @Override // d.o.a.b.a.c.a
        public JSONObject g() {
            return this.f70649b.z();
        }

        @Override // d.o.a.b.a.c.a
        public int h() {
            if (this.f70651d.b() == 2) {
                return 2;
            }
            return this.f70649b.G();
        }

        @Override // d.o.a.b.a.c.a
        public String i() {
            return this.f70650c.a();
        }

        @Override // d.o.a.b.a.c.a
        public String j() {
            return this.f70650c.b();
        }

        @Override // d.o.a.b.a.c.a
        public JSONObject k() {
            return this.f70650c.o();
        }

        @Override // d.o.a.b.a.c.a
        public long l() {
            return this.f70649b.g();
        }

        @Override // d.o.a.b.a.c.a
        public boolean m() {
            return this.f70650c.m();
        }

        @Override // d.o.a.b.a.c.a
        public List<String> n() {
            return this.f70649b.y();
        }

        @Override // d.o.a.b.a.c.a
        public Object o() {
            return this.f70650c.j();
        }

        @Override // d.o.a.b.a.c.a
        public JSONObject p() {
            return this.f70650c.n();
        }

        @Override // d.o.a.b.a.c.a
        public boolean q() {
            return this.f70651d.g();
        }

        @Override // d.o.a.b.a.c.a
        public JSONObject r() {
            return this.f70649b.p();
        }

        @Override // d.o.a.b.a.c.a
        public int s() {
            return 0;
        }

        @Override // d.o.a.b.a.c.a
        public d.o.a.a.a.c.d t() {
            return this.f70649b;
        }

        @Override // d.o.a.b.a.c.a
        public d.o.a.a.a.c.c u() {
            return this.f70650c;
        }

        @Override // d.o.a.b.a.c.a
        public d.o.a.a.a.c.b v() {
            return this.f70651d;
        }

        public boolean w() {
            return this.f70648a <= 0 || this.f70649b == null || this.f70650c == null || this.f70651d == null;
        }

        public boolean x() {
            return this.f70648a > 0 && (this.f70649b instanceof d.o.a.b.a.a.c) && (this.f70650c instanceof d.o.a.b.a.a.b) && (this.f70651d instanceof d.o.a.b.a.a.a);
        }

        public f(long j, d.o.a.a.a.c.d dVar, d.o.a.a.a.c.c cVar, d.o.a.a.a.c.b bVar) {
            this.f70648a = j;
            this.f70649b = dVar;
            this.f70650c = cVar;
            this.f70651d = bVar;
        }
    }

    /* loaded from: classes7.dex */
    public class g {

        /* renamed from: a  reason: collision with root package name */
        public volatile boolean f70652a;

        /* renamed from: b  reason: collision with root package name */
        public final ConcurrentHashMap<Long, d.o.a.a.a.c.d> f70653b;

        /* renamed from: c  reason: collision with root package name */
        public final ConcurrentHashMap<Long, d.o.a.a.a.c.c> f70654c;

        /* renamed from: d  reason: collision with root package name */
        public final ConcurrentHashMap<Long, d.o.a.a.a.c.b> f70655d;

        /* renamed from: e  reason: collision with root package name */
        public final ConcurrentHashMap<Long, d.o.a.b.a.c.b> f70656e;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (g.this.f70652a) {
                    return;
                }
                synchronized (g.class) {
                    if (!g.this.f70652a) {
                        g.this.f70656e.putAll(j.b().f());
                        g.this.f70652a = true;
                    }
                }
            }
        }

        /* loaded from: classes7.dex */
        public static class b {

            /* renamed from: a  reason: collision with root package name */
            public static g f70658a = new g(null);
        }

        public /* synthetic */ g(a aVar) {
            this();
        }

        public static g e() {
            return b.f70658a;
        }

        public d.o.a.a.a.c.d a(long j) {
            return this.f70653b.get(Long.valueOf(j));
        }

        public d.o.a.b.a.c.b b(int i2) {
            for (d.o.a.b.a.c.b bVar : this.f70656e.values()) {
                if (bVar != null && bVar.s() == i2) {
                    return bVar;
                }
            }
            return null;
        }

        public d.o.a.b.a.c.b c(DownloadInfo downloadInfo) {
            if (downloadInfo == null) {
                return null;
            }
            if (!TextUtils.isEmpty(downloadInfo.R())) {
                try {
                    long g2 = d.o.a.d.n.k.g(new JSONObject(downloadInfo.R()), "extra");
                    if (g2 > 0) {
                        for (d.o.a.b.a.c.b bVar : this.f70656e.values()) {
                            if (bVar != null && bVar.b() == g2) {
                                return bVar;
                            }
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            for (d.o.a.b.a.c.b bVar2 : this.f70656e.values()) {
                if (bVar2 != null && bVar2.s() == downloadInfo.c0()) {
                    return bVar2;
                }
            }
            for (d.o.a.b.a.c.b bVar3 : this.f70656e.values()) {
                if (bVar3 != null && TextUtils.equals(bVar3.a(), downloadInfo.T0())) {
                    return bVar3;
                }
            }
            return null;
        }

        public d.o.a.b.a.c.b d(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            for (d.o.a.b.a.c.b bVar : this.f70656e.values()) {
                if (bVar != null && str.equals(bVar.e())) {
                    return bVar;
                }
            }
            return null;
        }

        @NonNull
        public Map<Long, d.o.a.b.a.c.b> f(String str, String str2) {
            HashMap hashMap = new HashMap();
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                for (d.o.a.b.a.c.b bVar : this.f70656e.values()) {
                    if (bVar != null && TextUtils.equals(bVar.a(), str)) {
                        bVar.l0(str2);
                        hashMap.put(Long.valueOf(bVar.b()), bVar);
                    }
                }
            }
            return hashMap;
        }

        public void g(long j, d.o.a.a.a.c.b bVar) {
            if (bVar != null) {
                this.f70655d.put(Long.valueOf(j), bVar);
            }
        }

        public void h(long j, d.o.a.a.a.c.c cVar) {
            if (cVar != null) {
                this.f70654c.put(Long.valueOf(j), cVar);
            }
        }

        public void i(d.o.a.a.a.c.d dVar) {
            if (dVar != null) {
                this.f70653b.put(Long.valueOf(dVar.d()), dVar);
                if (dVar.x() != null) {
                    dVar.x().b(dVar.d());
                    dVar.x().g(dVar.v());
                }
            }
        }

        public synchronized void j(d.o.a.b.a.c.b bVar) {
            if (bVar == null) {
                return;
            }
            this.f70656e.put(Long.valueOf(bVar.b()), bVar);
            j.b().c(bVar);
        }

        public synchronized void k(List<Long> list) {
            ArrayList arrayList = new ArrayList();
            for (Long l : list) {
                long longValue = l.longValue();
                arrayList.add(String.valueOf(longValue));
                this.f70656e.remove(Long.valueOf(longValue));
            }
            j.b().e(arrayList);
        }

        public d.o.a.a.a.c.c n(long j) {
            return this.f70654c.get(Long.valueOf(j));
        }

        public d.o.a.b.a.c.b o(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            for (d.o.a.b.a.c.b bVar : this.f70656e.values()) {
                if (bVar != null && str.equals(bVar.a())) {
                    return bVar;
                }
            }
            return null;
        }

        public void q() {
            d.o.a.d.i.a().d(new a(), true);
        }

        public void r(String str, String str2) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return;
            }
            for (d.o.a.a.a.c.d dVar : this.f70653b.values()) {
                if ((dVar instanceof d.o.a.b.a.a.c) && TextUtils.equals(dVar.a(), str)) {
                    ((d.o.a.b.a.a.c) dVar).d(str2);
                }
            }
        }

        public d.o.a.a.a.c.b s(long j) {
            return this.f70655d.get(Long.valueOf(j));
        }

        public ConcurrentHashMap<Long, d.o.a.b.a.c.b> t() {
            return this.f70656e;
        }

        public d.o.a.b.a.c.b u(long j) {
            return this.f70656e.get(Long.valueOf(j));
        }

        @NonNull
        public f v(long j) {
            f fVar = new f();
            fVar.f70648a = j;
            fVar.f70649b = a(j);
            d.o.a.a.a.c.c n = n(j);
            fVar.f70650c = n;
            if (n == null) {
                fVar.f70650c = new d.o.a.a.a.c.h();
            }
            d.o.a.a.a.c.b s = s(j);
            fVar.f70651d = s;
            if (s == null) {
                fVar.f70651d = new d.o.a.a.a.c.g();
            }
            return fVar;
        }

        public void w(long j) {
            this.f70653b.remove(Long.valueOf(j));
            this.f70654c.remove(Long.valueOf(j));
            this.f70655d.remove(Long.valueOf(j));
        }

        public g() {
            this.f70652a = false;
            this.f70653b = new ConcurrentHashMap<>();
            this.f70654c = new ConcurrentHashMap<>();
            this.f70655d = new ConcurrentHashMap<>();
            this.f70656e = new ConcurrentHashMap<>();
        }
    }

    /* loaded from: classes7.dex */
    public class h {

        /* renamed from: a  reason: collision with root package name */
        public int f70659a;

        /* renamed from: b  reason: collision with root package name */
        public int f70660b;

        /* renamed from: c  reason: collision with root package name */
        public String f70661c;

        public h(int i2) {
            this(i2, 0, null);
        }

        public int a() {
            return this.f70659a;
        }

        public int b() {
            return this.f70660b;
        }

        public String c() {
            return this.f70661c;
        }

        public h(int i2, int i3) {
            this(i2, i3, null);
        }

        public h(int i2, String str) {
            this(i2, 0, str);
        }

        public h(int i2, int i3, String str) {
            this.f70659a = i2;
            this.f70660b = i3;
            this.f70661c = str;
        }
    }

    /* loaded from: classes7.dex */
    public class i {

        /* renamed from: a  reason: collision with root package name */
        public static volatile i f70662a;

        public static i a() {
            if (f70662a == null) {
                synchronized (e.class) {
                    if (f70662a == null) {
                        f70662a = new i();
                    }
                }
            }
            return f70662a;
        }

        public void b(int i2, int i3, d.o.a.b.a.c.b bVar) {
            if (bVar == null) {
                return;
            }
            d.o.a.e.b.j.a d2 = d.o.a.e.b.j.a.d(bVar.s());
            if (d2.b("report_api_hijack", 0) == 0) {
                return;
            }
            int i4 = i3 - i2;
            if (i2 <= 0 || i4 <= d2.b("check_api_hijack_version_code_diff", 500)) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("version_code_diff", i4);
                jSONObject.put("installed_version_code", i3);
                jSONObject.put("hijack_type", 1);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            j.c.a().t("api_hijack", jSONObject, bVar);
        }
    }

    /* loaded from: classes7.dex */
    public class j {

        /* loaded from: classes7.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Collection f70663e;

            public a(Collection collection) {
                this.f70663e = collection;
            }

            @Override // java.lang.Runnable
            public void run() {
                SharedPreferences.Editor edit = j.this.g().edit();
                for (d.o.a.b.a.c.b bVar : this.f70663e) {
                    if (bVar != null && bVar.b() != 0) {
                        edit.putString(String.valueOf(bVar.b()), bVar.e0().toString());
                    }
                }
                edit.apply();
            }
        }

        /* loaded from: classes7.dex */
        public class b implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ List f70665e;

            public b(List list) {
                this.f70665e = list;
            }

            @Override // java.lang.Runnable
            public void run() {
                SharedPreferences.Editor edit = j.this.g().edit();
                for (String str : this.f70665e) {
                    edit.remove(str);
                }
                edit.apply();
            }
        }

        /* renamed from: d.o.a.d.f.c$j$c  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public static class C1930c {

            /* renamed from: a  reason: collision with root package name */
            public static j f70667a = new j(null);
        }

        public /* synthetic */ j(a aVar) {
            this();
        }

        public static j b() {
            return C1930c.f70667a;
        }

        public void c(d.o.a.b.a.c.b bVar) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(bVar);
            d(arrayList);
        }

        public synchronized void d(Collection<d.o.a.b.a.c.b> collection) {
            if (collection != null) {
                if (!collection.isEmpty()) {
                    d.o.a.d.i.a().d(new a(collection), true);
                }
            }
        }

        public void e(List<String> list) {
            if (list == null || list.isEmpty()) {
                return;
            }
            d.o.a.d.i.a().d(new b(list), true);
        }

        @NonNull
        public ConcurrentHashMap<Long, d.o.a.b.a.c.b> f() {
            ConcurrentHashMap<Long, d.o.a.b.a.c.b> concurrentHashMap = new ConcurrentHashMap<>();
            Map<String, ?> all = g().getAll();
            if (all == null) {
                return concurrentHashMap;
            }
            for (Map.Entry<String, ?> entry : all.entrySet()) {
                if (entry.getValue() != null) {
                    try {
                        long longValue = Long.valueOf(entry.getKey()).longValue();
                        d.o.a.b.a.c.b i0 = d.o.a.b.a.c.b.i0(new JSONObject(String.valueOf(entry.getValue())));
                        if (longValue > 0 && i0 != null) {
                            concurrentHashMap.put(Long.valueOf(longValue), i0);
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
            return concurrentHashMap;
        }

        public final SharedPreferences g() {
            return n.a().getSharedPreferences("sp_ad_download_event", 0);
        }

        public j() {
        }
    }

    public static c a() {
        if (f70615b == null) {
            synchronized (c.class) {
                if (f70615b == null) {
                    f70615b = new c();
                }
            }
        }
        return f70615b;
    }

    public void b(Context context, DownloadInfo downloadInfo) {
        if (c() && downloadInfo != null) {
            try {
                File file = new File(downloadInfo.F0(), downloadInfo.q0());
                if (file.isFile() && file.exists()) {
                    file.delete();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (this.f70616a == null) {
                this.f70616a = new Handler(Looper.getMainLooper());
            }
            String T0 = downloadInfo.T0();
            d.o.a.e.b.g.a.l(context).d(downloadInfo.c0());
            this.f70616a.post(new a(this, T0));
        }
    }

    public boolean c() {
        return n.s().optInt("forbid_invalidte_download_file_install", 0) == 1;
    }
}
