package com.repackage;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class l73 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean j;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public JSONObject h;
    public JSONObject i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755576215, "Lcom/repackage/l73;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755576215, "Lcom/repackage/l73;");
                return;
            }
        }
        j = tg1.a;
    }

    public l73() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = "swan";
    }

    public void a(@NonNull String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, obj) == null) {
            if (this.h == null) {
                this.h = new JSONObject();
            }
            try {
                this.h.put(str, obj);
            } catch (JSONException e) {
                if (j) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void b(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        if (this.h == null) {
            this.h = new JSONObject();
        }
        JSONObject optJSONObject = this.h.optJSONObject("extlog");
        this.i = optJSONObject;
        if (optJSONObject == null) {
            this.i = new JSONObject();
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                this.i.put(next, jSONObject.opt(next));
            } catch (JSONException e) {
                if (j) {
                    e.printStackTrace();
                }
            }
        }
        try {
            this.h.put("extlog", this.i);
        } catch (JSONException e2) {
            if (j) {
                e2.printStackTrace();
            }
        }
    }

    public JSONObject c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.h == null) {
                return null;
            }
            try {
                return new JSONObject(this.h.toString());
            } catch (JSONException e) {
                if (j) {
                    e.printStackTrace();
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
        } catch (JSONException e) {
            if (j) {
                e.printStackTrace();
            }
        }
    }

    public void e(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        if (this.h == null) {
            this.h = new JSONObject();
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                this.h.put(next, jSONObject.opt(next));
            } catch (JSONException e) {
                if (j) {
                    e.printStackTrace();
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
                if (!TextUtils.isEmpty(this.a)) {
                    jSONObject.put("from", this.a);
                }
                if (!TextUtils.isEmpty(this.b)) {
                    jSONObject.put("type", this.b);
                }
                if (!TextUtils.isEmpty(this.e)) {
                    jSONObject.put("value", this.e);
                }
                if (TextUtils.isEmpty(this.c)) {
                    this.c = "NA";
                }
                jSONObject.put("source", this.c);
                if (!TextUtils.isEmpty(this.g)) {
                    String b = b73.b(this.g);
                    this.g = b;
                    jSONObject.put("page", b);
                }
                if (this.h == null) {
                    this.h = new JSONObject();
                }
                if (!TextUtils.isEmpty(this.f)) {
                    this.h.put("appid", this.f);
                }
                if (!TextUtils.isEmpty(this.d)) {
                    this.h.put("launchid", this.d);
                }
                b73.a(this.h);
                jSONObject.put("ext", this.h);
                return jSONObject;
            } catch (JSONException e) {
                if (j) {
                    e.printStackTrace();
                    return null;
                }
                return null;
            }
        }
        return (JSONObject) invokeV.objValue;
    }
}
