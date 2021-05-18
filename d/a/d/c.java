package d.a.d;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class c implements h {

    /* renamed from: a  reason: collision with root package name */
    public final int f39712a;

    /* renamed from: b  reason: collision with root package name */
    public final int f39713b;

    /* renamed from: c  reason: collision with root package name */
    public int f39714c;

    /* renamed from: d  reason: collision with root package name */
    public HashMap f39715d;

    public c(int i2, int i3, int i4, String str, String str2, int i5) {
        this.f39712a = i2;
        this.f39713b = i3;
        this.f39714c = i5;
    }

    public static h f(int i2, int i3, int i4, String str, String str2, int i5) {
        return new c(i2, i3, i4, str, str2, i5);
    }

    @Override // d.a.d.h
    public void a(HashMap hashMap) {
        this.f39715d = hashMap;
        if (hashMap.containsKey("iadex")) {
            return;
        }
        hashMap.put("iadex", d.a.j0.z0.d.e());
    }

    @Override // d.a.d.h
    public int b() {
        return this.f39714c;
    }

    @Override // d.a.d.h
    public int c() {
        return this.f39712a;
    }

    @Override // d.a.d.h
    public Map<String, String> d() {
        return this.f39715d;
    }

    @Override // d.a.d.h
    public int e() {
        return this.f39713b;
    }
}
