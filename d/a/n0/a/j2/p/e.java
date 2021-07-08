package d.a.n0.a.j2.p;

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
import d.a.n0.a.j2.j;
import d.a.n0.a.k;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f45817a;

    /* renamed from: b  reason: collision with root package name */
    public String f45818b;

    /* renamed from: c  reason: collision with root package name */
    public String f45819c;

    /* renamed from: d  reason: collision with root package name */
    public String f45820d;

    /* renamed from: e  reason: collision with root package name */
    public String f45821e;

    /* renamed from: f  reason: collision with root package name */
    public String f45822f;

    /* renamed from: g  reason: collision with root package name */
    public String f45823g;

    /* renamed from: h  reason: collision with root package name */
    public JSONObject f45824h;

    /* renamed from: i  reason: collision with root package name */
    public JSONObject f45825i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2144264346, "Ld/a/n0/a/j2/p/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2144264346, "Ld/a/n0/a/j2/p/e;");
                return;
            }
        }
        j = k.f45831a;
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
        this.f45817a = "swan";
    }

    public void a(@NonNull String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, obj) == null) {
            if (this.f45824h == null) {
                this.f45824h = new JSONObject();
            }
            try {
                this.f45824h.put(str, obj);
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
        if (this.f45824h == null) {
            this.f45824h = new JSONObject();
        }
        JSONObject optJSONObject = this.f45824h.optJSONObject("extlog");
        this.f45825i = optJSONObject;
        if (optJSONObject == null) {
            this.f45825i = new JSONObject();
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                this.f45825i.put(next, jSONObject.opt(next));
            } catch (JSONException e2) {
                if (j) {
                    e2.printStackTrace();
                }
            }
        }
        try {
            this.f45824h.put("extlog", this.f45825i);
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
            if (this.f45824h == null) {
                return null;
            }
            try {
                return new JSONObject(this.f45824h.toString());
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
        if (this.f45824h == null) {
            this.f45824h = new JSONObject();
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                this.f45824h.put(next, jSONObject.opt(next));
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
                if (!TextUtils.isEmpty(this.f45817a)) {
                    jSONObject.put("from", this.f45817a);
                }
                if (!TextUtils.isEmpty(this.f45818b)) {
                    jSONObject.put("type", this.f45818b);
                }
                if (!TextUtils.isEmpty(this.f45821e)) {
                    jSONObject.put("value", this.f45821e);
                }
                if (TextUtils.isEmpty(this.f45819c)) {
                    this.f45819c = AdParamInfo.AdClickActionString.AD_CLICK_ACTION_NA;
                }
                jSONObject.put("source", this.f45819c);
                if (!TextUtils.isEmpty(this.f45823g)) {
                    String a2 = j.a(this.f45823g);
                    this.f45823g = a2;
                    jSONObject.put("page", a2);
                }
                if (this.f45824h == null) {
                    this.f45824h = new JSONObject();
                }
                if (!TextUtils.isEmpty(this.f45822f)) {
                    this.f45824h.put("appid", this.f45822f);
                }
                if (!TextUtils.isEmpty(this.f45820d)) {
                    this.f45824h.put("launchid", this.f45820d);
                }
                jSONObject.put("ext", this.f45824h);
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
