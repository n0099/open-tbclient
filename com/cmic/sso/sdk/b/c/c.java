package com.cmic.sso.sdk.b.c;

import android.net.Network;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.cmic.sso.sdk.auth.AuthnHelper;
import com.cmic.sso.sdk.b.b.g;
import com.cmic.sso.sdk.d.e;
import com.heytap.mcssdk.mode.CommandMessage;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.protocol.HTTP;
/* loaded from: classes5.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f32803a;

    /* renamed from: b  reason: collision with root package name */
    public final String f32804b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, String> f32805c;

    /* renamed from: d  reason: collision with root package name */
    public final String f32806d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f32807e;

    /* renamed from: f  reason: collision with root package name */
    public final String f32808f;

    /* renamed from: g  reason: collision with root package name */
    public Network f32809g;

    /* renamed from: h  reason: collision with root package name */
    public long f32810h;

    /* renamed from: i  reason: collision with root package name */
    public final String f32811i;
    public int j;
    public final g k;

    public c(String str, Map<String, String> map, g gVar, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, map, gVar, str2, str3};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f32807e = false;
        this.f32804b = str;
        this.k = gVar;
        this.f32805c = map == null ? new HashMap<>() : map;
        this.f32803a = gVar == null ? "" : gVar.b().toString();
        this.f32806d = str2;
        this.f32808f = str3;
        this.f32811i = gVar != null ? gVar.a() : "";
        l();
    }

    private void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            this.f32805c.put(CommandMessage.SDK_VERSION, AuthnHelper.SDK_VERSION);
            this.f32805c.put("Content-Type", "application/json");
            this.f32805c.put("CMCC-EncryptType", "STD");
            this.f32805c.put("traceId", this.f32808f);
            this.f32805c.put("appid", this.f32811i);
            this.f32805c.put(HTTP.CONN_DIRECTIVE, IntentConfig.CLOSE);
        }
    }

    public void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) {
            this.f32805c.put(str, str2);
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f32807e : invokeV.booleanValue;
    }

    public Map<String, String> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f32805c : (Map) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f32803a : (String) invokeV.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f32806d : (String) invokeV.objValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f32808f : (String) invokeV.objValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? !e.a(this.f32808f) || this.f32804b.contains("logReport") || this.f32804b.contains("uniConfig") : invokeV.booleanValue;
    }

    public Network h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f32809g : (Network) invokeV.objValue;
    }

    public long i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f32810h : invokeV.longValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            int i2 = this.j;
            this.j = i2 + 1;
            return i2 < 2;
        }
        return invokeV.booleanValue;
    }

    public g k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.k : (g) invokeV.objValue;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f32804b : (String) invokeV.objValue;
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.f32807e = z;
        }
    }

    public void a(Network network) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, network) == null) {
            this.f32809g = network;
        }
    }

    public void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
            this.f32810h = j;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public c(String str, g gVar, String str2, String str3) {
        this(str, null, gVar, str2, str3);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, gVar, str2, str3};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((String) objArr2[0], (Map) objArr2[1], (g) objArr2[2], (String) objArr2[3], (String) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }
}
