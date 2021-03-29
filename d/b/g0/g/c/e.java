package d.b.g0.g.c;

import android.util.Log;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import d.b.g0.a.k;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e extends d.b.g0.a.b1.c.e.a {

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f47943f = k.f45051a;

    /* renamed from: d  reason: collision with root package name */
    public EventTargetImpl f47944d;

    /* renamed from: e  reason: collision with root package name */
    public b f47945e;

    public e(EventTargetImpl eventTargetImpl, JSONObject jSONObject) {
        super(null, jSONObject);
        this.f47944d = eventTargetImpl;
    }

    @Override // d.b.g0.a.b1.c.e.a
    public void b(String str, JSONObject jSONObject) {
        String optString = this.f43317b.optString(str);
        b bVar = this.f47945e;
        if (bVar != null) {
            bVar.i(optString, jSONObject);
        }
        if (this.f47944d.hasEventListener(optString)) {
            JSEvent jSEvent = new JSEvent(optString);
            if (jSONObject != null) {
                jSEvent.data = jSONObject;
            }
            if (f47943f && !"onTimeUpdate".equals(str)) {
                StringBuilder sb = new StringBuilder();
                sb.append("type = ");
                sb.append(str);
                sb.append("  result = ");
                sb.append(jSONObject != null ? jSONObject.toString() : StringUtil.NULL_STRING);
                Log.d("AudioCallbackForV8", sb.toString());
            }
            this.f47944d.dispatchEvent(jSEvent);
        }
    }

    @Override // d.b.g0.a.b1.c.e.a
    public boolean c() {
        return true;
    }

    public void e(b bVar) {
        this.f47945e = bVar;
    }
}
