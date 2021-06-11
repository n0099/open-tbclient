package d.o.a.d.f.f;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.ss.android.downloadlib.addownload.compliance.AppDetailInfoActivity;
import com.ss.android.downloadlib.addownload.compliance.AppPrivacyPolicyActivity;
import com.ss.android.downloadlib.addownload.compliance.d;
import com.ss.android.downloadlib.guide.install.ClipImageView;
import d.o.a.d.f.c;
import d.o.a.d.f.n;
import d.o.a.d.n.k;
/* loaded from: classes7.dex */
public class a extends Dialog {

    /* renamed from: e  reason: collision with root package name */
    public TextView f70574e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f70575f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f70576g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f70577h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f70578i;
    public TextView j;
    public ClipImageView k;
    public LinearLayout l;
    public Activity m;
    public final long n;
    public long o;
    public final c.C1926c p;

    /* renamed from: d.o.a.d.f.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class DialogInterface$OnCancelListenerC1928a implements DialogInterface.OnCancelListener {
        public DialogInterface$OnCancelListenerC1928a() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            d.o.a.d.f.f.c.c("lp_app_dialog_cancel", a.this.o);
        }
    }

    /* loaded from: classes7.dex */
    public class b implements d.c {
        public b() {
        }

        @Override // com.ss.android.downloadlib.addownload.compliance.d.c
        public void a(Bitmap bitmap) {
            if (bitmap != null) {
                a.this.k.setImageBitmap(bitmap);
            } else {
                d.o.a.d.f.f.c.a(8, a.this.o);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.o.a.d.f.f.b.a().c(a.this.m);
            AppDetailInfoActivity.a(a.this.m, a.this.n);
            d.o.a.d.f.f.c.c("lp_app_dialog_click_detail", a.this.o);
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.o.a.d.f.f.b.a().c(a.this.m);
            AppPrivacyPolicyActivity.a(a.this.m, a.this.n);
            d.o.a.d.f.f.c.c("lp_app_dialog_click_privacy", a.this.o);
        }
    }

    /* loaded from: classes7.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.dismiss();
            d.o.a.d.f.f.c.c("lp_app_dialog_click_giveup", a.this.o);
        }
    }

    /* loaded from: classes7.dex */
    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.o.a.d.f.f.c.c("lp_app_dialog_click_download", a.this.o);
            d.o.a.d.f.f.b.a().i(a.this.o);
            a.this.dismiss();
        }
    }

    public a(@NonNull Activity activity, long j) {
        super(activity);
        this.m = activity;
        this.n = j;
        this.p = com.ss.android.downloadlib.addownload.compliance.c.a().get(Long.valueOf(j));
    }

    public final void b() {
        this.f70574e = (TextView) findViewById(d.o.a.d.b.tv_app_name);
        this.f70575f = (TextView) findViewById(d.o.a.d.b.tv_app_version);
        this.f70576g = (TextView) findViewById(d.o.a.d.b.tv_app_developer);
        this.f70577h = (TextView) findViewById(d.o.a.d.b.tv_app_detail);
        this.f70578i = (TextView) findViewById(d.o.a.d.b.tv_app_privacy);
        this.j = (TextView) findViewById(d.o.a.d.b.tv_give_up);
        this.k = (ClipImageView) findViewById(d.o.a.d.b.iv_app_icon);
        this.l = (LinearLayout) findViewById(d.o.a.d.b.ll_download);
        this.f70574e.setText(k.m(this.p.f70525d, "--"));
        TextView textView = this.f70575f;
        textView.setText("版本号：" + k.m(this.p.f70526e, "--"));
        TextView textView2 = this.f70576g;
        textView2.setText("开发者：" + k.m(this.p.f70527f, "应用信息正在完善中"));
        this.k.setRoundRadius(k.b(n.a(), 8.0f));
        this.k.setBackgroundColor(Color.parseColor("#EBEBEB"));
        com.ss.android.downloadlib.addownload.compliance.d.a().a(this.n, new b());
        this.f70577h.setOnClickListener(new c());
        this.f70578i.setOnClickListener(new d());
        this.j.setOnClickListener(new e());
        this.l.setOnClickListener(new f());
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        d.o.a.e.a.d.q(this.m);
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.p == null) {
            dismiss();
            return;
        }
        requestWindowFeature(1);
        setContentView(d.o.a.d.c.ttdownloader_dialog_appinfo);
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(d.o.a.d.a.ttdownloader_bg_transparent);
        }
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        this.o = this.p.f70523b;
        b();
        d.o.a.d.f.f.c.f("lp_app_dialog_show", this.o);
        setOnCancelListener(new DialogInterface$OnCancelListenerC1928a());
    }
}
