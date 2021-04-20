package d.b.g;

import android.content.Context;
import com.baidu.bdhttpdns.BDHttpDns;
import com.baidu.bdhttpdns.i;
import d.b.g.h;
import java.util.Map;
/* loaded from: classes.dex */
public class j implements i.a {

    /* renamed from: a  reason: collision with root package name */
    public final h f43481a;

    /* renamed from: b  reason: collision with root package name */
    public final BDHttpDns f43482b;

    /* renamed from: c  reason: collision with root package name */
    public final BDHttpDns.CachePolicy f43483c;

    /* renamed from: d  reason: collision with root package name */
    public final com.baidu.bdhttpdns.i f43484d;

    public j(Context context) {
        BDHttpDns j = BDHttpDns.j(context);
        this.f43482b = j;
        this.f43481a = j.a();
        this.f43483c = this.f43482b.f();
        this.f43484d = this.f43482b.g();
    }

    @Override // com.baidu.bdhttpdns.i.a
    public void a(int i, i.d dVar, Map<String, i.e> map, String str) {
        if (i != -1) {
            if (i != 0) {
                k.a("Internal error: async httpdns resolve completion get error ret(%d)", Integer.valueOf(i));
            } else {
                for (Map.Entry<String, i.e> entry : map.entrySet()) {
                    String key = entry.getKey();
                    i.e value = entry.getValue();
                    if (value != null) {
                        h.a aVar = new h.a();
                        aVar.a(value.b());
                        aVar.e(System.currentTimeMillis() / 1000);
                        aVar.b(value.a());
                        this.f43481a.c(key, aVar);
                    } else if (this.f43483c == BDHttpDns.CachePolicy.POLICY_TOLERANT) {
                        this.f43481a.f(key);
                    }
                }
            }
        } else if (dVar.equals(i.d.DNLIST_HOSTS) && this.f43483c == BDHttpDns.CachePolicy.POLICY_TOLERANT) {
            for (String str2 : str.split(",")) {
                this.f43481a.f(str2);
            }
        }
        if (this.f43482b.h() <= 0 || this.f43484d.C()) {
            return;
        }
        this.f43484d.s(true);
        k.a("preResolve has finished", new Object[0]);
    }
}
