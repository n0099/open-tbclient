package d.b.h0.r.q;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Page;
/* loaded from: classes3.dex */
public class z0 {

    /* renamed from: a  reason: collision with root package name */
    public int f51353a = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f51354b = 0;

    /* renamed from: e  reason: collision with root package name */
    public int f51357e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f51358f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f51359g = 0;

    /* renamed from: h  reason: collision with root package name */
    public int f51360h = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f51355c = 0;

    /* renamed from: d  reason: collision with root package name */
    public int f51356d = 0;

    public int a() {
        return this.f51357e;
    }

    public int b() {
        return this.f51359g;
    }

    public int c() {
        return this.f51360h;
    }

    public int d() {
        return this.f51356d;
    }

    public int e() {
        return this.f51358f;
    }

    public int f() {
        return this.f51355c;
    }

    public int g() {
        return this.f51354b;
    }

    public int h() {
        return this.f51353a;
    }

    public void i(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.f51353a = jSONObject.optInt("total_page", 0);
            this.f51354b = jSONObject.optInt("total_num", 0);
            this.f51355c = jSONObject.optInt("total_count", 0);
            this.f51357e = jSONObject.optInt("current_page", 0);
            this.f51358f = jSONObject.optInt("page_size", 0);
            this.f51359g = jSONObject.optInt("has_more", 0);
            this.f51360h = jSONObject.optInt("has_prev", 0);
            this.f51356d = jSONObject.optInt("lz_total_floor", 0);
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void j(Page page) {
        if (page == null) {
            return;
        }
        this.f51353a = page.total_page.intValue();
        this.f51354b = page.total_num.intValue();
        this.f51355c = page.total_count.intValue();
        this.f51357e = page.current_page.intValue();
        this.f51358f = page.page_size.intValue();
        this.f51359g = page.has_more.intValue();
        this.f51360h = page.has_prev.intValue();
        this.f51356d = page.lz_total_floor.intValue();
    }

    public void k(int i) {
        this.f51357e = i;
    }

    public void l(int i) {
        this.f51359g = i;
    }

    public void m(int i) {
        this.f51360h = i;
    }

    public void n(int i) {
        this.f51356d = i;
    }

    public void o(int i) {
        this.f51358f = i;
    }

    public void p(int i) {
        this.f51354b = i;
    }

    public void q(int i) {
        this.f51353a = i;
    }
}
