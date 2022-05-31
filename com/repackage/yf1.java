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
import com.repackage.ly2;
import com.repackage.m43;
import java.util.HashMap;
import java.util.Map;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.apache.http.client.methods.HttpDelete;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class yf1 extends kn1 {
    public static /* synthetic */ Interceptable $ic;
    public static String f;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yf1 a;

        public a(yf1 yf1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yf1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yf1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                zy2 f = zy2.f(this.a.getContext(), R.string.obfuscated_res_0x7f0f1273);
                f.l(10);
                f.s(false);
                f.z();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends ResponseCallback<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ t02 b;
        public final /* synthetic */ yf1 c;

        /* loaded from: classes7.dex */
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
                    zy2.a();
                }
            }
        }

        /* renamed from: com.repackage.yf1$b$b  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC0569b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public RunnableC0569b(b bVar) {
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
                    zy2.f(oi2.c(), R.string.obfuscated_res_0x7f0f1274).G();
                }
            }
        }

        /* loaded from: classes7.dex */
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
                    zy2.a();
                }
            }
        }

        public b(yf1 yf1Var, boolean z, t02 t02Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yf1Var, Boolean.valueOf(z), t02Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = yf1Var;
            this.a = z;
            this.b = t02Var;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                if (this.a) {
                    bd3.e0(new c(this));
                }
                yf1 yf1Var = this.c;
                t02 t02Var = this.b;
                yf1Var.N(t02Var, 1001, "operation fail, msg = " + exc.getMessage(), this.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(JSONObject jSONObject, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, jSONObject, i) == null) {
                if (this.a) {
                    bd3.e0(new a(this));
                }
                if (jSONObject == null) {
                    this.c.N(this.b, 1001, "server response fail", this.a);
                    return;
                }
                int optInt = jSONObject.optInt("errno", -1);
                if (optInt != 0) {
                    if (this.a) {
                        bd3.e0(new RunnableC0569b(this));
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
                return hc3.d(response.body().string());
            }
            return (JSONObject) invokeLI.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        public c(yf1 yf1Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yf1Var, str};
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
                zy2.g(oi2.c(), this.a).G();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yf1 a;

        public d(yf1 yf1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yf1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yf1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                zy2.f(this.a.getContext(), R.string.obfuscated_res_0x7f0f0199).G();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yf1 a;

        public e(yf1 yf1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yf1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yf1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                zy2.f(this.a.getContext(), R.string.obfuscated_res_0x7f0f0199).G();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements ae3<k43<m43.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSONArray a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ yf1 d;

        /* loaded from: classes7.dex */
        public class a implements t02<hr1> {
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
            @Override // com.repackage.t02
            /* renamed from: b */
            public void a(hr1 hr1Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hr1Var) == null) {
                    f fVar = this.a;
                    fVar.d.d(fVar.c, hr1Var);
                }
            }
        }

        /* loaded from: classes7.dex */
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
                    zy2.f(this.a.d.getContext(), R.string.obfuscated_res_0x7f0f1272).G();
                }
            }
        }

        public f(yf1 yf1Var, JSONArray jSONArray, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yf1Var, jSONArray, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = yf1Var;
            this.a = jSONArray;
            this.b = str;
            this.c = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ae3
        /* renamed from: a */
        public void onCallback(k43<m43.e> k43Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, k43Var) == null) {
                if (f43.h(k43Var)) {
                    int type = gz2.J().r().V().getType();
                    String v1 = gz2.J().r().V().v1();
                    String N = gz2.J().r().N();
                    HashMap hashMap = new HashMap();
                    hashMap.put("appKey", N);
                    hashMap.put("contentIds", this.a);
                    hashMap.put("category", this.b);
                    hashMap.put("pkg_type", Integer.valueOf(type));
                    hashMap.put("version_code", v1);
                    this.d.W("INSERT", hashMap, new a(this));
                    return;
                }
                this.d.d(this.c, new hr1(k43Var.b(), f43.f(k43Var.b())));
                bd3.e0(new b(this));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements ae3<k43<m43.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSONArray a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ yf1 d;

        /* loaded from: classes7.dex */
        public class a implements t02<hr1> {
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
            @Override // com.repackage.t02
            /* renamed from: b */
            public void a(hr1 hr1Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hr1Var) == null) {
                    g gVar = this.a;
                    gVar.d.d(gVar.c, hr1Var);
                }
            }
        }

        /* loaded from: classes7.dex */
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
                    zy2.f(this.a.d.getContext(), R.string.obfuscated_res_0x7f0f1272).G();
                }
            }
        }

        public g(yf1 yf1Var, JSONArray jSONArray, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yf1Var, jSONArray, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = yf1Var;
            this.a = jSONArray;
            this.b = str;
            this.c = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ae3
        /* renamed from: a */
        public void onCallback(k43<m43.e> k43Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, k43Var) == null) {
                if (f43.h(k43Var)) {
                    int type = gz2.J().r().V().getType();
                    String v1 = gz2.J().r().V().v1();
                    String N = gz2.J().r().N();
                    HashMap hashMap = new HashMap();
                    hashMap.put("appKey", N);
                    hashMap.put("contentIds", this.a);
                    hashMap.put("category", this.b);
                    hashMap.put("pkg_type", Integer.valueOf(type));
                    hashMap.put("version_code", v1);
                    this.d.W(HttpDelete.METHOD_NAME, hashMap, new a(this));
                    return;
                }
                this.d.d(this.c, new hr1(k43Var.b(), f43.f(k43Var.b())));
                bd3.e0(new b(this));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements t02<hr1> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ yf1 b;

        public h(yf1 yf1Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yf1Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = yf1Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.t02
        /* renamed from: b */
        public void a(hr1 hr1Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hr1Var) == null) {
                this.b.d(this.a, hr1Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements t02<hr1> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ yf1 b;

        public i(yf1 yf1Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yf1Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = yf1Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.t02
        /* renamed from: b */
        public void a(hr1 hr1Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hr1Var) == null) {
                this.b.d(this.a, hr1Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j implements tf1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ String b;
        public final /* synthetic */ yf1 c;

        public j(yf1 yf1Var, boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yf1Var, Boolean.valueOf(z), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = yf1Var;
            this.a = z;
            this.b = str;
        }

        @Override // com.repackage.tf1
        public void onResult(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i != 0) {
                    if (!this.a) {
                        a63.S(com.baidu.pass.biometrics.face.liveness.b.a.g0, 10, RetrieveTaskManager.KEY);
                    }
                    this.c.d(this.b, new hr1(1001, "user is not login"));
                    return;
                }
                if (!this.a) {
                    a63.S("success", 10, RetrieveTaskManager.KEY);
                }
                this.c.S(this.b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class k implements CallbackHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ yf1 b;

        public k(yf1 yf1Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yf1Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = yf1Var;
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

    /* loaded from: classes7.dex */
    public class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ yf1 e;

        /* loaded from: classes7.dex */
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

        /* loaded from: classes7.dex */
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
                    gz2.J().r().d0().E();
                }
            }
        }

        public l(yf1 yf1Var, String str, String str2, String str3, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yf1Var, str, str2, str3, str4};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = yf1Var;
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = str4;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ly2.a aVar = new ly2.a(this.e.getContext());
                aVar.V(this.a);
                aVar.x(this.b);
                aVar.y();
                aVar.n(new pe3());
                aVar.m(false);
                aVar.P(this.c, new b(this));
                aVar.C(this.d, new a(this));
                aVar.X();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yf1(@NonNull in1 in1Var) {
        super(in1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {in1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((in1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void I(JSONArray jSONArray, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, jSONArray, str, str2) == null) {
            gz2.J().r().d0().g(getContext(), "scope_insert_bookshelf", new g(this, jSONArray, str, str2));
        }
    }

    public final void J(JSONArray jSONArray, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray, str, str2) == null) {
            gz2.J().r().d0().g(getContext(), "scope_insert_bookshelf", new f(this, jSONArray, str, str2));
        }
    }

    public hr1 K(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#deleteBookshelf", false);
            Pair<hr1, JSONObject> s = s(str);
            hr1 hr1Var = (hr1) s.first;
            JSONObject jSONObject = (JSONObject) s.second;
            if (!hr1Var.isSuccess() || jSONObject == null) {
                return hr1Var;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("contentIds");
            if (optJSONArray != null && optJSONArray.length() != 0) {
                String optString = jSONObject.optString("category");
                if (TextUtils.isEmpty(optString)) {
                    return new hr1(201, "category is invalid");
                }
                String optString2 = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString2)) {
                    return new hr1(202, "cb is invalid");
                }
                if (!SwanAppNetworkUtils.i(getContext())) {
                    bd3.e0(new e(this));
                    return new hr1(1001, "network is not connected");
                } else if (R()) {
                    M();
                    return new hr1(10003, f43.f(10003));
                } else {
                    I(optJSONArray, optString, optString2);
                    return hr1.f();
                }
            }
            return new hr1(201, "contentIds is invalid");
        }
        return (hr1) invokeL.objValue;
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
                        return oi2.o().H();
                    }
                    return oi2.o().y();
                }
                return oi2.o().h();
            }
            return oi2.o().w();
        }
        return (String) invokeL.objValue;
    }

    public final void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            bd3.e0(new l(this, getContext().getString(R.string.obfuscated_res_0x7f0f1276), getContext().getString(R.string.obfuscated_res_0x7f0f1275), getContext().getString(R.string.obfuscated_res_0x7f0f1310), getContext().getString(R.string.obfuscated_res_0x7f0f12ac)));
        }
    }

    public final void N(t02<hr1> t02Var, int i2, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{t02Var, Integer.valueOf(i2), str, Boolean.valueOf(z)}) == null) {
            if (t02Var != null) {
                t02Var.a(new hr1(i2, str));
            }
            if (z) {
                bd3.e0(new c(this, str));
            }
        }
    }

    public final void O(t02<hr1> t02Var, JSONObject jSONObject, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048582, this, t02Var, jSONObject, z) == null) {
            if (t02Var != null && jSONObject != null) {
                t02Var.a(new hr1(0, jSONObject));
            }
            if (z) {
                oi2.l0().b(getContext());
            }
        }
    }

    public hr1 P(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            q("#insertBookshelf", false);
            Pair<hr1, JSONObject> s = s(str);
            hr1 hr1Var = (hr1) s.first;
            JSONObject jSONObject = (JSONObject) s.second;
            if (!hr1Var.isSuccess() || jSONObject == null) {
                return hr1Var;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("contentIds");
            if (optJSONArray != null && optJSONArray.length() != 0) {
                String optString = jSONObject.optString("category");
                f = optString;
                if (TextUtils.isEmpty(optString)) {
                    return new hr1(201, "category is invalid");
                }
                String optString2 = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString2)) {
                    return new hr1(202, "cb is invalid");
                }
                if (!SwanAppNetworkUtils.i(getContext())) {
                    bd3.e0(new d(this));
                    return new hr1(1001, "network is not connected");
                } else if (R()) {
                    M();
                    return new hr1(10003, f43.f(10003));
                } else {
                    J(optJSONArray, f, optString2);
                    return hr1.f();
                }
            }
            return new hr1(201, "contentIds is invalid");
        }
        return (hr1) invokeL.objValue;
    }

    public final void Q(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2) == null) {
            int i2 = 1001;
            if (TextUtils.isEmpty(str)) {
                d(str2, new hr1(1001, "navigateToBookshelf fail"));
            }
            try {
                i2 = new JSONObject(str).optInt("status", 1001);
            } catch (JSONException e2) {
                p("json put data fail", e2, false);
            }
            if (i2 == 0) {
                d(str2, new hr1(i2, "navigateToBookshelf success"));
            } else {
                d(str2, new hr1(i2, "navigateToBookshelf fail"));
            }
        }
    }

    public final boolean R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            h43 h43Var = fr2.g(true).get("scope_insert_bookshelf");
            if (h43Var != null) {
                return h43Var.j < 0 && !h43Var.d;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void S(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            oi2.l0().d(new k(this, str));
        }
    }

    public final void T(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            hz2 r = gz2.J().r();
            r.M().f(r.x(), null, new j(this, r.M().e(getContext()), str));
        }
    }

    public hr1 U(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            q("#navigateToBookshelf", false);
            Pair<hr1, JSONObject> s = s(str);
            hr1 hr1Var = (hr1) s.first;
            JSONObject jSONObject = (JSONObject) s.second;
            if (!hr1Var.isSuccess() || jSONObject == null) {
                return hr1Var;
            }
            f = jSONObject.optString("category");
            String optString = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                return new hr1(202, "cb is invalid");
            }
            if (!gz2.J().r().M().e(getContext())) {
                a63.S("show", 10, RetrieveTaskManager.KEY);
                T(optString);
                return hr1.f();
            }
            S(optString);
            return hr1.f();
        }
        return (hr1) invokeL.objValue;
    }

    public hr1 V(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            q("#queryBookshelf", false);
            Pair<hr1, JSONObject> s = s(str);
            hr1 hr1Var = (hr1) s.first;
            JSONObject jSONObject = (JSONObject) s.second;
            if (!hr1Var.isSuccess() || jSONObject == null) {
                return hr1Var;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("contentIds");
            if (optJSONArray != null && optJSONArray.length() != 0) {
                String optString = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    return new hr1(202, "cb is invalid");
                }
                if (!SwanAppNetworkUtils.i(getContext())) {
                    return new hr1(1001, "network is not connected");
                }
                if (!gz2.J().r().M().e(getContext())) {
                    return new hr1(1001, "user is not login");
                }
                Object N = gz2.J().r().N();
                int type = gz2.J().r().V().getType();
                Object v1 = gz2.J().r().V().v1();
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("appKey", N);
                hashMap.put("contentIds", optJSONArray);
                hashMap.put("pkg_type", Integer.valueOf(type));
                hashMap.put("version_code", v1);
                W("QUERY", hashMap, new h(this, optString));
                return hr1.f();
            }
            return new hr1(201, "contentIds is invalid");
        }
        return (hr1) invokeL.objValue;
    }

    public final void W(String str, HashMap<String, Object> hashMap, t02<hr1> t02Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048590, this, str, hashMap, t02Var) == null) {
            boolean equals = TextUtils.equals(str, "INSERT");
            JSONObject jSONObject = new JSONObject();
            try {
                for (Map.Entry<String, Object> entry : hashMap.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
            } catch (Exception unused) {
            }
            RequestBody create = RequestBody.create(oq2.a, jSONObject.toString());
            String L = L(str);
            if (TextUtils.isEmpty(L)) {
                N(t02Var, 1001, "operation fail, msg = url is null", equals);
                return;
            }
            if (equals) {
                bd3.e0(new a(this));
            }
            i64 i64Var = new i64(L, create, new b(this, equals, t02Var));
            if (j64.g().c()) {
                i64Var.f = true;
            }
            i64Var.g = true;
            j64.g().e(i64Var);
        }
    }

    public hr1 X(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
            q("#updateBookshelfReadTime", false);
            Pair<hr1, JSONObject> s = s(str);
            hr1 hr1Var = (hr1) s.first;
            JSONObject jSONObject = (JSONObject) s.second;
            if (!hr1Var.isSuccess() || jSONObject == null) {
                return hr1Var;
            }
            String optString = jSONObject.optString("contentId");
            if (TextUtils.isEmpty(optString)) {
                return new hr1(201, "contentId is invalid");
            }
            String optString2 = jSONObject.optString("category");
            if (TextUtils.isEmpty(optString2)) {
                return new hr1(201, "category is invalid");
            }
            String optString3 = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString3)) {
                return new hr1(202, "cb is invalid");
            }
            if (!SwanAppNetworkUtils.i(getContext())) {
                return new hr1(1001, "network is not connected");
            }
            if (!gz2.J().r().M().e(getContext())) {
                return new hr1(1001, "user is not login");
            }
            Object N = gz2.J().r().N();
            int type = gz2.J().r().V().getType();
            Object v1 = gz2.J().r().V().v1();
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("appKey", N);
            hashMap.put("contentId", optString);
            hashMap.put("category", optString2);
            hashMap.put("pkg_type", Integer.valueOf(type));
            hashMap.put("version_code", v1);
            W("UPDATE_READ_TIME", hashMap, new i(this, optString3));
            return hr1.f();
        }
        return (hr1) invokeL.objValue;
    }

    @Override // com.repackage.kn1
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? "Bookshelf" : (String) invokeV.objValue;
    }

    @Override // com.repackage.kn1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? "SwanAppBookshelfApi" : (String) invokeV.objValue;
    }
}
