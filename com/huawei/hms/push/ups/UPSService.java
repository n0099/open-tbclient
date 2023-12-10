package com.huawei.hms.push.ups;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tieba.fcc;
import com.baidu.tieba.icc;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.aaid.HmsInstanceId;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.push.HmsMessaging;
import com.huawei.hms.push.s;
import com.huawei.hms.push.ups.entity.CodeResult;
import com.huawei.hms.push.ups.entity.TokenResult;
import com.huawei.hms.push.ups.entity.UPSRegisterCallBack;
import com.huawei.hms.push.ups.entity.UPSTurnCallBack;
import com.huawei.hms.push.ups.entity.UPSUnRegisterCallBack;
import com.huawei.hms.support.log.HMSLog;
/* loaded from: classes10.dex */
public final class UPSService {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public UPSService() {
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

    public static void registerToken(Context context, String str, String str2, String str3, UPSRegisterCallBack uPSRegisterCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65537, null, context, str, str2, str3, uPSRegisterCallBack) == null) {
            HMSLog.i("UPSService", "invoke registerToken");
            Preconditions.checkNotNull(uPSRegisterCallBack);
            if (!s.b()) {
                uPSRegisterCallBack.onResult(new TokenResult(ErrorEnum.ERROR_OPERATION_NOT_SUPPORTED.getExternalCode()));
                return;
            }
            try {
                uPSRegisterCallBack.onResult(new TokenResult(HmsInstanceId.getInstance(context).getToken(str, null)));
            } catch (ApiException e) {
                uPSRegisterCallBack.onResult(new TokenResult(e.getStatusCode(), e.getMessage()));
            }
        }
    }

    public static void turnOffPush(Context context, UPSTurnCallBack uPSTurnCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, context, uPSTurnCallBack) == null) {
            HMSLog.i("UPSService", "invoke turnOffPush");
            Preconditions.checkNotNull(uPSTurnCallBack);
            if (!s.b()) {
                uPSTurnCallBack.onResult(new TokenResult(ErrorEnum.ERROR_OPERATION_NOT_SUPPORTED.getExternalCode()));
            } else {
                HmsMessaging.getInstance(context).turnOffPush().a(new fcc<Void>(uPSTurnCallBack) { // from class: com.huawei.hms.push.ups.UPSService.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ UPSTurnCallBack a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {uPSTurnCallBack};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = uPSTurnCallBack;
                    }

                    @Override // com.baidu.tieba.fcc
                    public void onComplete(icc<Void> iccVar) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, iccVar) == null) {
                            if (iccVar.h()) {
                                this.a.onResult(new CodeResult());
                                return;
                            }
                            ApiException apiException = (ApiException) iccVar.d();
                            this.a.onResult(new CodeResult(apiException.getStatusCode(), apiException.getMessage()));
                        }
                    }
                });
            }
        }
    }

    public static void turnOnPush(Context context, UPSTurnCallBack uPSTurnCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, context, uPSTurnCallBack) == null) {
            HMSLog.i("UPSService", "invoke turnOnPush");
            Preconditions.checkNotNull(uPSTurnCallBack);
            if (!s.b()) {
                uPSTurnCallBack.onResult(new TokenResult(ErrorEnum.ERROR_OPERATION_NOT_SUPPORTED.getExternalCode()));
            } else {
                HmsMessaging.getInstance(context).turnOnPush().a(new fcc<Void>(uPSTurnCallBack) { // from class: com.huawei.hms.push.ups.UPSService.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ UPSTurnCallBack a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {uPSTurnCallBack};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = uPSTurnCallBack;
                    }

                    @Override // com.baidu.tieba.fcc
                    public void onComplete(icc<Void> iccVar) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, iccVar) == null) {
                            if (iccVar.h()) {
                                this.a.onResult(new CodeResult());
                                return;
                            }
                            ApiException apiException = (ApiException) iccVar.d();
                            this.a.onResult(new CodeResult(apiException.getStatusCode(), apiException.getMessage()));
                        }
                    }
                });
            }
        }
    }

    public static void unRegisterToken(Context context, UPSUnRegisterCallBack uPSUnRegisterCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, uPSUnRegisterCallBack) == null) {
            HMSLog.i("UPSService", "invoke unRegisterToken");
            Preconditions.checkNotNull(uPSUnRegisterCallBack);
            if (!s.b()) {
                uPSUnRegisterCallBack.onResult(new TokenResult(ErrorEnum.ERROR_OPERATION_NOT_SUPPORTED.getExternalCode()));
                return;
            }
            try {
                HmsInstanceId.getInstance(context).deleteToken(null, null);
                uPSUnRegisterCallBack.onResult(new TokenResult());
            } catch (ApiException e) {
                uPSUnRegisterCallBack.onResult(new TokenResult(e.getStatusCode(), e.getMessage()));
            }
        }
    }
}
