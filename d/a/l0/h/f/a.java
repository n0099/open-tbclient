package d.a.l0.h.f;

import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.JSEvent;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends JSEvent {

    /* renamed from: d.a.l0.h.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1078a {
        @V8JavascriptField
        public String cmd;
        @V8JavascriptField
        public String type;
    }

    public a(Object obj) {
        super("sconsoleCmdMessage", obj);
    }

    public static a a(JSONObject jSONObject) {
        C1078a c1078a = new C1078a();
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        c1078a.type = jSONObject.optString("type");
        c1078a.cmd = jSONObject.optString("cmd");
        return new a(c1078a);
    }
}
