package com.huawei.hms.push;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.vvb;
import com.baidu.tieba.wvb;
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

    /* JADX DEBUG: Type inference failed for r6v10. Raw type applied. Possible types: com.baidu.tieba.vvb<TResult>, com.baidu.tieba.vvb<java.lang.Void> */
    public final vvb<Void> a(boolean z) {
        InterceptResult invokeZ;
        wvb wvbVar;
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
                wvb wvbVar2 = new wvb();
                wvbVar2.c(e);
                externalCode = e.getStatusCode();
                wvbVar = wvbVar2;
                PushBiUtil.reportExit(this.b, PushNaming.PUSH_CONSENT, reportEntry, externalCode);
                return wvbVar.b();
            } catch (Exception unused) {
                wvbVar = new wvb();
                wvbVar.c(ErrorEnum.ERROR_INTERNAL_ERROR.toApiException());
                externalCode = ErrorEnum.ERROR_INTERNAL_ERROR.getExternalCode();
                PushBiUtil.reportExit(this.b, PushNaming.PUSH_CONSENT, reportEntry, externalCode);
                return wvbVar.b();
            }
        }
        return (vvb) invokeZ.objValue;
    }

    public vvb<Void> consentOff() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return a(false);
        }
        return (vvb) invokeV.objValue;
    }

    public vvb<Void> consentOn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return a(true);
        }
        return (vvb) invokeV.objValue;
    }
}
