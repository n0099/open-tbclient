package d.b.h0.r.q;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import org.json.JSONObject;
import tbclient.FrsPage.Banner;
/* loaded from: classes3.dex */
public class f0 {

    /* renamed from: a  reason: collision with root package name */
    public int f50778a;

    /* renamed from: b  reason: collision with root package name */
    public String f50779b;

    /* renamed from: c  reason: collision with root package name */
    public String f50780c;

    /* renamed from: d  reason: collision with root package name */
    public int f50781d;

    /* renamed from: e  reason: collision with root package name */
    public String f50782e;

    /* renamed from: f  reason: collision with root package name */
    public String f50783f;

    /* renamed from: g  reason: collision with root package name */
    public String f50784g;

    /* renamed from: h  reason: collision with root package name */
    public float f50785h;
    public boolean i = true;

    public int a() {
        return this.f50778a;
    }

    public String b() {
        return this.f50779b;
    }

    public String c() {
        return this.f50783f;
    }

    public int d() {
        return this.f50781d;
    }

    public String e() {
        return this.f50780c;
    }

    public boolean f() {
        if (StringUtils.isNull(this.f50780c)) {
            return false;
        }
        int i = this.f50781d;
        if (i != 1) {
            return i == 2 && !StringUtils.isNull(this.f50782e);
        }
        int i2 = this.f50778a;
        return i2 == 1 || i2 == 4 || i2 == 2 || i2 == 3;
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
            int d2 = d.b.b.e.m.b.d(split[0], 1);
            int d3 = d.b.b.e.m.b.d(split[1], 1);
            if (d3 != 0) {
                this.f50785h = d2 / d3;
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
            this.f50778a = jSONObject.optInt("bannerType");
            this.f50779b = jSONObject.optString("bannerUrl");
            this.f50780c = jSONObject.optString("value");
            this.f50781d = jSONObject.optInt("type");
            this.f50782e = jSONObject.optString("desc");
            jSONObject.optInt("template_id");
            this.f50783f = jSONObject.optString("obj_id");
            jSONObject.optString("tag_name");
            this.f50784g = jSONObject.optString("tag_name_url");
            g(jSONObject.optString("tag_name_wh"));
        } catch (Exception e2) {
            BdLog.e(e2.toString());
        }
    }

    public void i(Banner banner) {
        if (banner == null) {
            return;
        }
        this.f50778a = banner.banner_type.intValue();
        this.f50779b = banner.banner_url;
        this.f50780c = banner.value;
        this.f50781d = banner.type.intValue();
        this.f50782e = banner.desc;
        banner.template_id.intValue();
        this.f50783f = banner.obj_id;
        String str = banner.tag_name;
        this.f50784g = banner.tag_name_url;
        g(banner.tag_name_wh);
    }
}
