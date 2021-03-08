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
/* loaded from: classes6.dex */
public class DownloadTaskDeleteActivity extends Activity {
    private Intent b;
    private j qft;

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
        this.b = getIntent();
        b();
        if (this.qft != null && !this.qft.b()) {
            this.qft.a();
        } else if (this.qft == null) {
            finish();
        }
    }

    private void b() {
        if (this.qft == null && this.b != null) {
            try {
                final int intExtra = this.b.getIntExtra("extra_click_download_ids", 0);
                final c h = f.iC(getApplicationContext()).h(intExtra);
                if (h != null) {
                    String i = h.i();
                    if (TextUtils.isEmpty(i)) {
                        Log.w("DeleteActivity", "Missing appName; skipping handle");
                        return;
                    }
                    String format = String.format(getString(i.a(this, "appdownloader_notification_download_delete")), i);
                    com.ss.android.socialbase.appdownloader.c.c eFu = d.eFz().eFu();
                    k kVar = null;
                    if (eFu != null) {
                        kVar = eFu.iA(this);
                    }
                    if (kVar == null) {
                        kVar = new com.ss.android.socialbase.appdownloader.d.a(this);
                    }
                    if (kVar != null) {
                        int a2 = i.a(this, "appdownloader_tip");
                        kVar.Ra(a2).aba(format).h(i.a(this, "appdownloader_label_ok"), new DialogInterface.OnClickListener() { // from class: com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity.3
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i2) {
                                com.ss.android.socialbase.appdownloader.c.d eFv = d.eFz().eFv();
                                if (eFv != null) {
                                    eFv.a(h);
                                }
                                com.ss.android.socialbase.downloader.d.d Rx = f.iC(b.eGG()).Rx(intExtra);
                                if (Rx != null) {
                                    Rx.a(10, h, "", "");
                                }
                                if (b.eGG() != null) {
                                    f.iC(b.eGG()).b(intExtra);
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
                        this.qft = kVar.eFk();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
