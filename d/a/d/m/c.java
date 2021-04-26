package d.a.d.m;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class c implements a {

    /* renamed from: a  reason: collision with root package name */
    public final int f40485a;

    /* renamed from: b  reason: collision with root package name */
    public int f40486b;

    /* renamed from: c  reason: collision with root package name */
    public final int f40487c;

    /* renamed from: d  reason: collision with root package name */
    public final int f40488d;

    /* renamed from: e  reason: collision with root package name */
    public final String f40489e;

    /* renamed from: f  reason: collision with root package name */
    public HashMap f40490f;

    public c(int i2, int i3, String str, int i4, int i5, int i6) {
        this.f40485a = i2;
        this.f40489e = str;
        this.f40486b = i4;
        this.f40487c = i5;
        this.f40488d = i6;
    }

    public static a h(int i2, int i3, String str, int i4, int i5, int i6) {
        return new c(i2, i3, str, i4, i5, i6);
    }

    @Override // d.a.d.m.a
    public void a(HashMap hashMap) {
        this.f40490f = hashMap;
        if (hashMap.containsKey("iadex")) {
            return;
        }
        hashMap.put("iadex", d.a.i0.z0.d.e());
    }

    @Override // d.a.d.m.a
    public int b() {
        return this.f40486b;
    }

    @Override // d.a.d.m.a
    public int c() {
        return this.f40485a;
    }

    @Override // d.a.d.m.a
    public Map<String, String> d() {
        return this.f40490f;
    }

    @Override // d.a.d.m.a
    public int e() {
        return this.f40488d;
    }

    @Override // d.a.d.m.a
    public int f() {
        return this.f40487c;
    }

    @Override // d.a.d.m.a
    public String g() {
        return this.f40489e;
    }
}
