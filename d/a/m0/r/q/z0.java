package d.a.m0.r.q;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Page;
/* loaded from: classes3.dex */
public class z0 {

    /* renamed from: a  reason: collision with root package name */
    public int f50189a = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f50190b = 0;

    /* renamed from: e  reason: collision with root package name */
    public int f50193e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f50194f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f50195g = 0;

    /* renamed from: h  reason: collision with root package name */
    public int f50196h = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f50191c = 0;

    /* renamed from: d  reason: collision with root package name */
    public int f50192d = 0;

    public int a() {
        return this.f50193e;
    }

    public int b() {
        return this.f50195g;
    }

    public int c() {
        return this.f50196h;
    }

    public int d() {
        return this.f50192d;
    }

    public int e() {
        return this.f50194f;
    }

    public int f() {
        return this.f50191c;
    }

    public int g() {
        return this.f50190b;
    }

    public int h() {
        return this.f50189a;
    }

    public void i(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.f50189a = jSONObject.optInt("total_page", 0);
            this.f50190b = jSONObject.optInt("total_num", 0);
            this.f50191c = jSONObject.optInt("total_count", 0);
            this.f50193e = jSONObject.optInt("current_page", 0);
            this.f50194f = jSONObject.optInt("page_size", 0);
            this.f50195g = jSONObject.optInt("has_more", 0);
            this.f50196h = jSONObject.optInt("has_prev", 0);
            this.f50192d = jSONObject.optInt("lz_total_floor", 0);
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void j(Page page) {
        if (page == null) {
            return;
        }
        this.f50189a = page.total_page.intValue();
        this.f50190b = page.total_num.intValue();
        this.f50191c = page.total_count.intValue();
        this.f50193e = page.current_page.intValue();
        this.f50194f = page.page_size.intValue();
        this.f50195g = page.has_more.intValue();
        this.f50196h = page.has_prev.intValue();
        this.f50192d = page.lz_total_floor.intValue();
    }

    public void k(int i2) {
        this.f50193e = i2;
    }

    public void l(int i2) {
        this.f50195g = i2;
    }

    public void m(int i2) {
        this.f50196h = i2;
    }

    public void n(int i2) {
        this.f50192d = i2;
    }

    public void o(int i2) {
        this.f50194f = i2;
    }

    public void p(int i2) {
        this.f50190b = i2;
    }

    public void q(int i2) {
        this.f50189a = i2;
    }
}
