package d.a.o0.a.j2.p;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.adrequest.AdParamInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.j2.j;
import d.a.o0.a.k;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f46321a;

    /* renamed from: b  reason: collision with root package name */
    public String f46322b;

    /* renamed from: c  reason: collision with root package name */
    public String f46323c;

    /* renamed from: d  reason: collision with root package name */
    public String f46324d;

    /* renamed from: e  reason: collision with root package name */
    public String f46325e;

    /* renamed from: f  reason: collision with root package name */
    public String f46326f;

    /* renamed from: g  reason: collision with root package name */
    public String f46327g;

    /* renamed from: h  reason: collision with root package name */
    public JSONObject f46328h;

    /* renamed from: i  reason: collision with root package name */
    public JSONObject f46329i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2015181627, "Ld/a/o0/a/j2/p/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2015181627, "Ld/a/o0/a/j2/p/e;");
                return;
            }
        }
        j = k.f46335a;
    }

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f46321a = "swan";
    }

    public void a(@NonNull String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, obj) == null) {
            if (this.f46328h == null) {
                this.f46328h = new JSONObject();
            }
            try {
                this.f46328h.put(str, obj);
            } catch (JSONException e2) {
                if (j) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public void b(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        if (this.f46328h == null) {
            this.f46328h = new JSONObject();
        }
        JSONObject optJSONObject = this.f46328h.optJSONObject("extlog");
        this.f46329i = optJSONObject;
        if (optJSONObject == null) {
            this.f46329i = new JSONObject();
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                this.f46329i.put(next, jSONObject.opt(next));
            } catch (JSONException e2) {
                if (j) {
                    e2.printStackTrace();
                }
            }
        }
        try {
            this.f46328h.put("extlog", this.f46329i);
        } catch (JSONException e3) {
            if (j) {
                e3.printStackTrace();
            }
        }
    }

    public JSONObject c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f46328h == null) {
                return null;
            }
            try {
                return new JSONObject(this.f46328h.toString());
            } catch (JSONException e2) {
                if (j) {
                    e2.printStackTrace();
                }
                return null;
            }
        }
        return (JSONObject) invokeV.objValue;
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            e(new JSONObject(str));
        } catch (JSONException e2) {
            if (j) {
                e2.printStackTrace();
            }
        }
    }

    public void e(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        if (this.f46328h == null) {
            this.f46328h = new JSONObject();
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                this.f46328h.put(next, jSONObject.opt(next));
            } catch (JSONException e2) {
                if (j) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public JSONObject f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                if (!TextUtils.isEmpty(this.f46321a)) {
                    jSONObject.put("from", this.f46321a);
                }
                if (!TextUtils.isEmpty(this.f46322b)) {
                    jSONObject.put("type", this.f46322b);
                }
                if (!TextUtils.isEmpty(this.f46325e)) {
                    jSONObject.put("value", this.f46325e);
                }
                if (TextUtils.isEmpty(this.f46323c)) {
                    this.f46323c = AdParamInfo.AdClickActionString.AD_CLICK_ACTION_NA;
                }
                jSONObject.put("source", this.f46323c);
                if (!TextUtils.isEmpty(this.f46327g)) {
                    String a2 = j.a(this.f46327g);
                    this.f46327g = a2;
                    jSONObject.put("page", a2);
                }
                if (this.f46328h == null) {
                    this.f46328h = new JSONObject();
                }
                if (!TextUtils.isEmpty(this.f46326f)) {
                    this.f46328h.put("appid", this.f46326f);
                }
                if (!TextUtils.isEmpty(this.f46324d)) {
                    this.f46328h.put("launchid", this.f46324d);
                }
                jSONObject.put("ext", this.f46328h);
                return jSONObject;
            } catch (JSONException e2) {
                if (j) {
                    e2.printStackTrace();
                    return null;
                }
                return null;
            }
        }
        return (JSONObject) invokeV.objValue;
    }
}
