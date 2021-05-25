package d.a.m0.s.c;

import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public boolean f50411a;

    /* renamed from: b  reason: collision with root package name */
    public String f50412b;

    /* renamed from: c  reason: collision with root package name */
    public String f50413c;

    /* renamed from: d  reason: collision with root package name */
    public String f50414d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f50415e;

    /* renamed from: f  reason: collision with root package name */
    public String f50416f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f50417g;

    /* renamed from: h  reason: collision with root package name */
    public String f50418h;

    public String a() {
        return this.f50414d;
    }

    public String b() {
        return this.f50412b;
    }

    public String c() {
        return this.f50416f;
    }

    public String d() {
        return this.f50413c;
    }

    public String e() {
        return this.f50418h;
    }

    public boolean f() {
        return this.f50417g;
    }

    public boolean g() {
        return this.f50411a;
    }

    public boolean h() {
        return this.f50415e;
    }

    public void i(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        j(jSONObject.optInt(SetImageWatermarkTypeReqMsg.SWITCH) == 1);
        this.f50412b = jSONObject.optString("feed_text");
        jSONObject.optString("enter_forum_text");
        this.f50413c = jSONObject.optString("my_tab_text");
        long optLong = jSONObject.optLong("dot_timestamp");
        String str = "";
        if (optLong != 0) {
            str = optLong + "";
        }
        this.f50414d = str;
        this.f50415e = jSONObject.optInt("user_satisfy") == 1;
        this.f50416f = jSONObject.optString("h5_url");
        this.f50417g = jSONObject.optInt("person_item_switch") == 1;
        this.f50418h = jSONObject.optString("person_item_text");
    }

    public void j(boolean z) {
        this.f50411a = z;
    }
}
