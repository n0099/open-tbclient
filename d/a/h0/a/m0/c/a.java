package d.a.h0.a.m0.c;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.favordata.SwanFavorDataManager;
/* loaded from: classes2.dex */
public class a extends d.a.h0.a.n1.a.a.a {
    @Override // d.a.h0.a.n1.a.a.a
    public void b(@NonNull Bundle bundle) {
        SwanFavorDataManager.i().n(bundle.getString("appKey"), bundle.getBoolean("isFavor"));
    }
}
