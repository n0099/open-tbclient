package com.ss.android.socialbase.appdownloader.view;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import com.baidu.searchbox.updateprocessor.UpdateCloudControlProcessor;
import com.ss.android.socialbase.appdownloader.b;
import com.ss.android.socialbase.appdownloader.c;
import com.ss.android.socialbase.appdownloader.c.k;
import com.ss.android.socialbase.appdownloader.c.l;
import com.ss.android.socialbase.appdownloader.d;
import com.ss.android.socialbase.appdownloader.h;
import com.ss.android.socialbase.appdownloader.i;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class JumpUnknownSourceActivity extends Activity {
    public k a;

    /* renamed from: b  reason: collision with root package name */
    public Intent f62171b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public Intent f62172c;

    /* renamed from: d  reason: collision with root package name */
    public int f62173d;

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f62174e;

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        a();
        h.a().a(this);
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        h.a().a(this);
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        Intent intent = getIntent();
        this.f62171b = intent;
        if (intent != null) {
            this.f62172c = (Intent) intent.getParcelableExtra("intent");
            this.f62173d = intent.getIntExtra("id", -1);
            try {
                this.f62174e = new JSONObject(intent.getStringExtra(UpdateCloudControlProcessor.CLOUD_UPDATE_ACTION_NAME));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if (this.f62174e == null) {
            c.a((Activity) this);
            return;
        }
        b();
        k kVar = this.a;
        if (kVar != null && !kVar.b()) {
            this.a.a();
        } else if (this.a == null) {
            finish();
        }
    }

    private void a() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha = 0.0f;
        window.setAttributes(attributes);
    }

    private void b() {
        if (this.a != null || this.f62171b == null) {
            return;
        }
        try {
            com.ss.android.socialbase.appdownloader.c.c a = d.j().a();
            l a2 = a != null ? a.a(this) : null;
            if (a2 == null) {
                a2 = new com.ss.android.socialbase.appdownloader.d.a(this);
            }
            int a3 = i.a(this, "tt_appdownloader_tip");
            int a4 = i.a(this, "tt_appdownloader_label_ok");
            int a5 = i.a(this, "tt_appdownloader_label_cancel");
            String optString = this.f62174e.optString("jump_unknown_source_tips");
            if (TextUtils.isEmpty(optString)) {
                optString = getString(i.a(this, "tt_appdownloader_jump_unknown_source_tips"));
            }
            a2.a(a3).a(optString).a(a4, new DialogInterface.OnClickListener() { // from class: com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    JumpUnknownSourceActivity jumpUnknownSourceActivity = JumpUnknownSourceActivity.this;
                    if (b.a(jumpUnknownSourceActivity, jumpUnknownSourceActivity.f62172c, JumpUnknownSourceActivity.this.f62173d, JumpUnknownSourceActivity.this.f62174e)) {
                        b.c(JumpUnknownSourceActivity.this.f62173d, JumpUnknownSourceActivity.this.f62174e);
                    } else {
                        JumpUnknownSourceActivity jumpUnknownSourceActivity2 = JumpUnknownSourceActivity.this;
                        b.a((Context) jumpUnknownSourceActivity2, jumpUnknownSourceActivity2.f62172c, true);
                    }
                    b.a(JumpUnknownSourceActivity.this.f62173d, JumpUnknownSourceActivity.this.f62174e);
                    JumpUnknownSourceActivity.this.finish();
                }
            }).b(a5, new DialogInterface.OnClickListener() { // from class: com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    if (JumpUnknownSourceActivity.this.f62172c != null) {
                        JumpUnknownSourceActivity jumpUnknownSourceActivity = JumpUnknownSourceActivity.this;
                        b.a((Context) jumpUnknownSourceActivity, jumpUnknownSourceActivity.f62172c, true);
                    }
                    b.b(JumpUnknownSourceActivity.this.f62173d, JumpUnknownSourceActivity.this.f62174e);
                    JumpUnknownSourceActivity.this.finish();
                }
            }).a(new DialogInterface.OnCancelListener() { // from class: com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity.1
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    if (JumpUnknownSourceActivity.this.f62172c != null) {
                        JumpUnknownSourceActivity jumpUnknownSourceActivity = JumpUnknownSourceActivity.this;
                        b.a((Context) jumpUnknownSourceActivity, jumpUnknownSourceActivity.f62172c, true);
                    }
                    b.b(JumpUnknownSourceActivity.this.f62173d, JumpUnknownSourceActivity.this.f62174e);
                    JumpUnknownSourceActivity.this.finish();
                }
            }).a(false);
            this.a = a2.a();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
