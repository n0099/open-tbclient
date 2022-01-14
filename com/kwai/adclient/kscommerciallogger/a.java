package com.kwai.adclient.kscommerciallogger;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public com.kwai.adclient.kscommerciallogger.kwai.a a;

    /* renamed from: b  reason: collision with root package name */
    public com.kwai.adclient.kscommerciallogger.kwai.b f58125b;

    /* renamed from: c  reason: collision with root package name */
    public JSONObject f58126c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f58127d;

    /* renamed from: com.kwai.adclient.kscommerciallogger.a$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: com.kwai.adclient.kscommerciallogger.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C2152a {
        public static /* synthetic */ Interceptable $ic;
        public static a a;
        public transient /* synthetic */ FieldHolder $fh;

        public static a a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
                if (a == null) {
                    a = new a(null);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f58127d = false;
    }

    public /* synthetic */ a(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? C2152a.a() : (a) invokeV.objValue;
    }

    private void b(@NonNull com.kwai.adclient.kscommerciallogger.model.a aVar) {
        com.kwai.adclient.kscommerciallogger.kwai.a aVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, this, aVar) == null) || (aVar2 = this.a) == null) {
            return;
        }
        String d2 = aVar.d();
        String str = aVar.b() == null ? "" : aVar.b().value;
        Object[] objArr = new Object[5];
        objArr[0] = aVar.c() == null ? "" : aVar.c().value;
        objArr[1] = aVar.e() != null ? aVar.e().a() : "";
        objArr[2] = aVar.h();
        objArr[3] = b.a(aVar.f());
        objArr[4] = b.a(aVar.g());
        aVar2.a(d2, str, objArr);
    }

    public void a(@NonNull com.kwai.adclient.kscommerciallogger.kwai.a aVar, @NonNull com.kwai.adclient.kscommerciallogger.kwai.b bVar, @Nullable JSONObject jSONObject, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{aVar, bVar, jSONObject, Boolean.valueOf(z)}) == null) {
            this.a = aVar;
            this.f58125b = bVar;
            this.f58126c = jSONObject;
            this.f58127d = z;
        }
    }

    public void a(com.kwai.adclient.kscommerciallogger.model.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            b(aVar);
            com.kwai.adclient.kscommerciallogger.kwai.b bVar = this.f58125b;
            if (bVar != null) {
                bVar.a(aVar.a(), aVar.toString());
            }
        }
    }

    public JSONObject b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f58126c : (JSONObject) invokeV.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f58127d : invokeV.booleanValue;
    }
}
