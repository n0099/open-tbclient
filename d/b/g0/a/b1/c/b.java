package d.b.g0.a.b1.c;

import android.text.TextUtils;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import d.b.g0.a.k;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f43285a = "";

    /* renamed from: b  reason: collision with root package name */
    public String f43286b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f43287c = "";

    /* renamed from: d  reason: collision with root package name */
    public int f43288d = 0;

    /* renamed from: e  reason: collision with root package name */
    public boolean f43289e = false;

    /* renamed from: f  reason: collision with root package name */
    public boolean f43290f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f43291g = true;

    /* renamed from: h  reason: collision with root package name */
    public int f43292h = 0;
    public float i = 1.0f;
    public String j;

    static {
        boolean z = k.f45050a;
    }

    public static b a(JSONObject jSONObject, b bVar) {
        b bVar2 = new b();
        if (jSONObject != null) {
            bVar2.f43285a = jSONObject.optString("audioId", bVar.f43285a);
            bVar2.f43286b = jSONObject.optString("slaveId", bVar.f43286b);
            bVar2.f43289e = jSONObject.optBoolean("autoplay", bVar.f43289e);
            bVar2.f43290f = jSONObject.optBoolean("loop", bVar.f43290f);
            bVar2.f43287c = jSONObject.optString(UserAccountActionItem.KEY_SRC, bVar.f43287c);
            bVar2.f43288d = jSONObject.optInt("startTime", bVar.f43288d);
            bVar2.f43291g = jSONObject.optBoolean("obeyMuteSwitch", bVar.f43291g);
            bVar2.f43292h = jSONObject.optInt("position", bVar.f43292h);
            bVar2.i = (float) jSONObject.optDouble("volume", bVar.i);
            bVar2.j = jSONObject.optString("cb", bVar.j);
        }
        return bVar2;
    }

    public boolean b() {
        return !TextUtils.isEmpty(this.f43285a);
    }

    public String toString() {
        return "playerId : " + this.f43285a + "; slaveId : " + this.f43286b + "; url : " + this.f43287c + "; AutoPlay : " + this.f43289e + "; Loop : " + this.f43290f + "; startTime : " + this.f43288d + "; ObeyMute : " + this.f43291g + "; pos : " + this.f43292h;
    }
}
