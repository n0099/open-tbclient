package d.p.a.d.f;

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
import d.p.a.d.j;
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
/* loaded from: classes6.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public static volatile c f67650b;

    /* renamed from: a  reason: collision with root package name */
    public Handler f67651a = null;

    /* loaded from: classes6.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f67652e;

        public a(c cVar, String str) {
            this.f67652e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            n.n().a(3, n.a(), null, "下载失败，请重试！", null, 0);
            d.p.a.d.f.i a2 = d.p.a.d.k.b().a(this.f67652e);
            if (a2 != null) {
                a2.z();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public long f67653a;

        /* renamed from: b  reason: collision with root package name */
        public long f67654b;

        /* renamed from: c  reason: collision with root package name */
        public long f67655c;

        /* renamed from: d  reason: collision with root package name */
        public String f67656d;

        /* renamed from: e  reason: collision with root package name */
        public String f67657e;

        /* renamed from: f  reason: collision with root package name */
        public String f67658f;

        /* renamed from: g  reason: collision with root package name */
        public String f67659g;

        /* renamed from: h  reason: collision with root package name */
        public volatile long f67660h;

        public b() {
        }

        public static b a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            b bVar = new b();
            try {
                bVar.f67653a = d.p.a.d.n.k.g(jSONObject, "mDownloadId");
                bVar.f67654b = d.p.a.d.n.k.g(jSONObject, "mAdId");
                bVar.f67655c = d.p.a.d.n.k.g(jSONObject, "mExtValue");
                bVar.f67656d = jSONObject.optString("mPackageName");
                bVar.f67657e = jSONObject.optString("mAppName");
                bVar.f67658f = jSONObject.optString("mLogExtra");
                bVar.f67659g = jSONObject.optString("mFileName");
                bVar.f67660h = d.p.a.d.n.k.g(jSONObject, "mTimeStamp");
                return bVar;
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }

        public JSONObject b() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("mDownloadId", this.f67653a);
                jSONObject.put("mAdId", this.f67654b);
                jSONObject.put("mExtValue", this.f67655c);
                jSONObject.put("mPackageName", this.f67656d);
                jSONObject.put("mAppName", this.f67657e);
                jSONObject.put("mLogExtra", this.f67658f);
                jSONObject.put("mFileName", this.f67659g);
                jSONObject.put("mTimeStamp", this.f67660h);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }

        public b(long j, long j2, long j3, String str, String str2, String str3, String str4) {
            this.f67653a = j;
            this.f67654b = j2;
            this.f67655c = j3;
            this.f67656d = str;
            this.f67657e = str2;
            this.f67658f = str3;
            this.f67659g = str4;
        }
    }

    /* renamed from: d.p.a.d.f.c$c  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C1863c {

        /* renamed from: a  reason: collision with root package name */
        public long f67661a;

        /* renamed from: b  reason: collision with root package name */
        public long f67662b;

        /* renamed from: c  reason: collision with root package name */
        public String f67663c;

        /* renamed from: d  reason: collision with root package name */
        public String f67664d;

        /* renamed from: e  reason: collision with root package name */
        public String f67665e;

        /* renamed from: f  reason: collision with root package name */
        public String f67666f;

        /* renamed from: g  reason: collision with root package name */
        public final List<Pair<String, String>> f67667g = new ArrayList();

        /* renamed from: h  reason: collision with root package name */
        public String f67668h;

        public static long b(long j, long j2) {
            return j > 0 ? j : j2;
        }

        public long a() {
            return b(this.f67661a, this.f67662b);
        }
    }

    /* loaded from: classes6.dex */
    public class d {

        /* renamed from: c  reason: collision with root package name */
        public static int f67669c = 0;

        /* renamed from: d  reason: collision with root package name */
        public static int f67670d = 1;

        /* renamed from: e  reason: collision with root package name */
        public static int f67671e = 2;

        /* renamed from: a  reason: collision with root package name */
        public int f67672a = f67669c;

        /* renamed from: b  reason: collision with root package name */
        public int f67673b = 0;

        public d a(int i) {
            this.f67672a = i;
            return this;
        }

        public boolean b() {
            return this.f67672a == f67670d;
        }

        public int c() {
            return this.f67673b;
        }

        public d d(int i) {
            this.f67673b = i;
            return this;
        }
    }

    /* loaded from: classes6.dex */
    public class e {

        /* renamed from: b  reason: collision with root package name */
        public static volatile e f67674b;

        /* renamed from: c  reason: collision with root package name */
        public static final String[] f67675c = {"com", "android", "ss"};

        /* renamed from: d  reason: collision with root package name */
        public static final int[] f67676d = {3101, 3102, 3103, 3201, 3202, 3203};

        /* renamed from: a  reason: collision with root package name */
        public final LinkedList<b> f67677a = new LinkedList<>();

        /* loaded from: classes6.dex */
        public static class b {

            /* renamed from: a  reason: collision with root package name */
            public final String f67678a;

            /* renamed from: b  reason: collision with root package name */
            public final int f67679b;

            /* renamed from: c  reason: collision with root package name */
            public final String f67680c;

            /* renamed from: d  reason: collision with root package name */
            public final String f67681d;

            /* renamed from: e  reason: collision with root package name */
            public final long f67682e;

            public b(String str, int i, String str2, String str3, long j) {
                this.f67678a = str;
                this.f67679b = i;
                this.f67680c = str2 != null ? str2.toLowerCase() : null;
                this.f67681d = str3 != null ? str3.toLowerCase() : null;
                this.f67682e = j;
            }
        }

        public static e b() {
            if (f67674b == null) {
                synchronized (e.class) {
                    if (f67674b == null) {
                        f67674b = new e();
                    }
                }
            }
            return f67674b;
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
                int i = 0;
                int i2 = 0;
                for (String str3 : split) {
                    String[] strArr = f67675c;
                    int length = strArr.length;
                    int i3 = 0;
                    while (true) {
                        if (i3 >= length) {
                            z = false;
                            break;
                        }
                        String str4 = strArr[i3];
                        if (str4.equals(str3)) {
                            if (i < split2.length && str4.equals(split2[i])) {
                                i++;
                            }
                            z = true;
                        } else {
                            i3++;
                        }
                    }
                    if (!z) {
                        int i4 = i2;
                        int i5 = i;
                        while (i < split2.length) {
                            if (str3.equals(split2[i])) {
                                if (i == i5) {
                                    i5++;
                                }
                                i4++;
                                if (i4 >= 2) {
                                    return true;
                                }
                            }
                            i++;
                        }
                        i = i5;
                        i2 = i4;
                    }
                }
                return false;
            }
            return false;
        }

        public b a(d.p.a.b.a.c.b bVar) {
            if (bVar == null) {
                return null;
            }
            f();
            synchronized (this.f67677a) {
                Iterator<b> it = this.f67677a.iterator();
                while (it.hasNext()) {
                    b next = it.next();
                    if (next.f67682e > bVar.x()) {
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
            synchronized (this.f67677a) {
                this.f67677a.add(h2);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:34:0x0096, code lost:
            r7[1] = r11;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Pair<b, Integer> e(d.p.a.b.a.c.b bVar) {
            int i;
            b next;
            if (bVar == null) {
                return null;
            }
            try {
                f();
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (this.f67677a.isEmpty()) {
                return null;
            }
            String I = bVar.I();
            String e2 = bVar.e();
            String E = bVar.E();
            int D = bVar.D();
            int length = f67676d.length;
            b[] bVarArr = new b[length];
            synchronized (this.f67677a) {
                Iterator<b> it = this.f67677a.iterator();
                PackageInfo packageInfo = null;
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    next = it.next();
                    if (next.f67682e >= bVar.x()) {
                        if (TextUtils.isEmpty(I)) {
                            if (packageInfo == null) {
                                packageInfo = d.p.a.d.n.k.h(bVar);
                            }
                            if (packageInfo != null) {
                                try {
                                    I = (String) n.a().getPackageManager().getApplicationLabel(packageInfo.applicationInfo);
                                } catch (Throwable unused) {
                                }
                            }
                        }
                        if (!TextUtils.isEmpty(I) && !TextUtils.isEmpty(next.f67681d)) {
                            I = I.toLowerCase();
                            if (I.equals(next.f67681d)) {
                                bVarArr[0] = next;
                                break;
                            } else if (I.contains(next.f67681d) || next.f67681d.contains(I)) {
                                break;
                            }
                        }
                        if (TextUtils.isEmpty(e2)) {
                            if (packageInfo == null) {
                                packageInfo = d.p.a.d.n.k.h(bVar);
                            }
                            if (packageInfo != null) {
                                e2 = packageInfo.packageName;
                            }
                        }
                        if (!TextUtils.isEmpty(e2) && !TextUtils.isEmpty(next.f67678a)) {
                            e2 = e2.toLowerCase();
                            if (e2.contains(next.f67678a) || next.f67678a.contains(e2)) {
                                break;
                            } else if (bVarArr[3] == null) {
                                if (d(e2, next.f67678a)) {
                                    bVarArr[3] = next;
                                }
                            }
                        }
                        if (bVarArr[4] == null) {
                            if (TextUtils.isEmpty(E)) {
                                if (packageInfo == null) {
                                    packageInfo = d.p.a.d.n.k.h(bVar);
                                }
                                if (packageInfo != null) {
                                    E = packageInfo.versionName;
                                }
                            }
                            if (!TextUtils.isEmpty(E) && !TextUtils.isEmpty(next.f67680c)) {
                                E = E.toLowerCase();
                                if (E.equals(next.f67680c)) {
                                    bVarArr[4] = next;
                                }
                            }
                            if (bVarArr[5] == null) {
                                if (D <= 0) {
                                    if (packageInfo == null) {
                                        packageInfo = d.p.a.d.n.k.h(bVar);
                                    }
                                    if (packageInfo != null) {
                                        D = packageInfo.versionCode;
                                    }
                                }
                                if (D == next.f67679b) {
                                    bVarArr[5] = next;
                                }
                            }
                        }
                    }
                }
                bVarArr[2] = next;
            }
            for (i = 0; i < length; i++) {
                if (bVarArr[i] != null) {
                    return new Pair<>(bVarArr[i], Integer.valueOf(f67676d[i]));
                }
            }
            return null;
        }

        public final void f() {
            long currentTimeMillis = System.currentTimeMillis();
            synchronized (this.f67677a) {
                Iterator<b> it = this.f67677a.iterator();
                while (it.hasNext() && currentTimeMillis - it.next().f67682e > 1800000) {
                    it.remove();
                }
            }
        }

        public void g(String str) {
            f();
            if (TextUtils.isEmpty(str)) {
                return;
            }
            synchronized (this.f67677a) {
                Iterator<b> it = this.f67677a.iterator();
                while (it.hasNext()) {
                    if (str.equals(it.next().f67678a)) {
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

    /* loaded from: classes6.dex */
    public class f implements d.p.a.b.a.c.a {

        /* renamed from: a  reason: collision with root package name */
        public long f67683a;

        /* renamed from: b  reason: collision with root package name */
        public d.p.a.a.a.c.d f67684b;

        /* renamed from: c  reason: collision with root package name */
        public d.p.a.a.a.c.c f67685c;

        /* renamed from: d  reason: collision with root package name */
        public d.p.a.a.a.c.b f67686d;

        public f() {
        }

        @Override // d.p.a.b.a.c.a
        public String a() {
            return this.f67684b.a();
        }

        @Override // d.p.a.b.a.c.a
        public long b() {
            return this.f67684b.d();
        }

        @Override // d.p.a.b.a.c.a
        public boolean c() {
            return this.f67684b.t();
        }

        @Override // d.p.a.b.a.c.a
        public String d() {
            return this.f67684b.u();
        }

        @Override // d.p.a.b.a.c.a
        public String e() {
            return this.f67684b.v();
        }

        @Override // d.p.a.b.a.c.a
        public String f() {
            if (this.f67684b.x() != null) {
                return this.f67684b.x().d();
            }
            return null;
        }

        @Override // d.p.a.b.a.c.a
        public JSONObject g() {
            return this.f67684b.z();
        }

        @Override // d.p.a.b.a.c.a
        public int h() {
            if (this.f67686d.b() == 2) {
                return 2;
            }
            return this.f67684b.G();
        }

        @Override // d.p.a.b.a.c.a
        public String i() {
            return this.f67685c.a();
        }

        @Override // d.p.a.b.a.c.a
        public String j() {
            return this.f67685c.b();
        }

        @Override // d.p.a.b.a.c.a
        public JSONObject k() {
            return this.f67685c.o();
        }

        @Override // d.p.a.b.a.c.a
        public long l() {
            return this.f67684b.g();
        }

        @Override // d.p.a.b.a.c.a
        public boolean m() {
            return this.f67685c.m();
        }

        @Override // d.p.a.b.a.c.a
        public List<String> n() {
            return this.f67684b.y();
        }

        @Override // d.p.a.b.a.c.a
        public Object o() {
            return this.f67685c.j();
        }

        @Override // d.p.a.b.a.c.a
        public JSONObject p() {
            return this.f67685c.n();
        }

        @Override // d.p.a.b.a.c.a
        public boolean q() {
            return this.f67686d.g();
        }

        @Override // d.p.a.b.a.c.a
        public JSONObject r() {
            return this.f67684b.p();
        }

        @Override // d.p.a.b.a.c.a
        public int s() {
            return 0;
        }

        @Override // d.p.a.b.a.c.a
        public d.p.a.a.a.c.d t() {
            return this.f67684b;
        }

        @Override // d.p.a.b.a.c.a
        public d.p.a.a.a.c.c u() {
            return this.f67685c;
        }

        @Override // d.p.a.b.a.c.a
        public d.p.a.a.a.c.b v() {
            return this.f67686d;
        }

        public boolean w() {
            return this.f67683a <= 0 || this.f67684b == null || this.f67685c == null || this.f67686d == null;
        }

        public boolean x() {
            return this.f67683a > 0 && (this.f67684b instanceof d.p.a.b.a.a.c) && (this.f67685c instanceof d.p.a.b.a.a.b) && (this.f67686d instanceof d.p.a.b.a.a.a);
        }

        public f(long j, d.p.a.a.a.c.d dVar, d.p.a.a.a.c.c cVar, d.p.a.a.a.c.b bVar) {
            this.f67683a = j;
            this.f67684b = dVar;
            this.f67685c = cVar;
            this.f67686d = bVar;
        }
    }

    /* loaded from: classes6.dex */
    public class g {

        /* renamed from: a  reason: collision with root package name */
        public volatile boolean f67687a;

        /* renamed from: b  reason: collision with root package name */
        public final ConcurrentHashMap<Long, d.p.a.a.a.c.d> f67688b;

        /* renamed from: c  reason: collision with root package name */
        public final ConcurrentHashMap<Long, d.p.a.a.a.c.c> f67689c;

        /* renamed from: d  reason: collision with root package name */
        public final ConcurrentHashMap<Long, d.p.a.a.a.c.b> f67690d;

        /* renamed from: e  reason: collision with root package name */
        public final ConcurrentHashMap<Long, d.p.a.b.a.c.b> f67691e;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (g.this.f67687a) {
                    return;
                }
                synchronized (g.class) {
                    if (!g.this.f67687a) {
                        g.this.f67691e.putAll(j.b().f());
                        g.this.f67687a = true;
                    }
                }
            }
        }

        /* loaded from: classes6.dex */
        public static class b {

            /* renamed from: a  reason: collision with root package name */
            public static g f67693a = new g(null);
        }

        public /* synthetic */ g(a aVar) {
            this();
        }

        public static g e() {
            return b.f67693a;
        }

        public d.p.a.a.a.c.d a(long j) {
            return this.f67688b.get(Long.valueOf(j));
        }

        public d.p.a.b.a.c.b b(int i) {
            for (d.p.a.b.a.c.b bVar : this.f67691e.values()) {
                if (bVar != null && bVar.s() == i) {
                    return bVar;
                }
            }
            return null;
        }

        public d.p.a.b.a.c.b c(DownloadInfo downloadInfo) {
            if (downloadInfo == null) {
                return null;
            }
            if (!TextUtils.isEmpty(downloadInfo.R())) {
                try {
                    long g2 = d.p.a.d.n.k.g(new JSONObject(downloadInfo.R()), "extra");
                    if (g2 > 0) {
                        for (d.p.a.b.a.c.b bVar : this.f67691e.values()) {
                            if (bVar != null && bVar.b() == g2) {
                                return bVar;
                            }
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            for (d.p.a.b.a.c.b bVar2 : this.f67691e.values()) {
                if (bVar2 != null && bVar2.s() == downloadInfo.c0()) {
                    return bVar2;
                }
            }
            for (d.p.a.b.a.c.b bVar3 : this.f67691e.values()) {
                if (bVar3 != null && TextUtils.equals(bVar3.a(), downloadInfo.T0())) {
                    return bVar3;
                }
            }
            return null;
        }

        public d.p.a.b.a.c.b d(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            for (d.p.a.b.a.c.b bVar : this.f67691e.values()) {
                if (bVar != null && str.equals(bVar.e())) {
                    return bVar;
                }
            }
            return null;
        }

        @NonNull
        public Map<Long, d.p.a.b.a.c.b> f(String str, String str2) {
            HashMap hashMap = new HashMap();
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                for (d.p.a.b.a.c.b bVar : this.f67691e.values()) {
                    if (bVar != null && TextUtils.equals(bVar.a(), str)) {
                        bVar.l0(str2);
                        hashMap.put(Long.valueOf(bVar.b()), bVar);
                    }
                }
            }
            return hashMap;
        }

        public void g(long j, d.p.a.a.a.c.b bVar) {
            if (bVar != null) {
                this.f67690d.put(Long.valueOf(j), bVar);
            }
        }

        public void h(long j, d.p.a.a.a.c.c cVar) {
            if (cVar != null) {
                this.f67689c.put(Long.valueOf(j), cVar);
            }
        }

        public void i(d.p.a.a.a.c.d dVar) {
            if (dVar != null) {
                this.f67688b.put(Long.valueOf(dVar.d()), dVar);
                if (dVar.x() != null) {
                    dVar.x().b(dVar.d());
                    dVar.x().g(dVar.v());
                }
            }
        }

        public synchronized void j(d.p.a.b.a.c.b bVar) {
            if (bVar == null) {
                return;
            }
            this.f67691e.put(Long.valueOf(bVar.b()), bVar);
            j.b().c(bVar);
        }

        public synchronized void k(List<Long> list) {
            ArrayList arrayList = new ArrayList();
            for (Long l : list) {
                long longValue = l.longValue();
                arrayList.add(String.valueOf(longValue));
                this.f67691e.remove(Long.valueOf(longValue));
            }
            j.b().e(arrayList);
        }

        public d.p.a.a.a.c.c n(long j) {
            return this.f67689c.get(Long.valueOf(j));
        }

        public d.p.a.b.a.c.b o(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            for (d.p.a.b.a.c.b bVar : this.f67691e.values()) {
                if (bVar != null && str.equals(bVar.a())) {
                    return bVar;
                }
            }
            return null;
        }

        public void q() {
            d.p.a.d.i.a().d(new a(), true);
        }

        public void r(String str, String str2) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return;
            }
            for (d.p.a.a.a.c.d dVar : this.f67688b.values()) {
                if ((dVar instanceof d.p.a.b.a.a.c) && TextUtils.equals(dVar.a(), str)) {
                    ((d.p.a.b.a.a.c) dVar).d(str2);
                }
            }
        }

        public d.p.a.a.a.c.b s(long j) {
            return this.f67690d.get(Long.valueOf(j));
        }

        public ConcurrentHashMap<Long, d.p.a.b.a.c.b> t() {
            return this.f67691e;
        }

        public d.p.a.b.a.c.b u(long j) {
            return this.f67691e.get(Long.valueOf(j));
        }

        @NonNull
        public f v(long j) {
            f fVar = new f();
            fVar.f67683a = j;
            fVar.f67684b = a(j);
            d.p.a.a.a.c.c n = n(j);
            fVar.f67685c = n;
            if (n == null) {
                fVar.f67685c = new d.p.a.a.a.c.h();
            }
            d.p.a.a.a.c.b s = s(j);
            fVar.f67686d = s;
            if (s == null) {
                fVar.f67686d = new d.p.a.a.a.c.g();
            }
            return fVar;
        }

        public void w(long j) {
            this.f67688b.remove(Long.valueOf(j));
            this.f67689c.remove(Long.valueOf(j));
            this.f67690d.remove(Long.valueOf(j));
        }

        public g() {
            this.f67687a = false;
            this.f67688b = new ConcurrentHashMap<>();
            this.f67689c = new ConcurrentHashMap<>();
            this.f67690d = new ConcurrentHashMap<>();
            this.f67691e = new ConcurrentHashMap<>();
        }
    }

    /* loaded from: classes6.dex */
    public class h {

        /* renamed from: a  reason: collision with root package name */
        public int f67694a;

        /* renamed from: b  reason: collision with root package name */
        public int f67695b;

        /* renamed from: c  reason: collision with root package name */
        public String f67696c;

        public h(int i) {
            this(i, 0, null);
        }

        public int a() {
            return this.f67694a;
        }

        public int b() {
            return this.f67695b;
        }

        public String c() {
            return this.f67696c;
        }

        public h(int i, int i2) {
            this(i, i2, null);
        }

        public h(int i, String str) {
            this(i, 0, str);
        }

        public h(int i, int i2, String str) {
            this.f67694a = i;
            this.f67695b = i2;
            this.f67696c = str;
        }
    }

    /* loaded from: classes6.dex */
    public class i {

        /* renamed from: a  reason: collision with root package name */
        public static volatile i f67697a;

        public static i a() {
            if (f67697a == null) {
                synchronized (e.class) {
                    if (f67697a == null) {
                        f67697a = new i();
                    }
                }
            }
            return f67697a;
        }

        public void b(int i, int i2, d.p.a.b.a.c.b bVar) {
            if (bVar == null) {
                return;
            }
            d.p.a.e.b.j.a d2 = d.p.a.e.b.j.a.d(bVar.s());
            if (d2.b("report_api_hijack", 0) == 0) {
                return;
            }
            int i3 = i2 - i;
            if (i <= 0 || i3 <= d2.b("check_api_hijack_version_code_diff", 500)) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("version_code_diff", i3);
                jSONObject.put("installed_version_code", i2);
                jSONObject.put("hijack_type", 1);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            j.c.a().t("api_hijack", jSONObject, bVar);
        }
    }

    /* loaded from: classes6.dex */
    public class j {

        /* loaded from: classes6.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Collection f67698e;

            public a(Collection collection) {
                this.f67698e = collection;
            }

            @Override // java.lang.Runnable
            public void run() {
                SharedPreferences.Editor edit = j.this.g().edit();
                for (d.p.a.b.a.c.b bVar : this.f67698e) {
                    if (bVar != null && bVar.b() != 0) {
                        edit.putString(String.valueOf(bVar.b()), bVar.e0().toString());
                    }
                }
                edit.apply();
            }
        }

        /* loaded from: classes6.dex */
        public class b implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ List f67700e;

            public b(List list) {
                this.f67700e = list;
            }

            @Override // java.lang.Runnable
            public void run() {
                SharedPreferences.Editor edit = j.this.g().edit();
                for (String str : this.f67700e) {
                    edit.remove(str);
                }
                edit.apply();
            }
        }

        /* renamed from: d.p.a.d.f.c$j$c  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public static class C1864c {

            /* renamed from: a  reason: collision with root package name */
            public static j f67702a = new j(null);
        }

        public /* synthetic */ j(a aVar) {
            this();
        }

        public static j b() {
            return C1864c.f67702a;
        }

        public void c(d.p.a.b.a.c.b bVar) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(bVar);
            d(arrayList);
        }

        public synchronized void d(Collection<d.p.a.b.a.c.b> collection) {
            if (collection != null) {
                if (!collection.isEmpty()) {
                    d.p.a.d.i.a().d(new a(collection), true);
                }
            }
        }

        public void e(List<String> list) {
            if (list == null || list.isEmpty()) {
                return;
            }
            d.p.a.d.i.a().d(new b(list), true);
        }

        @NonNull
        public ConcurrentHashMap<Long, d.p.a.b.a.c.b> f() {
            ConcurrentHashMap<Long, d.p.a.b.a.c.b> concurrentHashMap = new ConcurrentHashMap<>();
            Map<String, ?> all = g().getAll();
            if (all == null) {
                return concurrentHashMap;
            }
            for (Map.Entry<String, ?> entry : all.entrySet()) {
                if (entry.getValue() != null) {
                    try {
                        long longValue = Long.valueOf(entry.getKey()).longValue();
                        d.p.a.b.a.c.b i0 = d.p.a.b.a.c.b.i0(new JSONObject(String.valueOf(entry.getValue())));
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
        if (f67650b == null) {
            synchronized (c.class) {
                if (f67650b == null) {
                    f67650b = new c();
                }
            }
        }
        return f67650b;
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
            if (this.f67651a == null) {
                this.f67651a = new Handler(Looper.getMainLooper());
            }
            String T0 = downloadInfo.T0();
            d.p.a.e.b.g.a.l(context).d(downloadInfo.c0());
            this.f67651a.post(new a(this, T0));
        }
    }

    public boolean c() {
        return n.s().optInt("forbid_invalidte_download_file_install", 0) == 1;
    }
}
