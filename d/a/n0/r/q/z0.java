package d.a.n0.r.q;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Page;
/* loaded from: classes3.dex */
public class z0 {

    /* renamed from: a  reason: collision with root package name */
    public int f53972a = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f53973b = 0;

    /* renamed from: e  reason: collision with root package name */
    public int f53976e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f53977f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f53978g = 0;

    /* renamed from: h  reason: collision with root package name */
    public int f53979h = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f53974c = 0;

    /* renamed from: d  reason: collision with root package name */
    public int f53975d = 0;

    public int a() {
        return this.f53976e;
    }

    public int b() {
        return this.f53978g;
    }

    public int c() {
        return this.f53979h;
    }

    public int d() {
        return this.f53975d;
    }

    public int e() {
        return this.f53977f;
    }

    public int f() {
        return this.f53974c;
    }

    public int g() {
        return this.f53973b;
    }

    public int h() {
        return this.f53972a;
    }

    public void i(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.f53972a = jSONObject.optInt("total_page", 0);
            this.f53973b = jSONObject.optInt("total_num", 0);
            this.f53974c = jSONObject.optInt("total_count", 0);
            this.f53976e = jSONObject.optInt("current_page", 0);
            this.f53977f = jSONObject.optInt("page_size", 0);
            this.f53978g = jSONObject.optInt("has_more", 0);
            this.f53979h = jSONObject.optInt("has_prev", 0);
            this.f53975d = jSONObject.optInt("lz_total_floor", 0);
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void j(Page page) {
        if (page == null) {
            return;
        }
        this.f53972a = page.total_page.intValue();
        this.f53973b = page.total_num.intValue();
        this.f53974c = page.total_count.intValue();
        this.f53976e = page.current_page.intValue();
        this.f53977f = page.page_size.intValue();
        this.f53978g = page.has_more.intValue();
        this.f53979h = page.has_prev.intValue();
        this.f53975d = page.lz_total_floor.intValue();
    }

    public void k(int i2) {
        this.f53976e = i2;
    }

    public void l(int i2) {
        this.f53978g = i2;
    }

    public void m(int i2) {
        this.f53979h = i2;
    }

    public void n(int i2) {
        this.f53975d = i2;
    }

    public void o(int i2) {
        this.f53977f = i2;
    }

    public void p(int i2) {
        this.f53973b = i2;
    }

    public void q(int i2) {
        this.f53972a = i2;
    }
}
