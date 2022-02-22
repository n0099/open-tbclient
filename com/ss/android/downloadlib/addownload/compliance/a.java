package com.ss.android.downloadlib.addownload.compliance;

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
import com.bytedance.sdk.openadsdk.R;
import com.ss.android.downloadlib.addownload.compliance.d;
import com.ss.android.downloadlib.addownload.j;
import com.ss.android.downloadlib.g.l;
import com.ss.android.downloadlib.guide.install.ClipImageView;
/* loaded from: classes4.dex */
public class a extends Dialog {
    public TextView a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f59707b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f59708c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f59709d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f59710e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f59711f;

    /* renamed from: g  reason: collision with root package name */
    public ClipImageView f59712g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f59713h;

    /* renamed from: i  reason: collision with root package name */
    public Activity f59714i;

    /* renamed from: j  reason: collision with root package name */
    public final long f59715j;
    public long k;
    public final com.ss.android.downloadlib.addownload.b.b l;

    public a(@NonNull Activity activity, long j2) {
        super(activity);
        this.f59714i = activity;
        this.f59715j = j2;
        this.l = c.a().get(Long.valueOf(j2));
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        com.ss.android.socialbase.appdownloader.c.a(this.f59714i);
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.l == null) {
            dismiss();
            return;
        }
        requestWindowFeature(1);
        setContentView(R.layout.ttdownloader_dialog_appinfo);
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(R.drawable.ttdownloader_bg_transparent);
        }
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        this.k = this.l.f59653b;
        a();
        e.b("lp_app_dialog_show", this.k);
        setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.ss.android.downloadlib.addownload.compliance.a.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                e.a("lp_app_dialog_cancel", a.this.k);
            }
        });
    }

    private void a() {
        this.a = (TextView) findViewById(R.id.tv_app_name);
        this.f59707b = (TextView) findViewById(R.id.tv_app_version);
        this.f59708c = (TextView) findViewById(R.id.tv_app_developer);
        this.f59709d = (TextView) findViewById(R.id.tv_app_detail);
        this.f59710e = (TextView) findViewById(R.id.tv_app_privacy);
        this.f59711f = (TextView) findViewById(R.id.tv_give_up);
        this.f59712g = (ClipImageView) findViewById(R.id.iv_app_icon);
        this.f59713h = (LinearLayout) findViewById(R.id.ll_download);
        this.a.setText(l.a(this.l.f59656e, "--"));
        TextView textView = this.f59707b;
        textView.setText("版本号：" + l.a(this.l.f59657f, "--"));
        TextView textView2 = this.f59708c;
        textView2.setText("开发者：" + l.a(this.l.f59658g, "应用信息正在完善中"));
        this.f59712g.setRoundRadius(l.a(j.getContext(), 8.0f));
        this.f59712g.setBackgroundColor(Color.parseColor("#EBEBEB"));
        d.a().a(this.f59715j, new d.a() { // from class: com.ss.android.downloadlib.addownload.compliance.a.2
            @Override // com.ss.android.downloadlib.addownload.compliance.d.a
            public void a(Bitmap bitmap) {
                if (bitmap != null) {
                    a.this.f59712g.setImageBitmap(bitmap);
                } else {
                    e.a(8, a.this.k);
                }
            }
        });
        this.f59709d.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.a().a(a.this.f59714i);
                AppDetailInfoActivity.a(a.this.f59714i, a.this.f59715j);
                e.a("lp_app_dialog_click_detail", a.this.k);
            }
        });
        this.f59710e.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.a().a(a.this.f59714i);
                AppPrivacyPolicyActivity.a(a.this.f59714i, a.this.f59715j);
                e.a("lp_app_dialog_click_privacy", a.this.k);
            }
        });
        this.f59711f.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.dismiss();
                e.a("lp_app_dialog_click_giveup", a.this.k);
            }
        });
        this.f59713h.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.a("lp_app_dialog_click_download", a.this.k);
                b.a().b(a.this.k);
                a.this.dismiss();
            }
        });
    }
}
