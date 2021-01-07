package com.ss.android.downloadlib.a.b;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.ar.constants.HttpConstants;
import com.ss.android.downloadlib.a.j;
import com.ss.android.downloadlib.f.i;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes4.dex */
public class c {
    private static final String[] c = {"com", HttpConstants.OS_TYPE_VALUE, "ss"};
    private static final int[] d = {3101, 3102, 3103, 3201, 3202, 3203};
    private static volatile c pVu;

    /* renamed from: b  reason: collision with root package name */
    private final LinkedList<a> f13233b = new LinkedList<>();

    private c() {
    }

    public static c eFS() {
        if (pVu == null) {
            synchronized (c.class) {
                if (pVu == null) {
                    pVu = new c();
                }
            }
        }
        return pVu;
    }

    public void a(String str) {
        a aaL;
        b();
        if (!TextUtils.isEmpty(str) && (aaL = aaL(str)) != null) {
            synchronized (this.f13233b) {
                this.f13233b.add(aaL);
            }
        }
    }

    public void b(String str) {
        b();
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.f13233b) {
                Iterator<a> it = this.f13233b.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    } else if (str.equals(it.next().f13234a)) {
                        it.remove();
                        break;
                    }
                }
            }
        }
    }

    public a e(com.ss.android.b.a.b.a aVar) {
        a aVar2;
        if (aVar == null) {
            return null;
        }
        b();
        synchronized (this.f13233b) {
            Iterator<a> it = this.f13233b.iterator();
            while (true) {
                if (!it.hasNext()) {
                    aVar2 = null;
                    break;
                }
                aVar2 = it.next();
                if (aVar2.e > aVar.f()) {
                    break;
                }
            }
        }
        return aVar2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x00be, code lost:
        r9[1] = r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Pair<a, Integer> f(com.ss.android.b.a.b.a aVar) {
        a next;
        PackageInfo packageInfo;
        if (aVar == null) {
            return null;
        }
        try {
            b();
            if (this.f13233b.isEmpty()) {
                return null;
            }
            String C = aVar.C();
            String m = aVar.m();
            String s = aVar.s();
            int r = aVar.r();
            a[] aVarArr = new a[d.length];
            synchronized (this.f13233b) {
                Iterator<a> it = this.f13233b.iterator();
                PackageInfo packageInfo2 = null;
                String str = C;
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    next = it.next();
                    if (next.e >= aVar.f()) {
                        if (TextUtils.isEmpty(str)) {
                            if (packageInfo2 == null) {
                                packageInfo2 = i.h(aVar);
                            }
                            if (packageInfo2 != null) {
                                try {
                                    str = (String) j.a().getPackageManager().getApplicationLabel(packageInfo2.applicationInfo);
                                } catch (Throwable th) {
                                }
                            }
                        }
                        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(next.d)) {
                            str = str.toLowerCase();
                            if (str.equals(next.d)) {
                                aVarArr[0] = next;
                                break;
                            } else if (str.contains(next.d) || next.d.contains(str)) {
                                break;
                            }
                        }
                        if (TextUtils.isEmpty(m)) {
                            packageInfo = packageInfo2 == null ? i.h(aVar) : packageInfo2;
                            if (packageInfo != null) {
                                m = packageInfo.packageName;
                            }
                        } else {
                            packageInfo = packageInfo2;
                        }
                        if (!TextUtils.isEmpty(m) && !TextUtils.isEmpty(next.f13234a)) {
                            m = m.toLowerCase();
                            if (m.contains(next.f13234a) || next.f13234a.contains(m)) {
                                break;
                            } else if (aVarArr[3] != null) {
                                packageInfo2 = packageInfo;
                            } else if (a(m, next.f13234a)) {
                                aVarArr[3] = next;
                                packageInfo2 = packageInfo;
                            }
                        }
                        if (aVarArr[4] != null) {
                            packageInfo2 = packageInfo;
                        } else {
                            if (TextUtils.isEmpty(s)) {
                                if (packageInfo == null) {
                                    packageInfo = i.h(aVar);
                                }
                                if (packageInfo != null) {
                                    s = packageInfo.versionName;
                                }
                            }
                            if (!TextUtils.isEmpty(s) && !TextUtils.isEmpty(next.c)) {
                                s = s.toLowerCase();
                                if (s.equals(next.c)) {
                                    aVarArr[4] = next;
                                    packageInfo2 = packageInfo;
                                }
                            }
                            if (aVarArr[5] != null) {
                                packageInfo2 = packageInfo;
                            } else {
                                if (r <= 0) {
                                    if (packageInfo == null) {
                                        packageInfo = i.h(aVar);
                                    }
                                    if (packageInfo != null) {
                                        r = packageInfo.versionCode;
                                    }
                                }
                                if (r == next.f13235b) {
                                    aVarArr[5] = next;
                                }
                                packageInfo2 = packageInfo;
                            }
                        }
                    }
                }
                aVarArr[2] = next;
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= aVarArr.length) {
                    break;
                } else if (aVarArr[i2] == null) {
                    i = i2 + 1;
                } else {
                    return new Pair<>(aVarArr[i2], Integer.valueOf(d[i2]));
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        return null;
    }

    private void b() {
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this.f13233b) {
            Iterator<a> it = this.f13233b.iterator();
            while (it.hasNext() && currentTimeMillis - it.next().e > 1800000) {
                it.remove();
            }
        }
    }

    private a aaL(String str) {
        try {
            PackageManager packageManager = j.a().getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            if (packageInfo != null) {
                return new a(str, packageInfo.versionCode, packageInfo.versionName, (String) packageManager.getApplicationLabel(packageInfo.applicationInfo), System.currentTimeMillis());
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return null;
    }

    private static boolean a(String str, String str2) {
        String[] split;
        String[] split2;
        boolean z;
        int i;
        try {
            split = str.split("\\.");
            split2 = str2.split("\\.");
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (split.length == 0 || split2.length == 0) {
            return false;
        }
        int i2 = 0;
        int i3 = 0;
        for (String str3 : split) {
            String[] strArr = c;
            int length = strArr.length;
            int i4 = 0;
            while (true) {
                if (i4 >= length) {
                    z = false;
                    i = i2;
                    break;
                }
                String str4 = strArr[i4];
                if (!str4.equals(str3)) {
                    i4++;
                } else {
                    if (i2 < split2.length && str4.equals(split2[i2])) {
                        i2++;
                    }
                    z = true;
                    i = i2;
                }
            }
            if (z) {
                i2 = i;
            } else {
                i2 = i;
                for (int i5 = i; i5 < split2.length; i5++) {
                    if (str3.equals(split2[i5])) {
                        if (i5 == i2) {
                            i2++;
                        }
                        i3++;
                        if (i3 >= 2) {
                            return true;
                        }
                    }
                }
                continue;
            }
        }
        return false;
    }

    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final String f13234a;

        /* renamed from: b  reason: collision with root package name */
        public final int f13235b;
        public final String c;
        public final String d;
        public final long e;

        private a(String str, int i, String str2, String str3, long j) {
            this.f13234a = str;
            this.f13235b = i;
            this.c = str2 != null ? str2.toLowerCase() : null;
            this.d = str3 != null ? str3.toLowerCase() : null;
            this.e = j;
        }
    }
}
