package d.b.g0.a.q0;

import android.app.Activity;
import android.content.DialogInterface;
import android.text.TextUtils;
import com.baidu.wallet.paysdk.banksign.datamodel.QueryResponse;
import d.b.g0.a.q1.b.b.g;
import d.b.g0.a.z1.h;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static volatile a f45493b;

    /* renamed from: a  reason: collision with root package name */
    public String f45494a;

    /* renamed from: d.b.g0.a.q0.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class DialogInterface$OnClickListenerC0759a implements DialogInterface.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.e0.n.b f45495e;

        public DialogInterface$OnClickListenerC0759a(a aVar, d.b.g0.a.e0.n.b bVar) {
            this.f45495e = bVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            h.g(QueryResponse.Options.CANCEL);
            this.f45495e.a(Boolean.FALSE);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements DialogInterface.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.e0.n.b f45496e;

        public b(a aVar, d.b.g0.a.e0.n.b bVar) {
            this.f45496e = bVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            h.g("confirm");
            this.f45496e.a(Boolean.TRUE);
        }
    }

    /* loaded from: classes2.dex */
    public class c implements DialogInterface.OnShowListener {
        public c(a aVar) {
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            h.g("show");
        }
    }

    public static a b() {
        if (f45493b == null) {
            synchronized (a.class) {
                if (f45493b == null) {
                    f45493b = new a();
                }
            }
        }
        return f45493b;
    }

    public static void d() {
        if (f45493b == null) {
            return;
        }
        if (f45493b.f45494a != null) {
            f45493b.f45494a = null;
        }
        f45493b = null;
    }

    public String a() {
        return this.f45494a;
    }

    public boolean c() {
        return !TextUtils.isEmpty(this.f45494a);
    }

    public void e(String str) {
        this.f45494a = str;
    }

    public void f(Activity activity, d.b.g0.a.e0.n.b<Boolean> bVar) {
        if (activity == null || bVar == null) {
            return;
        }
        g.a aVar = new g.a(activity);
        aVar.U(d.b.g0.a.h.aiapps_confirm_close_title);
        aVar.y(b().a());
        aVar.n(new d.b.g0.a.j2.g.a());
        aVar.m(true);
        aVar.Q(d.b.g0.a.c.aiapps_modal_confirm_color);
        aVar.O(d.b.g0.a.h.aiapps_dialog_nagtive_button_text, new DialogInterface$OnClickListenerC0759a(this, bVar));
        aVar.C(d.b.g0.a.h.aiapps_dialog_positive_button_text, new b(this, bVar));
        aVar.N(new c(this));
        aVar.X();
    }
}
