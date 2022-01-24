package com.kuaishou.weapon.un;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class n0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n0 a;

        public a(n0 n0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONObject a;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (new d(this.a.a).a(d.c0, 1) != 1 || (a = new d1(q0.f55258e, q0.f55259f).a(this.a.a)) == null) {
                        return;
                    }
                    JSONObject jSONObject = new JSONObject();
                    List<p> b2 = x.a(this.a.a).b();
                    jSONObject.put("11030", b2.size());
                    jSONObject.put("11031", b2.size() > 0 ? b2.get(0).f55240d : "");
                    jSONObject.put("11032", b2.size() > 1 ? b2.get(1).f55240d : "");
                    a.put("module_section", jSONObject);
                    g1.a(a.toString(), this.a.a);
                } catch (Throwable th) {
                    l1.a(th);
                }
            }
        }
    }

    public n0(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
