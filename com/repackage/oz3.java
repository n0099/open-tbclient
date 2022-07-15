package com.repackage;

import android.text.TextUtils;
import android.util.Log;
import android.webkit.JavascriptInterface;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.searchbox.v8engine.FontParser;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.binding.model.JSTypeMismatchException;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class oz3 extends mz3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public r72 b;

    /* loaded from: classes6.dex */
    public class a extends ResponseCallback<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uz3 a;
        public final /* synthetic */ os1 b;
        public final /* synthetic */ oz3 c;

        /* renamed from: com.repackage.oz3$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC0701a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ JSONObject a;
            public final /* synthetic */ a b;

            public RunnableC0701a(a aVar, JSONObject jSONObject) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, jSONObject};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = aVar;
                this.a = jSONObject;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    s24.call(this.b.b, true, this.a);
                }
            }
        }

        /* loaded from: classes6.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public b(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    a aVar = this.a;
                    s24.call(aVar.b, false, aVar.a);
                }
            }
        }

        public a(oz3 oz3Var, uz3 uz3Var, os1 os1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oz3Var, uz3Var, os1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = oz3Var;
            this.a = uz3Var;
            this.b = os1Var;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                if (mz3.a) {
                    Log.e("OpenDataApi", "on fail");
                    exc.printStackTrace();
                }
                if (TextUtils.isEmpty(this.a.errMsg)) {
                    uz3 uz3Var = this.a;
                    uz3Var.errNo = "100";
                    uz3Var.errMsg = String.format("%s: fail Error: %s", "getUserInfo", exc.getMessage());
                }
                this.c.b.post(new b(this));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(JSONObject jSONObject, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, jSONObject, i) == null) {
                if (mz3.a) {
                    Log.d("OpenDataApi", "on success");
                }
                this.c.b.post(new RunnableC0701a(this, jSONObject));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public JSONObject parseResponse(Response response, int i) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, response, i)) == null) {
                ResponseBody body = response.body();
                if (body == null) {
                    return null;
                }
                String string = body.string();
                if (mz3.a) {
                    Log.d("OpenDataApi", "parse response: " + string);
                }
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("errno");
                if (!TextUtils.equals(optString, "0")) {
                    if (mz3.a) {
                        Log.d("OpenDataApi", "errno = " + optString);
                    }
                    uz3 uz3Var = this.a;
                    uz3Var.errNo = optString;
                    uz3Var.errMsg = String.format("%s: fail Error: %s", "getUserInfo", jSONObject.optString("errmsg"));
                    return null;
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("errNo", "0");
                jSONObject2.put(StatConstants.KEY_EXT_ERR_MSG, s24.b("getUserInfo", "ok"));
                jSONObject2.put("data", jSONObject.optJSONArray("data"));
                return jSONObject2;
            }
            return (JSONObject) invokeLI.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b extends ResponseCallback<uz3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uz3 a;
        public final /* synthetic */ os1 b;
        public final /* synthetic */ oz3 c;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ uz3 a;
            public final /* synthetic */ b b;

            public a(b bVar, uz3 uz3Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, uz3Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = bVar;
                this.a = uz3Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    s24.call(this.b.b, true, this.a);
                }
            }
        }

        /* renamed from: com.repackage.oz3$b$b  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC0702b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public RunnableC0702b(b bVar) {
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
                        return;
                    }
                }
                this.a = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    b bVar = this.a;
                    s24.call(bVar.b, false, bVar.a);
                }
            }
        }

        public b(oz3 oz3Var, uz3 uz3Var, os1 os1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oz3Var, uz3Var, os1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = oz3Var;
            this.a = uz3Var;
            this.b = os1Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(uz3 uz3Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, uz3Var, i) == null) {
                if (mz3.a) {
                    Log.d("OpenDataApi", "on success ");
                }
                this.c.b.post(new a(this, uz3Var));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public uz3 parseResponse(Response response, int i) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, response, i)) == null) {
                ResponseBody body = response.body();
                if (body == null) {
                    return null;
                }
                String string = body.string();
                if (mz3.a) {
                    Log.d("OpenDataApi", "parse response: " + string);
                }
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("errno");
                if (!TextUtils.equals(optString, "0")) {
                    if (mz3.a) {
                        Log.d("OpenDataApi", "errno = " + optString);
                    }
                    uz3 uz3Var = this.a;
                    uz3Var.errNo = optString;
                    uz3Var.errMsg = String.format("%s: fail Error: %s", "removeUserCloudStorage", jSONObject.optString("errmsg"));
                    return null;
                }
                uz3 uz3Var2 = this.a;
                uz3Var2.errNo = "0";
                uz3Var2.errMsg = s24.b("removeUserCloudStorage", "ok");
                return this.a;
            }
            return (uz3) invokeLI.objValue;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
                if (mz3.a) {
                    Log.d("OpenDataApi", "on fail");
                    exc.printStackTrace();
                }
                if (TextUtils.isEmpty(this.a.errMsg)) {
                    uz3 uz3Var = this.a;
                    uz3Var.errNo = "100";
                    uz3Var.errMsg = String.format("%s: fail Error: %s", "removeUserCloudStorage", exc.getMessage());
                }
                this.c.b.post(new RunnableC0702b(this));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends ResponseCallback<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uz3 a;
        public final /* synthetic */ os1 b;
        public final /* synthetic */ oz3 c;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ JSONObject a;
            public final /* synthetic */ c b;

            public a(c cVar, JSONObject jSONObject) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, jSONObject};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = cVar;
                this.a = jSONObject;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    s24.call(this.b.b, true, this.a);
                }
            }
        }

        /* loaded from: classes6.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            public b(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c cVar = this.a;
                    s24.call(cVar.b, false, cVar.a);
                }
            }
        }

        public c(oz3 oz3Var, uz3 uz3Var, os1 os1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oz3Var, uz3Var, os1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = oz3Var;
            this.a = uz3Var;
            this.b = os1Var;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                if (mz3.a) {
                    Log.e("OpenDataApi", "on fail");
                }
                if (TextUtils.isEmpty(this.a.errMsg)) {
                    uz3 uz3Var = this.a;
                    uz3Var.errNo = "100";
                    uz3Var.errMsg = String.format("%s: fail Error: %s", "getUserCloudStorage", exc.getMessage());
                }
                this.c.b.post(new b(this));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(JSONObject jSONObject, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, jSONObject, i) == null) {
                if (mz3.a) {
                    Log.d("OpenDataApi", "on success");
                }
                this.c.b.post(new a(this, jSONObject));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public JSONObject parseResponse(Response response, int i) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, response, i)) == null) {
                ResponseBody body = response.body();
                if (body == null) {
                    return null;
                }
                String string = body.string();
                if (mz3.a) {
                    Log.d("OpenDataApi", "parse response: " + string);
                }
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("errno");
                if (!TextUtils.equals(optString, "0")) {
                    if (mz3.a) {
                        Log.d("OpenDataApi", "errno = " + optString);
                    }
                    uz3 uz3Var = this.a;
                    uz3Var.errNo = optString;
                    uz3Var.errMsg = String.format("%s: fail Error: %s", "getUserCloudStorage", jSONObject.optString("errmsg"));
                    return null;
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("errNo", "0");
                jSONObject2.put(StatConstants.KEY_EXT_ERR_MSG, s24.b("getUserCloudStorage", "ok"));
                jSONObject2.put("KVDataList", jSONObject.optJSONArray("data"));
                return jSONObject2;
            }
            return (JSONObject) invokeLI.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class d extends ResponseCallback<uz3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uz3 a;
        public final /* synthetic */ os1 b;
        public final /* synthetic */ oz3 c;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ uz3 a;
            public final /* synthetic */ d b;

            public a(d dVar, uz3 uz3Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar, uz3Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = dVar;
                this.a = uz3Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    s24.call(this.b.b, true, this.a);
                }
            }
        }

        /* loaded from: classes6.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d a;

            public b(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    d dVar = this.a;
                    s24.call(dVar.b, false, dVar.a);
                }
            }
        }

        public d(oz3 oz3Var, uz3 uz3Var, os1 os1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oz3Var, uz3Var, os1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = oz3Var;
            this.a = uz3Var;
            this.b = os1Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(uz3 uz3Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, uz3Var, i) == null) {
                if (mz3.a) {
                    Log.d("OpenDataApi", "on success");
                }
                this.c.b.post(new a(this, uz3Var));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public uz3 parseResponse(Response response, int i) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, response, i)) == null) {
                ResponseBody body = response.body();
                if (body == null) {
                    return null;
                }
                String string = body.string();
                if (mz3.a) {
                    Log.d("OpenDataApi", "parse response: " + string);
                }
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("errno");
                if (!TextUtils.equals(optString, "0")) {
                    if (mz3.a) {
                        Log.d("OpenDataApi", "errno = " + optString);
                    }
                    uz3 uz3Var = this.a;
                    uz3Var.errNo = optString;
                    uz3Var.errMsg = String.format("%s: fail Error: %s", "setUserCloudStorage", jSONObject.optString("errmsg"));
                    return null;
                }
                uz3 uz3Var2 = this.a;
                uz3Var2.errNo = "0";
                uz3Var2.errMsg = s24.b("setUserCloudStorage", "ok");
                return this.a;
            }
            return (uz3) invokeLI.objValue;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
                if (mz3.a) {
                    Log.e("OpenDataApi", "on fail");
                }
                if (TextUtils.isEmpty(this.a.errMsg)) {
                    uz3 uz3Var = this.a;
                    uz3Var.errNo = "100";
                    uz3Var.errMsg = String.format("%s: fail Error: %s", "setUserCloudStorage", exc.getMessage());
                }
                this.c.b.post(new b(this));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e extends ResponseCallback<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uz3 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ os1 c;
        public final /* synthetic */ oz3 d;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ JSONObject a;
            public final /* synthetic */ e b;

            public a(e eVar, JSONObject jSONObject) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar, jSONObject};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = eVar;
                this.a = jSONObject;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    s24.call(this.b.c, true, this.a);
                }
            }
        }

        /* loaded from: classes6.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ e a;

            public b(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = eVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    e eVar = this.a;
                    s24.call(eVar.c, false, eVar.a);
                }
            }
        }

        public e(oz3 oz3Var, uz3 uz3Var, String str, os1 os1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oz3Var, uz3Var, str, os1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = oz3Var;
            this.a = uz3Var;
            this.b = str;
            this.c = os1Var;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                if (mz3.a) {
                    Log.e("OpenDataApi", "on fail");
                    exc.printStackTrace();
                }
                if (TextUtils.isEmpty(this.a.errMsg)) {
                    uz3 uz3Var = this.a;
                    uz3Var.errNo = "100";
                    uz3Var.errMsg = String.format("%s: fail Error: %s", this.b, exc.getMessage());
                }
                this.d.b.post(new b(this));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(JSONObject jSONObject, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, jSONObject, i) == null) {
                if (mz3.a) {
                    Log.d("OpenDataApi", "on success");
                }
                this.d.b.post(new a(this, jSONObject));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public JSONObject parseResponse(Response response, int i) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, response, i)) == null) {
                ResponseBody body = response.body();
                if (body == null) {
                    return null;
                }
                String string = body.string();
                if (mz3.a) {
                    Log.d("OpenDataApi", "parse response: " + string);
                }
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("errno");
                if (!TextUtils.equals(optString, "0")) {
                    if (mz3.a) {
                        Log.d("OpenDataApi", "errno = " + optString);
                    }
                    uz3 uz3Var = this.a;
                    uz3Var.errNo = optString;
                    uz3Var.errMsg = String.format("%s: fail Error: %s", this.b, jSONObject.optString("errmsg"));
                    return null;
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("errNo", "0");
                jSONObject2.put(StatConstants.KEY_EXT_ERR_MSG, s24.b(this.b, "ok"));
                jSONObject2.put("data", jSONObject.optJSONArray("data"));
                return jSONObject2;
            }
            return (JSONObject) invokeLI.objValue;
        }
    }

    public oz3(@NonNull r72 r72Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {r72Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = r72Var;
    }

    public final tz3[] c(os1 os1Var, JsObject[] jsObjectArr, uz3 uz3Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, os1Var, jsObjectArr, uz3Var)) == null) {
            int length = jsObjectArr.length;
            if (length < 1) {
                uz3Var.errMsg = s24.b("setUserCloudStorage", "fail KVDataList.length must greater than 0");
                s24.call(os1Var, false, uz3Var);
                return null;
            } else if (length > 128) {
                uz3Var.errMsg = s24.b("setUserCloudStorage", "fail user has stored too much keys. delete some keys and try again");
                s24.call(os1Var, false, uz3Var);
                return null;
            } else {
                tz3[] tz3VarArr = new tz3[length];
                for (int i = 0; i < length; i++) {
                    os1 F = os1.F(jsObjectArr[i]);
                    if (F != null && F.k() == 2 && !TextUtils.isEmpty(F.B("key")) && !TextUtils.isEmpty(F.B("value"))) {
                        tz3VarArr[i] = new tz3();
                        tz3VarArr[i].key = F.B("key");
                        tz3VarArr[i].value = F.B("value");
                        if (!tz3VarArr[i].a()) {
                            uz3Var.errMsg = s24.b("setUserCloudStorage", "fail some keys in list meet length exceed");
                            s24.call(os1Var, false, uz3Var);
                            return null;
                        } else if (!tz3VarArr[i].b()) {
                            uz3Var.errMsg = s24.b("setUserCloudStorage", "fail some key-value in list meet length exceed");
                            s24.call(os1Var, false, uz3Var);
                            return null;
                        }
                    } else {
                        uz3Var.errMsg = s24.b("setUserCloudStorage", "fail invalid KVData item");
                        s24.call(os1Var, false, uz3Var);
                        return null;
                    }
                }
                return tz3VarArr;
            }
        }
        return (tz3[]) invokeLLL.objValue;
    }

    public final void d(JsObject jsObject, int i) {
        os1 F;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jsObject, i) == null) || (F = os1.F(jsObject)) == null) {
            return;
        }
        if (i == 5) {
            uz3 uz3Var = new uz3();
            if (!g()) {
                uz3Var.errNo = FontParser.sFontWeightDefault;
                uz3Var.errMsg = s24.b("getFriendCloudStorage", "fail must login before calling");
                s24.call(F, false, uz3Var);
                h(jsObject);
                return;
            }
            try {
                String[] h = F.h("keyList");
                h(jsObject);
                j(i, h, new e(this, uz3Var, "getFriendCloudStorage", F));
                return;
            } catch (JSTypeMismatchException e2) {
                if (mz3.a) {
                    e2.printStackTrace();
                }
                uz3Var.errNo = FontParser.sFontWeightDefault;
                uz3Var.errMsg = s24.b("getFriendCloudStorage", "fail invalid keyList");
                s24.call(F, false, uz3Var);
                h(jsObject);
                return;
            }
        }
        h(jsObject);
    }

    public final JSONObject e(tz3[] tz3VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tz3VarArr)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ma_id", h03.g0());
                JSONArray jSONArray = new JSONArray();
                for (tz3 tz3Var : tz3VarArr) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("key", tz3Var.key);
                    jSONObject2.put("value", tz3Var.value);
                    jSONArray.put(jSONObject2);
                }
                jSONObject.put("data", jSONArray);
            } catch (JSONException e2) {
                if (mz3.a) {
                    e2.printStackTrace();
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public final String f(int i) {
        InterceptResult invokeI;
        String r;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            if (i == 1) {
                r = xw3.b().r();
            } else if (i == 2) {
                r = xw3.b().m();
            } else if (i == 3) {
                r = xw3.b().s();
            } else if (i != 4) {
                r = i != 5 ? "" : xw3.b().k();
            } else {
                r = xw3.b().o();
            }
            if (TextUtils.isEmpty(r) && mz3.a) {
                Log.e("OpenDataApi", "getUrlByType（）meet empty url !");
            }
            return r;
        }
        return (String) invokeI.objValue;
    }

    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            h03 M = h03.M();
            if (M == null) {
                return false;
            }
            return M.N().e(AppRuntime.getAppContext());
        }
        return invokeV.booleanValue;
    }

    @JavascriptInterface
    public void getFriendCloudStorage(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, jsObject) == null) {
            d(jsObject, 5);
        }
    }

    @JavascriptInterface
    public void getUserCloudStorage(JsObject jsObject) {
        os1 F;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, jsObject) == null) || (F = os1.F(jsObject)) == null) {
            return;
        }
        uz3 uz3Var = new uz3();
        if (!g()) {
            uz3Var.errNo = FontParser.sFontWeightDefault;
            uz3Var.errMsg = s24.b("getUserCloudStorage", "fail must login before calling");
            s24.call(F, false, uz3Var);
            h(jsObject);
            return;
        }
        try {
            String[] h = F.h("keyList");
            h(jsObject);
            j(3, h, new c(this, uz3Var, F));
        } catch (JSTypeMismatchException e2) {
            if (mz3.a) {
                e2.printStackTrace();
            }
            uz3Var.errNo = FontParser.sFontWeightDefault;
            uz3Var.errMsg = s24.b("getUserCloudStorage", "fail invalid keyList");
            s24.call(F, false, uz3Var);
            h(jsObject);
        }
    }

    @JavascriptInterface
    public void getUserInfo(JsObject jsObject) {
        os1 F;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, jsObject) == null) || (F = os1.F(jsObject)) == null) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        try {
            String[] h = F.h("swanIdList");
            if (h != null && h.length > 0) {
                for (String str : h) {
                    jSONArray.put(str);
                }
            }
        } catch (JSTypeMismatchException e2) {
            if (mz3.a) {
                e2.printStackTrace();
            }
        }
        h(jsObject);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ma_id", h03.g0());
            jSONObject.put("swanid_list", jSONArray);
        } catch (JSONException e3) {
            if (mz3.a) {
                e3.printStackTrace();
            }
        }
        a(f(1), jSONObject.toString(), new a(this, new uz3(), F));
    }

    public final void h(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jsObject) == null) || jsObject == null) {
            return;
        }
        jsObject.release();
    }

    public final void i(JsObject[] jsObjectArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, jsObjectArr) == null) || jsObjectArr == null) {
            return;
        }
        for (JsObject jsObject : jsObjectArr) {
            h(jsObject);
        }
    }

    public final <T> void j(int i, @NonNull String[] strArr, ResponseCallback<T> responseCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048586, this, i, strArr, responseCallback) == null) {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            if (strArr.length > 0) {
                for (String str : strArr) {
                    jSONArray.put(str);
                }
            }
            try {
                jSONObject.put("ma_id", h03.g0());
                jSONObject.put("key_list", jSONArray);
            } catch (JSONException e2) {
                if (mz3.a) {
                    e2.printStackTrace();
                }
            }
            a(f(i), jSONObject.toString(), responseCallback);
        }
    }

    @JavascriptInterface
    public void removeUserCloudStorage(JsObject jsObject) {
        os1 F;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, jsObject) == null) || (F = os1.F(jsObject)) == null) {
            return;
        }
        uz3 uz3Var = new uz3();
        if (!g()) {
            uz3Var.errNo = FontParser.sFontWeightDefault;
            uz3Var.errMsg = s24.b("removeUserCloudStorage", "fail must login before calling");
            s24.call(F, false, uz3Var);
            h(jsObject);
            return;
        }
        try {
            String[] h = F.h("keyList");
            h(jsObject);
            j(2, h, new b(this, uz3Var, F));
        } catch (JSTypeMismatchException e2) {
            if (mz3.a) {
                e2.printStackTrace();
            }
            uz3Var.errNo = FontParser.sFontWeightDefault;
            uz3Var.errMsg = s24.b("removeUserCloudStorage", "fail invalid keyList");
            s24.call(F, false, uz3Var);
            h(jsObject);
        }
    }

    @JavascriptInterface
    public void setUserCloudStorage(JsObject jsObject) {
        os1 F;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, jsObject) == null) || (F = os1.F(jsObject)) == null) {
            return;
        }
        uz3 uz3Var = new uz3();
        if (!g()) {
            uz3Var.errNo = FontParser.sFontWeightDefault;
            uz3Var.errMsg = s24.b("setUserCloudStorage", "fail must login before calling");
            s24.call(F, false, uz3Var);
            i(F.z("KVDataList"));
            h(jsObject);
            return;
        }
        try {
            JsObject[] e2 = F.e("KVDataList");
            h(jsObject);
            tz3[] c2 = c(F, e2, uz3Var);
            i(e2);
            if (c2 == null) {
                return;
            }
            a(f(4), e(c2).toString(), new d(this, uz3Var, F));
        } catch (JSTypeMismatchException e3) {
            if (mz3.a) {
                e3.printStackTrace();
            }
            uz3Var.errNo = FontParser.sFontWeightDefault;
            uz3Var.errMsg = s24.b("setUserCloudStorage", "fail KVDataList must be an Array");
            s24.call(F, false, uz3Var);
            h(jsObject);
        }
    }
}
