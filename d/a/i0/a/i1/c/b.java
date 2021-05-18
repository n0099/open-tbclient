package d.a.i0.a.i1.c;

import android.text.TextUtils;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import d.a.i0.a.k;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f42545a = "";

    /* renamed from: b  reason: collision with root package name */
    public String f42546b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f42547c = "";

    /* renamed from: d  reason: collision with root package name */
    public int f42548d = 0;

    /* renamed from: e  reason: collision with root package name */
    public boolean f42549e = false;

    /* renamed from: f  reason: collision with root package name */
    public boolean f42550f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f42551g = true;

    /* renamed from: h  reason: collision with root package name */
    public int f42552h = 0;

    /* renamed from: i  reason: collision with root package name */
    public float f42553i = 1.0f;
    public String j;

    static {
        boolean z = k.f43025a;
    }

    public static b a(JSONObject jSONObject, b bVar) {
        b bVar2 = new b();
        if (jSONObject != null) {
            bVar2.f42545a = jSONObject.optString("audioId", bVar.f42545a);
            bVar2.f42546b = jSONObject.optString("slaveId", bVar.f42546b);
            bVar2.f42549e = jSONObject.optBoolean("autoplay", bVar.f42549e);
            bVar2.f42550f = jSONObject.optBoolean("loop", bVar.f42550f);
            bVar2.f42547c = jSONObject.optString(UserAccountActionItem.KEY_SRC, bVar.f42547c);
            bVar2.f42548d = jSONObject.optInt("startTime", bVar.f42548d);
            bVar2.f42551g = jSONObject.optBoolean("obeyMuteSwitch", bVar.f42551g);
            bVar2.f42552h = jSONObject.optInt("position", bVar.f42552h);
            bVar2.f42553i = (float) jSONObject.optDouble("volume", bVar.f42553i);
            bVar2.j = jSONObject.optString("cb", bVar.j);
        }
        return bVar2;
    }

    public boolean b() {
        return !TextUtils.isEmpty(this.f42545a);
    }

    public String toString() {
        return "playerId : " + this.f42545a + "; slaveId : " + this.f42546b + "; url : " + this.f42547c + "; AutoPlay : " + this.f42549e + "; Loop : " + this.f42550f + "; startTime : " + this.f42548d + "; ObeyMute : " + this.f42551g + "; pos : " + this.f42552h;
    }
}
