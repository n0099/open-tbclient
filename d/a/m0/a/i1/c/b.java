package d.a.m0.a.i1.c;

import android.text.TextUtils;
import d.a.m0.a.k;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f46503a = "";

    /* renamed from: b  reason: collision with root package name */
    public String f46504b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f46505c = "";

    /* renamed from: d  reason: collision with root package name */
    public int f46506d = 0;

    /* renamed from: e  reason: collision with root package name */
    public boolean f46507e = false;

    /* renamed from: f  reason: collision with root package name */
    public boolean f46508f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f46509g = true;

    /* renamed from: h  reason: collision with root package name */
    public int f46510h = 0;

    /* renamed from: i  reason: collision with root package name */
    public float f46511i = 1.0f;
    public String j;

    static {
        boolean z = k.f46983a;
    }

    public static b a(JSONObject jSONObject, b bVar) {
        b bVar2 = new b();
        if (jSONObject != null) {
            bVar2.f46503a = jSONObject.optString("audioId", bVar.f46503a);
            bVar2.f46504b = jSONObject.optString("slaveId", bVar.f46504b);
            bVar2.f46507e = jSONObject.optBoolean("autoplay", bVar.f46507e);
            bVar2.f46508f = jSONObject.optBoolean("loop", bVar.f46508f);
            bVar2.f46505c = jSONObject.optString("src", bVar.f46505c);
            bVar2.f46506d = jSONObject.optInt("startTime", bVar.f46506d);
            bVar2.f46509g = jSONObject.optBoolean("obeyMuteSwitch", bVar.f46509g);
            bVar2.f46510h = jSONObject.optInt("position", bVar.f46510h);
            bVar2.f46511i = (float) jSONObject.optDouble("volume", bVar.f46511i);
            bVar2.j = jSONObject.optString("cb", bVar.j);
        }
        return bVar2;
    }

    public boolean b() {
        return !TextUtils.isEmpty(this.f46503a);
    }

    public String toString() {
        return "playerId : " + this.f46503a + "; slaveId : " + this.f46504b + "; url : " + this.f46505c + "; AutoPlay : " + this.f46507e + "; Loop : " + this.f46508f + "; startTime : " + this.f46506d + "; ObeyMute : " + this.f46509g + "; pos : " + this.f46510h;
    }
}
