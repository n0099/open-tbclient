package com.xiaomi.push;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.swan.apps.so.SoUtils;
/* loaded from: classes7.dex */
public class dp extends dq {

    /* renamed from: a  reason: collision with root package name */
    public String f37516a;

    public dp(Context context, int i2, String str) {
        super(context, i2);
        this.f37516a = str;
    }

    private String[] a() {
        if (TextUtils.isEmpty(this.f37516a)) {
            return null;
        }
        String b2 = bj.b(this.f37516a);
        if (TextUtils.isEmpty(b2)) {
            return null;
        }
        return b2.contains(",") ? b2.split(",") : new String[]{b2};
    }

    @Override // com.xiaomi.push.dq, com.xiaomi.push.ai.a
    /* renamed from: a */
    public hh mo171a() {
        return hh.AppIsInstalled;
    }

    @Override // com.xiaomi.push.dq, com.xiaomi.push.ai.a
    /* renamed from: a */
    public String mo171a() {
        return SoUtils.SO_EVENT_ID_DEFAULT;
    }

    @Override // com.xiaomi.push.dq
    public String b() {
        String str;
        String[] a2 = a();
        if (a2 == null || a2.length <= 0) {
            return null;
        }
        PackageManager packageManager = ((dq) this).f238a.getPackageManager();
        StringBuilder sb = new StringBuilder();
        for (String str2 : a2) {
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo(str2, 16384);
                if (packageInfo != null) {
                    if (sb.length() > 0) {
                        sb.append(";");
                    }
                    try {
                        str = packageManager.getInstallerPackageName(str2);
                    } catch (IllegalArgumentException unused) {
                        str = null;
                    }
                    if (TextUtils.isEmpty(str)) {
                        str = StringUtil.NULL_STRING;
                    }
                    sb.append(packageInfo.applicationInfo.loadLabel(packageManager).toString());
                    sb.append(",");
                    sb.append(packageInfo.packageName);
                    sb.append(",");
                    sb.append(packageInfo.versionName);
                    sb.append(",");
                    sb.append(packageInfo.versionCode);
                    sb.append(",");
                    sb.append(packageInfo.firstInstallTime);
                    sb.append(",");
                    sb.append(packageInfo.lastUpdateTime);
                    sb.append(",");
                    sb.append(str);
                }
            } catch (Exception unused2) {
            }
        }
        if (sb.length() > 0) {
            return sb.toString();
        }
        return null;
    }
}
