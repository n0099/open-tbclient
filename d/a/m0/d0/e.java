package d.a.m0.d0;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
/* loaded from: classes3.dex */
public class e {
    public static d a(View view) {
        if (view == null) {
            return null;
        }
        if (view instanceof LinearLayout) {
            return new f();
        }
        if (view instanceof RelativeLayout) {
            return new i();
        }
        if (view instanceof FrameLayout) {
            return new b();
        }
        return null;
    }

    public static d b(View view, boolean z) {
        if (view == null) {
            return null;
        }
        if (view instanceof LinearLayout) {
            return new f();
        }
        if (view instanceof RelativeLayout) {
            return new i();
        }
        if (view instanceof FrameLayout) {
            return z ? new j() : new b();
        }
        return null;
    }
}
