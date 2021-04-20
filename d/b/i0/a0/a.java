package d.b.i0.a0;

import com.baidu.adp.lib.util.StringUtils;
import org.json.JSONObject;
import tbclient.OrderList;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f52266a;

    /* renamed from: b  reason: collision with root package name */
    public long f52267b;

    /* renamed from: c  reason: collision with root package name */
    public int f52268c;

    /* renamed from: d  reason: collision with root package name */
    public long f52269d;

    /* renamed from: e  reason: collision with root package name */
    public long f52270e;

    /* renamed from: f  reason: collision with root package name */
    public String f52271f;

    /* renamed from: g  reason: collision with root package name */
    public long f52272g;

    /* renamed from: h  reason: collision with root package name */
    public String f52273h;
    public String i;
    public String j;
    public String k;
    public String l;

    public String a() {
        return this.j;
    }

    public String b() {
        return this.f52273h;
    }

    public String c() {
        return this.i;
    }

    public long d() {
        return this.f52269d;
    }

    public long e() {
        return this.f52270e;
    }

    public long f() {
        return this.f52272g;
    }

    public String g() {
        return this.f52266a;
    }

    public String h() {
        return StringUtils.isNull(this.l) ? this.k : this.l;
    }

    public int i() {
        return this.f52268c;
    }

    public String j() {
        return this.f52271f;
    }

    public long k() {
        return this.f52267b;
    }

    public void l(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f52266a = jSONObject.optString("order_id");
        jSONObject.optLong("scene_id");
        this.f52267b = jSONObject.optLong("scores");
        this.f52268c = jSONObject.optInt("status");
        this.f52269d = jSONObject.optLong("create_time");
        this.f52270e = jSONObject.optLong("finish_time");
        this.f52271f = jSONObject.optString("title");
        this.f52272g = jSONObject.optLong("money");
        jSONObject.optString("preg_field");
        this.k = jSONObject.optString("user_name");
        this.l = jSONObject.optString("user_nickname");
        this.f52273h = jSONObject.optString("activity_desc");
        this.i = jSONObject.optString("activity_url");
        this.j = jSONObject.optString("button_name");
    }

    public void m(OrderList orderList) {
        if (orderList == null) {
            return;
        }
        this.f52266a = orderList.order_id;
        orderList.scene_id.intValue();
        this.f52267b = orderList.scores.longValue();
        this.f52268c = orderList.status.intValue();
        this.f52269d = orderList.create_time.longValue();
        this.f52270e = orderList.finish_time.longValue();
        this.f52271f = orderList.title;
        this.f52272g = orderList.money.longValue();
        String str = orderList.preg_field;
        this.f52273h = orderList.activity_desc;
        this.i = orderList.activity_url;
        this.j = orderList.button_name;
    }
}
