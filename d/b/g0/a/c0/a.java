package d.b.g0.a.c0;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import com.baidu.swan.apps.SwanAppActivity;
import d.b.g0.a.h;
import d.b.g0.a.q1.b.b.g;
import d.b.g0.a.r1.e;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f43984a;

    /* renamed from: d.b.g0.a.c0.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class DialogInterface$OnClickListenerC0630a implements DialogInterface.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f43985e;

        public DialogInterface$OnClickListenerC0630a(e eVar) {
            this.f43985e = eVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            SwanAppActivity n = this.f43985e.n();
            if (n != null && Build.VERSION.SDK_INT >= 21) {
                n.finishAndRemoveTask();
            }
            System.exit(0);
        }
    }

    public static boolean a() {
        return f43984a;
    }

    public static void b(boolean z) {
        f43984a = z;
    }

    public static void c(Context context, boolean z) {
        e y = e.y();
        if (y != null) {
            b.c(z);
            int i = z ? h.aiapps_open_debug : h.aiapps_close_debug;
            g.a aVar = new g.a(context);
            aVar.V(context.getString(h.aiapps_debug_switch_title));
            aVar.y(context.getString(i));
            aVar.n(new d.b.g0.a.j2.g.a());
            aVar.m(false);
            aVar.O(h.aiapps_confirm, new DialogInterface$OnClickListenerC0630a(y));
            aVar.X();
        }
    }

    public static void d(Context context) {
        c(context, !a());
    }
}
