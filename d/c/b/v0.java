package d.c.b;

import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public final class v0 {

    /* renamed from: a  reason: collision with root package name */
    public static final AtomicBoolean f65931a = new AtomicBoolean(false);

    /* renamed from: b  reason: collision with root package name */
    public static String f65932b = "";

    public static String a(SharedPreferences sharedPreferences) {
        if (f65931a.compareAndSet(false, true)) {
            String string = sharedPreferences.getString("cdid", "");
            f65932b = string;
            if (TextUtils.isEmpty(string)) {
                f65932b = UUID.randomUUID().toString();
                sharedPreferences.edit().putString("cdid", f65932b).apply();
            }
        }
        return f65932b;
    }
}
