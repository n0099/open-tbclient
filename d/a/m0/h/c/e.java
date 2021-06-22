package d.a.m0.h.c;

import android.util.Log;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import d.a.m0.a.k;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e extends d.a.m0.a.i1.c.e.a {

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f50966f = k.f46983a;

    /* renamed from: d  reason: collision with root package name */
    public EventTargetImpl f50967d;

    /* renamed from: e  reason: collision with root package name */
    public b f50968e;

    public e(EventTargetImpl eventTargetImpl, JSONObject jSONObject) {
        super(null, jSONObject);
        this.f50967d = eventTargetImpl;
    }

    @Override // d.a.m0.a.i1.c.e.a
    public void b(String str, JSONObject jSONObject) {
        String optString = this.f46536b.optString(str);
        b bVar = this.f50968e;
        if (bVar != null) {
            bVar.q(optString, jSONObject);
        }
        if (this.f50967d.hasEventListener(optString)) {
            JSEvent jSEvent = new JSEvent(optString);
            if (jSONObject != null) {
                jSEvent.data = jSONObject;
            }
            if (f50966f && !"onTimeUpdate".equals(str)) {
                StringBuilder sb = new StringBuilder();
                sb.append("type = ");
                sb.append(str);
                sb.append("  result = ");
                sb.append(jSONObject != null ? jSONObject.toString() : StringUtil.NULL_STRING);
                Log.d("AudioCallbackForV8", sb.toString());
            }
            this.f50967d.dispatchEvent(jSEvent);
        }
    }

    @Override // d.a.m0.a.i1.c.e.a
    public boolean c() {
        return true;
    }

    public void e(b bVar) {
        this.f50968e = bVar;
    }
}
