package d.a.l0.a.j1;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.core.container.NgWebView;
import d.a.l0.a.a2.e;
import d.a.l0.a.g1.f;
import d.a.l0.a.h;
import d.a.l0.a.p.d.d1;
import d.a.l0.a.u.c.d;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends d {
    public b(@NonNull d.a.l0.a.u.c.b bVar) {
        super(bVar);
    }

    public d.a.l0.a.u.h.b r(String str) {
        if (d.f48486c) {
            Log.d("Api-callImageMenu", "handle: callImageMenu");
        }
        if (e.Q() == null) {
            return new d.a.l0.a.u.h.b(1001, "null swan runtime");
        }
        Pair<d.a.l0.a.u.h.b, JSONObject> b2 = d.a.l0.a.u.i.b.b("Api-callImageMenu", str);
        d.a.l0.a.u.h.b bVar = (d.a.l0.a.u.h.b) b2.first;
        if (!bVar.isSuccess()) {
            if (d.f48486c) {
                d.a.l0.a.e0.d.b("Api-callImageMenu", "parse fail");
            }
            return bVar;
        }
        String optString = ((JSONObject) b2.second).optString("imageURL");
        if (TextUtils.isEmpty(optString)) {
            return new d.a.l0.a.u.h.b(202, d.a.l0.a.c1.a.b().getString(h.united_scheme_err_message_params_parse_fail));
        }
        return s(optString);
    }

    public d.a.l0.a.u.h.b s(String str) {
        d.a.l0.a.p.e.c h2 = f.V().h();
        if (!(h2 instanceof NgWebView)) {
            return new d.a.l0.a.u.h.b(1001, "call image menu fail");
        }
        d1 t0 = d.a.l0.a.c1.a.t0();
        if (t0 == null) {
            return new d.a.l0.a.u.h.b(1001, "call image menu fail");
        }
        t0.b((NgWebView) h2, str);
        return new d.a.l0.a.u.h.b(0);
    }
}
