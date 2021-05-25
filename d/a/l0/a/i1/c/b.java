package d.a.l0.a.i1.c;

import android.text.TextUtils;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import d.a.l0.a.k;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f42719a = "";

    /* renamed from: b  reason: collision with root package name */
    public String f42720b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f42721c = "";

    /* renamed from: d  reason: collision with root package name */
    public int f42722d = 0;

    /* renamed from: e  reason: collision with root package name */
    public boolean f42723e = false;

    /* renamed from: f  reason: collision with root package name */
    public boolean f42724f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f42725g = true;

    /* renamed from: h  reason: collision with root package name */
    public int f42726h = 0;

    /* renamed from: i  reason: collision with root package name */
    public float f42727i = 1.0f;
    public String j;

    static {
        boolean z = k.f43199a;
    }

    public static b a(JSONObject jSONObject, b bVar) {
        b bVar2 = new b();
        if (jSONObject != null) {
            bVar2.f42719a = jSONObject.optString("audioId", bVar.f42719a);
            bVar2.f42720b = jSONObject.optString("slaveId", bVar.f42720b);
            bVar2.f42723e = jSONObject.optBoolean("autoplay", bVar.f42723e);
            bVar2.f42724f = jSONObject.optBoolean("loop", bVar.f42724f);
            bVar2.f42721c = jSONObject.optString(UserAccountActionItem.KEY_SRC, bVar.f42721c);
            bVar2.f42722d = jSONObject.optInt("startTime", bVar.f42722d);
            bVar2.f42725g = jSONObject.optBoolean("obeyMuteSwitch", bVar.f42725g);
            bVar2.f42726h = jSONObject.optInt("position", bVar.f42726h);
            bVar2.f42727i = (float) jSONObject.optDouble("volume", bVar.f42727i);
            bVar2.j = jSONObject.optString("cb", bVar.j);
        }
        return bVar2;
    }

    public boolean b() {
        return !TextUtils.isEmpty(this.f42719a);
    }

    public String toString() {
        return "playerId : " + this.f42719a + "; slaveId : " + this.f42720b + "; url : " + this.f42721c + "; AutoPlay : " + this.f42723e + "; Loop : " + this.f42724f + "; startTime : " + this.f42722d + "; ObeyMute : " + this.f42725g + "; pos : " + this.f42726h;
    }
}
