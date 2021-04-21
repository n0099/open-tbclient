package d.b.h0.a.q0;

import android.app.Activity;
import android.content.DialogInterface;
import android.text.TextUtils;
import com.baidu.wallet.paysdk.banksign.datamodel.QueryResponse;
import d.b.h0.a.q1.b.b.g;
import d.b.h0.a.z1.h;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static volatile a f46214b;

    /* renamed from: a  reason: collision with root package name */
    public String f46215a;

    /* renamed from: d.b.h0.a.q0.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class DialogInterface$OnClickListenerC0791a implements DialogInterface.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.e0.n.b f46216e;

        public DialogInterface$OnClickListenerC0791a(a aVar, d.b.h0.a.e0.n.b bVar) {
            this.f46216e = bVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            h.g(QueryResponse.Options.CANCEL);
            this.f46216e.a(Boolean.FALSE);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements DialogInterface.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.e0.n.b f46217e;

        public b(a aVar, d.b.h0.a.e0.n.b bVar) {
            this.f46217e = bVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            h.g("confirm");
            this.f46217e.a(Boolean.TRUE);
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
        if (f46214b == null) {
            synchronized (a.class) {
                if (f46214b == null) {
                    f46214b = new a();
                }
            }
        }
        return f46214b;
    }

    public static void d() {
        if (f46214b == null) {
            return;
        }
        if (f46214b.f46215a != null) {
            f46214b.f46215a = null;
        }
        f46214b = null;
    }

    public String a() {
        return this.f46215a;
    }

    public boolean c() {
        return !TextUtils.isEmpty(this.f46215a);
    }

    public void e(String str) {
        this.f46215a = str;
    }

    public void f(Activity activity, d.b.h0.a.e0.n.b<Boolean> bVar) {
        if (activity == null || bVar == null) {
            return;
        }
        g.a aVar = new g.a(activity);
        aVar.U(d.b.h0.a.h.aiapps_confirm_close_title);
        aVar.y(b().a());
        aVar.n(new d.b.h0.a.j2.g.a());
        aVar.m(true);
        aVar.Q(d.b.h0.a.c.aiapps_modal_confirm_color);
        aVar.O(d.b.h0.a.h.aiapps_dialog_nagtive_button_text, new DialogInterface$OnClickListenerC0791a(this, bVar));
        aVar.C(d.b.h0.a.h.aiapps_dialog_positive_button_text, new b(this, bVar));
        aVar.N(new c(this));
        aVar.X();
    }
}
