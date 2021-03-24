package d.b.g0.g.f;

import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.JSEvent;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends JSEvent {

    /* renamed from: d.b.g0.g.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0960a {
        @V8JavascriptField
        public String cmd;
        @V8JavascriptField
        public String type;
    }

    public a(Object obj) {
        super("sconsoleCmdMessage", obj);
    }

    public static a a(JSONObject jSONObject) {
        C0960a c0960a = new C0960a();
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        c0960a.type = jSONObject.optString("type");
        c0960a.cmd = jSONObject.optString("cmd");
        return new a(c0960a);
    }
}
