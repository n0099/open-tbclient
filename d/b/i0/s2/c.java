package d.b.i0.s2;

import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final long f61590a = TimeUnit.DAYS.toMillis(1);

    /* renamed from: b  reason: collision with root package name */
    public static final long f61591b;

    /* renamed from: c  reason: collision with root package name */
    public static final long f61592c;

    static {
        TimeUnit.HOURS.toMillis(1L);
        f61591b = TimeUnit.MINUTES.toMillis(1L);
        f61592c = TimeUnit.SECONDS.toMillis(1L);
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

    public static String c(String str, int i) {
        return str.substring(i + 1);
    }

    public static long d(String str, int i) {
        try {
            return Long.parseLong(str.substring(0, i));
        } catch (Exception unused) {
            return -1L;
        }
    }

    public static boolean e(long j, long j2, int i) {
        return j - j2 > ((long) i) * f61591b;
    }

    public static boolean f(long j, long j2) {
        long j3 = f61590a;
        return j / j3 == j2 / j3;
    }

    public static void g(@NonNull String str, int i) {
        h(str, String.valueOf(i));
    }

    public static void h(@NonNull String str, String str2) {
        SharedPreferences.Editor edit = TbadkCoreApplication.getInst().getSharedPreferences("ad_sp_workplace", 0).edit();
        edit.putString(str, System.currentTimeMillis() + "," + str2);
        edit.apply();
    }
}
