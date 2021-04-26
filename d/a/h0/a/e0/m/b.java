package d.a.h0.a.e0.m;

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
import d.a.h0.a.e0.m.a;
import d.a.h0.a.e0.m.c;
import d.a.h0.a.e0.m.d;
import d.a.h0.a.q1.b.b.b;
import d.a.h0.a.q1.b.b.g;
import java.util.Date;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f42077c = d.a.h0.a.k.f43101a;

    /* renamed from: a  reason: collision with root package name */
    public Context f42078a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.h0.a.e0.m.a f42079b;

    /* loaded from: classes2.dex */
    public class a implements DialogInterface.OnCancelListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ s f42080e;

        public a(b bVar, s sVar) {
            this.f42080e = sVar;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            s sVar = this.f42080e;
            if (sVar != null) {
                sVar.onCancel();
            }
        }
    }

    /* renamed from: d.a.h0.a.e0.m.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class DialogInterface$OnClickListenerC0637b implements DialogInterface.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ s f42081e;

        public DialogInterface$OnClickListenerC0637b(b bVar, s sVar) {
            this.f42081e = sVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            s sVar = this.f42081e;
            if (sVar != null) {
                sVar.b("");
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements DialogInterface.OnCancelListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ s f42082e;

        public c(b bVar, s sVar) {
            this.f42082e = sVar;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            s sVar = this.f42082e;
            if (sVar != null) {
                sVar.onCancel();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements DialogInterface.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ s f42083e;

        public d(b bVar, s sVar) {
            this.f42083e = sVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            s sVar = this.f42083e;
            if (sVar != null) {
                sVar.onCancel();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e implements DialogInterface.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ s f42084e;

        public e(b bVar, s sVar) {
            this.f42084e = sVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            s sVar = this.f42084e;
            if (sVar != null) {
                sVar.b("");
            }
        }
    }

    /* loaded from: classes2.dex */
    public class f implements DialogInterface.OnCancelListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ s f42085e;

        public f(b bVar, s sVar) {
            this.f42085e = sVar;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            s sVar = this.f42085e;
            if (sVar != null) {
                sVar.onCancel();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class g implements DialogInterface.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ s f42086e;

        public g(b bVar, s sVar) {
            this.f42086e = sVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            s sVar = this.f42086e;
            if (sVar != null) {
                sVar.onCancel();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class h implements DialogInterface.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ s f42087e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ EditText f42088f;

        public h(b bVar, s sVar, EditText editText) {
            this.f42087e = sVar;
            this.f42088f = editText;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            s sVar = this.f42087e;
            if (sVar != null) {
                sVar.b(this.f42088f.getText().toString());
            }
        }
    }

    /* loaded from: classes2.dex */
    public class i implements a.f {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ r f42089a;

        public i(r rVar) {
            this.f42089a = rVar;
        }

        @Override // d.a.h0.a.e0.m.a.f
        public void a(String str, String str2, String str3, String str4) {
            r rVar = this.f42089a;
            if (rVar != null) {
                rVar.b(str3, str4);
            }
            b.this.f42079b = null;
        }
    }

    /* loaded from: classes2.dex */
    public class j implements a.e {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ r f42091a;

        public j(r rVar) {
            this.f42091a = rVar;
        }

        @Override // d.a.h0.a.e0.m.a.e
        public void onCancel() {
            r rVar = this.f42091a;
            if (rVar != null) {
                rVar.a();
            }
            b.this.f42079b = null;
        }
    }

    /* loaded from: classes2.dex */
    public class k implements DialogInterface.OnCancelListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SslErrorHandler f42093e;

        public k(b bVar, SslErrorHandler sslErrorHandler) {
            this.f42093e = sslErrorHandler;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            this.f42093e.cancel();
        }
    }

    /* loaded from: classes2.dex */
    public class l implements b.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ t f42094a;

        public l(b bVar, t tVar) {
            this.f42094a = tVar;
        }

        @Override // d.a.h0.a.q1.b.b.b.c
        public void a(View view) {
            t tVar = this.f42094a;
            if (tVar != null) {
                tVar.c();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class m implements b.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ t f42095a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SslErrorHandler f42096b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SslError f42097c;

        public m(t tVar, SslErrorHandler sslErrorHandler, SslError sslError) {
            this.f42095a = tVar;
            this.f42096b = sslErrorHandler;
            this.f42097c = sslError;
        }

        @Override // d.a.h0.a.q1.b.b.b.c
        public void a(View view) {
            b.this.o(this.f42095a, this.f42096b, this.f42097c);
        }
    }

    /* loaded from: classes2.dex */
    public class n implements b.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ t f42099a;

        public n(b bVar, t tVar) {
            this.f42099a = tVar;
        }

        @Override // d.a.h0.a.q1.b.b.b.c
        public void a(View view) {
            t tVar = this.f42099a;
            if (tVar != null) {
                tVar.b();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class o implements b.c {

        /* renamed from: a  reason: collision with root package name */
        public long[] f42100a = null;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SslError f42101b;

        public o(SslError sslError) {
            this.f42101b = sslError;
        }

        @Override // d.a.h0.a.q1.b.b.b.c
        public void a(View view) {
            if (this.f42100a == null) {
                this.f42100a = new long[5];
            }
            long[] jArr = this.f42100a;
            System.arraycopy(jArr, 1, jArr, 0, jArr.length - 1);
            long[] jArr2 = this.f42100a;
            jArr2[jArr2.length - 1] = SystemClock.uptimeMillis();
            if (this.f42100a[0] >= SystemClock.uptimeMillis() - 3000) {
                this.f42100a = null;
                b.this.g(this.f42101b.toString());
            }
        }
    }

    /* loaded from: classes2.dex */
    public class p implements DialogInterface.OnCancelListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ t f42103e;

        public p(b bVar, t tVar) {
            this.f42103e = tVar;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            t tVar = this.f42103e;
            if (tVar != null) {
                tVar.a();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class q implements b.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ t f42104a;

        public q(b bVar, t tVar) {
            this.f42104a = tVar;
        }

        @Override // d.a.h0.a.q1.b.b.b.c
        public void a(View view) {
            t tVar = this.f42104a;
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
        this.f42078a = context;
    }

    public final void c(LinearLayout linearLayout, int i2) {
        d(linearLayout, i2, d.a.h0.a.e.aiapps_dialog_browser_security_good);
    }

    public final void d(LinearLayout linearLayout, int i2, int i3) {
        View inflate = LayoutInflater.from(this.f42078a).inflate(d.a.h0.a.g.aiapps_ssl_content_header, (ViewGroup) linearLayout, false);
        TextView textView = (TextView) inflate.findViewById(d.a.h0.a.f.ssl_header_text);
        textView.setTextColor(inflate.getContext().getResources().getColor(d.a.h0.a.c.aiapps_safe_dialog_message));
        textView.setText(i2);
        ((BdBaseImageView) inflate.findViewById(d.a.h0.a.f.ssl_header_icon)).setImageResource(i3);
        linearLayout.addView(inflate);
    }

    public final void e(LinearLayout linearLayout, int i2) {
        d(linearLayout, i2, d.a.h0.a.e.aiapps_dialog_browser_security_bad);
    }

    public final boolean f() {
        Context context = this.f42078a;
        return (context instanceof Activity) && !((Activity) context).isFinishing();
    }

    public void g(String str) {
        ((ClipboardManager) this.f42078a.getSystemService("clipboard")).setText(str);
        d.a.h0.a.q1.b.f.d.e(this.f42078a, d.a.h0.a.h.aiapps_ssl_copy_error).C();
    }

    public final d.a h(SslCertificate sslCertificate, SslError sslError) {
        View j2 = j(sslCertificate);
        LinearLayout linearLayout = (LinearLayout) j2.findViewById(d.a.h0.a.f.placeholder);
        j2.findViewById(d.a.h0.a.f.ssl_divider).setBackgroundColor(this.f42078a.getResources().getColor(d.a.h0.a.c.aiapps_dialog_gray));
        if (sslError == null) {
            c(linearLayout, d.a.h0.a.h.aiapps_ssl_certificate_is_valid);
        } else {
            if (sslError.hasError(3)) {
                e(linearLayout, d.a.h0.a.h.aiapps_ssl_untrusted);
            }
            if (sslError.hasError(2)) {
                e(linearLayout, d.a.h0.a.h.aiapps_ssl_mismatch);
            }
            if (sslError.hasError(1)) {
                e(linearLayout, d.a.h0.a.h.aiapps_ssl_expired);
            }
            if (sslError.hasError(0)) {
                e(linearLayout, d.a.h0.a.h.aiapps_ssl_not_yet_valid);
            }
            if (sslError.hasError(4)) {
                e(linearLayout, d.a.h0.a.h.aiapps_ssl_date_invalid);
            }
            if (sslError.hasError(5)) {
                e(linearLayout, d.a.h0.a.h.aiapps_ssl_invalid);
            }
            if (linearLayout.getChildCount() == 0) {
                e(linearLayout, d.a.h0.a.h.aiapps_ssl_unknown);
            }
        }
        d.a aVar = new d.a(this.f42078a);
        aVar.d0(d.a.h0.a.h.aiapps_ssl_certificate);
        aVar.c0(j2);
        return aVar;
    }

    public final String i(Date date) {
        return date == null ? "" : DateFormat.getDateFormat(this.f42078a).format(date);
    }

    public final View j(SslCertificate sslCertificate) {
        View inflate = LayoutInflater.from(this.f42078a).inflate(d.a.h0.a.g.aiapps_ssl_certificate, (ViewGroup) null);
        int color = this.f42078a.getResources().getColor(d.a.h0.a.c.aiapps_safe_dialog_message);
        ViewGroup viewGroup = (ViewGroup) inflate.findViewById(d.a.h0.a.f.body);
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
            ((TextView) inflate.findViewById(d.a.h0.a.f.to_common)).setText(issuedTo.getCName());
            ((TextView) inflate.findViewById(d.a.h0.a.f.to_org)).setText(issuedTo.getOName());
            ((TextView) inflate.findViewById(d.a.h0.a.f.to_org_unit)).setText(issuedTo.getUName());
        }
        SslCertificate.DName issuedBy = sslCertificate.getIssuedBy();
        if (issuedBy != null) {
            ((TextView) inflate.findViewById(d.a.h0.a.f.by_common)).setText(issuedBy.getCName());
            ((TextView) inflate.findViewById(d.a.h0.a.f.by_org)).setText(issuedBy.getOName());
            ((TextView) inflate.findViewById(d.a.h0.a.f.by_org_unit)).setText(issuedBy.getUName());
        }
        ((TextView) inflate.findViewById(d.a.h0.a.f.issued_on)).setText(i(sslCertificate.getValidNotBeforeDate()));
        ((TextView) inflate.findViewById(d.a.h0.a.f.expires_on)).setText(i(sslCertificate.getValidNotAfterDate()));
        return inflate;
    }

    public void k(r rVar, String str, String str2) {
        d.a.h0.a.e0.m.a aVar = new d.a.h0.a.e0.m.a(this.f42078a, str, str2);
        this.f42079b = aVar;
        aVar.h(new i(rVar));
        this.f42079b.g(new j(rVar));
        this.f42079b.i();
    }

    public boolean l(String str, String str2, s sVar) {
        if (!f()) {
            if (f42077c) {
                Log.e("PageDialogsHandler", "can not showJsAlert");
            }
            if (sVar != null) {
                sVar.a();
            }
            return false;
        }
        g.a aVar = new g.a(this.f42078a);
        aVar.U(d.a.h0.a.h.aiapps_dialog_webcall_common_title);
        aVar.y(str2);
        aVar.O(d.a.h0.a.h.aiapps_dialog_positive_button_text, new DialogInterface$OnClickListenerC0637b(this, sVar));
        aVar.L(new a(this, sVar));
        if (d.a.h0.a.w0.a.z().a()) {
            aVar.Y(false);
        } else {
            aVar.Y(true);
        }
        return true;
    }

    public boolean m(String str, String str2, s sVar) {
        if (!f()) {
            if (f42077c) {
                Log.e("PageDialogsHandler", "can not showJsConfirm");
            }
            if (sVar != null) {
                sVar.a();
            }
            return false;
        }
        g.a aVar = new g.a(this.f42078a);
        aVar.U(d.a.h0.a.h.aiapps_dialog_webcall_common_title);
        aVar.y(str2);
        aVar.O(d.a.h0.a.h.aiapps_dialog_positive_button_text, new e(this, sVar));
        aVar.C(d.a.h0.a.h.aiapps_dialog_nagtive_button_text, new d(this, sVar));
        aVar.L(new c(this, sVar));
        if (d.a.h0.a.w0.a.z().a()) {
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
        View inflate = LayoutInflater.from(this.f42078a).inflate(d.a.h0.a.g.aiapps_js_prompt, (ViewGroup) null);
        EditText editText = (EditText) inflate.findViewById(d.a.h0.a.f.value);
        editText.setText(str3);
        ((TextView) inflate.findViewById(d.a.h0.a.f.message)).setText(str2);
        g.a aVar = new g.a(this.f42078a);
        aVar.U(d.a.h0.a.h.aiapps_dialog_webcall_common_title);
        aVar.W(inflate);
        aVar.O(d.a.h0.a.h.aiapps_dialog_positive_button_text, new h(this, sVar, editText));
        aVar.C(d.a.h0.a.h.aiapps_dialog_nagtive_button_text, new g(this, sVar));
        aVar.L(new f(this, sVar));
        if (d.a.h0.a.w0.a.z().a()) {
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
        h2.a0(new b.a(this.f42078a.getText(d.a.h0.a.h.aiapps_ssl_got_it), d.a.h0.a.c.aiapps_safe_dialog_btn_black, new q(this, tVar)));
        h2.L(new p(this, tVar));
        h2.X();
    }

    public void p(t tVar, SslErrorHandler sslErrorHandler, SslError sslError) {
        if (!f()) {
            sslErrorHandler.cancel();
            return;
        }
        c.C0638c c0638c = new c.C0638c(this.f42078a);
        c0638c.g0(d.a.h0.a.h.aiapps_security_warning);
        c0638c.f0(d.a.h0.a.h.aiapps_ssl_warnings_header, new o(sslError));
        c0638c.a0(new b.a(this.f42078a.getText(d.a.h0.a.h.aiapps_ssl_continue), d.a.h0.a.c.aiapps_ssl_dialog_go_on_text_color, new n(this, tVar)));
        c0638c.a0(new b.a(this.f42078a.getText(d.a.h0.a.h.aiapps_view_certificate), d.a.h0.a.c.aiapps_safe_dialog_btn_black, new m(tVar, sslErrorHandler, sslError)));
        c0638c.a0(new b.a(this.f42078a.getText(d.a.h0.a.h.aiapps_ssl_go_back), d.a.h0.a.c.aiapps_safe_dialog_btn_black, new l(this, tVar)));
        c0638c.L(new k(this, sslErrorHandler));
        c0638c.X();
    }
}
