package com.huawei.hms.push;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ewa;
import com.baidu.tieba.fva;
import com.baidu.tieba.fwa;
import com.baidu.tieba.qwa;
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
import com.huawei.hms.push.task.ProfileTask;
import com.huawei.hms.push.utils.PushBiUtil;
import com.huawei.hms.support.api.entity.push.ProfileReq;
import com.huawei.hms.support.api.entity.push.PushNaming;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;
/* loaded from: classes8.dex */
public class HmsProfile {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CUSTOM_PROFILE = 2;
    public static final int HUAWEI_PROFILE = 1;
    public static final String a = "HmsProfile";
    public transient /* synthetic */ FieldHolder $fh;
    public Context b;
    public HuaweiApi<Api.ApiOptions.NoOptions> c;

    public HmsProfile(Context context) {
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
        this.b = null;
        Preconditions.checkNotNull(context);
        this.b = context;
        HuaweiApi<Api.ApiOptions.NoOptions> huaweiApi = new HuaweiApi<>(context, new Api(HuaweiApiAvailability.HMS_API_NAME_PUSH), (Api.ApiOptions) null, new PushClientBuilder());
        this.c = huaweiApi;
        huaweiApi.setKitSdkVersion(60500300);
    }

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            return fva.c(context).a("client/project_id");
        }
        return (String) invokeL.objValue;
    }

    public static HmsProfile getInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            return new HmsProfile(context);
        }
        return (HmsProfile) invokeL.objValue;
    }

    public final boolean b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
            if (s.b(context) >= 110001400) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public ewa<Void> deleteProfile(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            return deleteProfile("", str);
        }
        return (ewa) invokeL.objValue;
    }

    /* JADX DEBUG: Type inference failed for r5v9. Raw type applied. Possible types: com.baidu.tieba.ewa<TResult>, com.baidu.tieba.ewa<java.lang.Void> */
    public final ewa<Void> a(int i, String str, int i2, String str2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2), str2})) == null) {
            if (!isSupportProfile()) {
                fwa fwaVar = new fwa();
                fwaVar.c(ErrorEnum.ERROR_OPERATION_NOT_SUPPORTED.toApiException());
                return fwaVar.b();
            }
            if (!TextUtils.isEmpty(str)) {
                String a2 = a(this.b);
                if (TextUtils.isEmpty(a2)) {
                    HMSLog.i(a, "agc connect services config missing project id.");
                    fwa fwaVar2 = new fwa();
                    fwaVar2.c(ErrorEnum.ERROR_MISSING_PROJECT_ID.toApiException());
                    return fwaVar2.b();
                } else if (str.equals(a2)) {
                    str = "";
                }
            }
            ProfileReq profileReq = new ProfileReq();
            if (i == 0) {
                profileReq.setOperation(0);
                profileReq.setType(i2);
            } else {
                profileReq.setOperation(1);
            }
            String reportEntry = PushBiUtil.reportEntry(this.b, PushNaming.PUSH_PROFILE);
            try {
                profileReq.setSubjectId(str);
                profileReq.setProfileId(qwa.b(str2));
                profileReq.setPkgName(this.b.getPackageName());
                return this.c.doWrite(new ProfileTask(PushNaming.PUSH_PROFILE, JsonUtil.createJsonString(profileReq), reportEntry));
            } catch (Exception e) {
                if (e.getCause() instanceof ApiException) {
                    fwa fwaVar3 = new fwa();
                    ApiException apiException = (ApiException) e.getCause();
                    fwaVar3.c(apiException);
                    PushBiUtil.reportExit(this.b, PushNaming.PUSH_PROFILE, reportEntry, apiException.getStatusCode());
                    return fwaVar3.b();
                }
                fwa fwaVar4 = new fwa();
                PushBiUtil.reportExit(this.b, PushNaming.PUSH_PROFILE, reportEntry, ErrorEnum.ERROR_INTERNAL_ERROR);
                fwaVar4.c(ErrorEnum.ERROR_INTERNAL_ERROR.toApiException());
                return fwaVar4.b();
            }
        }
        return (ewa) invokeCommon.objValue;
    }

    public ewa<Void> addProfile(int i, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str)) == null) {
            return addProfile("", i, str);
        }
        return (ewa) invokeIL.objValue;
    }

    public ewa<Void> addProfile(String str, int i, String str2) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, str, i, str2)) == null) {
            if (i != 1 && i != 2) {
                HMSLog.i(a, "add profile type undefined.");
                fwa fwaVar = new fwa();
                fwaVar.c(ErrorEnum.ERROR_PUSH_ARGUMENTS_INVALID.toApiException());
                return fwaVar.b();
            } else if (TextUtils.isEmpty(str2)) {
                HMSLog.i(a, "add profile params is empty.");
                fwa fwaVar2 = new fwa();
                fwaVar2.c(ErrorEnum.ERROR_PUSH_ARGUMENTS_INVALID.toApiException());
                return fwaVar2.b();
            } else {
                return a(0, str, i, str2);
            }
        }
        return (ewa) invokeLIL.objValue;
    }

    public ewa<Void> deleteProfile(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, str2)) == null) {
            if (TextUtils.isEmpty(str2)) {
                HMSLog.e(a, "del profile params is empty.");
                fwa fwaVar = new fwa();
                fwaVar.c(ErrorEnum.ERROR_PUSH_ARGUMENTS_INVALID.toApiException());
                return fwaVar.b();
            }
            return a(1, str, -1, str2);
        }
        return (ewa) invokeLL.objValue;
    }

    public boolean isSupportProfile() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (s.d(this.b)) {
                if (s.c()) {
                    HMSLog.i(a, "current EMUI version below 9.1, not support profile operation.");
                    return false;
                } else if (!b(this.b)) {
                    HMSLog.i(a, "current HwPushService.apk version below 11.0.1.400,please upgrade your HwPushService.apk version.");
                    return false;
                } else {
                    return true;
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }
}
