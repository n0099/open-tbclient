package d.b.i0.e3;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import tbclient.GetIconList.Setting;
import tbclient.GetIconList.UserInfo;
/* loaded from: classes5.dex */
public class b {
    public static String a(int i) {
        if (i < 0) {
            i = 0;
        }
        String valueOf = String.valueOf(i);
        if (i >= 1000000) {
            float f2 = i / 10000.0f;
            int i2 = i / 10000;
            if (f2 > i2) {
                return String.format("%.1f", Float.valueOf(f2)) + TbadkCoreApplication.getInst().getResources().getString(R.string.unit_wan);
            }
            return i2 + TbadkCoreApplication.getInst().getResources().getString(R.string.unit_wan);
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

    public static int c(UserInfo userInfo, int i, Setting setting) {
        if (userInfo == null || userInfo.is_mem == null) {
            return 0;
        }
        return userInfo.is_mem.intValue() != 2 ? i : (setting == null || setting.vip_extra_switch.intValue() != 1 || setting.vip_extra_percent.intValue() <= 0) ? i : ((setting.vip_extra_percent.intValue() * i) / 100) + i;
    }

    public static int d(int i) {
        return (int) (i / 100.0f);
    }
}
