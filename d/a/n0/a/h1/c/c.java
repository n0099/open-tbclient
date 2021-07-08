package d.a.n0.a.h1.c;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class c extends d.a.n0.a.c0.b.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public boolean B;
    public String C;
    public d.a.n0.a.h1.c.h.c n;
    public double o;
    public List<d.a.n0.a.h1.c.h.d> p;
    public List<d.a.n0.a.h1.c.h.f> q;
    public List<d.a.n0.a.h1.c.h.a> r;
    public List<d.a.n0.a.h1.c.h.b> s;
    public List<d.a.n0.a.h1.c.h.c> t;
    public List<d.a.n0.a.h1.c.h.e> u;
    public boolean v;
    public boolean w;
    public boolean x;
    public boolean y;
    public boolean z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c() {
        super("map", "mapId");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr = newInitContext.callArgs;
                super((String) objArr[0], (String) objArr[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = 16.0d;
        this.v = true;
        this.C = "";
    }

    @Override // d.a.n0.a.c0.b.b, d.a.n0.a.l1.a
    public void a(JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
            String str = "markers";
            if (jSONObject == null) {
                return;
            }
            super.a(jSONObject);
            if (jSONObject.has("longitude") && jSONObject.has("latitude")) {
                d.a.n0.a.h1.c.h.c cVar = new d.a.n0.a.h1.c.h.c();
                this.n = cVar;
                cVar.a(jSONObject);
            }
            if (jSONObject.has("scale")) {
                this.o = jSONObject.optDouble("scale", 16.0d);
            }
            jSONObject.optString("subkey", "");
            jSONObject.optString("layerStyle", "");
            this.C = jSONObject.optString("cb");
            this.v = jSONObject.optBoolean("showLocation", true);
            this.w = jSONObject.optBoolean("enableZoom", true);
            this.x = jSONObject.optBoolean("enableScroll", true);
            this.y = jSONObject.optBoolean("enableRotate", false);
            this.z = jSONObject.optBoolean("showCompass", false);
            this.A = jSONObject.optBoolean("enableOverlooking", false);
            this.B = jSONObject.optBoolean("enable3D", false);
            try {
                if (!jSONObject.has("markers")) {
                    str = "covers";
                }
                this.p = j(jSONObject, str, d.a.n0.a.h1.c.h.d.class);
                this.r = j(jSONObject, "circles", d.a.n0.a.h1.c.h.a.class);
                this.q = j(jSONObject, "polyline", d.a.n0.a.h1.c.h.f.class);
                this.s = j(jSONObject, "controls", d.a.n0.a.h1.c.h.b.class);
                this.t = j(jSONObject, "includePoints", d.a.n0.a.h1.c.h.c.class);
                this.u = j(jSONObject, "polygons", d.a.n0.a.h1.c.h.e.class);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public final <T extends d.a.n0.a.l1.a> List<T> j(JSONObject jSONObject, String str, Class<T> cls) throws IllegalAccessException, InstantiationException, JSONException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject, str, cls)) == null) {
            if (jSONObject.has(str)) {
                JSONArray optJSONArray = jSONObject.optJSONArray(str);
                int length = optJSONArray == null ? 0 : optJSONArray.length();
                if (length > 0) {
                    ArrayList arrayList = new ArrayList(length);
                    for (int i2 = 0; i2 < length; i2++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                        if (optJSONObject != null) {
                            T newInstance = cls.newInstance();
                            newInstance.a(optJSONObject);
                            if (newInstance.isValid()) {
                                arrayList.add(newInstance);
                            }
                        }
                    }
                    return arrayList;
                }
            }
            return null;
        }
        return (List) invokeLLL.objValue;
    }
}
