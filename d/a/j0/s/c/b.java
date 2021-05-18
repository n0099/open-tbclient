package d.a.j0.s.c;

import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public boolean f50345a;

    /* renamed from: b  reason: collision with root package name */
    public String f50346b;

    /* renamed from: c  reason: collision with root package name */
    public String f50347c;

    /* renamed from: d  reason: collision with root package name */
    public String f50348d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f50349e;

    /* renamed from: f  reason: collision with root package name */
    public String f50350f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f50351g;

    /* renamed from: h  reason: collision with root package name */
    public String f50352h;

    public String a() {
        return this.f50348d;
    }

    public String b() {
        return this.f50346b;
    }

    public String c() {
        return this.f50350f;
    }

    public String d() {
        return this.f50347c;
    }

    public String e() {
        return this.f50352h;
    }

    public boolean f() {
        return this.f50351g;
    }

    public boolean g() {
        return this.f50345a;
    }

    public boolean h() {
        return this.f50349e;
    }

    public void i(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        j(jSONObject.optInt(SetImageWatermarkTypeReqMsg.SWITCH) == 1);
        this.f50346b = jSONObject.optString("feed_text");
        jSONObject.optString("enter_forum_text");
        this.f50347c = jSONObject.optString("my_tab_text");
        long optLong = jSONObject.optLong("dot_timestamp");
        String str = "";
        if (optLong != 0) {
            str = optLong + "";
        }
        this.f50348d = str;
        this.f50349e = jSONObject.optInt("user_satisfy") == 1;
        this.f50350f = jSONObject.optString("h5_url");
        this.f50351g = jSONObject.optInt("person_item_switch") == 1;
        this.f50352h = jSONObject.optString("person_item_text");
    }

    public void j(boolean z) {
        this.f50345a = z;
    }
}
