package com.kuaishou.weapon.un;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class o0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o0 a;

        public a(o0 o0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            d1 d1Var;
            JSONObject a;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    d dVar = new d(this.a.a);
                    if (dVar.a(d.b0, 1) != 1 || (a = (d1Var = new d1(q0.f38951d, q0.f38953f)).a(this.a.a)) == null) {
                        return;
                    }
                    JSONObject jSONObject = new JSONObject();
                    boolean b2 = dVar.b(d.Z0);
                    boolean b3 = dVar.b(d.a1);
                    jSONObject.put("11006", b2 ? 1 : 0);
                    jSONObject.put("11028", d1Var.k());
                    jSONObject.put("11029", b3 ? 1 : 0);
                    a.put("module_section", jSONObject);
                    g1.a(a.toString(), this.a.a);
                } catch (Throwable th) {
                    l1.a(th);
                }
            }
        }
    }

    public o0(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                t1.a().a(new a(this));
            } catch (Exception unused) {
            }
        }
    }
}
