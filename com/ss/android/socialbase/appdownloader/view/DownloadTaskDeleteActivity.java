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
    private Intent f13059b;
    private j pTZ;

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
        this.f13059b = getIntent();
        b();
        if (this.pTZ != null && !this.pTZ.b()) {
            this.pTZ.a();
        } else if (this.pTZ == null) {
            finish();
        }
    }

    private void b() {
        if (this.pTZ == null && this.f13059b != null) {
            try {
                final int intExtra = this.f13059b.getIntExtra("extra_click_download_ids", 0);
                final c h = f.iy(getApplicationContext()).h(intExtra);
                if (h != null) {
                    String i = h.i();
                    if (TextUtils.isEmpty(i)) {
                        Log.w("DeleteActivity", "Missing appName; skipping handle");
                        return;
                    }
                    String format = String.format(getString(i.a(this, "appdownloader_notification_download_delete")), i);
                    com.ss.android.socialbase.appdownloader.c.c eCR = d.eCW().eCR();
                    k kVar = null;
                    if (eCR != null) {
                        kVar = eCR.iw(this);
                    }
                    if (kVar == null) {
                        kVar = new com.ss.android.socialbase.appdownloader.d.a(this);
                    }
                    if (kVar != null) {
                        int a2 = i.a(this, "appdownloader_tip");
                        kVar.QA(a2).ZH(format).h(i.a(this, "appdownloader_label_ok"), new DialogInterface.OnClickListener() { // from class: com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity.3
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i2) {
                                com.ss.android.socialbase.appdownloader.c.d eCS = d.eCW().eCS();
                                if (eCS != null) {
                                    eCS.a(h);
                                }
                                com.ss.android.socialbase.downloader.d.d QX = f.iy(b.eEd()).QX(intExtra);
                                if (QX != null) {
                                    QX.a(10, h, "", "");
                                }
                                if (b.eEd() != null) {
                                    f.iy(b.eEd()).b(intExtra);
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
                        this.pTZ = kVar.eCH();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
