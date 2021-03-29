package d.b.g;

import com.baidu.bdhttpdns.BDHttpDns;
import com.baidu.bdhttpdns.BDHttpDnsResult;
import d.b.g.h;
/* loaded from: classes.dex */
public class d implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ BDHttpDns.a f43070e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ BDHttpDnsResult.ResolveType f43071f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ h.a f43072g;

    public d(BDHttpDns bDHttpDns, BDHttpDns.a aVar, BDHttpDnsResult.ResolveType resolveType, h.a aVar2) {
        this.f43070e = aVar;
        this.f43071f = resolveType;
        this.f43072g = aVar2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f43070e.a(new BDHttpDnsResult(this.f43071f, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK, this.f43072g.d(), this.f43072g.g()));
    }
}
