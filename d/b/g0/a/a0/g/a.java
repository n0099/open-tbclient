package d.b.g0.a.a0.g;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import d.b.g0.a.c0.c;
import d.b.g0.a.k;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f43179a = k.f45050a;

    public static void a(@NonNull String str, @NonNull String str2) {
        b(str, str2, null);
    }

    public static void b(@NonNull String str, @NonNull String str2, @Nullable Throwable th) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        if (th == null) {
            c.b(str, str2);
            if (f43179a) {
                throw new RuntimeException(str2);
            }
            return;
        }
        c.c(str, str2, th);
        if (f43179a) {
            throw new RuntimeException(str2, th);
        }
    }
}
