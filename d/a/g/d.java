package d.a.g;

import com.baidu.bdhttpdns.BDHttpDns;
import com.baidu.bdhttpdns.BDHttpDnsResult;
import d.a.g.h;
/* loaded from: classes.dex */
public class d implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ BDHttpDns.a f39874e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ BDHttpDnsResult.ResolveType f39875f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ h.a f39876g;

    public d(BDHttpDns bDHttpDns, BDHttpDns.a aVar, BDHttpDnsResult.ResolveType resolveType, h.a aVar2) {
        this.f39874e = aVar;
        this.f39875f = resolveType;
        this.f39876g = aVar2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f39874e.a(new BDHttpDnsResult(this.f39875f, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK, this.f39876g.d(), this.f39876g.g()));
    }
}
