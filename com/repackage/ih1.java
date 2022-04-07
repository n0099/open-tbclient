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
public class ih1 implements eh1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public pp3 c;
    public fh1 d;
    public yo3 e;
    public List<dh1> f;
    public dh1 g;
    public dh1 h;
    public Map<String, String> i;
    public op3 j;

    /* loaded from: classes6.dex */
    public class a implements op3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ih1 a;

        public a(ih1 ih1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ih1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ih1Var;
        }

        @Override // com.repackage.op3
        public void a(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
                if (z) {
                    this.a.d.b();
                    this.a.g.a(0);
                    for (dh1 dh1Var : this.a.f) {
                        dh1Var.a(0);
                        if (this.a.f.contains(dh1Var)) {
                            this.a.f.remove(dh1Var);
                        }
                    }
                    return;
                }
                this.a.g.a(1001);
                for (dh1 dh1Var2 : this.a.f) {
                    dh1Var2.a(1001);
                    if (this.a.f.contains(dh1Var2)) {
                        this.a.f.remove(dh1Var2);
                    }
                }
            }
        }

        @Override // com.repackage.op3
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

        @Override // com.repackage.op3
        public void c(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
                this.a.d.a(hh1.a(z));
            }
        }

        @Override // com.repackage.op3
        public void onClick(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            }
        }

        @Override // com.repackage.op3
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                this.a.d.c(hh1.b(str));
                rp3.k(this.a.i, str);
            }
        }
    }

    public ih1(@NonNull JSONObject jSONObject, fh1 fh1Var, dh1 dh1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONObject, fh1Var, dh1Var};
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
            this.i = rp3.a("video", "app", optString, this.a, false);
            this.e = new jh1();
            pp3 pp3Var = new pp3(wl2.U().getActivity(), this.b, this.a, false, this.j, this.e);
            this.c = pp3Var;
            pp3Var.k0(this.i);
            this.f = new CopyOnWriteArrayList();
            b(jSONObject, dh1Var, fh1Var);
            return;
        }
        dh1Var.a(202);
    }

    @Override // com.repackage.eh1
    public synchronized void a(JSONObject jSONObject, dh1 dh1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, jSONObject, dh1Var) == null) {
            synchronized (this) {
                if (this.c != null) {
                    this.h = dh1Var;
                    this.c.l0();
                }
            }
        }
    }

    @Override // com.repackage.eh1
    public synchronized void b(JSONObject jSONObject, dh1 dh1Var, fh1 fh1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject, dh1Var, fh1Var) == null) {
            synchronized (this) {
                this.d = fh1Var;
                if (this.c != null) {
                    this.g = dh1Var;
                    if (dh1Var != null && !this.f.contains(dh1Var)) {
                        this.f.add(dh1Var);
                    }
                    this.c.c0();
                }
            }
        }
    }
}
