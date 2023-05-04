package com.huawei.hms.opendevice;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.j0b;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.aaid.HmsInstanceId;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.entity.TokenReq;
import com.huawei.hms.aaid.entity.TokenResp;
import com.huawei.hms.aaid.entity.TokenResult;
import com.huawei.hms.aaid.task.PushClient;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;
/* loaded from: classes8.dex */
public class l extends TaskApiCall<PushClient, TokenResult> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public TokenReq b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(String str, TokenReq tokenReq, Context context, String str2) {
        super(str, JsonUtil.createJsonString(tokenReq), str2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, tokenReq, context, str2};
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
        this.a = context;
        this.b = tokenReq;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.huawei.hms.common.internal.TaskApiCall
    /* renamed from: a */
    public void doExecute(PushClient pushClient, ResponseErrorCode responseErrorCode, String str, j0b<TokenResult> j0bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, pushClient, responseErrorCode, str, j0bVar) == null) {
            if (responseErrorCode.getErrorCode() != 0) {
                String str2 = HmsInstanceId.TAG;
                HMSLog.e(str2, "TokenTask failed, ErrorCode:" + responseErrorCode.getErrorCode());
                a(responseErrorCode, j0bVar);
            } else {
                TokenResp tokenResp = (TokenResp) JsonUtil.jsonToEntity(str, new TokenResp());
                ErrorEnum fromCode = ErrorEnum.fromCode(tokenResp.getRetCode());
                if (fromCode != ErrorEnum.SUCCESS) {
                    j0bVar.c(fromCode.toApiException());
                    String str3 = HmsInstanceId.TAG;
                    HMSLog.e(str3, "TokenTask failed, StatusCode:" + fromCode.getExternalCode());
                } else {
                    TokenResult tokenResult = new TokenResult();
                    tokenResult.setToken(tokenResp.getToken());
                    tokenResult.setBelongId(tokenResp.getBelongId());
                    tokenResult.setRetCode(ErrorEnum.fromCode(tokenResp.getRetCode()).getExternalCode());
                    j0bVar.setResult(tokenResult);
                    String token = tokenResp.getToken();
                    if (TextUtils.isEmpty(token)) {
                        HMSLog.i(HmsInstanceId.TAG, "GetTokenTask receive a empty token, please check HmsMessageService.onNewToken receive result.");
                        q.a(pushClient.getContext(), getUri(), responseErrorCode);
                        return;
                    }
                    a(token, this.b.getSubjectId());
                    n.a(this.a, token);
                }
            }
            q.a(pushClient.getContext(), getUri(), responseErrorCode);
        }
    }

    public final void a(ResponseErrorCode responseErrorCode, j0b<TokenResult> j0bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, responseErrorCode, j0bVar) == null) {
            ErrorEnum fromCode = ErrorEnum.fromCode(responseErrorCode.getErrorCode());
            if (fromCode != ErrorEnum.ERROR_UNKNOWN) {
                j0bVar.c(fromCode.toApiException());
            } else {
                j0bVar.c(new ApiException(new Status(responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason())));
            }
        }
    }

    public final void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) && !i.a(this.a).b(str2).equals(str)) {
            HMSLog.i(HmsInstanceId.TAG, "receive a token, refresh the local token");
            i.a(this.a).b(str2, str);
        }
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getMinApkVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.b.isMultiSender()) {
                return 50004300;
            }
            return 30000000;
        }
        return invokeV.intValue;
    }
}
