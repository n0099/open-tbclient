package d.a.j0.r.q;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import org.json.JSONObject;
import tbclient.FrsPage.Banner;
/* loaded from: classes3.dex */
public class f0 {

    /* renamed from: a  reason: collision with root package name */
    public int f49967a;

    /* renamed from: b  reason: collision with root package name */
    public String f49968b;

    /* renamed from: c  reason: collision with root package name */
    public String f49969c;

    /* renamed from: d  reason: collision with root package name */
    public int f49970d;

    /* renamed from: e  reason: collision with root package name */
    public String f49971e;

    /* renamed from: f  reason: collision with root package name */
    public String f49972f;

    /* renamed from: g  reason: collision with root package name */
    public String f49973g;

    /* renamed from: h  reason: collision with root package name */
    public float f49974h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f49975i = true;

    public int a() {
        return this.f49967a;
    }

    public String b() {
        return this.f49968b;
    }

    public String c() {
        return this.f49972f;
    }

    public int d() {
        return this.f49970d;
    }

    public String e() {
        return this.f49969c;
    }

    public boolean f() {
        if (StringUtils.isNull(this.f49969c)) {
            return false;
        }
        int i2 = this.f49970d;
        if (i2 != 1) {
            return i2 == 2 && !StringUtils.isNull(this.f49971e);
        }
        int i3 = this.f49967a;
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
                this.f49974h = d2 / d3;
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
            this.f49967a = jSONObject.optInt("bannerType");
            this.f49968b = jSONObject.optString("bannerUrl");
            this.f49969c = jSONObject.optString("value");
            this.f49970d = jSONObject.optInt("type");
            this.f49971e = jSONObject.optString("desc");
            jSONObject.optInt("template_id");
            this.f49972f = jSONObject.optString("obj_id");
            jSONObject.optString("tag_name");
            this.f49973g = jSONObject.optString("tag_name_url");
            g(jSONObject.optString("tag_name_wh"));
        } catch (Exception e2) {
            BdLog.e(e2.toString());
        }
    }

    public void i(Banner banner) {
        if (banner == null) {
            return;
        }
        this.f49967a = banner.banner_type.intValue();
        this.f49968b = banner.banner_url;
        this.f49969c = banner.value;
        this.f49970d = banner.type.intValue();
        this.f49971e = banner.desc;
        banner.template_id.intValue();
        this.f49972f = banner.obj_id;
        String str = banner.tag_name;
        this.f49973g = banner.tag_name_url;
        g(banner.tag_name_wh);
    }
}
