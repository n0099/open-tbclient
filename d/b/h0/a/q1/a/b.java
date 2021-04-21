package d.b.h0.a.q1.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.swan.apps.res.ui.FullScreenFloatView;
import d.b.h0.a.g;
/* loaded from: classes3.dex */
public class b {
    public static FullScreenFloatView a(Context context, ViewGroup viewGroup, int i) {
        if (context == null || viewGroup == null) {
            return null;
        }
        FullScreenFloatView b2 = b(context, i);
        viewGroup.addView(b2);
        return b2;
    }

    public static FullScreenFloatView b(Context context, int i) {
        if (context == null) {
            return null;
        }
        int i2 = g.aiapps_fullscreen_floatview;
        if (i != 1 && i == 2) {
            i2 = g.aiapps_fullscreen_floatview_button;
        }
        return (FullScreenFloatView) LayoutInflater.from(context.getApplicationContext()).inflate(i2, (ViewGroup) null);
    }
}
