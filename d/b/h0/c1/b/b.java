package d.b.h0.c1.b;

import android.content.SharedPreferences;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final SharedPreferences f50083a = TbadkCoreApplication.getInst().getSharedPreferences("youngster_tip_sp", 0);

    /* renamed from: b  reason: collision with root package name */
    public String f50084b;

    /* renamed from: c  reason: collision with root package name */
    public String f50085c;

    public b(String str, String str2) {
        this.f50084b = str;
        this.f50085c = str2;
    }

    public void a(long j) {
        if (b(this.f50084b, this.f50085c)) {
            String str = this.f50084b + '_' + this.f50085c + "_youngster_tip_times";
            String str2 = this.f50084b + '_' + this.f50085c + "_youngster_tip_time";
            int i = this.f50083a.getInt(str, 0);
            SharedPreferences.Editor edit = this.f50083a.edit();
            int i2 = i + 1;
            if (i2 <= 10) {
                i = i2;
            }
            edit.putInt(str, i);
            edit.putLong(str2, j);
            edit.apply();
        }
    }

    public final boolean b(String str, String str2) {
        return (StringUtils.isNull(str) || StringUtils.isNull(str2) || "0".equals(str) || "0".equals(str2)) ? false : true;
    }

    public long c() {
        if (b(this.f50084b, this.f50085c)) {
            return this.f50083a.getLong(this.f50084b + '_' + this.f50085c + "_youngster_tip_time", 0L);
        }
        return 0L;
    }

    public int d() {
        if (b(this.f50084b, this.f50085c)) {
            return this.f50083a.getInt(this.f50084b + '_' + this.f50085c + "_youngster_tip_times", 0);
        }
        return 0;
    }
}
