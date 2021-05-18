package d.a.i0.b.j;

import android.os.Bundle;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
/* loaded from: classes3.dex */
public class i extends ProviderDelegation {
    @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
    public Bundle execCall(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        a0 A = a.A(getAgent().getContext());
        bundle2.putString("NICK_NAME", A.f46072a);
        bundle2.putString("AVATAR_URL", A.f46073b);
        return bundle2;
    }
}
