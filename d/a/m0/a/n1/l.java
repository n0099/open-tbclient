package d.a.m0.a.n1;

import android.os.Bundle;
import com.baidu.searchbox.http.NetworkQuality;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
/* loaded from: classes3.dex */
public class l extends ProviderDelegation {
    public static int a() {
        d.a.m0.a.v1.b.f b2 = d.a.m0.a.v1.b.d.b(l.class, null);
        if (b2.a()) {
            return b2.f49079a.getInt("net_quality", -1);
        }
        return -1;
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
    public Bundle execCall(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (SwanAppNetworkUtils.h()) {
            bundle2.putInt("net_quality", NetworkQuality.getNetworkQuality());
        } else {
            bundle2.putInt("net_quality", 3);
        }
        return bundle2;
    }
}
