package d.a.j0.c1.b;

import android.content.SharedPreferences;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final SharedPreferences f49212a = TbadkCoreApplication.getInst().getSharedPreferences("youngster_tip_sp", 0);

    /* renamed from: b  reason: collision with root package name */
    public String f49213b;

    /* renamed from: c  reason: collision with root package name */
    public String f49214c;

    public b(String str, String str2) {
        this.f49213b = str;
        this.f49214c = str2;
    }

    public void a(long j) {
        if (b(this.f49213b, this.f49214c)) {
            String str = this.f49213b + '_' + this.f49214c + "_youngster_tip_times";
            String str2 = this.f49213b + '_' + this.f49214c + "_youngster_tip_time";
            int i2 = this.f49212a.getInt(str, 0);
            SharedPreferences.Editor edit = this.f49212a.edit();
            int i3 = i2 + 1;
            if (i3 <= 10) {
                i2 = i3;
            }
            edit.putInt(str, i2);
            edit.putLong(str2, j);
            edit.apply();
        }
    }

    public final boolean b(String str, String str2) {
        return (StringUtils.isNull(str) || StringUtils.isNull(str2) || "0".equals(str) || "0".equals(str2)) ? false : true;
    }

    public long c() {
        if (b(this.f49213b, this.f49214c)) {
            return this.f49212a.getLong(this.f49213b + '_' + this.f49214c + "_youngster_tip_time", 0L);
        }
        return 0L;
    }

    public int d() {
        if (b(this.f49213b, this.f49214c)) {
            return this.f49212a.getInt(this.f49213b + '_' + this.f49214c + "_youngster_tip_times", 0);
        }
        return 0;
    }
}
