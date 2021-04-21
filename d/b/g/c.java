package d.b.g;

import com.baidu.bdhttpdns.BDHttpDns;
import com.baidu.bdhttpdns.BDHttpDnsResult;
import d.b.g.h;
/* loaded from: classes.dex */
public class c implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ BDHttpDns.a f43468e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ BDHttpDnsResult.ResolveType f43469f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ h.a f43470g;

    public c(BDHttpDns bDHttpDns, BDHttpDns.a aVar, BDHttpDnsResult.ResolveType resolveType, h.a aVar2) {
        this.f43468e = aVar;
        this.f43469f = resolveType;
        this.f43470g = aVar2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f43468e.a(new BDHttpDnsResult(this.f43469f, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK, this.f43470g.d(), null));
    }
}
