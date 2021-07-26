package com.qq.e.ads.rewardvideo2;

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
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.compliance.ApkDownloadComplianceInterface;
import com.qq.e.comm.compliance.DownloadConfirmCallBack;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.pi.RVADI2;
import com.qq.e.comm.util.AdErrorConvertor;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.VideoAdValidity;
import java.util.HashMap;
@Deprecated
/* loaded from: classes6.dex */
public class ExpressRewardVideoAD extends LiteAbstractAD<RVADI2> implements ApkDownloadComplianceInterface, DownloadConfirmListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public RVADI2 f38086a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f38087b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f38088c;

    /* renamed from: d  reason: collision with root package name */
    public ServerSideVerificationOptions f38089d;

    /* renamed from: e  reason: collision with root package name */
    public ExpressRewardVideoAdListener f38090e;

    /* renamed from: f  reason: collision with root package name */
    public DownloadConfirmListener f38091f;

    /* loaded from: classes6.dex */
    public static class AdListenerAdapter implements ADListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public ExpressRewardVideoAdListener f38092a;

        public AdListenerAdapter(ExpressRewardVideoAdListener expressRewardVideoAdListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {expressRewardVideoAdListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38092a = expressRewardVideoAdListener;
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aDEvent) == null) || this.f38092a == null || aDEvent == null) {
                return;
            }
            switch (aDEvent.getType()) {
                case 100:
                    this.f38092a.onAdLoaded();
                    return;
                case 101:
                    this.f38092a.onVideoCached();
                    return;
                case 102:
                    this.f38092a.onShow();
                    return;
                case 103:
                    this.f38092a.onExpose();
                    return;
                case 104:
                    if (aDEvent.getParas().length <= 0 || !(aDEvent.getParas()[0] instanceof String)) {
                        return;
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put(ServerSideVerificationOptions.TRANS_ID, aDEvent.getParas()[0]);
                    this.f38092a.onReward(hashMap);
                    return;
                case 105:
                    this.f38092a.onClick();
                    return;
                case 106:
                    this.f38092a.onClose();
                    return;
                case 107:
                    if (aDEvent.getParas().length <= 0 || !(aDEvent.getParas()[0] instanceof Integer)) {
                        return;
                    }
                    this.f38092a.onError(AdErrorConvertor.formatErrorCode(((Integer) aDEvent.getParas()[0]).intValue()));
                    return;
                case 108:
                    this.f38092a.onVideoComplete();
                    return;
                default:
                    return;
            }
        }
    }

    public ExpressRewardVideoAD(Context context, String str, ExpressRewardVideoAdListener expressRewardVideoAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, expressRewardVideoAdListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f38088c = true;
        this.f38090e = expressRewardVideoAdListener;
        if (GDTADManager.getInstance().isInitialized()) {
            a(context, GDTADManager.getInstance().getAppStatus().getAPPID(), str);
            return;
        }
        GDTLogger.e("SDK 尚未初始化，请在 Application 中调用 GDTADManager.getInstance().initWith() 初始化");
        a(2003);
    }

    public ExpressRewardVideoAD(Context context, String str, String str2, ExpressRewardVideoAdListener expressRewardVideoAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, str2, expressRewardVideoAdListener};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f38088c = true;
        this.f38090e = expressRewardVideoAdListener;
        a(context, str, str2);
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.qq.e.ads.LiteAbstractAD
    public final /* synthetic */ RVADI2 a(Context context, POFactory pOFactory, String str, String str2) {
        return pOFactory.getExpressRewardVideoADDelegate(context, str, str2, new AdListenerAdapter(this.f38090e));
    }

    @Override // com.qq.e.ads.LiteAbstractAD
    public final void a(int i2) {
        ExpressRewardVideoAdListener expressRewardVideoAdListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || (expressRewardVideoAdListener = this.f38090e) == null) {
            return;
        }
        expressRewardVideoAdListener.onError(AdErrorConvertor.formatErrorCode(i2));
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.qq.e.ads.LiteAbstractAD
    public final /* synthetic */ void a(RVADI2 rvadi2) {
        RVADI2 rvadi22 = rvadi2;
        this.f38086a = rvadi22;
        rvadi22.setVolumeOn(this.f38088c);
        this.f38086a.setServerSideVerificationOptions(this.f38089d);
        if (this.f38087b) {
            this.f38086a.loadAD();
            this.f38087b = false;
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
            RVADI2 rvadi2 = this.f38086a;
            if (rvadi2 != null) {
                z = rvadi2.isVideoCached();
            } else {
                GDTLogger.w("don't call isVideoCached before loading AD success");
                z = false;
            }
            return !z ? VideoAdValidity.NONE_CACHE : VideoAdValidity.VALID;
        }
        return (VideoAdValidity) invokeV.objValue;
    }

    public void destroy() {
        RVADI2 rvadi2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (rvadi2 = this.f38086a) == null) {
            return;
        }
        rvadi2.destroy();
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public String getApkInfoUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            RVADI2 rvadi2 = this.f38086a;
            if (rvadi2 != null) {
                return rvadi2.getApkInfoUrl();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public int getECPM() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            RVADI2 rvadi2 = this.f38086a;
            if (rvadi2 != null) {
                return rvadi2.getECPM();
            }
            GDTLogger.w("don't call getECPM before loading AD success");
            return -1;
        }
        return invokeV.intValue;
    }

    public String getECPMLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            RVADI2 rvadi2 = this.f38086a;
            if (rvadi2 != null) {
                return rvadi2.getECPMLevel();
            }
            GDTLogger.w("don't call getECPMLevel before loading AD success");
            return null;
        }
        return (String) invokeV.objValue;
    }

    public long getExpireTimestamp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            RVADI2 rvadi2 = this.f38086a;
            if (rvadi2 != null) {
                return rvadi2.getExpireTimestamp();
            }
            GDTLogger.w("don't call getExpireTimestamp before loading AD success");
            return 0L;
        }
        return invokeV.longValue;
    }

    public int getVideoDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            RVADI2 rvadi2 = this.f38086a;
            if (rvadi2 != null) {
                return rvadi2.getVideoDuration();
            }
            GDTLogger.w("don't call getVideoDuration before loading AD success");
            return 0;
        }
        return invokeV.intValue;
    }

    public boolean hasShown() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            RVADI2 rvadi2 = this.f38086a;
            if (rvadi2 != null) {
                return rvadi2.hasShown();
            }
            GDTLogger.w("don't call hasShown before loading AD success");
            return false;
        }
        return invokeV.booleanValue;
    }

    public void loadAD() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            RVADI2 rvadi2 = this.f38086a;
            if (rvadi2 != null) {
                rvadi2.loadAD();
            } else {
                this.f38087b = true;
            }
        }
    }

    @Override // com.qq.e.comm.compliance.DownloadConfirmListener
    public void onDownloadConfirm(Activity activity, int i2, String str, DownloadConfirmCallBack downloadConfirmCallBack) {
        DownloadConfirmListener downloadConfirmListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLILL(1048588, this, activity, i2, str, downloadConfirmCallBack) == null) || (downloadConfirmListener = this.f38091f) == null) {
            return;
        }
        downloadConfirmListener.onDownloadConfirm(activity, i2, str, downloadConfirmCallBack);
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public void setDownloadConfirmListener(DownloadConfirmListener downloadConfirmListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, downloadConfirmListener) == null) {
            this.f38091f = downloadConfirmListener;
            RVADI2 rvadi2 = this.f38086a;
            if (rvadi2 != null) {
                rvadi2.setDownloadConfirmListener(this);
            }
        }
    }

    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, serverSideVerificationOptions) == null) {
            RVADI2 rvadi2 = this.f38086a;
            if (rvadi2 != null) {
                rvadi2.setServerSideVerificationOptions(serverSideVerificationOptions);
            } else {
                this.f38089d = serverSideVerificationOptions;
            }
        }
    }

    public void setVolumeOn(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            RVADI2 rvadi2 = this.f38086a;
            if (rvadi2 != null) {
                rvadi2.setVolumeOn(z);
            } else {
                this.f38088c = z;
            }
        }
    }

    public void showAD(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, activity) == null) {
            RVADI2 rvadi2 = this.f38086a;
            if (rvadi2 != null) {
                rvadi2.showAD(activity);
            } else {
                GDTLogger.w("don't call showAD before loading AD success");
            }
        }
    }
}
