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
    public static volatile c f70511b;

    /* renamed from: a  reason: collision with root package name */
    public Handler f70512a = null;

    /* loaded from: classes7.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f70513e;

        public a(c cVar, String str) {
            this.f70513e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            n.n().a(3, n.a(), null, "下载失败，请重试！", null, 0);
            d.o.a.d.f.i a2 = d.o.a.d.k.b().a(this.f70513e);
            if (a2 != null) {
                a2.z();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public long f70514a;

        /* renamed from: b  reason: collision with root package name */
        public long f70515b;

        /* renamed from: c  reason: collision with root package name */
        public long f70516c;

        /* renamed from: d  reason: collision with root package name */
        public String f70517d;

        /* renamed from: e  reason: collision with root package name */
        public String f70518e;

        /* renamed from: f  reason: collision with root package name */
        public String f70519f;

        /* renamed from: g  reason: collision with root package name */
        public String f70520g;

        /* renamed from: h  reason: collision with root package name */
        public volatile long f70521h;

        public b() {
        }

        public static b a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            b bVar = new b();
            try {
                bVar.f70514a = d.o.a.d.n.k.g(jSONObject, "mDownloadId");
                bVar.f70515b = d.o.a.d.n.k.g(jSONObject, "mAdId");
                bVar.f70516c = d.o.a.d.n.k.g(jSONObject, "mExtValue");
                bVar.f70517d = jSONObject.optString("mPackageName");
                bVar.f70518e = jSONObject.optString("mAppName");
                bVar.f70519f = jSONObject.optString("mLogExtra");
                bVar.f70520g = jSONObject.optString("mFileName");
                bVar.f70521h = d.o.a.d.n.k.g(jSONObject, "mTimeStamp");
                return bVar;
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }

        public JSONObject b() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("mDownloadId", this.f70514a);
                jSONObject.put("mAdId", this.f70515b);
                jSONObject.put("mExtValue", this.f70516c);
                jSONObject.put("mPackageName", this.f70517d);
                jSONObject.put("mAppName", this.f70518e);
                jSONObject.put("mLogExtra", this.f70519f);
                jSONObject.put("mFileName", this.f70520g);
                jSONObject.put("mTimeStamp", this.f70521h);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }

        public b(long j, long j2, long j3, String str, String str2, String str3, String str4) {
            this.f70514a = j;
            this.f70515b = j2;
            this.f70516c = j3;
            this.f70517d = str;
            this.f70518e = str2;
            this.f70519f = str3;
            this.f70520g = str4;
        }
    }

    /* renamed from: d.o.a.d.f.c$c  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1926c {

        /* renamed from: a  reason: collision with root package name */
        public long f70522a;

        /* renamed from: b  reason: collision with root package name */
        public long f70523b;

        /* renamed from: c  reason: collision with root package name */
        public String f70524c;

        /* renamed from: d  reason: collision with root package name */
        public String f70525d;

        /* renamed from: e  reason: collision with root package name */
        public String f70526e;

        /* renamed from: f  reason: collision with root package name */
        public String f70527f;

        /* renamed from: g  reason: collision with root package name */
        public final List<Pair<String, String>> f70528g = new ArrayList();

        /* renamed from: h  reason: collision with root package name */
        public String f70529h;

        public static long b(long j, long j2) {
            return j > 0 ? j : j2;
        }

        public long a() {
            return b(this.f70522a, this.f70523b);
        }
    }

    /* loaded from: classes7.dex */
    public class d {

        /* renamed from: c  reason: collision with root package name */
        public static int f70530c = 0;

        /* renamed from: d  reason: collision with root package name */
        public static int f70531d = 1;

        /* renamed from: e  reason: collision with root package name */
        public static int f70532e = 2;

        /* renamed from: a  reason: collision with root package name */
        public int f70533a = f70530c;

        /* renamed from: b  reason: collision with root package name */
        public int f70534b = 0;

        public d a(int i2) {
            this.f70533a = i2;
            return this;
        }

        public boolean b() {
            return this.f70533a == f70531d;
        }

        public int c() {
            return this.f70534b;
        }

        public d d(int i2) {
            this.f70534b = i2;
            return this;
        }
    }

    /* loaded from: classes7.dex */
    public class e {

        /* renamed from: b  reason: collision with root package name */
        public static volatile e f70535b;

        /* renamed from: c  reason: collision with root package name */
        public static final String[] f70536c = {"com", "android", "ss"};

        /* renamed from: d  reason: collision with root package name */
        public static final int[] f70537d = {3101, 3102, 3103, 3201, 3202, 3203};

        /* renamed from: a  reason: collision with root package name */
        public final LinkedList<b> f70538a = new LinkedList<>();

        /* loaded from: classes7.dex */
        public static class b {

            /* renamed from: a  reason: collision with root package name */
            public final String f70539a;

            /* renamed from: b  reason: collision with root package name */
            public final int f70540b;

            /* renamed from: c  reason: collision with root package name */
            public final String f70541c;

            /* renamed from: d  reason: collision with root package name */
            public final String f70542d;

            /* renamed from: e  reason: collision with root package name */
            public final long f70543e;

            public b(String str, int i2, String str2, String str3, long j) {
                this.f70539a = str;
                this.f70540b = i2;
                this.f70541c = str2 != null ? str2.toLowerCase() : null;
                this.f70542d = str3 != null ? str3.toLowerCase() : null;
                this.f70543e = j;
            }
        }

        public static e b() {
            if (f70535b == null) {
                synchronized (e.class) {
                    if (f70535b == null) {
                        f70535b = new e();
                    }
                }
            }
            return f70535b;
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
                    String[] strArr = f70536c;
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
            synchronized (this.f70538a) {
                Iterator<b> it = this.f70538a.iterator();
                while (it.hasNext()) {
                    b next = it.next();
                    if (next.f70543e > bVar.x()) {
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
            synchronized (this.f70538a) {
                this.f70538a.add(h2);
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
            if (this.f70538a.isEmpty()) {
                return null;
            }
            String I = bVar.I();
            String e2 = bVar.e();
            String E = bVar.E();
            int D = bVar.D();
            int length = f70537d.length;
            b[] bVarArr = new b[length];
            synchronized (this.f70538a) {
                Iterator<b> it = this.f70538a.iterator();
                PackageInfo packageInfo = null;
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    next = it.next();
                    if (next.f70543e >= bVar.x()) {
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
                        if (!TextUtils.isEmpty(I) && !TextUtils.isEmpty(next.f70542d)) {
                            I = I.toLowerCase();
                            if (I.equals(next.f70542d)) {
                                bVarArr[0] = next;
                                break;
                            } else if (I.contains(next.f70542d) || next.f70542d.contains(I)) {
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
                        if (!TextUtils.isEmpty(e2) && !TextUtils.isEmpty(next.f70539a)) {
                            e2 = e2.toLowerCase();
                            if (e2.contains(next.f70539a) || next.f70539a.contains(e2)) {
                                break;
                            } else if (bVarArr[3] == null) {
                                if (d(e2, next.f70539a)) {
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
                            if (!TextUtils.isEmpty(E) && !TextUtils.isEmpty(next.f70541c)) {
                                E = E.toLowerCase();
                                if (E.equals(next.f70541c)) {
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
                                if (D == next.f70540b) {
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
                    return new Pair<>(bVarArr[i2], Integer.valueOf(f70537d[i2]));
                }
            }
            return null;
        }

        public final void f() {
            long currentTimeMillis = System.currentTimeMillis();
            synchronized (this.f70538a) {
                Iterator<b> it = this.f70538a.iterator();
                while (it.hasNext() && currentTimeMillis - it.next().f70543e > 1800000) {
                    it.remove();
                }
            }
        }

        public void g(String str) {
            f();
            if (TextUtils.isEmpty(str)) {
                return;
            }
            synchronized (this.f70538a) {
                Iterator<b> it = this.f70538a.iterator();
                while (it.hasNext()) {
                    if (str.equals(it.next().f70539a)) {
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
        public long f70544a;

        /* renamed from: b  reason: collision with root package name */
        public d.o.a.a.a.c.d f70545b;

        /* renamed from: c  reason: collision with root package name */
        public d.o.a.a.a.c.c f70546c;

        /* renamed from: d  reason: collision with root package name */
        public d.o.a.a.a.c.b f70547d;

        public f() {
        }

        @Override // d.o.a.b.a.c.a
        public String a() {
            return this.f70545b.a();
        }

        @Override // d.o.a.b.a.c.a
        public long b() {
            return this.f70545b.d();
        }

        @Override // d.o.a.b.a.c.a
        public boolean c() {
            return this.f70545b.t();
        }

        @Override // d.o.a.b.a.c.a
        public String d() {
            return this.f70545b.u();
        }

        @Override // d.o.a.b.a.c.a
        public String e() {
            return this.f70545b.v();
        }

        @Override // d.o.a.b.a.c.a
        public String f() {
            if (this.f70545b.x() != null) {
                return this.f70545b.x().d();
            }
            return null;
        }

        @Override // d.o.a.b.a.c.a
        public JSONObject g() {
            return this.f70545b.z();
        }

        @Override // d.o.a.b.a.c.a
        public int h() {
            if (this.f70547d.b() == 2) {
                return 2;
            }
            return this.f70545b.G();
        }

        @Override // d.o.a.b.a.c.a
        public String i() {
            return this.f70546c.a();
        }

        @Override // d.o.a.b.a.c.a
        public String j() {
            return this.f70546c.b();
        }

        @Override // d.o.a.b.a.c.a
        public JSONObject k() {
            return this.f70546c.o();
        }

        @Override // d.o.a.b.a.c.a
        public long l() {
            return this.f70545b.g();
        }

        @Override // d.o.a.b.a.c.a
        public boolean m() {
            return this.f70546c.m();
        }

        @Override // d.o.a.b.a.c.a
        public List<String> n() {
            return this.f70545b.y();
        }

        @Override // d.o.a.b.a.c.a
        public Object o() {
            return this.f70546c.j();
        }

        @Override // d.o.a.b.a.c.a
        public JSONObject p() {
            return this.f70546c.n();
        }

        @Override // d.o.a.b.a.c.a
        public boolean q() {
            return this.f70547d.g();
        }

        @Override // d.o.a.b.a.c.a
        public JSONObject r() {
            return this.f70545b.p();
        }

        @Override // d.o.a.b.a.c.a
        public int s() {
            return 0;
        }

        @Override // d.o.a.b.a.c.a
        public d.o.a.a.a.c.d t() {
            return this.f70545b;
        }

        @Override // d.o.a.b.a.c.a
        public d.o.a.a.a.c.c u() {
            return this.f70546c;
        }

        @Override // d.o.a.b.a.c.a
        public d.o.a.a.a.c.b v() {
            return this.f70547d;
        }

        public boolean w() {
            return this.f70544a <= 0 || this.f70545b == null || this.f70546c == null || this.f70547d == null;
        }

        public boolean x() {
            return this.f70544a > 0 && (this.f70545b instanceof d.o.a.b.a.a.c) && (this.f70546c instanceof d.o.a.b.a.a.b) && (this.f70547d instanceof d.o.a.b.a.a.a);
        }

        public f(long j, d.o.a.a.a.c.d dVar, d.o.a.a.a.c.c cVar, d.o.a.a.a.c.b bVar) {
            this.f70544a = j;
            this.f70545b = dVar;
            this.f70546c = cVar;
            this.f70547d = bVar;
        }
    }

    /* loaded from: classes7.dex */
    public class g {

        /* renamed from: a  reason: collision with root package name */
        public volatile boolean f70548a;

        /* renamed from: b  reason: collision with root package name */
        public final ConcurrentHashMap<Long, d.o.a.a.a.c.d> f70549b;

        /* renamed from: c  reason: collision with root package name */
        public final ConcurrentHashMap<Long, d.o.a.a.a.c.c> f70550c;

        /* renamed from: d  reason: collision with root package name */
        public final ConcurrentHashMap<Long, d.o.a.a.a.c.b> f70551d;

        /* renamed from: e  reason: collision with root package name */
        public final ConcurrentHashMap<Long, d.o.a.b.a.c.b> f70552e;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (g.this.f70548a) {
                    return;
                }
                synchronized (g.class) {
                    if (!g.this.f70548a) {
                        g.this.f70552e.putAll(j.b().f());
                        g.this.f70548a = true;
                    }
                }
            }
        }

        /* loaded from: classes7.dex */
        public static class b {

            /* renamed from: a  reason: collision with root package name */
            public static g f70554a = new g(null);
        }

        public /* synthetic */ g(a aVar) {
            this();
        }

        public static g e() {
            return b.f70554a;
        }

        public d.o.a.a.a.c.d a(long j) {
            return this.f70549b.get(Long.valueOf(j));
        }

        public d.o.a.b.a.c.b b(int i2) {
            for (d.o.a.b.a.c.b bVar : this.f70552e.values()) {
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
                        for (d.o.a.b.a.c.b bVar : this.f70552e.values()) {
                            if (bVar != null && bVar.b() == g2) {
                                return bVar;
                            }
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            for (d.o.a.b.a.c.b bVar2 : this.f70552e.values()) {
                if (bVar2 != null && bVar2.s() == downloadInfo.c0()) {
                    return bVar2;
                }
            }
            for (d.o.a.b.a.c.b bVar3 : this.f70552e.values()) {
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
            for (d.o.a.b.a.c.b bVar : this.f70552e.values()) {
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
                for (d.o.a.b.a.c.b bVar : this.f70552e.values()) {
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
                this.f70551d.put(Long.valueOf(j), bVar);
            }
        }

        public void h(long j, d.o.a.a.a.c.c cVar) {
            if (cVar != null) {
                this.f70550c.put(Long.valueOf(j), cVar);
            }
        }

        public void i(d.o.a.a.a.c.d dVar) {
            if (dVar != null) {
                this.f70549b.put(Long.valueOf(dVar.d()), dVar);
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
            this.f70552e.put(Long.valueOf(bVar.b()), bVar);
            j.b().c(bVar);
        }

        public synchronized void k(List<Long> list) {
            ArrayList arrayList = new ArrayList();
            for (Long l : list) {
                long longValue = l.longValue();
                arrayList.add(String.valueOf(longValue));
                this.f70552e.remove(Long.valueOf(longValue));
            }
            j.b().e(arrayList);
        }

        public d.o.a.a.a.c.c n(long j) {
            return this.f70550c.get(Long.valueOf(j));
        }

        public d.o.a.b.a.c.b o(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            for (d.o.a.b.a.c.b bVar : this.f70552e.values()) {
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
            for (d.o.a.a.a.c.d dVar : this.f70549b.values()) {
                if ((dVar instanceof d.o.a.b.a.a.c) && TextUtils.equals(dVar.a(), str)) {
                    ((d.o.a.b.a.a.c) dVar).d(str2);
                }
            }
        }

        public d.o.a.a.a.c.b s(long j) {
            return this.f70551d.get(Long.valueOf(j));
        }

        public ConcurrentHashMap<Long, d.o.a.b.a.c.b> t() {
            return this.f70552e;
        }

        public d.o.a.b.a.c.b u(long j) {
            return this.f70552e.get(Long.valueOf(j));
        }

        @NonNull
        public f v(long j) {
            f fVar = new f();
            fVar.f70544a = j;
            fVar.f70545b = a(j);
            d.o.a.a.a.c.c n = n(j);
            fVar.f70546c = n;
            if (n == null) {
                fVar.f70546c = new d.o.a.a.a.c.h();
            }
            d.o.a.a.a.c.b s = s(j);
            fVar.f70547d = s;
            if (s == null) {
                fVar.f70547d = new d.o.a.a.a.c.g();
            }
            return fVar;
        }

        public void w(long j) {
            this.f70549b.remove(Long.valueOf(j));
            this.f70550c.remove(Long.valueOf(j));
            this.f70551d.remove(Long.valueOf(j));
        }

        public g() {
            this.f70548a = false;
            this.f70549b = new ConcurrentHashMap<>();
            this.f70550c = new ConcurrentHashMap<>();
            this.f70551d = new ConcurrentHashMap<>();
            this.f70552e = new ConcurrentHashMap<>();
        }
    }

    /* loaded from: classes7.dex */
    public class h {

        /* renamed from: a  reason: collision with root package name */
        public int f70555a;

        /* renamed from: b  reason: collision with root package name */
        public int f70556b;

        /* renamed from: c  reason: collision with root package name */
        public String f70557c;

        public h(int i2) {
            this(i2, 0, null);
        }

        public int a() {
            return this.f70555a;
        }

        public int b() {
            return this.f70556b;
        }

        public String c() {
            return this.f70557c;
        }

        public h(int i2, int i3) {
            this(i2, i3, null);
        }

        public h(int i2, String str) {
            this(i2, 0, str);
        }

        public h(int i2, int i3, String str) {
            this.f70555a = i2;
            this.f70556b = i3;
            this.f70557c = str;
        }
    }

    /* loaded from: classes7.dex */
    public class i {

        /* renamed from: a  reason: collision with root package name */
        public static volatile i f70558a;

        public static i a() {
            if (f70558a == null) {
                synchronized (e.class) {
                    if (f70558a == null) {
                        f70558a = new i();
                    }
                }
            }
            return f70558a;
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
            public final /* synthetic */ Collection f70559e;

            public a(Collection collection) {
                this.f70559e = collection;
            }

            @Override // java.lang.Runnable
            public void run() {
                SharedPreferences.Editor edit = j.this.g().edit();
                for (d.o.a.b.a.c.b bVar : this.f70559e) {
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
            public final /* synthetic */ List f70561e;

            public b(List list) {
                this.f70561e = list;
            }

            @Override // java.lang.Runnable
            public void run() {
                SharedPreferences.Editor edit = j.this.g().edit();
                for (String str : this.f70561e) {
                    edit.remove(str);
                }
                edit.apply();
            }
        }

        /* renamed from: d.o.a.d.f.c$j$c  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public static class C1927c {

            /* renamed from: a  reason: collision with root package name */
            public static j f70563a = new j(null);
        }

        public /* synthetic */ j(a aVar) {
            this();
        }

        public static j b() {
            return C1927c.f70563a;
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
        if (f70511b == null) {
            synchronized (c.class) {
                if (f70511b == null) {
                    f70511b = new c();
                }
            }
        }
        return f70511b;
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
            if (this.f70512a == null) {
                this.f70512a = new Handler(Looper.getMainLooper());
            }
            String T0 = downloadInfo.T0();
            d.o.a.e.b.g.a.l(context).d(downloadInfo.c0());
            this.f70512a.post(new a(this, T0));
        }
    }

    public boolean c() {
        return n.s().optInt("forbid_invalidte_download_file_install", 0) == 1;
    }
}
