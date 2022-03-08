package com.qq.e.ads.nativ.express2;

import android.app.Activity;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADEventListener;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.compliance.DownloadConfirmCallBack;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import java.util.Map;
@Deprecated
/* loaded from: classes8.dex */
public class NativeExpressADDataAdapter implements NativeExpressADData2, DownloadConfirmListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NativeExpressADData2 a;

    /* renamed from: b  reason: collision with root package name */
    public MediaEventListener f57577b;

    /* renamed from: c  reason: collision with root package name */
    public AdEventListener f57578c;

    /* renamed from: d  reason: collision with root package name */
    public DownloadConfirmListener f57579d;

    public NativeExpressADDataAdapter(NativeExpressADData2 nativeExpressADData2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {nativeExpressADData2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = nativeExpressADData2;
        if (nativeExpressADData2 instanceof ADEventListener) {
            ((ADEventListener) nativeExpressADData2).setAdListener(new ADListener(this) { // from class: com.qq.e.ads.nativ.express2.NativeExpressADDataAdapter.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ NativeExpressADDataAdapter a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext2 = TitanRuntime.newInitContext();
                        newInitContext2.initArgs = r2;
                        Object[] objArr2 = {this};
                        interceptable2.invokeUnInit(65536, newInitContext2);
                        int i4 = newInitContext2.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext2.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext2);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // com.qq.e.comm.adevent.ADListener
                public void onADEvent(ADEvent aDEvent) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, aDEvent) == null) {
                        if (aDEvent.getType() < 201) {
                            NativeExpressADDataAdapter.a(this.a, aDEvent);
                        } else if (aDEvent.getType() < 301) {
                            NativeExpressADDataAdapter.b(this.a, aDEvent);
                        }
                    }
                }
            });
        }
    }

    public static void a(NativeExpressADDataAdapter nativeExpressADDataAdapter, ADEvent aDEvent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, nativeExpressADDataAdapter, aDEvent) == null) || nativeExpressADDataAdapter.f57578c == null) {
            return;
        }
        switch (aDEvent.getType()) {
            case 101:
                nativeExpressADDataAdapter.f57578c.onClick();
                return;
            case 102:
                nativeExpressADDataAdapter.f57578c.onExposed();
                return;
            case 103:
                nativeExpressADDataAdapter.f57578c.onRenderSuccess();
                return;
            case 104:
                nativeExpressADDataAdapter.f57578c.onRenderFail();
                return;
            case 105:
                nativeExpressADDataAdapter.f57578c.onAdClosed();
                return;
            default:
                return;
        }
    }

    public static void b(NativeExpressADDataAdapter nativeExpressADDataAdapter, ADEvent aDEvent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65538, null, nativeExpressADDataAdapter, aDEvent) == null) || nativeExpressADDataAdapter.f57577b == null) {
            return;
        }
        switch (aDEvent.getType()) {
            case 201:
                nativeExpressADDataAdapter.f57577b.onVideoCache();
                return;
            case 202:
                nativeExpressADDataAdapter.f57577b.onVideoStart();
                return;
            case 203:
                nativeExpressADDataAdapter.f57577b.onVideoResume();
                return;
            case 204:
            case 205:
                nativeExpressADDataAdapter.f57577b.onVideoPause();
                return;
            case 206:
                nativeExpressADDataAdapter.f57577b.onVideoComplete();
                return;
            case 207:
                nativeExpressADDataAdapter.f57577b.onVideoError();
                return;
            default:
                return;
        }
    }

    @Override // com.qq.e.ads.nativ.express2.NativeExpressADData2
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.destroy();
        }
    }

    @Override // com.qq.e.ads.nativ.express2.NativeExpressADData2
    public View getAdView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a.getAdView() : (View) invokeV.objValue;
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public String getApkInfoUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            NativeExpressADData2 nativeExpressADData2 = this.a;
            if (nativeExpressADData2 != null) {
                return nativeExpressADData2.getApkInfoUrl();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.qq.e.ads.nativ.express2.NativeExpressADData2
    public int getECPM() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a.getECPM() : invokeV.intValue;
    }

    @Override // com.qq.e.ads.nativ.express2.NativeExpressADData2
    public String getECPMLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a.getECPMLevel() : (String) invokeV.objValue;
    }

    @Override // com.qq.e.ads.nativ.express2.NativeExpressADData2
    public Map<String, Object> getExtraInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.a.getExtraInfo() : (Map) invokeV.objValue;
    }

    @Override // com.qq.e.ads.nativ.express2.NativeExpressADData2
    public int getVideoDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.a.getVideoDuration() : invokeV.intValue;
    }

    @Override // com.qq.e.ads.nativ.express2.NativeExpressADData2
    public boolean isVideoAd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.a.isVideoAd() : invokeV.booleanValue;
    }

    @Override // com.qq.e.comm.compliance.DownloadConfirmListener
    public void onDownloadConfirm(Activity activity, int i2, String str, DownloadConfirmCallBack downloadConfirmCallBack) {
        DownloadConfirmListener downloadConfirmListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLILL(InputDeviceCompat.SOURCE_TOUCHPAD, this, activity, i2, str, downloadConfirmCallBack) == null) || (downloadConfirmListener = this.f57579d) == null) {
            return;
        }
        downloadConfirmListener.onDownloadConfirm(activity, i2, str, downloadConfirmCallBack);
    }

    @Override // com.qq.e.ads.nativ.express2.NativeExpressADData2
    public void render() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.a.render();
        }
    }

    @Override // com.qq.e.ads.nativ.express2.NativeExpressADData2
    public void sendLossNotification(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048586, this, i2, i3, str) == null) {
            this.a.sendLossNotification(i2, i3, str);
        }
    }

    @Override // com.qq.e.ads.nativ.express2.NativeExpressADData2
    public void sendWinNotification(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.a.sendWinNotification(i2);
        }
    }

    @Override // com.qq.e.ads.nativ.express2.NativeExpressADData2
    public void setAdEventListener(AdEventListener adEventListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, adEventListener) == null) {
            this.f57578c = adEventListener;
        }
    }

    @Override // com.qq.e.ads.nativ.express2.NativeExpressADData2
    public void setBidECPM(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.a.setBidECPM(i2);
        }
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public void setDownloadConfirmListener(DownloadConfirmListener downloadConfirmListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, downloadConfirmListener) == null) {
            this.f57579d = downloadConfirmListener;
            NativeExpressADData2 nativeExpressADData2 = this.a;
            if (nativeExpressADData2 != null) {
                nativeExpressADData2.setDownloadConfirmListener(this);
            }
        }
    }

    @Override // com.qq.e.ads.nativ.express2.NativeExpressADData2
    public void setMediaListener(MediaEventListener mediaEventListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, mediaEventListener) == null) {
            this.f57577b = mediaEventListener;
        }
    }
}
