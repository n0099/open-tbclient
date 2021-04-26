package d.a.h0.g.c;

import android.util.Log;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import d.a.h0.a.k;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e extends d.a.h0.a.b1.c.e.a {

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f46130f = k.f43101a;

    /* renamed from: d  reason: collision with root package name */
    public EventTargetImpl f46131d;

    /* renamed from: e  reason: collision with root package name */
    public b f46132e;

    public e(EventTargetImpl eventTargetImpl, JSONObject jSONObject) {
        super(null, jSONObject);
        this.f46131d = eventTargetImpl;
    }

    @Override // d.a.h0.a.b1.c.e.a
    public void b(String str, JSONObject jSONObject) {
        String optString = this.f41311b.optString(str);
        b bVar = this.f46132e;
        if (bVar != null) {
            bVar.r(optString, jSONObject);
        }
        if (this.f46131d.hasEventListener(optString)) {
            JSEvent jSEvent = new JSEvent(optString);
            if (jSONObject != null) {
                jSEvent.data = jSONObject;
            }
            if (f46130f && !"onTimeUpdate".equals(str)) {
                StringBuilder sb = new StringBuilder();
                sb.append("type = ");
                sb.append(str);
                sb.append("  result = ");
                sb.append(jSONObject != null ? jSONObject.toString() : StringUtil.NULL_STRING);
                Log.d("AudioCallbackForV8", sb.toString());
            }
            this.f46131d.dispatchEvent(jSEvent);
        }
    }

    @Override // d.a.h0.a.b1.c.e.a
    public boolean c() {
        return true;
    }

    public void e(b bVar) {
        this.f46132e = bVar;
    }
}
