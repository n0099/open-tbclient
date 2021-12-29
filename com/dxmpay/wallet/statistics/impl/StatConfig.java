package com.dxmpay.wallet.statistics.impl;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.f.a.g.d.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.fsg.base.statistics.k;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.api.BaiduWallet;
import com.duxiaoman.dxmpay.statistics.internal.IStatConfig;
import com.dxmpay.apollon.ApollonConstants;
import com.dxmpay.apollon.NoProguard;
import com.dxmpay.apollon.armor.SecurePay;
import com.dxmpay.apollon.restnet.RestNameValuePair;
import com.dxmpay.apollon.restnet.RestRuntimeException;
import com.dxmpay.apollon.restnet.RestTemplate;
import com.dxmpay.apollon.restnet.rest.RestHttpRequestInterceptor;
import com.dxmpay.apollon.utils.PhoneUtils;
import com.dxmpay.wallet.api.WalletLoginHelper;
import com.dxmpay.wallet.core.DebugConfig;
import com.dxmpay.wallet.core.beans.BeanConstants;
import com.dxmpay.wallet.core.domain.DomainConfig;
import com.dxmpay.wallet.core.utils.UAFilterUtil;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class StatConfig implements IStatConfig, NoProguard {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f56165e;

    /* loaded from: classes2.dex */
    public class a implements RestHttpRequestInterceptor {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(StatConfig statConfig) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {statConfig};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.dxmpay.apollon.restnet.rest.RestHttpRequestInterceptor
        public void a(Context context, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, context, dVar) == null) {
                dVar.a().e("Accept-Encoding", "gzip");
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public static StatConfig a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-30497580, "Lcom/dxmpay/wallet/statistics/impl/StatConfig$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-30497580, "Lcom/dxmpay/wallet/statistics/impl/StatConfig$b;");
                    return;
                }
            }
            a = new StatConfig(null);
        }
    }

    public /* synthetic */ StatConfig(a aVar) {
        this();
    }

    public static StatConfig getInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            b.a.setContext(context);
            return b.a;
        }
        return (StatConfig) invokeL.objValue;
    }

    public final String a(Context context, int i2, String str) {
        InterceptResult invokeLIL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, context, i2, str)) == null) {
            RestTemplate restTemplate = new RestTemplate(context, UAFilterUtil.getInstance().getTrueUA(context), ApollonConstants.HTTP_REQUEST_TYPE_STASTICS_BEAN);
            ArrayList arrayList = new ArrayList();
            String d2 = c.f.b.f.a.a.a().d(context);
            if (!TextUtils.isEmpty(d2)) {
                arrayList.add(new RestNameValuePair("ua", d2));
            }
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(new a(this));
            restTemplate.setRequestInterceptor(arrayList2);
            restTemplate.setMessageConverter(new c.f.a.g.b.b());
            String str3 = null;
            try {
                if (i2 == 0) {
                    str2 = (String) restTemplate.d(str, arrayList, "utf-8", String.class);
                } else {
                    str2 = (String) restTemplate.l(str, arrayList, "utf-8", String.class);
                }
                str3 = str2;
                return str3;
            } catch (RestRuntimeException e2) {
                e2.printStackTrace();
                return str3;
            }
        }
        return (String) invokeLIL.objValue;
    }

    @Override // com.duxiaoman.dxmpay.statistics.internal.IStatConfig
    public String getAppVersionCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? String.valueOf(PhoneUtils.getAppVersionCode(this.f56165e)) : (String) invokeV.objValue;
    }

    @Override // com.duxiaoman.dxmpay.statistics.internal.IStatConfig
    public String getAppVersionName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? PhoneUtils.getAppVersionName(this.f56165e) : (String) invokeV.objValue;
    }

    @Override // com.duxiaoman.dxmpay.statistics.internal.IStatConfig
    public String getChannelId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? BeanConstants.CHANNEL_ID : (String) invokeV.objValue;
    }

    @Override // com.duxiaoman.dxmpay.statistics.internal.IStatConfig
    public String getCommonEvent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "DXMPaySDK" : (String) invokeV.objValue;
    }

    @Override // com.duxiaoman.dxmpay.statistics.internal.IStatConfig
    public String getDistinctId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (isLogin() && !TextUtils.isEmpty(WalletLoginHelper.getInstance().getUnionId())) {
                return SecurePay.getInstance().encryptProxy(WalletLoginHelper.getInstance().getUnionId());
            }
            return SecurePay.getInstance().encryptProxy(c.f.b.f.a.a.a().c(this.f56165e));
        }
        return (String) invokeV.objValue;
    }

    @Override // com.duxiaoman.dxmpay.statistics.internal.IStatConfig
    public String getDistinctIdKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? SecurePay.getInstance().getpwProxy() : (String) invokeV.objValue;
    }

    @Override // com.duxiaoman.dxmpay.statistics.internal.IStatConfig
    public String getHeader() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                if (this.f56165e != null) {
                    c.f.b.f.a.a a2 = c.f.b.f.a.a.a();
                    jSONObject.putOpt("ua", a2.d(this.f56165e));
                    jSONObject.putOpt(k.f34934b, a2.b(this.f56165e));
                    jSONObject.putOpt("op", a2.e(this.f56165e));
                    jSONObject.put(k.f34935c, a2.c(this.f56165e));
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject.toString();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.duxiaoman.dxmpay.statistics.internal.IStatConfig
    public String getProductName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? BaiduWallet.TAG : (String) invokeV.objValue;
    }

    @Override // com.duxiaoman.dxmpay.statistics.internal.IStatConfig
    public String getSDKVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? BeanConstants.VERSION_NO : (String) invokeV.objValue;
    }

    @Override // com.duxiaoman.dxmpay.statistics.internal.IStatConfig
    public String getUploadUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return DebugConfig.getInstance().getSenorStatisticsHost() + "/sensors_batch/v2";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.duxiaoman.dxmpay.statistics.internal.IStatConfig
    public boolean isLogin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? WalletLoginHelper.getInstance().isLogin() : invokeV.booleanValue;
    }

    @Override // com.duxiaoman.dxmpay.statistics.internal.IStatConfig
    public String loadDefaultStrategy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? "{\"content\":{\"disable\":\"0\",\"3G\":\"5\",\"wifi\":\"3\",\"now\":[\"std_pay_success\",\"std_pay_failed\",\"percashier_pay_success\",\"percashier_pay_failed\",\"initiative_bind_card_failed\",\"initiative_bind_card_success\",\"lbs_pay_result_error\",\"lbs_pay_result_paying\",\"lbs_pay_result_cancel\",\"lbs_pay_result_success\",\"_endLivenessSDK\",\"endIDCard\"],\"never\":[]}}" : (String) invokeV.objValue;
    }

    @Override // com.duxiaoman.dxmpay.statistics.internal.IStatConfig
    public String loadStrategy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return a(this.f56165e, 0, DomainConfig.getInstance().getAppPayHost() + "/aif/sdk/category");
        }
        return (String) invokeV.objValue;
    }

    @Override // com.duxiaoman.dxmpay.statistics.internal.IStatConfig
    public void setContext(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, context) == null) && this.f56165e == null && context != null) {
            this.f56165e = context.getApplicationContext();
        }
    }

    public StatConfig() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }
}
