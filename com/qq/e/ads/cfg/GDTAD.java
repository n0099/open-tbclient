package com.qq.e.ads.cfg;

import android.content.Context;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.plugin.PM;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
/* loaded from: classes3.dex */
public class GDTAD {

    /* renamed from: b  reason: collision with root package name */
    private static InitListener f11437b;

    /* renamed from: a  reason: collision with root package name */
    private static boolean f11436a = false;
    private static PM.a.InterfaceC1181a c = new PM.a.InterfaceC1181a() { // from class: com.qq.e.ads.cfg.GDTAD.1
        public final void onLoadFail() {
            GDTLogger.w("Init fail", null);
        }

        public final void onLoadSuccess() {
            boolean unused = GDTAD.f11436a = true;
            if (GDTAD.f11437b != null) {
                GDTAD.f11437b.onSuccess();
            }
        }
    };

    /* loaded from: classes3.dex */
    public interface InitListener {
        void onSuccess();
    }

    public static void initSDK(Context context, String str, InitListener initListener) {
        if (f11436a) {
            GDTLogger.w("SDK已经被初始化过", null);
        } else if (context == null) {
            GDTLogger.e("Context参数不能为null");
        } else if (StringUtil.isEmpty(str)) {
            GDTLogger.e("AppId参数不能为空");
        } else {
            f11437b = initListener;
            GDTADManager gDTADManager = GDTADManager.getInstance();
            gDTADManager.setPluginLoadListener(c);
            gDTADManager.initWith(context.getApplicationContext(), str);
        }
    }
}
