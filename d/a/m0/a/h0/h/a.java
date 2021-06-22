package d.a.m0.a.h0.h;

import android.content.Context;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import d.a.m0.a.g;
import d.a.m0.a.z1.b.b.h;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final Context f45887a;

    /* renamed from: b  reason: collision with root package name */
    public final String f45888b;

    /* renamed from: c  reason: collision with root package name */
    public final String f45889c;

    /* renamed from: d  reason: collision with root package name */
    public h f45890d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f45891e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f45892f;

    /* renamed from: g  reason: collision with root package name */
    public f f45893g;

    /* renamed from: h  reason: collision with root package name */
    public e f45894h;

    /* renamed from: d.a.m0.a.h0.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0722a implements TextView.OnEditorActionListener {
        public C0722a() {
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

    /* loaded from: classes3.dex */
    public class b implements DialogInterface.OnCancelListener {
        public b() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (a.this.f45894h != null) {
                a.this.f45894h.onCancel();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements DialogInterface.OnClickListener {
        public c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            if (a.this.f45894h != null) {
                a.this.f45894h.onCancel();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements DialogInterface.OnClickListener {
        public d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
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
        this.f45887a = context;
        this.f45888b = str;
        this.f45889c = str2;
        c();
    }

    public final void c() {
        View inflate = LayoutInflater.from(this.f45887a).inflate(g.aiapps_browser_http_authentication, (ViewGroup) null);
        this.f45891e = (TextView) inflate.findViewById(d.a.m0.a.f.username_edit);
        TextView textView = (TextView) inflate.findViewById(d.a.m0.a.f.password_edit);
        this.f45892f = textView;
        textView.setOnEditorActionListener(new C0722a());
        String replace = this.f45887a.getText(d.a.m0.a.h.aiapps_sign_in_to).toString().replace("%s1", this.f45888b).replace("%s2", this.f45889c);
        h.a aVar = new h.a(this.f45887a);
        aVar.V(replace);
        aVar.u(17301543);
        aVar.W(inflate);
        aVar.O(d.a.m0.a.h.aiapps_http_authentication_login, new d());
        aVar.B(d.a.m0.a.h.aiapps_cancel, new c());
        aVar.K(new b());
        h c2 = aVar.c();
        this.f45890d = c2;
        c2.getWindow().setSoftInputMode(4);
    }

    public final String d() {
        return this.f45892f.getText().toString();
    }

    public final String e() {
        return this.f45891e.getText().toString();
    }

    public final void f() {
        f fVar = this.f45893g;
        if (fVar != null) {
            fVar.a(this.f45888b, this.f45889c, e(), d());
        }
    }

    public void g(e eVar) {
        this.f45894h = eVar;
    }

    public void h(f fVar) {
        this.f45893g = fVar;
    }

    public void i() {
        this.f45890d.show();
        this.f45891e.requestFocus();
    }
}
