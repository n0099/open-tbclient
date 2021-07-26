package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class cn {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f40207a;

    /* renamed from: a  reason: collision with other field name */
    public long f189a;

    /* renamed from: a  reason: collision with other field name */
    public String f190a;

    /* renamed from: b  reason: collision with root package name */
    public long f40208b;

    /* renamed from: c  reason: collision with root package name */
    public long f40209c;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public cn() {
        this(0, 0L, 0L, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr = newInitContext.callArgs;
                this(((Integer) objArr[0]).intValue(), ((Long) objArr[1]).longValue(), ((Long) objArr[2]).longValue(), (Exception) objArr[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public cn(int i2, long j, long j2, Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2), exc};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f40207a = i2;
        this.f189a = j;
        this.f40209c = j2;
        this.f40208b = System.currentTimeMillis();
        if (exc != null) {
            this.f190a = exc.getClass().getSimpleName();
        }
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f40207a : invokeV.intValue;
    }

    public cn a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject)) == null) {
            this.f189a = jSONObject.getLong("cost");
            this.f40209c = jSONObject.getLong("size");
            this.f40208b = jSONObject.getLong("ts");
            this.f40207a = jSONObject.getInt("wt");
            this.f190a = jSONObject.optString("expt");
            return this;
        }
        return (cn) invokeL.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public JSONObject m218a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("cost", this.f189a);
            jSONObject.put("size", this.f40209c);
            jSONObject.put("ts", this.f40208b);
            jSONObject.put("wt", this.f40207a);
            jSONObject.put("expt", this.f190a);
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
