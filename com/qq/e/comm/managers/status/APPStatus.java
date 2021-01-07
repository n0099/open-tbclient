package com.qq.e.comm.managers.status;

import android.content.Context;
import com.qq.e.comm.util.StringUtil;
/* loaded from: classes4.dex */
public class APPStatus {

    /* renamed from: a  reason: collision with root package name */
    private String f11859a;

    /* renamed from: b  reason: collision with root package name */
    private Context f11860b;

    public APPStatus(String str, Context context) {
        this.f11859a = str;
        this.f11860b = context;
    }

    public String getAPPID() {
        return this.f11859a;
    }

    public String getAPPName() {
        return this.f11860b.getPackageName();
    }

    public String getAPPRealName() {
        String aPPName = getAPPName();
        if (StringUtil.isEmpty(aPPName)) {
            return null;
        }
        try {
            return this.f11860b.getPackageManager().getPackageInfo(aPPName, 0).applicationInfo.loadLabel(this.f11860b.getPackageManager()).toString();
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
            return this.f11860b.getPackageManager().getPackageInfo(aPPName, 0).versionName;
        } catch (Exception e) {
            return null;
        }
    }
}
