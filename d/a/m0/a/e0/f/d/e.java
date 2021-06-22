package d.a.m0.a.e0.f.d;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.SwanAppActivity;
import d.a.m0.a.v2.q0;
/* loaded from: classes3.dex */
public class e {

    /* loaded from: classes3.dex */
    public static class a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            SwanAppActivity x;
            d.a.m0.a.a2.e Q = d.a.m0.a.a2.e.Q();
            if (Q == null || (x = Q.x()) == null || x.isFinishing()) {
                return;
            }
            x.addDebugRunningView();
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements View.OnTouchListener {
        @Override // android.view.View.OnTouchListener
        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            SwanAppActivity x;
            d.a.m0.a.a2.e Q = d.a.m0.a.a2.e.Q();
            if (Q == null || (x = Q.x()) == null || x.isFinishing()) {
                return;
            }
            x.removeDebugRunningView();
        }
    }

    @SuppressLint({"InflateParams"})
    public static View a(@NonNull Activity activity) {
        View inflate = LayoutInflater.from(activity).inflate(d.a.m0.a.g.swanapp_local_debug_running_view, (ViewGroup) null);
        inflate.setOnTouchListener(new b());
        ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
        viewGroup.removeView(inflate);
        viewGroup.addView(inflate);
        return inflate;
    }

    public static void b() {
        q0.X(new a());
    }

    public static void c() {
        q0.X(new c());
    }

    public static void d(@NonNull Activity activity, @NonNull View view) {
        ((ViewGroup) activity.getWindow().getDecorView()).removeView(view);
    }
}
