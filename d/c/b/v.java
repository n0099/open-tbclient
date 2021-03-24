package d.c.b;

import android.content.Context;
import android.telephony.TelephonyManager;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class v extends h2 {

    /* renamed from: e  reason: collision with root package name */
    public final Context f65084e;

    public v(Context context) {
        super(true, false);
        this.f65084e = context;
    }

    @Override // d.c.b.h2
    public boolean b(JSONObject jSONObject) {
        j.f(jSONObject, "sim_region", ((TelephonyManager) this.f65084e.getSystemService("phone")).getSimCountryIso());
        return true;
    }
}
