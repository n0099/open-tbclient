package d.b.j0.a0;

import com.baidu.adp.lib.util.StringUtils;
import org.json.JSONObject;
import tbclient.OrderList;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f52687a;

    /* renamed from: b  reason: collision with root package name */
    public long f52688b;

    /* renamed from: c  reason: collision with root package name */
    public int f52689c;

    /* renamed from: d  reason: collision with root package name */
    public long f52690d;

    /* renamed from: e  reason: collision with root package name */
    public long f52691e;

    /* renamed from: f  reason: collision with root package name */
    public String f52692f;

    /* renamed from: g  reason: collision with root package name */
    public long f52693g;

    /* renamed from: h  reason: collision with root package name */
    public String f52694h;
    public String i;
    public String j;
    public String k;
    public String l;

    public String a() {
        return this.j;
    }

    public String b() {
        return this.f52694h;
    }

    public String c() {
        return this.i;
    }

    public long d() {
        return this.f52690d;
    }

    public long e() {
        return this.f52691e;
    }

    public long f() {
        return this.f52693g;
    }

    public String g() {
        return this.f52687a;
    }

    public String h() {
        return StringUtils.isNull(this.l) ? this.k : this.l;
    }

    public int i() {
        return this.f52689c;
    }

    public String j() {
        return this.f52692f;
    }

    public long k() {
        return this.f52688b;
    }

    public void l(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f52687a = jSONObject.optString("order_id");
        jSONObject.optLong("scene_id");
        this.f52688b = jSONObject.optLong("scores");
        this.f52689c = jSONObject.optInt("status");
        this.f52690d = jSONObject.optLong("create_time");
        this.f52691e = jSONObject.optLong("finish_time");
        this.f52692f = jSONObject.optString("title");
        this.f52693g = jSONObject.optLong("money");
        jSONObject.optString("preg_field");
        this.k = jSONObject.optString("user_name");
        this.l = jSONObject.optString("user_nickname");
        this.f52694h = jSONObject.optString("activity_desc");
        this.i = jSONObject.optString("activity_url");
        this.j = jSONObject.optString("button_name");
    }

    public void m(OrderList orderList) {
        if (orderList == null) {
            return;
        }
        this.f52687a = orderList.order_id;
        orderList.scene_id.intValue();
        this.f52688b = orderList.scores.longValue();
        this.f52689c = orderList.status.intValue();
        this.f52690d = orderList.create_time.longValue();
        this.f52691e = orderList.finish_time.longValue();
        this.f52692f = orderList.title;
        this.f52693g = orderList.money.longValue();
        String str = orderList.preg_field;
        this.f52694h = orderList.activity_desc;
        this.i = orderList.activity_url;
        this.j = orderList.button_name;
    }
}
