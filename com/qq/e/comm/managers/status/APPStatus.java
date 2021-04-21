package com.qq.e.comm.managers.status;

import android.content.Context;
import com.qq.e.comm.util.StringUtil;
/* loaded from: classes6.dex */
public class APPStatus {

    /* renamed from: a  reason: collision with root package name */
    public String f38713a;

    /* renamed from: b  reason: collision with root package name */
    public Context f38714b;

    public APPStatus(String str, Context context) {
        this.f38713a = str;
        this.f38714b = context;
    }

    public String getAPPID() {
        return this.f38713a;
    }

    public String getAPPName() {
        return this.f38714b.getPackageName();
    }

    public String getAPPRealName() {
        String aPPName = getAPPName();
        if (!StringUtil.isEmpty(aPPName)) {
            try {
                return this.f38714b.getPackageManager().getPackageInfo(aPPName, 0).applicationInfo.loadLabel(this.f38714b.getPackageManager()).toString();
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public String getAPPVersion() {
        String aPPName = getAPPName();
        if (!StringUtil.isEmpty(aPPName)) {
            try {
                return this.f38714b.getPackageManager().getPackageInfo(aPPName, 0).versionName;
            } catch (Exception unused) {
            }
        }
        return null;
    }
}
