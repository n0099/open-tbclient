package d.b.h0.a.b1.c;

import android.text.TextUtils;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import d.b.h0.a.k;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f44007a = "";

    /* renamed from: b  reason: collision with root package name */
    public String f44008b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f44009c = "";

    /* renamed from: d  reason: collision with root package name */
    public int f44010d = 0;

    /* renamed from: e  reason: collision with root package name */
    public boolean f44011e = false;

    /* renamed from: f  reason: collision with root package name */
    public boolean f44012f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f44013g = true;

    /* renamed from: h  reason: collision with root package name */
    public int f44014h = 0;
    public float i = 1.0f;
    public String j;

    static {
        boolean z = k.f45772a;
    }

    public static b a(JSONObject jSONObject, b bVar) {
        b bVar2 = new b();
        if (jSONObject != null) {
            bVar2.f44007a = jSONObject.optString("audioId", bVar.f44007a);
            bVar2.f44008b = jSONObject.optString("slaveId", bVar.f44008b);
            bVar2.f44011e = jSONObject.optBoolean("autoplay", bVar.f44011e);
            bVar2.f44012f = jSONObject.optBoolean("loop", bVar.f44012f);
            bVar2.f44009c = jSONObject.optString(UserAccountActionItem.KEY_SRC, bVar.f44009c);
            bVar2.f44010d = jSONObject.optInt("startTime", bVar.f44010d);
            bVar2.f44013g = jSONObject.optBoolean("obeyMuteSwitch", bVar.f44013g);
            bVar2.f44014h = jSONObject.optInt("position", bVar.f44014h);
            bVar2.i = (float) jSONObject.optDouble("volume", bVar.i);
            bVar2.j = jSONObject.optString("cb", bVar.j);
        }
        return bVar2;
    }

    public boolean b() {
        return !TextUtils.isEmpty(this.f44007a);
    }

    public String toString() {
        return "playerId : " + this.f44007a + "; slaveId : " + this.f44008b + "; url : " + this.f44009c + "; AutoPlay : " + this.f44011e + "; Loop : " + this.f44012f + "; startTime : " + this.f44010d + "; ObeyMute : " + this.f44013g + "; pos : " + this.f44014h;
    }
}
