package d.a.p0.j1.a.e;

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

    /* renamed from: d.a.p0.j1.a.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C1493a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f58935a;

        /* renamed from: b  reason: collision with root package name */
        public String f58936b;

        /* renamed from: c  reason: collision with root package name */
        public String f58937c;

        /* renamed from: d  reason: collision with root package name */
        public String f58938d;

        /* renamed from: e  reason: collision with root package name */
        public String f58939e;

        /* renamed from: f  reason: collision with root package name */
        public String f58940f;

        /* renamed from: g  reason: collision with root package name */
        public String f58941g;

        /* renamed from: h  reason: collision with root package name */
        public int f58942h;

        public C1493a() {
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

    public static C1493a a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            C1493a c1493a = new C1493a();
            try {
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray.length() > 0) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(0);
                    optJSONObject.optString("title");
                    c1493a.f58936b = optJSONObject.optString("content");
                    c1493a.f58937c = optJSONObject.optString("quote_content");
                    c1493a.f58938d = optJSONObject.optString("fname");
                    c1493a.f58939e = optJSONObject.optString("thread_id");
                    c1493a.f58940f = optJSONObject.optString("post_id");
                    c1493a.f58942h = optJSONObject.optInt("type");
                    c1493a.f58941g = optJSONObject.optString("title");
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
                        c1493a.f58935a = optJSONObject3.optInt("gender");
                    }
                }
                return c1493a;
            } catch (JSONException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (C1493a) invokeL.objValue;
    }
}
