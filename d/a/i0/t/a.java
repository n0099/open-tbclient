package d.a.i0.t;

import org.json.JSONObject;
import tbclient.Advertisement;
/* loaded from: classes3.dex */
public class a implements Comparable<a> {

    /* renamed from: e  reason: collision with root package name */
    public long f49876e;

    /* renamed from: f  reason: collision with root package name */
    public String f49877f;

    /* renamed from: g  reason: collision with root package name */
    public String f49878g;

    /* renamed from: h  reason: collision with root package name */
    public String f49879h;

    /* renamed from: i  reason: collision with root package name */
    public String f49880i;
    public int j;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(a aVar) {
        return g() > aVar.g() ? -1 : 1;
    }

    public String b() {
        return this.f49880i;
    }

    public int c() {
        return this.j;
    }

    public String d() {
        return this.f49879h;
    }

    public String e() {
        return this.f49877f;
    }

    public String f() {
        return this.f49878g;
    }

    public long g() {
        return this.f49876e;
    }

    public void h(Advertisement advertisement) {
        this.f49876e = advertisement.time.longValue();
        this.f49877f = advertisement.pic;
        this.f49878g = advertisement.pic_click;
        this.f49879h = advertisement.jump_link;
        this.f49880i = advertisement.advertisement_id;
    }

    public void i(JSONObject jSONObject) {
        this.f49877f = jSONObject.optString("pic");
        this.f49878g = jSONObject.optString("pic_click");
        this.f49879h = jSONObject.optString("jump_link");
        this.f49880i = jSONObject.optString("advertisement_id");
    }

    public void j(int i2) {
        this.j = i2;
    }
}
