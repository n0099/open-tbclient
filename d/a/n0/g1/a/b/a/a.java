package d.a.n0.g1.a.b.a;

import android.os.Build;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class a {
    public static boolean a(BaseFragmentActivity baseFragmentActivity, int i2) {
        if (TbadkCoreApplication.getInst().appResponseToCmd(i2)) {
            return true;
        }
        c(baseFragmentActivity);
        return false;
    }

    public static boolean b(BaseFragmentActivity baseFragmentActivity, Class<?> cls) {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(cls)) {
            return true;
        }
        c(baseFragmentActivity);
        return false;
    }

    public static void c(BaseFragmentActivity baseFragmentActivity) {
        if (baseFragmentActivity == null) {
            return;
        }
        if (Build.VERSION.SDK_INT <= 10) {
            baseFragmentActivity.showToast(R.string.plugin_not_exit_for_2_3);
        } else {
            baseFragmentActivity.showToast(R.string.plugin_not_exit);
        }
    }
}
