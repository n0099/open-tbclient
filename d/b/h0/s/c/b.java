package d.b.h0.s.c;

import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public boolean f51539a;

    /* renamed from: b  reason: collision with root package name */
    public String f51540b;

    /* renamed from: c  reason: collision with root package name */
    public String f51541c;

    /* renamed from: d  reason: collision with root package name */
    public String f51542d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f51543e;

    /* renamed from: f  reason: collision with root package name */
    public String f51544f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f51545g;

    /* renamed from: h  reason: collision with root package name */
    public String f51546h;

    public String a() {
        return this.f51542d;
    }

    public String b() {
        return this.f51540b;
    }

    public String c() {
        return this.f51544f;
    }

    public String d() {
        return this.f51541c;
    }

    public String e() {
        return this.f51546h;
    }

    public boolean f() {
        return this.f51545g;
    }

    public boolean g() {
        return this.f51539a;
    }

    public boolean h() {
        return this.f51543e;
    }

    public void i(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        j(jSONObject.optInt(SetImageWatermarkTypeReqMsg.SWITCH) == 1);
        this.f51540b = jSONObject.optString("feed_text");
        jSONObject.optString("enter_forum_text");
        this.f51541c = jSONObject.optString("my_tab_text");
        long optLong = jSONObject.optLong("dot_timestamp");
        String str = "";
        if (optLong != 0) {
            str = optLong + "";
        }
        this.f51542d = str;
        this.f51543e = jSONObject.optInt("user_satisfy") == 1;
        this.f51544f = jSONObject.optString("h5_url");
        this.f51545g = jSONObject.optInt("person_item_switch") == 1;
        this.f51546h = jSONObject.optString("person_item_text");
    }

    public void j(boolean z) {
        this.f51539a = z;
    }
}
