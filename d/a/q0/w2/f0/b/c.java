package d.a.q0.w2.f0.b;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f66585a;

    /* renamed from: b  reason: collision with root package name */
    public double f66586b;

    /* renamed from: c  reason: collision with root package name */
    public List<String> f66587c;

    /* renamed from: d  reason: collision with root package name */
    public int f66588d;

    /* renamed from: e  reason: collision with root package name */
    public int f66589e;

    public c() {
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

    public static c a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            c cVar = new c();
            cVar.f66585a = jSONObject.optInt("label_measure") == 2;
            cVar.f66586b = jSONObject.optDouble("show_width_scale", 1.0d);
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("thread_pic_list");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                    if (optJSONObject != null) {
                        d.a.q0.n1.o.k.a.a(arrayList, optJSONObject.optString("pic"));
                    }
                }
            }
            cVar.f66587c = arrayList;
            cVar.f66588d = jSONObject.optInt("width");
            cVar.f66589e = jSONObject.optInt("height");
            return cVar;
        }
        return (c) invokeL.objValue;
    }
}
