package d.b.i0.t;

import org.json.JSONObject;
import tbclient.Advertisement;
/* loaded from: classes3.dex */
public class a implements Comparable<a> {

    /* renamed from: e  reason: collision with root package name */
    public long f52209e;

    /* renamed from: f  reason: collision with root package name */
    public String f52210f;

    /* renamed from: g  reason: collision with root package name */
    public String f52211g;

    /* renamed from: h  reason: collision with root package name */
    public String f52212h;
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
        return this.f52212h;
    }

    public String e() {
        return this.f52210f;
    }

    public String f() {
        return this.f52211g;
    }

    public long g() {
        return this.f52209e;
    }

    public void h(Advertisement advertisement) {
        this.f52209e = advertisement.time.longValue();
        this.f52210f = advertisement.pic;
        this.f52211g = advertisement.pic_click;
        this.f52212h = advertisement.jump_link;
        this.i = advertisement.advertisement_id;
    }

    public void i(JSONObject jSONObject) {
        this.f52210f = jSONObject.optString("pic");
        this.f52211g = jSONObject.optString("pic_click");
        this.f52212h = jSONObject.optString("jump_link");
        this.i = jSONObject.optString("advertisement_id");
    }

    public void j(int i) {
        this.j = i;
    }
}
