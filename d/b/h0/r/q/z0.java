package d.b.h0.r.q;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Page;
/* loaded from: classes3.dex */
public class z0 {

    /* renamed from: a  reason: collision with root package name */
    public int f50946a = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f50947b = 0;

    /* renamed from: e  reason: collision with root package name */
    public int f50950e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f50951f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f50952g = 0;

    /* renamed from: h  reason: collision with root package name */
    public int f50953h = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f50948c = 0;

    /* renamed from: d  reason: collision with root package name */
    public int f50949d = 0;

    public int a() {
        return this.f50950e;
    }

    public int b() {
        return this.f50952g;
    }

    public int c() {
        return this.f50953h;
    }

    public int d() {
        return this.f50949d;
    }

    public int e() {
        return this.f50951f;
    }

    public int f() {
        return this.f50948c;
    }

    public int g() {
        return this.f50947b;
    }

    public int h() {
        return this.f50946a;
    }

    public void i(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.f50946a = jSONObject.optInt("total_page", 0);
            this.f50947b = jSONObject.optInt("total_num", 0);
            this.f50948c = jSONObject.optInt("total_count", 0);
            this.f50950e = jSONObject.optInt("current_page", 0);
            this.f50951f = jSONObject.optInt("page_size", 0);
            this.f50952g = jSONObject.optInt("has_more", 0);
            this.f50953h = jSONObject.optInt("has_prev", 0);
            this.f50949d = jSONObject.optInt("lz_total_floor", 0);
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void j(Page page) {
        if (page == null) {
            return;
        }
        this.f50946a = page.total_page.intValue();
        this.f50947b = page.total_num.intValue();
        this.f50948c = page.total_count.intValue();
        this.f50950e = page.current_page.intValue();
        this.f50951f = page.page_size.intValue();
        this.f50952g = page.has_more.intValue();
        this.f50953h = page.has_prev.intValue();
        this.f50949d = page.lz_total_floor.intValue();
    }

    public void k(int i) {
        this.f50950e = i;
    }

    public void l(int i) {
        this.f50952g = i;
    }

    public void m(int i) {
        this.f50953h = i;
    }

    public void n(int i) {
        this.f50949d = i;
    }

    public void o(int i) {
        this.f50951f = i;
    }

    public void p(int i) {
        this.f50947b = i;
    }

    public void q(int i) {
        this.f50946a = i;
    }
}
