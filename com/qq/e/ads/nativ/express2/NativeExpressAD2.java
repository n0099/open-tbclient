package com.qq.e.ads.nativ.express2;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f37843a;

    /* renamed from: b  reason: collision with root package name */
    public int f37844b;

    /* renamed from: c  reason: collision with root package name */
    public VideoOption2 f37845c;

    /* renamed from: d  reason: collision with root package name */
    public AdLoadListener f37846d;

    /* renamed from: e  reason: collision with root package name */
    public List<Integer> f37847e;

    /* loaded from: classes6.dex */
    public interface AdLoadListener extends AbstractAD.BasicADListener {
        void onLoadSuccess(List<NativeExpressADData2> list);
    }

    /* loaded from: classes6.dex */
    public static class AdLoadListenerAdapter implements ADListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public AdLoadListener f37848a;

        public AdLoadListenerAdapter(AdLoadListener adLoadListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adLoadListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f37848a = adLoadListener;
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aDEvent) == null) || this.f37848a == null) {
                return;
            }
            int type = aDEvent.getType();
            if (type != 1) {
                if (type != 2) {
                    return;
                }
                if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof Integer)) {
                    this.f37848a.onNoAD(AdErrorConvertor.formatErrorCode(((Integer) aDEvent.getParas()[0]).intValue()));
                } else {
                    GDTLogger.e("ADEvent.Params error for NativeExpressSecondAD(" + aDEvent + SmallTailInfo.EMOTION_SUFFIX);
                }
            }
            if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof List)) {
                this.f37848a.onLoadSuccess((List) aDEvent.getParas()[0]);
                return;
            }
            GDTLogger.e("ADEvent.Params error for NativeExpressSecondAD(" + aDEvent + SmallTailInfo.EMOTION_SUFFIX);
        }
    }

    public NativeExpressAD2(Context context, String str, AdLoadListener adLoadListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, adLoadListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f37847e = Collections.synchronizedList(new ArrayList());
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
        this.f37846d = adLoadListener;
        a(context, appid, str, adLoadListener);
    }

    /* JADX DEBUG: Return type fixed from 'com.qq.e.comm.pi.ADI' to match base method */
    @Override // com.qq.e.ads.AbstractAD
    public final /* synthetic */ NEIADI a(Context context, POFactory pOFactory, String str, String str2) {
        return pOFactory.getNativeExpressADDelegate2(context, str, str2, new AdLoadListenerAdapter(this.f37846d));
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.qq.e.comm.pi.ADI] */
    @Override // com.qq.e.ads.AbstractAD
    public final /* synthetic */ void a(NEIADI neiadi) {
        NEIADI neiadi2 = neiadi;
        neiadi2.setAdSize(this.f37843a, this.f37844b);
        neiadi2.setVideoOption(this.f37845c);
        synchronized (this.f37847e) {
            for (Integer num : this.f37847e) {
                loadAd(num.intValue());
            }
        }
    }

    public void loadAd(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            if (!c()) {
                GDTLogger.e("AD init Paras OR Context error,details in logs produced while init NativeAD");
            } else if (!b()) {
                this.f37847e.add(Integer.valueOf(i2));
            } else {
                NEIADI a2 = a();
                if (a2 != null) {
                    a2.loadAd(i2);
                } else {
                    GDTLogger.e("Native Express AD Init error, see more logs");
                }
            }
        }
    }

    public void setAdSize(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i2, i3) == null) {
            this.f37843a = i2;
            this.f37844b = i3;
            NEIADI a2 = a();
            if (a2 != null) {
                a2.setAdSize(i2, i3);
            }
        }
    }

    public void setVideoOption2(VideoOption2 videoOption2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, videoOption2) == null) {
            this.f37845c = videoOption2;
            NEIADI a2 = a();
            if (a2 != null) {
                a2.setVideoOption(videoOption2);
            }
        }
    }
}
