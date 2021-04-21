package d.b.h0.f.k.a;

import android.util.Log;
import d.b.h0.a.i2.y;
import d.b.h0.a.k;
import d.b.h0.a.r1.e;
import d.b.h0.a.t.e.b;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends d.b.h0.f.i.a {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f48573c = k.f45772a;

    public a() {
        super("startPermissionsPage");
    }

    @Override // d.b.h0.f.i.a
    public b a(JSONObject jSONObject, d.b.h0.a.p0.b bVar) {
        e O = e.O();
        if (O != null && O.n() != null) {
            y.g(O.n());
            bVar.a(null);
        } else if (f48573c) {
            Log.d("StartPermissionsPage", "swan or activity is null");
        }
        return null;
    }
}
