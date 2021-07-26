package d.a.q0.v.d.f.c;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.p0.s.q.b2;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f65155a;

    /* renamed from: b  reason: collision with root package name */
    public String f65156b;

    /* renamed from: c  reason: collision with root package name */
    public List<b2> f65157c;

    /* renamed from: d  reason: collision with root package name */
    public int f65158d;

    /* renamed from: e  reason: collision with root package name */
    public int f65159e;

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

    public void a(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.f65155a = jSONObject.optString("head_pic");
        jSONObject.optString("url_type");
        this.f65156b = jSONObject.optString("url");
        this.f65158d = jSONObject.optInt("head_type", 0);
        this.f65159e = jSONObject.optInt("is_set", -1);
        JSONArray optJSONArray = jSONObject.optJSONArray("head_thread");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            return;
        }
        this.f65157c = new ArrayList(optJSONArray.length());
        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
            JSONObject jSONObject2 = (JSONObject) optJSONArray.opt(i2);
            if (jSONObject2 != null) {
                b2 b2Var = new b2();
                b2Var.J2(jSONObject2);
                this.f65157c.add(b2Var);
            }
        }
    }
}
