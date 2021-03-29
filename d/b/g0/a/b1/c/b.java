package d.b.g0.a.b1.c;

import android.text.TextUtils;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import d.b.g0.a.k;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f43286a = "";

    /* renamed from: b  reason: collision with root package name */
    public String f43287b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f43288c = "";

    /* renamed from: d  reason: collision with root package name */
    public int f43289d = 0;

    /* renamed from: e  reason: collision with root package name */
    public boolean f43290e = false;

    /* renamed from: f  reason: collision with root package name */
    public boolean f43291f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f43292g = true;

    /* renamed from: h  reason: collision with root package name */
    public int f43293h = 0;
    public float i = 1.0f;
    public String j;

    static {
        boolean z = k.f45051a;
    }

    public static b a(JSONObject jSONObject, b bVar) {
        b bVar2 = new b();
        if (jSONObject != null) {
            bVar2.f43286a = jSONObject.optString("audioId", bVar.f43286a);
            bVar2.f43287b = jSONObject.optString("slaveId", bVar.f43287b);
            bVar2.f43290e = jSONObject.optBoolean("autoplay", bVar.f43290e);
            bVar2.f43291f = jSONObject.optBoolean("loop", bVar.f43291f);
            bVar2.f43288c = jSONObject.optString(UserAccountActionItem.KEY_SRC, bVar.f43288c);
            bVar2.f43289d = jSONObject.optInt("startTime", bVar.f43289d);
            bVar2.f43292g = jSONObject.optBoolean("obeyMuteSwitch", bVar.f43292g);
            bVar2.f43293h = jSONObject.optInt("position", bVar.f43293h);
            bVar2.i = (float) jSONObject.optDouble("volume", bVar.i);
            bVar2.j = jSONObject.optString("cb", bVar.j);
        }
        return bVar2;
    }

    public boolean b() {
        return !TextUtils.isEmpty(this.f43286a);
    }

    public String toString() {
        return "playerId : " + this.f43286a + "; slaveId : " + this.f43287b + "; url : " + this.f43288c + "; AutoPlay : " + this.f43290e + "; Loop : " + this.f43291f + "; startTime : " + this.f43289d + "; ObeyMute : " + this.f43292g + "; pos : " + this.f43293h;
    }
}
