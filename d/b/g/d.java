package d.b.g;

import com.baidu.bdhttpdns.BDHttpDns;
import com.baidu.bdhttpdns.BDHttpDnsResult;
import d.b.g.h;
/* loaded from: classes.dex */
public class d implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ BDHttpDns.a f43471e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ BDHttpDnsResult.ResolveType f43472f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ h.a f43473g;

    public d(BDHttpDns bDHttpDns, BDHttpDns.a aVar, BDHttpDnsResult.ResolveType resolveType, h.a aVar2) {
        this.f43471e = aVar;
        this.f43472f = resolveType;
        this.f43473g = aVar2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f43471e.a(new BDHttpDnsResult(this.f43472f, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK, this.f43473g.d(), this.f43473g.g()));
    }
}
