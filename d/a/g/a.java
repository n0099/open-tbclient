package d.a.g;

import com.baidu.bdhttpdns.BDHttpDns;
import com.baidu.bdhttpdns.BDHttpDnsResult;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ BDHttpDns.a f40709e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ ArrayList f40710f;

    public a(BDHttpDns bDHttpDns, BDHttpDns.a aVar, ArrayList arrayList) {
        this.f40709e = aVar;
        this.f40710f = arrayList;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f40709e.a(new BDHttpDnsResult(BDHttpDnsResult.ResolveType.RESOLVE_NONEED, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK, this.f40710f, null));
    }
}
