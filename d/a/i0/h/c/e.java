package d.a.i0.h.c;

import android.util.Log;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import d.a.i0.a.k;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e extends d.a.i0.a.i1.c.e.a {

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f47008f = k.f43025a;

    /* renamed from: d  reason: collision with root package name */
    public EventTargetImpl f47009d;

    /* renamed from: e  reason: collision with root package name */
    public b f47010e;

    public e(EventTargetImpl eventTargetImpl, JSONObject jSONObject) {
        super(null, jSONObject);
        this.f47009d = eventTargetImpl;
    }

    @Override // d.a.i0.a.i1.c.e.a
    public void b(String str, JSONObject jSONObject) {
        String optString = this.f42578b.optString(str);
        b bVar = this.f47010e;
        if (bVar != null) {
            bVar.q(optString, jSONObject);
        }
        if (this.f47009d.hasEventListener(optString)) {
            JSEvent jSEvent = new JSEvent(optString);
            if (jSONObject != null) {
                jSEvent.data = jSONObject;
            }
            if (f47008f && !"onTimeUpdate".equals(str)) {
                StringBuilder sb = new StringBuilder();
                sb.append("type = ");
                sb.append(str);
                sb.append("  result = ");
                sb.append(jSONObject != null ? jSONObject.toString() : StringUtil.NULL_STRING);
                Log.d("AudioCallbackForV8", sb.toString());
            }
            this.f47009d.dispatchEvent(jSEvent);
        }
    }

    @Override // d.a.i0.a.i1.c.e.a
    public boolean c() {
        return true;
    }

    public void e(b bVar) {
        this.f47010e = bVar;
    }
}
