package com.huawei.hms.hatool;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.UnsupportedEncodingException;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class r implements s {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<q> a;
    public o b;
    public p c;
    public s d;
    public String e;
    public String f;

    public r(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = "";
        this.f = str;
    }

    @Override // com.huawei.hms.hatool.s
    public JSONObject a() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            List<q> list = this.a;
            if (list == null || list.size() == 0) {
                str = "Not have actionEvent to send";
            } else if (this.b == null || this.c == null || this.d == null) {
                str = "model in wrong format";
            } else {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("header", this.b.a());
                JSONObject jSONObject2 = new JSONObject();
                JSONObject a = this.d.a();
                a.put("properties", this.c.a());
                try {
                    a.put("events_global_properties", new JSONObject(this.e));
                } catch (JSONException unused) {
                    a.put("events_global_properties", this.e);
                }
                jSONObject2.put("events_common", a);
                JSONArray jSONArray = new JSONArray();
                for (q qVar : this.a) {
                    JSONObject a2 = qVar.a();
                    if (a2 != null) {
                        jSONArray.put(a2);
                    } else {
                        y.e("hmsSdk", "custom event is empty,delete this event");
                    }
                }
                jSONObject2.put("events", jSONArray);
                try {
                    String a3 = d.a(t0.a(jSONObject2.toString().getBytes("UTF-8")), this.f);
                    if (TextUtils.isEmpty(a3)) {
                        y.e("hmsSdk", "eventInfo encrypt failed,report over!");
                        return null;
                    }
                    jSONObject.put("event", a3);
                    return jSONObject;
                } catch (UnsupportedEncodingException unused2) {
                    str = "getBitZip(): Unsupported coding : utf-8";
                }
            }
            y.e("hmsSdk", str);
            return null;
        }
        return (JSONObject) invokeV.objValue;
    }

    public void a(e1 e1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, e1Var) == null) {
            this.d = e1Var;
        }
    }

    public void a(o oVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, oVar) == null) {
            this.b = oVar;
        }
    }

    public void a(p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, pVar) == null) {
            this.c = pVar;
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || str == null) {
            return;
        }
        this.e = str;
    }

    public void a(List<q> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            this.a = list;
        }
    }
}
