package com.huawei.hms.push.task;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.i2b;
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
import com.huawei.hms.push.h;
import com.huawei.hms.push.utils.PushBiUtil;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.log.HMSLog;
/* loaded from: classes9.dex */
public class SendUpStreamTask extends TaskApiCall<PushClient, BaseVoidTask> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getMinApkVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return 40003000;
        }
        return invokeV.intValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SendUpStreamTask(String str, String str2, String str3, String str4, String str5) {
        super(str, str2, str3);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3, str4, str5};
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
        this.a = str4;
        this.b = str5;
    }

    public final void a(PushClient pushClient, ResponseErrorCode responseErrorCode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, pushClient, responseErrorCode) == null) {
            HMSLog.i("SendUpStreamTask", "receive upstream, msgId :" + this.b + " , packageName = " + this.a + " , errorCode = " + responseErrorCode.getErrorCode());
            Intent intent = new Intent("com.huawei.push.action.MESSAGING_EVENT");
            intent.setPackage(this.a);
            Bundle bundle = new Bundle();
            bundle.putString("message_id", this.b);
            bundle.putInt("error", responseErrorCode.getErrorCode());
            if (ErrorEnum.SUCCESS.getInternalCode() == responseErrorCode.getErrorCode()) {
                bundle.putString("message_type", "sent_message");
            } else {
                bundle.putString("message_type", "send_error");
            }
            if (new h().a(pushClient.getContext(), bundle, intent)) {
                HMSLog.i("SendUpStreamTask", "receive upstream, start service success");
                PushBiUtil.reportExit(pushClient.getContext(), getUri(), responseErrorCode);
                return;
            }
            HMSLog.w("SendUpStreamTask", "receive upstream, start service failed");
            PushBiUtil.reportExit(pushClient.getContext(), getUri(), responseErrorCode.getTransactionId(), ErrorEnum.ERROR_BIND_SERVICE_SELF_MAPPING);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.huawei.hms.common.internal.TaskApiCall
    public void doExecute(PushClient pushClient, ResponseErrorCode responseErrorCode, String str, i2b<BaseVoidTask> i2bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pushClient, responseErrorCode, str, i2bVar) == null) {
            if (responseErrorCode.getErrorCode() == 0) {
                HMSLog.i("SendUpStreamTask", "send up stream task,Operate succeed");
                i2bVar.setResult(null);
            } else {
                HMSLog.e("SendUpStreamTask", "send up stream task,Operate failed with ret=" + responseErrorCode.getErrorCode());
                ErrorEnum fromCode = ErrorEnum.fromCode(responseErrorCode.getErrorCode());
                if (fromCode != ErrorEnum.ERROR_UNKNOWN) {
                    i2bVar.c(fromCode.toApiException());
                } else {
                    i2bVar.c(new ApiException(new Status(responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason())));
                }
            }
            a(pushClient, responseErrorCode);
        }
    }
}
