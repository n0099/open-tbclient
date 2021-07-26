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
import com.qq.e.ads.LiteAbstractAD;
import com.qq.e.ads.nativ.express2.VideoOption2;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.compliance.ApkDownloadComplianceInterface;
import com.qq.e.comm.compliance.DownloadConfirmCallBack;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.pi.UIADI2;
import com.qq.e.comm.util.AdErrorConvertor;
import com.qq.e.comm.util.CallbackUtil;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.VideoAdValidity;
@Deprecated
/* loaded from: classes6.dex */
public class ExpressInterstitialAD extends LiteAbstractAD<UIADI2> implements ApkDownloadComplianceInterface, DownloadConfirmListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public UIADI2 f37978a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f37979b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f37980c;

    /* renamed from: d  reason: collision with root package name */
    public VideoOption2 f37981d;

    /* renamed from: e  reason: collision with root package name */
    public ExpressInterstitialAdListener f37982e;

    /* renamed from: f  reason: collision with root package name */
    public DownloadConfirmListener f37983f;

    /* loaded from: classes6.dex */
    public static class AdListenerAdapter implements ADListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public ExpressInterstitialAdListener f37984a;

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
            this.f37984a = expressInterstitialAdListener;
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aDEvent) == null) || this.f37984a == null || aDEvent == null) {
                return;
            }
            switch (aDEvent.getType()) {
                case 100:
                    this.f37984a.onAdLoaded();
                    return;
                case 101:
                    this.f37984a.onVideoCached();
                    return;
                case 102:
                    this.f37984a.onShow();
                    return;
                case 103:
                    this.f37984a.onExpose();
                    return;
                case 104:
                default:
                    return;
                case 105:
                    this.f37984a.onClick();
                    return;
                case 106:
                    this.f37984a.onClose();
                    return;
                case 107:
                    if (aDEvent.getParas().length <= 0 || !(aDEvent.getParas()[0] instanceof Integer)) {
                        return;
                    }
                    this.f37984a.onError(AdErrorConvertor.formatErrorCode(((Integer) aDEvent.getParas()[0]).intValue()));
                    return;
                case 108:
                    this.f37984a.onVideoComplete();
                    return;
                case 109:
                    if (CallbackUtil.hasRenderSuccessCallback(this.f37984a)) {
                        this.f37984a.onRenderSuccess();
                        return;
                    }
                    return;
                case 110:
                    if (CallbackUtil.hasRenderFailCallback(this.f37984a)) {
                        this.f37984a.onRenderFail();
                        return;
                    }
                    return;
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
        this.f37982e = expressInterstitialAdListener;
        if (GDTADManager.getInstance().isInitialized()) {
            a(context, GDTADManager.getInstance().getAppStatus().getAPPID(), str);
            return;
        }
        GDTLogger.e("SDK 尚未初始化，请在 Application 中调用 GDTADManager.getInstance().initWith() 初始化");
        a(2003);
    }

    public ExpressInterstitialAD(Context context, String str, String str2, ExpressInterstitialAdListener expressInterstitialAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, str2, expressInterstitialAdListener};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f37982e = expressInterstitialAdListener;
        a(context, str, str2);
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.qq.e.ads.LiteAbstractAD
    public final /* synthetic */ UIADI2 a(Context context, POFactory pOFactory, String str, String str2) {
        return pOFactory.getExpressInterstitialADDelegate(context, str, str2, new AdListenerAdapter(this.f37982e));
    }

    @Override // com.qq.e.ads.LiteAbstractAD
    public final void a(int i2) {
        ExpressInterstitialAdListener expressInterstitialAdListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || (expressInterstitialAdListener = this.f37982e) == null) {
            return;
        }
        expressInterstitialAdListener.onError(AdErrorConvertor.formatErrorCode(i2));
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.qq.e.ads.LiteAbstractAD
    public final /* synthetic */ void a(UIADI2 uiadi2) {
        UIADI2 uiadi22 = uiadi2;
        this.f37978a = uiadi22;
        uiadi22.setVideoOption(this.f37981d);
        if (this.f37979b) {
            this.f37978a.loadHalfScreenAD();
            this.f37979b = false;
        }
        if (this.f37980c) {
            this.f37978a.loadFullScreenAD();
            this.f37980c = false;
        }
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
                UIADI2 uiadi2 = this.f37978a;
                if (uiadi2 != null) {
                    z = uiadi2.isVideoCached();
                } else {
                    GDTLogger.w("don't call isVideoCached before loading AD success");
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
            UIADI2 uiadi2 = this.f37978a;
            if (uiadi2 != null) {
                uiadi2.closeHalfScreenAD();
            } else {
                GDTLogger.w("don't call closeHalfScreenAD before loading AD success");
            }
        }
    }

    public void destroy() {
        UIADI2 uiadi2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (uiadi2 = this.f37978a) == null) {
            return;
        }
        uiadi2.destroy();
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public String getApkInfoUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            UIADI2 uiadi2 = this.f37978a;
            if (uiadi2 != null) {
                return uiadi2.getApkInfoUrl();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public int getECPM() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            UIADI2 uiadi2 = this.f37978a;
            if (uiadi2 != null) {
                return uiadi2.getECPM();
            }
            GDTLogger.w("don't call getECPMLevel before loading AD success");
            return -1;
        }
        return invokeV.intValue;
    }

    public String getECPMLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            UIADI2 uiadi2 = this.f37978a;
            if (uiadi2 != null) {
                return uiadi2.getECPMLevel();
            }
            GDTLogger.w("don't call getECPMLevel before loading AD success");
            return null;
        }
        return (String) invokeV.objValue;
    }

    public long getExpireTimestamp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            UIADI2 uiadi2 = this.f37978a;
            if (uiadi2 != null) {
                return uiadi2.getExpireTimestamp();
            }
            GDTLogger.w("don't call getExpireTimestamp before loading AD success");
            return 0L;
        }
        return invokeV.longValue;
    }

    public int getVideoDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            UIADI2 uiadi2 = this.f37978a;
            if (uiadi2 != null) {
                return uiadi2.getVideoDuration();
            }
            GDTLogger.w("don't call getVideoDuration before loading AD success");
            return 0;
        }
        return invokeV.intValue;
    }

    public boolean hasShown() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            UIADI2 uiadi2 = this.f37978a;
            if (uiadi2 != null) {
                return uiadi2.hasShown();
            }
            GDTLogger.w("don't call hasShown before loading AD success");
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isVideoAd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            UIADI2 uiadi2 = this.f37978a;
            if (uiadi2 != null) {
                return uiadi2.isVideoAd();
            }
            GDTLogger.w("don't call isVideoAd before loading AD success");
            return false;
        }
        return invokeV.booleanValue;
    }

    public void loadFullScreenAD() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            UIADI2 uiadi2 = this.f37978a;
            if (uiadi2 != null) {
                uiadi2.loadFullScreenAD();
            } else {
                this.f37980c = true;
            }
        }
    }

    public void loadHalfScreenAD() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            UIADI2 uiadi2 = this.f37978a;
            if (uiadi2 != null) {
                uiadi2.loadHalfScreenAD();
            } else {
                this.f37979b = true;
            }
        }
    }

    @Override // com.qq.e.comm.compliance.DownloadConfirmListener
    public void onDownloadConfirm(Activity activity, int i2, String str, DownloadConfirmCallBack downloadConfirmCallBack) {
        DownloadConfirmListener downloadConfirmListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLILL(1048591, this, activity, i2, str, downloadConfirmCallBack) == null) || (downloadConfirmListener = this.f37983f) == null) {
            return;
        }
        downloadConfirmListener.onDownloadConfirm(activity, i2, str, downloadConfirmCallBack);
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public void setDownloadConfirmListener(DownloadConfirmListener downloadConfirmListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, downloadConfirmListener) == null) {
            this.f37983f = downloadConfirmListener;
            UIADI2 uiadi2 = this.f37978a;
            if (uiadi2 != null) {
                uiadi2.setDownloadConfirmListener(this);
            }
        }
    }

    public void setVideoOption(VideoOption2 videoOption2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, videoOption2) == null) {
            UIADI2 uiadi2 = this.f37978a;
            if (uiadi2 != null) {
                uiadi2.setVideoOption(videoOption2);
            } else {
                this.f37981d = videoOption2;
            }
        }
    }

    public void showFullScreenAD(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, activity) == null) {
            UIADI2 uiadi2 = this.f37978a;
            if (uiadi2 != null) {
                uiadi2.showFullScreenAD(activity);
            } else {
                GDTLogger.w("don't call showAD before loading AD success");
            }
        }
    }

    public void showHalfScreenAD(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, activity) == null) {
            UIADI2 uiadi2 = this.f37978a;
            if (uiadi2 != null) {
                uiadi2.showHalfScreenAD(activity);
            } else {
                GDTLogger.w("don't call showHalfScreenAD before loading AD success");
            }
        }
    }
}
