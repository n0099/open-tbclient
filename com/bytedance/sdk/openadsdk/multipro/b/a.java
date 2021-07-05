package com.bytedance.sdk.openadsdk.multipro.b;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f31491a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f31492b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f31493c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f31494d;

    /* renamed from: e  reason: collision with root package name */
    public long f31495e;

    /* renamed from: f  reason: collision with root package name */
    public long f31496f;

    /* renamed from: g  reason: collision with root package name */
    public long f31497g;

    /* renamed from: com.bytedance.sdk.openadsdk.multipro.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0355a {
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
            this.f31494d = z;
            return this;
        }
        return (a) invokeZ.objValue;
    }

    public a b(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
            this.f31491a = z;
            return this;
        }
        return (a) invokeZ.objValue;
    }

    public a c(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) {
            this.f31492b = z;
            return this;
        }
        return (a) invokeZ.objValue;
    }

    public a d(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048583, this, z)) == null) {
            this.f31493c = z;
            return this;
        }
        return (a) invokeZ.objValue;
    }

    public a a(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) {
            this.f31495e = j;
            return this;
        }
        return (a) invokeJ.objValue;
    }

    public a b(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048579, this, j)) == null) {
            this.f31496f = j;
            return this;
        }
        return (a) invokeJ.objValue;
    }

    public a c(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j)) == null) {
            this.f31497g = j;
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
                jSONObject.put("isCompleted", this.f31491a);
                jSONObject.put("isFromVideoDetailPage", this.f31492b);
                jSONObject.put("isFromDetailPage", this.f31493c);
                jSONObject.put("duration", this.f31495e);
                jSONObject.put("totalPlayDuration", this.f31496f);
                jSONObject.put("currentPlayPosition", this.f31497g);
                jSONObject.put("isAutoPlay", this.f31494d);
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
