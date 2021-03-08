package com.qq.e.ads.cfg;

import android.content.Context;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.plugin.PM;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
/* loaded from: classes4.dex */
public class GDTAD {
    private static InitListener b;

    /* renamed from: a  reason: collision with root package name */
    private static boolean f7501a = false;
    private static PM.a.InterfaceC1204a c = new PM.a.InterfaceC1204a() { // from class: com.qq.e.ads.cfg.GDTAD.1
        @Override // com.qq.e.comm.managers.plugin.PM.a.InterfaceC1204a
        public final void onLoadFail() {
            GDTLogger.w("Init fail", null);
        }

        @Override // com.qq.e.comm.managers.plugin.PM.a.InterfaceC1204a
        public final void onLoadSuccess() {
            boolean unused = GDTAD.f7501a = true;
            if (GDTAD.b != null) {
                GDTAD.b.onSuccess();
            }
        }
    };

    /* loaded from: classes4.dex */
    public interface InitListener {
        void onSuccess();
    }

    public static void initSDK(Context context, String str, InitListener initListener) {
        if (f7501a) {
            GDTLogger.w("SDK已经被初始化过", null);
        } else if (context == null) {
            GDTLogger.e("Context参数不能为null");
        } else if (StringUtil.isEmpty(str)) {
            GDTLogger.e("AppId参数不能为空");
        } else {
            b = initListener;
            GDTADManager gDTADManager = GDTADManager.getInstance();
            gDTADManager.setPluginLoadListener(c);
            gDTADManager.initWith(context.getApplicationContext(), str);
        }
    }
}
