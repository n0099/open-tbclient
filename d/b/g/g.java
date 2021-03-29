package d.b.g;

import android.content.Context;
import com.baidu.bdhttpdns.BDHttpDns;
import com.baidu.bdhttpdns.BDHttpDnsResult;
import d.b.g.f;
import d.b.g.h;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class g implements f.a {

    /* renamed from: a  reason: collision with root package name */
    public final BDHttpDns.a f43079a;

    /* renamed from: b  reason: collision with root package name */
    public final BDHttpDns f43080b;

    /* renamed from: c  reason: collision with root package name */
    public final h f43081c;

    public g(Context context, BDHttpDns.a aVar) {
        this.f43079a = aVar;
        BDHttpDns j = BDHttpDns.j(context);
        this.f43080b = j;
        this.f43081c = j.d();
    }

    @Override // d.b.g.f.a
    public void a(int i, ArrayList<String> arrayList, ArrayList<String> arrayList2, long j, String str) {
        BDHttpDns.a aVar;
        BDHttpDnsResult bDHttpDnsResult;
        if (i == -1) {
            k.a("Async resolve failed, host(%s), dns resolve failed", str);
            aVar = this.f43079a;
            if (aVar == null) {
                return;
            }
            bDHttpDnsResult = new BDHttpDnsResult(BDHttpDnsResult.ResolveType.RESOLVE_NONE, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveErrorDnsResolve, arrayList, arrayList2);
        } else if (i != 0) {
            k.a("Internal error: async dns resolve completion get error ret(%d)", Integer.valueOf(i));
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
            this.f43081c.c(str, aVar2);
            aVar = this.f43079a;
            if (aVar == null) {
                return;
            }
            bDHttpDnsResult = new BDHttpDnsResult(BDHttpDnsResult.ResolveType.RESOLVE_FROM_DNS, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK, arrayList, arrayList2);
        }
        aVar.a(bDHttpDnsResult);
    }
}
