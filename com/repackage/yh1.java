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
public class yh1 implements uh1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public fq3 c;
    public vh1 d;
    public op3 e;
    public List<th1> f;
    public th1 g;
    public th1 h;
    public Map<String, String> i;
    public eq3 j;

    /* loaded from: classes7.dex */
    public class a implements eq3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yh1 a;

        public a(yh1 yh1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yh1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yh1Var;
        }

        @Override // com.repackage.eq3
        public void a(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
                if (z) {
                    this.a.d.b();
                    this.a.g.a(0);
                    for (th1 th1Var : this.a.f) {
                        th1Var.a(0);
                        if (this.a.f.contains(th1Var)) {
                            this.a.f.remove(th1Var);
                        }
                    }
                    return;
                }
                this.a.g.a(1001);
                for (th1 th1Var2 : this.a.f) {
                    th1Var2.a(1001);
                    if (this.a.f.contains(th1Var2)) {
                        this.a.f.remove(th1Var2);
                    }
                }
            }
        }

        @Override // com.repackage.eq3
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

        @Override // com.repackage.eq3
        public void c(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
                this.a.d.a(xh1.a(z));
            }
        }

        @Override // com.repackage.eq3
        public void onClick(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            }
        }

        @Override // com.repackage.eq3
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                this.a.d.c(xh1.b(str));
                hq3.k(this.a.i, str);
            }
        }
    }

    public yh1(@NonNull JSONObject jSONObject, vh1 vh1Var, th1 th1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONObject, vh1Var, th1Var};
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
            this.i = hq3.a("video", "app", optString, this.a, false);
            this.e = new zh1();
            fq3 fq3Var = new fq3(mm2.U().getActivity(), this.b, this.a, false, this.j, this.e);
            this.c = fq3Var;
            fq3Var.k0(this.i);
            this.f = new CopyOnWriteArrayList();
            b(jSONObject, th1Var, vh1Var);
            return;
        }
        th1Var.a(202);
    }

    @Override // com.repackage.uh1
    public synchronized void a(JSONObject jSONObject, th1 th1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, jSONObject, th1Var) == null) {
            synchronized (this) {
                if (this.c != null) {
                    this.h = th1Var;
                    this.c.l0();
                }
            }
        }
    }

    @Override // com.repackage.uh1
    public synchronized void b(JSONObject jSONObject, th1 th1Var, vh1 vh1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject, th1Var, vh1Var) == null) {
            synchronized (this) {
                this.d = vh1Var;
                if (this.c != null) {
                    this.g = th1Var;
                    if (th1Var != null && !this.f.contains(th1Var)) {
                        this.f.add(th1Var);
                    }
                    this.c.c0();
                }
            }
        }
    }
}
