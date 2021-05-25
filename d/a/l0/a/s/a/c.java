package d.a.l0.a.s.a;

import android.os.Bundle;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
/* loaded from: classes2.dex */
public class c extends ProviderDelegation {
    @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
    public Bundle execCall(Bundle bundle) {
        boolean z = bundle == null ? false : bundle.getBoolean("status");
        d.a.l0.a.m.c e2 = f.f44582d.e();
        if (e2 != null) {
            e2.a(z);
            return null;
        }
        return null;
    }
}
