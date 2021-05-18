package d.a.g;

import com.baidu.bdhttpdns.BDHttpDns;
import com.baidu.bdhttpdns.BDHttpDnsResult;
import d.a.g.h;
/* loaded from: classes.dex */
public class c implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ BDHttpDns.a f39958e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ BDHttpDnsResult.ResolveType f39959f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ h.a f39960g;

    public c(BDHttpDns bDHttpDns, BDHttpDns.a aVar, BDHttpDnsResult.ResolveType resolveType, h.a aVar2) {
        this.f39958e = aVar;
        this.f39959f = resolveType;
        this.f39960g = aVar2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f39958e.a(new BDHttpDnsResult(this.f39959f, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK, this.f39960g.d(), null));
    }
}
