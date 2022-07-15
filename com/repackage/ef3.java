package com.repackage;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.swan.apps.model.SwanAppBearInfo;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.view.BearLayout;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidubce.services.vod.VodClient;
import java.util.LinkedHashMap;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ef3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean d;
    public transient /* synthetic */ FieldHolder $fh;
    public BearLayout a;
    public Activity b;
    public SwanAppBearInfo c;

    /* loaded from: classes6.dex */
    public class a extends ResponseCallback<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public BearLayout.d a;
        public boolean b;

        public a(ef3 ef3Var, BearLayout.d dVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ef3Var, dVar, Boolean.valueOf(z)};
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
            this.b = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(String str, int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, str, i) == null) || this.a == null) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("errno");
                if (optInt == 0) {
                    if (this.b) {
                        JSONObject optJSONObject = jSONObject.optJSONObject("data");
                        if (optJSONObject != null) {
                            JSONArray optJSONArray = optJSONObject.optJSONArray("items");
                            if (optJSONArray != null && optJSONArray.length() > 0) {
                                this.a.a(true);
                            }
                            this.a.a(false);
                        }
                    } else {
                        this.a.a(true);
                    }
                } else if (800200 == optInt) {
                    String optString = jSONObject.optString("errmsg");
                    BearLayout.d dVar = this.a;
                    dVar.b("errNo:" + optInt + ",errMsg:" + optString);
                } else {
                    BearLayout.d dVar2 = this.a;
                    dVar2.b("errNo:" + optInt);
                }
            } catch (JSONException e) {
                if (ef3.d) {
                    e.printStackTrace();
                    this.a.b(e.getMessage());
                }
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exc) == null) && ef3.d) {
                exc.printStackTrace();
                this.a.b(exc.getMessage());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public String parseResponse(Response response, int i) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, response, i)) == null) ? (response == null || response.body() == null) ? "" : response.body().string() : (String) invokeLI.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755739585, "Lcom/repackage/ef3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755739585, "Lcom/repackage/ef3;");
                return;
            }
        }
        d = rg1.a;
    }

    public ef3(Activity activity, View view2, @NonNull SwanAppBearInfo swanAppBearInfo, @IdRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, view2, swanAppBearInfo, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = activity;
        this.c = swanAppBearInfo;
        BearLayout bearLayout = (BearLayout) view2.findViewById(i);
        this.a = bearLayout;
        bearLayout.setVisibility(0);
        this.a.k(activity, swanAppBearInfo, this);
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (SwanAppNetworkUtils.i(this.b)) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("type", VodClient.PATH_MEDIA);
                linkedHashMap.put("sfrom", "searchpaws");
                linkedHashMap.put("store", "uid_cuid");
                linkedHashMap.put("source", "dusite_na_subbar");
                linkedHashMap.put("third_id", this.c.bearId);
                linkedHashMap.put("op_type", "add");
                String b = lv1.b();
                if (TextUtils.isEmpty(b)) {
                    return;
                }
                j74.g().getRequest().url(b).addUrlParams(linkedHashMap).cookieManager(oj2.q().a()).build().executeAsyncOnUIBack(new a(this, this.a.getCallback(), false));
                return;
            }
            zz2.f(this.b, R.string.obfuscated_res_0x7f0f019b).G();
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && SwanAppNetworkUtils.i(this.b)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("type", VodClient.PATH_MEDIA);
            linkedHashMap.put("sfrom", "searchpaws");
            linkedHashMap.put("store", "uid_cuid");
            linkedHashMap.put("source", "dusite_na_subbar");
            linkedHashMap.put("third_id", this.c.bearId);
            String B = oj2.o().B();
            if (TextUtils.isEmpty(B)) {
                return;
            }
            j74.g().getRequest().url(B).connectionTimeout(3000).addUrlParams(linkedHashMap).cookieManager(oj2.q().a()).build().executeAsyncOnUIBack(new a(this, this.a.getCallback(), true));
        }
    }
}
