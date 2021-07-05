package d.a.q0.a.j2.p;

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
import d.a.q0.a.j2.j;
import d.a.q0.a.k;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f49119a;

    /* renamed from: b  reason: collision with root package name */
    public String f49120b;

    /* renamed from: c  reason: collision with root package name */
    public String f49121c;

    /* renamed from: d  reason: collision with root package name */
    public String f49122d;

    /* renamed from: e  reason: collision with root package name */
    public String f49123e;

    /* renamed from: f  reason: collision with root package name */
    public String f49124f;

    /* renamed from: g  reason: collision with root package name */
    public String f49125g;

    /* renamed from: h  reason: collision with root package name */
    public JSONObject f49126h;

    /* renamed from: i  reason: collision with root package name */
    public JSONObject f49127i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1757016189, "Ld/a/q0/a/j2/p/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1757016189, "Ld/a/q0/a/j2/p/e;");
                return;
            }
        }
        j = k.f49133a;
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
        this.f49119a = "swan";
    }

    public void a(@NonNull String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, obj) == null) {
            if (this.f49126h == null) {
                this.f49126h = new JSONObject();
            }
            try {
                this.f49126h.put(str, obj);
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
        if (this.f49126h == null) {
            this.f49126h = new JSONObject();
        }
        JSONObject optJSONObject = this.f49126h.optJSONObject("extlog");
        this.f49127i = optJSONObject;
        if (optJSONObject == null) {
            this.f49127i = new JSONObject();
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                this.f49127i.put(next, jSONObject.opt(next));
            } catch (JSONException e2) {
                if (j) {
                    e2.printStackTrace();
                }
            }
        }
        try {
            this.f49126h.put("extlog", this.f49127i);
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
            if (this.f49126h == null) {
                return null;
            }
            try {
                return new JSONObject(this.f49126h.toString());
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
        if (this.f49126h == null) {
            this.f49126h = new JSONObject();
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                this.f49126h.put(next, jSONObject.opt(next));
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
                if (!TextUtils.isEmpty(this.f49119a)) {
                    jSONObject.put("from", this.f49119a);
                }
                if (!TextUtils.isEmpty(this.f49120b)) {
                    jSONObject.put("type", this.f49120b);
                }
                if (!TextUtils.isEmpty(this.f49123e)) {
                    jSONObject.put("value", this.f49123e);
                }
                if (TextUtils.isEmpty(this.f49121c)) {
                    this.f49121c = AdParamInfo.AdClickActionString.AD_CLICK_ACTION_NA;
                }
                jSONObject.put("source", this.f49121c);
                if (!TextUtils.isEmpty(this.f49125g)) {
                    String a2 = j.a(this.f49125g);
                    this.f49125g = a2;
                    jSONObject.put("page", a2);
                }
                if (this.f49126h == null) {
                    this.f49126h = new JSONObject();
                }
                if (!TextUtils.isEmpty(this.f49124f)) {
                    this.f49126h.put("appid", this.f49124f);
                }
                if (!TextUtils.isEmpty(this.f49122d)) {
                    this.f49126h.put("launchid", this.f49122d);
                }
                jSONObject.put("ext", this.f49126h);
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
