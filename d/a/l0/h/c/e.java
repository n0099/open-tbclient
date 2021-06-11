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
    public static final boolean f50858f = k.f46875a;

    /* renamed from: d  reason: collision with root package name */
    public EventTargetImpl f50859d;

    /* renamed from: e  reason: collision with root package name */
    public b f50860e;

    public e(EventTargetImpl eventTargetImpl, JSONObject jSONObject) {
        super(null, jSONObject);
        this.f50859d = eventTargetImpl;
    }

    @Override // d.a.l0.a.i1.c.e.a
    public void b(String str, JSONObject jSONObject) {
        String optString = this.f46428b.optString(str);
        b bVar = this.f50860e;
        if (bVar != null) {
            bVar.q(optString, jSONObject);
        }
        if (this.f50859d.hasEventListener(optString)) {
            JSEvent jSEvent = new JSEvent(optString);
            if (jSONObject != null) {
                jSEvent.data = jSONObject;
            }
            if (f50858f && !"onTimeUpdate".equals(str)) {
                StringBuilder sb = new StringBuilder();
                sb.append("type = ");
                sb.append(str);
                sb.append("  result = ");
                sb.append(jSONObject != null ? jSONObject.toString() : StringUtil.NULL_STRING);
                Log.d("AudioCallbackForV8", sb.toString());
            }
            this.f50859d.dispatchEvent(jSEvent);
        }
    }

    @Override // d.a.l0.a.i1.c.e.a
    public boolean c() {
        return true;
    }

    public void e(b bVar) {
        this.f50860e = bVar;
    }
}
