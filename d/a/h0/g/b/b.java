package d.a.h0.g.b;

import android.util.Log;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import d.a.h0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends EventTargetImpl {
    public b(d.a.h0.g.i.b bVar) {
        super(bVar);
        d.p().x(this);
    }

    public void A(int i2, String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("state", i2);
        jSONObject.put("msg", str);
        JSEvent jSEvent = new JSEvent("antiaddiction");
        jSEvent.data = jSONObject;
        if (k.f43101a) {
            Log.d("AntiAddictionApi", "result: " + jSONObject.toString());
        }
        dispatchEvent(jSEvent);
    }
}
