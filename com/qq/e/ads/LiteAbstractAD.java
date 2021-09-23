package com.qq.e.ads;

import android.app.Activity;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.comm.compliance.DownloadConfirmCallBack;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.pi.LADI;
/* loaded from: classes10.dex */
public abstract class LiteAbstractAD<T extends LADI> extends AbstractAD<T> implements DownloadConfirmListener, LADI {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public DownloadConfirmListener f75426b;

    public LiteAbstractAD() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
            T t = this.f75411a;
            if (t != 0) {
                return ((LADI) t).getApkInfoUrl();
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
            T t = this.f75411a;
            if (t != 0) {
                return ((LADI) t).getECPM();
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
            T t = this.f75411a;
            if (t != 0) {
                return ((LADI) t).getECPMLevel();
            }
            a("getECPMLevel");
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.qq.e.comm.compliance.DownloadConfirmListener
    public void onDownloadConfirm(Activity activity, int i2, String str, DownloadConfirmCallBack downloadConfirmCallBack) {
        DownloadConfirmListener downloadConfirmListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLILL(1048579, this, activity, i2, str, downloadConfirmCallBack) == null) || (downloadConfirmListener = this.f75426b) == null) {
            return;
        }
        downloadConfirmListener.onDownloadConfirm(activity, i2, str, downloadConfirmCallBack);
    }

    @Override // com.qq.e.comm.pi.LADI
    public void sendLossNotification(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048580, this, i2, i3, str) == null) {
            T t = this.f75411a;
            if (t != 0) {
                ((LADI) t).sendLossNotification(i2, i3, str);
            } else {
                a("sendLossNotification");
            }
        }
    }

    @Override // com.qq.e.comm.pi.LADI
    public void sendWinNotification(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            T t = this.f75411a;
            if (t != 0) {
                ((LADI) t).sendWinNotification(i2);
            } else {
                a("sendWinNotification");
            }
        }
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public void setDownloadConfirmListener(DownloadConfirmListener downloadConfirmListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, downloadConfirmListener) == null) {
            this.f75426b = downloadConfirmListener;
            T t = this.f75411a;
            if (t != 0) {
                ((LADI) t).setDownloadConfirmListener(this);
            }
        }
    }
}
