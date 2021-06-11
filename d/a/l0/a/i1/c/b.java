package d.a.l0.a.i1.c;

import android.text.TextUtils;
import d.a.l0.a.k;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f46395a = "";

    /* renamed from: b  reason: collision with root package name */
    public String f46396b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f46397c = "";

    /* renamed from: d  reason: collision with root package name */
    public int f46398d = 0;

    /* renamed from: e  reason: collision with root package name */
    public boolean f46399e = false;

    /* renamed from: f  reason: collision with root package name */
    public boolean f46400f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f46401g = true;

    /* renamed from: h  reason: collision with root package name */
    public int f46402h = 0;

    /* renamed from: i  reason: collision with root package name */
    public float f46403i = 1.0f;
    public String j;

    static {
        boolean z = k.f46875a;
    }

    public static b a(JSONObject jSONObject, b bVar) {
        b bVar2 = new b();
        if (jSONObject != null) {
            bVar2.f46395a = jSONObject.optString("audioId", bVar.f46395a);
            bVar2.f46396b = jSONObject.optString("slaveId", bVar.f46396b);
            bVar2.f46399e = jSONObject.optBoolean("autoplay", bVar.f46399e);
            bVar2.f46400f = jSONObject.optBoolean("loop", bVar.f46400f);
            bVar2.f46397c = jSONObject.optString("src", bVar.f46397c);
            bVar2.f46398d = jSONObject.optInt("startTime", bVar.f46398d);
            bVar2.f46401g = jSONObject.optBoolean("obeyMuteSwitch", bVar.f46401g);
            bVar2.f46402h = jSONObject.optInt("position", bVar.f46402h);
            bVar2.f46403i = (float) jSONObject.optDouble("volume", bVar.f46403i);
            bVar2.j = jSONObject.optString("cb", bVar.j);
        }
        return bVar2;
    }

    public boolean b() {
        return !TextUtils.isEmpty(this.f46395a);
    }

    public String toString() {
        return "playerId : " + this.f46395a + "; slaveId : " + this.f46396b + "; url : " + this.f46397c + "; AutoPlay : " + this.f46399e + "; Loop : " + this.f46400f + "; startTime : " + this.f46398d + "; ObeyMute : " + this.f46401g + "; pos : " + this.f46402h;
    }
}
