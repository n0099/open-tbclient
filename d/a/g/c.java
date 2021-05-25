package d.a.g;

import com.baidu.bdhttpdns.BDHttpDns;
import com.baidu.bdhttpdns.BDHttpDnsResult;
import d.a.g.h;
/* loaded from: classes.dex */
public class c implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ BDHttpDns.a f39871e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ BDHttpDnsResult.ResolveType f39872f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ h.a f39873g;

    public c(BDHttpDns bDHttpDns, BDHttpDns.a aVar, BDHttpDnsResult.ResolveType resolveType, h.a aVar2) {
        this.f39871e = aVar;
        this.f39872f = resolveType;
        this.f39873g = aVar2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f39871e.a(new BDHttpDnsResult(this.f39872f, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK, this.f39873g.d(), null));
    }
}
