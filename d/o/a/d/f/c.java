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
    public static volatile c f66510b;

    /* renamed from: a  reason: collision with root package name */
    public Handler f66511a = null;

    /* loaded from: classes7.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f66512e;

        public a(c cVar, String str) {
            this.f66512e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            n.n().a(3, n.a(), null, "下载失败，请重试！", null, 0);
            d.o.a.d.f.i a2 = d.o.a.d.k.b().a(this.f66512e);
            if (a2 != null) {
                a2.z();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public long f66513a;

        /* renamed from: b  reason: collision with root package name */
        public long f66514b;

        /* renamed from: c  reason: collision with root package name */
        public long f66515c;

        /* renamed from: d  reason: collision with root package name */
        public String f66516d;

        /* renamed from: e  reason: collision with root package name */
        public String f66517e;

        /* renamed from: f  reason: collision with root package name */
        public String f66518f;

        /* renamed from: g  reason: collision with root package name */
        public String f66519g;

        /* renamed from: h  reason: collision with root package name */
        public volatile long f66520h;

        public b() {
        }

        public static b a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            b bVar = new b();
            try {
                bVar.f66513a = d.o.a.d.n.k.g(jSONObject, "mDownloadId");
                bVar.f66514b = d.o.a.d.n.k.g(jSONObject, "mAdId");
                bVar.f66515c = d.o.a.d.n.k.g(jSONObject, "mExtValue");
                bVar.f66516d = jSONObject.optString("mPackageName");
                bVar.f66517e = jSONObject.optString("mAppName");
                bVar.f66518f = jSONObject.optString("mLogExtra");
                bVar.f66519g = jSONObject.optString("mFileName");
                bVar.f66520h = d.o.a.d.n.k.g(jSONObject, "mTimeStamp");
                return bVar;
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }

        public JSONObject b() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("mDownloadId", this.f66513a);
                jSONObject.put("mAdId", this.f66514b);
                jSONObject.put("mExtValue", this.f66515c);
                jSONObject.put("mPackageName", this.f66516d);
                jSONObject.put("mAppName", this.f66517e);
                jSONObject.put("mLogExtra", this.f66518f);
                jSONObject.put("mFileName", this.f66519g);
                jSONObject.put("mTimeStamp", this.f66520h);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }

        public b(long j, long j2, long j3, String str, String str2, String str3, String str4) {
            this.f66513a = j;
            this.f66514b = j2;
            this.f66515c = j3;
            this.f66516d = str;
            this.f66517e = str2;
            this.f66518f = str3;
            this.f66519g = str4;
        }
    }

    /* renamed from: d.o.a.d.f.c$c  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1824c {

        /* renamed from: a  reason: collision with root package name */
        public long f66521a;

        /* renamed from: b  reason: collision with root package name */
        public long f66522b;

        /* renamed from: c  reason: collision with root package name */
        public String f66523c;

        /* renamed from: d  reason: collision with root package name */
        public String f66524d;

        /* renamed from: e  reason: collision with root package name */
        public String f66525e;

        /* renamed from: f  reason: collision with root package name */
        public String f66526f;

        /* renamed from: g  reason: collision with root package name */
        public final List<Pair<String, String>> f66527g = new ArrayList();

        /* renamed from: h  reason: collision with root package name */
        public String f66528h;

        public static long b(long j, long j2) {
            return j > 0 ? j : j2;
        }

        public long a() {
            return b(this.f66521a, this.f66522b);
        }
    }

    /* loaded from: classes7.dex */
    public class d {

        /* renamed from: c  reason: collision with root package name */
        public static int f66529c = 0;

        /* renamed from: d  reason: collision with root package name */
        public static int f66530d = 1;

        /* renamed from: e  reason: collision with root package name */
        public static int f66531e = 2;

        /* renamed from: a  reason: collision with root package name */
        public int f66532a = f66529c;

        /* renamed from: b  reason: collision with root package name */
        public int f66533b = 0;

        public d a(int i) {
            this.f66532a = i;
            return this;
        }

        public boolean b() {
            return this.f66532a == f66530d;
        }

        public int c() {
            return this.f66533b;
        }

        public d d(int i) {
            this.f66533b = i;
            return this;
        }
    }

    /* loaded from: classes7.dex */
    public class e {

        /* renamed from: b  reason: collision with root package name */
        public static volatile e f66534b;

        /* renamed from: c  reason: collision with root package name */
        public static final String[] f66535c = {"com", "android", "ss"};

        /* renamed from: d  reason: collision with root package name */
        public static final int[] f66536d = {3101, 3102, 3103, 3201, 3202, 3203};

        /* renamed from: a  reason: collision with root package name */
        public final LinkedList<b> f66537a = new LinkedList<>();

        /* loaded from: classes7.dex */
        public static class b {

            /* renamed from: a  reason: collision with root package name */
            public final String f66538a;

            /* renamed from: b  reason: collision with root package name */
            public final int f66539b;

            /* renamed from: c  reason: collision with root package name */
            public final String f66540c;

            /* renamed from: d  reason: collision with root package name */
            public final String f66541d;

            /* renamed from: e  reason: collision with root package name */
            public final long f66542e;

            public b(String str, int i, String str2, String str3, long j) {
                this.f66538a = str;
                this.f66539b = i;
                this.f66540c = str2 != null ? str2.toLowerCase() : null;
                this.f66541d = str3 != null ? str3.toLowerCase() : null;
                this.f66542e = j;
            }
        }

        public static e b() {
            if (f66534b == null) {
                synchronized (e.class) {
                    if (f66534b == null) {
                        f66534b = new e();
                    }
                }
            }
            return f66534b;
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
                    String[] strArr = f66535c;
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

        public b a(d.o.a.b.a.c.b bVar) {
            if (bVar == null) {
                return null;
            }
            f();
            synchronized (this.f66537a) {
                Iterator<b> it = this.f66537a.iterator();
                while (it.hasNext()) {
                    b next = it.next();
                    if (next.f66542e > bVar.x()) {
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
            synchronized (this.f66537a) {
                this.f66537a.add(h2);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:34:0x0096, code lost:
            r7[1] = r11;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Pair<b, Integer> e(d.o.a.b.a.c.b bVar) {
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
            if (this.f66537a.isEmpty()) {
                return null;
            }
            String I = bVar.I();
            String e2 = bVar.e();
            String E = bVar.E();
            int D = bVar.D();
            int length = f66536d.length;
            b[] bVarArr = new b[length];
            synchronized (this.f66537a) {
                Iterator<b> it = this.f66537a.iterator();
                PackageInfo packageInfo = null;
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    next = it.next();
                    if (next.f66542e >= bVar.x()) {
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
                        if (!TextUtils.isEmpty(I) && !TextUtils.isEmpty(next.f66541d)) {
                            I = I.toLowerCase();
                            if (I.equals(next.f66541d)) {
                                bVarArr[0] = next;
                                break;
                            } else if (I.contains(next.f66541d) || next.f66541d.contains(I)) {
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
                        if (!TextUtils.isEmpty(e2) && !TextUtils.isEmpty(next.f66538a)) {
                            e2 = e2.toLowerCase();
                            if (e2.contains(next.f66538a) || next.f66538a.contains(e2)) {
                                break;
                            } else if (bVarArr[3] == null) {
                                if (d(e2, next.f66538a)) {
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
                            if (!TextUtils.isEmpty(E) && !TextUtils.isEmpty(next.f66540c)) {
                                E = E.toLowerCase();
                                if (E.equals(next.f66540c)) {
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
                                if (D == next.f66539b) {
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
                    return new Pair<>(bVarArr[i], Integer.valueOf(f66536d[i]));
                }
            }
            return null;
        }

        public final void f() {
            long currentTimeMillis = System.currentTimeMillis();
            synchronized (this.f66537a) {
                Iterator<b> it = this.f66537a.iterator();
                while (it.hasNext() && currentTimeMillis - it.next().f66542e > 1800000) {
                    it.remove();
                }
            }
        }

        public void g(String str) {
            f();
            if (TextUtils.isEmpty(str)) {
                return;
            }
            synchronized (this.f66537a) {
                Iterator<b> it = this.f66537a.iterator();
                while (it.hasNext()) {
                    if (str.equals(it.next().f66538a)) {
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
        public long f66543a;

        /* renamed from: b  reason: collision with root package name */
        public d.o.a.a.a.c.d f66544b;

        /* renamed from: c  reason: collision with root package name */
        public d.o.a.a.a.c.c f66545c;

        /* renamed from: d  reason: collision with root package name */
        public d.o.a.a.a.c.b f66546d;

        public f() {
        }

        @Override // d.o.a.b.a.c.a
        public String a() {
            return this.f66544b.a();
        }

        @Override // d.o.a.b.a.c.a
        public long b() {
            return this.f66544b.d();
        }

        @Override // d.o.a.b.a.c.a
        public boolean c() {
            return this.f66544b.t();
        }

        @Override // d.o.a.b.a.c.a
        public String d() {
            return this.f66544b.u();
        }

        @Override // d.o.a.b.a.c.a
        public String e() {
            return this.f66544b.v();
        }

        @Override // d.o.a.b.a.c.a
        public String f() {
            if (this.f66544b.x() != null) {
                return this.f66544b.x().d();
            }
            return null;
        }

        @Override // d.o.a.b.a.c.a
        public JSONObject g() {
            return this.f66544b.z();
        }

        @Override // d.o.a.b.a.c.a
        public int h() {
            if (this.f66546d.b() == 2) {
                return 2;
            }
            return this.f66544b.G();
        }

        @Override // d.o.a.b.a.c.a
        public String i() {
            return this.f66545c.a();
        }

        @Override // d.o.a.b.a.c.a
        public String j() {
            return this.f66545c.b();
        }

        @Override // d.o.a.b.a.c.a
        public JSONObject k() {
            return this.f66545c.o();
        }

        @Override // d.o.a.b.a.c.a
        public long l() {
            return this.f66544b.g();
        }

        @Override // d.o.a.b.a.c.a
        public boolean m() {
            return this.f66545c.m();
        }

        @Override // d.o.a.b.a.c.a
        public List<String> n() {
            return this.f66544b.y();
        }

        @Override // d.o.a.b.a.c.a
        public Object o() {
            return this.f66545c.j();
        }

        @Override // d.o.a.b.a.c.a
        public JSONObject p() {
            return this.f66545c.n();
        }

        @Override // d.o.a.b.a.c.a
        public boolean q() {
            return this.f66546d.g();
        }

        @Override // d.o.a.b.a.c.a
        public JSONObject r() {
            return this.f66544b.p();
        }

        @Override // d.o.a.b.a.c.a
        public int s() {
            return 0;
        }

        @Override // d.o.a.b.a.c.a
        public d.o.a.a.a.c.d t() {
            return this.f66544b;
        }

        @Override // d.o.a.b.a.c.a
        public d.o.a.a.a.c.c u() {
            return this.f66545c;
        }

        @Override // d.o.a.b.a.c.a
        public d.o.a.a.a.c.b v() {
            return this.f66546d;
        }

        public boolean w() {
            return this.f66543a <= 0 || this.f66544b == null || this.f66545c == null || this.f66546d == null;
        }

        public boolean x() {
            return this.f66543a > 0 && (this.f66544b instanceof d.o.a.b.a.a.c) && (this.f66545c instanceof d.o.a.b.a.a.b) && (this.f66546d instanceof d.o.a.b.a.a.a);
        }

        public f(long j, d.o.a.a.a.c.d dVar, d.o.a.a.a.c.c cVar, d.o.a.a.a.c.b bVar) {
            this.f66543a = j;
            this.f66544b = dVar;
            this.f66545c = cVar;
            this.f66546d = bVar;
        }
    }

    /* loaded from: classes7.dex */
    public class g {

        /* renamed from: a  reason: collision with root package name */
        public volatile boolean f66547a;

        /* renamed from: b  reason: collision with root package name */
        public final ConcurrentHashMap<Long, d.o.a.a.a.c.d> f66548b;

        /* renamed from: c  reason: collision with root package name */
        public final ConcurrentHashMap<Long, d.o.a.a.a.c.c> f66549c;

        /* renamed from: d  reason: collision with root package name */
        public final ConcurrentHashMap<Long, d.o.a.a.a.c.b> f66550d;

        /* renamed from: e  reason: collision with root package name */
        public final ConcurrentHashMap<Long, d.o.a.b.a.c.b> f66551e;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (g.this.f66547a) {
                    return;
                }
                synchronized (g.class) {
                    if (!g.this.f66547a) {
                        g.this.f66551e.putAll(j.b().f());
                        g.this.f66547a = true;
                    }
                }
            }
        }

        /* loaded from: classes7.dex */
        public static class b {

            /* renamed from: a  reason: collision with root package name */
            public static g f66553a = new g(null);
        }

        public /* synthetic */ g(a aVar) {
            this();
        }

        public static g e() {
            return b.f66553a;
        }

        public d.o.a.a.a.c.d a(long j) {
            return this.f66548b.get(Long.valueOf(j));
        }

        public d.o.a.b.a.c.b b(int i) {
            for (d.o.a.b.a.c.b bVar : this.f66551e.values()) {
                if (bVar != null && bVar.s() == i) {
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
                        for (d.o.a.b.a.c.b bVar : this.f66551e.values()) {
                            if (bVar != null && bVar.b() == g2) {
                                return bVar;
                            }
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            for (d.o.a.b.a.c.b bVar2 : this.f66551e.values()) {
                if (bVar2 != null && bVar2.s() == downloadInfo.c0()) {
                    return bVar2;
                }
            }
            for (d.o.a.b.a.c.b bVar3 : this.f66551e.values()) {
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
            for (d.o.a.b.a.c.b bVar : this.f66551e.values()) {
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
                for (d.o.a.b.a.c.b bVar : this.f66551e.values()) {
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
                this.f66550d.put(Long.valueOf(j), bVar);
            }
        }

        public void h(long j, d.o.a.a.a.c.c cVar) {
            if (cVar != null) {
                this.f66549c.put(Long.valueOf(j), cVar);
            }
        }

        public void i(d.o.a.a.a.c.d dVar) {
            if (dVar != null) {
                this.f66548b.put(Long.valueOf(dVar.d()), dVar);
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
            this.f66551e.put(Long.valueOf(bVar.b()), bVar);
            j.b().c(bVar);
        }

        public synchronized void k(List<Long> list) {
            ArrayList arrayList = new ArrayList();
            for (Long l : list) {
                long longValue = l.longValue();
                arrayList.add(String.valueOf(longValue));
                this.f66551e.remove(Long.valueOf(longValue));
            }
            j.b().e(arrayList);
        }

        public d.o.a.a.a.c.c n(long j) {
            return this.f66549c.get(Long.valueOf(j));
        }

        public d.o.a.b.a.c.b o(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            for (d.o.a.b.a.c.b bVar : this.f66551e.values()) {
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
            for (d.o.a.a.a.c.d dVar : this.f66548b.values()) {
                if ((dVar instanceof d.o.a.b.a.a.c) && TextUtils.equals(dVar.a(), str)) {
                    ((d.o.a.b.a.a.c) dVar).d(str2);
                }
            }
        }

        public d.o.a.a.a.c.b s(long j) {
            return this.f66550d.get(Long.valueOf(j));
        }

        public ConcurrentHashMap<Long, d.o.a.b.a.c.b> t() {
            return this.f66551e;
        }

        public d.o.a.b.a.c.b u(long j) {
            return this.f66551e.get(Long.valueOf(j));
        }

        @NonNull
        public f v(long j) {
            f fVar = new f();
            fVar.f66543a = j;
            fVar.f66544b = a(j);
            d.o.a.a.a.c.c n = n(j);
            fVar.f66545c = n;
            if (n == null) {
                fVar.f66545c = new d.o.a.a.a.c.h();
            }
            d.o.a.a.a.c.b s = s(j);
            fVar.f66546d = s;
            if (s == null) {
                fVar.f66546d = new d.o.a.a.a.c.g();
            }
            return fVar;
        }

        public void w(long j) {
            this.f66548b.remove(Long.valueOf(j));
            this.f66549c.remove(Long.valueOf(j));
            this.f66550d.remove(Long.valueOf(j));
        }

        public g() {
            this.f66547a = false;
            this.f66548b = new ConcurrentHashMap<>();
            this.f66549c = new ConcurrentHashMap<>();
            this.f66550d = new ConcurrentHashMap<>();
            this.f66551e = new ConcurrentHashMap<>();
        }
    }

    /* loaded from: classes7.dex */
    public class h {

        /* renamed from: a  reason: collision with root package name */
        public int f66554a;

        /* renamed from: b  reason: collision with root package name */
        public int f66555b;

        /* renamed from: c  reason: collision with root package name */
        public String f66556c;

        public h(int i) {
            this(i, 0, null);
        }

        public int a() {
            return this.f66554a;
        }

        public int b() {
            return this.f66555b;
        }

        public String c() {
            return this.f66556c;
        }

        public h(int i, int i2) {
            this(i, i2, null);
        }

        public h(int i, String str) {
            this(i, 0, str);
        }

        public h(int i, int i2, String str) {
            this.f66554a = i;
            this.f66555b = i2;
            this.f66556c = str;
        }
    }

    /* loaded from: classes7.dex */
    public class i {

        /* renamed from: a  reason: collision with root package name */
        public static volatile i f66557a;

        public static i a() {
            if (f66557a == null) {
                synchronized (e.class) {
                    if (f66557a == null) {
                        f66557a = new i();
                    }
                }
            }
            return f66557a;
        }

        public void b(int i, int i2, d.o.a.b.a.c.b bVar) {
            if (bVar == null) {
                return;
            }
            d.o.a.e.b.j.a d2 = d.o.a.e.b.j.a.d(bVar.s());
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

    /* loaded from: classes7.dex */
    public class j {

        /* loaded from: classes7.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Collection f66558e;

            public a(Collection collection) {
                this.f66558e = collection;
            }

            @Override // java.lang.Runnable
            public void run() {
                SharedPreferences.Editor edit = j.this.g().edit();
                for (d.o.a.b.a.c.b bVar : this.f66558e) {
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
            public final /* synthetic */ List f66560e;

            public b(List list) {
                this.f66560e = list;
            }

            @Override // java.lang.Runnable
            public void run() {
                SharedPreferences.Editor edit = j.this.g().edit();
                for (String str : this.f66560e) {
                    edit.remove(str);
                }
                edit.apply();
            }
        }

        /* renamed from: d.o.a.d.f.c$j$c  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public static class C1825c {

            /* renamed from: a  reason: collision with root package name */
            public static j f66562a = new j(null);
        }

        public /* synthetic */ j(a aVar) {
            this();
        }

        public static j b() {
            return C1825c.f66562a;
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
        if (f66510b == null) {
            synchronized (c.class) {
                if (f66510b == null) {
                    f66510b = new c();
                }
            }
        }
        return f66510b;
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
            if (this.f66511a == null) {
                this.f66511a = new Handler(Looper.getMainLooper());
            }
            String T0 = downloadInfo.T0();
            d.o.a.e.b.g.a.l(context).d(downloadInfo.c0());
            this.f66511a.post(new a(this, T0));
        }
    }

    public boolean c() {
        return n.s().optInt("forbid_invalidte_download_file_install", 0) == 1;
    }
}
