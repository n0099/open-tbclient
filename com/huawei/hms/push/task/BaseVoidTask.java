package com.huawei.hms.push.task;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.xyb;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.task.PushClient;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.push.utils.PushBiUtil;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.log.HMSLog;
/* loaded from: classes10.dex */
public class BaseVoidTask extends TaskApiCall<PushClient, Void> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getMinApkVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return 30000000;
        }
        return invokeV.intValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseVoidTask(String str, String str2, String str3) {
        super(str, str2, str3);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((String) objArr2[0], (String) objArr2[1], (String) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.huawei.hms.common.internal.TaskApiCall
    public void doExecute(PushClient pushClient, ResponseErrorCode responseErrorCode, String str, xyb<Void> xybVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, pushClient, responseErrorCode, str, xybVar) == null) {
            if (responseErrorCode.getErrorCode() == 0) {
                HMSLog.i("BaseVoidTask", "Operate succeed");
                xybVar.setResult(null);
            } else {
                HMSLog.e("BaseVoidTask", "Operate failed with ret=" + responseErrorCode.getErrorCode());
                ErrorEnum fromCode = ErrorEnum.fromCode(responseErrorCode.getErrorCode());
                if (fromCode != ErrorEnum.ERROR_UNKNOWN) {
                    xybVar.c(fromCode.toApiException());
                } else {
                    xybVar.c(new ApiException(new Status(responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason())));
                }
            }
            PushBiUtil.reportExit(pushClient.getContext(), getUri(), responseErrorCode);
        }
    }
}
