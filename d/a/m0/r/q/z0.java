package d.a.m0.r.q;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Page;
/* loaded from: classes3.dex */
public class z0 {

    /* renamed from: a  reason: collision with root package name */
    public int f53865a = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f53866b = 0;

    /* renamed from: e  reason: collision with root package name */
    public int f53869e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f53870f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f53871g = 0;

    /* renamed from: h  reason: collision with root package name */
    public int f53872h = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f53867c = 0;

    /* renamed from: d  reason: collision with root package name */
    public int f53868d = 0;

    public int a() {
        return this.f53869e;
    }

    public int b() {
        return this.f53871g;
    }

    public int c() {
        return this.f53872h;
    }

    public int d() {
        return this.f53868d;
    }

    public int e() {
        return this.f53870f;
    }

    public int f() {
        return this.f53867c;
    }

    public int g() {
        return this.f53866b;
    }

    public int h() {
        return this.f53865a;
    }

    public void i(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.f53865a = jSONObject.optInt("total_page", 0);
            this.f53866b = jSONObject.optInt("total_num", 0);
            this.f53867c = jSONObject.optInt("total_count", 0);
            this.f53869e = jSONObject.optInt("current_page", 0);
            this.f53870f = jSONObject.optInt("page_size", 0);
            this.f53871g = jSONObject.optInt("has_more", 0);
            this.f53872h = jSONObject.optInt("has_prev", 0);
            this.f53868d = jSONObject.optInt("lz_total_floor", 0);
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void j(Page page) {
        if (page == null) {
            return;
        }
        this.f53865a = page.total_page.intValue();
        this.f53866b = page.total_num.intValue();
        this.f53867c = page.total_count.intValue();
        this.f53869e = page.current_page.intValue();
        this.f53870f = page.page_size.intValue();
        this.f53871g = page.has_more.intValue();
        this.f53872h = page.has_prev.intValue();
        this.f53868d = page.lz_total_floor.intValue();
    }

    public void k(int i2) {
        this.f53869e = i2;
    }

    public void l(int i2) {
        this.f53871g = i2;
    }

    public void m(int i2) {
        this.f53872h = i2;
    }

    public void n(int i2) {
        this.f53868d = i2;
    }

    public void o(int i2) {
        this.f53870f = i2;
    }

    public void p(int i2) {
        this.f53866b = i2;
    }

    public void q(int i2) {
        this.f53865a = i2;
    }
}
