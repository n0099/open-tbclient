package com.qq.e.comm.managers.status;

import android.content.Context;
import com.qq.e.comm.util.StringUtil;
/* loaded from: classes4.dex */
public class APPStatus {

    /* renamed from: a  reason: collision with root package name */
    private String f7574a;
    private Context b;

    public APPStatus(String str, Context context) {
        this.f7574a = str;
        this.b = context;
    }

    public String getAPPID() {
        return this.f7574a;
    }

    public String getAPPName() {
        return this.b.getPackageName();
    }

    public String getAPPRealName() {
        String aPPName = getAPPName();
        if (StringUtil.isEmpty(aPPName)) {
            return null;
        }
        try {
            return this.b.getPackageManager().getPackageInfo(aPPName, 0).applicationInfo.loadLabel(this.b.getPackageManager()).toString();
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
            return this.b.getPackageManager().getPackageInfo(aPPName, 0).versionName;
        } catch (Exception e) {
            return null;
        }
    }
}
