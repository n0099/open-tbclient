package com.qq.e.comm.managers.status;

import android.content.Context;
import com.qq.e.comm.util.StringUtil;
/* loaded from: classes6.dex */
public class APPStatus {

    /* renamed from: a  reason: collision with root package name */
    public String f36292a;

    /* renamed from: b  reason: collision with root package name */
    public Context f36293b;

    public APPStatus(String str, Context context) {
        this.f36292a = str;
        this.f36293b = context;
    }

    public String getAPPID() {
        return this.f36292a;
    }

    public String getAPPName() {
        return this.f36293b.getPackageName();
    }

    public String getAPPRealName() {
        String aPPName = getAPPName();
        if (!StringUtil.isEmpty(aPPName)) {
            try {
                return this.f36293b.getPackageManager().getPackageInfo(aPPName, 0).applicationInfo.loadLabel(this.f36293b.getPackageManager()).toString();
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public String getAPPVersion() {
        String aPPName = getAPPName();
        if (!StringUtil.isEmpty(aPPName)) {
            try {
                return this.f36293b.getPackageManager().getPackageInfo(aPPName, 0).versionName;
            } catch (Exception unused) {
            }
        }
        return null;
    }
}
