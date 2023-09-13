package com.huawei.hms.aaid;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.wyb;
import com.baidu.tieba.xyb;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.entity.TokenReq;
import com.huawei.hms.aaid.entity.TokenResult;
import com.huawei.hms.aaid.plugin.ProxyCenter;
import com.huawei.hms.aaid.task.PushClientBuilder;
import com.huawei.hms.aaid.utils.PushPreferences;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.opendevice.l;
import com.huawei.hms.opendevice.o;
import com.huawei.hms.opendevice.q;
import com.huawei.hms.support.log.HMSLog;
import java.util.UUID;
@Deprecated
/* loaded from: classes10.dex */
public class HmsInstanceIdEx {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "HmsInstanceIdEx";
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public PushPreferences b;
    public HuaweiApi<Api.ApiOptions.NoOptions> c;

    public HmsInstanceIdEx(Context context) {
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
        this.a = null;
        this.b = null;
        this.a = context;
        this.b = new PushPreferences(context, "aaid");
        HuaweiApi<Api.ApiOptions.NoOptions> huaweiApi = new HuaweiApi<>(context, new Api(HuaweiApiAvailability.HMS_API_NAME_PUSH), (Api.ApiOptions) null, new PushClientBuilder());
        this.c = huaweiApi;
        huaweiApi.setKitSdkVersion(60300305);
    }

    public String getAAId(String str) throws ApiException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (str != null) {
                try {
                    if (this.b.containsKey(str)) {
                        return this.b.getString(str);
                    }
                    String uuid = UUID.randomUUID().toString();
                    this.b.saveString(str, uuid);
                    this.b.saveLong(a(str), Long.valueOf(System.currentTimeMillis()));
                    return uuid;
                } catch (RuntimeException unused) {
                    throw ErrorEnum.ERROR_INTERNAL_ERROR.toApiException();
                } catch (Exception unused2) {
                    throw ErrorEnum.ERROR_INTERNAL_ERROR.toApiException();
                }
            }
            throw ErrorEnum.ERROR_ARGUMENTS_INVALID.toApiException();
        }
        return (String) invokeL.objValue;
    }

    public static HmsInstanceIdEx getInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            Preconditions.checkNotNull(context);
            return new HmsInstanceIdEx(context);
        }
        return (HmsInstanceIdEx) invokeL.objValue;
    }

    public final wyb<TokenResult> a(Exception exc) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, exc)) == null) {
            xyb xybVar = new xyb();
            xybVar.c(exc);
            return xybVar.b();
        }
        return (wyb) invokeL.objValue;
    }

    public final String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            return "creationTime" + str;
        }
        return (String) invokeL.objValue;
    }

    public void deleteAAID(String str) throws ApiException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            if (str != null) {
                try {
                    if (this.b.containsKey(str)) {
                        this.b.removeKey(str);
                        this.b.removeKey(a(str));
                        return;
                    }
                    return;
                } catch (RuntimeException unused) {
                    throw ErrorEnum.ERROR_INTERNAL_ERROR.toApiException();
                } catch (Exception unused2) {
                    throw ErrorEnum.ERROR_INTERNAL_ERROR.toApiException();
                }
            }
            throw ErrorEnum.ERROR_ARGUMENTS_INVALID.toApiException();
        }
    }

    public long getCreationTime(String str) throws ApiException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (str != null) {
                try {
                    if (!this.b.containsKey(a(str))) {
                        getAAId(str);
                    }
                    return this.b.getLong(a(str));
                } catch (RuntimeException unused) {
                    throw ErrorEnum.ERROR_INTERNAL_ERROR.toApiException();
                } catch (Exception unused2) {
                    throw ErrorEnum.ERROR_INTERNAL_ERROR.toApiException();
                }
            }
            throw ErrorEnum.ERROR_ARGUMENTS_INVALID.toApiException();
        }
        return invokeL.longValue;
    }

    /* JADX DEBUG: Type inference failed for r0v22. Raw type applied. Possible types: com.baidu.tieba.wyb<TResult>, com.baidu.tieba.wyb<com.huawei.hms.aaid.entity.TokenResult> */
    public wyb<TokenResult> getToken() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (ProxyCenter.getProxy() != null) {
                try {
                    HMSLog.i(TAG, "use proxy get token, please check HmsMessageService.onNewToken receive result.");
                    ProxyCenter.getProxy().getToken(this.a, null, null);
                    xyb xybVar = new xyb();
                    xybVar.setResult(new TokenResult());
                    return xybVar.b();
                } catch (ApiException e) {
                    return a(e);
                } catch (Exception unused) {
                    return a(ErrorEnum.ERROR_INTERNAL_ERROR.toApiException());
                }
            }
            String a = q.a(this.a, "push.gettoken");
            try {
                TokenReq b = o.b(this.a, null, null);
                b.setAaid(HmsInstanceId.getInstance(this.a).getId());
                return this.c.doWrite(new l("push.gettoken", b, this.a, a));
            } catch (RuntimeException unused2) {
                q.a(this.a, "push.gettoken", a, ErrorEnum.ERROR_INTERNAL_ERROR);
                return a(ErrorEnum.ERROR_INTERNAL_ERROR.toApiException());
            } catch (Exception unused3) {
                q.a(this.a, "push.gettoken", a, ErrorEnum.ERROR_INTERNAL_ERROR);
                return a(ErrorEnum.ERROR_INTERNAL_ERROR.toApiException());
            }
        }
        return (wyb) invokeV.objValue;
    }
}
