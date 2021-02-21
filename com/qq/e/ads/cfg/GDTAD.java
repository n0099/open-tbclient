package com.qq.e.ads.cfg;

import android.content.Context;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.plugin.PM;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
/* loaded from: classes15.dex */
public class GDTAD {

    /* renamed from: b  reason: collision with root package name */
    private static InitListener f11439b;

    /* renamed from: a  reason: collision with root package name */
    private static boolean f11438a = false;
    private static PM.a.InterfaceC1187a c = new PM.a.InterfaceC1187a() { // from class: com.qq.e.ads.cfg.GDTAD.1
        public final void onLoadFail() {
            GDTLogger.w("Init fail", null);
        }

        public final void onLoadSuccess() {
            boolean unused = GDTAD.f11438a = true;
            if (GDTAD.f11439b != null) {
                GDTAD.f11439b.onSuccess();
            }
        }
    };

    /* loaded from: classes15.dex */
    public interface InitListener {
        void onSuccess();
    }

    public static void initSDK(Context context, String str, InitListener initListener) {
        if (f11438a) {
            GDTLogger.w("SDK已经被初始化过", null);
        } else if (context == null) {
            GDTLogger.e("Context参数不能为null");
        } else if (StringUtil.isEmpty(str)) {
            GDTLogger.e("AppId参数不能为空");
        } else {
            f11439b = initListener;
            GDTADManager gDTADManager = GDTADManager.getInstance();
            gDTADManager.setPluginLoadListener(c);
            gDTADManager.initWith(context.getApplicationContext(), str);
        }
    }
}
