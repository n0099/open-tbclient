package d.b.h0.t;

import org.json.JSONObject;
import tbclient.Advertisement;
/* loaded from: classes3.dex */
public class a implements Comparable<a> {

    /* renamed from: e  reason: collision with root package name */
    public long f51873e;

    /* renamed from: f  reason: collision with root package name */
    public String f51874f;

    /* renamed from: g  reason: collision with root package name */
    public String f51875g;

    /* renamed from: h  reason: collision with root package name */
    public String f51876h;
    public String i;
    public int j;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(a aVar) {
        return g() > aVar.g() ? -1 : 1;
    }

    public String b() {
        return this.i;
    }

    public int c() {
        return this.j;
    }

    public String d() {
        return this.f51876h;
    }

    public String e() {
        return this.f51874f;
    }

    public String f() {
        return this.f51875g;
    }

    public long g() {
        return this.f51873e;
    }

    public void h(Advertisement advertisement) {
        this.f51873e = advertisement.time.longValue();
        this.f51874f = advertisement.pic;
        this.f51875g = advertisement.pic_click;
        this.f51876h = advertisement.jump_link;
        this.i = advertisement.advertisement_id;
    }

    public void i(JSONObject jSONObject) {
        this.f51874f = jSONObject.optString("pic");
        this.f51875g = jSONObject.optString("pic_click");
        this.f51876h = jSONObject.optString("jump_link");
        this.i = jSONObject.optString("advertisement_id");
    }

    public void j(int i) {
        this.j = i;
    }
}
