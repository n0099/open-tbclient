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
/* loaded from: classes6.dex */
public class NativeExpressAD2 extends AbstractAD<NEIADI> {

    /* renamed from: a  reason: collision with root package name */
    public int f38555a;

    /* renamed from: b  reason: collision with root package name */
    public int f38556b;

    /* renamed from: c  reason: collision with root package name */
    public VideoOption2 f38557c;

    /* renamed from: d  reason: collision with root package name */
    public AdLoadListener f38558d;

    /* renamed from: e  reason: collision with root package name */
    public List<Integer> f38559e = Collections.synchronizedList(new ArrayList());

    /* loaded from: classes6.dex */
    public interface AdLoadListener extends AbstractAD.BasicADListener {
        void onLoadSuccess(List<NativeExpressADData2> list);
    }

    /* loaded from: classes6.dex */
    public static class AdLoadListenerAdapter implements ADListener {

        /* renamed from: a  reason: collision with root package name */
        public AdLoadListener f38560a;

        public AdLoadListenerAdapter(AdLoadListener adLoadListener) {
            this.f38560a = adLoadListener;
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            if (this.f38560a != null) {
                int type = aDEvent.getType();
                if (type != 1) {
                    if (type != 2) {
                        return;
                    }
                    if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof Integer)) {
                        this.f38560a.onNoAD(AdErrorConvertor.formatErrorCode(((Integer) aDEvent.getParas()[0]).intValue()));
                    } else {
                        GDTLogger.e("ADEvent.Params error for NativeExpressSecondAD(" + aDEvent + SmallTailInfo.EMOTION_SUFFIX);
                    }
                }
                if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof List)) {
                    this.f38560a.onLoadSuccess((List) aDEvent.getParas()[0]);
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
        this.f38558d = adLoadListener;
        a(context, appid, str, adLoadListener);
    }

    /* JADX DEBUG: Return type fixed from 'com.qq.e.comm.pi.ADI' to match base method */
    @Override // com.qq.e.ads.AbstractAD
    public final /* synthetic */ NEIADI a(Context context, POFactory pOFactory, String str, String str2) {
        return pOFactory.getNativeExpressADDelegate2(context, str, str2, new AdLoadListenerAdapter(this.f38558d));
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.qq.e.comm.pi.ADI] */
    @Override // com.qq.e.ads.AbstractAD
    public final /* synthetic */ void a(NEIADI neiadi) {
        NEIADI neiadi2 = neiadi;
        neiadi2.setAdSize(this.f38555a, this.f38556b);
        neiadi2.setVideoOption(this.f38557c);
        synchronized (this.f38559e) {
            for (Integer num : this.f38559e) {
                loadAd(num.intValue());
            }
        }
    }

    public void loadAd(int i) {
        if (!c()) {
            GDTLogger.e("AD init Paras OR Context error,details in logs produced while init NativeAD");
        } else if (!b()) {
            this.f38559e.add(Integer.valueOf(i));
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
        this.f38555a = i;
        this.f38556b = i2;
        NEIADI a2 = a();
        if (a2 != null) {
            a2.setAdSize(i, i2);
        }
    }

    public void setVideoOption2(VideoOption2 videoOption2) {
        this.f38557c = videoOption2;
        NEIADI a2 = a();
        if (a2 != null) {
            a2.setVideoOption(videoOption2);
        }
    }
}
