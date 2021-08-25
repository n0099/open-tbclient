package com.bytedance.sdk.openadsdk.multipro.b;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f67933a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f67934b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f67935c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f67936d;

    /* renamed from: e  reason: collision with root package name */
    public long f67937e;

    /* renamed from: f  reason: collision with root package name */
    public long f67938f;

    /* renamed from: g  reason: collision with root package name */
    public long f67939g;

    /* renamed from: com.bytedance.sdk.openadsdk.multipro.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC1921a {
        a e();

        boolean g();
    }

    public a() {
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

    public a a(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
            this.f67936d = z;
            return this;
        }
        return (a) invokeZ.objValue;
    }

    public a b(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
            this.f67933a = z;
            return this;
        }
        return (a) invokeZ.objValue;
    }

    public a c(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) {
            this.f67934b = z;
            return this;
        }
        return (a) invokeZ.objValue;
    }

    public a d(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048583, this, z)) == null) {
            this.f67935c = z;
            return this;
        }
        return (a) invokeZ.objValue;
    }

    public a a(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j2)) == null) {
            this.f67937e = j2;
            return this;
        }
        return (a) invokeJ.objValue;
    }

    public a b(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048579, this, j2)) == null) {
            this.f67938f = j2;
            return this;
        }
        return (a) invokeJ.objValue;
    }

    public a c(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j2)) == null) {
            this.f67939g = j2;
            return this;
        }
        return (a) invokeJ.objValue;
    }

    public JSONObject a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("isCompleted", this.f67933a);
                jSONObject.put("isFromVideoDetailPage", this.f67934b);
                jSONObject.put("isFromDetailPage", this.f67935c);
                jSONObject.put("duration", this.f67937e);
                jSONObject.put("totalPlayDuration", this.f67938f);
                jSONObject.put("currentPlayPosition", this.f67939g);
                jSONObject.put("isAutoPlay", this.f67936d);
            } catch (Exception unused) {
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public static a a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            a aVar = new a();
            aVar.b(jSONObject.optBoolean("isCompleted"));
            aVar.c(jSONObject.optBoolean("isFromVideoDetailPage"));
            aVar.d(jSONObject.optBoolean("isFromDetailPage"));
            aVar.a(jSONObject.optLong("duration"));
            aVar.b(jSONObject.optLong("totalPlayDuration"));
            aVar.c(jSONObject.optLong("currentPlayPosition"));
            aVar.a(jSONObject.optBoolean("isAutoPlay"));
            return aVar;
        }
        return (a) invokeL.objValue;
    }
}
