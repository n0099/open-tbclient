package d.a.g;

import android.content.Context;
import com.baidu.bdhttpdns.BDHttpDns;
import com.baidu.bdhttpdns.i;
import d.a.g.h;
import java.util.Map;
/* loaded from: classes.dex */
public class j implements i.a {

    /* renamed from: a  reason: collision with root package name */
    public final h f43574a;

    /* renamed from: b  reason: collision with root package name */
    public final BDHttpDns f43575b;

    /* renamed from: c  reason: collision with root package name */
    public final BDHttpDns.CachePolicy f43576c;

    /* renamed from: d  reason: collision with root package name */
    public final com.baidu.bdhttpdns.i f43577d;

    public j(Context context) {
        BDHttpDns j = BDHttpDns.j(context);
        this.f43575b = j;
        this.f43574a = j.a();
        this.f43576c = this.f43575b.f();
        this.f43577d = this.f43575b.g();
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
                        this.f43574a.c(key, aVar);
                    } else if (this.f43576c == BDHttpDns.CachePolicy.POLICY_TOLERANT) {
                        this.f43574a.f(key);
                    }
                }
            }
        } else if (dVar.equals(i.d.DNLIST_HOSTS) && this.f43576c == BDHttpDns.CachePolicy.POLICY_TOLERANT) {
            for (String str2 : str.split(",")) {
                this.f43574a.f(str2);
            }
        }
        if (this.f43575b.h() <= 0 || this.f43577d.C()) {
            return;
        }
        this.f43577d.s(true);
        k.a("preResolve has finished", new Object[0]);
    }
}
