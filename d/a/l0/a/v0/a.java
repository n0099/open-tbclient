package d.a.l0.a.v0;

import android.app.Activity;
import android.content.DialogInterface;
import android.text.TextUtils;
import com.baidu.wallet.paysdk.banksign.datamodel.QueryResponse;
import d.a.l0.a.j2.k;
import d.a.l0.a.z1.b.b.h;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static volatile a f48929b;

    /* renamed from: a  reason: collision with root package name */
    public String f48930a;

    /* renamed from: d.a.l0.a.v0.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class DialogInterface$OnClickListenerC0930a implements DialogInterface.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.h0.j.b f48931e;

        public DialogInterface$OnClickListenerC0930a(a aVar, d.a.l0.a.h0.j.b bVar) {
            this.f48931e = bVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            k.e(QueryResponse.Options.CANCEL);
            this.f48931e.a(Boolean.FALSE);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements DialogInterface.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.h0.j.b f48932e;

        public b(a aVar, d.a.l0.a.h0.j.b bVar) {
            this.f48932e = bVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            k.e("confirm");
            this.f48932e.a(Boolean.TRUE);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements DialogInterface.OnShowListener {
        public c(a aVar) {
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            k.e("show");
        }
    }

    public static a b() {
        if (f48929b == null) {
            synchronized (a.class) {
                if (f48929b == null) {
                    f48929b = new a();
                }
            }
        }
        return f48929b;
    }

    public static void d() {
        if (f48929b == null) {
            return;
        }
        if (f48929b.f48930a != null) {
            f48929b.f48930a = null;
        }
        f48929b = null;
    }

    public String a() {
        return this.f48930a;
    }

    public boolean c() {
        return !TextUtils.isEmpty(this.f48930a);
    }

    public void e(String str) {
        this.f48930a = str;
    }

    public void f(Activity activity, d.a.l0.a.h0.j.b<Boolean> bVar) {
        if (activity == null || bVar == null) {
            return;
        }
        h.a aVar = new h.a(activity);
        aVar.U(d.a.l0.a.h.aiapps_confirm_close_title);
        aVar.x(b().a());
        aVar.n(new d.a.l0.a.w2.h.a());
        aVar.m(true);
        aVar.Q(d.a.l0.a.c.aiapps_modal_confirm_color);
        aVar.O(d.a.l0.a.h.aiapps_cancel, new DialogInterface$OnClickListenerC0930a(this, bVar));
        aVar.B(d.a.l0.a.h.aiapps_confirm, new b(this, bVar));
        aVar.N(new c(this));
        aVar.X();
    }
}
