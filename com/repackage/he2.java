package com.repackage;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.WorkerThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.oa2;
import com.repackage.rl2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class he2 implements ih1 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements fe2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rl2 a;

        public a(rl2 rl2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rl2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rl2Var;
        }

        @Override // com.repackage.fe2
        public void onResult(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && z) {
                x72.u(AppRuntime.getAppContext().getContentResolver(), this.a.H(), 1);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b extends ResponseCallback<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fe2 a;

        public b(fe2 fe2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fe2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fe2Var;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            fe2 fe2Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, exc) == null) || (fe2Var = this.a) == null) {
                return;
            }
            fe2Var.onResult(false);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(JSONObject jSONObject, int i) {
            fe2 fe2Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, jSONObject, i) == null) || (fe2Var = this.a) == null) {
                return;
            }
            if (jSONObject != null) {
                if (he2.a) {
                    Log.d("SwanHistoryManager", "上报数据 onSuccess: response=" + jSONObject);
                }
                if (jSONObject.optInt("errno", -1) == 0) {
                    this.a.onResult(true);
                    return;
                } else {
                    this.a.onResult(false);
                    return;
                }
            }
            fe2Var.onResult(false);
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
    public static class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
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
                he2.h(true);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class d implements ee2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.ee2
        public void a(List<ge2> list) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || list == null) {
                return;
            }
            x72.f();
            x72.l(list);
        }
    }

    /* loaded from: classes6.dex */
    public static class e extends ResponseCallback<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ee2 a;

        public e(ee2 ee2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ee2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ee2Var;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            ee2 ee2Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, exc) == null) || (ee2Var = this.a) == null) {
                return;
            }
            ee2Var.a(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(JSONObject jSONObject, int i) {
            ee2 ee2Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, jSONObject, i) == null) || (ee2Var = this.a) == null) {
                return;
            }
            if (jSONObject != null) {
                if (he2.a) {
                    Log.d("SwanHistoryManager", "下拉数据 onSuccess: response=" + jSONObject);
                }
                if (jSONObject.optInt("errno", -1) != 0) {
                    this.a.a(null);
                    return;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (optJSONObject == null) {
                    this.a.a(null);
                    return;
                }
                JSONArray optJSONArray = optJSONObject.optJSONArray("items");
                if (optJSONArray == null) {
                    this.a.a(null);
                    return;
                }
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    ge2 b = ge2.b(optJSONArray.optJSONObject(i2));
                    if (b != null) {
                        arrayList.add(b);
                    }
                }
                i93.a().putString("fetch_history_data_last_id", optJSONObject.optString(ImageViewerConfig.LAST_ID));
                this.a.a(arrayList);
                return;
            }
            ee2Var.a(null);
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
    public static class f {
        public static /* synthetic */ Interceptable $ic;
        public static final he2 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-331352902, "Lcom/repackage/he2$f;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-331352902, "Lcom/repackage/he2$f;");
                    return;
                }
            }
            a = new he2(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755651204, "Lcom/repackage/he2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755651204, "Lcom/repackage/he2;");
                return;
            }
        }
        a = eh1.a;
    }

    public /* synthetic */ he2(a aVar) {
        this();
    }

    @WorkerThread
    public static void c(u03 u03Var, oa2.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, u03Var, bVar) == null) || u03Var == null) {
            return;
        }
        rl2.a V = u03Var.V();
        if (TextUtils.equals("1", V.c0())) {
            ux1.b("SwanHistoryManager", "add history with 'notinhis=1': " + V.H() + "/" + V.K());
            return;
        }
        ux1.b("SwanHistoryManager", "add history: " + V.H() + "/" + V.K());
        ge2 a2 = ge2.a(V);
        boolean c2 = x72.c(AppRuntime.getAppContext().getContentResolver(), a2, bVar);
        a aVar = new a(V);
        if (c2) {
            j("ADD", a2.a, a2.e, a2.b, a2.g, a2.j, aVar);
        }
        if (!a || c2) {
            return;
        }
        Log.e("SwanHistoryManager", "addHistoryAsync Failed!");
    }

    public static String d(String str, List<ge2> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, str, list)) == null) {
            if (list == null || list.size() <= 0) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            try {
                for (ge2 ge2Var : list) {
                    if (ge2Var != null) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("cmd", str);
                        jSONObject2.put("bundle_id", ge2Var.a);
                        jSONObject2.put("time", ge2Var.e);
                        jSONArray.put(jSONObject2);
                    }
                }
                jSONObject.put("items", jSONArray);
            } catch (JSONException e2) {
                if (a) {
                    e2.printStackTrace();
                }
            }
            return jSONObject.toString();
        }
        return (String) invokeLL.objValue;
    }

    public static String e(String str, String str2, long j, String str3, String str4, String str5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{str, str2, Long.valueOf(j), str3, str4, str5})) == null) {
            if (TextUtils.isEmpty(str2)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("cmd", str);
                if (TextUtils.isEmpty(str3)) {
                    jSONObject2.put("bundle_id", str2);
                } else {
                    jSONObject2.put("appkey", str3);
                }
                if (!TextUtils.isEmpty(str4)) {
                    jSONObject2.put("pkg_type", Integer.parseInt(str4));
                }
                if (!TextUtils.isEmpty(str5)) {
                    jSONObject2.put("version_code", Integer.parseInt(str5));
                }
                jSONObject2.put("time", j);
                jSONArray.put(jSONObject2);
                jSONObject.put("items", jSONArray);
            } catch (JSONException e2) {
                if (a) {
                    e2.printStackTrace();
                }
            }
            return jSONObject.toString();
        }
        return (String) invokeCommon.objValue;
    }

    public static void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, null) == null) {
            od3.k(new c(), "fetchHistoryDataFromServer");
        }
    }

    public static void g(String str, List<ge2> list, ee2 ee2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65544, null, str, list, ee2Var) == null) {
            String p = bk2.o().p();
            HashMap hashMap = new HashMap();
            hashMap.put(ImageViewerConfig.LAST_ID, i93.a().getString("fetch_history_data_last_id", ""));
            String b2 = me3.b(p, hashMap);
            String d2 = d(str, list);
            if (a) {
                Log.d("SwanHistoryManager", "fetchHistoryDataFromServer: url=" + b2 + "  params=" + d2);
            }
            e eVar = new e(ee2Var);
            v74 v74Var = new v74();
            v74Var.b = "POST";
            v74Var.a = b2;
            v74Var.f = true;
            v74Var.g = true;
            if (!TextUtils.isEmpty(d2)) {
                v74Var.d = RequestBody.create(bs2.a, d2);
            }
            v74Var.e = eVar;
            w74.g().e(v74Var);
        }
    }

    public static void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65545, null, z) == null) {
            List<ge2> r = x72.r();
            if (z || (r != null && r.size() > 0)) {
                g("ADD", r, new d());
            }
        }
    }

    public static he2 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? f.a : (he2) invokeV.objValue;
    }

    public static void j(String str, String str2, long j, String str3, String str4, String str5, fe2 fe2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65547, null, new Object[]{str, str2, Long.valueOf(j), str3, str4, str5, fe2Var}) == null) {
            String c2 = bk2.o().c();
            String e2 = e(str, str2, j, str3, str4, str5);
            if (TextUtils.isEmpty(e2)) {
                return;
            }
            if (a) {
                Log.d("SwanHistoryManager", "reportHistoryDataToServer: 上行参数" + e2);
            }
            b bVar = new b(fe2Var);
            v74 v74Var = new v74();
            v74Var.b = "POST";
            v74Var.a = c2;
            v74Var.f = true;
            v74Var.g = true;
            v74Var.d = RequestBody.create(bs2.a, e2);
            v74Var.e = bVar;
            w74.g().e(v74Var);
        }
    }

    @Override // com.repackage.ih1
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            f();
        }
    }

    public he2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        bk2.h0().c(this);
    }
}
