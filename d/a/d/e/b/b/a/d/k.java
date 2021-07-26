package d.a.d.e.b.b.a.d;

import android.util.SparseArray;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class k implements h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public JSONObject f41572a;

    public k(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONObject};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f41572a = jSONObject;
    }

    @Override // d.a.d.e.b.b.a.d.h
    public Object a(d.a.d.e.b.b.a.e.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
            Class<?> a2 = cVar.a();
            Type[] b2 = cVar.b();
            if (d.a.d.e.b.a.a.e(a2, Map.class)) {
                Map<String, Object> b3 = d.a.d.e.b.b.a.e.a.b(cVar, this.f41572a.length());
                if (b3 != null) {
                    Iterator<String> keys = this.f41572a.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        if (next instanceof String) {
                            String str = next;
                            Object a3 = d.a.d.e.b.b.a.e.g.a(this.f41572a.opt(str)).a(new d.a.d.e.b.b.a.e.c(b2[1]));
                            if (a3 != null) {
                                b3.put(str, a3);
                            }
                        }
                    }
                }
                return b3;
            } else if (a2 == SparseArray.class) {
                SparseArray sparseArray = new SparseArray(this.f41572a.length());
                Iterator<String> keys2 = this.f41572a.keys();
                while (keys2.hasNext()) {
                    String next2 = keys2.next();
                    if (next2 instanceof String) {
                        String str2 = next2;
                        try {
                            int parseInt = Integer.parseInt(str2);
                            Object a4 = d.a.d.e.b.b.a.e.g.a(this.f41572a.opt(String.valueOf(str2))).a(new d.a.d.e.b.b.a.e.c(b2[0]));
                            if (a4 != null) {
                                sparseArray.put(parseInt, a4);
                            }
                        } catch (NumberFormatException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
                return sparseArray;
            } else if (d.a.d.e.b.a.a.e(a2, d.a.d.e.b.b.a.a.a.class)) {
                return OrmObject.objectWithJson(this.f41572a, a2);
            } else {
                return null;
            }
        }
        return invokeL.objValue;
    }
}
