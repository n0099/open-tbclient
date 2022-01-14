package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.meizu.cloud.pushsdk.notification.model.TimeDisplaySetting;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class cn {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public long f194a;

    /* renamed from: a  reason: collision with other field name */
    public String f195a;

    /* renamed from: b  reason: collision with root package name */
    public long f60953b;

    /* renamed from: c  reason: collision with root package name */
    public long f60954c;

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

    public cn(int i2, long j2, long j3, Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(j3), exc};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = i2;
        this.f194a = j2;
        this.f60954c = j3;
        this.f60953b = System.currentTimeMillis();
        if (exc != null) {
            this.f195a = exc.getClass().getSimpleName();
        }
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : invokeV.intValue;
    }

    public cn a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject)) == null) {
            this.f194a = jSONObject.getLong("cost");
            this.f60954c = jSONObject.getLong("size");
            this.f60953b = jSONObject.getLong(TimeDisplaySetting.TIME_DISPLAY_SETTING);
            this.a = jSONObject.getInt("wt");
            this.f195a = jSONObject.optString("expt");
            return this;
        }
        return (cn) invokeL.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public JSONObject m282a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("cost", this.f194a);
            jSONObject.put("size", this.f60954c);
            jSONObject.put(TimeDisplaySetting.TIME_DISPLAY_SETTING, this.f60953b);
            jSONObject.put("wt", this.a);
            jSONObject.put("expt", this.f195a);
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
