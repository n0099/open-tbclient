package d.b.h0.a.a0.g;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import d.b.h0.a.c0.c;
import d.b.h0.a.k;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f43901a = k.f45772a;

    public static void a(@NonNull String str, @NonNull String str2) {
        b(str, str2, null);
    }

    public static void b(@NonNull String str, @NonNull String str2, @Nullable Throwable th) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        if (th == null) {
            c.b(str, str2);
            if (f43901a) {
                throw new RuntimeException(str2);
            }
            return;
        }
        c.c(str, str2, th);
        if (f43901a) {
            throw new RuntimeException(str2, th);
        }
    }
}
