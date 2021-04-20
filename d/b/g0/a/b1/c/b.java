package d.b.g0.a.b1.c;

import android.text.TextUtils;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import d.b.g0.a.k;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f43678a = "";

    /* renamed from: b  reason: collision with root package name */
    public String f43679b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f43680c = "";

    /* renamed from: d  reason: collision with root package name */
    public int f43681d = 0;

    /* renamed from: e  reason: collision with root package name */
    public boolean f43682e = false;

    /* renamed from: f  reason: collision with root package name */
    public boolean f43683f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f43684g = true;

    /* renamed from: h  reason: collision with root package name */
    public int f43685h = 0;
    public float i = 1.0f;
    public String j;

    static {
        boolean z = k.f45443a;
    }

    public static b a(JSONObject jSONObject, b bVar) {
        b bVar2 = new b();
        if (jSONObject != null) {
            bVar2.f43678a = jSONObject.optString("audioId", bVar.f43678a);
            bVar2.f43679b = jSONObject.optString("slaveId", bVar.f43679b);
            bVar2.f43682e = jSONObject.optBoolean("autoplay", bVar.f43682e);
            bVar2.f43683f = jSONObject.optBoolean("loop", bVar.f43683f);
            bVar2.f43680c = jSONObject.optString(UserAccountActionItem.KEY_SRC, bVar.f43680c);
            bVar2.f43681d = jSONObject.optInt("startTime", bVar.f43681d);
            bVar2.f43684g = jSONObject.optBoolean("obeyMuteSwitch", bVar.f43684g);
            bVar2.f43685h = jSONObject.optInt("position", bVar.f43685h);
            bVar2.i = (float) jSONObject.optDouble("volume", bVar.i);
            bVar2.j = jSONObject.optString("cb", bVar.j);
        }
        return bVar2;
    }

    public boolean b() {
        return !TextUtils.isEmpty(this.f43678a);
    }

    public String toString() {
        return "playerId : " + this.f43678a + "; slaveId : " + this.f43679b + "; url : " + this.f43680c + "; AutoPlay : " + this.f43682e + "; Loop : " + this.f43683f + "; startTime : " + this.f43681d + "; ObeyMute : " + this.f43684g + "; pos : " + this.f43685h;
    }
}
