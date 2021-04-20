package d.b.h0.r.q;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import org.json.JSONObject;
import tbclient.FrsPage.Banner;
/* loaded from: classes3.dex */
public class f0 {

    /* renamed from: a  reason: collision with root package name */
    public int f51186a;

    /* renamed from: b  reason: collision with root package name */
    public String f51187b;

    /* renamed from: c  reason: collision with root package name */
    public String f51188c;

    /* renamed from: d  reason: collision with root package name */
    public int f51189d;

    /* renamed from: e  reason: collision with root package name */
    public String f51190e;

    /* renamed from: f  reason: collision with root package name */
    public String f51191f;

    /* renamed from: g  reason: collision with root package name */
    public String f51192g;

    /* renamed from: h  reason: collision with root package name */
    public float f51193h;
    public boolean i = true;

    public int a() {
        return this.f51186a;
    }

    public String b() {
        return this.f51187b;
    }

    public String c() {
        return this.f51191f;
    }

    public int d() {
        return this.f51189d;
    }

    public String e() {
        return this.f51188c;
    }

    public boolean f() {
        if (StringUtils.isNull(this.f51188c)) {
            return false;
        }
        int i = this.f51189d;
        if (i != 1) {
            return i == 2 && !StringUtils.isNull(this.f51190e);
        }
        int i2 = this.f51186a;
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
            int d2 = d.b.c.e.m.b.d(split[0], 1);
            int d3 = d.b.c.e.m.b.d(split[1], 1);
            if (d3 != 0) {
                this.f51193h = d2 / d3;
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
            this.f51186a = jSONObject.optInt("bannerType");
            this.f51187b = jSONObject.optString("bannerUrl");
            this.f51188c = jSONObject.optString("value");
            this.f51189d = jSONObject.optInt("type");
            this.f51190e = jSONObject.optString("desc");
            jSONObject.optInt("template_id");
            this.f51191f = jSONObject.optString("obj_id");
            jSONObject.optString("tag_name");
            this.f51192g = jSONObject.optString("tag_name_url");
            g(jSONObject.optString("tag_name_wh"));
        } catch (Exception e2) {
            BdLog.e(e2.toString());
        }
    }

    public void i(Banner banner) {
        if (banner == null) {
            return;
        }
        this.f51186a = banner.banner_type.intValue();
        this.f51187b = banner.banner_url;
        this.f51188c = banner.value;
        this.f51189d = banner.type.intValue();
        this.f51190e = banner.desc;
        banner.template_id.intValue();
        this.f51191f = banner.obj_id;
        String str = banner.tag_name;
        this.f51192g = banner.tag_name_url;
        g(banner.tag_name_wh);
    }
}
