package d.b.i0.x0.d;

import android.util.Log;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes3.dex */
public class a {
    public static boolean a() {
        return TbadkCoreApplication.getInst().isDebugMode();
    }

    public static void b(String str) {
        if (a()) {
            Log.d("TemplatePageLoader", str);
        }
    }
}
