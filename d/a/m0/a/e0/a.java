package d.a.m0.a.e0;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import com.baidu.swan.apps.SwanAppActivity;
import d.a.m0.a.h;
import d.a.m0.a.z1.b.b.h;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f45131a;

    /* renamed from: d.a.m0.a.e0.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class DialogInterface$OnClickListenerC0655a implements DialogInterface.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.a2.e f45132e;

        public DialogInterface$OnClickListenerC0655a(d.a.m0.a.a2.e eVar) {
            this.f45132e = eVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            SwanAppActivity x = this.f45132e.x();
            if (x != null && Build.VERSION.SDK_INT >= 21) {
                x.finishAndRemoveTask();
            }
            System.exit(0);
        }
    }

    public static boolean a() {
        return f45131a;
    }

    public static void b(boolean z) {
        f45131a = z;
    }

    public static void c(Context context, boolean z) {
        d.a.m0.a.a2.e i2 = d.a.m0.a.a2.e.i();
        if (i2 != null) {
            b.c(z);
            int i3 = z ? h.aiapps_open_debug : h.aiapps_close_debug;
            h.a aVar = new h.a(context);
            aVar.V(context.getString(d.a.m0.a.h.aiapps_debug_switch_title));
            aVar.x(context.getString(i3));
            aVar.n(new d.a.m0.a.w2.h.a());
            aVar.m(false);
            aVar.O(d.a.m0.a.h.aiapps_confirm, new DialogInterface$OnClickListenerC0655a(i2));
            aVar.X();
        }
    }

    public static void d(Context context) {
        c(context, !a());
    }
}
