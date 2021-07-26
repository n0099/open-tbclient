package d.d.a.a.b;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collection;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f69579a;

    /* renamed from: b  reason: collision with root package name */
    public long f69580b;

    /* renamed from: c  reason: collision with root package name */
    public String f69581c;

    /* renamed from: d  reason: collision with root package name */
    public String f69582d;

    /* renamed from: e  reason: collision with root package name */
    public String f69583e;

    /* renamed from: f  reason: collision with root package name */
    public long f69584f;

    /* renamed from: g  reason: collision with root package name */
    public String f69585g;

    /* renamed from: h  reason: collision with root package name */
    public Map<String, Object> f69586h;

    public j() {
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

    public static j a(String str, long j, String str2, long j2, String str3, Collection<String> collection, Map<String, Object> map, String str4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{str, Long.valueOf(j), str2, Long.valueOf(j2), str3, collection, map, str4})) == null) {
            j jVar = new j();
            jVar.f69579a = str;
            jVar.f69580b = j;
            jVar.f69582d = str2;
            jVar.f69584f = j2;
            jVar.f69583e = str3;
            jVar.f69585g = str4;
            if (collection != null) {
                JSONArray jSONArray = new JSONArray();
                for (String str5 : collection) {
                    jSONArray.put(str5);
                }
                jVar.f69581c = jSONArray.toString();
            }
            if (map != null && !map.isEmpty()) {
                jVar.f69586h = map;
            }
            return jVar;
        }
        return (j) invokeCommon.objValue;
    }

    public JSONObject b() throws NullPointerException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("en", this.f69579a);
                jSONObject.put("et", this.f69580b);
                jSONObject.put("nu", this.f69584f);
                if (!TextUtils.isEmpty(this.f69582d)) {
                    jSONObject.put("eg", this.f69582d);
                }
                jSONObject.putOpt("lk", this.f69583e);
                if (this.f69581c != null) {
                    jSONObject.put("ev", this.f69581c);
                }
                if (!TextUtils.isEmpty(this.f69585g)) {
                    jSONObject.put("at", this.f69585g);
                }
                if (this.f69586h != null && !this.f69586h.isEmpty()) {
                    for (Map.Entry<String, Object> entry : this.f69586h.entrySet()) {
                        if (entry.getValue() instanceof Integer) {
                            jSONObject.put(entry.getKey(), ((Integer) entry.getValue()).intValue());
                        } else if (entry.getValue() instanceof Long) {
                            jSONObject.put(entry.getKey(), ((Long) entry.getValue()).longValue());
                        } else if (entry.getValue() instanceof Double) {
                            jSONObject.put(entry.getKey(), ((Double) entry.getValue()).doubleValue());
                        } else if (entry.getValue() instanceof Short) {
                            jSONObject.put(entry.getKey(), (int) ((Short) entry.getValue()).shortValue());
                        } else if (entry.getValue() instanceof Float) {
                            jSONObject.put(entry.getKey(), ((Float) entry.getValue()).floatValue());
                        } else if (entry.getValue() instanceof Byte) {
                            jSONObject.put(entry.getKey(), (int) ((Byte) entry.getValue()).byteValue());
                        } else if (entry.getValue() instanceof String) {
                            jSONObject.put(entry.getKey(), entry.getValue().toString());
                        }
                    }
                }
            } catch (Exception unused) {
                jSONObject = null;
            }
            if (jSONObject != null) {
                return jSONObject;
            }
            throw null;
        }
        return (JSONObject) invokeV.objValue;
    }
}
