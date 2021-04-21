package d.b.i0.r.q;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Page;
/* loaded from: classes3.dex */
public class z0 {

    /* renamed from: a  reason: collision with root package name */
    public int f51689a = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f51690b = 0;

    /* renamed from: e  reason: collision with root package name */
    public int f51693e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f51694f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f51695g = 0;

    /* renamed from: h  reason: collision with root package name */
    public int f51696h = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f51691c = 0;

    /* renamed from: d  reason: collision with root package name */
    public int f51692d = 0;

    public int a() {
        return this.f51693e;
    }

    public int b() {
        return this.f51695g;
    }

    public int c() {
        return this.f51696h;
    }

    public int d() {
        return this.f51692d;
    }

    public int e() {
        return this.f51694f;
    }

    public int f() {
        return this.f51691c;
    }

    public int g() {
        return this.f51690b;
    }

    public int h() {
        return this.f51689a;
    }

    public void i(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.f51689a = jSONObject.optInt("total_page", 0);
            this.f51690b = jSONObject.optInt("total_num", 0);
            this.f51691c = jSONObject.optInt("total_count", 0);
            this.f51693e = jSONObject.optInt("current_page", 0);
            this.f51694f = jSONObject.optInt("page_size", 0);
            this.f51695g = jSONObject.optInt("has_more", 0);
            this.f51696h = jSONObject.optInt("has_prev", 0);
            this.f51692d = jSONObject.optInt("lz_total_floor", 0);
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void j(Page page) {
        if (page == null) {
            return;
        }
        this.f51689a = page.total_page.intValue();
        this.f51690b = page.total_num.intValue();
        this.f51691c = page.total_count.intValue();
        this.f51693e = page.current_page.intValue();
        this.f51694f = page.page_size.intValue();
        this.f51695g = page.has_more.intValue();
        this.f51696h = page.has_prev.intValue();
        this.f51692d = page.lz_total_floor.intValue();
    }

    public void k(int i) {
        this.f51693e = i;
    }

    public void l(int i) {
        this.f51695g = i;
    }

    public void m(int i) {
        this.f51696h = i;
    }

    public void n(int i) {
        this.f51692d = i;
    }

    public void o(int i) {
        this.f51694f = i;
    }

    public void p(int i) {
        this.f51690b = i;
    }

    public void q(int i) {
        this.f51689a = i;
    }
}
