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
public class gg1 implements cg1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public no3 c;
    public dg1 d;
    public wn3 e;
    public List<bg1> f;
    public bg1 g;
    public bg1 h;
    public Map<String, String> i;
    public mo3 j;

    /* loaded from: classes6.dex */
    public class a implements mo3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gg1 a;

        public a(gg1 gg1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gg1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gg1Var;
        }

        @Override // com.repackage.mo3
        public void a(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
                if (z) {
                    this.a.d.b();
                    this.a.g.a(0);
                    for (bg1 bg1Var : this.a.f) {
                        bg1Var.a(0);
                        if (this.a.f.contains(bg1Var)) {
                            this.a.f.remove(bg1Var);
                        }
                    }
                    return;
                }
                this.a.g.a(1001);
                for (bg1 bg1Var2 : this.a.f) {
                    bg1Var2.a(1001);
                    if (this.a.f.contains(bg1Var2)) {
                        this.a.f.remove(bg1Var2);
                    }
                }
            }
        }

        @Override // com.repackage.mo3
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

        @Override // com.repackage.mo3
        public void c(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
                this.a.d.a(fg1.a(z));
            }
        }

        @Override // com.repackage.mo3
        public void onClick(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            }
        }

        @Override // com.repackage.mo3
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                this.a.d.c(fg1.b(str));
                po3.k(this.a.i, str);
            }
        }
    }

    public gg1(@NonNull JSONObject jSONObject, dg1 dg1Var, bg1 bg1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONObject, dg1Var, bg1Var};
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
            this.i = po3.a("video", "app", optString, this.a, false);
            this.e = new hg1();
            no3 no3Var = new no3(uk2.U().getActivity(), this.b, this.a, false, this.j, this.e);
            this.c = no3Var;
            no3Var.k0(this.i);
            this.f = new CopyOnWriteArrayList();
            b(jSONObject, bg1Var, dg1Var);
            return;
        }
        bg1Var.a(202);
    }

    @Override // com.repackage.cg1
    public synchronized void a(JSONObject jSONObject, bg1 bg1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, jSONObject, bg1Var) == null) {
            synchronized (this) {
                if (this.c != null) {
                    this.h = bg1Var;
                    this.c.l0();
                }
            }
        }
    }

    @Override // com.repackage.cg1
    public synchronized void b(JSONObject jSONObject, bg1 bg1Var, dg1 dg1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject, bg1Var, dg1Var) == null) {
            synchronized (this) {
                this.d = dg1Var;
                if (this.c != null) {
                    this.g = bg1Var;
                    if (bg1Var != null && !this.f.contains(bg1Var)) {
                        this.f.add(bg1Var);
                    }
                    this.c.c0();
                }
            }
        }
    }
}
