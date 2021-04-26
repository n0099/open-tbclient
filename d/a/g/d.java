package d.a.g;

import com.baidu.bdhttpdns.BDHttpDns;
import com.baidu.bdhttpdns.BDHttpDnsResult;
import d.a.g.h;
/* loaded from: classes.dex */
public class d implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ BDHttpDns.a f40716e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ BDHttpDnsResult.ResolveType f40717f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ h.a f40718g;

    public d(BDHttpDns bDHttpDns, BDHttpDns.a aVar, BDHttpDnsResult.ResolveType resolveType, h.a aVar2) {
        this.f40716e = aVar;
        this.f40717f = resolveType;
        this.f40718g = aVar2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f40716e.a(new BDHttpDnsResult(this.f40717f, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK, this.f40718g.d(), this.f40718g.g()));
    }
}
