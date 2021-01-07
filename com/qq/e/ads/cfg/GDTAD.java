package com.qq.e.ads.cfg;

import android.content.Context;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.plugin.PM;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
/* loaded from: classes4.dex */
public class GDTAD {

    /* renamed from: b  reason: collision with root package name */
    private static InitListener f11737b;

    /* renamed from: a  reason: collision with root package name */
    private static boolean f11736a = false;
    private static PM.a.InterfaceC1198a c = new PM.a.InterfaceC1198a() { // from class: com.qq.e.ads.cfg.GDTAD.1
        public final void onLoadFail() {
            GDTLogger.w("Init fail", null);
        }

        public final void onLoadSuccess() {
            boolean unused = GDTAD.f11736a = true;
            if (GDTAD.f11737b != null) {
                GDTAD.f11737b.onSuccess();
            }
        }
    };

    /* loaded from: classes4.dex */
    public interface InitListener {
        void onSuccess();
    }

    public static void initSDK(Context context, String str, InitListener initListener) {
        if (f11736a) {
            GDTLogger.w("SDK已经被初始化过", null);
        } else if (context == null) {
            GDTLogger.e("Context参数不能为null");
        } else if (StringUtil.isEmpty(str)) {
            GDTLogger.e("AppId参数不能为空");
        } else {
            f11737b = initListener;
            GDTADManager gDTADManager = GDTADManager.getInstance();
            gDTADManager.setPluginLoadListener(c);
            gDTADManager.initWith(context.getApplicationContext(), str);
        }
    }
}
