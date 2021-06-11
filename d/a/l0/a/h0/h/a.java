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
    public final Context f45779a;

    /* renamed from: b  reason: collision with root package name */
    public final String f45780b;

    /* renamed from: c  reason: collision with root package name */
    public final String f45781c;

    /* renamed from: d  reason: collision with root package name */
    public h f45782d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f45783e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f45784f;

    /* renamed from: g  reason: collision with root package name */
    public f f45785g;

    /* renamed from: h  reason: collision with root package name */
    public e f45786h;

    /* renamed from: d.a.l0.a.h0.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0719a implements TextView.OnEditorActionListener {
        public C0719a() {
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
            if (a.this.f45786h != null) {
                a.this.f45786h.onCancel();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements DialogInterface.OnClickListener {
        public c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            if (a.this.f45786h != null) {
                a.this.f45786h.onCancel();
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
        this.f45779a = context;
        this.f45780b = str;
        this.f45781c = str2;
        c();
    }

    public final void c() {
        View inflate = LayoutInflater.from(this.f45779a).inflate(g.aiapps_browser_http_authentication, (ViewGroup) null);
        this.f45783e = (TextView) inflate.findViewById(d.a.l0.a.f.username_edit);
        TextView textView = (TextView) inflate.findViewById(d.a.l0.a.f.password_edit);
        this.f45784f = textView;
        textView.setOnEditorActionListener(new C0719a());
        String replace = this.f45779a.getText(d.a.l0.a.h.aiapps_sign_in_to).toString().replace("%s1", this.f45780b).replace("%s2", this.f45781c);
        h.a aVar = new h.a(this.f45779a);
        aVar.V(replace);
        aVar.u(17301543);
        aVar.W(inflate);
        aVar.O(d.a.l0.a.h.aiapps_http_authentication_login, new d());
        aVar.B(d.a.l0.a.h.aiapps_cancel, new c());
        aVar.K(new b());
        h c2 = aVar.c();
        this.f45782d = c2;
        c2.getWindow().setSoftInputMode(4);
    }

    public final String d() {
        return this.f45784f.getText().toString();
    }

    public final String e() {
        return this.f45783e.getText().toString();
    }

    public final void f() {
        f fVar = this.f45785g;
        if (fVar != null) {
            fVar.a(this.f45780b, this.f45781c, e(), d());
        }
    }

    public void g(e eVar) {
        this.f45786h = eVar;
    }

    public void h(f fVar) {
        this.f45785g = fVar;
    }

    public void i() {
        this.f45782d.show();
        this.f45783e.requestFocus();
    }
}
