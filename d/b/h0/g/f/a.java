package d.b.h0.g.f;

import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.JSEvent;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends JSEvent {

    /* renamed from: d.b.h0.g.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0993a {
        @V8JavascriptField
        public String cmd;
        @V8JavascriptField
        public String type;
    }

    public a(Object obj) {
        super("sconsoleCmdMessage", obj);
    }

    public static a a(JSONObject jSONObject) {
        C0993a c0993a = new C0993a();
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        c0993a.type = jSONObject.optString("type");
        c0993a.cmd = jSONObject.optString("cmd");
        return new a(c0993a);
    }
}
