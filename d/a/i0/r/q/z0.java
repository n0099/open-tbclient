package d.a.i0.r.q;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Page;
/* loaded from: classes3.dex */
public class z0 {

    /* renamed from: a  reason: collision with root package name */
    public int f49326a = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f49327b = 0;

    /* renamed from: e  reason: collision with root package name */
    public int f49330e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f49331f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f49332g = 0;

    /* renamed from: h  reason: collision with root package name */
    public int f49333h = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f49328c = 0;

    /* renamed from: d  reason: collision with root package name */
    public int f49329d = 0;

    public int a() {
        return this.f49330e;
    }

    public int b() {
        return this.f49332g;
    }

    public int c() {
        return this.f49333h;
    }

    public int d() {
        return this.f49329d;
    }

    public int e() {
        return this.f49331f;
    }

    public int f() {
        return this.f49328c;
    }

    public int g() {
        return this.f49327b;
    }

    public int h() {
        return this.f49326a;
    }

    public void i(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.f49326a = jSONObject.optInt("total_page", 0);
            this.f49327b = jSONObject.optInt("total_num", 0);
            this.f49328c = jSONObject.optInt("total_count", 0);
            this.f49330e = jSONObject.optInt("current_page", 0);
            this.f49331f = jSONObject.optInt("page_size", 0);
            this.f49332g = jSONObject.optInt("has_more", 0);
            this.f49333h = jSONObject.optInt("has_prev", 0);
            this.f49329d = jSONObject.optInt("lz_total_floor", 0);
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void j(Page page) {
        if (page == null) {
            return;
        }
        this.f49326a = page.total_page.intValue();
        this.f49327b = page.total_num.intValue();
        this.f49328c = page.total_count.intValue();
        this.f49330e = page.current_page.intValue();
        this.f49331f = page.page_size.intValue();
        this.f49332g = page.has_more.intValue();
        this.f49333h = page.has_prev.intValue();
        this.f49329d = page.lz_total_floor.intValue();
    }

    public void k(int i2) {
        this.f49330e = i2;
    }

    public void l(int i2) {
        this.f49332g = i2;
    }

    public void m(int i2) {
        this.f49333h = i2;
    }

    public void n(int i2) {
        this.f49329d = i2;
    }

    public void o(int i2) {
        this.f49331f = i2;
    }

    public void p(int i2) {
        this.f49327b = i2;
    }

    public void q(int i2) {
        this.f49326a = i2;
    }
}
