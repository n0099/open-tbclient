package com.qq.e.comm;

import android.content.Context;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.qq.e.comm.pi.CustomLandingPageListener;
import com.qq.e.comm.util.SystemUtil;
/* loaded from: classes15.dex */
public class StubVisitor {

    /* renamed from: a  reason: collision with root package name */
    private static volatile StubVisitor f11537a;

    private StubVisitor() {
    }

    public static StubVisitor getInstance() {
        if (f11537a == null) {
            synchronized (StubVisitor.class) {
                try {
                    if (f11537a == null) {
                        f11537a = new StubVisitor();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f11537a;
    }

    public String appendPathName(String str) {
        return SystemUtil.buildNewPathByProcessName(str);
    }

    public boolean jumpToCustomLandingPage(Context context, String str, String str2) {
        CustomLandingPageListener customLandingPageListener = GlobalSetting.getCustomLandingPageListener();
        if (customLandingPageListener != null) {
            return customLandingPageListener.jumpToCustomLandingPage(context, str, str2);
        }
        return false;
    }
}
