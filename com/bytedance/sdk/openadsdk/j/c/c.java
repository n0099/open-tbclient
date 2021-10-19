package com.bytedance.sdk.openadsdk.j.c;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.d.g;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.e.i;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class c implements com.bytedance.sdk.openadsdk.j.c.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final b f68302a;

    /* renamed from: b  reason: collision with root package name */
    public final List<a> f68303b;

    public c() {
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
        this.f68303b = Collections.synchronizedList(new LinkedList());
        this.f68302a = b.a();
    }

    public static com.bytedance.sdk.openadsdk.j.c.a c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? e.c() : (com.bytedance.sdk.openadsdk.j.c.a) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.j.c.a
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.j.c.a
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            com.bytedance.sdk.component.d.e.a(new g(this, "init") { // from class: com.bytedance.sdk.openadsdk.j.c.c.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ c f68304a;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r8);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r8};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            super((String) newInitContext.callArgs[0]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f68304a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        List<a> d2 = this.f68304a.f68302a.d();
                        if (d2 != null) {
                            this.f68304a.f68303b.addAll(d2);
                        }
                        this.f68304a.f68302a.c();
                    }
                }
            }, 5);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.j.c.a
    public void a(com.bytedance.sdk.openadsdk.j.a.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            a(aVar, false);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.j.c.a
    public void a(com.bytedance.sdk.openadsdk.j.a.a aVar, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, aVar, z) == null) && aVar != null && com.bytedance.sdk.openadsdk.core.j.g.a()) {
            a aVar2 = new a(UUID.randomUUID().toString(), aVar.a());
            if (z) {
                o.e().a(aVar2);
            } else {
                o.d().a(aVar2);
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class a implements i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final String f68305a;

        /* renamed from: b  reason: collision with root package name */
        public final JSONObject f68306b;

        public a(String str, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f68305a = str;
            this.f68306b = jSONObject;
        }

        public static a a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    String optString = jSONObject.optString("localId", null);
                    JSONObject optJSONObject = jSONObject.optJSONObject("event");
                    if (!TextUtils.isEmpty(optString) && optJSONObject != null) {
                        return new a(optString, optJSONObject);
                    }
                } catch (Throwable unused) {
                }
                return null;
            }
            return (a) invokeL.objValue;
        }

        @Override // com.bytedance.sdk.openadsdk.e.i
        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f68305a : (String) invokeV.objValue;
        }

        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (TextUtils.isEmpty(this.f68305a) || this.f68306b == null) {
                    return null;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("localId", this.f68305a);
                    jSONObject.put("event", this.f68306b);
                } catch (Throwable unused) {
                }
                return jSONObject.toString();
            }
            return (String) invokeV.objValue;
        }
    }
}
