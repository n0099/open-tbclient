package d.a.m0.h.b;

import android.util.Log;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import d.a.m0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends EventTargetImpl {
    public b(d.a.m0.a.l0.c cVar) {
        super(cVar);
        d.p().x(this);
    }

    public void z(int i2, String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("state", i2);
        jSONObject.put("msg", str);
        JSEvent jSEvent = new JSEvent("antiaddiction");
        jSEvent.data = jSONObject;
        if (k.f46983a) {
            Log.d("AntiAddictionApi", "result: " + jSONObject.toString());
        }
        dispatchEvent(jSEvent);
    }
}
