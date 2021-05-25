package d.a.l0.a.h0.h;

import android.content.Context;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import d.a.l0.a.g;
import d.a.l0.a.z1.b.b.h;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final Context f42103a;

    /* renamed from: b  reason: collision with root package name */
    public final String f42104b;

    /* renamed from: c  reason: collision with root package name */
    public final String f42105c;

    /* renamed from: d  reason: collision with root package name */
    public h f42106d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f42107e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f42108f;

    /* renamed from: g  reason: collision with root package name */
    public f f42109g;

    /* renamed from: h  reason: collision with root package name */
    public e f42110h;

    /* renamed from: d.a.l0.a.h0.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0663a implements TextView.OnEditorActionListener {
        public C0663a() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
            if (i2 == 6 || i2 == 0) {
                if (i2 == 0 && keyEvent != null && keyEvent.getAction() == 1) {
                    return true;
                }
                a.this.f();
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes2.dex */
    public class b implements DialogInterface.OnCancelListener {
        public b() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (a.this.f42110h != null) {
                a.this.f42110h.onCancel();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements DialogInterface.OnClickListener {
        public c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            if (a.this.f42110h != null) {
                a.this.f42110h.onCancel();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements DialogInterface.OnClickListener {
        public d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            a.this.f();
        }
    }

    /* loaded from: classes2.dex */
    public interface e {
        void onCancel();
    }

    /* loaded from: classes2.dex */
    public interface f {
        void a(String str, String str2, String str3, String str4);
    }

    public a(Context context, String str, String str2) {
        this.f42103a = context;
        this.f42104b = str;
        this.f42105c = str2;
        c();
    }

    public final void c() {
        View inflate = LayoutInflater.from(this.f42103a).inflate(g.aiapps_browser_http_authentication, (ViewGroup) null);
        this.f42107e = (TextView) inflate.findViewById(d.a.l0.a.f.username_edit);
        TextView textView = (TextView) inflate.findViewById(d.a.l0.a.f.password_edit);
        this.f42108f = textView;
        textView.setOnEditorActionListener(new C0663a());
        String replace = this.f42103a.getText(d.a.l0.a.h.aiapps_sign_in_to).toString().replace("%s1", this.f42104b).replace("%s2", this.f42105c);
        h.a aVar = new h.a(this.f42103a);
        aVar.V(replace);
        aVar.u(17301543);
        aVar.W(inflate);
        aVar.O(d.a.l0.a.h.aiapps_http_authentication_login, new d());
        aVar.B(d.a.l0.a.h.aiapps_cancel, new c());
        aVar.K(new b());
        h c2 = aVar.c();
        this.f42106d = c2;
        c2.getWindow().setSoftInputMode(4);
    }

    public final String d() {
        return this.f42108f.getText().toString();
    }

    public final String e() {
        return this.f42107e.getText().toString();
    }

    public final void f() {
        f fVar = this.f42109g;
        if (fVar != null) {
            fVar.a(this.f42104b, this.f42105c, e(), d());
        }
    }

    public void g(e eVar) {
        this.f42110h = eVar;
    }

    public void h(f fVar) {
        this.f42109g = fVar;
    }

    public void i() {
        this.f42106d.show();
        this.f42107e.requestFocus();
    }
}
