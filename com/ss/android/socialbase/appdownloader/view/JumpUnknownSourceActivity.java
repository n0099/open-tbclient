package com.ss.android.socialbase.appdownloader.view;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import com.ss.android.socialbase.appdownloader.b;
import com.ss.android.socialbase.appdownloader.c.c;
import com.ss.android.socialbase.appdownloader.c.j;
import com.ss.android.socialbase.appdownloader.c.k;
import com.ss.android.socialbase.appdownloader.d;
import com.ss.android.socialbase.appdownloader.i;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class JumpUnknownSourceActivity extends Activity {

    /* renamed from: b  reason: collision with root package name */
    private Intent f13061b;
    @Nullable
    private Intent c;
    private JSONObject d;
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
        Intent intent = getIntent();
        this.f13061b = intent;
        if (intent != null) {
            this.c = (Intent) intent.getParcelableExtra("intent");
            try {
                this.d = new JSONObject(intent.getStringExtra("config"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        b();
        if (this.pTZ != null && !this.pTZ.b()) {
            this.pTZ.a();
        } else if (this.pTZ == null) {
            finish();
        }
    }

    private void b() {
        if (this.pTZ == null && this.f13061b != null) {
            try {
                c eCR = d.eCW().eCR();
                k kVar = null;
                if (eCR != null) {
                    kVar = eCR.iw(this);
                }
                com.ss.android.socialbase.appdownloader.d.a aVar = kVar == null ? new com.ss.android.socialbase.appdownloader.d.a(this) : kVar;
                int a2 = i.a(this, "appdownloader_tip");
                int a3 = i.a(this, "appdownloader_label_ok");
                int a4 = i.a(this, "appdownloader_label_cancel");
                String optString = this.d.optString("jump_unknown_source_tips");
                if (TextUtils.isEmpty(optString)) {
                    optString = getString(i.a(this, "appdownloader_jump_unknown_source_tips"));
                }
                aVar.QA(a2).ZH(optString).h(a3, new DialogInterface.OnClickListener() { // from class: com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity.3
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (!b.a(JumpUnknownSourceActivity.this, JumpUnknownSourceActivity.this.c, JumpUnknownSourceActivity.this.d)) {
                            b.c(JumpUnknownSourceActivity.this, JumpUnknownSourceActivity.this.c, true);
                        }
                        JumpUnknownSourceActivity.this.finish();
                    }
                }).i(a4, new DialogInterface.OnClickListener() { // from class: com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (JumpUnknownSourceActivity.this.c != null) {
                            b.c(JumpUnknownSourceActivity.this, JumpUnknownSourceActivity.this.c, true);
                        }
                        JumpUnknownSourceActivity.this.finish();
                    }
                }).h(new DialogInterface.OnCancelListener() { // from class: com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity.1
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        if (JumpUnknownSourceActivity.this.c != null) {
                            b.c(JumpUnknownSourceActivity.this, JumpUnknownSourceActivity.this.c, true);
                        }
                        JumpUnknownSourceActivity.this.finish();
                    }
                }).BE(false);
                this.pTZ = aVar.eCH();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
