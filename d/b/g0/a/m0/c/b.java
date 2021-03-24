package d.b.g0.a.m0.c;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.favordata.SwanFavorDataManager;
import d.b.g0.a.r1.e;
/* loaded from: classes3.dex */
public class b extends d.b.g0.a.n1.a.a.a {
    @Override // d.b.g0.a.n1.a.a.a
    public void b(@NonNull Bundle bundle) {
        e O = e.O();
        if (O == null || TextUtils.equals(O.B(), "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u")) {
            return;
        }
        SwanFavorDataManager.i().n(bundle.getString("appKey"), bundle.getBoolean("isFavor"));
    }
}
