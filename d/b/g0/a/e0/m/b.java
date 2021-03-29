package d.b.g0.a.e0.m;

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
import d.b.g0.a.e0.m.a;
import d.b.g0.a.e0.m.c;
import d.b.g0.a.e0.m.d;
import d.b.g0.a.q1.b.b.b;
import d.b.g0.a.q1.b.b.g;
import java.util.Date;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f44058c = d.b.g0.a.k.f45051a;

    /* renamed from: a  reason: collision with root package name */
    public Context f44059a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.g0.a.e0.m.a f44060b;

    /* loaded from: classes2.dex */
    public class a implements DialogInterface.OnCancelListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ s f44061e;

        public a(b bVar, s sVar) {
            this.f44061e = sVar;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            s sVar = this.f44061e;
            if (sVar != null) {
                sVar.onCancel();
            }
        }
    }

    /* renamed from: d.b.g0.a.e0.m.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class DialogInterface$OnClickListenerC0666b implements DialogInterface.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ s f44062e;

        public DialogInterface$OnClickListenerC0666b(b bVar, s sVar) {
            this.f44062e = sVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            s sVar = this.f44062e;
            if (sVar != null) {
                sVar.b("");
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements DialogInterface.OnCancelListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ s f44063e;

        public c(b bVar, s sVar) {
            this.f44063e = sVar;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            s sVar = this.f44063e;
            if (sVar != null) {
                sVar.onCancel();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements DialogInterface.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ s f44064e;

        public d(b bVar, s sVar) {
            this.f44064e = sVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            s sVar = this.f44064e;
            if (sVar != null) {
                sVar.onCancel();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e implements DialogInterface.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ s f44065e;

        public e(b bVar, s sVar) {
            this.f44065e = sVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            s sVar = this.f44065e;
            if (sVar != null) {
                sVar.b("");
            }
        }
    }

    /* loaded from: classes2.dex */
    public class f implements DialogInterface.OnCancelListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ s f44066e;

        public f(b bVar, s sVar) {
            this.f44066e = sVar;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            s sVar = this.f44066e;
            if (sVar != null) {
                sVar.onCancel();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class g implements DialogInterface.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ s f44067e;

        public g(b bVar, s sVar) {
            this.f44067e = sVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            s sVar = this.f44067e;
            if (sVar != null) {
                sVar.onCancel();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class h implements DialogInterface.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ s f44068e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ EditText f44069f;

        public h(b bVar, s sVar, EditText editText) {
            this.f44068e = sVar;
            this.f44069f = editText;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            s sVar = this.f44068e;
            if (sVar != null) {
                sVar.b(this.f44069f.getText().toString());
            }
        }
    }

    /* loaded from: classes2.dex */
    public class i implements a.f {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ r f44070a;

        public i(r rVar) {
            this.f44070a = rVar;
        }

        @Override // d.b.g0.a.e0.m.a.f
        public void a(String str, String str2, String str3, String str4) {
            r rVar = this.f44070a;
            if (rVar != null) {
                rVar.a(str3, str4);
            }
            b.this.f44060b = null;
        }
    }

    /* loaded from: classes2.dex */
    public class j implements a.e {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ r f44072a;

        public j(r rVar) {
            this.f44072a = rVar;
        }

        @Override // d.b.g0.a.e0.m.a.e
        public void onCancel() {
            r rVar = this.f44072a;
            if (rVar != null) {
                rVar.b();
            }
            b.this.f44060b = null;
        }
    }

    /* loaded from: classes2.dex */
    public class k implements DialogInterface.OnCancelListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SslErrorHandler f44074e;

        public k(b bVar, SslErrorHandler sslErrorHandler) {
            this.f44074e = sslErrorHandler;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            this.f44074e.cancel();
        }
    }

    /* loaded from: classes2.dex */
    public class l implements b.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ t f44075a;

        public l(b bVar, t tVar) {
            this.f44075a = tVar;
        }

        @Override // d.b.g0.a.q1.b.b.b.c
        public void a(View view) {
            t tVar = this.f44075a;
            if (tVar != null) {
                tVar.b();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class m implements b.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ t f44076a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SslErrorHandler f44077b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SslError f44078c;

        public m(t tVar, SslErrorHandler sslErrorHandler, SslError sslError) {
            this.f44076a = tVar;
            this.f44077b = sslErrorHandler;
            this.f44078c = sslError;
        }

        @Override // d.b.g0.a.q1.b.b.b.c
        public void a(View view) {
            b.this.o(this.f44076a, this.f44077b, this.f44078c);
        }
    }

    /* loaded from: classes2.dex */
    public class n implements b.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ t f44080a;

        public n(b bVar, t tVar) {
            this.f44080a = tVar;
        }

        @Override // d.b.g0.a.q1.b.b.b.c
        public void a(View view) {
            t tVar = this.f44080a;
            if (tVar != null) {
                tVar.a();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class o implements b.c {

        /* renamed from: a  reason: collision with root package name */
        public long[] f44081a = null;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SslError f44082b;

        public o(SslError sslError) {
            this.f44082b = sslError;
        }

        @Override // d.b.g0.a.q1.b.b.b.c
        public void a(View view) {
            if (this.f44081a == null) {
                this.f44081a = new long[5];
            }
            long[] jArr = this.f44081a;
            System.arraycopy(jArr, 1, jArr, 0, jArr.length - 1);
            long[] jArr2 = this.f44081a;
            jArr2[jArr2.length - 1] = SystemClock.uptimeMillis();
            if (this.f44081a[0] >= SystemClock.uptimeMillis() - 3000) {
                this.f44081a = null;
                b.this.g(this.f44082b.toString());
            }
        }
    }

    /* loaded from: classes2.dex */
    public class p implements DialogInterface.OnCancelListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ t f44084e;

        public p(b bVar, t tVar) {
            this.f44084e = tVar;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            t tVar = this.f44084e;
            if (tVar != null) {
                tVar.c();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class q implements b.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ t f44085a;

        public q(b bVar, t tVar) {
            this.f44085a = tVar;
        }

        @Override // d.b.g0.a.q1.b.b.b.c
        public void a(View view) {
            t tVar = this.f44085a;
            if (tVar != null) {
                tVar.c();
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface r {
        void a(String str, String str2);

        void b();
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
        this.f44059a = context;
    }

    public final void c(LinearLayout linearLayout, int i2) {
        d(linearLayout, i2, d.b.g0.a.e.aiapps_dialog_browser_security_good);
    }

    public final void d(LinearLayout linearLayout, int i2, int i3) {
        View inflate = LayoutInflater.from(this.f44059a).inflate(d.b.g0.a.g.aiapps_ssl_content_header, (ViewGroup) linearLayout, false);
        TextView textView = (TextView) inflate.findViewById(d.b.g0.a.f.ssl_header_text);
        textView.setTextColor(inflate.getContext().getResources().getColor(d.b.g0.a.c.aiapps_safe_dialog_message));
        textView.setText(i2);
        ((BdBaseImageView) inflate.findViewById(d.b.g0.a.f.ssl_header_icon)).setImageResource(i3);
        linearLayout.addView(inflate);
    }

    public final void e(LinearLayout linearLayout, int i2) {
        d(linearLayout, i2, d.b.g0.a.e.aiapps_dialog_browser_security_bad);
    }

    public final boolean f() {
        Context context = this.f44059a;
        return (context instanceof Activity) && !((Activity) context).isFinishing();
    }

    public void g(String str) {
        ((ClipboardManager) this.f44059a.getSystemService("clipboard")).setText(str);
        d.b.g0.a.q1.b.f.d.e(this.f44059a, d.b.g0.a.h.aiapps_ssl_copy_error).C();
    }

    public final d.a h(SslCertificate sslCertificate, SslError sslError) {
        View j2 = j(sslCertificate);
        LinearLayout linearLayout = (LinearLayout) j2.findViewById(d.b.g0.a.f.placeholder);
        j2.findViewById(d.b.g0.a.f.ssl_divider).setBackgroundColor(this.f44059a.getResources().getColor(d.b.g0.a.c.aiapps_dialog_gray));
        if (sslError == null) {
            c(linearLayout, d.b.g0.a.h.aiapps_ssl_certificate_is_valid);
        } else {
            if (sslError.hasError(3)) {
                e(linearLayout, d.b.g0.a.h.aiapps_ssl_untrusted);
            }
            if (sslError.hasError(2)) {
                e(linearLayout, d.b.g0.a.h.aiapps_ssl_mismatch);
            }
            if (sslError.hasError(1)) {
                e(linearLayout, d.b.g0.a.h.aiapps_ssl_expired);
            }
            if (sslError.hasError(0)) {
                e(linearLayout, d.b.g0.a.h.aiapps_ssl_not_yet_valid);
            }
            if (sslError.hasError(4)) {
                e(linearLayout, d.b.g0.a.h.aiapps_ssl_date_invalid);
            }
            if (sslError.hasError(5)) {
                e(linearLayout, d.b.g0.a.h.aiapps_ssl_invalid);
            }
            if (linearLayout.getChildCount() == 0) {
                e(linearLayout, d.b.g0.a.h.aiapps_ssl_unknown);
            }
        }
        d.a aVar = new d.a(this.f44059a);
        aVar.d0(d.b.g0.a.h.aiapps_ssl_certificate);
        aVar.c0(j2);
        return aVar;
    }

    public final String i(Date date) {
        return date == null ? "" : DateFormat.getDateFormat(this.f44059a).format(date);
    }

    public final View j(SslCertificate sslCertificate) {
        View inflate = LayoutInflater.from(this.f44059a).inflate(d.b.g0.a.g.aiapps_ssl_certificate, (ViewGroup) null);
        int color = this.f44059a.getResources().getColor(d.b.g0.a.c.aiapps_safe_dialog_message);
        ViewGroup viewGroup = (ViewGroup) inflate.findViewById(d.b.g0.a.f.body);
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
            ((TextView) inflate.findViewById(d.b.g0.a.f.to_common)).setText(issuedTo.getCName());
            ((TextView) inflate.findViewById(d.b.g0.a.f.to_org)).setText(issuedTo.getOName());
            ((TextView) inflate.findViewById(d.b.g0.a.f.to_org_unit)).setText(issuedTo.getUName());
        }
        SslCertificate.DName issuedBy = sslCertificate.getIssuedBy();
        if (issuedBy != null) {
            ((TextView) inflate.findViewById(d.b.g0.a.f.by_common)).setText(issuedBy.getCName());
            ((TextView) inflate.findViewById(d.b.g0.a.f.by_org)).setText(issuedBy.getOName());
            ((TextView) inflate.findViewById(d.b.g0.a.f.by_org_unit)).setText(issuedBy.getUName());
        }
        ((TextView) inflate.findViewById(d.b.g0.a.f.issued_on)).setText(i(sslCertificate.getValidNotBeforeDate()));
        ((TextView) inflate.findViewById(d.b.g0.a.f.expires_on)).setText(i(sslCertificate.getValidNotAfterDate()));
        return inflate;
    }

    public void k(r rVar, String str, String str2) {
        d.b.g0.a.e0.m.a aVar = new d.b.g0.a.e0.m.a(this.f44059a, str, str2);
        this.f44060b = aVar;
        aVar.h(new i(rVar));
        this.f44060b.g(new j(rVar));
        this.f44060b.i();
    }

    public boolean l(String str, String str2, s sVar) {
        if (!f()) {
            if (f44058c) {
                Log.e("PageDialogsHandler", "can not showJsAlert");
            }
            if (sVar != null) {
                sVar.a();
            }
            return false;
        }
        g.a aVar = new g.a(this.f44059a);
        aVar.U(d.b.g0.a.h.aiapps_dialog_webcall_common_title);
        aVar.y(str2);
        aVar.O(d.b.g0.a.h.aiapps_dialog_positive_button_text, new DialogInterface$OnClickListenerC0666b(this, sVar));
        aVar.L(new a(this, sVar));
        if (d.b.g0.a.w0.a.z().a()) {
            aVar.Y(false);
        } else {
            aVar.Y(true);
        }
        return true;
    }

    public boolean m(String str, String str2, s sVar) {
        if (!f()) {
            if (f44058c) {
                Log.e("PageDialogsHandler", "can not showJsConfirm");
            }
            if (sVar != null) {
                sVar.a();
            }
            return false;
        }
        g.a aVar = new g.a(this.f44059a);
        aVar.U(d.b.g0.a.h.aiapps_dialog_webcall_common_title);
        aVar.y(str2);
        aVar.O(d.b.g0.a.h.aiapps_dialog_positive_button_text, new e(this, sVar));
        aVar.C(d.b.g0.a.h.aiapps_dialog_nagtive_button_text, new d(this, sVar));
        aVar.L(new c(this, sVar));
        if (d.b.g0.a.w0.a.z().a()) {
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
        View inflate = LayoutInflater.from(this.f44059a).inflate(d.b.g0.a.g.aiapps_js_prompt, (ViewGroup) null);
        EditText editText = (EditText) inflate.findViewById(d.b.g0.a.f.value);
        editText.setText(str3);
        ((TextView) inflate.findViewById(d.b.g0.a.f.message)).setText(str2);
        g.a aVar = new g.a(this.f44059a);
        aVar.U(d.b.g0.a.h.aiapps_dialog_webcall_common_title);
        aVar.W(inflate);
        aVar.O(d.b.g0.a.h.aiapps_dialog_positive_button_text, new h(this, sVar, editText));
        aVar.C(d.b.g0.a.h.aiapps_dialog_nagtive_button_text, new g(this, sVar));
        aVar.L(new f(this, sVar));
        if (d.b.g0.a.w0.a.z().a()) {
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
        h2.a0(new b.a(this.f44059a.getText(d.b.g0.a.h.aiapps_ssl_got_it), d.b.g0.a.c.aiapps_safe_dialog_btn_black, new q(this, tVar)));
        h2.L(new p(this, tVar));
        h2.X();
    }

    public void p(t tVar, SslErrorHandler sslErrorHandler, SslError sslError) {
        if (!f()) {
            sslErrorHandler.cancel();
            return;
        }
        c.C0667c c0667c = new c.C0667c(this.f44059a);
        c0667c.g0(d.b.g0.a.h.aiapps_security_warning);
        c0667c.f0(d.b.g0.a.h.aiapps_ssl_warnings_header, new o(sslError));
        c0667c.a0(new b.a(this.f44059a.getText(d.b.g0.a.h.aiapps_ssl_continue), d.b.g0.a.c.aiapps_ssl_dialog_go_on_text_color, new n(this, tVar)));
        c0667c.a0(new b.a(this.f44059a.getText(d.b.g0.a.h.aiapps_view_certificate), d.b.g0.a.c.aiapps_safe_dialog_btn_black, new m(tVar, sslErrorHandler, sslError)));
        c0667c.a0(new b.a(this.f44059a.getText(d.b.g0.a.h.aiapps_ssl_go_back), d.b.g0.a.c.aiapps_safe_dialog_btn_black, new l(this, tVar)));
        c0667c.L(new k(this, sslErrorHandler));
        c0667c.X();
    }
}
