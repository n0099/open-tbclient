package com.qq.e.ads.nativ;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class NativeUnifiedADAppInfoImpl implements NativeUnifiedADAppMiitInfo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final String b;
    public final long c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;

    /* loaded from: classes10.dex */
    public interface Keys {
        public static final String APP_NAME = "app_name";
        public static final String AUTHOR_NAME = "author_name";
        public static final String DESCRIPTION_URL = "description_url";
        public static final String PACKAGE_SIZE = "package_size";
        public static final String PERMISSION_URL = "permission_url";
        public static final String PRIVACY_AGREEMENT = "privacy_agreement";
        public static final String VERSION_NAME = "version_name";
    }

    public NativeUnifiedADAppInfoImpl(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONObject};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = jSONObject.optString("app_name");
        this.b = jSONObject.optString(Keys.AUTHOR_NAME);
        this.c = jSONObject.optLong(Keys.PACKAGE_SIZE);
        this.d = jSONObject.optString(Keys.PERMISSION_URL);
        this.e = jSONObject.optString(Keys.PRIVACY_AGREEMENT);
        this.f = jSONObject.optString(Keys.VERSION_NAME);
        this.g = jSONObject.optString(Keys.DESCRIPTION_URL);
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo
    public String getAppName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (String) invokeV.objValue;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo
    public String getAuthorName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.b : (String) invokeV.objValue;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo
    public String getDescriptionUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.g : (String) invokeV.objValue;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo
    public long getPackageSizeBytes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.c : invokeV.longValue;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo
    public String getPermissionsUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.d : (String) invokeV.objValue;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo
    public String getPrivacyAgreement() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.e : (String) invokeV.objValue;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo
    public String getVersionName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f : (String) invokeV.objValue;
    }
}
