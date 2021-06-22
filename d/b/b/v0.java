package d.b.b;

import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public final class v0 {

    /* renamed from: a  reason: collision with root package name */
    public static final AtomicBoolean f68950a = new AtomicBoolean(false);

    /* renamed from: b  reason: collision with root package name */
    public static String f68951b = "";

    public static String a(SharedPreferences sharedPreferences) {
        if (f68950a.compareAndSet(false, true)) {
            String string = sharedPreferences.getString("cdid", "");
            f68951b = string;
            if (TextUtils.isEmpty(string)) {
                f68951b = UUID.randomUUID().toString();
                sharedPreferences.edit().putString("cdid", f68951b).apply();
            }
        }
        return f68951b;
    }
}
