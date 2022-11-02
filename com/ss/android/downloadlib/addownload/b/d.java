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
/* loaded from: classes8.dex */
public class d {
    public static volatile d a;
    public static final String[] c = {"com", "android", "ss"};
    public static final int[] d = {3101, 3102, 3103, 3201, 3202, 3203};
    public final LinkedList<a> b = new LinkedList<>();

    /* loaded from: classes8.dex */
    public static class a {
        public final String a;
        public final int b;
        public final String c;
        public final String d;
        public final long e;

        public a(String str, int i, String str2, String str3, long j) {
            String str4;
            this.a = str;
            this.b = i;
            if (str2 != null) {
                str4 = str2.toLowerCase();
            } else {
                str4 = null;
            }
            this.c = str4;
            this.d = str3 != null ? str3.toLowerCase() : null;
            this.e = j;
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

    private void b() {
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this.b) {
            Iterator<a> it = this.b.iterator();
            while (it.hasNext() && currentTimeMillis - it.next().e > FlushManager.ReportTimer.DEFAULT_INTERVAL) {
                it.remove();
            }
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
            int i = 0;
            int i2 = 0;
            for (String str3 : split) {
                String[] strArr = c;
                int length = strArr.length;
                int i3 = 0;
                while (true) {
                    if (i3 < length) {
                        String str4 = strArr[i3];
                        if (str4.equals(str3)) {
                            if (i < split2.length && str4.equals(split2[i])) {
                                i++;
                            }
                            z = true;
                        } else {
                            i3++;
                        }
                    } else {
                        z = false;
                        break;
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

    public a a(com.ss.android.downloadad.api.a.b bVar) {
        if (bVar == null) {
            return null;
        }
        b();
        synchronized (this.b) {
            Iterator<a> it = this.b.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next.e > bVar.C()) {
                    return next;
                }
            }
            return null;
        }
    }

    public void b(String str) {
        b();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.b) {
            Iterator<a> it = this.b.iterator();
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
        if (!TextUtils.isEmpty(str) && (c2 = c(str)) != null) {
            synchronized (this.b) {
                this.b.add(c2);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0096, code lost:
        r7[1] = r11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Pair<a, Integer> b(com.ss.android.downloadad.api.a.b bVar) {
        int i;
        a next;
        if (bVar == null) {
            return null;
        }
        try {
            b();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (this.b.isEmpty()) {
            return null;
        }
        String N = bVar.N();
        String e = bVar.e();
        String J = bVar.J();
        int I = bVar.I();
        int length = d.length;
        a[] aVarArr = new a[length];
        synchronized (this.b) {
            Iterator<a> it = this.b.iterator();
            PackageInfo packageInfo = null;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                next = it.next();
                if (next.e >= bVar.C()) {
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
                    if (!TextUtils.isEmpty(N) && !TextUtils.isEmpty(next.d)) {
                        N = N.toLowerCase();
                        if (N.equals(next.d)) {
                            aVarArr[0] = next;
                            break;
                        } else if (N.contains(next.d) || next.d.contains(N)) {
                            break;
                        }
                    }
                    if (TextUtils.isEmpty(e)) {
                        if (packageInfo == null) {
                            packageInfo = l.a(bVar);
                        }
                        if (packageInfo != null) {
                            e = packageInfo.packageName;
                        }
                    }
                    if (!TextUtils.isEmpty(e) && !TextUtils.isEmpty(next.a)) {
                        e = e.toLowerCase();
                        if (e.contains(next.a) || next.a.contains(e)) {
                            break;
                        } else if (aVarArr[3] == null) {
                            if (a(e, next.a)) {
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
                        if (!TextUtils.isEmpty(J) && !TextUtils.isEmpty(next.c)) {
                            J = J.toLowerCase();
                            if (J.equals(next.c)) {
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
                            if (I == next.b) {
                                aVarArr[5] = next;
                            }
                        }
                    }
                }
            }
            aVarArr[2] = next;
        }
        for (i = 0; i < length; i++) {
            if (aVarArr[i] != null) {
                return new Pair<>(aVarArr[i], Integer.valueOf(d[i]));
            }
        }
        return null;
    }
}
