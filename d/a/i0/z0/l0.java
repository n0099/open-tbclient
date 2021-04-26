package d.a.i0.z0;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import tbclient.NewGodInfo;
/* loaded from: classes3.dex */
public class l0 {
    public static String a(int i2) {
        return c(i2 == 2);
    }

    public static String b(NewGodInfo newGodInfo) {
        return c(newGodInfo != null && newGodInfo.type.intValue() == 2);
    }

    public static String c(boolean z) {
        if (z) {
            return TbadkCoreApplication.getInst().getApp().getString(R.string.field_new_video_god);
        }
        return TbadkCoreApplication.getInst().getApp().getString(R.string.field_new_god);
    }
}
