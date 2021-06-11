package d.a.d.m;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class c implements a {

    /* renamed from: a  reason: collision with root package name */
    public final int f43227a;

    /* renamed from: b  reason: collision with root package name */
    public int f43228b;

    /* renamed from: c  reason: collision with root package name */
    public final int f43229c;

    /* renamed from: d  reason: collision with root package name */
    public final int f43230d;

    /* renamed from: e  reason: collision with root package name */
    public final String f43231e;

    /* renamed from: f  reason: collision with root package name */
    public HashMap f43232f;

    public c(int i2, int i3, String str, int i4, int i5, int i6) {
        this.f43227a = i2;
        this.f43231e = str;
        this.f43228b = i4;
        this.f43229c = i5;
        this.f43230d = i6;
    }

    public static a h(int i2, int i3, String str, int i4, int i5, int i6) {
        return new c(i2, i3, str, i4, i5, i6);
    }

    @Override // d.a.d.m.a
    public void a(HashMap hashMap) {
        this.f43232f = hashMap;
        if (hashMap.containsKey("iadex")) {
            return;
        }
        hashMap.put("iadex", d.a.m0.z0.d.e());
    }

    @Override // d.a.d.m.a
    public int b() {
        return this.f43228b;
    }

    @Override // d.a.d.m.a
    public int c() {
        return this.f43227a;
    }

    @Override // d.a.d.m.a
    public Map<String, String> d() {
        return this.f43232f;
    }

    @Override // d.a.d.m.a
    public int e() {
        return this.f43230d;
    }

    @Override // d.a.d.m.a
    public int f() {
        return this.f43229c;
    }

    @Override // d.a.d.m.a
    public String g() {
        return this.f43231e;
    }
}
