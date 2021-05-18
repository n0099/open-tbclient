package com.ss.android.socialbase.appdownloader.view;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import d.o.a.e.a.d;
import d.o.a.e.a.e;
import d.o.a.e.a.l;
/* loaded from: classes7.dex */
public class DownloadTaskDeleteActivity extends Activity {

    /* renamed from: a  reason: collision with root package name */
    public d.m f35912a;

    /* renamed from: b  reason: collision with root package name */
    public Intent f35913b;

    /* loaded from: classes7.dex */
    public class a implements DialogInterface.OnCancelListener {
        public a() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            DownloadTaskDeleteActivity.this.finish();
        }
    }

    /* loaded from: classes7.dex */
    public class b implements DialogInterface.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f35915e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ DownloadInfo f35916f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f35917g;

        public b(boolean z, DownloadInfo downloadInfo, int i2) {
            this.f35915e = z;
            this.f35916f = downloadInfo;
            this.f35917g = i2;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            if (this.f35915e) {
                DownloadTaskDeleteActivity.this.a(this.f35916f, this.f35917g);
            }
            DownloadTaskDeleteActivity.this.finish();
        }
    }

    /* loaded from: classes7.dex */
    public class c implements DialogInterface.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f35919e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ DownloadInfo f35920f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f35921g;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                d.o.a.e.b.g.a.l(DownloadTaskDeleteActivity.this).C(c.this.f35920f.c0());
            }
        }

        public c(boolean z, DownloadInfo downloadInfo, int i2) {
            this.f35919e = z;
            this.f35920f = downloadInfo;
            this.f35921g = i2;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            if (!this.f35919e) {
                DownloadTaskDeleteActivity.this.a(this.f35920f, this.f35921g);
            } else {
                this.f35920f.Q2(true);
                d.o.a.e.b.g.a.l(DownloadTaskDeleteActivity.this).v(this.f35920f.c0());
                new Handler(Looper.getMainLooper()).postDelayed(new a(), 100L);
            }
            DownloadTaskDeleteActivity.this.finish();
        }
    }

    private void b() {
        Intent intent;
        if (this.f35912a != null || (intent = this.f35913b) == null) {
            return;
        }
        try {
            boolean z = false;
            int intExtra = intent.getIntExtra("extra_click_download_ids", 0);
            DownloadInfo f2 = d.o.a.e.b.g.a.l(getApplicationContext()).f(intExtra);
            if (f2 == null) {
                return;
            }
            String P0 = f2.P0();
            if (TextUtils.isEmpty(P0)) {
                Log.w("DeleteActivity", "Missing appName; skipping handle");
                return;
            }
            String format = String.format(getString(l.a(this, "tt_appdownloader_notification_download_delete")), P0);
            d.e b2 = e.F().b();
            d.n a2 = b2 != null ? b2.a(this) : null;
            if (a2 == null) {
                a2 = new e.C1879e(this);
            }
            if (a2 != null) {
                int a3 = l.a(this, "tt_appdownloader_tip");
                int a4 = l.a(this, "tt_appdownloader_label_ok");
                int a5 = l.a(this, "tt_appdownloader_label_cancel");
                if (d.o.a.e.b.j.a.d(f2.c0()).b("cancel_with_net_opt", 0) == 1 && d.o.a.e.b.l.e.L0() && f2.E() != f2.Q0()) {
                    z = true;
                }
                if (z) {
                    a4 = l.a(this, "tt_appdownloader_label_reserve_wifi");
                    a5 = l.a(this, "tt_appdownloader_label_cancel_directly");
                    format = getResources().getString(l.a(this, "tt_appdownloader_resume_in_wifi"));
                }
                a2.a(a3).a(format).b(a4, new c(z, f2, intExtra)).a(a5, new b(z, f2, intExtra)).c(new a());
                this.f35912a = a2.a();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        a();
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        this.f35913b = getIntent();
        b();
        d.m mVar = this.f35912a;
        if (mVar != null && !mVar.b()) {
            this.f35912a.a();
        } else if (this.f35912a == null) {
            finish();
        }
    }

    private void a() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha = 0.0f;
        window.setAttributes(attributes);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DownloadInfo downloadInfo, int i2) {
        d.f t = e.F().t();
        if (t != null) {
            t.a(downloadInfo);
        }
        d.o.a.e.b.f.d i3 = d.o.a.e.b.g.a.l(d.o.a.e.b.g.d.l()).i(i2);
        if (i3 != null) {
            i3.a(10, downloadInfo, "", "");
        }
        if (d.o.a.e.b.g.d.l() != null) {
            d.o.a.e.b.g.a.l(d.o.a.e.b.g.d.l()).b(i2);
        }
    }
}
