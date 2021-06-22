package d.a.g;

import com.baidu.bdhttpdns.BDHttpDns;
import com.baidu.bdhttpdns.BDHttpDnsResult;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class b implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ BDHttpDns.a f43544e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ ArrayList f43545f;

    public b(BDHttpDns bDHttpDns, BDHttpDns.a aVar, ArrayList arrayList) {
        this.f43544e = aVar;
        this.f43545f = arrayList;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f43544e.a(new BDHttpDnsResult(BDHttpDnsResult.ResolveType.RESOLVE_NONEED, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK, null, this.f43545f));
    }
}
