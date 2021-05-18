package com.qq.e.ads.cfg;

import android.content.Context;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.plugin.PM;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
/* loaded from: classes5.dex */
public class GDTAD {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f35248a = false;

    /* renamed from: b  reason: collision with root package name */
    public static InitListener f35249b;

    /* renamed from: c  reason: collision with root package name */
    public static PM.a.InterfaceC0418a f35250c = new PM.a.InterfaceC0418a() { // from class: com.qq.e.ads.cfg.GDTAD.1
        @Override // com.qq.e.comm.managers.plugin.PM.a.InterfaceC0418a
        public final void onLoadFail() {
            GDTLogger.w("Init fail", null);
        }

        @Override // com.qq.e.comm.managers.plugin.PM.a.InterfaceC0418a
        public final void onLoadSuccess() {
            boolean unused = GDTAD.f35248a = true;
            if (GDTAD.f35249b != null) {
                GDTAD.f35249b.onSuccess();
            }
        }
    };

    /* loaded from: classes5.dex */
    public interface InitListener {
        void onSuccess();
    }

    public static void initSDK(Context context, String str, InitListener initListener) {
        if (f35248a) {
            GDTLogger.w("SDK已经被初始化过", null);
        } else if (context == null) {
            GDTLogger.e("Context参数不能为null");
        } else if (StringUtil.isEmpty(str)) {
            GDTLogger.e("AppId参数不能为空");
        } else {
            f35249b = initListener;
            GDTADManager gDTADManager = GDTADManager.getInstance();
            gDTADManager.setPluginLoadListener(f35250c);
            gDTADManager.initWith(context.getApplicationContext(), str);
        }
    }
}
