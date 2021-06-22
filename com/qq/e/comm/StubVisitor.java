package com.qq.e.comm;

import android.content.Context;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.qq.e.comm.pi.CustomLandingPageListener;
import com.qq.e.comm.util.SystemUtil;
/* loaded from: classes7.dex */
public class StubVisitor {

    /* renamed from: a  reason: collision with root package name */
    public static volatile StubVisitor f39168a;

    public static StubVisitor getInstance() {
        if (f39168a == null) {
            synchronized (StubVisitor.class) {
                if (f39168a == null) {
                    f39168a = new StubVisitor();
                }
            }
        }
        return f39168a;
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
