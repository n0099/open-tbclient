package d.b.g;

import com.baidu.bdhttpdns.BDHttpDns;
import com.baidu.bdhttpdns.BDHttpDnsResult;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class b implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ BDHttpDns.a f43064e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ ArrayList f43065f;

    public b(BDHttpDns bDHttpDns, BDHttpDns.a aVar, ArrayList arrayList) {
        this.f43064e = aVar;
        this.f43065f = arrayList;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f43064e.a(new BDHttpDnsResult(BDHttpDnsResult.ResolveType.RESOLVE_NONEED, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK, null, this.f43065f));
    }
}
