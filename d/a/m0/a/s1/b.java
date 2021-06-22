package d.a.m0.a.s1;

import android.content.Context;
import android.content.DialogInterface;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.SwanAppBaseActivity;
import com.coremedia.iso.boxes.FreeSpaceBox;
import d.a.m0.a.k2.g.h;
import d.a.m0.a.s1.g;
import d.a.m0.a.v2.a0;
import d.a.m0.a.v2.q0;
import d.a.m0.a.z1.b.b.f;
/* loaded from: classes3.dex */
public final class b implements g.a {

    /* renamed from: a  reason: collision with root package name */
    public boolean f48450a = false;

    /* renamed from: b  reason: collision with root package name */
    public boolean f48451b = false;

    /* renamed from: c  reason: collision with root package name */
    public boolean f48452c = false;

    /* renamed from: d  reason: collision with root package name */
    public final int f48453d;

    /* renamed from: e  reason: collision with root package name */
    public final f f48454e;

    /* renamed from: f  reason: collision with root package name */
    public final Context f48455f;

    /* loaded from: classes3.dex */
    public class a implements DialogInterface.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48456e;

        public a(String str) {
            this.f48456e = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            if (b.this.f48450a) {
                if (!b.this.f48451b) {
                    b.this.h(this.f48456e, i2, dialogInterface);
                } else {
                    dialogInterface.dismiss();
                }
            }
        }
    }

    /* renamed from: d.a.m0.a.s1.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class DialogInterface$OnClickListenerC0878b implements DialogInterface.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48458e;

        public DialogInterface$OnClickListenerC0878b(String str) {
            this.f48458e = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            b.this.i(this.f48458e, i2, dialogInterface);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements DialogInterface.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48460e;

        public c(String str) {
            this.f48460e = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            b.this.h(this.f48460e, i2, dialogInterface);
        }
    }

    /* loaded from: classes3.dex */
    public class d implements DialogInterface.OnShowListener {
        public d() {
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            b.this.f48450a = true;
            b.this.j("show");
        }
    }

    /* loaded from: classes3.dex */
    public class e implements DialogInterface.OnDismissListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48463e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ f f48464f;

        public e(String str, f fVar) {
            this.f48463e = str;
            this.f48464f = fVar;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            b.this.p(this.f48463e, this.f48464f);
            b.this.f48450a = false;
        }
    }

    public b(Context context, int i2, @NonNull f fVar) {
        this.f48455f = context;
        this.f48453d = i2;
        this.f48454e = fVar;
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
        this.f48451b = true;
        dialogInterface.dismiss();
        a0.g(this.f48455f);
    }

    public final void j(String str) {
        d.a.m0.a.a2.d g2 = d.a.m0.a.a2.d.g();
        String appId = g2.getAppId();
        d.a.m0.a.j2.p.e eVar = new d.a.m0.a.j2.p.e();
        eVar.f46974f = appId;
        eVar.f46969a = "swan";
        eVar.f46971c = d.a.m0.a.s1.c.a(this.f48453d);
        eVar.f46975g = "minipnl";
        eVar.f46970b = str;
        eVar.f46973e = d.a.m0.a.s1.c.b(this.f48452c);
        eVar.a("appid", appId);
        eVar.a("appname", g2.r().O());
        eVar.a("host", d.a.m0.a.c1.a.m().a());
        d.a.m0.a.j2.g.onEvent(eVar);
    }

    public final boolean k(String str) {
        return h.a().getBoolean(str, false);
    }

    public final String l(String str) {
        String D = d.a.m0.a.a2.d.g().r().D();
        return "permission/" + str + "/" + D;
    }

    public final String m(String str) {
        Context applicationContext = d.a.m0.a.a2.d.g().getApplicationContext();
        return applicationContext.getString(d.a.m0.a.h.swanapp_perm_hover_dialog_tip, q0.l(applicationContext), str);
    }

    public final String n(String str) {
        return d.a.m0.a.a2.d.g().getApplicationContext().getString(d.a.m0.a.h.swanapp_perm_hover_dialog_title, str);
    }

    public final d.a.m0.a.z1.b.b.f o(Context context, String str, String str2, String str3, String str4, f fVar) {
        f.a aVar = new f.a(context);
        aVar.f0(str);
        aVar.e0(str2);
        aVar.i0(new e(str4, fVar));
        aVar.j0(new d());
        aVar.g0(new c(str3));
        aVar.k0(new DialogInterface$OnClickListenerC0878b(str3));
        aVar.h0(new a(str3));
        return aVar.c();
    }

    @Override // d.a.m0.a.s1.g.a
    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (i2 != this.f48453d) {
            this.f48454e.b(2, "request permission fail");
        } else if (strArr.length == 0 && iArr.length == 0) {
            this.f48454e.a("permission granted successful");
        } else if (strArr.length != iArr.length) {
            this.f48454e.b(2, "request permission fail");
        } else if (!(this.f48455f instanceof SwanAppBaseActivity)) {
            this.f48454e.b(2, "request permission fail");
        } else {
            for (int i3 = 0; i3 < iArr.length; i3++) {
                String str = strArr[i3];
                if (iArr[i3] == -1) {
                    if (!d.a.m0.o.a.a.a.k((SwanAppBaseActivity) this.f48455f, str)) {
                        q(str, this.f48454e);
                        return;
                    } else {
                        this.f48454e.b(1, "user denied");
                        return;
                    }
                }
            }
            this.f48454e.a("permission granted successful");
        }
    }

    public final void p(String str, f fVar) {
        Context context = this.f48455f;
        boolean z = context != null && d.a.m0.u.d.c.a(context, str);
        this.f48452c = z;
        if (z) {
            fVar.a("permission granted successful");
        } else {
            fVar.b(1, "user denied");
        }
    }

    public final void q(String str, f fVar) {
        if (!(this.f48455f instanceof SwanAppBaseActivity)) {
            this.f48454e.b(2, "request permission fail");
            return;
        }
        String l = l(str);
        if (k(l)) {
            this.f48454e.b(2, "request permission fail");
            return;
        }
        String n = a0.n(str);
        if (n != null && n.trim().length() != 0) {
            o(this.f48455f, n(n), m(n), l, str, fVar).show();
            return;
        }
        this.f48454e.b(2, "request permission fail");
    }

    public final void r(String str, boolean z) {
        if (str != null) {
            h.a().putBoolean(str, z);
        }
    }

    public g.a s() {
        return new d.a.m0.a.s1.a(this.f48453d, this.f48454e);
    }
}
