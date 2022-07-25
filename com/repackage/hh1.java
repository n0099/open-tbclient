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
/* loaded from: classes6.dex */
public class hh1 implements dh1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public op3 c;
    public eh1 d;
    public xo3 e;
    public List<ch1> f;
    public ch1 g;
    public ch1 h;
    public Map<String, String> i;
    public np3 j;

    /* loaded from: classes6.dex */
    public class a implements np3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hh1 a;

        public a(hh1 hh1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hh1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hh1Var;
        }

        @Override // com.repackage.np3
        public void a(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
                if (z) {
                    this.a.d.b();
                    this.a.g.a(0);
                    for (ch1 ch1Var : this.a.f) {
                        ch1Var.a(0);
                        if (this.a.f.contains(ch1Var)) {
                            this.a.f.remove(ch1Var);
                        }
                    }
                    return;
                }
                this.a.g.a(1001);
                for (ch1 ch1Var2 : this.a.f) {
                    ch1Var2.a(1001);
                    if (this.a.f.contains(ch1Var2)) {
                        this.a.f.remove(ch1Var2);
                    }
                }
            }
        }

        @Override // com.repackage.np3
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

        @Override // com.repackage.np3
        public void c(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
                this.a.d.a(gh1.a(z));
            }
        }

        @Override // com.repackage.np3
        public void onClick(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            }
        }

        @Override // com.repackage.np3
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                this.a.d.c(gh1.b(str));
                qp3.k(this.a.i, str);
            }
        }
    }

    public hh1(@NonNull JSONObject jSONObject, eh1 eh1Var, ch1 ch1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONObject, eh1Var, ch1Var};
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
            this.i = qp3.a("video", "app", optString, this.a, false);
            this.e = new ih1();
            op3 op3Var = new op3(vl2.U().getActivity(), this.b, this.a, false, this.j, this.e);
            this.c = op3Var;
            op3Var.k0(this.i);
            this.f = new CopyOnWriteArrayList();
            b(jSONObject, ch1Var, eh1Var);
            return;
        }
        ch1Var.a(202);
    }

    @Override // com.repackage.dh1
    public synchronized void a(JSONObject jSONObject, ch1 ch1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, jSONObject, ch1Var) == null) {
            synchronized (this) {
                if (this.c != null) {
                    this.h = ch1Var;
                    this.c.l0();
                }
            }
        }
    }

    @Override // com.repackage.dh1
    public synchronized void b(JSONObject jSONObject, ch1 ch1Var, eh1 eh1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject, ch1Var, eh1Var) == null) {
            synchronized (this) {
                this.d = eh1Var;
                if (this.c != null) {
                    this.g = ch1Var;
                    if (ch1Var != null && !this.f.contains(ch1Var)) {
                        this.f.add(ch1Var);
                    }
                    this.c.c0();
                }
            }
        }
    }
}
