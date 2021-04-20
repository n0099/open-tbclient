package d.b.g;

import com.baidu.bdhttpdns.BDHttpDns;
import com.baidu.bdhttpdns.BDHttpDnsResult;
import d.b.g.h;
/* loaded from: classes.dex */
public class c implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ BDHttpDns.a f43459e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ BDHttpDnsResult.ResolveType f43460f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ h.a f43461g;

    public c(BDHttpDns bDHttpDns, BDHttpDns.a aVar, BDHttpDnsResult.ResolveType resolveType, h.a aVar2) {
        this.f43459e = aVar;
        this.f43460f = resolveType;
        this.f43461g = aVar2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f43459e.a(new BDHttpDnsResult(this.f43460f, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK, this.f43461g.d(), null));
    }
}
