package d.b.b;

import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public final class v0 {

    /* renamed from: a  reason: collision with root package name */
    public static final AtomicBoolean f68846a = new AtomicBoolean(false);

    /* renamed from: b  reason: collision with root package name */
    public static String f68847b = "";

    public static String a(SharedPreferences sharedPreferences) {
        if (f68846a.compareAndSet(false, true)) {
            String string = sharedPreferences.getString("cdid", "");
            f68847b = string;
            if (TextUtils.isEmpty(string)) {
                f68847b = UUID.randomUUID().toString();
                sharedPreferences.edit().putString("cdid", f68847b).apply();
            }
        }
        return f68847b;
    }
}
