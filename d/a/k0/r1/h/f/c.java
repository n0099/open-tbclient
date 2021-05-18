package d.a.k0.r1.h.f;

import android.graphics.Color;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class c {
    public static int a(String str) {
        try {
            return Color.parseColor(b(str));
        } catch (Exception unused) {
            return 0;
        }
    }

    public static String b(String str) {
        if (str == null) {
            return null;
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            return TbadkCoreApplication.getInst().getString(R.string.color_prefix) + TbadkCoreApplication.getInst().getString(R.string.tail_color_night) + str;
        }
        return TbadkCoreApplication.getInst().getString(R.string.color_prefix) + str;
    }
}
