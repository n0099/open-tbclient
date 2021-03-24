package d.b.g;

import com.baidu.bdhttpdns.BDHttpDns;
import com.baidu.bdhttpdns.BDHttpDnsResult;
import d.b.g.h;
/* loaded from: classes2.dex */
public class c implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ BDHttpDns.a f43066e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ BDHttpDnsResult.ResolveType f43067f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ h.a f43068g;

    public c(BDHttpDns bDHttpDns, BDHttpDns.a aVar, BDHttpDnsResult.ResolveType resolveType, h.a aVar2) {
        this.f43066e = aVar;
        this.f43067f = resolveType;
        this.f43068g = aVar2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f43066e.a(new BDHttpDnsResult(this.f43067f, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK, this.f43068g.d(), null));
    }
}
