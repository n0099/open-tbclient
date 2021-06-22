package d.a.n0.t;

import org.json.JSONObject;
import tbclient.Advertisement;
/* loaded from: classes3.dex */
public class a implements Comparable<a> {

    /* renamed from: e  reason: collision with root package name */
    public long f54552e;

    /* renamed from: f  reason: collision with root package name */
    public String f54553f;

    /* renamed from: g  reason: collision with root package name */
    public String f54554g;

    /* renamed from: h  reason: collision with root package name */
    public String f54555h;

    /* renamed from: i  reason: collision with root package name */
    public String f54556i;
    public int j;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(a aVar) {
        return g() > aVar.g() ? -1 : 1;
    }

    public String b() {
        return this.f54556i;
    }

    public int c() {
        return this.j;
    }

    public String d() {
        return this.f54555h;
    }

    public String e() {
        return this.f54553f;
    }

    public String f() {
        return this.f54554g;
    }

    public long g() {
        return this.f54552e;
    }

    public void h(Advertisement advertisement) {
        this.f54552e = advertisement.time.longValue();
        this.f54553f = advertisement.pic;
        this.f54554g = advertisement.pic_click;
        this.f54555h = advertisement.jump_link;
        this.f54556i = advertisement.advertisement_id;
    }

    public void i(JSONObject jSONObject) {
        this.f54553f = jSONObject.optString("pic");
        this.f54554g = jSONObject.optString("pic_click");
        this.f54555h = jSONObject.optString("jump_link");
        this.f54556i = jSONObject.optString("advertisement_id");
    }

    public void j(int i2) {
        this.j = i2;
    }
}
