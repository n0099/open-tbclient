package d.b.i0.o3;

import android.os.Build;
import android.view.Window;
import android.view.WindowManager;
import java.lang.reflect.Field;
/* loaded from: classes5.dex */
public class c {
    public static int a(int i) {
        if (Build.VERSION.SDK_INT >= 26) {
            return 2038;
        }
        return i;
    }

    public static void b(int i, WindowManager.LayoutParams layoutParams, Window window) {
        if (layoutParams == null || window == null) {
            return;
        }
        try {
            Field declaredField = layoutParams.getClass().getDeclaredField("layoutInDisplayCutoutMode");
            if (declaredField != null) {
                declaredField.set(layoutParams, Integer.valueOf(i));
                window.setAttributes(layoutParams);
            }
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (NoSuchFieldException e3) {
            e3.printStackTrace();
        }
    }
}
