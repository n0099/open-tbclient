package d.a.j0.z0;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.coreExtra.data.NewGodData;
import com.baidu.tieba.R;
import tbclient.NewGodInfo;
/* loaded from: classes3.dex */
public class l0 {
    public static String a(int i2) {
        return d(i2 == 2);
    }

    public static String b(NewGodData newGodData) {
        return d(newGodData != null && newGodData.getType() == 2);
    }

    public static String c(NewGodInfo newGodInfo) {
        return d(newGodInfo != null && newGodInfo.type.intValue() == 2);
    }

    public static String d(boolean z) {
        if (z) {
            return TbadkCoreApplication.getInst().getApp().getString(R.string.field_new_video_god);
        }
        return TbadkCoreApplication.getInst().getApp().getString(R.string.field_new_god);
    }
}
