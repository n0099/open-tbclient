package d.b.g;

import com.baidu.bdhttpdns.BDHttpDns;
import com.baidu.bdhttpdns.BDHttpDnsResult;
import d.b.g.h;
/* loaded from: classes.dex */
public class d implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ BDHttpDns.a f43462e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ BDHttpDnsResult.ResolveType f43463f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ h.a f43464g;

    public d(BDHttpDns bDHttpDns, BDHttpDns.a aVar, BDHttpDnsResult.ResolveType resolveType, h.a aVar2) {
        this.f43462e = aVar;
        this.f43463f = resolveType;
        this.f43464g = aVar2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f43462e.a(new BDHttpDnsResult(this.f43463f, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK, this.f43464g.d(), this.f43464g.g()));
    }
}
