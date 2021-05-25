package d.a.g;

import com.baidu.bdhttpdns.BDHttpDns;
import com.baidu.bdhttpdns.BDHttpDnsResult;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ BDHttpDns.a f39867e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ ArrayList f39868f;

    public a(BDHttpDns bDHttpDns, BDHttpDns.a aVar, ArrayList arrayList) {
        this.f39867e = aVar;
        this.f39868f = arrayList;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f39867e.a(new BDHttpDnsResult(BDHttpDnsResult.ResolveType.RESOLVE_NONEED, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK, this.f39868f, null));
    }
}
