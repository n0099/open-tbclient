package d.a.m0.o.a.b;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Process;
import androidx.annotation.NonNull;
/* loaded from: classes3.dex */
public class a {
    public static int a(@NonNull Context context, @NonNull String str) {
        if (str != null) {
            return context.checkPermission(str, Process.myPid(), Process.myUid());
        }
        throw new IllegalArgumentException("permission is null");
    }

    public static final int b(Context context, int i2) {
        if (Build.VERSION.SDK_INT >= 23) {
            return c.a(context, i2);
        }
        return context.getResources().getColor(i2);
    }

    public static final ColorStateList c(Context context, int i2) {
        if (Build.VERSION.SDK_INT >= 23) {
            return c.b(context, i2);
        }
        return context.getResources().getColorStateList(i2);
    }

    public static final Drawable d(Context context, int i2) {
        if (Build.VERSION.SDK_INT >= 21) {
            return b.a(context, i2);
        }
        return context.getResources().getDrawable(i2);
    }
}
