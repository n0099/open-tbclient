package com.ss.android.downloadlib.addownload.b;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.ss.android.downloadlib.addownload.j;
import com.ss.android.downloadlib.g.l;
import com.yy.hiidostatis.inner.FlushManager;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes4.dex */
public class d {
    public static volatile d a;

    /* renamed from: c  reason: collision with root package name */
    public static final String[] f59502c = {"com", "android", "ss"};

    /* renamed from: d  reason: collision with root package name */
    public static final int[] f59503d = {3101, 3102, 3103, 3201, 3202, 3203};

    /* renamed from: b  reason: collision with root package name */
    public final LinkedList<a> f59504b = new LinkedList<>();

    /* loaded from: classes4.dex */
    public static class a {
        public final String a;

        /* renamed from: b  reason: collision with root package name */
        public final int f59505b;

        /* renamed from: c  reason: collision with root package name */
        public final String f59506c;

        /* renamed from: d  reason: collision with root package name */
        public final String f59507d;

        /* renamed from: e  reason: collision with root package name */
        public final long f59508e;

        public a(String str, int i2, String str2, String str3, long j2) {
            this.a = str;
            this.f59505b = i2;
            this.f59506c = str2 != null ? str2.toLowerCase() : null;
            this.f59507d = str3 != null ? str3.toLowerCase() : null;
            this.f59508e = j2;
        }
    }

    public static d a() {
        if (a == null) {
            synchronized (d.class) {
                if (a == null) {
                    a = new d();
                }
            }
        }
        return a;
    }

    private a c(String str) {
        try {
            PackageManager packageManager = j.getContext().getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            if (packageInfo != null) {
                return new a(str, packageInfo.versionCode, packageInfo.versionName, (String) packageManager.getApplicationLabel(packageInfo.applicationInfo), System.currentTimeMillis());
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public void b(String str) {
        b();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.f59504b) {
            Iterator<a> it = this.f59504b.iterator();
            while (it.hasNext()) {
                if (str.equals(it.next().a)) {
                    it.remove();
                    return;
                }
            }
        }
    }

    public void a(String str) {
        a c2;
        b();
        if (TextUtils.isEmpty(str) || (c2 = c(str)) == null) {
            return;
        }
        synchronized (this.f59504b) {
            this.f59504b.add(c2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0096, code lost:
        r7[1] = r11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Pair<a, Integer> b(com.ss.android.downloadad.api.a.b bVar) {
        int i2;
        a next;
        if (bVar == null) {
            return null;
        }
        try {
            b();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (this.f59504b.isEmpty()) {
            return null;
        }
        String N = bVar.N();
        String e2 = bVar.e();
        String J = bVar.J();
        int I = bVar.I();
        int length = f59503d.length;
        a[] aVarArr = new a[length];
        synchronized (this.f59504b) {
            Iterator<a> it = this.f59504b.iterator();
            PackageInfo packageInfo = null;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                next = it.next();
                if (next.f59508e >= bVar.C()) {
                    if (TextUtils.isEmpty(N)) {
                        if (packageInfo == null) {
                            packageInfo = l.a(bVar);
                        }
                        if (packageInfo != null) {
                            try {
                                N = (String) j.getContext().getPackageManager().getApplicationLabel(packageInfo.applicationInfo);
                            } catch (Throwable unused) {
                            }
                        }
                    }
                    if (!TextUtils.isEmpty(N) && !TextUtils.isEmpty(next.f59507d)) {
                        N = N.toLowerCase();
                        if (N.equals(next.f59507d)) {
                            aVarArr[0] = next;
                            break;
                        } else if (N.contains(next.f59507d) || next.f59507d.contains(N)) {
                            break;
                        }
                    }
                    if (TextUtils.isEmpty(e2)) {
                        if (packageInfo == null) {
                            packageInfo = l.a(bVar);
                        }
                        if (packageInfo != null) {
                            e2 = packageInfo.packageName;
                        }
                    }
                    if (!TextUtils.isEmpty(e2) && !TextUtils.isEmpty(next.a)) {
                        e2 = e2.toLowerCase();
                        if (e2.contains(next.a) || next.a.contains(e2)) {
                            break;
                        } else if (aVarArr[3] == null) {
                            if (a(e2, next.a)) {
                                aVarArr[3] = next;
                            }
                        }
                    }
                    if (aVarArr[4] == null) {
                        if (TextUtils.isEmpty(J)) {
                            if (packageInfo == null) {
                                packageInfo = l.a(bVar);
                            }
                            if (packageInfo != null) {
                                J = packageInfo.versionName;
                            }
                        }
                        if (!TextUtils.isEmpty(J) && !TextUtils.isEmpty(next.f59506c)) {
                            J = J.toLowerCase();
                            if (J.equals(next.f59506c)) {
                                aVarArr[4] = next;
                            }
                        }
                        if (aVarArr[5] == null) {
                            if (I <= 0) {
                                if (packageInfo == null) {
                                    packageInfo = l.a(bVar);
                                }
                                if (packageInfo != null) {
                                    I = packageInfo.versionCode;
                                }
                            }
                            if (I == next.f59505b) {
                                aVarArr[5] = next;
                            }
                        }
                    }
                }
            }
            aVarArr[2] = next;
        }
        for (i2 = 0; i2 < length; i2++) {
            if (aVarArr[i2] != null) {
                return new Pair<>(aVarArr[i2], Integer.valueOf(f59503d[i2]));
            }
        }
        return null;
    }

    public a a(com.ss.android.downloadad.api.a.b bVar) {
        if (bVar == null) {
            return null;
        }
        b();
        synchronized (this.f59504b) {
            Iterator<a> it = this.f59504b.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next.f59508e > bVar.C()) {
                    return next;
                }
            }
            return null;
        }
    }

    public static boolean a(String str, String str2) {
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
                String[] strArr = f59502c;
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

    private void b() {
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this.f59504b) {
            Iterator<a> it = this.f59504b.iterator();
            while (it.hasNext() && currentTimeMillis - it.next().f59508e > FlushManager.ReportTimer.DEFAULT_INTERVAL) {
                it.remove();
            }
        }
    }
}
