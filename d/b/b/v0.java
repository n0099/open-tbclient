package d.b.b;

import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public final class v0 {

    /* renamed from: a  reason: collision with root package name */
    public static final AtomicBoolean f64386a = new AtomicBoolean(false);

    /* renamed from: b  reason: collision with root package name */
    public static String f64387b = "";

    public static String a(SharedPreferences sharedPreferences) {
        if (f64386a.compareAndSet(false, true)) {
            String string = sharedPreferences.getString("cdid", "");
            f64387b = string;
            if (TextUtils.isEmpty(string)) {
                f64387b = UUID.randomUUID().toString();
                sharedPreferences.edit().putString("cdid", f64387b).apply();
            }
        }
        return f64387b;
    }
}
