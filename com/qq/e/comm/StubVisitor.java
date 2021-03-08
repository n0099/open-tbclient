package com.qq.e.comm;

import android.content.Context;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.qq.e.comm.pi.CustomLandingPageListener;
import com.qq.e.comm.util.SystemUtil;
/* loaded from: classes4.dex */
public class StubVisitor {

    /* renamed from: a  reason: collision with root package name */
    private static volatile StubVisitor f7556a;

    private StubVisitor() {
    }

    public static StubVisitor getInstance() {
        if (f7556a == null) {
            synchronized (StubVisitor.class) {
                if (f7556a == null) {
                    f7556a = new StubVisitor();
                }
            }
        }
        return f7556a;
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
