package d.a.m0.a.c0.g;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import d.a.m0.a.e0.d;
import d.a.m0.a.k;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f44704a = k.f46983a;

    public static void a(@NonNull String str, @NonNull String str2) {
        b(str, str2, null);
    }

    public static void b(@NonNull String str, @NonNull String str2, @Nullable Throwable th) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        if (th == null) {
            d.b(str, str2);
            if (f44704a) {
                throw new RuntimeException(str2);
            }
            return;
        }
        d.c(str, str2, th);
        if (f44704a) {
            throw new RuntimeException(str2, th);
        }
    }
}
