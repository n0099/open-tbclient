package d.a.g;

import android.content.Context;
import com.baidu.bdhttpdns.BDHttpDns;
import com.baidu.bdhttpdns.i;
import d.a.g.h;
import java.util.Map;
/* loaded from: classes.dex */
public class j implements i.a {

    /* renamed from: a  reason: collision with root package name */
    public final h f39980a;

    /* renamed from: b  reason: collision with root package name */
    public final BDHttpDns f39981b;

    /* renamed from: c  reason: collision with root package name */
    public final BDHttpDns.CachePolicy f39982c;

    /* renamed from: d  reason: collision with root package name */
    public final com.baidu.bdhttpdns.i f39983d;

    public j(Context context) {
        BDHttpDns j = BDHttpDns.j(context);
        this.f39981b = j;
        this.f39980a = j.a();
        this.f39982c = this.f39981b.f();
        this.f39983d = this.f39981b.g();
    }

    @Override // com.baidu.bdhttpdns.i.a
    public void a(int i2, i.d dVar, Map<String, i.e> map, String str) {
        if (i2 != -1) {
            if (i2 != 0) {
                k.a("Internal error: async httpdns resolve completion get error ret(%d)", Integer.valueOf(i2));
            } else {
                for (Map.Entry<String, i.e> entry : map.entrySet()) {
                    String key = entry.getKey();
                    i.e value = entry.getValue();
                    if (value != null) {
                        h.a aVar = new h.a();
                        aVar.a(value.b());
                        aVar.e(System.currentTimeMillis() / 1000);
                        aVar.b(value.a());
                        this.f39980a.c(key, aVar);
                    } else if (this.f39982c == BDHttpDns.CachePolicy.POLICY_TOLERANT) {
                        this.f39980a.f(key);
                    }
                }
            }
        } else if (dVar.equals(i.d.DNLIST_HOSTS) && this.f39982c == BDHttpDns.CachePolicy.POLICY_TOLERANT) {
            for (String str2 : str.split(",")) {
                this.f39980a.f(str2);
            }
        }
        if (this.f39981b.h() <= 0 || this.f39983d.C()) {
            return;
        }
        this.f39983d.s(true);
        k.a("preResolve has finished", new Object[0]);
    }
}
