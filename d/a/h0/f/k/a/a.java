package d.a.h0.f.k.a;

import android.util.Log;
import d.a.h0.a.i2.y;
import d.a.h0.a.k;
import d.a.h0.a.r1.e;
import d.a.h0.a.t.e.b;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends d.a.h0.f.i.a {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f46034c = k.f43101a;

    public a() {
        super("startPermissionsPage");
    }

    @Override // d.a.h0.f.i.a
    public b a(JSONObject jSONObject, d.a.h0.a.p0.b bVar) {
        e O = e.O();
        if (O != null && O.v() != null) {
            y.g(O.v());
            bVar.a(null);
        } else if (f46034c) {
            Log.d("StartPermissionsPage", "swan or activity is null");
        }
        return null;
    }
}
