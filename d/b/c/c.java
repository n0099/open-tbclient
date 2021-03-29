package d.b.c;

import com.baidu.tbadk.util.AdExtParam;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class c implements h {

    /* renamed from: a  reason: collision with root package name */
    public final int f42484a;

    /* renamed from: b  reason: collision with root package name */
    public final int f42485b;

    /* renamed from: c  reason: collision with root package name */
    public int f42486c;

    /* renamed from: d  reason: collision with root package name */
    public HashMap f42487d;

    public c(int i, int i2, int i3, String str, String str2, int i4) {
        this.f42484a = i;
        this.f42485b = i2;
        this.f42486c = i4;
    }

    public static h f(int i, int i2, int i3, String str, String str2, int i4) {
        return new c(i, i2, i3, str, str2, i4);
    }

    @Override // d.b.c.h
    public void a(HashMap hashMap) {
        this.f42487d = hashMap;
        if (hashMap.containsKey(AdExtParam.KEY_IADEX)) {
            return;
        }
        hashMap.put(AdExtParam.KEY_IADEX, d.b.h0.z0.d.e());
    }

    @Override // d.b.c.h
    public int b() {
        return this.f42484a;
    }

    @Override // d.b.c.h
    public Map<String, String> c() {
        return this.f42487d;
    }

    @Override // d.b.c.h
    public int d() {
        return this.f42486c;
    }

    @Override // d.b.c.h
    public int e() {
        return this.f42485b;
    }
}
