package d.b.c.e.p;

import android.content.Context;
import android.text.ClipboardManager;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class a {
    public static void a(String str) {
        if (str == null) {
            str = "";
        }
        try {
            ((ClipboardManager) BdBaseApplication.getInst().getApp().getSystemService("clipboard")).setText(str);
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }

    public static int b(Context context) {
        int identifier;
        if (context != null && (identifier = context.getResources().getIdentifier("navigation_bar_height", "dimen", "android")) > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }
}
