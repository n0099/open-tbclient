package d.a.q0.j1.a.e;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d.a.q0.j1.a.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C1498a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f59549a;

        /* renamed from: b  reason: collision with root package name */
        public String f59550b;

        /* renamed from: c  reason: collision with root package name */
        public String f59551c;

        /* renamed from: d  reason: collision with root package name */
        public String f59552d;

        /* renamed from: e  reason: collision with root package name */
        public String f59553e;

        /* renamed from: f  reason: collision with root package name */
        public String f59554f;

        /* renamed from: g  reason: collision with root package name */
        public String f59555g;

        /* renamed from: h  reason: collision with root package name */
        public int f59556h;

        public C1498a() {
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
    }

    public static C1498a a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            C1498a c1498a = new C1498a();
            try {
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray.length() > 0) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(0);
                    optJSONObject.optString("title");
                    c1498a.f59550b = optJSONObject.optString("content");
                    c1498a.f59551c = optJSONObject.optString("quote_content");
                    c1498a.f59552d = optJSONObject.optString("fname");
                    c1498a.f59553e = optJSONObject.optString("thread_id");
                    c1498a.f59554f = optJSONObject.optString("post_id");
                    c1498a.f59556h = optJSONObject.optInt("type");
                    c1498a.f59555g = optJSONObject.optString("title");
                    optJSONObject.optInt("thread_type");
                    JSONObject optJSONObject2 = optJSONObject.optJSONObject("quote_user");
                    if (optJSONObject2 != null) {
                        optJSONObject2.optString("id");
                        optJSONObject2.optString("portrait");
                        optJSONObject2.optInt("gender");
                    }
                    JSONObject optJSONObject3 = optJSONObject.optJSONObject("replyer");
                    if (optJSONObject3 != null) {
                        optJSONObject3.optString("id");
                        c1498a.f59549a = optJSONObject3.optInt("gender");
                    }
                }
                return c1498a;
            } catch (JSONException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (C1498a) invokeL.objValue;
    }
}
