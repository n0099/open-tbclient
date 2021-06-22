package d.a.m0.a.v2;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.core.content.FileProvider;
import java.io.File;
/* loaded from: classes3.dex */
public final class s0 {
    public static Uri a(@NonNull Context context, @NonNull File file) {
        return FileProvider.getUriForFile(context, b().a(context), file);
    }

    public static d.a.m0.a.p.d.e b() {
        return d.a.m0.a.c1.a.o();
    }
}
