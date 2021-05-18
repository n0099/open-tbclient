package d.d.a.a.b;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.apollon.statistics.BasicStoreTools;
/* loaded from: classes6.dex */
public class f {

    /* loaded from: classes6.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public static final f f66008a = new f();
    }

    public static f a() {
        return b.f66008a;
    }

    public String b(Context context) {
        return context.getSharedPreferences("Stat_Sensor_SDK_SendRem", 0).getString(BasicStoreTools.STAT_LAST_SENDDATA, "");
    }

    public void c(Context context, long j) {
        SharedPreferences.Editor edit = context.getSharedPreferences("Stat_Sensor_SDK_SendRem", 0).edit();
        edit.putLong(BasicStoreTools.f3899c, j);
        edit.commit();
    }

    public void d(Context context, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences("Stat_Sensor_SDK_SendRem", 0).edit();
        edit.putString(BasicStoreTools.STAT_LAST_SENDDATA, str);
        edit.commit();
    }

    public long e(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Stat_Sensor_SDK_SendRem", 0);
        try {
            return sharedPreferences.getLong(BasicStoreTools.f3899c, 0L);
        } catch (ClassCastException unused) {
            return sharedPreferences.getInt(BasicStoreTools.f3899c, 0);
        }
    }

    public f() {
    }
}
