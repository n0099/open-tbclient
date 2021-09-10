package com.qq.e.ads.nativ;

import android.app.Activity;
import android.content.Context;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.ads.nativ.express2.NativeExpressADData2;
import com.qq.e.comm.compliance.ApkDownloadComplianceInterface;
import com.qq.e.comm.compliance.DownloadConfirmCallBack;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.constants.Constants;
import com.qq.e.comm.pi.AdData;
import com.qq.e.comm.pi.NEADI;
import com.qq.e.comm.pi.NEADVI;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class NativeExpressADView extends FrameLayout implements ApkDownloadComplianceInterface, DownloadConfirmListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public AdData f75203a;

    /* renamed from: b  reason: collision with root package name */
    public ViewBindStatusListener f75204b;

    /* renamed from: c  reason: collision with root package name */
    public final NativeExpressADCore f75205c;
    public Map<String, String> ext;

    /* loaded from: classes10.dex */
    public interface ViewBindStatusListener {
        void onAttachedToWindow();

        void onDetachedFromWindow();

        void onFinishTemporaryDetach();

        void onStartTemporaryDetach();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NativeExpressADView(NEADI neadi, NEADVI neadvi, NativeExpressADData2 nativeExpressADData2, Context context, ADSize aDSize, String str, String str2, String str3, JSONObject jSONObject, HashMap<String, Object> hashMap) {
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
        this.ext = new HashMap();
        this.f75205c = new NativeExpressADCore(this, neadi, neadvi, nativeExpressADData2, context, aDSize, str2, jSONObject, hashMap);
        this.f75203a = a(hashMap);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x001d  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0020 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static AdData a(HashMap<String, Object> hashMap) {
        InterceptResult invokeL;
        JSONObject jSONObject;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65537, null, hashMap)) != null) {
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

    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f75205c.g();
        }
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public String getApkInfoUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f75205c.getApkInfoUrl() : (String) invokeV.objValue;
    }

    public AdData getBoundData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f75203a : (AdData) invokeV.objValue;
    }

    public int getECPM() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f75205c.getECPM() : invokeV.intValue;
    }

    public String getECPMLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f75205c.getECPMLevel() : (String) invokeV.objValue;
    }

    public void negativeFeedback() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f75205c.f();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onAttachedToWindow();
            ViewBindStatusListener viewBindStatusListener = this.f75204b;
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
            ViewBindStatusListener viewBindStatusListener = this.f75204b;
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
            ViewBindStatusListener viewBindStatusListener = this.f75204b;
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
            ViewBindStatusListener viewBindStatusListener = this.f75204b;
            if (viewBindStatusListener != null) {
                viewBindStatusListener.onStartTemporaryDetach();
            }
        }
    }

    public void preloadVideo() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f75205c.d();
        }
    }

    public void render() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.f75205c.e();
        }
    }

    public void sendLossNotification(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048589, this, i2, i3, str) == null) {
            this.f75205c.sendLossNotification(i2, i3, str);
        }
    }

    public void sendWinNotification(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.f75205c.sendWinNotification(i2);
        }
    }

    @Deprecated
    public void setAdSize(ADSize aDSize) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, aDSize) == null) {
            this.f75205c.a(aDSize);
        }
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public void setDownloadConfirmListener(DownloadConfirmListener downloadConfirmListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, downloadConfirmListener) == null) {
            this.f75205c.setDownloadConfirmListener(downloadConfirmListener);
        }
    }

    public void setMediaListener(NativeExpressMediaListener nativeExpressMediaListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, nativeExpressMediaListener) == null) {
            this.f75205c.a(nativeExpressMediaListener);
        }
    }

    public void setViewBindStatusListener(ViewBindStatusListener viewBindStatusListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, viewBindStatusListener) == null) {
            this.f75204b = viewBindStatusListener;
        }
    }
}
