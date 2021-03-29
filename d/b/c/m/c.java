package d.b.c.m;

import com.baidu.tbadk.util.AdExtParam;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class c implements a {

    /* renamed from: a  reason: collision with root package name */
    public final int f42501a;

    /* renamed from: b  reason: collision with root package name */
    public int f42502b;

    /* renamed from: c  reason: collision with root package name */
    public final int f42503c;

    /* renamed from: d  reason: collision with root package name */
    public final int f42504d;

    /* renamed from: e  reason: collision with root package name */
    public final String f42505e;

    /* renamed from: f  reason: collision with root package name */
    public HashMap f42506f;

    public c(int i, int i2, String str, int i3, int i4, int i5) {
        this.f42501a = i;
        this.f42505e = str;
        this.f42502b = i3;
        this.f42503c = i4;
        this.f42504d = i5;
    }

    public static a h(int i, int i2, String str, int i3, int i4, int i5) {
        return new c(i, i2, str, i3, i4, i5);
    }

    @Override // d.b.c.m.a
    public void a(HashMap hashMap) {
        this.f42506f = hashMap;
        if (hashMap.containsKey(AdExtParam.KEY_IADEX)) {
            return;
        }
        hashMap.put(AdExtParam.KEY_IADEX, d.b.h0.z0.d.e());
    }

    @Override // d.b.c.m.a
    public int b() {
        return this.f42501a;
    }

    @Override // d.b.c.m.a
    public Map<String, String> c() {
        return this.f42506f;
    }

    @Override // d.b.c.m.a
    public int d() {
        return this.f42502b;
    }

    @Override // d.b.c.m.a
    public int e() {
        return this.f42504d;
    }

    @Override // d.b.c.m.a
    public String f() {
        return this.f42505e;
    }

    @Override // d.b.c.m.a
    public int g() {
        return this.f42503c;
    }
}
