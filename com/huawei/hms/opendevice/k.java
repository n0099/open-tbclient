package com.huawei.hms.opendevice;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.qcb;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.aaid.HmsInstanceId;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.entity.DeleteTokenReq;
import com.huawei.hms.aaid.entity.DeleteTokenResp;
import com.huawei.hms.aaid.task.PushClient;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;
/* loaded from: classes9.dex */
public class k extends TaskApiCall<PushClient, Void> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public DeleteTokenReq a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(String str, DeleteTokenReq deleteTokenReq, String str2) {
        super(str, JsonUtil.createJsonString(deleteTokenReq), str2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, deleteTokenReq, str2};
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
        this.a = deleteTokenReq;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.huawei.hms.common.internal.TaskApiCall
    /* renamed from: a */
    public void doExecute(PushClient pushClient, ResponseErrorCode responseErrorCode, String str, qcb<Void> qcbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, pushClient, responseErrorCode, str, qcbVar) == null) {
            if (responseErrorCode.getErrorCode() != 0) {
                String str2 = HmsInstanceId.TAG;
                HMSLog.e(str2, "DeleteTokenTask failed, ErrorCode: " + responseErrorCode.getErrorCode());
                ErrorEnum fromCode = ErrorEnum.fromCode(responseErrorCode.getErrorCode());
                if (fromCode != ErrorEnum.ERROR_UNKNOWN) {
                    qcbVar.c(fromCode.toApiException());
                    return;
                } else {
                    qcbVar.c(new ApiException(new Status(responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason())));
                    return;
                }
            }
            ErrorEnum fromCode2 = ErrorEnum.fromCode(((DeleteTokenResp) JsonUtil.jsonToEntity(str, new DeleteTokenResp())).getRetCode());
            if (fromCode2 != ErrorEnum.SUCCESS) {
                qcbVar.c(fromCode2.toApiException());
                return;
            }
            qcbVar.setResult(null);
            q.a(pushClient.getContext(), getUri(), responseErrorCode);
        }
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getMinApkVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.a.isMultiSender()) {
                return 50004300;
            }
            return 30000000;
        }
        return invokeV.intValue;
    }
}
