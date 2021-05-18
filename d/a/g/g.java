package d.a.g;

import android.content.Context;
import com.baidu.bdhttpdns.BDHttpDns;
import com.baidu.bdhttpdns.BDHttpDnsResult;
import d.a.g.f;
import d.a.g.h;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class g implements f.a {

    /* renamed from: a  reason: collision with root package name */
    public final BDHttpDns.a f39970a;

    /* renamed from: b  reason: collision with root package name */
    public final BDHttpDns f39971b;

    /* renamed from: c  reason: collision with root package name */
    public final h f39972c;

    public g(Context context, BDHttpDns.a aVar) {
        this.f39970a = aVar;
        BDHttpDns j = BDHttpDns.j(context);
        this.f39971b = j;
        this.f39972c = j.d();
    }

    @Override // d.a.g.f.a
    public void a(int i2, ArrayList<String> arrayList, ArrayList<String> arrayList2, long j, String str) {
        BDHttpDns.a aVar;
        BDHttpDnsResult bDHttpDnsResult;
        if (i2 == -1) {
            k.a("Async resolve failed, host(%s), dns resolve failed", str);
            aVar = this.f39970a;
            if (aVar == null) {
                return;
            }
            bDHttpDnsResult = new BDHttpDnsResult(BDHttpDnsResult.ResolveType.RESOLVE_NONE, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveErrorDnsResolve, arrayList, arrayList2);
        } else if (i2 != 0) {
            k.a("Internal error: async dns resolve completion get error ret(%d)", Integer.valueOf(i2));
            return;
        } else {
            Object[] objArr = new Object[4];
            objArr[0] = str;
            objArr[1] = arrayList != null ? arrayList.toString() : null;
            objArr[2] = arrayList2 != null ? arrayList2.toString() : null;
            objArr[3] = BDHttpDnsResult.ResolveType.RESOLVE_FROM_DNS.toString();
            k.a("Async resolve successful, host(%s) ipv4List(%s) ipv6List(%s) resolveType(%s)", objArr);
            h.a aVar2 = new h.a();
            aVar2.a(60L);
            aVar2.e(System.currentTimeMillis() / 1000);
            aVar2.b(arrayList);
            aVar2.f(arrayList2);
            this.f39972c.c(str, aVar2);
            aVar = this.f39970a;
            if (aVar == null) {
                return;
            }
            bDHttpDnsResult = new BDHttpDnsResult(BDHttpDnsResult.ResolveType.RESOLVE_FROM_DNS, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK, arrayList, arrayList2);
        }
        aVar.a(bDHttpDnsResult);
    }
}
