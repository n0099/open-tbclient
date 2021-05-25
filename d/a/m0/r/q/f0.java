package d.a.m0.r.q;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import org.json.JSONObject;
import tbclient.FrsPage.Banner;
/* loaded from: classes3.dex */
public class f0 {

    /* renamed from: a  reason: collision with root package name */
    public int f50011a;

    /* renamed from: b  reason: collision with root package name */
    public String f50012b;

    /* renamed from: c  reason: collision with root package name */
    public String f50013c;

    /* renamed from: d  reason: collision with root package name */
    public int f50014d;

    /* renamed from: e  reason: collision with root package name */
    public String f50015e;

    /* renamed from: f  reason: collision with root package name */
    public String f50016f;

    /* renamed from: g  reason: collision with root package name */
    public String f50017g;

    /* renamed from: h  reason: collision with root package name */
    public float f50018h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f50019i = true;

    public int a() {
        return this.f50011a;
    }

    public String b() {
        return this.f50012b;
    }

    public String c() {
        return this.f50016f;
    }

    public int d() {
        return this.f50014d;
    }

    public String e() {
        return this.f50013c;
    }

    public boolean f() {
        if (StringUtils.isNull(this.f50013c)) {
            return false;
        }
        int i2 = this.f50014d;
        if (i2 != 1) {
            return i2 == 2 && !StringUtils.isNull(this.f50015e);
        }
        int i3 = this.f50011a;
        return i3 == 1 || i3 == 4 || i3 == 2 || i3 == 3;
    }

    public final void g(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            String[] split = str.split(",");
            if (split == null || split.length < 2) {
                return;
            }
            int d2 = d.a.c.e.m.b.d(split[0], 1);
            int d3 = d.a.c.e.m.b.d(split[1], 1);
            if (d3 != 0) {
                this.f50018h = d2 / d3;
            }
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void h(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.f50011a = jSONObject.optInt("bannerType");
            this.f50012b = jSONObject.optString("bannerUrl");
            this.f50013c = jSONObject.optString("value");
            this.f50014d = jSONObject.optInt("type");
            this.f50015e = jSONObject.optString("desc");
            jSONObject.optInt("template_id");
            this.f50016f = jSONObject.optString("obj_id");
            jSONObject.optString("tag_name");
            this.f50017g = jSONObject.optString("tag_name_url");
            g(jSONObject.optString("tag_name_wh"));
        } catch (Exception e2) {
            BdLog.e(e2.toString());
        }
    }

    public void i(Banner banner) {
        if (banner == null) {
            return;
        }
        this.f50011a = banner.banner_type.intValue();
        this.f50012b = banner.banner_url;
        this.f50013c = banner.value;
        this.f50014d = banner.type.intValue();
        this.f50015e = banner.desc;
        banner.template_id.intValue();
        this.f50016f = banner.obj_id;
        String str = banner.tag_name;
        this.f50017g = banner.tag_name_url;
        g(banner.tag_name_wh);
    }
}
