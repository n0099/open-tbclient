package d.a.m0.c1.b;

import android.content.SharedPreferences;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final SharedPreferences f49238a = TbadkCoreApplication.getInst().getSharedPreferences("youngster_tip_sp", 0);

    /* renamed from: b  reason: collision with root package name */
    public String f49239b;

    /* renamed from: c  reason: collision with root package name */
    public String f49240c;

    public b(String str, String str2) {
        this.f49239b = str;
        this.f49240c = str2;
    }

    public void a(long j) {
        if (b(this.f49239b, this.f49240c)) {
            String str = this.f49239b + '_' + this.f49240c + "_youngster_tip_times";
            String str2 = this.f49239b + '_' + this.f49240c + "_youngster_tip_time";
            int i2 = this.f49238a.getInt(str, 0);
            SharedPreferences.Editor edit = this.f49238a.edit();
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
        if (b(this.f49239b, this.f49240c)) {
            return this.f49238a.getLong(this.f49239b + '_' + this.f49240c + "_youngster_tip_time", 0L);
        }
        return 0L;
    }

    public int d() {
        if (b(this.f49239b, this.f49240c)) {
            return this.f49238a.getInt(this.f49239b + '_' + this.f49240c + "_youngster_tip_times", 0);
        }
        return 0;
    }
}
