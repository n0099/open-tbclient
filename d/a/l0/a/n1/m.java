package d.a.l0.a.n1;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.baidu.searchbox.http.NetworkQuality;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
/* loaded from: classes3.dex */
public class m extends d.a.l0.a.v1.a.a.a {
    @Override // d.a.l0.a.v1.a.a.a
    public void b(@NonNull Bundle bundle) {
        if (SwanAppNetworkUtils.h()) {
            this.f48946d.putInt("net_quality", NetworkQuality.getNetworkQuality());
        } else {
            this.f48946d.putInt("net_quality", 3);
        }
        c();
    }
}
