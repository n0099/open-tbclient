package com.huawei.hms.aaid;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.vvb;
import com.baidu.tieba.wvb;
import com.baidu.tieba.yvb;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.entity.AAIDResult;
import com.huawei.hms.aaid.entity.DeleteTokenReq;
import com.huawei.hms.aaid.entity.TokenReq;
import com.huawei.hms.aaid.entity.TokenResult;
import com.huawei.hms.aaid.plugin.ProxyCenter;
import com.huawei.hms.aaid.task.PushClientBuilder;
import com.huawei.hms.aaid.utils.BaseUtils;
import com.huawei.hms.aaid.utils.PushPreferences;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.opendevice.c;
import com.huawei.hms.opendevice.i;
import com.huawei.hms.opendevice.j;
import com.huawei.hms.opendevice.k;
import com.huawei.hms.opendevice.l;
import com.huawei.hms.opendevice.o;
import com.huawei.hms.opendevice.p;
import com.huawei.hms.opendevice.q;
import com.huawei.hms.support.log.HMSLog;
/* loaded from: classes9.dex */
public class HmsInstanceId {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "HmsInstanceId";
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public PushPreferences b;
    public HuaweiApi<Api.ApiOptions.NoOptions> c;

    public HmsInstanceId(Context context) {
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
        this.a = context.getApplicationContext();
        this.b = new PushPreferences(context, "aaid");
        HuaweiApi<Api.ApiOptions.NoOptions> huaweiApi = new HuaweiApi<>(context, new Api(HuaweiApiAvailability.HMS_API_NAME_PUSH), (Api.ApiOptions) null, new PushClientBuilder());
        this.c = huaweiApi;
        huaweiApi.setKitSdkVersion(60300305);
    }

    public void deleteToken(String str) throws ApiException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            b();
            a();
            if (!TextUtils.isEmpty(str)) {
                String d = o.d(this.a);
                if (!TextUtils.isEmpty(d)) {
                    if (str.equals(d)) {
                        deleteToken(null, null);
                        return;
                    }
                    DeleteTokenReq a = o.a(this.a, str);
                    a.setMultiSender(true);
                    a(a, 2);
                    return;
                }
                throw ErrorEnum.ERROR_MISSING_PROJECT_ID.toApiException();
            }
            throw ErrorEnum.ERROR_ARGUMENTS_INVALID.toApiException();
        }
    }

    public String getToken(String str) throws ApiException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            b();
            a();
            if (!TextUtils.isEmpty(str)) {
                String d = o.d(this.a);
                if (!TextUtils.isEmpty(d)) {
                    if (str.equals(d)) {
                        return getToken(null, null);
                    }
                    TokenReq b = o.b(this.a, str);
                    b.setAaid(getId());
                    b.setMultiSender(true);
                    return a(b, 2);
                }
                throw ErrorEnum.ERROR_MISSING_PROJECT_ID.toApiException();
            }
            throw ErrorEnum.ERROR_ARGUMENTS_INVALID.toApiException();
        }
        return (String) invokeL.objValue;
    }

    public static HmsInstanceId getInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            Preconditions.checkNotNull(context);
            c.c(context);
            return new HmsInstanceId(context);
        }
        return (HmsInstanceId) invokeL.objValue;
    }

    public final String a(TokenReq tokenReq, int i) throws ApiException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, tokenReq, i)) == null) {
            if (ProxyCenter.getProxy() != null) {
                HMSLog.i(TAG, "use proxy get token, please check HmsMessageService.onNewToken receive result.");
                ProxyCenter.getProxy().getToken(this.a, tokenReq.getSubjectId(), null);
                return null;
            }
            a(tokenReq.getSubjectId());
            String a = q.a(this.a, "push.gettoken");
            try {
                String str = TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("getToken req :");
                sb.append(tokenReq.toString());
                HMSLog.d(str, sb.toString());
                l lVar = new l("push.gettoken", tokenReq, this.a, a);
                lVar.setApiLevel(i);
                return ((TokenResult) yvb.a(this.c.doWrite(lVar))).getToken();
            } catch (Exception e) {
                if (e.getCause() instanceof ApiException) {
                    ApiException apiException = (ApiException) e.getCause();
                    q.a(this.a, "push.gettoken", a, apiException.getStatusCode());
                    throw apiException;
                }
                q.a(this.a, "push.gettoken", a, ErrorEnum.ERROR_INTERNAL_ERROR);
                throw ErrorEnum.ERROR_INTERNAL_ERROR.toApiException();
            }
        }
        return (String) invokeLI.objValue;
    }

    public final void a() throws ApiException {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && BaseUtils.getProxyInit(this.a) && ProxyCenter.getProxy() == null && !BaseUtils.isMainProc(this.a)) {
            HMSLog.e(TAG, "Operations in child processes are not supported.");
            throw ErrorEnum.ERROR_OPER_IN_CHILD_PROCESS.toApiException();
        }
    }

    public vvb<AAIDResult> getAAID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            try {
                return yvb.b(new j(this.a.getApplicationContext()));
            } catch (Exception unused) {
                wvb wvbVar = new wvb();
                wvbVar.c(ErrorEnum.ERROR_INTERNAL_ERROR.toApiException());
                return wvbVar.b();
            }
        }
        return (vvb) invokeV.objValue;
    }

    public final void a(DeleteTokenReq deleteTokenReq, int i) throws ApiException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, deleteTokenReq, i) == null) {
            String subjectId = deleteTokenReq.getSubjectId();
            if (ProxyCenter.getProxy() != null) {
                HMSLog.i(TAG, "use proxy delete token");
                ProxyCenter.getProxy().deleteToken(this.a, subjectId, null);
                return;
            }
            String a = q.a(this.a, "push.deletetoken");
            try {
                String b = i.a(this.a).b(subjectId);
                if (deleteTokenReq.isMultiSender() && (TextUtils.isEmpty(b) || b.equals(i.a(this.a).b(null)))) {
                    i.a(this.a).removeKey(subjectId);
                    HMSLog.i(TAG, "The local subject token is null");
                    return;
                }
                deleteTokenReq.setToken(b);
                k kVar = new k("push.deletetoken", deleteTokenReq, a);
                kVar.setApiLevel(i);
                yvb.a(this.c.doWrite(kVar));
                i.a(this.a).c(subjectId);
            } catch (Exception e) {
                if (e.getCause() instanceof ApiException) {
                    ApiException apiException = (ApiException) e.getCause();
                    q.a(this.a, "push.deletetoken", a, apiException.getStatusCode());
                    throw apiException;
                }
                q.a(this.a, "push.deletetoken", a, ErrorEnum.ERROR_INTERNAL_ERROR);
                throw ErrorEnum.ERROR_INTERNAL_ERROR.toApiException();
            }
        }
    }

    public final void a(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        if (p.e(this.a)) {
            String string = i.a(this.a).getString("subjectId");
            if (TextUtils.isEmpty(string)) {
                i.a(this.a).saveString("subjectId", str);
                return;
            } else if (!string.contains(str)) {
                i a = i.a(this.a);
                a.saveString("subjectId", string + "," + str);
                return;
            } else {
                return;
            }
        }
        i.a(this.a).removeKey("subjectId");
    }

    public final void b() throws ApiException {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || Looper.getMainLooper() != Looper.myLooper()) {
            return;
        }
        throw ErrorEnum.ERROR_MAIN_THREAD.toApiException();
    }

    public long getCreationTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            try {
                if (!this.b.containsKey("creationTime")) {
                    getAAID();
                }
                return this.b.getLong("creationTime");
            } catch (Exception unused) {
                return 0L;
            }
        }
        return invokeV.longValue;
    }

    public String getId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return o.c(this.a);
        }
        return (String) invokeV.objValue;
    }

    @Deprecated
    public String getToken() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            try {
                return getToken(null, null);
            } catch (Exception unused) {
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public void deleteAAID() throws ApiException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            b();
            try {
                if (!this.b.containsKey("aaid")) {
                    return;
                }
                this.b.removeKey("aaid");
                this.b.removeKey("creationTime");
                if (!o.e(this.a)) {
                    return;
                }
                if (ProxyCenter.getProxy() != null) {
                    HMSLog.i(TAG, "use proxy delete all token after delete AaId.");
                    ProxyCenter.getProxy().deleteAllToken(this.a);
                    return;
                }
                DeleteTokenReq b = o.b(this.a);
                b.setDeleteType(1);
                b.setMultiSender(false);
                a(b, 1);
                BaseUtils.deleteAllTokenCache(this.a);
            } catch (ApiException e) {
                throw e;
            } catch (Exception unused) {
                throw ErrorEnum.ERROR_INTERNAL_ERROR.toApiException();
            }
        }
    }

    public void deleteToken(String str, String str2) throws ApiException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, str, str2) == null) {
            b();
            a();
            DeleteTokenReq a = o.a(this.a, str, str2);
            a.setMultiSender(false);
            a(a, 1);
        }
    }

    public String getToken(String str, String str2) throws ApiException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, str, str2)) == null) {
            b();
            a();
            TokenReq b = o.b(this.a, null, str2);
            b.setAaid(getId());
            b.setMultiSender(false);
            i.a(this.a).saveString(this.a.getPackageName(), "1");
            return a(b, 1);
        }
        return (String) invokeLL.objValue;
    }
}
