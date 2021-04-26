package d.a.h0.a.j1;

import android.os.Bundle;
import com.baidu.searchbox.process.ipc.delegate.DelegateResult;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
/* loaded from: classes3.dex */
public class c extends ProviderDelegation {

    /* renamed from: a  reason: collision with root package name */
    public static long f42920a = -1;

    public static long a() {
        long j = f42920a;
        if (j >= 0) {
            return j;
        }
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(d.a.h0.a.w0.a.c(), c.class, null);
        long j2 = callOnMainWithContentProvider.isOk() ? callOnMainWithContentProvider.mResult.getLong("result", 0L) : 0L;
        f42920a = j2;
        return j2;
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
    public Bundle execCall(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putLong("result", d.a.h0.a.w0.a.l().I());
        return bundle2;
    }
}
