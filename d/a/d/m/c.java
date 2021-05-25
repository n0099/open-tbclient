package d.a.d.m;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class c implements a {

    /* renamed from: a  reason: collision with root package name */
    public final int f39546a;

    /* renamed from: b  reason: collision with root package name */
    public int f39547b;

    /* renamed from: c  reason: collision with root package name */
    public final int f39548c;

    /* renamed from: d  reason: collision with root package name */
    public final int f39549d;

    /* renamed from: e  reason: collision with root package name */
    public final String f39550e;

    /* renamed from: f  reason: collision with root package name */
    public HashMap f39551f;

    public c(int i2, int i3, String str, int i4, int i5, int i6) {
        this.f39546a = i2;
        this.f39550e = str;
        this.f39547b = i4;
        this.f39548c = i5;
        this.f39549d = i6;
    }

    public static a h(int i2, int i3, String str, int i4, int i5, int i6) {
        return new c(i2, i3, str, i4, i5, i6);
    }

    @Override // d.a.d.m.a
    public void a(HashMap hashMap) {
        this.f39551f = hashMap;
        if (hashMap.containsKey("iadex")) {
            return;
        }
        hashMap.put("iadex", d.a.m0.z0.d.e());
    }

    @Override // d.a.d.m.a
    public int b() {
        return this.f39547b;
    }

    @Override // d.a.d.m.a
    public int c() {
        return this.f39546a;
    }

    @Override // d.a.d.m.a
    public Map<String, String> d() {
        return this.f39551f;
    }

    @Override // d.a.d.m.a
    public int e() {
        return this.f39549d;
    }

    @Override // d.a.d.m.a
    public int f() {
        return this.f39548c;
    }

    @Override // d.a.d.m.a
    public String g() {
        return this.f39550e;
    }
}
