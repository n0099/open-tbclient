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
@Deprecated
/* loaded from: classes6.dex */
public class NativeExpressADDataAdapter implements NativeExpressADData2, DownloadConfirmListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public NativeExpressADData2 f38039a;

    /* renamed from: b  reason: collision with root package name */
    public MediaEventListener f38040b;

    /* renamed from: c  reason: collision with root package name */
    public AdEventListener f38041c;

    /* renamed from: d  reason: collision with root package name */
    public DownloadConfirmListener f38042d;

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
        this.f38039a = nativeExpressADData2;
        if (nativeExpressADData2 instanceof ADEventListener) {
            ((ADEventListener) nativeExpressADData2).setAdListener(new ADListener(this) { // from class: com.qq.e.ads.nativ.express2.NativeExpressADDataAdapter.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public /* synthetic */ NativeExpressADDataAdapter f38043a;

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
                    this.f38043a = this;
                }

                @Override // com.qq.e.comm.adevent.ADListener
                public void onADEvent(ADEvent aDEvent) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, aDEvent) == null) {
                        if (aDEvent.getType() < 201) {
                            NativeExpressADDataAdapter.a(this.f38043a, aDEvent);
                        } else if (aDEvent.getType() < 301) {
                            NativeExpressADDataAdapter.b(this.f38043a, aDEvent);
                        }
                    }
                }
            });
        }
    }

    public static /* synthetic */ void a(NativeExpressADDataAdapter nativeExpressADDataAdapter, ADEvent aDEvent) {
        if (nativeExpressADDataAdapter.f38041c != null) {
            switch (aDEvent.getType()) {
                case 101:
                    nativeExpressADDataAdapter.f38041c.onClick();
                    return;
                case 102:
                    nativeExpressADDataAdapter.f38041c.onExposed();
                    return;
                case 103:
                    nativeExpressADDataAdapter.f38041c.onRenderSuccess();
                    return;
                case 104:
                    nativeExpressADDataAdapter.f38041c.onRenderFail();
                    return;
                case 105:
                    nativeExpressADDataAdapter.f38041c.onAdClosed();
                    return;
                default:
                    return;
            }
        }
    }

    public static /* synthetic */ void b(NativeExpressADDataAdapter nativeExpressADDataAdapter, ADEvent aDEvent) {
        if (nativeExpressADDataAdapter.f38040b != null) {
            switch (aDEvent.getType()) {
                case 201:
                    nativeExpressADDataAdapter.f38040b.onVideoCache();
                    return;
                case 202:
                    nativeExpressADDataAdapter.f38040b.onVideoStart();
                    return;
                case 203:
                    nativeExpressADDataAdapter.f38040b.onVideoResume();
                    return;
                case 204:
                case 205:
                    nativeExpressADDataAdapter.f38040b.onVideoPause();
                    return;
                case 206:
                    nativeExpressADDataAdapter.f38040b.onVideoComplete();
                    return;
                case 207:
                    nativeExpressADDataAdapter.f38040b.onVideoError();
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.qq.e.ads.nativ.express2.NativeExpressADData2
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f38039a.destroy();
        }
    }

    @Override // com.qq.e.ads.nativ.express2.NativeExpressADData2
    public View getAdView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f38039a.getAdView() : (View) invokeV.objValue;
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public String getApkInfoUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            NativeExpressADData2 nativeExpressADData2 = this.f38039a;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f38039a.getECPM() : invokeV.intValue;
    }

    @Override // com.qq.e.ads.nativ.express2.NativeExpressADData2
    public String getECPMLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f38039a.getECPMLevel() : (String) invokeV.objValue;
    }

    @Override // com.qq.e.ads.nativ.express2.NativeExpressADData2
    public int getVideoDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f38039a.getVideoDuration() : invokeV.intValue;
    }

    @Override // com.qq.e.ads.nativ.express2.NativeExpressADData2
    public boolean isVideoAd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f38039a.isVideoAd() : invokeV.booleanValue;
    }

    @Override // com.qq.e.comm.compliance.DownloadConfirmListener
    public void onDownloadConfirm(Activity activity, int i2, String str, DownloadConfirmCallBack downloadConfirmCallBack) {
        DownloadConfirmListener downloadConfirmListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLILL(1048583, this, activity, i2, str, downloadConfirmCallBack) == null) || (downloadConfirmListener = this.f38042d) == null) {
            return;
        }
        downloadConfirmListener.onDownloadConfirm(activity, i2, str, downloadConfirmCallBack);
    }

    @Override // com.qq.e.ads.nativ.express2.NativeExpressADData2
    public void render() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f38039a.render();
        }
    }

    @Override // com.qq.e.ads.nativ.express2.NativeExpressADData2
    public void setAdEventListener(AdEventListener adEventListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, adEventListener) == null) {
            this.f38041c = adEventListener;
        }
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public void setDownloadConfirmListener(DownloadConfirmListener downloadConfirmListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, downloadConfirmListener) == null) {
            this.f38042d = downloadConfirmListener;
            NativeExpressADData2 nativeExpressADData2 = this.f38039a;
            if (nativeExpressADData2 != null) {
                nativeExpressADData2.setDownloadConfirmListener(this);
            }
        }
    }

    @Override // com.qq.e.ads.nativ.express2.NativeExpressADData2
    public void setMediaListener(MediaEventListener mediaEventListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, mediaEventListener) == null) {
            this.f38040b = mediaEventListener;
        }
    }
}
