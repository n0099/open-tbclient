package d.a.i0.a.q0.c;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.favordata.SwanFavorDataManager;
/* loaded from: classes2.dex */
public class a extends d.a.i0.a.v1.a.a.a {
    @Override // d.a.i0.a.v1.a.a.a
    public void b(@NonNull Bundle bundle) {
        SwanFavorDataManager.h().m(bundle.getString("appKey"), bundle.getBoolean("isFavor"));
    }
}
