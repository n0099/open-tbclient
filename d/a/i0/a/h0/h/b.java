package d.a.i0.a.h0.h;

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
import d.a.i0.a.h0.h.a;
import d.a.i0.a.h0.h.c;
import d.a.i0.a.h0.h.d;
import d.a.i0.a.z1.b.b.b;
import d.a.i0.a.z1.b.b.h;
import java.util.Date;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f41941c = d.a.i0.a.k.f43025a;

    /* renamed from: a  reason: collision with root package name */
    public Context f41942a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.i0.a.h0.h.a f41943b;

    /* loaded from: classes2.dex */
    public class a implements DialogInterface.OnCancelListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ s f41944e;

        public a(b bVar, s sVar) {
            this.f41944e = sVar;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            s sVar = this.f41944e;
            if (sVar != null) {
                sVar.onCancel();
            }
        }
    }

    /* renamed from: d.a.i0.a.h0.h.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class DialogInterface$OnClickListenerC0653b implements DialogInterface.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ s f41945e;

        public DialogInterface$OnClickListenerC0653b(b bVar, s sVar) {
            this.f41945e = sVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            s sVar = this.f41945e;
            if (sVar != null) {
                sVar.b("");
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements DialogInterface.OnCancelListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ s f41946e;

        public c(b bVar, s sVar) {
            this.f41946e = sVar;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            s sVar = this.f41946e;
            if (sVar != null) {
                sVar.onCancel();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements DialogInterface.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ s f41947e;

        public d(b bVar, s sVar) {
            this.f41947e = sVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            s sVar = this.f41947e;
            if (sVar != null) {
                sVar.onCancel();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e implements DialogInterface.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ s f41948e;

        public e(b bVar, s sVar) {
            this.f41948e = sVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            s sVar = this.f41948e;
            if (sVar != null) {
                sVar.b("");
            }
        }
    }

    /* loaded from: classes2.dex */
    public class f implements DialogInterface.OnCancelListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ s f41949e;

        public f(b bVar, s sVar) {
            this.f41949e = sVar;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            s sVar = this.f41949e;
            if (sVar != null) {
                sVar.onCancel();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class g implements DialogInterface.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ s f41950e;

        public g(b bVar, s sVar) {
            this.f41950e = sVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            s sVar = this.f41950e;
            if (sVar != null) {
                sVar.onCancel();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class h implements DialogInterface.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ s f41951e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ EditText f41952f;

        public h(b bVar, s sVar, EditText editText) {
            this.f41951e = sVar;
            this.f41952f = editText;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            s sVar = this.f41951e;
            if (sVar != null) {
                sVar.b(this.f41952f.getText().toString());
            }
        }
    }

    /* loaded from: classes2.dex */
    public class i implements a.f {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ r f41953a;

        public i(r rVar) {
            this.f41953a = rVar;
        }

        @Override // d.a.i0.a.h0.h.a.f
        public void a(String str, String str2, String str3, String str4) {
            r rVar = this.f41953a;
            if (rVar != null) {
                rVar.b(str3, str4);
            }
            b.this.f41943b = null;
        }
    }

    /* loaded from: classes2.dex */
    public class j implements a.e {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ r f41955a;

        public j(r rVar) {
            this.f41955a = rVar;
        }

        @Override // d.a.i0.a.h0.h.a.e
        public void onCancel() {
            r rVar = this.f41955a;
            if (rVar != null) {
                rVar.a();
            }
            b.this.f41943b = null;
        }
    }

    /* loaded from: classes2.dex */
    public class k implements DialogInterface.OnCancelListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SslErrorHandler f41957e;

        public k(b bVar, SslErrorHandler sslErrorHandler) {
            this.f41957e = sslErrorHandler;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            this.f41957e.cancel();
        }
    }

    /* loaded from: classes2.dex */
    public class l implements b.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ t f41958a;

        public l(b bVar, t tVar) {
            this.f41958a = tVar;
        }

        @Override // d.a.i0.a.z1.b.b.b.c
        public void a(View view) {
            t tVar = this.f41958a;
            if (tVar != null) {
                tVar.c();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class m implements b.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ t f41959a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SslErrorHandler f41960b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SslError f41961c;

        public m(t tVar, SslErrorHandler sslErrorHandler, SslError sslError) {
            this.f41959a = tVar;
            this.f41960b = sslErrorHandler;
            this.f41961c = sslError;
        }

        @Override // d.a.i0.a.z1.b.b.b.c
        public void a(View view) {
            b.this.o(this.f41959a, this.f41960b, this.f41961c);
        }
    }

    /* loaded from: classes2.dex */
    public class n implements b.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ t f41963a;

        public n(b bVar, t tVar) {
            this.f41963a = tVar;
        }

        @Override // d.a.i0.a.z1.b.b.b.c
        public void a(View view) {
            t tVar = this.f41963a;
            if (tVar != null) {
                tVar.b();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class o implements b.c {

        /* renamed from: a  reason: collision with root package name */
        public long[] f41964a = null;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SslError f41965b;

        public o(SslError sslError) {
            this.f41965b = sslError;
        }

        @Override // d.a.i0.a.z1.b.b.b.c
        public void a(View view) {
            if (this.f41964a == null) {
                this.f41964a = new long[5];
            }
            long[] jArr = this.f41964a;
            System.arraycopy(jArr, 1, jArr, 0, jArr.length - 1);
            long[] jArr2 = this.f41964a;
            jArr2[jArr2.length - 1] = SystemClock.uptimeMillis();
            if (this.f41964a[0] >= SystemClock.uptimeMillis() - 3000) {
                this.f41964a = null;
                b.this.g(this.f41965b.toString());
            }
        }
    }

    /* loaded from: classes2.dex */
    public class p implements DialogInterface.OnCancelListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ t f41967e;

        public p(b bVar, t tVar) {
            this.f41967e = tVar;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            t tVar = this.f41967e;
            if (tVar != null) {
                tVar.a();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class q implements b.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ t f41968a;

        public q(b bVar, t tVar) {
            this.f41968a = tVar;
        }

        @Override // d.a.i0.a.z1.b.b.b.c
        public void a(View view) {
            t tVar = this.f41968a;
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
        this.f41942a = context;
    }

    public final void c(LinearLayout linearLayout, int i2) {
        d(linearLayout, i2, d.a.i0.a.e.aiapps_dialog_browser_security_good);
    }

    public final void d(LinearLayout linearLayout, int i2, int i3) {
        View inflate = LayoutInflater.from(this.f41942a).inflate(d.a.i0.a.g.aiapps_ssl_content_header, (ViewGroup) linearLayout, false);
        TextView textView = (TextView) inflate.findViewById(d.a.i0.a.f.ssl_header_text);
        textView.setTextColor(inflate.getContext().getResources().getColor(d.a.i0.a.c.aiapps_safe_dialog_message));
        textView.setText(i2);
        ((BdBaseImageView) inflate.findViewById(d.a.i0.a.f.ssl_header_icon)).setImageResource(i3);
        linearLayout.addView(inflate);
    }

    public final void e(LinearLayout linearLayout, int i2) {
        d(linearLayout, i2, d.a.i0.a.e.aiapps_dialog_browser_security_bad);
    }

    public final boolean f() {
        Context context = this.f41942a;
        return (context instanceof Activity) && !((Activity) context).isFinishing();
    }

    public void g(String str) {
        ((ClipboardManager) this.f41942a.getSystemService("clipboard")).setText(str);
        d.a.i0.a.z1.b.f.e.f(this.f41942a, d.a.i0.a.h.aiapps_ssl_copy_error).F();
    }

    public final d.a h(SslCertificate sslCertificate, SslError sslError) {
        View j2 = j(sslCertificate);
        LinearLayout linearLayout = (LinearLayout) j2.findViewById(d.a.i0.a.f.placeholder);
        j2.findViewById(d.a.i0.a.f.ssl_divider).setBackgroundColor(this.f41942a.getResources().getColor(d.a.i0.a.c.aiapps_dialog_gray));
        if (sslError == null) {
            c(linearLayout, d.a.i0.a.h.aiapps_ssl_certificate_is_valid);
        } else {
            if (sslError.hasError(3)) {
                e(linearLayout, d.a.i0.a.h.aiapps_ssl_untrusted);
            }
            if (sslError.hasError(2)) {
                e(linearLayout, d.a.i0.a.h.aiapps_ssl_mismatch);
            }
            if (sslError.hasError(1)) {
                e(linearLayout, d.a.i0.a.h.aiapps_ssl_expired);
            }
            if (sslError.hasError(0)) {
                e(linearLayout, d.a.i0.a.h.aiapps_ssl_not_yet_valid);
            }
            if (sslError.hasError(4)) {
                e(linearLayout, d.a.i0.a.h.aiapps_ssl_date_invalid);
            }
            if (sslError.hasError(5)) {
                e(linearLayout, d.a.i0.a.h.aiapps_ssl_invalid);
            }
            if (linearLayout.getChildCount() == 0) {
                e(linearLayout, d.a.i0.a.h.aiapps_ssl_unknown);
            }
        }
        d.a aVar = new d.a(this.f41942a);
        aVar.d0(d.a.i0.a.h.aiapps_ssl_certificate);
        aVar.c0(j2);
        return aVar;
    }

    public final String i(Date date) {
        return date == null ? "" : DateFormat.getDateFormat(this.f41942a).format(date);
    }

    public final View j(SslCertificate sslCertificate) {
        View inflate = LayoutInflater.from(this.f41942a).inflate(d.a.i0.a.g.aiapps_ssl_certificate, (ViewGroup) null);
        int color = this.f41942a.getResources().getColor(d.a.i0.a.c.aiapps_safe_dialog_message);
        ViewGroup viewGroup = (ViewGroup) inflate.findViewById(d.a.i0.a.f.body);
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
            ((TextView) inflate.findViewById(d.a.i0.a.f.to_common)).setText(issuedTo.getCName());
            ((TextView) inflate.findViewById(d.a.i0.a.f.to_org)).setText(issuedTo.getOName());
            ((TextView) inflate.findViewById(d.a.i0.a.f.to_org_unit)).setText(issuedTo.getUName());
        }
        SslCertificate.DName issuedBy = sslCertificate.getIssuedBy();
        if (issuedBy != null) {
            ((TextView) inflate.findViewById(d.a.i0.a.f.by_common)).setText(issuedBy.getCName());
            ((TextView) inflate.findViewById(d.a.i0.a.f.by_org)).setText(issuedBy.getOName());
            ((TextView) inflate.findViewById(d.a.i0.a.f.by_org_unit)).setText(issuedBy.getUName());
        }
        ((TextView) inflate.findViewById(d.a.i0.a.f.issued_on)).setText(i(sslCertificate.getValidNotBeforeDate()));
        ((TextView) inflate.findViewById(d.a.i0.a.f.expires_on)).setText(i(sslCertificate.getValidNotAfterDate()));
        return inflate;
    }

    public void k(r rVar, String str, String str2) {
        d.a.i0.a.h0.h.a aVar = new d.a.i0.a.h0.h.a(this.f41942a, str, str2);
        this.f41943b = aVar;
        aVar.h(new i(rVar));
        this.f41943b.g(new j(rVar));
        this.f41943b.i();
    }

    public boolean l(String str, String str2, s sVar) {
        if (!f()) {
            if (f41941c) {
                Log.e("PageDialogsHandler", "can not showJsAlert");
            }
            if (sVar != null) {
                sVar.a();
            }
            return false;
        }
        h.a aVar = new h.a(this.f41942a);
        aVar.U(d.a.i0.a.h.aiapps_dialog_webcall_common_title);
        aVar.x(str2);
        aVar.O(d.a.i0.a.h.aiapps_confirm, new DialogInterface$OnClickListenerC0653b(this, sVar));
        aVar.K(new a(this, sVar));
        if (d.a.i0.a.c1.a.H().a()) {
            aVar.Y(false);
        } else {
            aVar.Y(true);
        }
        return true;
    }

    public boolean m(String str, String str2, s sVar) {
        if (!f()) {
            if (f41941c) {
                Log.e("PageDialogsHandler", "can not showJsConfirm");
            }
            if (sVar != null) {
                sVar.a();
            }
            return false;
        }
        h.a aVar = new h.a(this.f41942a);
        aVar.U(d.a.i0.a.h.aiapps_dialog_webcall_common_title);
        aVar.x(str2);
        aVar.O(d.a.i0.a.h.aiapps_confirm, new e(this, sVar));
        aVar.B(d.a.i0.a.h.aiapps_cancel, new d(this, sVar));
        aVar.K(new c(this, sVar));
        if (d.a.i0.a.c1.a.H().a()) {
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
        View inflate = LayoutInflater.from(this.f41942a).inflate(d.a.i0.a.g.aiapps_js_prompt, (ViewGroup) null);
        EditText editText = (EditText) inflate.findViewById(d.a.i0.a.f.value);
        editText.setText(str3);
        ((TextView) inflate.findViewById(d.a.i0.a.f.message)).setText(str2);
        h.a aVar = new h.a(this.f41942a);
        aVar.U(d.a.i0.a.h.aiapps_dialog_webcall_common_title);
        aVar.W(inflate);
        aVar.O(d.a.i0.a.h.aiapps_confirm, new h(this, sVar, editText));
        aVar.B(d.a.i0.a.h.aiapps_cancel, new g(this, sVar));
        aVar.K(new f(this, sVar));
        if (d.a.i0.a.c1.a.H().a()) {
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
        h2.a0(new b.a(this.f41942a.getText(d.a.i0.a.h.aiapps_confirm_text), d.a.i0.a.c.aiapps_safe_dialog_btn_black, new q(this, tVar)));
        h2.K(new p(this, tVar));
        h2.X();
    }

    public void p(t tVar, SslErrorHandler sslErrorHandler, SslError sslError) {
        if (!f()) {
            sslErrorHandler.cancel();
            return;
        }
        c.C0654c c0654c = new c.C0654c(this.f41942a);
        c0654c.g0(d.a.i0.a.h.aiapps_security_warning);
        c0654c.f0(d.a.i0.a.h.aiapps_ssl_warnings_header, new o(sslError));
        c0654c.a0(new b.a(this.f41942a.getText(d.a.i0.a.h.aiapps_ssl_continue), d.a.i0.a.c.aiapps_ssl_dialog_go_on_text_color, new n(this, tVar)));
        c0654c.a0(new b.a(this.f41942a.getText(d.a.i0.a.h.aiapps_view_certificate), d.a.i0.a.c.aiapps_safe_dialog_btn_black, new m(tVar, sslErrorHandler, sslError)));
        c0654c.a0(new b.a(this.f41942a.getText(d.a.i0.a.h.aiapps_ssl_go_back), d.a.i0.a.c.aiapps_safe_dialog_btn_black, new l(this, tVar)));
        c0654c.K(new k(this, sslErrorHandler));
        c0654c.X();
    }
}
