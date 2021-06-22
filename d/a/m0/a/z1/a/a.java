package d.a.m0.a.z1.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.swan.apps.res.ui.FullScreenFloatView;
import d.a.m0.a.g;
/* loaded from: classes3.dex */
public class a {
    public static FullScreenFloatView a(Context context, ViewGroup viewGroup, int i2) {
        if (context == null || viewGroup == null) {
            return null;
        }
        FullScreenFloatView b2 = b(context, i2);
        viewGroup.addView(b2);
        return b2;
    }

    public static FullScreenFloatView b(Context context, int i2) {
        if (context == null) {
            return null;
        }
        int i3 = g.aiapps_fullscreen_floatview;
        if (i2 != 1 && i2 == 2) {
            i3 = g.aiapps_fullscreen_floatview_button;
        }
        return (FullScreenFloatView) LayoutInflater.from(context.getApplicationContext()).inflate(i3, (ViewGroup) null);
    }
}
