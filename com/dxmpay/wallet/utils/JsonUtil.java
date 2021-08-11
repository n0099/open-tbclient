package com.dxmpay.wallet.utils;

import android.text.TextUtils;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.apollon.restnet.RestNameValuePair;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class JsonUtil {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public JsonUtil() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static List<RestNameValuePair> json2KeyValuePairs(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            try {
                JSONObject jSONObject = new JSONObject(str);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    arrayList.add(new RestNameValuePair(next, jSONObject.optString(next)));
                }
                return arrayList;
            } catch (Exception unused) {
                return null;
            }
        }
        return (List) invokeL.objValue;
    }

    public static void jsonStringToNameValuePairList(String str, List<PassNameValuePair> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65538, null, str, list) == null) || TextUtils.isEmpty(str) || list == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                list.add(new PassNameValuePair(next, jSONObject.optString(next)));
            }
        } catch (JSONException e2) {
            e2.getMessage();
        }
    }

    public static String jsonToURLParams(JSONObject jSONObject, boolean z) throws JSONException {
        InterceptResult invokeLZ;
        Object obj;
        Object obj2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65539, null, jSONObject, z)) == null) {
            StringBuilder sb = new StringBuilder();
            if (jSONObject != null) {
                JSONArray names = jSONObject.names();
                if (names == null) {
                    return null;
                }
                for (int i2 = 0; i2 < names.length(); i2++) {
                    if (names.get(i2) != null && (names.get(i2) instanceof String)) {
                        StringBuilder sb2 = new StringBuilder((String) names.get(i2));
                        if (!TextUtils.isEmpty(sb2)) {
                            if (jSONObject.get(sb2.toString()) instanceof JSONObject) {
                                jsonToURLParams(new JSONObject(sb2.toString()), z);
                            }
                            try {
                                StringBuilder sb3 = new StringBuilder(z ? URLEncoder.encode(sb2.toString(), "gbk") : sb2);
                                if (jSONObject.get(sb2.toString()) != null && (jSONObject.get(sb2.toString()) instanceof String)) {
                                    if (i2 < names.length() - 1) {
                                        sb3.append("=");
                                        if (z) {
                                            obj2 = URLEncoder.encode(jSONObject.get(sb2.toString()).toString(), "gbk");
                                        } else {
                                            obj2 = jSONObject.get(sb2.toString());
                                        }
                                        sb3.append(obj2);
                                        sb3.append("&");
                                        sb.append((CharSequence) sb3);
                                    } else {
                                        sb3.append("=");
                                        if (z) {
                                            obj = URLEncoder.encode(jSONObject.get(sb2.toString()).toString(), "gbk");
                                        } else {
                                            obj = jSONObject.get(sb2.toString());
                                        }
                                        sb3.append(obj);
                                        sb.append((CharSequence) sb3);
                                    }
                                }
                            } catch (UnsupportedEncodingException e2) {
                                e2.printStackTrace();
                            } catch (JSONException e3) {
                                e3.printStackTrace();
                            }
                        }
                    }
                }
            }
            return sb.toString();
        }
        return (String) invokeLZ.objValue;
    }
}
