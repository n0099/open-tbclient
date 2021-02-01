package com.qq.e.comm.managers.status;

import android.content.Context;
import com.qq.e.comm.util.StringUtil;
/* loaded from: classes15.dex */
public class APPStatus {

    /* renamed from: a  reason: collision with root package name */
    private String f11561a;

    /* renamed from: b  reason: collision with root package name */
    private Context f11562b;

    public APPStatus(String str, Context context) {
        this.f11561a = str;
        this.f11562b = context;
    }

    public String getAPPID() {
        return this.f11561a;
    }

    public String getAPPName() {
        return this.f11562b.getPackageName();
    }

    public String getAPPRealName() {
        String aPPName = getAPPName();
        if (StringUtil.isEmpty(aPPName)) {
            return null;
        }
        try {
            return this.f11562b.getPackageManager().getPackageInfo(aPPName, 0).applicationInfo.loadLabel(this.f11562b.getPackageManager()).toString();
        } catch (Exception e) {
            return null;
        }
    }

    public String getAPPVersion() {
        String aPPName = getAPPName();
        if (StringUtil.isEmpty(aPPName)) {
            return null;
        }
        try {
            return this.f11562b.getPackageManager().getPackageInfo(aPPName, 0).versionName;
        } catch (Exception e) {
            return null;
        }
    }
}
