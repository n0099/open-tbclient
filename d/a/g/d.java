package d.a.g;

import com.baidu.bdhttpdns.BDHttpDns;
import com.baidu.bdhttpdns.BDHttpDnsResult;
import d.a.g.h;
/* loaded from: classes.dex */
public class d implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ BDHttpDns.a f43555e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ BDHttpDnsResult.ResolveType f43556f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ h.a f43557g;

    public d(BDHttpDns bDHttpDns, BDHttpDns.a aVar, BDHttpDnsResult.ResolveType resolveType, h.a aVar2) {
        this.f43555e = aVar;
        this.f43556f = resolveType;
        this.f43557g = aVar2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f43555e.a(new BDHttpDnsResult(this.f43556f, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK, this.f43557g.d(), this.f43557g.g()));
    }
}
