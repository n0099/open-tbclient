package d.b.g;

import com.baidu.bdhttpdns.BDHttpDns;
import com.baidu.bdhttpdns.BDHttpDnsResult;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class a implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ BDHttpDns.a f43062e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ ArrayList f43063f;

    public a(BDHttpDns bDHttpDns, BDHttpDns.a aVar, ArrayList arrayList) {
        this.f43062e = aVar;
        this.f43063f = arrayList;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f43062e.a(new BDHttpDnsResult(BDHttpDnsResult.ResolveType.RESOLVE_NONEED, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK, this.f43063f, null));
    }
}
