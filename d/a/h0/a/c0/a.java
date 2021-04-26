package d.a.h0.a.c0;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import com.baidu.swan.apps.SwanAppActivity;
import d.a.h0.a.h;
import d.a.h0.a.q1.b.b.g;
import d.a.h0.a.r1.e;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f41597a;

    /* renamed from: d.a.h0.a.c0.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class DialogInterface$OnClickListenerC0589a implements DialogInterface.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f41598e;

        public DialogInterface$OnClickListenerC0589a(e eVar) {
            this.f41598e = eVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            SwanAppActivity v = this.f41598e.v();
            if (v != null && Build.VERSION.SDK_INT >= 21) {
                v.finishAndRemoveTask();
            }
            System.exit(0);
        }
    }

    public static boolean a() {
        return f41597a;
    }

    public static void b(boolean z) {
        f41597a = z;
    }

    public static void c(Context context, boolean z) {
        e h2 = e.h();
        if (h2 != null) {
            b.c(z);
            int i2 = z ? h.aiapps_open_debug : h.aiapps_close_debug;
            g.a aVar = new g.a(context);
            aVar.V(context.getString(h.aiapps_debug_switch_title));
            aVar.y(context.getString(i2));
            aVar.n(new d.a.h0.a.j2.g.a());
            aVar.m(false);
            aVar.O(h.aiapps_confirm, new DialogInterface$OnClickListenerC0589a(h2));
            aVar.X();
        }
    }

    public static void d(Context context) {
        c(context, !a());
    }
}
