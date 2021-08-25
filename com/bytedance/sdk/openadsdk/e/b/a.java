package com.bytedance.sdk.openadsdk.e.b;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.e.b.c;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a<T extends c> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f67510a;

    /* renamed from: b  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.core.e.m f67511b;

    /* renamed from: c  reason: collision with root package name */
    public String f67512c;

    /* renamed from: d  reason: collision with root package name */
    public JSONObject f67513d;

    /* renamed from: e  reason: collision with root package name */
    public T f67514e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f67515f;

    public a(Context context, com.bytedance.sdk.openadsdk.core.e.m mVar, String str, JSONObject jSONObject, T t) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, mVar, str, jSONObject, t};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f67514e = null;
        this.f67515f = false;
        this.f67510a = context;
        this.f67511b = mVar;
        this.f67512c = str;
        this.f67513d = jSONObject;
        this.f67514e = t;
    }

    public Context a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f67510a : (Context) invokeV.objValue;
    }

    public com.bytedance.sdk.openadsdk.core.e.m b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f67511b : (com.bytedance.sdk.openadsdk.core.e.m) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f67512c : (String) invokeV.objValue;
    }

    public JSONObject d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f67513d == null) {
                this.f67513d = new JSONObject();
            }
            return this.f67513d;
        }
        return (JSONObject) invokeV.objValue;
    }

    public T e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f67514e : (T) invokeV.objValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f67515f : invokeV.booleanValue;
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.f67515f = z;
        }
    }
}
