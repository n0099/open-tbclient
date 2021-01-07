package com.qq.e.ads.nativ.express2;

import android.content.Context;
import android.text.TextUtils;
import com.qq.e.ads.AbstractAD;
import com.qq.e.comm.a;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.pi.NEIADI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.GDTLogger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes4.dex */
public class NativeExpressAD2 extends AbstractAD<NEIADI> {

    /* renamed from: a  reason: collision with root package name */
    private int f11791a;

    /* renamed from: b  reason: collision with root package name */
    private int f11792b;
    private VideoOption2 c;
    private AdLoadListener d;
    private List<Integer> e = Collections.synchronizedList(new ArrayList());

    /* loaded from: classes4.dex */
    public interface AdLoadListener extends AbstractAD.BasicADListener {
        void onLoadSuccess(List<NativeExpressADData2> list);
    }

    /* loaded from: classes4.dex */
    private static class AdLoadListenerAdapter implements ADListener {

        /* renamed from: a  reason: collision with root package name */
        private AdLoadListener f11793a;

        AdLoadListenerAdapter(AdLoadListener adLoadListener) {
            this.f11793a = adLoadListener;
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            if (this.f11793a != null) {
                switch (aDEvent.getType()) {
                    case 1:
                        break;
                    default:
                        return;
                    case 2:
                        if (aDEvent.getParas().length != 1 || !(aDEvent.getParas()[0] instanceof Integer)) {
                            GDTLogger.e("ADEvent.Params error for NativeExpressSecondAD(" + aDEvent + ")");
                            break;
                        } else {
                            this.f11793a.onNoAD(a.a(((Integer) aDEvent.getParas()[0]).intValue()));
                            break;
                        }
                        break;
                }
                if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof List)) {
                    this.f11793a.onLoadSuccess((List) aDEvent.getParas()[0]);
                } else {
                    GDTLogger.e("ADEvent.Params error for NativeExpressSecondAD(" + aDEvent + ")");
                }
            }
        }
    }

    public NativeExpressAD2(Context context, String str, AdLoadListener adLoadListener) {
        if (!GDTADManager.getInstance().isInitialized()) {
            GDTLogger.e("SDK 尚未初始化，请在 Application 中调用 GDTADManager.getInstance().initWith() 初始化");
            if (adLoadListener != null) {
                adLoadListener.onNoAD(a.a(2003));
                return;
            }
            return;
        }
        String appid = GDTADManager.getInstance().getAppStatus().getAPPID();
        if (context == null || TextUtils.isEmpty(appid) || TextUtils.isEmpty(str) || adLoadListener == null) {
            GDTLogger.e(String.format("NativeExpressSecondAD Constructor params error, context=%s, appId=%s, posId=%s, listener=%s", context, appid, str, adLoadListener));
            a(adLoadListener, 2001);
            return;
        }
        this.d = adLoadListener;
        a(context, appid, str, adLoadListener);
    }

    /* JADX DEBUG: Return type fixed from 'com.qq.e.comm.pi.ADI' to match base method */
    @Override // com.qq.e.ads.AbstractAD
    protected final /* synthetic */ NEIADI a(Context context, POFactory pOFactory, String str, String str2) {
        return pOFactory.getNativeExpressADDelegate2(context, str, str2, new AdLoadListenerAdapter(this.d));
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.qq.e.comm.pi.ADI] */
    @Override // com.qq.e.ads.AbstractAD
    protected final /* synthetic */ void a(NEIADI neiadi) {
        NEIADI neiadi2 = neiadi;
        neiadi2.setAdSize(this.f11791a, this.f11792b);
        neiadi2.setVideoOption(this.c);
        synchronized (this.e) {
            for (Integer num : this.e) {
                loadAd(num.intValue());
            }
        }
    }

    public void loadAd(int i) {
        if (!c()) {
            GDTLogger.e("AD init Paras OR Context error,details in logs produced while init NativeAD");
        } else if (!b()) {
            this.e.add(Integer.valueOf(i));
        } else {
            NEIADI a2 = a();
            if (a2 != null) {
                a2.loadAd(i);
            } else {
                GDTLogger.e("Native Express AD Init error, see more logs");
            }
        }
    }

    public void setAdSize(int i, int i2) {
        this.f11791a = i;
        this.f11792b = i2;
        NEIADI a2 = a();
        if (a2 != null) {
            a2.setAdSize(i, i2);
        }
    }

    public void setVideoOption2(VideoOption2 videoOption2) {
        this.c = videoOption2;
        NEIADI a2 = a();
        if (a2 != null) {
            a2.setVideoOption(videoOption2);
        }
    }
}
