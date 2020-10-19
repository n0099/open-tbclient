package com.sdk.base.framework.c;

import android.content.Context;
import android.os.Build;
import com.sdk.base.framework.bean.AInfo;
import com.sdk.base.framework.bean.KInfo;
import com.sdk.base.framework.bean.PInfo;
import com.sdk.base.framework.bean.SInfo;
import com.sdk.base.module.config.BaseConfig;
import java.util.ArrayList;
/* loaded from: classes16.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f4482a = false;
    private static String b = "";
    private static String c = "";

    public static AInfo a(Context context) {
        AInfo aInfo = new AInfo();
        aInfo.setN(com.sdk.base.framework.f.a.a.d(context));
        aInfo.setC(com.sdk.base.framework.f.a.a.b(context));
        aInfo.setV(com.sdk.base.framework.f.a.a.a(context));
        aInfo.setPk(com.sdk.base.framework.f.a.a.c(context));
        aInfo.setMd5(com.sdk.base.framework.f.a.a.e(context));
        return aInfo;
    }

    public static SInfo a() {
        SInfo sInfo = new SInfo();
        sInfo.setN(BaseConfig.n);
        sInfo.setC(BaseConfig.c);
        sInfo.setV(BaseConfig.v);
        sInfo.setCm(BaseConfig.cm);
        return sInfo;
    }

    public static ArrayList<KInfo> b(Context context) {
        return com.sdk.base.framework.f.c.a.a(context);
    }

    public static PInfo c(Context context) {
        PInfo pInfo = new PInfo();
        pInfo.setN(Build.MODEL);
        pInfo.setOs("Android");
        pInfo.setC(Build.VERSION.RELEASE);
        pInfo.setImei(com.sdk.base.framework.f.c.b.a(context));
        return pInfo;
    }
}
