package d.a.d0.b.g;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.io.File;
/* loaded from: classes2.dex */
public class i {
    @Nullable
    public static File a(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return f.o(str);
    }
}
