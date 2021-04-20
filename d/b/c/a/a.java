package d.b.c.a;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.res.TypedArray;
import android.os.Build;
import androidx.annotation.NonNull;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public class a {
    public static boolean a(int i) {
        if (i != 0 && i != 1 && i != 11 && i != 12) {
            switch (i) {
                case 6:
                case 7:
                case 8:
                case 9:
                    break;
                default:
                    return false;
            }
        }
        return true;
    }

    public static void b(@NonNull Activity activity) {
        if (d(activity)) {
            try {
                Field declaredField = Activity.class.getDeclaredField("mActivityInfo");
                declaredField.setAccessible(true);
                ActivityInfo activityInfo = (ActivityInfo) declaredField.get(activity);
                if (a(activityInfo.screenOrientation)) {
                    activityInfo.screenOrientation = -1;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static boolean c(Activity activity) {
        try {
            Field declaredField = Class.forName("com.android.internal.R$styleable").getDeclaredField("Window");
            declaredField.setAccessible(true);
            TypedArray obtainStyledAttributes = activity.obtainStyledAttributes((int[]) declaredField.get(null));
            Method declaredMethod = ActivityInfo.class.getDeclaredMethod("isTranslucentOrFloating", TypedArray.class);
            declaredMethod.setAccessible(true);
            return ((Boolean) declaredMethod.invoke(null, obtainStyledAttributes)).booleanValue();
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean d(Activity activity) {
        return Build.VERSION.SDK_INT == 26 && c(activity);
    }
}
