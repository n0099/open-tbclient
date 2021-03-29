package d.c.b;

import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public final class v0 {

    /* renamed from: a  reason: collision with root package name */
    public static final AtomicBoolean f65086a = new AtomicBoolean(false);

    /* renamed from: b  reason: collision with root package name */
    public static String f65087b = "";

    public static String a(SharedPreferences sharedPreferences) {
        if (f65086a.compareAndSet(false, true)) {
            String string = sharedPreferences.getString("cdid", "");
            f65087b = string;
            if (TextUtils.isEmpty(string)) {
                f65087b = UUID.randomUUID().toString();
                sharedPreferences.edit().putString("cdid", f65087b).apply();
            }
        }
        return f65087b;
    }
}
