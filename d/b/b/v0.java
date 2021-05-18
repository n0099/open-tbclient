package d.b.b;

import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public final class v0 {

    /* renamed from: a  reason: collision with root package name */
    public static final AtomicBoolean f65072a = new AtomicBoolean(false);

    /* renamed from: b  reason: collision with root package name */
    public static String f65073b = "";

    public static String a(SharedPreferences sharedPreferences) {
        if (f65072a.compareAndSet(false, true)) {
            String string = sharedPreferences.getString("cdid", "");
            f65073b = string;
            if (TextUtils.isEmpty(string)) {
                f65073b = UUID.randomUUID().toString();
                sharedPreferences.edit().putString("cdid", f65073b).apply();
            }
        }
        return f65073b;
    }
}
