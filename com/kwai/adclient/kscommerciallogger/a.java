package com.kwai.adclient.kscommerciallogger;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.adclient.kscommerciallogger.model.c;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public com.kwai.adclient.kscommerciallogger.kwai.a a;
    public com.kwai.adclient.kscommerciallogger.kwai.b b;
    public JSONObject c;
    public boolean d;
    public boolean e;

    /* renamed from: com.kwai.adclient.kscommerciallogger.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static final class C0554a {
        public static /* synthetic */ Interceptable $ic;
        public static a a;
        public transient /* synthetic */ FieldHolder $fh;

        public static a a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
                if (a == null) {
                    a = new a((byte) 0);
                }
                return a;
            }
            return (a) invokeV.objValue;
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = false;
        this.e = false;
    }

    public /* synthetic */ a(byte b) {
        this();
    }

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? C0554a.a() : (a) invokeV.objValue;
    }

    private void a(@NonNull com.kwai.adclient.kscommerciallogger.kwai.a aVar, @NonNull com.kwai.adclient.kscommerciallogger.kwai.b bVar, @Nullable JSONObject jSONObject, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, this, new Object[]{aVar, bVar, jSONObject, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.a = aVar;
            this.b = bVar;
            this.c = jSONObject;
            this.d = z;
            this.e = true;
        }
    }

    private void b(@NonNull c cVar) {
        com.kwai.adclient.kscommerciallogger.kwai.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, cVar) == null) || (aVar = this.a) == null) {
            return;
        }
        String d = cVar.d();
        String str = cVar.b() == null ? "" : cVar.b().value;
        if (cVar.c() != null) {
            String str2 = cVar.c().value;
        }
        if (cVar.e() != null) {
            cVar.e().a();
        }
        cVar.h();
        b.a(cVar.f());
        b.a(cVar.g());
        aVar.a(d, str);
    }

    public final void a(@NonNull com.kwai.adclient.kscommerciallogger.kwai.a aVar, @NonNull com.kwai.adclient.kscommerciallogger.kwai.b bVar, @Nullable JSONObject jSONObject, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{aVar, bVar, jSONObject, Boolean.valueOf(z)}) == null) {
            a(aVar, bVar, null, z, true);
        }
    }

    public final void a(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            if (cVar == null) {
                this.a.b("KSCommercialLogger", "rl rtLog is null please check it");
                return;
            }
            b(cVar);
            com.kwai.adclient.kscommerciallogger.kwai.b bVar = this.b;
            if (bVar != null) {
                bVar.a(cVar.a(), cVar.toString());
            }
        }
    }

    public final JSONObject b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.c : (JSONObject) invokeV.objValue;
    }

    public final boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.d : invokeV.booleanValue;
    }

    public final boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.e : invokeV.booleanValue;
    }
}
