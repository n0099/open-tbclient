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
    public static volatile c f66682b;

    /* renamed from: a  reason: collision with root package name */
    public Handler f66683a = null;

    /* loaded from: classes7.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f66684e;

        public a(c cVar, String str) {
            this.f66684e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            n.n().a(3, n.a(), null, "下载失败，请重试！", null, 0);
            d.o.a.d.f.i a2 = d.o.a.d.k.b().a(this.f66684e);
            if (a2 != null) {
                a2.z();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public long f66685a;

        /* renamed from: b  reason: collision with root package name */
        public long f66686b;

        /* renamed from: c  reason: collision with root package name */
        public long f66687c;

        /* renamed from: d  reason: collision with root package name */
        public String f66688d;

        /* renamed from: e  reason: collision with root package name */
        public String f66689e;

        /* renamed from: f  reason: collision with root package name */
        public String f66690f;

        /* renamed from: g  reason: collision with root package name */
        public String f66691g;

        /* renamed from: h  reason: collision with root package name */
        public volatile long f66692h;

        public b() {
        }

        public static b a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            b bVar = new b();
            try {
                bVar.f66685a = d.o.a.d.n.k.g(jSONObject, "mDownloadId");
                bVar.f66686b = d.o.a.d.n.k.g(jSONObject, "mAdId");
                bVar.f66687c = d.o.a.d.n.k.g(jSONObject, "mExtValue");
                bVar.f66688d = jSONObject.optString("mPackageName");
                bVar.f66689e = jSONObject.optString("mAppName");
                bVar.f66690f = jSONObject.optString("mLogExtra");
                bVar.f66691g = jSONObject.optString("mFileName");
                bVar.f66692h = d.o.a.d.n.k.g(jSONObject, "mTimeStamp");
                return bVar;
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }

        public JSONObject b() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("mDownloadId", this.f66685a);
                jSONObject.put("mAdId", this.f66686b);
                jSONObject.put("mExtValue", this.f66687c);
                jSONObject.put("mPackageName", this.f66688d);
                jSONObject.put("mAppName", this.f66689e);
                jSONObject.put("mLogExtra", this.f66690f);
                jSONObject.put("mFileName", this.f66691g);
                jSONObject.put("mTimeStamp", this.f66692h);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }

        public b(long j, long j2, long j3, String str, String str2, String str3, String str4) {
            this.f66685a = j;
            this.f66686b = j2;
            this.f66687c = j3;
            this.f66688d = str;
            this.f66689e = str2;
            this.f66690f = str3;
            this.f66691g = str4;
        }
    }

    /* renamed from: d.o.a.d.f.c$c  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1862c {

        /* renamed from: a  reason: collision with root package name */
        public long f66693a;

        /* renamed from: b  reason: collision with root package name */
        public long f66694b;

        /* renamed from: c  reason: collision with root package name */
        public String f66695c;

        /* renamed from: d  reason: collision with root package name */
        public String f66696d;

        /* renamed from: e  reason: collision with root package name */
        public String f66697e;

        /* renamed from: f  reason: collision with root package name */
        public String f66698f;

        /* renamed from: g  reason: collision with root package name */
        public final List<Pair<String, String>> f66699g = new ArrayList();

        /* renamed from: h  reason: collision with root package name */
        public String f66700h;

        public static long b(long j, long j2) {
            return j > 0 ? j : j2;
        }

        public long a() {
            return b(this.f66693a, this.f66694b);
        }
    }

    /* loaded from: classes7.dex */
    public class d {

        /* renamed from: c  reason: collision with root package name */
        public static int f66701c = 0;

        /* renamed from: d  reason: collision with root package name */
        public static int f66702d = 1;

        /* renamed from: e  reason: collision with root package name */
        public static int f66703e = 2;

        /* renamed from: a  reason: collision with root package name */
        public int f66704a = f66701c;

        /* renamed from: b  reason: collision with root package name */
        public int f66705b = 0;

        public d a(int i2) {
            this.f66704a = i2;
            return this;
        }

        public boolean b() {
            return this.f66704a == f66702d;
        }

        public int c() {
            return this.f66705b;
        }

        public d d(int i2) {
            this.f66705b = i2;
            return this;
        }
    }

    /* loaded from: classes7.dex */
    public class e {

        /* renamed from: b  reason: collision with root package name */
        public static volatile e f66706b;

        /* renamed from: c  reason: collision with root package name */
        public static final String[] f66707c = {"com", "android", "ss"};

        /* renamed from: d  reason: collision with root package name */
        public static final int[] f66708d = {3101, 3102, 3103, 3201, 3202, 3203};

        /* renamed from: a  reason: collision with root package name */
        public final LinkedList<b> f66709a = new LinkedList<>();

        /* loaded from: classes7.dex */
        public static class b {

            /* renamed from: a  reason: collision with root package name */
            public final String f66710a;

            /* renamed from: b  reason: collision with root package name */
            public final int f66711b;

            /* renamed from: c  reason: collision with root package name */
            public final String f66712c;

            /* renamed from: d  reason: collision with root package name */
            public final String f66713d;

            /* renamed from: e  reason: collision with root package name */
            public final long f66714e;

            public b(String str, int i2, String str2, String str3, long j) {
                this.f66710a = str;
                this.f66711b = i2;
                this.f66712c = str2 != null ? str2.toLowerCase() : null;
                this.f66713d = str3 != null ? str3.toLowerCase() : null;
                this.f66714e = j;
            }
        }

        public static e b() {
            if (f66706b == null) {
                synchronized (e.class) {
                    if (f66706b == null) {
                        f66706b = new e();
                    }
                }
            }
            return f66706b;
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
                    String[] strArr = f66707c;
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
            synchronized (this.f66709a) {
                Iterator<b> it = this.f66709a.iterator();
                while (it.hasNext()) {
                    b next = it.next();
                    if (next.f66714e > bVar.x()) {
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
            synchronized (this.f66709a) {
                this.f66709a.add(h2);
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
            if (this.f66709a.isEmpty()) {
                return null;
            }
            String I = bVar.I();
            String e2 = bVar.e();
            String E = bVar.E();
            int D = bVar.D();
            int length = f66708d.length;
            b[] bVarArr = new b[length];
            synchronized (this.f66709a) {
                Iterator<b> it = this.f66709a.iterator();
                PackageInfo packageInfo = null;
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    next = it.next();
                    if (next.f66714e >= bVar.x()) {
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
                        if (!TextUtils.isEmpty(I) && !TextUtils.isEmpty(next.f66713d)) {
                            I = I.toLowerCase();
                            if (I.equals(next.f66713d)) {
                                bVarArr[0] = next;
                                break;
                            } else if (I.contains(next.f66713d) || next.f66713d.contains(I)) {
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
                        if (!TextUtils.isEmpty(e2) && !TextUtils.isEmpty(next.f66710a)) {
                            e2 = e2.toLowerCase();
                            if (e2.contains(next.f66710a) || next.f66710a.contains(e2)) {
                                break;
                            } else if (bVarArr[3] == null) {
                                if (d(e2, next.f66710a)) {
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
                            if (!TextUtils.isEmpty(E) && !TextUtils.isEmpty(next.f66712c)) {
                                E = E.toLowerCase();
                                if (E.equals(next.f66712c)) {
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
                                if (D == next.f66711b) {
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
                    return new Pair<>(bVarArr[i2], Integer.valueOf(f66708d[i2]));
                }
            }
            return null;
        }

        public final void f() {
            long currentTimeMillis = System.currentTimeMillis();
            synchronized (this.f66709a) {
                Iterator<b> it = this.f66709a.iterator();
                while (it.hasNext() && currentTimeMillis - it.next().f66714e > 1800000) {
                    it.remove();
                }
            }
        }

        public void g(String str) {
            f();
            if (TextUtils.isEmpty(str)) {
                return;
            }
            synchronized (this.f66709a) {
                Iterator<b> it = this.f66709a.iterator();
                while (it.hasNext()) {
                    if (str.equals(it.next().f66710a)) {
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
        public long f66715a;

        /* renamed from: b  reason: collision with root package name */
        public d.o.a.a.a.c.d f66716b;

        /* renamed from: c  reason: collision with root package name */
        public d.o.a.a.a.c.c f66717c;

        /* renamed from: d  reason: collision with root package name */
        public d.o.a.a.a.c.b f66718d;

        public f() {
        }

        @Override // d.o.a.b.a.c.a
        public String a() {
            return this.f66716b.a();
        }

        @Override // d.o.a.b.a.c.a
        public long b() {
            return this.f66716b.d();
        }

        @Override // d.o.a.b.a.c.a
        public boolean c() {
            return this.f66716b.t();
        }

        @Override // d.o.a.b.a.c.a
        public String d() {
            return this.f66716b.u();
        }

        @Override // d.o.a.b.a.c.a
        public String e() {
            return this.f66716b.v();
        }

        @Override // d.o.a.b.a.c.a
        public String f() {
            if (this.f66716b.x() != null) {
                return this.f66716b.x().d();
            }
            return null;
        }

        @Override // d.o.a.b.a.c.a
        public JSONObject g() {
            return this.f66716b.z();
        }

        @Override // d.o.a.b.a.c.a
        public int h() {
            if (this.f66718d.b() == 2) {
                return 2;
            }
            return this.f66716b.G();
        }

        @Override // d.o.a.b.a.c.a
        public String i() {
            return this.f66717c.a();
        }

        @Override // d.o.a.b.a.c.a
        public String j() {
            return this.f66717c.b();
        }

        @Override // d.o.a.b.a.c.a
        public JSONObject k() {
            return this.f66717c.o();
        }

        @Override // d.o.a.b.a.c.a
        public long l() {
            return this.f66716b.g();
        }

        @Override // d.o.a.b.a.c.a
        public boolean m() {
            return this.f66717c.m();
        }

        @Override // d.o.a.b.a.c.a
        public List<String> n() {
            return this.f66716b.y();
        }

        @Override // d.o.a.b.a.c.a
        public Object o() {
            return this.f66717c.j();
        }

        @Override // d.o.a.b.a.c.a
        public JSONObject p() {
            return this.f66717c.n();
        }

        @Override // d.o.a.b.a.c.a
        public boolean q() {
            return this.f66718d.g();
        }

        @Override // d.o.a.b.a.c.a
        public JSONObject r() {
            return this.f66716b.p();
        }

        @Override // d.o.a.b.a.c.a
        public int s() {
            return 0;
        }

        @Override // d.o.a.b.a.c.a
        public d.o.a.a.a.c.d t() {
            return this.f66716b;
        }

        @Override // d.o.a.b.a.c.a
        public d.o.a.a.a.c.c u() {
            return this.f66717c;
        }

        @Override // d.o.a.b.a.c.a
        public d.o.a.a.a.c.b v() {
            return this.f66718d;
        }

        public boolean w() {
            return this.f66715a <= 0 || this.f66716b == null || this.f66717c == null || this.f66718d == null;
        }

        public boolean x() {
            return this.f66715a > 0 && (this.f66716b instanceof d.o.a.b.a.a.c) && (this.f66717c instanceof d.o.a.b.a.a.b) && (this.f66718d instanceof d.o.a.b.a.a.a);
        }

        public f(long j, d.o.a.a.a.c.d dVar, d.o.a.a.a.c.c cVar, d.o.a.a.a.c.b bVar) {
            this.f66715a = j;
            this.f66716b = dVar;
            this.f66717c = cVar;
            this.f66718d = bVar;
        }
    }

    /* loaded from: classes7.dex */
    public class g {

        /* renamed from: a  reason: collision with root package name */
        public volatile boolean f66719a;

        /* renamed from: b  reason: collision with root package name */
        public final ConcurrentHashMap<Long, d.o.a.a.a.c.d> f66720b;

        /* renamed from: c  reason: collision with root package name */
        public final ConcurrentHashMap<Long, d.o.a.a.a.c.c> f66721c;

        /* renamed from: d  reason: collision with root package name */
        public final ConcurrentHashMap<Long, d.o.a.a.a.c.b> f66722d;

        /* renamed from: e  reason: collision with root package name */
        public final ConcurrentHashMap<Long, d.o.a.b.a.c.b> f66723e;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (g.this.f66719a) {
                    return;
                }
                synchronized (g.class) {
                    if (!g.this.f66719a) {
                        g.this.f66723e.putAll(j.b().f());
                        g.this.f66719a = true;
                    }
                }
            }
        }

        /* loaded from: classes7.dex */
        public static class b {

            /* renamed from: a  reason: collision with root package name */
            public static g f66725a = new g(null);
        }

        public /* synthetic */ g(a aVar) {
            this();
        }

        public static g e() {
            return b.f66725a;
        }

        public d.o.a.a.a.c.d a(long j) {
            return this.f66720b.get(Long.valueOf(j));
        }

        public d.o.a.b.a.c.b b(int i2) {
            for (d.o.a.b.a.c.b bVar : this.f66723e.values()) {
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
                        for (d.o.a.b.a.c.b bVar : this.f66723e.values()) {
                            if (bVar != null && bVar.b() == g2) {
                                return bVar;
                            }
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            for (d.o.a.b.a.c.b bVar2 : this.f66723e.values()) {
                if (bVar2 != null && bVar2.s() == downloadInfo.c0()) {
                    return bVar2;
                }
            }
            for (d.o.a.b.a.c.b bVar3 : this.f66723e.values()) {
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
            for (d.o.a.b.a.c.b bVar : this.f66723e.values()) {
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
                for (d.o.a.b.a.c.b bVar : this.f66723e.values()) {
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
                this.f66722d.put(Long.valueOf(j), bVar);
            }
        }

        public void h(long j, d.o.a.a.a.c.c cVar) {
            if (cVar != null) {
                this.f66721c.put(Long.valueOf(j), cVar);
            }
        }

        public void i(d.o.a.a.a.c.d dVar) {
            if (dVar != null) {
                this.f66720b.put(Long.valueOf(dVar.d()), dVar);
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
            this.f66723e.put(Long.valueOf(bVar.b()), bVar);
            j.b().c(bVar);
        }

        public synchronized void k(List<Long> list) {
            ArrayList arrayList = new ArrayList();
            for (Long l : list) {
                long longValue = l.longValue();
                arrayList.add(String.valueOf(longValue));
                this.f66723e.remove(Long.valueOf(longValue));
            }
            j.b().e(arrayList);
        }

        public d.o.a.a.a.c.c n(long j) {
            return this.f66721c.get(Long.valueOf(j));
        }

        public d.o.a.b.a.c.b o(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            for (d.o.a.b.a.c.b bVar : this.f66723e.values()) {
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
            for (d.o.a.a.a.c.d dVar : this.f66720b.values()) {
                if ((dVar instanceof d.o.a.b.a.a.c) && TextUtils.equals(dVar.a(), str)) {
                    ((d.o.a.b.a.a.c) dVar).d(str2);
                }
            }
        }

        public d.o.a.a.a.c.b s(long j) {
            return this.f66722d.get(Long.valueOf(j));
        }

        public ConcurrentHashMap<Long, d.o.a.b.a.c.b> t() {
            return this.f66723e;
        }

        public d.o.a.b.a.c.b u(long j) {
            return this.f66723e.get(Long.valueOf(j));
        }

        @NonNull
        public f v(long j) {
            f fVar = new f();
            fVar.f66715a = j;
            fVar.f66716b = a(j);
            d.o.a.a.a.c.c n = n(j);
            fVar.f66717c = n;
            if (n == null) {
                fVar.f66717c = new d.o.a.a.a.c.h();
            }
            d.o.a.a.a.c.b s = s(j);
            fVar.f66718d = s;
            if (s == null) {
                fVar.f66718d = new d.o.a.a.a.c.g();
            }
            return fVar;
        }

        public void w(long j) {
            this.f66720b.remove(Long.valueOf(j));
            this.f66721c.remove(Long.valueOf(j));
            this.f66722d.remove(Long.valueOf(j));
        }

        public g() {
            this.f66719a = false;
            this.f66720b = new ConcurrentHashMap<>();
            this.f66721c = new ConcurrentHashMap<>();
            this.f66722d = new ConcurrentHashMap<>();
            this.f66723e = new ConcurrentHashMap<>();
        }
    }

    /* loaded from: classes7.dex */
    public class h {

        /* renamed from: a  reason: collision with root package name */
        public int f66726a;

        /* renamed from: b  reason: collision with root package name */
        public int f66727b;

        /* renamed from: c  reason: collision with root package name */
        public String f66728c;

        public h(int i2) {
            this(i2, 0, null);
        }

        public int a() {
            return this.f66726a;
        }

        public int b() {
            return this.f66727b;
        }

        public String c() {
            return this.f66728c;
        }

        public h(int i2, int i3) {
            this(i2, i3, null);
        }

        public h(int i2, String str) {
            this(i2, 0, str);
        }

        public h(int i2, int i3, String str) {
            this.f66726a = i2;
            this.f66727b = i3;
            this.f66728c = str;
        }
    }

    /* loaded from: classes7.dex */
    public class i {

        /* renamed from: a  reason: collision with root package name */
        public static volatile i f66729a;

        public static i a() {
            if (f66729a == null) {
                synchronized (e.class) {
                    if (f66729a == null) {
                        f66729a = new i();
                    }
                }
            }
            return f66729a;
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
            public final /* synthetic */ Collection f66730e;

            public a(Collection collection) {
                this.f66730e = collection;
            }

            @Override // java.lang.Runnable
            public void run() {
                SharedPreferences.Editor edit = j.this.g().edit();
                for (d.o.a.b.a.c.b bVar : this.f66730e) {
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
            public final /* synthetic */ List f66732e;

            public b(List list) {
                this.f66732e = list;
            }

            @Override // java.lang.Runnable
            public void run() {
                SharedPreferences.Editor edit = j.this.g().edit();
                for (String str : this.f66732e) {
                    edit.remove(str);
                }
                edit.apply();
            }
        }

        /* renamed from: d.o.a.d.f.c$j$c  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public static class C1863c {

            /* renamed from: a  reason: collision with root package name */
            public static j f66734a = new j(null);
        }

        public /* synthetic */ j(a aVar) {
            this();
        }

        public static j b() {
            return C1863c.f66734a;
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
        if (f66682b == null) {
            synchronized (c.class) {
                if (f66682b == null) {
                    f66682b = new c();
                }
            }
        }
        return f66682b;
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
            if (this.f66683a == null) {
                this.f66683a = new Handler(Looper.getMainLooper());
            }
            String T0 = downloadInfo.T0();
            d.o.a.e.b.g.a.l(context).d(downloadInfo.c0());
            this.f66683a.post(new a(this, T0));
        }
    }

    public boolean c() {
        return n.s().optInt("forbid_invalidte_download_file_install", 0) == 1;
    }
}
