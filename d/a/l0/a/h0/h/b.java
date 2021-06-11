package d.a.l0.a.h0.h;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.net.http.SslCertificate;
import android.net.http.SslError;
import android.os.SystemClock;
import android.text.ClipboardManager;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.SslErrorHandler;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.swan.apps.res.ui.BdBaseImageView;
import d.a.l0.a.h0.h.a;
import d.a.l0.a.h0.h.c;
import d.a.l0.a.h0.h.d;
import d.a.l0.a.z1.b.b.b;
import d.a.l0.a.z1.b.b.h;
import java.util.Date;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f45791c = d.a.l0.a.k.f46875a;

    /* renamed from: a  reason: collision with root package name */
    public Context f45792a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.l0.a.h0.h.a f45793b;

    /* loaded from: classes2.dex */
    public class a implements DialogInterface.OnCancelListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ s f45794e;

        public a(b bVar, s sVar) {
            this.f45794e = sVar;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            s sVar = this.f45794e;
            if (sVar != null) {
                sVar.onCancel();
            }
        }
    }

    /* renamed from: d.a.l0.a.h0.h.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class DialogInterface$OnClickListenerC0720b implements DialogInterface.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ s f45795e;

        public DialogInterface$OnClickListenerC0720b(b bVar, s sVar) {
            this.f45795e = sVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            s sVar = this.f45795e;
            if (sVar != null) {
                sVar.b("");
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements DialogInterface.OnCancelListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ s f45796e;

        public c(b bVar, s sVar) {
            this.f45796e = sVar;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            s sVar = this.f45796e;
            if (sVar != null) {
                sVar.onCancel();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements DialogInterface.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ s f45797e;

        public d(b bVar, s sVar) {
            this.f45797e = sVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            s sVar = this.f45797e;
            if (sVar != null) {
                sVar.onCancel();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e implements DialogInterface.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ s f45798e;

        public e(b bVar, s sVar) {
            this.f45798e = sVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            s sVar = this.f45798e;
            if (sVar != null) {
                sVar.b("");
            }
        }
    }

    /* loaded from: classes2.dex */
    public class f implements DialogInterface.OnCancelListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ s f45799e;

        public f(b bVar, s sVar) {
            this.f45799e = sVar;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            s sVar = this.f45799e;
            if (sVar != null) {
                sVar.onCancel();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class g implements DialogInterface.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ s f45800e;

        public g(b bVar, s sVar) {
            this.f45800e = sVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            s sVar = this.f45800e;
            if (sVar != null) {
                sVar.onCancel();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class h implements DialogInterface.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ s f45801e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ EditText f45802f;

        public h(b bVar, s sVar, EditText editText) {
            this.f45801e = sVar;
            this.f45802f = editText;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            s sVar = this.f45801e;
            if (sVar != null) {
                sVar.b(this.f45802f.getText().toString());
            }
        }
    }

    /* loaded from: classes2.dex */
    public class i implements a.f {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ r f45803a;

        public i(r rVar) {
            this.f45803a = rVar;
        }

        @Override // d.a.l0.a.h0.h.a.f
        public void a(String str, String str2, String str3, String str4) {
            r rVar = this.f45803a;
            if (rVar != null) {
                rVar.b(str3, str4);
            }
            b.this.f45793b = null;
        }
    }

    /* loaded from: classes2.dex */
    public class j implements a.e {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ r f45805a;

        public j(r rVar) {
            this.f45805a = rVar;
        }

        @Override // d.a.l0.a.h0.h.a.e
        public void onCancel() {
            r rVar = this.f45805a;
            if (rVar != null) {
                rVar.a();
            }
            b.this.f45793b = null;
        }
    }

    /* loaded from: classes2.dex */
    public class k implements DialogInterface.OnCancelListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SslErrorHandler f45807e;

        public k(b bVar, SslErrorHandler sslErrorHandler) {
            this.f45807e = sslErrorHandler;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            this.f45807e.cancel();
        }
    }

    /* loaded from: classes2.dex */
    public class l implements b.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ t f45808a;

        public l(b bVar, t tVar) {
            this.f45808a = tVar;
        }

        @Override // d.a.l0.a.z1.b.b.b.c
        public void a(View view) {
            t tVar = this.f45808a;
            if (tVar != null) {
                tVar.c();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class m implements b.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ t f45809a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SslErrorHandler f45810b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SslError f45811c;

        public m(t tVar, SslErrorHandler sslErrorHandler, SslError sslError) {
            this.f45809a = tVar;
            this.f45810b = sslErrorHandler;
            this.f45811c = sslError;
        }

        @Override // d.a.l0.a.z1.b.b.b.c
        public void a(View view) {
            b.this.o(this.f45809a, this.f45810b, this.f45811c);
        }
    }

    /* loaded from: classes2.dex */
    public class n implements b.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ t f45813a;

        public n(b bVar, t tVar) {
            this.f45813a = tVar;
        }

        @Override // d.a.l0.a.z1.b.b.b.c
        public void a(View view) {
            t tVar = this.f45813a;
            if (tVar != null) {
                tVar.b();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class o implements b.c {

        /* renamed from: a  reason: collision with root package name */
        public long[] f45814a = null;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SslError f45815b;

        public o(SslError sslError) {
            this.f45815b = sslError;
        }

        @Override // d.a.l0.a.z1.b.b.b.c
        public void a(View view) {
            if (this.f45814a == null) {
                this.f45814a = new long[5];
            }
            long[] jArr = this.f45814a;
            System.arraycopy(jArr, 1, jArr, 0, jArr.length - 1);
            long[] jArr2 = this.f45814a;
            jArr2[jArr2.length - 1] = SystemClock.uptimeMillis();
            if (this.f45814a[0] >= SystemClock.uptimeMillis() - 3000) {
                this.f45814a = null;
                b.this.g(this.f45815b.toString());
            }
        }
    }

    /* loaded from: classes2.dex */
    public class p implements DialogInterface.OnCancelListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ t f45817e;

        public p(b bVar, t tVar) {
            this.f45817e = tVar;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            t tVar = this.f45817e;
            if (tVar != null) {
                tVar.a();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class q implements b.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ t f45818a;

        public q(b bVar, t tVar) {
            this.f45818a = tVar;
        }

        @Override // d.a.l0.a.z1.b.b.b.c
        public void a(View view) {
            t tVar = this.f45818a;
            if (tVar != null) {
                tVar.a();
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface r {
        void a();

        void b(String str, String str2);
    }

    /* loaded from: classes2.dex */
    public interface s {
        void a();

        void b(String str);

        void onCancel();
    }

    /* loaded from: classes2.dex */
    public interface t {
        void a();

        void b();

        void c();
    }

    public b(Context context) {
        this.f45792a = context;
    }

    public final void c(LinearLayout linearLayout, int i2) {
        d(linearLayout, i2, d.a.l0.a.e.aiapps_dialog_browser_security_good);
    }

    public final void d(LinearLayout linearLayout, int i2, int i3) {
        View inflate = LayoutInflater.from(this.f45792a).inflate(d.a.l0.a.g.aiapps_ssl_content_header, (ViewGroup) linearLayout, false);
        TextView textView = (TextView) inflate.findViewById(d.a.l0.a.f.ssl_header_text);
        textView.setTextColor(inflate.getContext().getResources().getColor(d.a.l0.a.c.aiapps_safe_dialog_message));
        textView.setText(i2);
        ((BdBaseImageView) inflate.findViewById(d.a.l0.a.f.ssl_header_icon)).setImageResource(i3);
        linearLayout.addView(inflate);
    }

    public final void e(LinearLayout linearLayout, int i2) {
        d(linearLayout, i2, d.a.l0.a.e.aiapps_dialog_browser_security_bad);
    }

    public final boolean f() {
        Context context = this.f45792a;
        return (context instanceof Activity) && !((Activity) context).isFinishing();
    }

    public void g(String str) {
        ((ClipboardManager) this.f45792a.getSystemService("clipboard")).setText(str);
        d.a.l0.a.z1.b.f.e.f(this.f45792a, d.a.l0.a.h.aiapps_ssl_copy_error).F();
    }

    public final d.a h(SslCertificate sslCertificate, SslError sslError) {
        View j2 = j(sslCertificate);
        LinearLayout linearLayout = (LinearLayout) j2.findViewById(d.a.l0.a.f.placeholder);
        j2.findViewById(d.a.l0.a.f.ssl_divider).setBackgroundColor(this.f45792a.getResources().getColor(d.a.l0.a.c.aiapps_dialog_gray));
        if (sslError == null) {
            c(linearLayout, d.a.l0.a.h.aiapps_ssl_certificate_is_valid);
        } else {
            if (sslError.hasError(3)) {
                e(linearLayout, d.a.l0.a.h.aiapps_ssl_untrusted);
            }
            if (sslError.hasError(2)) {
                e(linearLayout, d.a.l0.a.h.aiapps_ssl_mismatch);
            }
            if (sslError.hasError(1)) {
                e(linearLayout, d.a.l0.a.h.aiapps_ssl_expired);
            }
            if (sslError.hasError(0)) {
                e(linearLayout, d.a.l0.a.h.aiapps_ssl_not_yet_valid);
            }
            if (sslError.hasError(4)) {
                e(linearLayout, d.a.l0.a.h.aiapps_ssl_date_invalid);
            }
            if (sslError.hasError(5)) {
                e(linearLayout, d.a.l0.a.h.aiapps_ssl_invalid);
            }
            if (linearLayout.getChildCount() == 0) {
                e(linearLayout, d.a.l0.a.h.aiapps_ssl_unknown);
            }
        }
        d.a aVar = new d.a(this.f45792a);
        aVar.d0(d.a.l0.a.h.aiapps_ssl_certificate);
        aVar.c0(j2);
        return aVar;
    }

    public final String i(Date date) {
        return date == null ? "" : DateFormat.getDateFormat(this.f45792a).format(date);
    }

    public final View j(SslCertificate sslCertificate) {
        View inflate = LayoutInflater.from(this.f45792a).inflate(d.a.l0.a.g.aiapps_ssl_certificate, (ViewGroup) null);
        int color = this.f45792a.getResources().getColor(d.a.l0.a.c.aiapps_safe_dialog_message);
        ViewGroup viewGroup = (ViewGroup) inflate.findViewById(d.a.l0.a.f.body);
        for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if (childAt instanceof TextView) {
                TextView textView = (TextView) childAt;
                textView.setTextColor(color);
                textView.setTextSize(14.0f);
            }
        }
        SslCertificate.DName issuedTo = sslCertificate.getIssuedTo();
        if (issuedTo != null) {
            ((TextView) inflate.findViewById(d.a.l0.a.f.to_common)).setText(issuedTo.getCName());
            ((TextView) inflate.findViewById(d.a.l0.a.f.to_org)).setText(issuedTo.getOName());
            ((TextView) inflate.findViewById(d.a.l0.a.f.to_org_unit)).setText(issuedTo.getUName());
        }
        SslCertificate.DName issuedBy = sslCertificate.getIssuedBy();
        if (issuedBy != null) {
            ((TextView) inflate.findViewById(d.a.l0.a.f.by_common)).setText(issuedBy.getCName());
            ((TextView) inflate.findViewById(d.a.l0.a.f.by_org)).setText(issuedBy.getOName());
            ((TextView) inflate.findViewById(d.a.l0.a.f.by_org_unit)).setText(issuedBy.getUName());
        }
        ((TextView) inflate.findViewById(d.a.l0.a.f.issued_on)).setText(i(sslCertificate.getValidNotBeforeDate()));
        ((TextView) inflate.findViewById(d.a.l0.a.f.expires_on)).setText(i(sslCertificate.getValidNotAfterDate()));
        return inflate;
    }

    public void k(r rVar, String str, String str2) {
        d.a.l0.a.h0.h.a aVar = new d.a.l0.a.h0.h.a(this.f45792a, str, str2);
        this.f45793b = aVar;
        aVar.h(new i(rVar));
        this.f45793b.g(new j(rVar));
        this.f45793b.i();
    }

    public boolean l(String str, String str2, s sVar) {
        if (!f()) {
            if (f45791c) {
                Log.e("PageDialogsHandler", "can not showJsAlert");
            }
            if (sVar != null) {
                sVar.a();
            }
            return false;
        }
        h.a aVar = new h.a(this.f45792a);
        aVar.U(d.a.l0.a.h.aiapps_dialog_webcall_common_title);
        aVar.x(str2);
        aVar.O(d.a.l0.a.h.aiapps_confirm, new DialogInterface$OnClickListenerC0720b(this, sVar));
        aVar.K(new a(this, sVar));
        if (d.a.l0.a.c1.a.H().a()) {
            aVar.Y(false);
        } else {
            aVar.Y(true);
        }
        return true;
    }

    public boolean m(String str, String str2, s sVar) {
        if (!f()) {
            if (f45791c) {
                Log.e("PageDialogsHandler", "can not showJsConfirm");
            }
            if (sVar != null) {
                sVar.a();
            }
            return false;
        }
        h.a aVar = new h.a(this.f45792a);
        aVar.U(d.a.l0.a.h.aiapps_dialog_webcall_common_title);
        aVar.x(str2);
        aVar.O(d.a.l0.a.h.aiapps_confirm, new e(this, sVar));
        aVar.B(d.a.l0.a.h.aiapps_cancel, new d(this, sVar));
        aVar.K(new c(this, sVar));
        if (d.a.l0.a.c1.a.H().a()) {
            aVar.Y(false);
        } else {
            aVar.Y(true);
        }
        return true;
    }

    public boolean n(String str, String str2, String str3, s sVar) {
        if (!f()) {
            if (sVar != null) {
                sVar.a();
            }
            return false;
        }
        View inflate = LayoutInflater.from(this.f45792a).inflate(d.a.l0.a.g.aiapps_js_prompt, (ViewGroup) null);
        EditText editText = (EditText) inflate.findViewById(d.a.l0.a.f.value);
        editText.setText(str3);
        ((TextView) inflate.findViewById(d.a.l0.a.f.message)).setText(str2);
        h.a aVar = new h.a(this.f45792a);
        aVar.U(d.a.l0.a.h.aiapps_dialog_webcall_common_title);
        aVar.W(inflate);
        aVar.O(d.a.l0.a.h.aiapps_confirm, new h(this, sVar, editText));
        aVar.B(d.a.l0.a.h.aiapps_cancel, new g(this, sVar));
        aVar.K(new f(this, sVar));
        if (d.a.l0.a.c1.a.H().a()) {
            aVar.Y(false);
        } else {
            aVar.Y(true);
        }
        return true;
    }

    public final void o(t tVar, SslErrorHandler sslErrorHandler, SslError sslError) {
        if (!f()) {
            sslErrorHandler.cancel();
            return;
        }
        SslCertificate certificate = sslError.getCertificate();
        if (certificate == null) {
            return;
        }
        d.a h2 = h(certificate, sslError);
        h2.a0(new b.a(this.f45792a.getText(d.a.l0.a.h.aiapps_confirm_text), d.a.l0.a.c.aiapps_safe_dialog_btn_black, new q(this, tVar)));
        h2.K(new p(this, tVar));
        h2.X();
    }

    public void p(t tVar, SslErrorHandler sslErrorHandler, SslError sslError) {
        if (!f()) {
            sslErrorHandler.cancel();
            return;
        }
        c.C0721c c0721c = new c.C0721c(this.f45792a);
        c0721c.g0(d.a.l0.a.h.aiapps_security_warning);
        c0721c.f0(d.a.l0.a.h.aiapps_ssl_warnings_header, new o(sslError));
        c0721c.a0(new b.a(this.f45792a.getText(d.a.l0.a.h.aiapps_ssl_continue), d.a.l0.a.c.aiapps_ssl_dialog_go_on_text_color, new n(this, tVar)));
        c0721c.a0(new b.a(this.f45792a.getText(d.a.l0.a.h.aiapps_view_certificate), d.a.l0.a.c.aiapps_safe_dialog_btn_black, new m(tVar, sslErrorHandler, sslError)));
        c0721c.a0(new b.a(this.f45792a.getText(d.a.l0.a.h.aiapps_ssl_go_back), d.a.l0.a.c.aiapps_safe_dialog_btn_black, new l(this, tVar)));
        c0721c.K(new k(this, sslErrorHandler));
        c0721c.X();
    }
}
