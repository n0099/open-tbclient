package d.a.m0.c1.b;

import android.content.SharedPreferences;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final SharedPreferences f52912a = TbadkCoreApplication.getInst().getSharedPreferences("youngster_tip_sp", 0);

    /* renamed from: b  reason: collision with root package name */
    public String f52913b;

    /* renamed from: c  reason: collision with root package name */
    public String f52914c;

    public b(String str, String str2) {
        this.f52913b = str;
        this.f52914c = str2;
    }

    public void a(long j) {
        if (b(this.f52913b, this.f52914c)) {
            String str = this.f52913b + '_' + this.f52914c + "_youngster_tip_times";
            String str2 = this.f52913b + '_' + this.f52914c + "_youngster_tip_time";
            int i2 = this.f52912a.getInt(str, 0);
            SharedPreferences.Editor edit = this.f52912a.edit();
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
        if (b(this.f52913b, this.f52914c)) {
            return this.f52912a.getLong(this.f52913b + '_' + this.f52914c + "_youngster_tip_time", 0L);
        }
        return 0L;
    }

    public int d() {
        if (b(this.f52913b, this.f52914c)) {
            return this.f52912a.getInt(this.f52913b + '_' + this.f52914c + "_youngster_tip_times", 0);
        }
        return 0;
    }
}
