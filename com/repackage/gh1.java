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
public class gh1 implements ch1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public np3 c;
    public dh1 d;
    public wo3 e;
    public List<bh1> f;
    public bh1 g;
    public bh1 h;
    public Map<String, String> i;
    public mp3 j;

    /* loaded from: classes6.dex */
    public class a implements mp3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gh1 a;

        public a(gh1 gh1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gh1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gh1Var;
        }

        @Override // com.repackage.mp3
        public void a(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
                if (z) {
                    this.a.d.b();
                    this.a.g.a(0);
                    for (bh1 bh1Var : this.a.f) {
                        bh1Var.a(0);
                        if (this.a.f.contains(bh1Var)) {
                            this.a.f.remove(bh1Var);
                        }
                    }
                    return;
                }
                this.a.g.a(1001);
                for (bh1 bh1Var2 : this.a.f) {
                    bh1Var2.a(1001);
                    if (this.a.f.contains(bh1Var2)) {
                        this.a.f.remove(bh1Var2);
                    }
                }
            }
        }

        @Override // com.repackage.mp3
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

        @Override // com.repackage.mp3
        public void c(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
                this.a.d.a(fh1.a(z));
            }
        }

        @Override // com.repackage.mp3
        public void onClick(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            }
        }

        @Override // com.repackage.mp3
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                this.a.d.c(fh1.b(str));
                pp3.k(this.a.i, str);
            }
        }
    }

    public gh1(@NonNull JSONObject jSONObject, dh1 dh1Var, bh1 bh1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONObject, dh1Var, bh1Var};
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
            this.i = pp3.a("video", "app", optString, this.a, false);
            this.e = new hh1();
            np3 np3Var = new np3(ul2.U().getActivity(), this.b, this.a, false, this.j, this.e);
            this.c = np3Var;
            np3Var.k0(this.i);
            this.f = new CopyOnWriteArrayList();
            b(jSONObject, bh1Var, dh1Var);
            return;
        }
        bh1Var.a(202);
    }

    @Override // com.repackage.ch1
    public synchronized void a(JSONObject jSONObject, bh1 bh1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, jSONObject, bh1Var) == null) {
            synchronized (this) {
                if (this.c != null) {
                    this.h = bh1Var;
                    this.c.l0();
                }
            }
        }
    }

    @Override // com.repackage.ch1
    public synchronized void b(JSONObject jSONObject, bh1 bh1Var, dh1 dh1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject, bh1Var, dh1Var) == null) {
            synchronized (this) {
                this.d = dh1Var;
                if (this.c != null) {
                    this.g = bh1Var;
                    if (bh1Var != null && !this.f.contains(bh1Var)) {
                        this.f.add(bh1Var);
                    }
                    this.c.c0();
                }
            }
        }
    }
}
