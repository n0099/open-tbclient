package d.a.i0.c1.b;

import android.content.SharedPreferences;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final SharedPreferences f48384a = TbadkCoreApplication.getInst().getSharedPreferences("youngster_tip_sp", 0);

    /* renamed from: b  reason: collision with root package name */
    public String f48385b;

    /* renamed from: c  reason: collision with root package name */
    public String f48386c;

    public b(String str, String str2) {
        this.f48385b = str;
        this.f48386c = str2;
    }

    public void a(long j) {
        if (b(this.f48385b, this.f48386c)) {
            String str = this.f48385b + '_' + this.f48386c + "_youngster_tip_times";
            String str2 = this.f48385b + '_' + this.f48386c + "_youngster_tip_time";
            int i2 = this.f48384a.getInt(str, 0);
            SharedPreferences.Editor edit = this.f48384a.edit();
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
        if (b(this.f48385b, this.f48386c)) {
            return this.f48384a.getLong(this.f48385b + '_' + this.f48386c + "_youngster_tip_time", 0L);
        }
        return 0L;
    }

    public int d() {
        if (b(this.f48385b, this.f48386c)) {
            return this.f48384a.getInt(this.f48385b + '_' + this.f48386c + "_youngster_tip_times", 0);
        }
        return 0;
    }
}
