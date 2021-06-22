package com.qq.e.ads;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.qq.e.ads.cfg.BrowserType;
import com.qq.e.ads.cfg.DownAPPConfirmPolicy;
import com.qq.e.comm.a;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.pi.ADI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.AdError;
import com.qq.e.comm.util.AdErrorConvertor;
import com.qq.e.comm.util.GDTLogger;
/* loaded from: classes7.dex */
public abstract class AbstractAD<T extends ADI> {

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f38909a = false;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f38910b = false;

    /* renamed from: c  reason: collision with root package name */
    public T f38911c;

    /* renamed from: d  reason: collision with root package name */
    public BrowserType f38912d;

    /* renamed from: e  reason: collision with root package name */
    public DownAPPConfirmPolicy f38913e;

    /* loaded from: classes7.dex */
    public interface BasicADListener {
        void onNoAD(AdError adError);
    }

    public final T a() {
        return this.f38911c;
    }

    public abstract T a(Context context, POFactory pOFactory, String str, String str2);

    public final void a(final Context context, final String str, final String str2, final BasicADListener basicADListener) {
        if (a.a(context)) {
            this.f38910b = true;
            GDTADManager.INIT_EXECUTOR.execute(new Runnable() { // from class: com.qq.e.ads.AbstractAD.1
                @Override // java.lang.Runnable
                public void run() {
                    AbstractAD abstractAD;
                    BasicADListener basicADListener2;
                    int i2;
                    if (GDTADManager.getInstance().initWith(context, str)) {
                        try {
                            final POFactory pOFactory = GDTADManager.getInstance().getPM().getPOFactory();
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.qq.e.ads.AbstractAD.1.1
                                /* JADX DEBUG: Multi-variable search result rejected for r1v20, resolved type: com.qq.e.ads.AbstractAD */
                                /* JADX WARN: Multi-variable type inference failed */
                                @Override // java.lang.Runnable
                                public void run() {
                                    try {
                                        if (pOFactory == null) {
                                            AbstractAD.this.f38909a = true;
                                            AbstractAD.this.a(basicADListener, 200102);
                                            return;
                                        }
                                        AbstractAD.this.f38911c = AbstractAD.this.a(context, pOFactory, str, str2);
                                        AbstractAD.this.f38909a = true;
                                        if (AbstractAD.this.f38912d != null) {
                                            AbstractAD.this.setBrowserType(AbstractAD.this.f38912d);
                                        }
                                        if (AbstractAD.this.f38913e != null) {
                                            AbstractAD.this.setDownAPPConfirmPolicy(AbstractAD.this.f38913e);
                                        }
                                        AbstractAD.this.a((AbstractAD) AbstractAD.this.f38911c);
                                    } catch (Throwable th) {
                                        GDTLogger.e("Exception while init Core", th);
                                        AbstractAD.this.f38909a = true;
                                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                        AbstractAD.this.a(basicADListener, 2001);
                                    }
                                }
                            });
                            return;
                        } catch (Throwable th) {
                            GDTLogger.e("Exception while init plugin", th);
                            abstractAD = AbstractAD.this;
                            basicADListener2 = basicADListener;
                            i2 = 200102;
                        }
                    } else {
                        GDTLogger.e("Fail to init ADManager");
                        abstractAD = AbstractAD.this;
                        basicADListener2 = basicADListener;
                        i2 = 200101;
                    }
                    abstractAD.a(basicADListener2, i2);
                }
            });
            return;
        }
        GDTLogger.e("Required Activity/Service/Permission not declared in AndroidManifest.xml");
        a(basicADListener, 4002);
    }

    public void a(final BasicADListener basicADListener, final int i2) {
        if (basicADListener != null) {
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                basicADListener.onNoAD(AdErrorConvertor.formatErrorCode(i2));
            } else {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.qq.e.ads.AbstractAD.2
                    @Override // java.lang.Runnable
                    public void run() {
                        BasicADListener basicADListener2 = basicADListener;
                        if (basicADListener2 != null) {
                            basicADListener2.onNoAD(AdErrorConvertor.formatErrorCode(i2));
                        }
                    }
                });
            }
        }
    }

    public abstract void a(T t);

    public final boolean b() {
        return this.f38909a;
    }

    public final boolean c() {
        return this.f38910b;
    }

    public void setBrowserType(BrowserType browserType) {
        this.f38912d = browserType;
        T t = this.f38911c;
        if (t == null || browserType == null) {
            return;
        }
        t.setBrowserType(browserType.value());
    }

    public void setDownAPPConfirmPolicy(DownAPPConfirmPolicy downAPPConfirmPolicy) {
        this.f38913e = downAPPConfirmPolicy;
        T t = this.f38911c;
        if (t == null || downAPPConfirmPolicy == null) {
            return;
        }
        t.setDownAPPConfirmPolicy(downAPPConfirmPolicy);
    }
}
