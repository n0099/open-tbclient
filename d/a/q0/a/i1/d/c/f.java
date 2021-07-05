package d.a.q0.a.i1.d.c;

import com.alipay.sdk.widget.j;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f48813a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f48814b;

    /* renamed from: c  reason: collision with root package name */
    public String f48815c;

    /* renamed from: d  reason: collision with root package name */
    public String f48816d;

    /* renamed from: e  reason: collision with root package name */
    public int f48817e;

    public f() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f48813a = 3;
        this.f48814b = true;
        this.f48816d = j.j;
        this.f48817e = 60;
    }

    public static f a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            f fVar = new f();
            if (jSONObject != null) {
                JSONArray optJSONArray = jSONObject.optJSONArray("sourceType");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    int length = optJSONArray.length();
                    int i2 = 0;
                    for (int i3 = 0; i3 < length; i3++) {
                        String optString = optJSONArray.optString(i3);
                        char c2 = 65535;
                        int hashCode = optString.hashCode();
                        if (hashCode != -1367751899) {
                            if (hashCode == 92896879 && optString.equals("album")) {
                                c2 = 0;
                            }
                        } else if (optString.equals("camera")) {
                            c2 = 1;
                        }
                        if (c2 == 0) {
                            i2 |= 1;
                        } else if (c2 == 1) {
                            i2 |= 2;
                        }
                    }
                    fVar.f48813a = i2;
                }
                fVar.f48814b = jSONObject.optBoolean("compressed", true);
                int optInt = jSONObject.optInt("maxDuration", 60);
                fVar.f48817e = optInt <= 60 ? optInt : 60;
                fVar.f48816d = jSONObject.optString("camera");
                fVar.f48815c = jSONObject.optString("cb");
            }
            return fVar;
        }
        return (f) invokeL.objValue;
    }
}
