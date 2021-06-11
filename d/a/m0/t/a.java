package d.a.m0.t;

import org.json.JSONObject;
import tbclient.Advertisement;
/* loaded from: classes3.dex */
public class a implements Comparable<a> {

    /* renamed from: e  reason: collision with root package name */
    public long f54445e;

    /* renamed from: f  reason: collision with root package name */
    public String f54446f;

    /* renamed from: g  reason: collision with root package name */
    public String f54447g;

    /* renamed from: h  reason: collision with root package name */
    public String f54448h;

    /* renamed from: i  reason: collision with root package name */
    public String f54449i;
    public int j;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(a aVar) {
        return g() > aVar.g() ? -1 : 1;
    }

    public String b() {
        return this.f54449i;
    }

    public int c() {
        return this.j;
    }

    public String d() {
        return this.f54448h;
    }

    public String e() {
        return this.f54446f;
    }

    public String f() {
        return this.f54447g;
    }

    public long g() {
        return this.f54445e;
    }

    public void h(Advertisement advertisement) {
        this.f54445e = advertisement.time.longValue();
        this.f54446f = advertisement.pic;
        this.f54447g = advertisement.pic_click;
        this.f54448h = advertisement.jump_link;
        this.f54449i = advertisement.advertisement_id;
    }

    public void i(JSONObject jSONObject) {
        this.f54446f = jSONObject.optString("pic");
        this.f54447g = jSONObject.optString("pic_click");
        this.f54448h = jSONObject.optString("jump_link");
        this.f54449i = jSONObject.optString("advertisement_id");
    }

    public void j(int i2) {
        this.j = i2;
    }
}
