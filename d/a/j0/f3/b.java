package d.a.j0.f3;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import tbclient.GetIconList.Setting;
import tbclient.GetIconList.UserInfo;
/* loaded from: classes5.dex */
public class b {
    public static String a(int i2) {
        if (i2 < 0) {
            i2 = 0;
        }
        String valueOf = String.valueOf(i2);
        if (i2 >= 1000000) {
            float f2 = i2 / 10000.0f;
            int i3 = i2 / 10000;
            if (f2 > i3) {
                return String.format("%.1f", Float.valueOf(f2)) + TbadkCoreApplication.getInst().getResources().getString(R.string.unit_wan);
            }
            return i3 + TbadkCoreApplication.getInst().getResources().getString(R.string.unit_wan);
        }
        return valueOf;
    }

    public static String b(long j) {
        if (j < 0) {
            j = 0;
        }
        String valueOf = String.valueOf(j);
        if (j >= 1000000) {
            float f2 = ((float) j) / 10000.0f;
            long j2 = j / 10000;
            if (f2 > ((float) j2)) {
                return String.format("%.1f", Float.valueOf(f2)) + TbadkCoreApplication.getInst().getResources().getString(R.string.unit_wan);
            }
            return j2 + TbadkCoreApplication.getInst().getResources().getString(R.string.unit_wan);
        }
        return valueOf;
    }

    public static int c(UserInfo userInfo, int i2, Setting setting) {
        if (userInfo == null || userInfo.is_mem == null) {
            return 0;
        }
        return userInfo.is_mem.intValue() != 2 ? i2 : (setting == null || setting.vip_extra_switch.intValue() != 1 || setting.vip_extra_percent.intValue() <= 0) ? i2 : ((setting.vip_extra_percent.intValue() * i2) / 100) + i2;
    }

    public static int d(int i2) {
        return (int) (i2 / 100.0f);
    }
}
