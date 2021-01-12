package com.qq.e.ads;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.baidu.mapapi.UIMsg;
import com.qq.e.ads.cfg.BrowserType;
import com.qq.e.ads.cfg.DownAPPConfirmPolicy;
import com.qq.e.comm.a;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.pi.ADI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.AdError;
import com.qq.e.comm.util.GDTLogger;
/* loaded from: classes3.dex */
public abstract class AbstractAD<T extends ADI> {

    /* renamed from: a  reason: collision with root package name */
    private volatile boolean f11409a = false;

    /* renamed from: b  reason: collision with root package name */
    private volatile boolean f11410b = false;
    private T c;
    private BrowserType d;
    private DownAPPConfirmPolicy e;

    /* loaded from: classes3.dex */
    public interface BasicADListener {
        void onNoAD(AdError adError);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final T a() {
        return this.c;
    }

    protected abstract T a(Context context, POFactory pOFactory, String str, String str2);

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(final Context context, final String str, final String str2, final BasicADListener basicADListener) {
        if (a.a(context)) {
            this.f11410b = true;
            GDTADManager.INIT_EXECUTOR.execute(new Runnable() { // from class: com.qq.e.ads.AbstractAD.1
                @Override // java.lang.Runnable
                public void run() {
                    if (!GDTADManager.getInstance().initWith(context, str)) {
                        GDTLogger.e("Fail to init ADManager");
                        AbstractAD.this.a(basicADListener, UIMsg.f_FUN.FUN_ID_VOICE_SCH_ACTION);
                        return;
                    }
                    try {
                        final POFactory pOFactory = GDTADManager.getInstance().getPM().getPOFactory();
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.qq.e.ads.AbstractAD.1.1
                            /* JADX DEBUG: Multi-variable search result rejected for r0v21, resolved type: com.qq.e.ads.AbstractAD */
                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    if (pOFactory == null) {
                                        AbstractAD.this.f11409a = true;
                                        AbstractAD.this.a(basicADListener, UIMsg.f_FUN.FUN_ID_VOICE_SCH_OPTION);
                                        return;
                                    }
                                    AbstractAD.this.c = AbstractAD.this.a(context, pOFactory, str, str2);
                                    AbstractAD.this.f11409a = true;
                                    if (AbstractAD.this.d != null) {
                                        AbstractAD.this.setBrowserType(AbstractAD.this.d);
                                    }
                                    if (AbstractAD.this.e != null) {
                                        AbstractAD.this.setDownAPPConfirmPolicy(AbstractAD.this.e);
                                    }
                                    AbstractAD.this.a((AbstractAD) AbstractAD.this.c);
                                } catch (Throwable th) {
                                    GDTLogger.e("Exception while init Core", th);
                                    AbstractAD.this.f11409a = true;
                                    AbstractAD.this.a(basicADListener, 2001);
                                }
                            }
                        });
                    } catch (Throwable th) {
                        GDTLogger.e("Exception while init plugin", th);
                        AbstractAD.this.a(basicADListener, UIMsg.f_FUN.FUN_ID_VOICE_SCH_OPTION);
                    }
                }
            });
            return;
        }
        GDTLogger.e("Required Activity/Service/Permission not declared in AndroidManifest.xml");
        a(basicADListener, 4002);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(final BasicADListener basicADListener, final int i) {
        if (basicADListener != null) {
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                basicADListener.onNoAD(a.a(i));
            } else {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.qq.e.ads.AbstractAD.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (basicADListener != null) {
                            basicADListener.onNoAD(a.a(i));
                        }
                    }
                });
            }
        }
    }

    protected abstract void a(T t);

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean b() {
        return this.f11409a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean c() {
        return this.f11410b;
    }

    public void setBrowserType(BrowserType browserType) {
        this.d = browserType;
        if (this.c == null || browserType == null) {
            return;
        }
        this.c.setBrowserType(browserType.value());
    }

    public void setDownAPPConfirmPolicy(DownAPPConfirmPolicy downAPPConfirmPolicy) {
        this.e = downAPPConfirmPolicy;
        if (this.c == null || downAPPConfirmPolicy == null) {
            return;
        }
        this.c.setDownAPPConfirmPolicy(downAPPConfirmPolicy);
    }
}
