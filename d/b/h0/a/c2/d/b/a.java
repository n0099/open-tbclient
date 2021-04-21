package d.b.h0.a.c2.d.b;

import android.app.Activity;
import android.content.Context;
import android.provider.Settings;
import android.view.Window;
import android.view.WindowManager;
import d.b.h0.a.k;
/* loaded from: classes3.dex */
public class a {

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final a f44499a = new a();
    }

    static {
        boolean z = k.f45772a;
    }

    public static a b() {
        return b.f44499a;
    }

    public static float c(Context context) {
        int i;
        try {
            i = Settings.System.getInt(context.getContentResolver(), "screen_brightness");
        } catch (Exception e2) {
            e2.printStackTrace();
            i = 0;
        }
        return i * 0.003921569f;
    }

    public float a(Activity activity) {
        if (activity != null) {
            float f2 = activity.getWindow().getAttributes().screenBrightness;
            return f2 < 0.0f ? c(activity) : f2;
        }
        return -1.0f;
    }

    public void d(Activity activity, float f2) {
        if (activity != null) {
            WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
            attributes.screenBrightness = f2;
            activity.getWindow().setAttributes(attributes);
        }
    }

    public void e(Activity activity, boolean z) {
        Window window;
        if (activity == null || (window = activity.getWindow()) == null) {
            return;
        }
        if (z) {
            window.addFlags(128);
        } else {
            window.clearFlags(128);
        }
    }

    public a() {
    }
}
