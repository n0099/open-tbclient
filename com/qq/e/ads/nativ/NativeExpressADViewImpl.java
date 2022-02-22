package com.qq.e.ads.nativ;

import android.app.Activity;
import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.ads.nativ.NativeExpressADView;
import com.qq.e.ads.nativ.express2.NativeExpressADData2;
import com.qq.e.comm.compliance.DownloadConfirmCallBack;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.constants.Constants;
import com.qq.e.comm.pi.AdData;
import com.qq.e.comm.pi.NEADI;
import com.qq.e.comm.pi.NEADVI;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class NativeExpressADViewImpl extends NativeExpressADView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AdData a;

    /* renamed from: b  reason: collision with root package name */
    public NativeExpressADView.ViewBindStatusListener f59214b;

    /* renamed from: c  reason: collision with root package name */
    public final NativeExpressADCore f59215c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NativeExpressADViewImpl(NEADI neadi, NEADVI neadvi, NativeExpressADData2 nativeExpressADData2, Context context, ADSize aDSize, String str, String str2, String str3, JSONObject jSONObject, HashMap<String, Object> hashMap) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {neadi, neadvi, nativeExpressADData2, context, aDSize, str, str2, str3, jSONObject, hashMap};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f59215c = new NativeExpressADCore(this, neadi, neadvi, nativeExpressADData2, context, aDSize, str2, jSONObject, hashMap);
        this.a = a(hashMap);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x001d  */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private AdData a(HashMap<String, Object> hashMap) {
        InterceptResult invokeL;
        JSONObject jSONObject;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65537, this, hashMap)) != null) {
            return (AdData) invokeL.objValue;
        }
        if (hashMap != null) {
            try {
                jSONObject = (JSONObject) hashMap.get(Constants.KEYS.AD_INFO);
            } catch (JSONException unused) {
            }
        } else {
            jSONObject = null;
        }
        if (jSONObject != null) {
            obj = jSONObject.get(Constants.KEYS.AD_INFO);
            if (obj instanceof AdData) {
                return null;
            }
            return (AdData) obj;
        }
        obj = null;
        if (obj instanceof AdData) {
        }
    }

    @Override // com.qq.e.ads.nativ.NativeExpressADView
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f59215c.destroy();
        }
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public String getApkInfoUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f59215c.getApkInfoUrl() : (String) invokeV.objValue;
    }

    @Override // com.qq.e.ads.nativ.NativeExpressADView
    public AdData getBoundData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a : (AdData) invokeV.objValue;
    }

    @Override // com.qq.e.ads.nativ.NativeExpressADView
    public int getECPM() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f59215c.getECPM() : invokeV.intValue;
    }

    @Override // com.qq.e.ads.nativ.NativeExpressADView
    public String getECPMLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f59215c.getECPMLevel() : (String) invokeV.objValue;
    }

    @Override // com.qq.e.ads.nativ.NativeExpressADView
    public void negativeFeedback() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f59215c.negativeFeedback();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onAttachedToWindow();
            NativeExpressADView.ViewBindStatusListener viewBindStatusListener = this.f59214b;
            if (viewBindStatusListener != null) {
                viewBindStatusListener.onAttachedToWindow();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onDetachedFromWindow();
            NativeExpressADView.ViewBindStatusListener viewBindStatusListener = this.f59214b;
            if (viewBindStatusListener != null) {
                viewBindStatusListener.onDetachedFromWindow();
            }
        }
    }

    @Override // com.qq.e.comm.compliance.DownloadConfirmListener
    public void onDownloadConfirm(Activity activity, int i2, String str, DownloadConfirmCallBack downloadConfirmCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(InputDeviceCompat.SOURCE_TOUCHPAD, this, activity, i2, str, downloadConfirmCallBack) == null) {
        }
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onFinishTemporaryDetach();
            NativeExpressADView.ViewBindStatusListener viewBindStatusListener = this.f59214b;
            if (viewBindStatusListener != null) {
                viewBindStatusListener.onFinishTemporaryDetach();
            }
        }
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onStartTemporaryDetach();
            NativeExpressADView.ViewBindStatusListener viewBindStatusListener = this.f59214b;
            if (viewBindStatusListener != null) {
                viewBindStatusListener.onStartTemporaryDetach();
            }
        }
    }

    @Override // com.qq.e.ads.nativ.NativeExpressADView
    public void preloadVideo() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f59215c.preloadVideo();
        }
    }

    @Override // com.qq.e.ads.nativ.NativeExpressADView
    public void render() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.f59215c.render();
        }
    }

    @Override // com.qq.e.ads.nativ.NativeExpressADView
    public void sendLossNotification(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048589, this, i2, i3, str) == null) {
            this.f59215c.sendLossNotification(i2, i3, str);
        }
    }

    @Override // com.qq.e.ads.nativ.NativeExpressADView
    public void sendWinNotification(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.f59215c.sendWinNotification(i2);
        }
    }

    @Override // com.qq.e.ads.nativ.NativeExpressADView
    @Deprecated
    public void setAdSize(ADSize aDSize) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, aDSize) == null) {
            this.f59215c.setAdSize(aDSize);
        }
    }

    @Override // com.qq.e.ads.nativ.NativeExpressADView
    public void setBidECPM(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            this.f59215c.setBidECPM(i2);
        }
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public void setDownloadConfirmListener(DownloadConfirmListener downloadConfirmListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, downloadConfirmListener) == null) {
            this.f59215c.setDownloadConfirmListener(downloadConfirmListener);
        }
    }

    @Override // com.qq.e.ads.nativ.NativeExpressADView
    public void setMediaListener(NativeExpressMediaListener nativeExpressMediaListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, nativeExpressMediaListener) == null) {
            this.f59215c.a(nativeExpressMediaListener);
        }
    }

    @Override // com.qq.e.ads.nativ.NativeExpressADView
    public void setViewBindStatusListener(NativeExpressADView.ViewBindStatusListener viewBindStatusListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, viewBindStatusListener) == null) {
            this.f59214b = viewBindStatusListener;
        }
    }
}
