package com.qq.e.ads;

import android.app.Activity;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.comm.compliance.DownloadConfirmCallBack;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.pi.LADI;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public abstract class LiteAbstractAD extends AbstractAD implements LADI, DownloadConfirmListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public DownloadConfirmListener f;

    public LiteAbstractAD() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public String getApkInfoUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Object obj = this.a;
            if (obj != null) {
                return ((LADI) obj).getApkInfoUrl();
            }
            a("getApkInfoUrl");
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.qq.e.comm.pi.LADI
    public int getECPM() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Object obj = this.a;
            if (obj != null) {
                return ((LADI) obj).getECPM();
            }
            a("getECPM");
            return -1;
        }
        return invokeV.intValue;
    }

    @Override // com.qq.e.comm.pi.LADI
    public String getECPMLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Object obj = this.a;
            if (obj != null) {
                return ((LADI) obj).getECPMLevel();
            }
            a("getECPMLevel");
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.qq.e.comm.pi.LADI
    public Map getExtraInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Object obj = this.a;
            if (obj != null) {
                return ((LADI) obj).getExtraInfo();
            }
            a("getExtraInfo");
            return new HashMap();
        }
        return (Map) invokeV.objValue;
    }

    @Override // com.qq.e.comm.compliance.DownloadConfirmListener
    public void onDownloadConfirm(Activity activity, int i, String str, DownloadConfirmCallBack downloadConfirmCallBack) {
        DownloadConfirmListener downloadConfirmListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLILL(1048580, this, activity, i, str, downloadConfirmCallBack) == null) || (downloadConfirmListener = this.f) == null) {
            return;
        }
        downloadConfirmListener.onDownloadConfirm(activity, i, str, downloadConfirmCallBack);
    }

    @Override // com.qq.e.comm.pi.LADI
    public void sendLossNotification(int i, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048581, this, i, i2, str) == null) {
            Object obj = this.a;
            if (obj != null) {
                ((LADI) obj).sendLossNotification(i, i2, str);
            } else {
                a("sendLossNotification");
            }
        }
    }

    @Override // com.qq.e.comm.pi.LADI
    public void sendWinNotification(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            Object obj = this.a;
            if (obj != null) {
                ((LADI) obj).sendWinNotification(i);
            } else {
                a("sendWinNotification");
            }
        }
    }

    @Override // com.qq.e.comm.pi.LADI
    public void setBidECPM(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            Object obj = this.a;
            if (obj != null) {
                ((LADI) obj).setBidECPM(i);
            } else {
                a("setBidECPM");
            }
        }
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public void setDownloadConfirmListener(DownloadConfirmListener downloadConfirmListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, downloadConfirmListener) == null) {
            this.f = downloadConfirmListener;
            Object obj = this.a;
            if (obj != null) {
                ((LADI) obj).setDownloadConfirmListener(this);
            }
        }
    }
}
