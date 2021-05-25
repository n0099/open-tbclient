package d.a.m0.t;

import org.json.JSONObject;
import tbclient.Advertisement;
/* loaded from: classes3.dex */
public class a implements Comparable<a> {

    /* renamed from: e  reason: collision with root package name */
    public long f50768e;

    /* renamed from: f  reason: collision with root package name */
    public String f50769f;

    /* renamed from: g  reason: collision with root package name */
    public String f50770g;

    /* renamed from: h  reason: collision with root package name */
    public String f50771h;

    /* renamed from: i  reason: collision with root package name */
    public String f50772i;
    public int j;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(a aVar) {
        return g() > aVar.g() ? -1 : 1;
    }

    public String b() {
        return this.f50772i;
    }

    public int c() {
        return this.j;
    }

    public String d() {
        return this.f50771h;
    }

    public String e() {
        return this.f50769f;
    }

    public String f() {
        return this.f50770g;
    }

    public long g() {
        return this.f50768e;
    }

    public void h(Advertisement advertisement) {
        this.f50768e = advertisement.time.longValue();
        this.f50769f = advertisement.pic;
        this.f50770g = advertisement.pic_click;
        this.f50771h = advertisement.jump_link;
        this.f50772i = advertisement.advertisement_id;
    }

    public void i(JSONObject jSONObject) {
        this.f50769f = jSONObject.optString("pic");
        this.f50770g = jSONObject.optString("pic_click");
        this.f50771h = jSONObject.optString("jump_link");
        this.f50772i = jSONObject.optString("advertisement_id");
    }

    public void j(int i2) {
        this.j = i2;
    }
}
