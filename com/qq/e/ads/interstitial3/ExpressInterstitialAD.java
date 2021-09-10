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
import com.qq.e.comm.util.VideoAdValidity;
import java.util.HashMap;
import java.util.Map;
@Deprecated
/* loaded from: classes10.dex */
public class ExpressInterstitialAD extends LiteAbstractAD<UIADI2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public boolean f75175b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f75176c;

    /* renamed from: d  reason: collision with root package name */
    public VideoOption2 f75177d;

    /* renamed from: e  reason: collision with root package name */
    public AdListenerAdapter f75178e;

    /* renamed from: f  reason: collision with root package name */
    public ExpressInterstitialAdListener f75179f;

    /* renamed from: g  reason: collision with root package name */
    public ServerSideVerificationOptions f75180g;

    /* loaded from: classes10.dex */
    public static class AdListenerAdapter implements ADListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public ExpressInterstitialAdListener f75181a;

        /* renamed from: b  reason: collision with root package name */
        public ADRewardListener f75182b;

        public AdListenerAdapter(ExpressInterstitialAdListener expressInterstitialAdListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {expressInterstitialAdListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f75181a = expressInterstitialAdListener;
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aDEvent) == null) || this.f75181a == null || aDEvent == null) {
                return;
            }
            switch (aDEvent.getType()) {
                case 100:
                    this.f75181a.onAdLoaded();
                    return;
                case 101:
                    this.f75181a.onVideoCached();
                    return;
                case 102:
                    this.f75181a.onShow();
                    return;
                case 103:
                    this.f75181a.onExpose();
                    return;
                case 104:
                    if (this.f75182b != null) {
                        Object obj = aDEvent.getParas()[0];
                        Map<String, Object> map = null;
                        if (obj instanceof String) {
                            map = new HashMap<>();
                            map.put(ServerSideVerificationOptions.TRANS_ID, String.valueOf(aDEvent.getParas()[0]));
                        } else if (obj instanceof Map) {
                            map = (Map) obj;
                        }
                        ADRewardListener aDRewardListener = this.f75182b;
                        if (aDRewardListener == null || map == null) {
                            return;
                        }
                        aDRewardListener.onReward(map);
                        return;
                    }
                    return;
                case 105:
                    this.f75181a.onClick();
                    return;
                case 106:
                    this.f75181a.onClose();
                    return;
                case 107:
                    if (aDEvent.getParas().length <= 0 || !(aDEvent.getParas()[0] instanceof Integer)) {
                        AbstractAD.a(ExpressInterstitialAD.class, aDEvent);
                        return;
                    } else {
                        this.f75181a.onError(AdErrorConvertor.formatErrorCode(((Integer) aDEvent.getParas()[0]).intValue()));
                        return;
                    }
                case 108:
                    this.f75181a.onVideoComplete();
                    return;
                case 109:
                    if (CallbackUtil.hasRenderSuccessCallback(this.f75181a)) {
                        this.f75181a.onRenderSuccess();
                        return;
                    }
                    return;
                case 110:
                    if (CallbackUtil.hasRenderFailCallback(this.f75181a)) {
                        this.f75181a.onRenderFail();
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
                this.f75182b = aDRewardListener;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f75179f = expressInterstitialAdListener;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (String) objArr2[1], (ExpressInterstitialAdListener) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        c();
    }

    @Override // com.qq.e.ads.AbstractAD
    public final /* synthetic */ Object a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        AdListenerAdapter adListenerAdapter = new AdListenerAdapter(this.f75179f);
        this.f75178e = adListenerAdapter;
        return pOFactory.getExpressInterstitialADDelegate(context, str, str2, adListenerAdapter);
    }

    @Override // com.qq.e.ads.AbstractAD
    public final /* synthetic */ void a(Object obj) {
        ((UIADI2) this.f75092a).setVideoOption(this.f75177d);
        ((UIADI2) this.f75092a).setServerSideVerificationOptions(this.f75180g);
        if (this.f75175b) {
            ((UIADI2) this.f75092a).loadHalfScreenAD();
            this.f75175b = false;
        }
        if (this.f75176c) {
            ((UIADI2) this.f75092a).loadFullScreenAD();
            this.f75176c = false;
        }
    }

    @Override // com.qq.e.ads.AbstractAD
    public final void b(int i2) {
        ExpressInterstitialAdListener expressInterstitialAdListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || (expressInterstitialAdListener = this.f75179f) == null) {
            return;
        }
        expressInterstitialAdListener.onError(AdErrorConvertor.formatErrorCode(i2));
    }

    public VideoAdValidity checkValidity() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (hasShown()) {
                return VideoAdValidity.SHOWED;
            }
            if (SystemClock.elapsedRealtime() > getExpireTimestamp()) {
                return VideoAdValidity.OVERDUE;
            }
            if (isVideoAd()) {
                T t = this.f75092a;
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
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            T t = this.f75092a;
            if (t != 0) {
                ((UIADI2) t).closeHalfScreenAD();
            } else {
                a("closeHalfScreenAD");
            }
        }
    }

    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            T t = this.f75092a;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            T t = this.f75092a;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            T t = this.f75092a;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            T t = this.f75092a;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            T t = this.f75092a;
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
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && b()) {
            if (!a()) {
                this.f75176c = true;
                return;
            }
            T t = this.f75092a;
            if (t != 0) {
                ((UIADI2) t).loadFullScreenAD();
            } else {
                a("loadFullScreenAD");
            }
        }
    }

    public void loadHalfScreenAD() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && b()) {
            if (!a()) {
                this.f75175b = true;
                return;
            }
            T t = this.f75092a;
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
        if (!(interceptable == null || interceptable.invokeL(1048588, this, aDRewardListener) == null) || (adListenerAdapter = this.f75178e) == null) {
            return;
        }
        adListenerAdapter.setRewardListener(aDRewardListener);
    }

    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, serverSideVerificationOptions) == null) {
            T t = this.f75092a;
            if (t != 0) {
                ((UIADI2) t).setServerSideVerificationOptions(serverSideVerificationOptions);
            } else {
                this.f75180g = serverSideVerificationOptions;
            }
        }
    }

    public void setVideoOption(VideoOption2 videoOption2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, videoOption2) == null) {
            T t = this.f75092a;
            if (t != 0) {
                ((UIADI2) t).setVideoOption(videoOption2);
            } else {
                this.f75177d = videoOption2;
            }
        }
    }

    public void showFullScreenAD(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, activity) == null) {
            T t = this.f75092a;
            if (t != 0) {
                ((UIADI2) t).showFullScreenAD(activity);
            } else {
                a("showFullScreenAD");
            }
        }
    }

    public void showHalfScreenAD(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, activity) == null) {
            T t = this.f75092a;
            if (t != 0) {
                ((UIADI2) t).showHalfScreenAD(activity);
            } else {
                a("showHalfScreenAD");
            }
        }
    }
}
