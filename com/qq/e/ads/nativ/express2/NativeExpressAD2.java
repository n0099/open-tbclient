package com.qq.e.ads.nativ.express2;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.qq.e.ads.AbstractAD;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.pi.NEIADI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.AdErrorConvertor;
import com.qq.e.comm.util.GDTLogger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes7.dex */
public class NativeExpressAD2 extends AbstractAD<NEIADI> {

    /* renamed from: a  reason: collision with root package name */
    public int f35300a;

    /* renamed from: b  reason: collision with root package name */
    public int f35301b;

    /* renamed from: c  reason: collision with root package name */
    public VideoOption2 f35302c;

    /* renamed from: d  reason: collision with root package name */
    public AdLoadListener f35303d;

    /* renamed from: e  reason: collision with root package name */
    public List<Integer> f35304e = Collections.synchronizedList(new ArrayList());

    /* loaded from: classes7.dex */
    public interface AdLoadListener extends AbstractAD.BasicADListener {
        void onLoadSuccess(List<NativeExpressADData2> list);
    }

    /* loaded from: classes7.dex */
    public static class AdLoadListenerAdapter implements ADListener {

        /* renamed from: a  reason: collision with root package name */
        public AdLoadListener f35305a;

        public AdLoadListenerAdapter(AdLoadListener adLoadListener) {
            this.f35305a = adLoadListener;
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            if (this.f35305a != null) {
                int type = aDEvent.getType();
                if (type != 1) {
                    if (type != 2) {
                        return;
                    }
                    if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof Integer)) {
                        this.f35305a.onNoAD(AdErrorConvertor.formatErrorCode(((Integer) aDEvent.getParas()[0]).intValue()));
                    } else {
                        GDTLogger.e("ADEvent.Params error for NativeExpressSecondAD(" + aDEvent + SmallTailInfo.EMOTION_SUFFIX);
                    }
                }
                if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof List)) {
                    this.f35305a.onLoadSuccess((List) aDEvent.getParas()[0]);
                    return;
                }
                GDTLogger.e("ADEvent.Params error for NativeExpressSecondAD(" + aDEvent + SmallTailInfo.EMOTION_SUFFIX);
            }
        }
    }

    public NativeExpressAD2(Context context, String str, AdLoadListener adLoadListener) {
        if (!GDTADManager.getInstance().isInitialized()) {
            GDTLogger.e("SDK 尚未初始化，请在 Application 中调用 GDTADManager.getInstance().initWith() 初始化");
            if (adLoadListener != null) {
                adLoadListener.onNoAD(AdErrorConvertor.formatErrorCode(2003));
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
        this.f35303d = adLoadListener;
        a(context, appid, str, adLoadListener);
    }

    /* JADX DEBUG: Return type fixed from 'com.qq.e.comm.pi.ADI' to match base method */
    @Override // com.qq.e.ads.AbstractAD
    public final /* synthetic */ NEIADI a(Context context, POFactory pOFactory, String str, String str2) {
        return pOFactory.getNativeExpressADDelegate2(context, str, str2, new AdLoadListenerAdapter(this.f35303d));
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.qq.e.comm.pi.ADI] */
    @Override // com.qq.e.ads.AbstractAD
    public final /* synthetic */ void a(NEIADI neiadi) {
        NEIADI neiadi2 = neiadi;
        neiadi2.setAdSize(this.f35300a, this.f35301b);
        neiadi2.setVideoOption(this.f35302c);
        synchronized (this.f35304e) {
            for (Integer num : this.f35304e) {
                loadAd(num.intValue());
            }
        }
    }

    public void loadAd(int i2) {
        if (!c()) {
            GDTLogger.e("AD init Paras OR Context error,details in logs produced while init NativeAD");
        } else if (!b()) {
            this.f35304e.add(Integer.valueOf(i2));
        } else {
            NEIADI a2 = a();
            if (a2 != null) {
                a2.loadAd(i2);
            } else {
                GDTLogger.e("Native Express AD Init error, see more logs");
            }
        }
    }

    public void setAdSize(int i2, int i3) {
        this.f35300a = i2;
        this.f35301b = i3;
        NEIADI a2 = a();
        if (a2 != null) {
            a2.setAdSize(i2, i3);
        }
    }

    public void setVideoOption2(VideoOption2 videoOption2) {
        this.f35302c = videoOption2;
        NEIADI a2 = a();
        if (a2 != null) {
            a2.setVideoOption(videoOption2);
        }
    }
}
