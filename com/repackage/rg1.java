package com.repackage;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class rg1 implements ng1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public yo3 c;
    public og1 d;
    public ho3 e;
    public List<mg1> f;
    public mg1 g;
    public mg1 h;
    public Map<String, String> i;
    public xo3 j;

    /* loaded from: classes7.dex */
    public class a implements xo3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rg1 a;

        public a(rg1 rg1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rg1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rg1Var;
        }

        @Override // com.repackage.xo3
        public void a(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
                if (z) {
                    this.a.d.b();
                    this.a.g.a(0);
                    for (mg1 mg1Var : this.a.f) {
                        mg1Var.a(0);
                        if (this.a.f.contains(mg1Var)) {
                            this.a.f.remove(mg1Var);
                        }
                    }
                    return;
                }
                this.a.g.a(1001);
                for (mg1 mg1Var2 : this.a.f) {
                    mg1Var2.a(1001);
                    if (this.a.f.contains(mg1Var2)) {
                        this.a.f.remove(mg1Var2);
                    }
                }
            }
        }

        @Override // com.repackage.xo3
        public void b(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, str) == null) {
                if (z) {
                    this.a.h.a(0);
                } else {
                    this.a.h.a(1001);
                }
            }
        }

        @Override // com.repackage.xo3
        public void c(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
                this.a.d.a(qg1.a(z));
            }
        }

        @Override // com.repackage.xo3
        public void onClick(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            }
        }

        @Override // com.repackage.xo3
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                this.a.d.c(qg1.b(str));
                ap3.k(this.a.i, str);
            }
        }
    }

    public rg1(@NonNull JSONObject jSONObject, og1 og1Var, mg1 mg1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONObject, og1Var, mg1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = "";
        this.i = new TreeMap();
        this.j = new a(this);
        if (jSONObject != null && !TextUtils.isEmpty(jSONObject.optString("adUnitId")) && !TextUtils.isEmpty(jSONObject.optString("appSid"))) {
            this.a = jSONObject.optString("adUnitId");
            String optString = jSONObject.optString("appSid");
            this.b = optString;
            this.i = ap3.a("video", "app", optString, this.a, false);
            this.e = new sg1();
            yo3 yo3Var = new yo3(fl2.U().getActivity(), this.b, this.a, false, this.j, this.e);
            this.c = yo3Var;
            yo3Var.k0(this.i);
            this.f = new CopyOnWriteArrayList();
            b(jSONObject, mg1Var, og1Var);
            return;
        }
        mg1Var.a(202);
    }

    @Override // com.repackage.ng1
    public synchronized void a(JSONObject jSONObject, mg1 mg1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, jSONObject, mg1Var) == null) {
            synchronized (this) {
                if (this.c != null) {
                    this.h = mg1Var;
                    this.c.l0();
                }
            }
        }
    }

    @Override // com.repackage.ng1
    public synchronized void b(JSONObject jSONObject, mg1 mg1Var, og1 og1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject, mg1Var, og1Var) == null) {
            synchronized (this) {
                this.d = og1Var;
                if (this.c != null) {
                    this.g = mg1Var;
                    if (mg1Var != null && !this.f.contains(mg1Var)) {
                        this.f.add(mg1Var);
                    }
                    this.c.c0();
                }
            }
        }
    }
}
