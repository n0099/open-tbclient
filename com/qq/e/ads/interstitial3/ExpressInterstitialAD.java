package com.qq.e.ads.interstitial3;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.ads.AbstractAD;
import com.qq.e.ads.LiteAbstractAD;
import com.qq.e.ads.interstitial2.ADRewardListener;
import com.qq.e.ads.nativ.express2.VideoOption2;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.pi.UIADI2;
import com.qq.e.comm.util.AdErrorConvertor;
import com.qq.e.comm.util.CallbackUtil;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.VideoAdValidity;
import java.util.HashMap;
import java.util.Map;
@Deprecated
/* loaded from: classes5.dex */
public class ExpressInterstitialAD extends LiteAbstractAD<UIADI2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean g;
    public boolean h;
    public VideoOption2 i;
    public AdListenerAdapter j;
    public ExpressInterstitialAdListener k;
    public ServerSideVerificationOptions l;

    /* loaded from: classes5.dex */
    public static class AdListenerAdapter implements ADListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ExpressInterstitialAdListener a;
        public ADRewardListener b;

        public AdListenerAdapter(ExpressInterstitialAdListener expressInterstitialAdListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {expressInterstitialAdListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = expressInterstitialAdListener;
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aDEvent) == null) || this.a == null || aDEvent == null) {
                return;
            }
            switch (aDEvent.getType()) {
                case 100:
                    this.a.onAdLoaded();
                    return;
                case 101:
                    this.a.onVideoCached();
                    return;
                case 102:
                    this.a.onShow();
                    return;
                case 103:
                    this.a.onExpose();
                    return;
                case 104:
                    if (this.b != null) {
                        Object obj = aDEvent.getParas()[0];
                        HashMap hashMap = null;
                        if (obj instanceof String) {
                            HashMap hashMap2 = new HashMap();
                            hashMap2.put(ServerSideVerificationOptions.TRANS_ID, String.valueOf(aDEvent.getParas()[0]));
                            hashMap = hashMap2;
                        } else if (obj instanceof Map) {
                            hashMap = (Map) obj;
                        }
                        ADRewardListener aDRewardListener = this.b;
                        if (aDRewardListener == null || hashMap == null) {
                            return;
                        }
                        aDRewardListener.onReward(hashMap);
                        return;
                    }
                    return;
                case 105:
                    this.a.onClick();
                    return;
                case 106:
                    this.a.onClose();
                    return;
                case 107:
                    if (aDEvent.getParas().length < 1 || !(aDEvent.getParas()[0] instanceof Integer)) {
                        AbstractAD.a(ExpressInterstitialAD.class, aDEvent);
                        return;
                    } else {
                        this.a.onError(AdErrorConvertor.formatErrorCode(((Integer) aDEvent.getParas()[0]).intValue()));
                        return;
                    }
                case 108:
                    this.a.onVideoComplete();
                    return;
                case 109:
                    if (CallbackUtil.hasRenderSuccessCallback(this.a)) {
                        this.a.onRenderSuccess();
                        return;
                    }
                    return;
                case 110:
                    if (CallbackUtil.hasRenderFailCallback(this.a)) {
                        this.a.onRenderFail();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }

        public void setRewardListener(ADRewardListener aDRewardListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aDRewardListener) == null) {
                this.b = aDRewardListener;
            }
        }
    }

    public ExpressInterstitialAD(Context context, String str, ExpressInterstitialAdListener expressInterstitialAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, expressInterstitialAdListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        GDTLogger.e("ExpressInterstitialAD 接口即将被移除，请使用 UnifiedInterstitialAD 接口");
        this.k = expressInterstitialAdListener;
        a(context, str);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ExpressInterstitialAD(Context context, String str, String str2, ExpressInterstitialAdListener expressInterstitialAdListener) {
        this(context, str2, expressInterstitialAdListener);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, str2, expressInterstitialAdListener};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (String) objArr2[1], (ExpressInterstitialAdListener) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        c();
    }

    public UIADI2 a(Context context, POFactory pOFactory, String str, String str2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, pOFactory, str, str2)) == null) {
            AdListenerAdapter adListenerAdapter = new AdListenerAdapter(this.k);
            this.j = adListenerAdapter;
            return pOFactory.getExpressInterstitialADDelegate(context, str, str2, adListenerAdapter);
        }
        return (UIADI2) invokeLLLL.objValue;
    }

    @Override // com.qq.e.ads.AbstractAD
    public /* bridge */ /* synthetic */ Object a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        return a(context, pOFactory, str, str2);
    }

    @Override // com.qq.e.ads.AbstractAD
    public /* bridge */ /* synthetic */ void a(Object obj) {
        UIADI2 uiadi2 = (UIADI2) obj;
        d();
    }

    @Override // com.qq.e.ads.AbstractAD
    public void b(int i) {
        ExpressInterstitialAdListener expressInterstitialAdListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i) == null) || (expressInterstitialAdListener = this.k) == null) {
            return;
        }
        expressInterstitialAdListener.onError(AdErrorConvertor.formatErrorCode(i));
    }

    public VideoAdValidity checkValidity() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (hasShown()) {
                return VideoAdValidity.SHOWED;
            }
            if (SystemClock.elapsedRealtime() > getExpireTimestamp()) {
                return VideoAdValidity.OVERDUE;
            }
            if (isVideoAd()) {
                T t = this.a;
                if (t != 0) {
                    z = ((UIADI2) t).isVideoCached();
                } else {
                    a("isVideoCached");
                    z = false;
                }
                if (!z) {
                    return VideoAdValidity.NONE_CACHE;
                }
            }
            return VideoAdValidity.VALID;
        }
        return (VideoAdValidity) invokeV.objValue;
    }

    public void closeHalfScreenAD() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            T t = this.a;
            if (t != 0) {
                ((UIADI2) t).closeHalfScreenAD();
            } else {
                a("closeHalfScreenAD");
            }
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            ((UIADI2) this.a).setVideoOption(this.i);
            ((UIADI2) this.a).setServerSideVerificationOptions(this.l);
            if (this.g) {
                ((UIADI2) this.a).loadHalfScreenAD();
                this.g = false;
            }
            if (this.h) {
                ((UIADI2) this.a).loadFullScreenAD();
                this.h = false;
            }
        }
    }

    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            T t = this.a;
            if (t != 0) {
                ((UIADI2) t).destroy();
            } else {
                a("destroy");
            }
        }
    }

    public long getExpireTimestamp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            T t = this.a;
            if (t != 0) {
                return ((UIADI2) t).getExpireTimestamp();
            }
            a("getExpireTimestamp");
            return 0L;
        }
        return invokeV.longValue;
    }

    public int getVideoDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            T t = this.a;
            if (t != 0) {
                return ((UIADI2) t).getVideoDuration();
            }
            a("getVideoDuration");
            return 0;
        }
        return invokeV.intValue;
    }

    public boolean hasShown() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            T t = this.a;
            if (t != 0) {
                return ((UIADI2) t).hasShown();
            }
            a("hasShown");
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isVideoAd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            T t = this.a;
            if (t != 0) {
                return ((UIADI2) t).isVideoAd();
            }
            a("isVideoAd");
            return false;
        }
        return invokeV.booleanValue;
    }

    public void loadFullScreenAD() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && a()) {
            if (!b()) {
                this.h = true;
                return;
            }
            T t = this.a;
            if (t != 0) {
                ((UIADI2) t).loadFullScreenAD();
            } else {
                a("loadFullScreenAD");
            }
        }
    }

    public void loadHalfScreenAD() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && a()) {
            if (!b()) {
                this.g = true;
                return;
            }
            T t = this.a;
            if (t != 0) {
                ((UIADI2) t).loadHalfScreenAD();
            } else {
                a("loadHalfScreenAD");
            }
        }
    }

    public void setRewardListener(ADRewardListener aDRewardListener) {
        AdListenerAdapter adListenerAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, aDRewardListener) == null) || (adListenerAdapter = this.j) == null) {
            return;
        }
        adListenerAdapter.setRewardListener(aDRewardListener);
    }

    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, serverSideVerificationOptions) == null) {
            T t = this.a;
            if (t != 0) {
                ((UIADI2) t).setServerSideVerificationOptions(serverSideVerificationOptions);
            } else {
                this.l = serverSideVerificationOptions;
            }
        }
    }

    public void setVideoOption(VideoOption2 videoOption2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, videoOption2) == null) {
            T t = this.a;
            if (t != 0) {
                ((UIADI2) t).setVideoOption(videoOption2);
            } else {
                this.i = videoOption2;
            }
        }
    }

    public void showFullScreenAD(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, activity) == null) {
            T t = this.a;
            if (t != 0) {
                ((UIADI2) t).showFullScreenAD(activity);
            } else {
                a("showFullScreenAD");
            }
        }
    }

    public void showHalfScreenAD(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, activity) == null) {
            T t = this.a;
            if (t != 0) {
                ((UIADI2) t).showHalfScreenAD(activity);
            } else {
                a("showHalfScreenAD");
            }
        }
    }
}
