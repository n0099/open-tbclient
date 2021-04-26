package d.a.g;

import com.baidu.bdhttpdns.BDHttpDns;
import com.baidu.bdhttpdns.BDHttpDnsResult;
import d.a.g.h;
/* loaded from: classes.dex */
public class c implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ BDHttpDns.a f40713e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ BDHttpDnsResult.ResolveType f40714f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ h.a f40715g;

    public c(BDHttpDns bDHttpDns, BDHttpDns.a aVar, BDHttpDnsResult.ResolveType resolveType, h.a aVar2) {
        this.f40713e = aVar;
        this.f40714f = resolveType;
        this.f40715g = aVar2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f40713e.a(new BDHttpDnsResult(this.f40714f, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK, this.f40715g.d(), null));
    }
}
