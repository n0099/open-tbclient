package d.b.g0.a.e0.m;

import android.content.Context;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import d.b.g0.a.h;
import d.b.g0.a.q1.b.b.g;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final Context f44045a;

    /* renamed from: b  reason: collision with root package name */
    public final String f44046b;

    /* renamed from: c  reason: collision with root package name */
    public final String f44047c;

    /* renamed from: d  reason: collision with root package name */
    public g f44048d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f44049e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f44050f;

    /* renamed from: g  reason: collision with root package name */
    public f f44051g;

    /* renamed from: h  reason: collision with root package name */
    public e f44052h;

    /* renamed from: d.b.g0.a.e0.m.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0664a implements TextView.OnEditorActionListener {
        public C0664a() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (i == 6 || i == 0) {
                if (i == 0 && keyEvent != null && keyEvent.getAction() == 1) {
                    return true;
                }
                a.this.f();
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements DialogInterface.OnCancelListener {
        public b() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (a.this.f44052h != null) {
                a.this.f44052h.onCancel();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements DialogInterface.OnClickListener {
        public c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            if (a.this.f44052h != null) {
                a.this.f44052h.onCancel();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements DialogInterface.OnClickListener {
        public d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            a.this.f();
        }
    }

    /* loaded from: classes3.dex */
    public interface e {
        void onCancel();
    }

    /* loaded from: classes3.dex */
    public interface f {
        void a(String str, String str2, String str3, String str4);
    }

    public a(Context context, String str, String str2) {
        this.f44045a = context;
        this.f44046b = str;
        this.f44047c = str2;
        c();
    }

    public final void c() {
        View inflate = LayoutInflater.from(this.f44045a).inflate(d.b.g0.a.g.aiapps_browser_http_authentication, (ViewGroup) null);
        this.f44049e = (TextView) inflate.findViewById(d.b.g0.a.f.username_edit);
        TextView textView = (TextView) inflate.findViewById(d.b.g0.a.f.password_edit);
        this.f44050f = textView;
        textView.setOnEditorActionListener(new C0664a());
        String replace = this.f44045a.getText(h.aiapps_sign_in_to).toString().replace("%s1", this.f44046b).replace("%s2", this.f44047c);
        g.a aVar = new g.a(this.f44045a);
        aVar.V(replace);
        aVar.v(17301543);
        aVar.W(inflate);
        aVar.O(h.aiapps_http_authentication_login, new d());
        aVar.C(h.aiapps_http_authentication_cancel, new c());
        aVar.L(new b());
        g c2 = aVar.c();
        this.f44048d = c2;
        c2.getWindow().setSoftInputMode(4);
    }

    public final String d() {
        return this.f44050f.getText().toString();
    }

    public final String e() {
        return this.f44049e.getText().toString();
    }

    public final void f() {
        f fVar = this.f44051g;
        if (fVar != null) {
            fVar.a(this.f44046b, this.f44047c, e(), d());
        }
    }

    public void g(e eVar) {
        this.f44052h = eVar;
    }

    public void h(f fVar) {
        this.f44051g = fVar;
    }

    public void i() {
        this.f44048d.show();
        this.f44049e.requestFocus();
    }
}
