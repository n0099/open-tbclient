package d.a.l0.h.c;

import android.util.Log;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import d.a.l0.a.k;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e extends d.a.l0.a.i1.c.e.a {

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f47184f = k.f43199a;

    /* renamed from: d  reason: collision with root package name */
    public EventTargetImpl f47185d;

    /* renamed from: e  reason: collision with root package name */
    public b f47186e;

    public e(EventTargetImpl eventTargetImpl, JSONObject jSONObject) {
        super(null, jSONObject);
        this.f47185d = eventTargetImpl;
    }

    @Override // d.a.l0.a.i1.c.e.a
    public void b(String str, JSONObject jSONObject) {
        String optString = this.f42752b.optString(str);
        b bVar = this.f47186e;
        if (bVar != null) {
            bVar.q(optString, jSONObject);
        }
        if (this.f47185d.hasEventListener(optString)) {
            JSEvent jSEvent = new JSEvent(optString);
            if (jSONObject != null) {
                jSEvent.data = jSONObject;
            }
            if (f47184f && !"onTimeUpdate".equals(str)) {
                StringBuilder sb = new StringBuilder();
                sb.append("type = ");
                sb.append(str);
                sb.append("  result = ");
                sb.append(jSONObject != null ? jSONObject.toString() : StringUtil.NULL_STRING);
                Log.d("AudioCallbackForV8", sb.toString());
            }
            this.f47185d.dispatchEvent(jSEvent);
        }
    }

    @Override // d.a.l0.a.i1.c.e.a
    public boolean c() {
        return true;
    }

    public void e(b bVar) {
        this.f47186e = bVar;
    }
}
