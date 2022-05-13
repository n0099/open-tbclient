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
public class th1 implements ph1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public aq3 c;
    public qh1 d;
    public jp3 e;
    public List<oh1> f;
    public oh1 g;
    public oh1 h;
    public Map<String, String> i;
    public zp3 j;

    /* loaded from: classes7.dex */
    public class a implements zp3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ th1 a;

        public a(th1 th1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {th1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = th1Var;
        }

        @Override // com.repackage.zp3
        public void a(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
                if (z) {
                    this.a.d.b();
                    this.a.g.a(0);
                    for (oh1 oh1Var : this.a.f) {
                        oh1Var.a(0);
                        if (this.a.f.contains(oh1Var)) {
                            this.a.f.remove(oh1Var);
                        }
                    }
                    return;
                }
                this.a.g.a(1001);
                for (oh1 oh1Var2 : this.a.f) {
                    oh1Var2.a(1001);
                    if (this.a.f.contains(oh1Var2)) {
                        this.a.f.remove(oh1Var2);
                    }
                }
            }
        }

        @Override // com.repackage.zp3
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

        @Override // com.repackage.zp3
        public void c(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
                this.a.d.a(sh1.a(z));
            }
        }

        @Override // com.repackage.zp3
        public void onClick(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            }
        }

        @Override // com.repackage.zp3
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                this.a.d.c(sh1.b(str));
                cq3.k(this.a.i, str);
            }
        }
    }

    public th1(@NonNull JSONObject jSONObject, qh1 qh1Var, oh1 oh1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONObject, qh1Var, oh1Var};
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
            this.i = cq3.a("video", "app", optString, this.a, false);
            this.e = new uh1();
            aq3 aq3Var = new aq3(hm2.U().getActivity(), this.b, this.a, false, this.j, this.e);
            this.c = aq3Var;
            aq3Var.k0(this.i);
            this.f = new CopyOnWriteArrayList();
            b(jSONObject, oh1Var, qh1Var);
            return;
        }
        oh1Var.a(202);
    }

    @Override // com.repackage.ph1
    public synchronized void a(JSONObject jSONObject, oh1 oh1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, jSONObject, oh1Var) == null) {
            synchronized (this) {
                if (this.c != null) {
                    this.h = oh1Var;
                    this.c.l0();
                }
            }
        }
    }

    @Override // com.repackage.ph1
    public synchronized void b(JSONObject jSONObject, oh1 oh1Var, qh1 qh1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject, oh1Var, qh1Var) == null) {
            synchronized (this) {
                this.d = qh1Var;
                if (this.c != null) {
                    this.g = oh1Var;
                    if (oh1Var != null && !this.f.contains(oh1Var)) {
                        this.f.add(oh1Var);
                    }
                    this.c.c0();
                }
            }
        }
    }
}
