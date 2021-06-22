package com.sdk.base.framework.c;

import android.content.Context;
import com.sdk.base.framework.bean.AInfo;
import com.sdk.base.framework.bean.KInfo;
import com.sdk.base.framework.bean.PInfo;
import com.sdk.base.framework.bean.SInfo;
import com.sdk.base.module.config.BaseConfig;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f39425a = false;

    /* renamed from: b  reason: collision with root package name */
    public static String f39426b = "";

    /* renamed from: c  reason: collision with root package name */
    public static String f39427c = "";

    public static AInfo a(Context context) {
        AInfo aInfo = new AInfo();
        aInfo.setN(com.sdk.base.framework.f.a.a.d(context));
        aInfo.setC(com.sdk.base.framework.f.a.a.b(context));
        aInfo.setV(com.sdk.base.framework.f.a.a.a(context));
        aInfo.setPk(com.sdk.base.framework.f.a.a.c(context));
        aInfo.setMd5(com.sdk.base.framework.f.a.a.e(context));
        return aInfo;
    }

    public static ArrayList<KInfo> a() {
        return new ArrayList<>();
    }

    public static SInfo b() {
        SInfo sInfo = new SInfo();
        sInfo.setN(BaseConfig.n);
        sInfo.setC(BaseConfig.f39496c);
        sInfo.setV(BaseConfig.v);
        sInfo.setCm(BaseConfig.cm);
        return sInfo;
    }

    public static PInfo c() {
        PInfo pInfo = new PInfo();
        pInfo.setOs("Android");
        return pInfo;
    }
}
