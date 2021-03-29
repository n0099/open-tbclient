package d.b.h0.s.c;

import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public boolean f51131a;

    /* renamed from: b  reason: collision with root package name */
    public String f51132b;

    /* renamed from: c  reason: collision with root package name */
    public String f51133c;

    /* renamed from: d  reason: collision with root package name */
    public String f51134d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f51135e;

    /* renamed from: f  reason: collision with root package name */
    public String f51136f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f51137g;

    /* renamed from: h  reason: collision with root package name */
    public String f51138h;

    public String a() {
        return this.f51134d;
    }

    public String b() {
        return this.f51132b;
    }

    public String c() {
        return this.f51136f;
    }

    public String d() {
        return this.f51133c;
    }

    public String e() {
        return this.f51138h;
    }

    public boolean f() {
        return this.f51137g;
    }

    public boolean g() {
        return this.f51131a;
    }

    public boolean h() {
        return this.f51135e;
    }

    public void i(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        j(jSONObject.optInt(SetImageWatermarkTypeReqMsg.SWITCH) == 1);
        this.f51132b = jSONObject.optString("feed_text");
        jSONObject.optString("enter_forum_text");
        this.f51133c = jSONObject.optString("my_tab_text");
        long optLong = jSONObject.optLong("dot_timestamp");
        String str = "";
        if (optLong != 0) {
            str = optLong + "";
        }
        this.f51134d = str;
        this.f51135e = jSONObject.optInt("user_satisfy") == 1;
        this.f51136f = jSONObject.optString("h5_url");
        this.f51137g = jSONObject.optInt("person_item_switch") == 1;
        this.f51138h = jSONObject.optString("person_item_text");
    }

    public void j(boolean z) {
        this.f51131a = z;
    }
}
