package d.a.d;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class c implements h {

    /* renamed from: a  reason: collision with root package name */
    public final int f39528a;

    /* renamed from: b  reason: collision with root package name */
    public final int f39529b;

    /* renamed from: c  reason: collision with root package name */
    public int f39530c;

    /* renamed from: d  reason: collision with root package name */
    public HashMap f39531d;

    public c(int i2, int i3, int i4, String str, String str2, int i5) {
        this.f39528a = i2;
        this.f39529b = i3;
        this.f39530c = i5;
    }

    public static h f(int i2, int i3, int i4, String str, String str2, int i5) {
        return new c(i2, i3, i4, str, str2, i5);
    }

    @Override // d.a.d.h
    public void a(HashMap hashMap) {
        this.f39531d = hashMap;
        if (hashMap.containsKey("iadex")) {
            return;
        }
        hashMap.put("iadex", d.a.m0.z0.d.e());
    }

    @Override // d.a.d.h
    public int b() {
        return this.f39530c;
    }

    @Override // d.a.d.h
    public int c() {
        return this.f39528a;
    }

    @Override // d.a.d.h
    public Map<String, String> d() {
        return this.f39531d;
    }

    @Override // d.a.d.h
    public int e() {
        return this.f39529b;
    }
}
