package d.a.j0.t;

import org.json.JSONObject;
import tbclient.Advertisement;
/* loaded from: classes3.dex */
public class a implements Comparable<a> {

    /* renamed from: e  reason: collision with root package name */
    public long f50695e;

    /* renamed from: f  reason: collision with root package name */
    public String f50696f;

    /* renamed from: g  reason: collision with root package name */
    public String f50697g;

    /* renamed from: h  reason: collision with root package name */
    public String f50698h;

    /* renamed from: i  reason: collision with root package name */
    public String f50699i;
    public int j;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(a aVar) {
        return g() > aVar.g() ? -1 : 1;
    }

    public String b() {
        return this.f50699i;
    }

    public int c() {
        return this.j;
    }

    public String d() {
        return this.f50698h;
    }

    public String e() {
        return this.f50696f;
    }

    public String f() {
        return this.f50697g;
    }

    public long g() {
        return this.f50695e;
    }

    public void h(Advertisement advertisement) {
        this.f50695e = advertisement.time.longValue();
        this.f50696f = advertisement.pic;
        this.f50697g = advertisement.pic_click;
        this.f50698h = advertisement.jump_link;
        this.f50699i = advertisement.advertisement_id;
    }

    public void i(JSONObject jSONObject) {
        this.f50696f = jSONObject.optString("pic");
        this.f50697g = jSONObject.optString("pic_click");
        this.f50698h = jSONObject.optString("jump_link");
        this.f50699i = jSONObject.optString("advertisement_id");
    }

    public void j(int i2) {
        this.j = i2;
    }
}
