package com.repackage;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.http.request.PostFormRequest;
import com.baidu.swan.apps.api.module.subscription.SubscribeHelper;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class fj1 implements ql1 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static int b;
    public static int c;
    public static int d;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements my2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SubscribeHelper.i a;
        public final /* synthetic */ fj1 b;

        public a(fj1 fj1Var, SubscribeHelper.i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fj1Var, iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = fj1Var;
            this.a = iVar;
        }

        @Override // com.repackage.my2
        public void a(JSONObject jSONObject) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
                if (jSONObject != null) {
                    if (jSONObject.optInt("errno") == 0) {
                        JSONObject optJSONObject = jSONObject.optJSONObject("data");
                        if (optJSONObject != null) {
                            this.a.a(optJSONObject.optString("tip"), this.b.i(optJSONObject.optJSONArray("list")), false);
                            return;
                        }
                    } else {
                        str = jSONObject.optString("tipmsg");
                        this.a.a(str, null, false);
                    }
                }
                str = null;
                this.a.a(str, null, false);
            }
        }

        @Override // com.repackage.my2
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.a.a(str, null, false);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b extends ResponseCallback<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @Nullable
        public final my2 a;

        public b(@Nullable my2 my2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {my2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = my2Var;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                if (fj1.a) {
                    Log.e("SwanAppPushIdImpl", "SimpleResponseCallback", exc);
                }
                my2 my2Var = this.a;
                if (my2Var != null) {
                    my2Var.onFail(exc.toString());
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(JSONObject jSONObject, int i) {
            my2 my2Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, jSONObject, i) == null) || (my2Var = this.a) == null) {
                return;
            }
            if (jSONObject == null) {
                my2Var.onFail("request fail");
            } else {
                my2Var.a(jSONObject);
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
                String string = response.body().string();
                if (fj1.a) {
                    Log.d("SwanAppPushIdImpl", "statusCode:" + i + ", response=" + string);
                }
                if (TextUtils.isEmpty(string)) {
                    return null;
                }
                return new JSONObject(string);
            }
            return (JSONObject) invokeLI.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755706012, "Lcom/repackage/fj1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755706012, "Lcom/repackage/fj1;");
                return;
            }
        }
        a = sg1.a;
        b = 0;
        c = 1;
        d = 2;
    }

    public fj1() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? ex1.w(String.format("%s/ma/formid/multi_action", ex1.a), true) : (String) invokeV.objValue;
    }

    public static String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? ex1.w(String.format("%s/ma/formid/new", ex1.a), true) : (String) invokeV.objValue;
    }

    public static String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? ex1.w(String.format("%s/ma/component/sub/create", ex1.a), true) : (String) invokeV.objValue;
    }

    public static String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? ex1.w(String.format("%s/ma/component/msgtpl", ex1.a), true) : (String) invokeV.objValue;
    }

    public static String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? ex1.w(String.format("%s/ma/payid/new", ex1.a), true) : (String) invokeV.objValue;
    }

    @Override // com.repackage.ql1
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            long seconds = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
            Uri.Builder buildUpon = Uri.parse(j()).buildUpon();
            buildUpon.appendQueryParameter("timestamp", String.valueOf(seconds)).appendQueryParameter("rasign", dx1.b().c(seconds)).appendQueryParameter("delta", "smartapp_formid");
            return buildUpon.toString();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.repackage.ql1
    public void b(@NonNull String str, @NonNull Set<String> set, @NonNull SubscribeHelper.i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, set, iVar) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(GameGuideConfigInfo.KEY_APP_KEY, str);
                JSONArray jSONArray = new JSONArray();
                if (set != null && set.size() > 0) {
                    for (String str2 : set) {
                        jSONArray.put(str2);
                    }
                }
                jSONObject.put("template_ids", jSONArray);
            } catch (JSONException e) {
                if (a) {
                    e.printStackTrace();
                }
            }
            j74 j74Var = new j74(m(), new b(new a(this, iVar)));
            j74Var.a(pr2.a, jSONObject.toString());
            if (k74.g().c()) {
                j74Var.f = true;
            }
            j74Var.g = true;
            k74.g().e(j74Var);
        }
    }

    @Override // com.repackage.ql1
    public void c(@NonNull String str, cd2 cd2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, cd2Var) == null) {
            String h = h(b);
            ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) k74.g().postFormRequest().url(h)).cookieManager(pj2.q().a())).addParam("appkey", str).build().executeAsyncOnUIBack(new b(cd2Var));
        }
    }

    @Override // com.repackage.ql1
    public void d(@NonNull String str, @NonNull List<String> list, @Nullable String str2, boolean z, cd2 cd2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, list, str2, Boolean.valueOf(z), cd2Var}) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(GameGuideConfigInfo.KEY_APP_KEY, str);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("sub_id", str2);
                if (z) {
                    jSONObject2.put("template_id", list.get(0));
                } else {
                    JSONArray jSONArray = new JSONArray();
                    for (String str3 : list) {
                        jSONArray.put(str3);
                    }
                    jSONObject2.put("template_ids", jSONArray);
                }
                JSONArray jSONArray2 = new JSONArray();
                jSONArray2.put(jSONObject2);
                jSONObject.put("detail", jSONArray2);
            } catch (JSONException e) {
                if (a) {
                    e.printStackTrace();
                }
            }
            j74 j74Var = new j74(h(d), new b(cd2Var));
            j74Var.a(pr2.a, jSONObject.toString());
            j74Var.f = true;
            j74Var.g = true;
            k74.g().e(j74Var);
        }
    }

    @Override // com.repackage.ql1
    public void e(String str, et2 et2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, et2Var) == null) {
            o(h(c), str, et2Var);
        }
    }

    public final String h(int i) {
        InterceptResult invokeI;
        long seconds;
        StringBuilder sb;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            String str2 = "timestamp=" + TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
            String str3 = "delta=smartapp_formid";
            if (i == b) {
                sb = new StringBuilder(k());
                str = "rasign=" + dx1.b().c(seconds);
            } else if (i == d) {
                sb = new StringBuilder(l());
                str = "rasign=" + dx1.b().c(seconds);
            } else {
                sb = new StringBuilder(n());
                str = "rasign=" + dx1.b().d(seconds);
                str3 = "delta=payid";
            }
            sb.append("&");
            sb.append(str2);
            sb.append("&");
            sb.append(str);
            sb.append("&");
            sb.append(str3);
            return ex1.v(sb.toString());
        }
        return (String) invokeI.objValue;
    }

    public final List<ed2> i(JSONArray jSONArray) {
        InterceptResult invokeL;
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, jSONArray)) == null) {
            if (jSONArray == null || (length = jSONArray.length()) == 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList(length);
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("template_id");
                    String optString2 = optJSONObject.optString("template_title");
                    if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                        arrayList.add(new ed2(optString, optString2));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public final void o(String str, String str2, my2 my2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, str, str2, my2Var) == null) {
            ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) k74.g().postFormRequest().url(str)).cookieManager(pj2.q().a())).userAgent(y64.b().getUserAgent())).addParam("appkey", str2).build().executeAsyncOnUIBack(new b(my2Var));
        }
    }
}
