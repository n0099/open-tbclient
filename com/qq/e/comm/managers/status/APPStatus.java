package com.qq.e.comm.managers.status;

import android.content.Context;
import com.qq.e.comm.util.StringUtil;
/* loaded from: classes6.dex */
public class APPStatus {

    /* renamed from: a  reason: collision with root package name */
    public String f38618a;

    /* renamed from: b  reason: collision with root package name */
    public Context f38619b;

    public APPStatus(String str, Context context) {
        this.f38618a = str;
        this.f38619b = context;
    }

    public String getAPPID() {
        return this.f38618a;
    }

    public String getAPPName() {
        return this.f38619b.getPackageName();
    }

    public String getAPPRealName() {
        String aPPName = getAPPName();
        if (!StringUtil.isEmpty(aPPName)) {
            try {
                return this.f38619b.getPackageManager().getPackageInfo(aPPName, 0).applicationInfo.loadLabel(this.f38619b.getPackageManager()).toString();
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public String getAPPVersion() {
        String aPPName = getAPPName();
        if (!StringUtil.isEmpty(aPPName)) {
            try {
                return this.f38619b.getPackageManager().getPackageInfo(aPPName, 0).versionName;
            } catch (Exception unused) {
            }
        }
        return null;
    }
}
