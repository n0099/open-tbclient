package d.a.d;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class c implements h {

    /* renamed from: a  reason: collision with root package name */
    public final int f43312a;

    /* renamed from: b  reason: collision with root package name */
    public final int f43313b;

    /* renamed from: c  reason: collision with root package name */
    public int f43314c;

    /* renamed from: d  reason: collision with root package name */
    public HashMap f43315d;

    public c(int i2, int i3, int i4, String str, String str2, int i5) {
        this.f43312a = i2;
        this.f43313b = i3;
        this.f43314c = i5;
    }

    public static h f(int i2, int i3, int i4, String str, String str2, int i5) {
        return new c(i2, i3, i4, str, str2, i5);
    }

    @Override // d.a.d.h
    public void a(HashMap hashMap) {
        this.f43315d = hashMap;
        if (hashMap.containsKey("iadex")) {
            return;
        }
        hashMap.put("iadex", d.a.n0.z0.d.e());
    }

    @Override // d.a.d.h
    public int b() {
        return this.f43314c;
    }

    @Override // d.a.d.h
    public int c() {
        return this.f43312a;
    }

    @Override // d.a.d.h
    public Map<String, String> d() {
        return this.f43315d;
    }

    @Override // d.a.d.h
    public int e() {
        return this.f43313b;
    }
}
