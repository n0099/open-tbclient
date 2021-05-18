package d.a.j0.r.q;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Page;
/* loaded from: classes3.dex */
public class z0 {

    /* renamed from: a  reason: collision with root package name */
    public int f50145a = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f50146b = 0;

    /* renamed from: e  reason: collision with root package name */
    public int f50149e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f50150f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f50151g = 0;

    /* renamed from: h  reason: collision with root package name */
    public int f50152h = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f50147c = 0;

    /* renamed from: d  reason: collision with root package name */
    public int f50148d = 0;

    public int a() {
        return this.f50149e;
    }

    public int b() {
        return this.f50151g;
    }

    public int c() {
        return this.f50152h;
    }

    public int d() {
        return this.f50148d;
    }

    public int e() {
        return this.f50150f;
    }

    public int f() {
        return this.f50147c;
    }

    public int g() {
        return this.f50146b;
    }

    public int h() {
        return this.f50145a;
    }

    public void i(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.f50145a = jSONObject.optInt("total_page", 0);
            this.f50146b = jSONObject.optInt("total_num", 0);
            this.f50147c = jSONObject.optInt("total_count", 0);
            this.f50149e = jSONObject.optInt("current_page", 0);
            this.f50150f = jSONObject.optInt("page_size", 0);
            this.f50151g = jSONObject.optInt("has_more", 0);
            this.f50152h = jSONObject.optInt("has_prev", 0);
            this.f50148d = jSONObject.optInt("lz_total_floor", 0);
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void j(Page page) {
        if (page == null) {
            return;
        }
        this.f50145a = page.total_page.intValue();
        this.f50146b = page.total_num.intValue();
        this.f50147c = page.total_count.intValue();
        this.f50149e = page.current_page.intValue();
        this.f50150f = page.page_size.intValue();
        this.f50151g = page.has_more.intValue();
        this.f50152h = page.has_prev.intValue();
        this.f50148d = page.lz_total_floor.intValue();
    }

    public void k(int i2) {
        this.f50149e = i2;
    }

    public void l(int i2) {
        this.f50151g = i2;
    }

    public void m(int i2) {
        this.f50152h = i2;
    }

    public void n(int i2) {
        this.f50148d = i2;
    }

    public void o(int i2) {
        this.f50150f = i2;
    }

    public void p(int i2) {
        this.f50146b = i2;
    }

    public void q(int i2) {
        this.f50145a = i2;
    }
}
