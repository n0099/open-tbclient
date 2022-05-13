package com.repackage;

import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.retrieve.RetrieveTaskManager;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.yz2;
import com.repackage.z53;
import java.util.HashMap;
import java.util.Map;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.apache.http.client.methods.HttpDelete;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class lh1 extends xo1 {
    public static /* synthetic */ Interceptable $ic;
    public static String f;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lh1 a;

        public a(lh1 lh1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lh1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lh1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                m03 f = m03.f(this.a.getContext(), R.string.obfuscated_res_0x7f0f1261);
                f.l(10);
                f.s(false);
                f.z();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends ResponseCallback<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ g22 b;
        public final /* synthetic */ lh1 c;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    m03.a();
                }
            }
        }

        /* renamed from: com.repackage.lh1$b$b  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC0458b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public RunnableC0458b(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    m03.f(bk2.c(), R.string.obfuscated_res_0x7f0f1262).G();
                }
            }
        }

        /* loaded from: classes6.dex */
        public class c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public c(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    m03.a();
                }
            }
        }

        public b(lh1 lh1Var, boolean z, g22 g22Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lh1Var, Boolean.valueOf(z), g22Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = lh1Var;
            this.a = z;
            this.b = g22Var;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                if (this.a) {
                    oe3.e0(new c(this));
                }
                lh1 lh1Var = this.c;
                g22 g22Var = this.b;
                lh1Var.N(g22Var, 1001, "operation fail, msg = " + exc.getMessage(), this.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(JSONObject jSONObject, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, jSONObject, i) == null) {
                if (this.a) {
                    oe3.e0(new a(this));
                }
                if (jSONObject == null) {
                    this.c.N(this.b, 1001, "server response fail", this.a);
                    return;
                }
                int optInt = jSONObject.optInt("errno", -1);
                if (optInt != 0) {
                    if (this.a) {
                        oe3.e0(new RunnableC0458b(this));
                    }
                    this.c.N(this.b, optInt, jSONObject.optString("errmsg"), false);
                    return;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (optJSONObject == null) {
                    this.c.N(this.b, 0, jSONObject.optString("errmsg"), this.a);
                } else {
                    this.c.O(this.b, optJSONObject, this.a);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public JSONObject parseResponse(Response response, int i) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, response, i)) == null) {
                if (response == null || response.body() == null) {
                    return null;
                }
                return ud3.d(response.body().string());
            }
            return (JSONObject) invokeLI.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        public c(lh1 lh1Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lh1Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                m03.g(bk2.c(), this.a).G();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lh1 a;

        public d(lh1 lh1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lh1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lh1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                m03.f(this.a.getContext(), R.string.obfuscated_res_0x7f0f0198).G();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lh1 a;

        public e(lh1 lh1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lh1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lh1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                m03.f(this.a.getContext(), R.string.obfuscated_res_0x7f0f0198).G();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements nf3<x53<z53.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSONArray a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ lh1 d;

        /* loaded from: classes6.dex */
        public class a implements g22<us1> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ f a;

            public a(f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = fVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.repackage.g22
            /* renamed from: b */
            public void a(us1 us1Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, us1Var) == null) {
                    f fVar = this.a;
                    fVar.d.d(fVar.c, us1Var);
                }
            }
        }

        /* loaded from: classes6.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ f a;

            public b(f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = fVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    m03.f(this.a.d.getContext(), R.string.obfuscated_res_0x7f0f1260).G();
                }
            }
        }

        public f(lh1 lh1Var, JSONArray jSONArray, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lh1Var, jSONArray, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = lh1Var;
            this.a = jSONArray;
            this.b = str;
            this.c = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.nf3
        /* renamed from: a */
        public void onCallback(x53<z53.e> x53Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, x53Var) == null) {
                if (s53.h(x53Var)) {
                    int type = t03.J().r().V().getType();
                    String v1 = t03.J().r().V().v1();
                    String N = t03.J().r().N();
                    HashMap hashMap = new HashMap();
                    hashMap.put("appKey", N);
                    hashMap.put("contentIds", this.a);
                    hashMap.put("category", this.b);
                    hashMap.put("pkg_type", Integer.valueOf(type));
                    hashMap.put("version_code", v1);
                    this.d.W("INSERT", hashMap, new a(this));
                    return;
                }
                this.d.d(this.c, new us1(x53Var.b(), s53.f(x53Var.b())));
                oe3.e0(new b(this));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements nf3<x53<z53.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSONArray a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ lh1 d;

        /* loaded from: classes6.dex */
        public class a implements g22<us1> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ g a;

            public a(g gVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = gVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.repackage.g22
            /* renamed from: b */
            public void a(us1 us1Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, us1Var) == null) {
                    g gVar = this.a;
                    gVar.d.d(gVar.c, us1Var);
                }
            }
        }

        /* loaded from: classes6.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ g a;

            public b(g gVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = gVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    m03.f(this.a.d.getContext(), R.string.obfuscated_res_0x7f0f1260).G();
                }
            }
        }

        public g(lh1 lh1Var, JSONArray jSONArray, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lh1Var, jSONArray, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = lh1Var;
            this.a = jSONArray;
            this.b = str;
            this.c = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.nf3
        /* renamed from: a */
        public void onCallback(x53<z53.e> x53Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, x53Var) == null) {
                if (s53.h(x53Var)) {
                    int type = t03.J().r().V().getType();
                    String v1 = t03.J().r().V().v1();
                    String N = t03.J().r().N();
                    HashMap hashMap = new HashMap();
                    hashMap.put("appKey", N);
                    hashMap.put("contentIds", this.a);
                    hashMap.put("category", this.b);
                    hashMap.put("pkg_type", Integer.valueOf(type));
                    hashMap.put("version_code", v1);
                    this.d.W(HttpDelete.METHOD_NAME, hashMap, new a(this));
                    return;
                }
                this.d.d(this.c, new us1(x53Var.b(), s53.f(x53Var.b())));
                oe3.e0(new b(this));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements g22<us1> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ lh1 b;

        public h(lh1 lh1Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lh1Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = lh1Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.g22
        /* renamed from: b */
        public void a(us1 us1Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, us1Var) == null) {
                this.b.d(this.a, us1Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements g22<us1> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ lh1 b;

        public i(lh1 lh1Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lh1Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = lh1Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.g22
        /* renamed from: b */
        public void a(us1 us1Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, us1Var) == null) {
                this.b.d(this.a, us1Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j implements gh1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ String b;
        public final /* synthetic */ lh1 c;

        public j(lh1 lh1Var, boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lh1Var, Boolean.valueOf(z), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = lh1Var;
            this.a = z;
            this.b = str;
        }

        @Override // com.repackage.gh1
        public void onResult(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i != 0) {
                    if (!this.a) {
                        n73.S(com.baidu.pass.biometrics.face.liveness.b.a.g0, 10, RetrieveTaskManager.KEY);
                    }
                    this.c.d(this.b, new us1(1001, "user is not login"));
                    return;
                }
                if (!this.a) {
                    n73.S("success", 10, RetrieveTaskManager.KEY);
                }
                this.c.S(this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k implements CallbackHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ lh1 b;

        public k(lh1 lh1Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lh1Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = lh1Var;
            this.a = str;
        }

        @Override // com.baidu.searchbox.unitedscheme.CallbackHandler
        public String getCurrentPageUrl() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return null;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.searchbox.unitedscheme.CallbackHandler
        public void handleSchemeDispatchCallback(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
                this.b.Q(str2, this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ lh1 e;

        /* loaded from: classes6.dex */
        public class a implements DialogInterface.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(l lVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {lVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                }
            }
        }

        /* loaded from: classes6.dex */
        public class b implements DialogInterface.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public b(l lVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {lVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                    t03.J().r().d0().E();
                }
            }
        }

        public l(lh1 lh1Var, String str, String str2, String str3, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lh1Var, str, str2, str3, str4};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = lh1Var;
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = str4;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                yz2.a aVar = new yz2.a(this.e.getContext());
                aVar.V(this.a);
                aVar.x(this.b);
                aVar.y();
                aVar.n(new cg3());
                aVar.m(false);
                aVar.P(this.c, new b(this));
                aVar.C(this.d, new a(this));
                aVar.X();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public lh1(@NonNull vo1 vo1Var) {
        super(vo1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vo1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((vo1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void I(JSONArray jSONArray, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, jSONArray, str, str2) == null) {
            t03.J().r().d0().g(getContext(), "scope_insert_bookshelf", new g(this, jSONArray, str, str2));
        }
    }

    public final void J(JSONArray jSONArray, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray, str, str2) == null) {
            t03.J().r().d0().g(getContext(), "scope_insert_bookshelf", new f(this, jSONArray, str, str2));
        }
    }

    public us1 K(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#deleteBookshelf", false);
            Pair<us1, JSONObject> s = s(str);
            us1 us1Var = (us1) s.first;
            JSONObject jSONObject = (JSONObject) s.second;
            if (!us1Var.isSuccess() || jSONObject == null) {
                return us1Var;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("contentIds");
            if (optJSONArray != null && optJSONArray.length() != 0) {
                String optString = jSONObject.optString("category");
                if (TextUtils.isEmpty(optString)) {
                    return new us1(201, "category is invalid");
                }
                String optString2 = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString2)) {
                    return new us1(202, "cb is invalid");
                }
                if (!SwanAppNetworkUtils.i(getContext())) {
                    oe3.e0(new e(this));
                    return new us1(1001, "network is not connected");
                } else if (R()) {
                    M();
                    return new us1(10003, s53.f(10003));
                } else {
                    I(optJSONArray, optString, optString2);
                    return us1.f();
                }
            }
            return new us1(201, "contentIds is invalid");
        }
        return (us1) invokeL.objValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final String L(String str) {
        InterceptResult invokeL;
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            switch (str.hashCode()) {
                case -2130463047:
                    if (str.equals("INSERT")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 77406376:
                    if (str.equals("QUERY")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1020968928:
                    if (str.equals("UPDATE_READ_TIME")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 2012838315:
                    if (str.equals(HttpDelete.METHOD_NAME)) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            if (c2 != 0) {
                if (c2 != 1) {
                    if (c2 != 2) {
                        if (c2 != 3) {
                            return null;
                        }
                        return bk2.o().H();
                    }
                    return bk2.o().y();
                }
                return bk2.o().h();
            }
            return bk2.o().w();
        }
        return (String) invokeL.objValue;
    }

    public final void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            oe3.e0(new l(this, getContext().getString(R.string.obfuscated_res_0x7f0f1264), getContext().getString(R.string.obfuscated_res_0x7f0f1263), getContext().getString(R.string.obfuscated_res_0x7f0f12fe), getContext().getString(R.string.obfuscated_res_0x7f0f129a)));
        }
    }

    public final void N(g22<us1> g22Var, int i2, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{g22Var, Integer.valueOf(i2), str, Boolean.valueOf(z)}) == null) {
            if (g22Var != null) {
                g22Var.a(new us1(i2, str));
            }
            if (z) {
                oe3.e0(new c(this, str));
            }
        }
    }

    public final void O(g22<us1> g22Var, JSONObject jSONObject, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048582, this, g22Var, jSONObject, z) == null) {
            if (g22Var != null && jSONObject != null) {
                g22Var.a(new us1(0, jSONObject));
            }
            if (z) {
                bk2.l0().b(getContext());
            }
        }
    }

    public us1 P(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            q("#insertBookshelf", false);
            Pair<us1, JSONObject> s = s(str);
            us1 us1Var = (us1) s.first;
            JSONObject jSONObject = (JSONObject) s.second;
            if (!us1Var.isSuccess() || jSONObject == null) {
                return us1Var;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("contentIds");
            if (optJSONArray != null && optJSONArray.length() != 0) {
                String optString = jSONObject.optString("category");
                f = optString;
                if (TextUtils.isEmpty(optString)) {
                    return new us1(201, "category is invalid");
                }
                String optString2 = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString2)) {
                    return new us1(202, "cb is invalid");
                }
                if (!SwanAppNetworkUtils.i(getContext())) {
                    oe3.e0(new d(this));
                    return new us1(1001, "network is not connected");
                } else if (R()) {
                    M();
                    return new us1(10003, s53.f(10003));
                } else {
                    J(optJSONArray, f, optString2);
                    return us1.f();
                }
            }
            return new us1(201, "contentIds is invalid");
        }
        return (us1) invokeL.objValue;
    }

    public final void Q(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2) == null) {
            int i2 = 1001;
            if (TextUtils.isEmpty(str)) {
                d(str2, new us1(1001, "navigateToBookshelf fail"));
            }
            try {
                i2 = new JSONObject(str).optInt("status", 1001);
            } catch (JSONException e2) {
                p("json put data fail", e2, false);
            }
            if (i2 == 0) {
                d(str2, new us1(i2, "navigateToBookshelf success"));
            } else {
                d(str2, new us1(i2, "navigateToBookshelf fail"));
            }
        }
    }

    public final boolean R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            u53 u53Var = ss2.g(true).get("scope_insert_bookshelf");
            if (u53Var != null) {
                return u53Var.j < 0 && !u53Var.d;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void S(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            bk2.l0().d(new k(this, str));
        }
    }

    public final void T(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            u03 r = t03.J().r();
            r.M().f(r.x(), null, new j(this, r.M().e(getContext()), str));
        }
    }

    public us1 U(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            q("#navigateToBookshelf", false);
            Pair<us1, JSONObject> s = s(str);
            us1 us1Var = (us1) s.first;
            JSONObject jSONObject = (JSONObject) s.second;
            if (!us1Var.isSuccess() || jSONObject == null) {
                return us1Var;
            }
            f = jSONObject.optString("category");
            String optString = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                return new us1(202, "cb is invalid");
            }
            if (!t03.J().r().M().e(getContext())) {
                n73.S("show", 10, RetrieveTaskManager.KEY);
                T(optString);
                return us1.f();
            }
            S(optString);
            return us1.f();
        }
        return (us1) invokeL.objValue;
    }

    public us1 V(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            q("#queryBookshelf", false);
            Pair<us1, JSONObject> s = s(str);
            us1 us1Var = (us1) s.first;
            JSONObject jSONObject = (JSONObject) s.second;
            if (!us1Var.isSuccess() || jSONObject == null) {
                return us1Var;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("contentIds");
            if (optJSONArray != null && optJSONArray.length() != 0) {
                String optString = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    return new us1(202, "cb is invalid");
                }
                if (!SwanAppNetworkUtils.i(getContext())) {
                    return new us1(1001, "network is not connected");
                }
                if (!t03.J().r().M().e(getContext())) {
                    return new us1(1001, "user is not login");
                }
                Object N = t03.J().r().N();
                int type = t03.J().r().V().getType();
                Object v1 = t03.J().r().V().v1();
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("appKey", N);
                hashMap.put("contentIds", optJSONArray);
                hashMap.put("pkg_type", Integer.valueOf(type));
                hashMap.put("version_code", v1);
                W("QUERY", hashMap, new h(this, optString));
                return us1.f();
            }
            return new us1(201, "contentIds is invalid");
        }
        return (us1) invokeL.objValue;
    }

    public final void W(String str, HashMap<String, Object> hashMap, g22<us1> g22Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048590, this, str, hashMap, g22Var) == null) {
            boolean equals = TextUtils.equals(str, "INSERT");
            JSONObject jSONObject = new JSONObject();
            try {
                for (Map.Entry<String, Object> entry : hashMap.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
            } catch (Exception unused) {
            }
            RequestBody create = RequestBody.create(bs2.a, jSONObject.toString());
            String L = L(str);
            if (TextUtils.isEmpty(L)) {
                N(g22Var, 1001, "operation fail, msg = url is null", equals);
                return;
            }
            if (equals) {
                oe3.e0(new a(this));
            }
            v74 v74Var = new v74(L, create, new b(this, equals, g22Var));
            if (w74.g().c()) {
                v74Var.f = true;
            }
            v74Var.g = true;
            w74.g().e(v74Var);
        }
    }

    public us1 X(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
            q("#updateBookshelfReadTime", false);
            Pair<us1, JSONObject> s = s(str);
            us1 us1Var = (us1) s.first;
            JSONObject jSONObject = (JSONObject) s.second;
            if (!us1Var.isSuccess() || jSONObject == null) {
                return us1Var;
            }
            String optString = jSONObject.optString("contentId");
            if (TextUtils.isEmpty(optString)) {
                return new us1(201, "contentId is invalid");
            }
            String optString2 = jSONObject.optString("category");
            if (TextUtils.isEmpty(optString2)) {
                return new us1(201, "category is invalid");
            }
            String optString3 = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString3)) {
                return new us1(202, "cb is invalid");
            }
            if (!SwanAppNetworkUtils.i(getContext())) {
                return new us1(1001, "network is not connected");
            }
            if (!t03.J().r().M().e(getContext())) {
                return new us1(1001, "user is not login");
            }
            Object N = t03.J().r().N();
            int type = t03.J().r().V().getType();
            Object v1 = t03.J().r().V().v1();
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("appKey", N);
            hashMap.put("contentId", optString);
            hashMap.put("category", optString2);
            hashMap.put("pkg_type", Integer.valueOf(type));
            hashMap.put("version_code", v1);
            W("UPDATE_READ_TIME", hashMap, new i(this, optString3));
            return us1.f();
        }
        return (us1) invokeL.objValue;
    }

    @Override // com.repackage.xo1
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? "Bookshelf" : (String) invokeV.objValue;
    }

    @Override // com.repackage.xo1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? "SwanAppBookshelfApi" : (String) invokeV.objValue;
    }
}
