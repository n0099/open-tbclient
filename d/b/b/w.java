package d.b.b;

import android.content.Context;
import android.telephony.TelephonyManager;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class w extends h2 {

    /* renamed from: e  reason: collision with root package name */
    public final Context f64391e;

    /* renamed from: f  reason: collision with root package name */
    public final i f64392f;

    public w(Context context, i iVar) {
        super(true, false);
        this.f64391e = context;
        this.f64392f = iVar;
    }

    @Override // d.b.b.h2
    public boolean b(JSONObject jSONObject) {
        TelephonyManager telephonyManager = (TelephonyManager) this.f64391e.getSystemService("phone");
        if (telephonyManager != null) {
            try {
                j.f(jSONObject, "carrier", telephonyManager.getNetworkOperatorName());
                j.f(jSONObject, "mcc_mnc", telephonyManager.getNetworkOperator());
                j.f(jSONObject, "udid", this.f64392f.n() ? p0.a(telephonyManager) : this.f64392f.m());
                return true;
            } catch (Exception e2) {
                r0.b(e2);
            }
        }
        return false;
    }
}
