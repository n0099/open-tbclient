package d.b.g0.a.r.a;

import android.os.Bundle;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
/* loaded from: classes3.dex */
public class c extends ProviderDelegation {
    @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
    public Bundle execCall(Bundle bundle) {
        boolean z = bundle == null ? false : bundle.getBoolean("status");
        d.b.g0.a.m.c d2 = f.f45696d.d();
        if (d2 != null) {
            d2.a(z);
            return null;
        }
        return null;
    }
}
