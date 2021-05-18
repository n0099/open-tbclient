package com.qq.e.comm.managers.status;

import android.content.Context;
import com.qq.e.comm.util.StringUtil;
/* loaded from: classes7.dex */
public class APPStatus {

    /* renamed from: a  reason: collision with root package name */
    public String f35537a;

    /* renamed from: b  reason: collision with root package name */
    public Context f35538b;

    public APPStatus(String str, Context context) {
        this.f35537a = str;
        this.f35538b = context;
    }

    public String getAPPID() {
        return this.f35537a;
    }

    public String getAPPName() {
        return this.f35538b.getPackageName();
    }

    public String getAPPRealName() {
        String aPPName = getAPPName();
        if (!StringUtil.isEmpty(aPPName)) {
            try {
                return this.f35538b.getPackageManager().getPackageInfo(aPPName, 0).applicationInfo.loadLabel(this.f35538b.getPackageManager()).toString();
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public String getAPPVersion() {
        String aPPName = getAPPName();
        if (!StringUtil.isEmpty(aPPName)) {
            try {
                return this.f35538b.getPackageManager().getPackageInfo(aPPName, 0).versionName;
            } catch (Exception unused) {
            }
        }
        return null;
    }
}
