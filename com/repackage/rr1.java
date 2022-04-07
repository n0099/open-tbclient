package com.repackage;

import android.content.Context;
import android.text.TextUtils;
import android.util.ArrayMap;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.request.task.ProgressInfo;
import com.baidu.mobstat.Config;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.storage.PathType;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class rr1 extends ir1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements cf3<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ArrayMap a;
        public final /* synthetic */ JSONArray b;
        public final /* synthetic */ JSONArray c;
        public final /* synthetic */ JSONArray d;
        public final /* synthetic */ JSONObject e;
        public final /* synthetic */ rr1 f;

        public a(rr1 rr1Var, ArrayMap arrayMap, JSONArray jSONArray, JSONArray jSONArray2, JSONArray jSONArray3, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rr1Var, arrayMap, jSONArray, jSONArray2, jSONArray3, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = rr1Var;
            this.a = arrayMap;
            this.b = jSONArray;
            this.c = jSONArray2;
            this.d = jSONArray3;
            this.e = jSONObject;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.cf3
        /* renamed from: a */
        public void onCallback(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || TextUtils.isEmpty(str)) {
                return;
            }
            JSONArray jSONArray = null;
            try {
                jSONArray = new JSONArray(str);
            } catch (JSONException unused) {
            }
            if (jSONArray == null || jSONArray.length() <= 0) {
                return;
            }
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                String optString = optJSONObject.optString("fileID");
                String optString2 = optJSONObject.optString("tempFileURL");
                if (optJSONObject.optString("status").equals("0") && !TextUtils.isEmpty(optString2)) {
                    this.a.put(optString, optString2);
                }
            }
            this.f.G(this.a, this.b, "images");
            this.f.G(this.a, this.c, "urls");
            this.f.G(this.a, this.d, "url");
            try {
                this.e.put("images", this.b);
                this.e.put("urls", this.c);
                this.e.put("url", this.d);
            } catch (JSONException unused2) {
            }
            SwanAppActivity activity = wl2.U().getActivity();
            if (activity == null) {
                qj2.C().b(this.f.getContext(), this.e);
            } else {
                qj2.C().b(activity, this.e);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rr1(@NonNull ko1 ko1Var) {
        super(ko1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ko1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((ko1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final String A(JSONArray jSONArray, String str, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048576, this, jSONArray, str, i)) == null) {
            if (str.equals("images")) {
                return jSONArray.optJSONObject(i).optString("url");
            }
            return jSONArray.optString(i);
        }
        return (String) invokeLLI.objValue;
    }

    public js1 B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#handlePreviewImage", false);
            if (n()) {
                jx1.c("PreviewImageApi", "PreviewImageApi does not supported when app is invisible.");
                return new js1(1001, "PreviewImageApi does not supported when app is invisible.");
            } else if (TextUtils.isEmpty(str)) {
                return new js1(202);
            } else {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.optBoolean("only_support_wifi") && !SwanAppNetworkUtils.j(getContext())) {
                        return new js1(403);
                    }
                    String optString = jSONObject.optString("source", "unitedscheme");
                    String optString2 = jSONObject.optString("type", "0");
                    JSONArray optJSONArray = jSONObject.optJSONArray("urls");
                    if (optJSONArray != null && optJSONArray.length() != 0) {
                        JSONArray optJSONArray2 = jSONObject.optJSONArray("images");
                        if (optJSONArray2 != null) {
                            F(optJSONArray2);
                            jSONObject.put("images", optJSONArray2);
                        } else {
                            JSONArray jSONArray = new JSONArray();
                            int length = optJSONArray.length();
                            for (int i = 0; i < length; i++) {
                                JSONObject jSONObject2 = new JSONObject();
                                String optString3 = optJSONArray.optString(i);
                                jSONObject2.put("url", optString3);
                                String b = qd3.b();
                                if (qd3.c(optString3) && !TextUtils.isEmpty(b)) {
                                    jSONObject2.put(Config.LAUNCH_REFERER, b);
                                }
                                String g0 = d72.U().g0();
                                if (!TextUtils.isEmpty(g0)) {
                                    jSONObject2.put(HttpRequest.USER_AGENT, g0);
                                }
                                jSONArray.put(jSONObject2);
                            }
                            jSONObject.put("images", jSONArray);
                        }
                        if (TextUtils.equals(optString, "swan")) {
                            C(optJSONArray);
                        }
                        jSONObject.put("url", optJSONArray);
                        jSONObject.put("type", optString2);
                        int z = z(jSONObject, optJSONArray);
                        if (z >= 0 && z < optJSONArray.length()) {
                            jSONObject.put("index", String.valueOf(z));
                            ArrayMap<String, String> arrayMap = new ArrayMap<>();
                            JSONArray optJSONArray3 = jSONObject.optJSONArray("images");
                            JSONArray optJSONArray4 = jSONObject.optJSONArray("urls");
                            JSONArray optJSONArray5 = jSONObject.optJSONArray("url");
                            D(arrayMap, optJSONArray3, "images");
                            D(arrayMap, optJSONArray4, "urls");
                            D(arrayMap, optJSONArray5, "url");
                            if (arrayMap.keySet().size() > 0) {
                                E(jSONObject, arrayMap, optJSONArray3, optJSONArray4, optJSONArray5);
                            } else {
                                Context activity = wl2.U().getActivity();
                                if (activity != null) {
                                    qj2.C().b(activity, jSONObject);
                                } else {
                                    qj2.C().b(getContext(), jSONObject);
                                }
                            }
                            return js1.f();
                        }
                        return new js1(202);
                    }
                    return new js1(202);
                } catch (JSONException unused) {
                    return new js1(202);
                }
            }
        }
        return (js1) invokeL.objValue;
    }

    public final JSONArray C(JSONArray jSONArray) {
        InterceptResult invokeL;
        j03 L;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONArray)) == null) {
            int length = jSONArray.length();
            if (jSONArray != null && length > 0 && (L = j03.L()) != null && !TextUtils.isEmpty(L.b) && !TextUtils.isEmpty(L.j0())) {
                for (int i = 0; i < length; i++) {
                    try {
                        String optString = jSONArray.optString(i);
                        PathType s = r73.s(optString);
                        if (s == PathType.BD_FILE) {
                            optString = r73.M(optString, L.b);
                        } else if (s == PathType.RELATIVE) {
                            optString = r73.L(optString, L, L.j0());
                        }
                        if (!TextUtils.isEmpty(optString)) {
                            jSONArray.put(i, optString);
                        }
                    } catch (JSONException unused) {
                    }
                }
            }
            return jSONArray;
        }
        return (JSONArray) invokeL.objValue;
    }

    public final void D(ArrayMap<String, String> arrayMap, JSONArray jSONArray, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048579, this, arrayMap, jSONArray, str) == null) || jSONArray == null || jSONArray.length() <= 0) {
            return;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            String A = A(jSONArray, str, i);
            if (!TextUtils.isEmpty(A) && r73.s(A) == PathType.CLOUD) {
                arrayMap.put(A, A);
            }
        }
    }

    public final void E(JSONObject jSONObject, ArrayMap<String, String> arrayMap, JSONArray jSONArray, JSONArray jSONArray2, JSONArray jSONArray3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLLL(1048580, this, jSONObject, arrayMap, jSONArray, jSONArray2, jSONArray3) == null) || jSONObject == null || arrayMap == null || arrayMap.keySet().size() <= 0) {
            return;
        }
        JSONArray jSONArray4 = new JSONArray();
        for (String str : arrayMap.values()) {
            jSONArray4.put(str);
        }
        rk1 l = qj2.l();
        if (l == null) {
            return;
        }
        l.c(getContext(), jSONArray4, new a(this, arrayMap, jSONArray, jSONArray2, jSONArray3, jSONObject));
    }

    public final void F(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, jSONArray) == null) {
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                try {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        String optString = optJSONObject.optString("url");
                        String b = qd3.b();
                        if (qd3.c(optString) && !TextUtils.isEmpty(b)) {
                            optJSONObject.put(Config.LAUNCH_REFERER, b);
                        }
                        String g0 = d72.U().g0();
                        if (!TextUtils.isEmpty(g0)) {
                            optJSONObject.put(HttpRequest.USER_AGENT, g0);
                        }
                    }
                } catch (JSONException unused) {
                    return;
                }
            }
        }
    }

    public final void G(ArrayMap<String, String> arrayMap, JSONArray jSONArray, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048582, this, arrayMap, jSONArray, str) == null) || arrayMap == null || jSONArray == null || jSONArray.length() <= 0) {
            return;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            String str2 = arrayMap.get(A(jSONArray, str, i));
            if (!TextUtils.isEmpty(str2)) {
                try {
                    if (str.equals("images")) {
                        jSONArray.optJSONObject(i).put("url", str2);
                    } else {
                        jSONArray.put(i, str2);
                    }
                } catch (JSONException unused) {
                }
            }
        }
    }

    @Override // com.repackage.mo1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? "PreviewImageApi" : (String) invokeV.objValue;
    }

    public final int z(@NonNull JSONObject jSONObject, @NonNull JSONArray jSONArray) throws JSONException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject, jSONArray)) == null) {
            int optInt = jSONObject.optInt(ProgressInfo.JSON_KEY_CURRENT, -1);
            if (optInt >= 0) {
                return optInt;
            }
            String optString = jSONObject.optString(ProgressInfo.JSON_KEY_CURRENT);
            if (TextUtils.isEmpty(optString)) {
                return 0;
            }
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                if (TextUtils.equals(optString, jSONArray.getString(i))) {
                    return i;
                }
            }
            return -1;
        }
        return invokeLL.intValue;
    }
}
