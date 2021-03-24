package com.qq.e.ads.cfg;

import android.content.Context;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.plugin.PM;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
/* loaded from: classes6.dex */
public class GDTAD {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f38050a = false;

    /* renamed from: b  reason: collision with root package name */
    public static InitListener f38051b;

    /* renamed from: c  reason: collision with root package name */
    public static PM.a.InterfaceC0469a f38052c = new PM.a.InterfaceC0469a() { // from class: com.qq.e.ads.cfg.GDTAD.1
        @Override // com.qq.e.comm.managers.plugin.PM.a.InterfaceC0469a
        public final void onLoadFail() {
            GDTLogger.w("Init fail", null);
        }

        @Override // com.qq.e.comm.managers.plugin.PM.a.InterfaceC0469a
        public final void onLoadSuccess() {
            boolean unused = GDTAD.f38050a = true;
            if (GDTAD.f38051b != null) {
                GDTAD.f38051b.onSuccess();
            }
        }
    };

    /* loaded from: classes6.dex */
    public interface InitListener {
        void onSuccess();
    }

    public static void initSDK(Context context, String str, InitListener initListener) {
        if (f38050a) {
            GDTLogger.w("SDK已经被初始化过", null);
        } else if (context == null) {
            GDTLogger.e("Context参数不能为null");
        } else if (StringUtil.isEmpty(str)) {
            GDTLogger.e("AppId参数不能为空");
        } else {
            f38051b = initListener;
            GDTADManager gDTADManager = GDTADManager.getInstance();
            gDTADManager.setPluginLoadListener(f38052c);
            gDTADManager.initWith(context.getApplicationContext(), str);
        }
    }
}
