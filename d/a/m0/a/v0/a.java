package d.a.m0.a.v0;

import android.app.Activity;
import android.content.DialogInterface;
import android.text.TextUtils;
import com.baidu.wallet.paysdk.banksign.datamodel.QueryResponse;
import d.a.m0.a.j2.k;
import d.a.m0.a.z1.b.b.h;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static volatile a f49037b;

    /* renamed from: a  reason: collision with root package name */
    public String f49038a;

    /* renamed from: d.a.m0.a.v0.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class DialogInterface$OnClickListenerC0933a implements DialogInterface.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.h0.j.b f49039e;

        public DialogInterface$OnClickListenerC0933a(a aVar, d.a.m0.a.h0.j.b bVar) {
            this.f49039e = bVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            k.e(QueryResponse.Options.CANCEL);
            this.f49039e.a(Boolean.FALSE);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements DialogInterface.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.h0.j.b f49040e;

        public b(a aVar, d.a.m0.a.h0.j.b bVar) {
            this.f49040e = bVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            k.e("confirm");
            this.f49040e.a(Boolean.TRUE);
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
        if (f49037b == null) {
            synchronized (a.class) {
                if (f49037b == null) {
                    f49037b = new a();
                }
            }
        }
        return f49037b;
    }

    public static void d() {
        if (f49037b == null) {
            return;
        }
        if (f49037b.f49038a != null) {
            f49037b.f49038a = null;
        }
        f49037b = null;
    }

    public String a() {
        return this.f49038a;
    }

    public boolean c() {
        return !TextUtils.isEmpty(this.f49038a);
    }

    public void e(String str) {
        this.f49038a = str;
    }

    public void f(Activity activity, d.a.m0.a.h0.j.b<Boolean> bVar) {
        if (activity == null || bVar == null) {
            return;
        }
        h.a aVar = new h.a(activity);
        aVar.U(d.a.m0.a.h.aiapps_confirm_close_title);
        aVar.x(b().a());
        aVar.n(new d.a.m0.a.w2.h.a());
        aVar.m(true);
        aVar.Q(d.a.m0.a.c.aiapps_modal_confirm_color);
        aVar.O(d.a.m0.a.h.aiapps_cancel, new DialogInterface$OnClickListenerC0933a(this, bVar));
        aVar.B(d.a.m0.a.h.aiapps_confirm, new b(this, bVar));
        aVar.N(new c(this));
        aVar.X();
    }
}
