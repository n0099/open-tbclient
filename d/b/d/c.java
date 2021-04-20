package d.b.d;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class c implements h {

    /* renamed from: a  reason: collision with root package name */
    public final int f43074a;

    /* renamed from: b  reason: collision with root package name */
    public final int f43075b;

    /* renamed from: c  reason: collision with root package name */
    public int f43076c;

    /* renamed from: d  reason: collision with root package name */
    public HashMap f43077d;

    public c(int i, int i2, int i3, String str, String str2, int i4) {
        this.f43074a = i;
        this.f43075b = i2;
        this.f43076c = i4;
    }

    public static h f(int i, int i2, int i3, String str, String str2, int i4) {
        return new c(i, i2, i3, str, str2, i4);
    }

    @Override // d.b.d.h
    public void a(HashMap hashMap) {
        this.f43077d = hashMap;
        if (hashMap.containsKey("iadex")) {
            return;
        }
        hashMap.put("iadex", d.b.h0.z0.d.e());
    }

    @Override // d.b.d.h
    public int b() {
        return this.f43074a;
    }

    @Override // d.b.d.h
    public Map<String, String> c() {
        return this.f43077d;
    }

    @Override // d.b.d.h
    public int d() {
        return this.f43076c;
    }

    @Override // d.b.d.h
    public int e() {
        return this.f43075b;
    }
}
