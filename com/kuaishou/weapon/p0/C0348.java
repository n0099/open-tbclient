package com.kuaishou.weapon.p0;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import org.json.JSONObject;
/* renamed from: com.kuaishou.weapon.p0.ʼﾞ  reason: contains not printable characters */
/* loaded from: classes5.dex */
public class C0348 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: ʻ  reason: contains not printable characters */
    public String f155;

    /* renamed from: ʼ  reason: contains not printable characters */
    public Map<String, String> f156;

    /* renamed from: ʽ  reason: contains not printable characters */
    public JSONObject f157;

    /* renamed from: ʾ  reason: contains not printable characters */
    public String f158;

    public C0348(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, jSONObject};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f155 = str;
        this.f157 = jSONObject;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public JSONObject m316() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f157 : (JSONObject) invokeV.objValue;
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public String m317() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f158 : (String) invokeV.objValue;
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public Map<String, String> m318() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f156 : (Map) invokeV.objValue;
    }
}
