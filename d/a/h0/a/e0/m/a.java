package d.a.h0.a.e0.m;

import android.content.Context;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import d.a.h0.a.h;
import d.a.h0.a.q1.b.b.g;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final Context f42065a;

    /* renamed from: b  reason: collision with root package name */
    public final String f42066b;

    /* renamed from: c  reason: collision with root package name */
    public final String f42067c;

    /* renamed from: d  reason: collision with root package name */
    public g f42068d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f42069e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f42070f;

    /* renamed from: g  reason: collision with root package name */
    public f f42071g;

    /* renamed from: h  reason: collision with root package name */
    public e f42072h;

    /* renamed from: d.a.h0.a.e0.m.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0636a implements TextView.OnEditorActionListener {
        public C0636a() {
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
            if (a.this.f42072h != null) {
                a.this.f42072h.onCancel();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements DialogInterface.OnClickListener {
        public c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            if (a.this.f42072h != null) {
                a.this.f42072h.onCancel();
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
        this.f42065a = context;
        this.f42066b = str;
        this.f42067c = str2;
        c();
    }

    public final void c() {
        View inflate = LayoutInflater.from(this.f42065a).inflate(d.a.h0.a.g.aiapps_browser_http_authentication, (ViewGroup) null);
        this.f42069e = (TextView) inflate.findViewById(d.a.h0.a.f.username_edit);
        TextView textView = (TextView) inflate.findViewById(d.a.h0.a.f.password_edit);
        this.f42070f = textView;
        textView.setOnEditorActionListener(new C0636a());
        String replace = this.f42065a.getText(h.aiapps_sign_in_to).toString().replace("%s1", this.f42066b).replace("%s2", this.f42067c);
        g.a aVar = new g.a(this.f42065a);
        aVar.V(replace);
        aVar.v(17301543);
        aVar.W(inflate);
        aVar.O(h.aiapps_http_authentication_login, new d());
        aVar.C(h.aiapps_http_authentication_cancel, new c());
        aVar.L(new b());
        g c2 = aVar.c();
        this.f42068d = c2;
        c2.getWindow().setSoftInputMode(4);
    }

    public final String d() {
        return this.f42070f.getText().toString();
    }

    public final String e() {
        return this.f42069e.getText().toString();
    }

    public final void f() {
        f fVar = this.f42071g;
        if (fVar != null) {
            fVar.a(this.f42066b, this.f42067c, e(), d());
        }
    }

    public void g(e eVar) {
        this.f42072h = eVar;
    }

    public void h(f fVar) {
        this.f42071g = fVar;
    }

    public void i() {
        this.f42068d.show();
        this.f42069e.requestFocus();
    }
}
