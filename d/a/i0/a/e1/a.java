package d.a.i0.a.e1;

import androidx.annotation.NonNull;
import com.baidu.mobads.container.util.XAdRemoteEvent;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a implements b {
    @Override // d.a.i0.a.e1.b
    @NonNull
    public String a() {
        return SchemeCollecter.CLASSIFY_SWAN_V8;
    }

    @Override // d.a.i0.a.e1.b
    @NonNull
    public JSONObject b(@NonNull JSONObject jSONObject) {
        try {
            jSONObject.put("invoke", "swan.method.v8BindingObject");
            jSONObject.put("method", "_naSwan.naRequest");
            JSONArray optJSONArray = jSONObject.optJSONArray("args");
            if (optJSONArray != null) {
                List asList = Arrays.asList("cb", "ping", "__requestDataType__");
                for (int length = optJSONArray.length() - 1; length >= 0; length--) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(length);
                    if (optJSONObject != null && asList.contains(optJSONObject.optString("name"))) {
                        optJSONArray.remove(length);
                    }
                }
                optJSONArray.put(d("success", "function="));
                optJSONArray.put(d("fail", "function="));
                optJSONArray.put(d(XAdRemoteEvent.COMPLETE, "function="));
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    @Override // d.a.i0.a.e1.b
    @NonNull
    public String c() {
        return "request";
    }

    public final JSONObject d(@NonNull String str, @NonNull String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", str);
            jSONObject.put("value", str2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }
}
