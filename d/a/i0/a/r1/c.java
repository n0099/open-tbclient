package d.a.i0.a.r1;

import android.os.Bundle;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
/* loaded from: classes3.dex */
public class c extends ProviderDelegation {

    /* renamed from: a  reason: collision with root package name */
    public static long f44257a = -1;

    public static long a() {
        long j = f44257a;
        if (j >= 0) {
            return j;
        }
        Bundle a2 = d.a.i0.a.v1.b.d.a(c.class, null);
        long j2 = a2 != null ? a2.getLong("result", 0L) : 0L;
        f44257a = j2;
        return j2;
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
    public Bundle execCall(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putLong("result", d.a.i0.a.c1.a.n().B());
        return bundle2;
    }
}
