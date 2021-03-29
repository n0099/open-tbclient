package d.b.i0.a0;

import com.baidu.adp.lib.util.StringUtils;
import org.json.JSONObject;
import tbclient.OrderList;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f51842a;

    /* renamed from: b  reason: collision with root package name */
    public long f51843b;

    /* renamed from: c  reason: collision with root package name */
    public int f51844c;

    /* renamed from: d  reason: collision with root package name */
    public long f51845d;

    /* renamed from: e  reason: collision with root package name */
    public long f51846e;

    /* renamed from: f  reason: collision with root package name */
    public String f51847f;

    /* renamed from: g  reason: collision with root package name */
    public long f51848g;

    /* renamed from: h  reason: collision with root package name */
    public String f51849h;
    public String i;
    public String j;
    public String k;
    public String l;

    public String a() {
        return this.j;
    }

    public String b() {
        return this.f51849h;
    }

    public String c() {
        return this.i;
    }

    public long d() {
        return this.f51845d;
    }

    public long e() {
        return this.f51846e;
    }

    public long f() {
        return this.f51848g;
    }

    public String g() {
        return this.f51842a;
    }

    public String h() {
        return StringUtils.isNull(this.l) ? this.k : this.l;
    }

    public int i() {
        return this.f51844c;
    }

    public String j() {
        return this.f51847f;
    }

    public long k() {
        return this.f51843b;
    }

    public void l(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f51842a = jSONObject.optString("order_id");
        jSONObject.optLong("scene_id");
        this.f51843b = jSONObject.optLong("scores");
        this.f51844c = jSONObject.optInt("status");
        this.f51845d = jSONObject.optLong("create_time");
        this.f51846e = jSONObject.optLong("finish_time");
        this.f51847f = jSONObject.optString("title");
        this.f51848g = jSONObject.optLong("money");
        jSONObject.optString("preg_field");
        this.k = jSONObject.optString("user_name");
        this.l = jSONObject.optString("user_nickname");
        this.f51849h = jSONObject.optString("activity_desc");
        this.i = jSONObject.optString("activity_url");
        this.j = jSONObject.optString("button_name");
    }

    public void m(OrderList orderList) {
        if (orderList == null) {
            return;
        }
        this.f51842a = orderList.order_id;
        orderList.scene_id.intValue();
        this.f51843b = orderList.scores.longValue();
        this.f51844c = orderList.status.intValue();
        this.f51845d = orderList.create_time.longValue();
        this.f51846e = orderList.finish_time.longValue();
        this.f51847f = orderList.title;
        this.f51848g = orderList.money.longValue();
        String str = orderList.preg_field;
        this.f51849h = orderList.activity_desc;
        this.i = orderList.activity_url;
        this.j = orderList.button_name;
    }
}
