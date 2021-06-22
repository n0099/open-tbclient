package d.a.g;

import com.baidu.bdhttpdns.BDHttpDns;
import com.baidu.bdhttpdns.BDHttpDnsResult;
import d.a.g.h;
/* loaded from: classes.dex */
public class d implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ BDHttpDns.a f43549e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ BDHttpDnsResult.ResolveType f43550f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ h.a f43551g;

    public d(BDHttpDns bDHttpDns, BDHttpDns.a aVar, BDHttpDnsResult.ResolveType resolveType, h.a aVar2) {
        this.f43549e = aVar;
        this.f43550f = resolveType;
        this.f43551g = aVar2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f43549e.a(new BDHttpDnsResult(this.f43550f, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK, this.f43551g.d(), this.f43551g.g()));
    }
}
