package d.b.i0.r.q;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import org.json.JSONObject;
import tbclient.FrsPage.Banner;
/* loaded from: classes3.dex */
public class f0 {

    /* renamed from: a  reason: collision with root package name */
    public int f51522a;

    /* renamed from: b  reason: collision with root package name */
    public String f51523b;

    /* renamed from: c  reason: collision with root package name */
    public String f51524c;

    /* renamed from: d  reason: collision with root package name */
    public int f51525d;

    /* renamed from: e  reason: collision with root package name */
    public String f51526e;

    /* renamed from: f  reason: collision with root package name */
    public String f51527f;

    /* renamed from: g  reason: collision with root package name */
    public String f51528g;

    /* renamed from: h  reason: collision with root package name */
    public float f51529h;
    public boolean i = true;

    public int a() {
        return this.f51522a;
    }

    public String b() {
        return this.f51523b;
    }

    public String c() {
        return this.f51527f;
    }

    public int d() {
        return this.f51525d;
    }

    public String e() {
        return this.f51524c;
    }

    public boolean f() {
        if (StringUtils.isNull(this.f51524c)) {
            return false;
        }
        int i = this.f51525d;
        if (i != 1) {
            return i == 2 && !StringUtils.isNull(this.f51526e);
        }
        int i2 = this.f51522a;
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
                this.f51529h = d2 / d3;
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
            this.f51522a = jSONObject.optInt("bannerType");
            this.f51523b = jSONObject.optString("bannerUrl");
            this.f51524c = jSONObject.optString("value");
            this.f51525d = jSONObject.optInt("type");
            this.f51526e = jSONObject.optString("desc");
            jSONObject.optInt("template_id");
            this.f51527f = jSONObject.optString("obj_id");
            jSONObject.optString("tag_name");
            this.f51528g = jSONObject.optString("tag_name_url");
            g(jSONObject.optString("tag_name_wh"));
        } catch (Exception e2) {
            BdLog.e(e2.toString());
        }
    }

    public void i(Banner banner) {
        if (banner == null) {
            return;
        }
        this.f51522a = banner.banner_type.intValue();
        this.f51523b = banner.banner_url;
        this.f51524c = banner.value;
        this.f51525d = banner.type.intValue();
        this.f51526e = banner.desc;
        banner.template_id.intValue();
        this.f51527f = banner.obj_id;
        String str = banner.tag_name;
        this.f51528g = banner.tag_name_url;
        g(banner.tag_name_wh);
    }
}
