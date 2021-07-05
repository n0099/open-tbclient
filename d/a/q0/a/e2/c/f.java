package d.a.q0.a.e2.c;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.WebGLImageLoader;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.heytap.mcssdk.mode.Message;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public JSONObject f47628a;

    /* renamed from: b  reason: collision with root package name */
    public final String f47629b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f47630c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f47631d;

    /* renamed from: e  reason: collision with root package name */
    public String f47632e;

    /* renamed from: f  reason: collision with root package name */
    public String f47633f;

    /* renamed from: g  reason: collision with root package name */
    public String f47634g;

    /* renamed from: h  reason: collision with root package name */
    public List<String> f47635h;

    /* renamed from: i  reason: collision with root package name */
    public final List<String> f47636i;
    public int j;
    public String k;
    public String l;
    public String m;
    public a n;
    public JSONObject o;
    public String p;
    public String q;
    public String r;
    public List<f> s;

    /* loaded from: classes8.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f47637a;

        /* renamed from: b  reason: collision with root package name */
        public String f47638b;

        /* renamed from: c  reason: collision with root package name */
        public String f47639c;

        /* renamed from: d  reason: collision with root package name */
        public String f47640d;

        /* renamed from: e  reason: collision with root package name */
        public String f47641e;

        /* renamed from: f  reason: collision with root package name */
        public JSONArray f47642f;

        public a() {
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

    public f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f47632e = "";
        this.f47633f = "";
        this.f47634g = "";
        this.f47635h = new ArrayList();
        this.f47636i = new ArrayList();
        this.j = -1;
        this.k = "";
        this.l = "";
        this.m = "";
        this.f47629b = str;
    }

    public static f d(String str, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, jSONObject)) == null) {
            f fVar = new f(str);
            fVar.f47628a = jSONObject;
            fVar.f47630c = jSONObject.optBoolean("permit", false);
            fVar.f47631d = jSONObject.optBoolean("forbidden", true);
            fVar.f47632e = jSONObject.optString("grade");
            fVar.k = jSONObject.optString("type", "");
            fVar.f47633f = jSONObject.optString("name", "");
            fVar.f47634g = jSONObject.optString("short_name", "");
            jSONObject.optString("description", "");
            fVar.j = jSONObject.optInt("tip_status", -1);
            fVar.l = jSONObject.optString("explain", "");
            fVar.m = jSONObject.optString("sub_explain", "");
            JSONArray optJSONArray = jSONObject.optJSONArray("ext");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    fVar.f47636i.add(optJSONArray.optString(i2));
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray(Message.RULE);
            if (optJSONArray2 != null) {
                int length2 = optJSONArray2.length();
                for (int i3 = 0; i3 < length2; i3++) {
                    fVar.f47635h.add(optJSONArray2.optString(i3));
                }
            }
            fVar.o = jSONObject.optJSONObject("other");
            fVar.p = jSONObject.optString("plugin_app_name");
            fVar.q = jSONObject.optString("plugin_icon_url");
            if (!jSONObject.has("forbidden")) {
                d.a.q0.a.e0.d.h("SwanAppUpdateManager", "scope:" + str + WebGLImageLoader.DATA_URL + jSONObject);
            }
            return fVar;
        }
        return (f) invokeLL.objValue;
    }

    public static f e(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            String optString = jSONObject.optString("id", "");
            if (TextUtils.isEmpty(optString)) {
                return null;
            }
            return d(optString, jSONObject);
        }
        return (f) invokeL.objValue;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.j > 0 : invokeV.booleanValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.j != 0 : invokeV.booleanValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "1".equals(this.k) : invokeV.booleanValue;
    }

    public void f() {
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (jSONObject = this.o) == null || jSONObject.keys() == null || !this.o.keys().hasNext()) {
            return;
        }
        a aVar = new a();
        this.n = aVar;
        aVar.f47637a = this.o.optString("detail_text");
        this.n.f47639c = this.o.optString("detail_url");
        this.n.f47638b = this.o.optString("text_color");
        this.n.f47640d = this.o.optString("keyword");
        this.n.f47641e = this.o.optString("key_color");
        JSONObject optJSONObject = this.o.optJSONObject("developer_agreements");
        if (optJSONObject != null) {
            this.n.f47642f = optJSONObject.optJSONArray("details");
        }
    }

    public void g(List<f> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            this.s = list;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? String.format(Locale.getDefault(), "Scope(%s) tipStatus=%d", this.f47629b, Integer.valueOf(this.j)) : (String) invokeV.objValue;
    }
}
