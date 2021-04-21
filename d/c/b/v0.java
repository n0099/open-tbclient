package d.c.b;

import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public final class v0 {

    /* renamed from: a  reason: collision with root package name */
    public static final AtomicBoolean f66026a = new AtomicBoolean(false);

    /* renamed from: b  reason: collision with root package name */
    public static String f66027b = "";

    public static String a(SharedPreferences sharedPreferences) {
        if (f66026a.compareAndSet(false, true)) {
            String string = sharedPreferences.getString("cdid", "");
            f66027b = string;
            if (TextUtils.isEmpty(string)) {
                f66027b = UUID.randomUUID().toString();
                sharedPreferences.edit().putString("cdid", f66027b).apply();
            }
        }
        return f66027b;
    }
}
