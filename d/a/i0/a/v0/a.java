package d.a.i0.a.v0;

import android.app.Activity;
import android.content.DialogInterface;
import android.text.TextUtils;
import com.baidu.wallet.paysdk.banksign.datamodel.QueryResponse;
import d.a.i0.a.j2.k;
import d.a.i0.a.z1.b.b.h;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static volatile a f45079b;

    /* renamed from: a  reason: collision with root package name */
    public String f45080a;

    /* renamed from: d.a.i0.a.v0.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class DialogInterface$OnClickListenerC0863a implements DialogInterface.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.h0.j.b f45081e;

        public DialogInterface$OnClickListenerC0863a(a aVar, d.a.i0.a.h0.j.b bVar) {
            this.f45081e = bVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            k.e(QueryResponse.Options.CANCEL);
            this.f45081e.a(Boolean.FALSE);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements DialogInterface.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.h0.j.b f45082e;

        public b(a aVar, d.a.i0.a.h0.j.b bVar) {
            this.f45082e = bVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            k.e("confirm");
            this.f45082e.a(Boolean.TRUE);
        }
    }

    /* loaded from: classes2.dex */
    public class c implements DialogInterface.OnShowListener {
        public c(a aVar) {
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            k.e("show");
        }
    }

    public static a b() {
        if (f45079b == null) {
            synchronized (a.class) {
                if (f45079b == null) {
                    f45079b = new a();
                }
            }
        }
        return f45079b;
    }

    public static void d() {
        if (f45079b == null) {
            return;
        }
        if (f45079b.f45080a != null) {
            f45079b.f45080a = null;
        }
        f45079b = null;
    }

    public String a() {
        return this.f45080a;
    }

    public boolean c() {
        return !TextUtils.isEmpty(this.f45080a);
    }

    public void e(String str) {
        this.f45080a = str;
    }

    public void f(Activity activity, d.a.i0.a.h0.j.b<Boolean> bVar) {
        if (activity == null || bVar == null) {
            return;
        }
        h.a aVar = new h.a(activity);
        aVar.U(d.a.i0.a.h.aiapps_confirm_close_title);
        aVar.x(b().a());
        aVar.n(new d.a.i0.a.w2.h.a());
        aVar.m(true);
        aVar.Q(d.a.i0.a.c.aiapps_modal_confirm_color);
        aVar.O(d.a.i0.a.h.aiapps_cancel, new DialogInterface$OnClickListenerC0863a(this, bVar));
        aVar.B(d.a.i0.a.h.aiapps_confirm, new b(this, bVar));
        aVar.N(new c(this));
        aVar.X();
    }
}
