package com.qq.e.ads;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.baidu.mapapi.UIMsg;
import com.qq.e.comm.a;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.GDTLogger;
/* loaded from: classes15.dex */
public abstract class LiteAbstractAD<T> {

    /* renamed from: a  reason: collision with root package name */
    private T f11420a;

    protected abstract T a(Context context, POFactory pOFactory, String str, String str2);

    protected abstract void a(int i);

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(final Context context, final String str, final String str2) {
        if (a.a(context)) {
            GDTADManager.INIT_EXECUTOR.execute(new Runnable() { // from class: com.qq.e.ads.LiteAbstractAD.1
                @Override // java.lang.Runnable
                public void run() {
                    if (!GDTADManager.getInstance().initWith(context, str)) {
                        GDTLogger.e("Fail to init ADManager");
                        LiteAbstractAD.this.a(UIMsg.f_FUN.FUN_ID_VOICE_SCH_ACTION);
                        return;
                    }
                    try {
                        final POFactory pOFactory = GDTADManager.getInstance().getPM().getPOFactory();
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.qq.e.ads.LiteAbstractAD.1.1
                            /* JADX DEBUG: Multi-variable search result rejected for r0v9, resolved type: com.qq.e.ads.LiteAbstractAD */
                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    if (pOFactory != null) {
                                        LiteAbstractAD.this.f11420a = LiteAbstractAD.this.a(context, pOFactory, str, str2);
                                        LiteAbstractAD.this.a((LiteAbstractAD) LiteAbstractAD.this.f11420a);
                                    } else {
                                        LiteAbstractAD.this.a(UIMsg.f_FUN.FUN_ID_VOICE_SCH_OPTION);
                                    }
                                } catch (Throwable th) {
                                    GDTLogger.e("Exception while init Core", th);
                                    LiteAbstractAD.this.a(2001);
                                }
                            }
                        });
                    } catch (Throwable th) {
                        GDTLogger.e("Exception while init plugin", th);
                        LiteAbstractAD.this.a(UIMsg.f_FUN.FUN_ID_VOICE_SCH_OPTION);
                    }
                }
            });
            return;
        }
        GDTLogger.e("Required Activity/Service/Permission not declared in AndroidManifest.xml");
        a(4002);
    }

    protected abstract void a(T t);
}
