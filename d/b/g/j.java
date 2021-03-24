package d.b.g;

import android.content.Context;
import com.baidu.bdhttpdns.BDHttpDns;
import com.baidu.bdhttpdns.i;
import d.b.g.h;
import java.util.Map;
/* loaded from: classes2.dex */
public class j implements i.a {

    /* renamed from: a  reason: collision with root package name */
    public final h f43088a;

    /* renamed from: b  reason: collision with root package name */
    public final BDHttpDns f43089b;

    /* renamed from: c  reason: collision with root package name */
    public final BDHttpDns.CachePolicy f43090c;

    /* renamed from: d  reason: collision with root package name */
    public final com.baidu.bdhttpdns.i f43091d;

    public j(Context context) {
        BDHttpDns j = BDHttpDns.j(context);
        this.f43089b = j;
        this.f43088a = j.a();
        this.f43090c = this.f43089b.f();
        this.f43091d = this.f43089b.g();
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
                        this.f43088a.c(key, aVar);
                    } else if (this.f43090c == BDHttpDns.CachePolicy.POLICY_TOLERANT) {
                        this.f43088a.f(key);
                    }
                }
            }
        } else if (dVar.equals(i.d.DNLIST_HOSTS) && this.f43090c == BDHttpDns.CachePolicy.POLICY_TOLERANT) {
            for (String str2 : str.split(",")) {
                this.f43088a.f(str2);
            }
        }
        if (this.f43089b.h() <= 0 || this.f43091d.C()) {
            return;
        }
        this.f43091d.s(true);
        k.a("preResolve has finished", new Object[0]);
    }
}
