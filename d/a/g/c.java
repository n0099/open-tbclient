package d.a.g;

import com.baidu.bdhttpdns.BDHttpDns;
import com.baidu.bdhttpdns.BDHttpDnsResult;
import d.a.g.h;
/* loaded from: classes.dex */
public class c implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ BDHttpDns.a f43552e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ BDHttpDnsResult.ResolveType f43553f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ h.a f43554g;

    public c(BDHttpDns bDHttpDns, BDHttpDns.a aVar, BDHttpDnsResult.ResolveType resolveType, h.a aVar2) {
        this.f43552e = aVar;
        this.f43553f = resolveType;
        this.f43554g = aVar2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f43552e.a(new BDHttpDnsResult(this.f43553f, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK, this.f43554g.d(), null));
    }
}
