package com.qq.e.comm.managers.status;

import android.content.Context;
import com.qq.e.comm.util.StringUtil;
/* loaded from: classes7.dex */
public class APPStatus {

    /* renamed from: a  reason: collision with root package name */
    public String f39243a;

    /* renamed from: b  reason: collision with root package name */
    public Context f39244b;

    public APPStatus(String str, Context context) {
        this.f39243a = str;
        this.f39244b = context;
    }

    public String getAPPID() {
        return this.f39243a;
    }

    public String getAPPName() {
        return this.f39244b.getPackageName();
    }

    public String getAPPRealName() {
        String aPPName = getAPPName();
        if (!StringUtil.isEmpty(aPPName)) {
            try {
                return this.f39244b.getPackageManager().getPackageInfo(aPPName, 0).applicationInfo.loadLabel(this.f39244b.getPackageManager()).toString();
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public String getAPPVersion() {
        String aPPName = getAPPName();
        if (!StringUtil.isEmpty(aPPName)) {
            try {
                return this.f39244b.getPackageManager().getPackageInfo(aPPName, 0).versionName;
            } catch (Exception unused) {
            }
        }
        return null;
    }
}
