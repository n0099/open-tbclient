package d.a.g;

import com.baidu.bdhttpdns.BDHttpDns;
import com.baidu.bdhttpdns.BDHttpDnsResult;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class b implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ BDHttpDns.a f40711e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ ArrayList f40712f;

    public b(BDHttpDns bDHttpDns, BDHttpDns.a aVar, ArrayList arrayList) {
        this.f40711e = aVar;
        this.f40712f = arrayList;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f40711e.a(new BDHttpDnsResult(BDHttpDnsResult.ResolveType.RESOLVE_NONEED, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK, null, this.f40712f));
    }
}
