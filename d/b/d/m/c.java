package d.b.d.m;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class c implements a {

    /* renamed from: a  reason: collision with root package name */
    public final int f43251a;

    /* renamed from: b  reason: collision with root package name */
    public int f43252b;

    /* renamed from: c  reason: collision with root package name */
    public final int f43253c;

    /* renamed from: d  reason: collision with root package name */
    public final int f43254d;

    /* renamed from: e  reason: collision with root package name */
    public final String f43255e;

    /* renamed from: f  reason: collision with root package name */
    public HashMap f43256f;

    public c(int i, int i2, String str, int i3, int i4, int i5) {
        this.f43251a = i;
        this.f43255e = str;
        this.f43252b = i3;
        this.f43253c = i4;
        this.f43254d = i5;
    }

    public static a h(int i, int i2, String str, int i3, int i4, int i5) {
        return new c(i, i2, str, i3, i4, i5);
    }

    @Override // d.b.d.m.a
    public void a(HashMap hashMap) {
        this.f43256f = hashMap;
        if (hashMap.containsKey("iadex")) {
            return;
        }
        hashMap.put("iadex", d.b.i0.z0.d.e());
    }

    @Override // d.b.d.m.a
    public int b() {
        return this.f43251a;
    }

    @Override // d.b.d.m.a
    public Map<String, String> c() {
        return this.f43256f;
    }

    @Override // d.b.d.m.a
    public int d() {
        return this.f43252b;
    }

    @Override // d.b.d.m.a
    public int e() {
        return this.f43254d;
    }

    @Override // d.b.d.m.a
    public String f() {
        return this.f43255e;
    }

    @Override // d.b.d.m.a
    public int g() {
        return this.f43253c;
    }
}
