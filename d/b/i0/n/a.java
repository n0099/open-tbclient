package d.b.i0.n;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f51106a = 300;

    /* renamed from: b  reason: collision with root package name */
    public int f51107b = 5000;

    /* renamed from: c  reason: collision with root package name */
    public int f51108c = 10000;

    /* renamed from: d  reason: collision with root package name */
    public int f51109d = 1500;

    /* renamed from: e  reason: collision with root package name */
    public int f51110e = 3000;

    /* renamed from: f  reason: collision with root package name */
    public int f51111f = 6000;

    /* renamed from: g  reason: collision with root package name */
    public boolean f51112g = true;

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            int optInt = jSONObject.optInt("wifiSlow", -1);
            if (optInt > 0) {
                this.f51106a = optInt;
            }
            int optInt2 = jSONObject.optInt("threeGSlow", -1);
            if (optInt2 > 0) {
                this.f51107b = optInt2;
            }
            int optInt3 = jSONObject.optInt("twoGSlow", -1);
            if (optInt3 > 0) {
                this.f51108c = optInt3;
            }
            int optInt4 = jSONObject.optInt("wifiLog", -1);
            if (optInt4 > 0) {
                this.f51109d = optInt4;
            }
            int optInt5 = jSONObject.optInt("threeGLog", -1);
            if (optInt5 > 0) {
                this.f51110e = optInt5;
            }
            int optInt6 = jSONObject.optInt("twoGLog", -1);
            if (optInt6 > 0) {
                this.f51111f = optInt6;
            }
            boolean z = true;
            if (jSONObject.optInt("mobile_cdn_switch", 1) != 1) {
                z = false;
            }
            this.f51112g = z;
        } catch (Exception unused) {
        }
    }
}
