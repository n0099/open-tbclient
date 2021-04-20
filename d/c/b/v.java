package d.c.b;

import android.content.Context;
import android.telephony.TelephonyManager;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class v extends h2 {

    /* renamed from: e  reason: collision with root package name */
    public final Context f65930e;

    public v(Context context) {
        super(true, false);
        this.f65930e = context;
    }

    @Override // d.c.b.h2
    public boolean b(JSONObject jSONObject) {
        j.f(jSONObject, "sim_region", ((TelephonyManager) this.f65930e.getSystemService("phone")).getSimCountryIso());
        return true;
    }
}
