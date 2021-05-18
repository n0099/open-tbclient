package d.a.i0.a.h0.h;

import android.content.Context;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import d.a.i0.a.g;
import d.a.i0.a.z1.b.b.h;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final Context f41929a;

    /* renamed from: b  reason: collision with root package name */
    public final String f41930b;

    /* renamed from: c  reason: collision with root package name */
    public final String f41931c;

    /* renamed from: d  reason: collision with root package name */
    public h f41932d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f41933e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f41934f;

    /* renamed from: g  reason: collision with root package name */
    public f f41935g;

    /* renamed from: h  reason: collision with root package name */
    public e f41936h;

    /* renamed from: d.a.i0.a.h0.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0652a implements TextView.OnEditorActionListener {
        public C0652a() {
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
            if (a.this.f41936h != null) {
                a.this.f41936h.onCancel();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements DialogInterface.OnClickListener {
        public c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            if (a.this.f41936h != null) {
                a.this.f41936h.onCancel();
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
        this.f41929a = context;
        this.f41930b = str;
        this.f41931c = str2;
        c();
    }

    public final void c() {
        View inflate = LayoutInflater.from(this.f41929a).inflate(g.aiapps_browser_http_authentication, (ViewGroup) null);
        this.f41933e = (TextView) inflate.findViewById(d.a.i0.a.f.username_edit);
        TextView textView = (TextView) inflate.findViewById(d.a.i0.a.f.password_edit);
        this.f41934f = textView;
        textView.setOnEditorActionListener(new C0652a());
        String replace = this.f41929a.getText(d.a.i0.a.h.aiapps_sign_in_to).toString().replace("%s1", this.f41930b).replace("%s2", this.f41931c);
        h.a aVar = new h.a(this.f41929a);
        aVar.V(replace);
        aVar.u(17301543);
        aVar.W(inflate);
        aVar.O(d.a.i0.a.h.aiapps_http_authentication_login, new d());
        aVar.B(d.a.i0.a.h.aiapps_cancel, new c());
        aVar.K(new b());
        h c2 = aVar.c();
        this.f41932d = c2;
        c2.getWindow().setSoftInputMode(4);
    }

    public final String d() {
        return this.f41934f.getText().toString();
    }

    public final String e() {
        return this.f41933e.getText().toString();
    }

    public final void f() {
        f fVar = this.f41935g;
        if (fVar != null) {
            fVar.a(this.f41930b, this.f41931c, e(), d());
        }
    }

    public void g(e eVar) {
        this.f41936h = eVar;
    }

    public void h(f fVar) {
        this.f41935g = fVar;
    }

    public void i() {
        this.f41932d.show();
        this.f41933e.requestFocus();
    }
}
