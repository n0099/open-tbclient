package com.qq.e.comm;

import android.content.Context;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.qq.e.comm.pi.CustomLandingPageListener;
import com.qq.e.comm.util.SystemUtil;
/* loaded from: classes7.dex */
public class StubVisitor {

    /* renamed from: a  reason: collision with root package name */
    public static volatile StubVisitor f35391a;

    public static StubVisitor getInstance() {
        if (f35391a == null) {
            synchronized (StubVisitor.class) {
                if (f35391a == null) {
                    f35391a = new StubVisitor();
                }
            }
        }
        return f35391a;
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
