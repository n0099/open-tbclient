package d.a.h0.g.f;

import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.JSEvent;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends JSEvent {

    /* renamed from: d.a.h0.g.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0932a {
        @V8JavascriptField
        public String cmd;
        @V8JavascriptField
        public String type;
    }

    public a(Object obj) {
        super("sconsoleCmdMessage", obj);
    }

    public static a a(JSONObject jSONObject) {
        C0932a c0932a = new C0932a();
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        c0932a.type = jSONObject.optString("type");
        c0932a.cmd = jSONObject.optString("cmd");
        return new a(c0932a);
    }
}
