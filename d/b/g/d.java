package d.b.g;

import com.baidu.bdhttpdns.BDHttpDns;
import com.baidu.bdhttpdns.BDHttpDnsResult;
import d.b.g.h;
/* loaded from: classes2.dex */
public class d implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ BDHttpDns.a f43069e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ BDHttpDnsResult.ResolveType f43070f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ h.a f43071g;

    public d(BDHttpDns bDHttpDns, BDHttpDns.a aVar, BDHttpDnsResult.ResolveType resolveType, h.a aVar2) {
        this.f43069e = aVar;
        this.f43070f = resolveType;
        this.f43071g = aVar2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f43069e.a(new BDHttpDnsResult(this.f43070f, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK, this.f43071g.d(), this.f43071g.g()));
    }
}
