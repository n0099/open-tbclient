package com.qq.e.comm;

import android.content.Context;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.qq.e.comm.pi.CustomLandingPageListener;
import com.qq.e.comm.util.SystemUtil;
/* loaded from: classes3.dex */
public class StubVisitor {

    /* renamed from: a  reason: collision with root package name */
    private static volatile StubVisitor f11834a;

    private StubVisitor() {
    }

    public static StubVisitor getInstance() {
        if (f11834a == null) {
            synchronized (StubVisitor.class) {
                try {
                    if (f11834a == null) {
                        f11834a = new StubVisitor();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f11834a;
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
