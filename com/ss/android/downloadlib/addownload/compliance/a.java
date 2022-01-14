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
/* loaded from: classes3.dex */
public class a extends Dialog {
    public TextView a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f59495b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f59496c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f59497d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f59498e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f59499f;

    /* renamed from: g  reason: collision with root package name */
    public ClipImageView f59500g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f59501h;

    /* renamed from: i  reason: collision with root package name */
    public Activity f59502i;

    /* renamed from: j  reason: collision with root package name */
    public final long f59503j;
    public long k;
    public final com.ss.android.downloadlib.addownload.b.b l;

    public a(@NonNull Activity activity, long j2) {
        super(activity);
        this.f59502i = activity;
        this.f59503j = j2;
        this.l = c.a().get(Long.valueOf(j2));
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        com.ss.android.socialbase.appdownloader.c.a(this.f59502i);
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
        this.k = this.l.f59441b;
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
        this.f59495b = (TextView) findViewById(R.id.tv_app_version);
        this.f59496c = (TextView) findViewById(R.id.tv_app_developer);
        this.f59497d = (TextView) findViewById(R.id.tv_app_detail);
        this.f59498e = (TextView) findViewById(R.id.tv_app_privacy);
        this.f59499f = (TextView) findViewById(R.id.tv_give_up);
        this.f59500g = (ClipImageView) findViewById(R.id.iv_app_icon);
        this.f59501h = (LinearLayout) findViewById(R.id.ll_download);
        this.a.setText(l.a(this.l.f59444e, "--"));
        TextView textView = this.f59495b;
        textView.setText("版本号：" + l.a(this.l.f59445f, "--"));
        TextView textView2 = this.f59496c;
        textView2.setText("开发者：" + l.a(this.l.f59446g, "应用信息正在完善中"));
        this.f59500g.setRoundRadius(l.a(j.getContext(), 8.0f));
        this.f59500g.setBackgroundColor(Color.parseColor("#EBEBEB"));
        d.a().a(this.f59503j, new d.a() { // from class: com.ss.android.downloadlib.addownload.compliance.a.2
            @Override // com.ss.android.downloadlib.addownload.compliance.d.a
            public void a(Bitmap bitmap) {
                if (bitmap != null) {
                    a.this.f59500g.setImageBitmap(bitmap);
                } else {
                    e.a(8, a.this.k);
                }
            }
        });
        this.f59497d.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.a().a(a.this.f59502i);
                AppDetailInfoActivity.a(a.this.f59502i, a.this.f59503j);
                e.a("lp_app_dialog_click_detail", a.this.k);
            }
        });
        this.f59498e.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.a().a(a.this.f59502i);
                AppPrivacyPolicyActivity.a(a.this.f59502i, a.this.f59503j);
                e.a("lp_app_dialog_click_privacy", a.this.k);
            }
        });
        this.f59499f.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.dismiss();
                e.a("lp_app_dialog_click_giveup", a.this.k);
            }
        });
        this.f59501h.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.a("lp_app_dialog_click_download", a.this.k);
                b.a().b(a.this.k);
                a.this.dismiss();
            }
        });
    }
}
