package d.a.o0.e3;

import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class u {
    public static boolean a(String str, Boolean bool) {
        if (SwitchManager.getInstance().findType("voice") != 0 || ((str != null && b(str)) || bool == null)) {
            return false;
        }
        return bool.booleanValue();
    }

    public static boolean b(String str) {
        String[] stringArray = TbadkCoreApplication.getInst().getApp().getResources().getStringArray(R.array.voice_black_frs_list);
        String string = TbadkCoreApplication.getInst().getApp().getResources().getString(R.string.forum);
        int length = stringArray.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (stringArray[i2].equals(str)) {
                return true;
            }
            if (str.equals(stringArray[i2] + string)) {
                return true;
            }
        }
        return false;
    }
}
