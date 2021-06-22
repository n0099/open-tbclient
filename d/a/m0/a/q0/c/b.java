package d.a.m0.a.q0.c;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.favordata.SwanFavorDataManager;
import d.a.m0.a.a2.e;
/* loaded from: classes3.dex */
public class b extends d.a.m0.a.v1.a.a.a {
    @Override // d.a.m0.a.v1.a.a.a
    public void b(@NonNull Bundle bundle) {
        e Q = e.Q();
        if (Q == null || TextUtils.equals(Q.D(), "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u")) {
            return;
        }
        SwanFavorDataManager.h().m(bundle.getString("appKey"), bundle.getBoolean("isFavor"));
    }
}
