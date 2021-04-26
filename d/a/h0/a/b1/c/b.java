package d.a.h0.a.b1.c;

import android.text.TextUtils;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import d.a.h0.a.k;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f41278a = "";

    /* renamed from: b  reason: collision with root package name */
    public String f41279b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f41280c = "";

    /* renamed from: d  reason: collision with root package name */
    public int f41281d = 0;

    /* renamed from: e  reason: collision with root package name */
    public boolean f41282e = false;

    /* renamed from: f  reason: collision with root package name */
    public boolean f41283f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f41284g = true;

    /* renamed from: h  reason: collision with root package name */
    public int f41285h = 0;

    /* renamed from: i  reason: collision with root package name */
    public float f41286i = 1.0f;
    public String j;

    static {
        boolean z = k.f43101a;
    }

    public static b a(JSONObject jSONObject, b bVar) {
        b bVar2 = new b();
        if (jSONObject != null) {
            bVar2.f41278a = jSONObject.optString("audioId", bVar.f41278a);
            bVar2.f41279b = jSONObject.optString("slaveId", bVar.f41279b);
            bVar2.f41282e = jSONObject.optBoolean("autoplay", bVar.f41282e);
            bVar2.f41283f = jSONObject.optBoolean("loop", bVar.f41283f);
            bVar2.f41280c = jSONObject.optString(UserAccountActionItem.KEY_SRC, bVar.f41280c);
            bVar2.f41281d = jSONObject.optInt("startTime", bVar.f41281d);
            bVar2.f41284g = jSONObject.optBoolean("obeyMuteSwitch", bVar.f41284g);
            bVar2.f41285h = jSONObject.optInt("position", bVar.f41285h);
            bVar2.f41286i = (float) jSONObject.optDouble("volume", bVar.f41286i);
            bVar2.j = jSONObject.optString("cb", bVar.j);
        }
        return bVar2;
    }

    public boolean b() {
        return !TextUtils.isEmpty(this.f41278a);
    }

    public String toString() {
        return "playerId : " + this.f41278a + "; slaveId : " + this.f41279b + "; url : " + this.f41280c + "; AutoPlay : " + this.f41282e + "; Loop : " + this.f41283f + "; startTime : " + this.f41281d + "; ObeyMute : " + this.f41284g + "; pos : " + this.f41285h;
    }
}
