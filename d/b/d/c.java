package d.b.d;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class c implements h {

    /* renamed from: a  reason: collision with root package name */
    public final int f43234a;

    /* renamed from: b  reason: collision with root package name */
    public final int f43235b;

    /* renamed from: c  reason: collision with root package name */
    public int f43236c;

    /* renamed from: d  reason: collision with root package name */
    public HashMap f43237d;

    public c(int i, int i2, int i3, String str, String str2, int i4) {
        this.f43234a = i;
        this.f43235b = i2;
        this.f43236c = i4;
    }

    public static h f(int i, int i2, int i3, String str, String str2, int i4) {
        return new c(i, i2, i3, str, str2, i4);
    }

    @Override // d.b.d.h
    public void a(HashMap hashMap) {
        this.f43237d = hashMap;
        if (hashMap.containsKey("iadex")) {
            return;
        }
        hashMap.put("iadex", d.b.i0.z0.d.e());
    }

    @Override // d.b.d.h
    public int b() {
        return this.f43234a;
    }

    @Override // d.b.d.h
    public Map<String, String> c() {
        return this.f43237d;
    }

    @Override // d.b.d.h
    public int d() {
        return this.f43236c;
    }

    @Override // d.b.d.h
    public int e() {
        return this.f43235b;
    }
}
