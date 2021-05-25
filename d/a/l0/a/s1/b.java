package d.a.l0.a.s1;

import android.content.Context;
import android.content.DialogInterface;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.SwanAppBaseActivity;
import com.coremedia.iso.boxes.FreeSpaceBox;
import d.a.l0.a.k2.g.h;
import d.a.l0.a.s1.g;
import d.a.l0.a.v2.a0;
import d.a.l0.a.v2.q0;
import d.a.l0.a.z1.b.b.f;
/* loaded from: classes3.dex */
public final class b implements g.a {

    /* renamed from: a  reason: collision with root package name */
    public boolean f44668a = false;

    /* renamed from: b  reason: collision with root package name */
    public boolean f44669b = false;

    /* renamed from: c  reason: collision with root package name */
    public boolean f44670c = false;

    /* renamed from: d  reason: collision with root package name */
    public final int f44671d;

    /* renamed from: e  reason: collision with root package name */
    public final f f44672e;

    /* renamed from: f  reason: collision with root package name */
    public final Context f44673f;

    /* loaded from: classes3.dex */
    public class a implements DialogInterface.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f44674e;

        public a(String str) {
            this.f44674e = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            if (b.this.f44668a) {
                if (!b.this.f44669b) {
                    b.this.h(this.f44674e, i2, dialogInterface);
                } else {
                    dialogInterface.dismiss();
                }
            }
        }
    }

    /* renamed from: d.a.l0.a.s1.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class DialogInterface$OnClickListenerC0819b implements DialogInterface.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f44676e;

        public DialogInterface$OnClickListenerC0819b(String str) {
            this.f44676e = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            b.this.i(this.f44676e, i2, dialogInterface);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements DialogInterface.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f44678e;

        public c(String str) {
            this.f44678e = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            b.this.h(this.f44678e, i2, dialogInterface);
        }
    }

    /* loaded from: classes3.dex */
    public class d implements DialogInterface.OnShowListener {
        public d() {
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            b.this.f44668a = true;
            b.this.j("show");
        }
    }

    /* loaded from: classes3.dex */
    public class e implements DialogInterface.OnDismissListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f44681e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ f f44682f;

        public e(String str, f fVar) {
            this.f44681e = str;
            this.f44682f = fVar;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            b.this.p(this.f44681e, this.f44682f);
            b.this.f44668a = false;
        }
    }

    public b(Context context, int i2, @NonNull f fVar) {
        this.f44673f = context;
        this.f44671d = i2;
        this.f44672e = fVar;
    }

    public final void h(String str, int i2, DialogInterface dialogInterface) {
        boolean z = i2 == 1;
        r(str, z);
        if (z) {
            j("deny_mute");
        } else {
            j("deny");
        }
        dialogInterface.dismiss();
    }

    public final void i(String str, int i2, DialogInterface dialogInterface) {
        boolean z = i2 == 1;
        r(str, z);
        if (z) {
            j("skip_mute");
        } else {
            j(FreeSpaceBox.TYPE);
        }
        this.f44669b = true;
        dialogInterface.dismiss();
        a0.g(this.f44673f);
    }

    public final void j(String str) {
        d.a.l0.a.a2.d g2 = d.a.l0.a.a2.d.g();
        String appId = g2.getAppId();
        d.a.l0.a.j2.p.e eVar = new d.a.l0.a.j2.p.e();
        eVar.f43190f = appId;
        eVar.f43185a = "swan";
        eVar.f43187c = d.a.l0.a.s1.c.a(this.f44671d);
        eVar.f43191g = "minipnl";
        eVar.f43186b = str;
        eVar.f43189e = d.a.l0.a.s1.c.b(this.f44670c);
        eVar.a("appid", appId);
        eVar.a("appname", g2.r().O());
        eVar.a("host", d.a.l0.a.c1.a.m().a());
        d.a.l0.a.j2.g.onEvent(eVar);
    }

    public final boolean k(String str) {
        return h.a().getBoolean(str, false);
    }

    public final String l(String str) {
        String D = d.a.l0.a.a2.d.g().r().D();
        return "permission/" + str + "/" + D;
    }

    public final String m(String str) {
        Context applicationContext = d.a.l0.a.a2.d.g().getApplicationContext();
        return applicationContext.getString(d.a.l0.a.h.swanapp_perm_hover_dialog_tip, q0.l(applicationContext), str);
    }

    public final String n(String str) {
        return d.a.l0.a.a2.d.g().getApplicationContext().getString(d.a.l0.a.h.swanapp_perm_hover_dialog_title, str);
    }

    public final d.a.l0.a.z1.b.b.f o(Context context, String str, String str2, String str3, String str4, f fVar) {
        f.a aVar = new f.a(context);
        aVar.f0(str);
        aVar.e0(str2);
        aVar.i0(new e(str4, fVar));
        aVar.j0(new d());
        aVar.g0(new c(str3));
        aVar.k0(new DialogInterface$OnClickListenerC0819b(str3));
        aVar.h0(new a(str3));
        return aVar.c();
    }

    @Override // d.a.l0.a.s1.g.a
    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (i2 != this.f44671d) {
            this.f44672e.b(2, "request permission fail");
        } else if (strArr.length == 0 && iArr.length == 0) {
            this.f44672e.a("permission granted successful");
        } else if (strArr.length != iArr.length) {
            this.f44672e.b(2, "request permission fail");
        } else if (!(this.f44673f instanceof SwanAppBaseActivity)) {
            this.f44672e.b(2, "request permission fail");
        } else {
            for (int i3 = 0; i3 < iArr.length; i3++) {
                String str = strArr[i3];
                if (iArr[i3] == -1) {
                    if (!d.a.l0.o.a.a.a.k((SwanAppBaseActivity) this.f44673f, str)) {
                        q(str, this.f44672e);
                        return;
                    } else {
                        this.f44672e.b(1, "user denied");
                        return;
                    }
                }
            }
            this.f44672e.a("permission granted successful");
        }
    }

    public final void p(String str, f fVar) {
        Context context = this.f44673f;
        boolean z = context != null && d.a.l0.u.d.c.a(context, str);
        this.f44670c = z;
        if (z) {
            fVar.a("permission granted successful");
        } else {
            fVar.b(1, "user denied");
        }
    }

    public final void q(String str, f fVar) {
        if (!(this.f44673f instanceof SwanAppBaseActivity)) {
            this.f44672e.b(2, "request permission fail");
            return;
        }
        String l = l(str);
        if (k(l)) {
            this.f44672e.b(2, "request permission fail");
            return;
        }
        String n = a0.n(str);
        if (n != null && n.trim().length() != 0) {
            o(this.f44673f, n(n), m(n), l, str, fVar).show();
            return;
        }
        this.f44672e.b(2, "request permission fail");
    }

    public final void r(String str, boolean z) {
        if (str != null) {
            h.a().putBoolean(str, z);
        }
    }

    public g.a s() {
        return new d.a.l0.a.s1.a(this.f44671d, this.f44672e);
    }
}
