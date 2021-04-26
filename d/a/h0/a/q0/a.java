package d.a.h0.a.q0;

import android.app.Activity;
import android.content.DialogInterface;
import android.text.TextUtils;
import com.baidu.wallet.paysdk.banksign.datamodel.QueryResponse;
import d.a.h0.a.q1.b.b.g;
import d.a.h0.a.z1.h;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static volatile a f43562b;

    /* renamed from: a  reason: collision with root package name */
    public String f43563a;

    /* renamed from: d.a.h0.a.q0.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class DialogInterface$OnClickListenerC0730a implements DialogInterface.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.e0.n.b f43564e;

        public DialogInterface$OnClickListenerC0730a(a aVar, d.a.h0.a.e0.n.b bVar) {
            this.f43564e = bVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            h.g(QueryResponse.Options.CANCEL);
            this.f43564e.a(Boolean.FALSE);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements DialogInterface.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.e0.n.b f43565e;

        public b(a aVar, d.a.h0.a.e0.n.b bVar) {
            this.f43565e = bVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            h.g("confirm");
            this.f43565e.a(Boolean.TRUE);
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
        if (f43562b == null) {
            synchronized (a.class) {
                if (f43562b == null) {
                    f43562b = new a();
                }
            }
        }
        return f43562b;
    }

    public static void d() {
        if (f43562b == null) {
            return;
        }
        if (f43562b.f43563a != null) {
            f43562b.f43563a = null;
        }
        f43562b = null;
    }

    public String a() {
        return this.f43563a;
    }

    public boolean c() {
        return !TextUtils.isEmpty(this.f43563a);
    }

    public void e(String str) {
        this.f43563a = str;
    }

    public void f(Activity activity, d.a.h0.a.e0.n.b<Boolean> bVar) {
        if (activity == null || bVar == null) {
            return;
        }
        g.a aVar = new g.a(activity);
        aVar.U(d.a.h0.a.h.aiapps_confirm_close_title);
        aVar.y(b().a());
        aVar.n(new d.a.h0.a.j2.g.a());
        aVar.m(true);
        aVar.Q(d.a.h0.a.c.aiapps_modal_confirm_color);
        aVar.O(d.a.h0.a.h.aiapps_dialog_nagtive_button_text, new DialogInterface$OnClickListenerC0730a(this, bVar));
        aVar.C(d.a.h0.a.h.aiapps_dialog_positive_button_text, new b(this, bVar));
        aVar.N(new c(this));
        aVar.X();
    }
}
