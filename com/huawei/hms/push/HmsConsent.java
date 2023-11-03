package com.huawei.hms.push;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.m7c;
import com.baidu.tieba.n7c;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.task.PushClientBuilder;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.push.task.ConsentTask;
import com.huawei.hms.push.utils.PushBiUtil;
import com.huawei.hms.support.api.entity.push.EnableConsentReq;
import com.huawei.hms.support.api.entity.push.PushNaming;
import com.huawei.hms.utils.JsonUtil;
/* loaded from: classes10.dex */
public class HmsConsent {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HuaweiApi<Api.ApiOptions.NoOptions> a;
    public Context b;

    public HmsConsent(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Preconditions.checkNotNull(context);
        this.b = context;
        HuaweiApi<Api.ApiOptions.NoOptions> huaweiApi = new HuaweiApi<>(context, new Api(HuaweiApiAvailability.HMS_API_NAME_PUSH), (Api.ApiOptions) null, new PushClientBuilder());
        this.a = huaweiApi;
        huaweiApi.setKitSdkVersion(60500300);
    }

    public static HmsConsent getInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            return new HmsConsent(context);
        }
        return (HmsConsent) invokeL.objValue;
    }

    /* JADX DEBUG: Type inference failed for r6v10. Raw type applied. Possible types: com.baidu.tieba.m7c<TResult>, com.baidu.tieba.m7c<java.lang.Void> */
    public final m7c<Void> a(boolean z) {
        InterceptResult invokeZ;
        n7c n7cVar;
        int externalCode;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            String reportEntry = PushBiUtil.reportEntry(this.b, PushNaming.PUSH_CONSENT);
            try {
                if (s.d(this.b)) {
                    EnableConsentReq enableConsentReq = new EnableConsentReq();
                    enableConsentReq.setPackageName(this.b.getPackageName());
                    enableConsentReq.setEnable(z);
                    return this.a.doWrite(new ConsentTask(PushNaming.PUSH_CONSENT, JsonUtil.createJsonString(enableConsentReq), reportEntry));
                }
                throw ErrorEnum.ERROR_OPERATION_NOT_SUPPORTED.toApiException();
            } catch (ApiException e) {
                n7c n7cVar2 = new n7c();
                n7cVar2.c(e);
                externalCode = e.getStatusCode();
                n7cVar = n7cVar2;
                PushBiUtil.reportExit(this.b, PushNaming.PUSH_CONSENT, reportEntry, externalCode);
                return n7cVar.b();
            } catch (Exception unused) {
                n7cVar = new n7c();
                n7cVar.c(ErrorEnum.ERROR_INTERNAL_ERROR.toApiException());
                externalCode = ErrorEnum.ERROR_INTERNAL_ERROR.getExternalCode();
                PushBiUtil.reportExit(this.b, PushNaming.PUSH_CONSENT, reportEntry, externalCode);
                return n7cVar.b();
            }
        }
        return (m7c) invokeZ.objValue;
    }

    public m7c<Void> consentOff() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return a(false);
        }
        return (m7c) invokeV.objValue;
    }

    public m7c<Void> consentOn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return a(true);
        }
        return (m7c) invokeV.objValue;
    }
}
