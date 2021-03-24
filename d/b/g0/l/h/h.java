package d.b.g0.l.h;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.HashSet;
/* loaded from: classes3.dex */
public final class h {
    @NonNull
    public static Bundle a(@NonNull e eVar, @Nullable Bundle bundle, String... strArr) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (bundle.getLong("timestamp", -1L) < 0) {
            bundle.putLong("timestamp", System.currentTimeMillis());
        }
        return eVar.g(bundle, new HashSet(Arrays.asList(strArr)));
    }

    @NonNull
    public static Bundle b(@NonNull e eVar, @NonNull String... strArr) {
        return a(eVar, null, strArr);
    }
}
