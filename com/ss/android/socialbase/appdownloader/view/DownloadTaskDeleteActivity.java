package com.ss.android.socialbase.appdownloader.view;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import com.ss.android.socialbase.appdownloader.c.j;
import com.ss.android.socialbase.appdownloader.c.k;
import com.ss.android.socialbase.appdownloader.d;
import com.ss.android.socialbase.appdownloader.i;
import com.ss.android.socialbase.downloader.downloader.b;
import com.ss.android.socialbase.downloader.downloader.f;
import com.ss.android.socialbase.downloader.g.c;
/* loaded from: classes4.dex */
public class DownloadTaskDeleteActivity extends Activity {

    /* renamed from: b  reason: collision with root package name */
    private Intent f13359b;
    private j pYz;

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    @Override // android.app.Activity
    protected void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        a();
    }

    private void a() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha = 0.0f;
        window.setAttributes(attributes);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        this.f13359b = getIntent();
        b();
        if (this.pYz != null && !this.pYz.b()) {
            this.pYz.a();
        } else if (this.pYz == null) {
            finish();
        }
    }

    private void b() {
        if (this.pYz == null && this.f13359b != null) {
            try {
                final int intExtra = this.f13359b.getIntExtra("extra_click_download_ids", 0);
                final c h = f.iA(getApplicationContext()).h(intExtra);
                if (h != null) {
                    String i = h.i();
                    if (TextUtils.isEmpty(i)) {
                        Log.w("DeleteActivity", "Missing appName; skipping handle");
                        return;
                    }
                    String format = String.format(getString(i.a(this, "appdownloader_notification_download_delete")), i);
                    com.ss.android.socialbase.appdownloader.c.c eGH = d.eGM().eGH();
                    k kVar = null;
                    if (eGH != null) {
                        kVar = eGH.iy(this);
                    }
                    if (kVar == null) {
                        kVar = new com.ss.android.socialbase.appdownloader.d.a(this);
                    }
                    if (kVar != null) {
                        int a2 = i.a(this, "appdownloader_tip");
                        kVar.Sh(a2).aaP(format).h(i.a(this, "appdownloader_label_ok"), new DialogInterface.OnClickListener() { // from class: com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity.3
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i2) {
                                com.ss.android.socialbase.appdownloader.c.d eGI = d.eGM().eGI();
                                if (eGI != null) {
                                    eGI.a(h);
                                }
                                com.ss.android.socialbase.downloader.d.d SE = f.iA(b.eHT()).SE(intExtra);
                                if (SE != null) {
                                    SE.a(10, h, "", "");
                                }
                                if (b.eHT() != null) {
                                    f.iA(b.eHT()).b(intExtra);
                                }
                                DownloadTaskDeleteActivity.this.finish();
                            }
                        }).i(i.a(this, "appdownloader_label_cancel"), new DialogInterface.OnClickListener() { // from class: com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity.2
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i2) {
                                DownloadTaskDeleteActivity.this.finish();
                            }
                        }).h(new DialogInterface.OnCancelListener() { // from class: com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity.1
                            @Override // android.content.DialogInterface.OnCancelListener
                            public void onCancel(DialogInterface dialogInterface) {
                                DownloadTaskDeleteActivity.this.finish();
                            }
                        });
                        this.pYz = kVar.eGy();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
