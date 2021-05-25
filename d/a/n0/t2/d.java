package d.a.n0.t2;

import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.concurrent.TimeUnit;
/* loaded from: classes5.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static final long f61026a = TimeUnit.DAYS.toMillis(1);

    /* renamed from: b  reason: collision with root package name */
    public static final long f61027b;

    /* renamed from: c  reason: collision with root package name */
    public static final long f61028c;

    static {
        TimeUnit.HOURS.toMillis(1L);
        f61027b = TimeUnit.MINUTES.toMillis(1L);
        f61028c = TimeUnit.SECONDS.toMillis(1L);
    }

    public static int a(@NonNull String str) {
        String b2 = b(str);
        if (TextUtils.isEmpty(b2)) {
            return 0;
        }
        try {
            return Integer.parseInt(b2);
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    @Nullable
    public static String b(@NonNull String str) {
        int indexOf;
        String string = TbadkCoreApplication.getInst().getSharedPreferences("ad_sp_workplace", 0).getString(str, null);
        if (TextUtils.isEmpty(string) || (indexOf = string.indexOf(",")) == -1 || !f(d(string, indexOf), System.currentTimeMillis())) {
            return null;
        }
        try {
            return c(string, indexOf);
        } catch (Exception unused) {
            return null;
        }
    }

    public static String c(String str, int i2) {
        return str.substring(i2 + 1);
    }

    public static long d(String str, int i2) {
        try {
            return Long.parseLong(str.substring(0, i2));
        } catch (Exception unused) {
            return -1L;
        }
    }

    public static boolean e(long j, long j2, int i2) {
        return j - j2 > ((long) i2) * f61027b;
    }

    public static boolean f(long j, long j2) {
        long j3 = f61026a;
        return j / j3 == j2 / j3;
    }

    public static void g(@NonNull String str, int i2) {
        h(str, String.valueOf(i2));
    }

    public static void h(@NonNull String str, String str2) {
        SharedPreferences.Editor edit = TbadkCoreApplication.getInst().getSharedPreferences("ad_sp_workplace", 0).edit();
        edit.putString(str, System.currentTimeMillis() + "," + str2);
        edit.apply();
    }
}
