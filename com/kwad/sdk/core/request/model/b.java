package com.kwad.sdk.core.request.model;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.utils.av;
import com.kwad.sdk.utils.t;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b implements com.kwad.sdk.core.b {
    public static /* synthetic */ Interceptable $ic;
    public static JSONObject a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public String f57764b;

    /* renamed from: c  reason: collision with root package name */
    public String f57765c;

    /* renamed from: d  reason: collision with root package name */
    public String f57766d;

    /* renamed from: e  reason: collision with root package name */
    public String f57767e;

    /* renamed from: f  reason: collision with root package name */
    public String f57768f;

    public b() {
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

    public static JSONObject a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (!a(a)) {
                a = b().toJson();
            }
            return a;
        }
        return (JSONObject) invokeV.objValue;
    }

    public static boolean a(@Nullable JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return false;
            }
            String optString = jSONObject.optString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
            String optString2 = jSONObject.optString("name");
            return !TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString) && optString.equals(KsAdSDKImpl.get().getAppId()) && optString2.equals(KsAdSDKImpl.get().getAppName());
        }
        return invokeL.booleanValue;
    }

    public static b b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            b bVar = new b();
            bVar.f57764b = KsAdSDKImpl.get().getAppId();
            bVar.f57765c = KsAdSDKImpl.get().getAppName();
            Context context = KsAdSDKImpl.get().getContext();
            if (context != null) {
                bVar.f57766d = context.getPackageName();
                bVar.f57767e = av.w(context);
            }
            bVar.f57768f = com.kwad.sdk.utils.g.a(context);
            return bVar;
        }
        return (b) invokeV.objValue;
    }

    @Override // com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
        }
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            t.a(jSONObject, BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.f57764b);
            t.a(jSONObject, "name", this.f57765c);
            t.a(jSONObject, "packageName", this.f57766d);
            t.a(jSONObject, "version", this.f57767e);
            t.a(jSONObject, "sha1", this.f57768f);
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
