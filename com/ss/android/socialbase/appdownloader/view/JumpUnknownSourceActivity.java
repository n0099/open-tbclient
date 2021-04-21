package com.ss.android.socialbase.appdownloader.view;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import d.p.a.e.a.d;
import d.p.a.e.a.e;
import d.p.a.e.a.k;
import d.p.a.e.a.l;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class JumpUnknownSourceActivity extends Activity {

    /* renamed from: a  reason: collision with root package name */
    public d.m f39093a;

    /* renamed from: b  reason: collision with root package name */
    public Intent f39094b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public Intent f39095c;

    /* renamed from: d  reason: collision with root package name */
    public int f39096d;

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f39097e;

    /* loaded from: classes6.dex */
    public class a implements DialogInterface.OnCancelListener {
        public a() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (JumpUnknownSourceActivity.this.f39095c != null) {
                JumpUnknownSourceActivity jumpUnknownSourceActivity = JumpUnknownSourceActivity.this;
                d.p.a.e.a.c.p(jumpUnknownSourceActivity, jumpUnknownSourceActivity.f39095c, true);
            }
            d.p.a.e.a.c.B(JumpUnknownSourceActivity.this.f39096d, JumpUnknownSourceActivity.this.f39097e);
            JumpUnknownSourceActivity.this.finish();
        }
    }

    /* loaded from: classes6.dex */
    public class b implements DialogInterface.OnClickListener {
        public b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            if (JumpUnknownSourceActivity.this.f39095c != null) {
                JumpUnknownSourceActivity jumpUnknownSourceActivity = JumpUnknownSourceActivity.this;
                d.p.a.e.a.c.p(jumpUnknownSourceActivity, jumpUnknownSourceActivity.f39095c, true);
            }
            d.p.a.e.a.c.B(JumpUnknownSourceActivity.this.f39096d, JumpUnknownSourceActivity.this.f39097e);
            JumpUnknownSourceActivity.this.finish();
        }
    }

    /* loaded from: classes6.dex */
    public class c implements DialogInterface.OnClickListener {
        public c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            JumpUnknownSourceActivity jumpUnknownSourceActivity = JumpUnknownSourceActivity.this;
            if (d.p.a.e.a.c.n(jumpUnknownSourceActivity, jumpUnknownSourceActivity.f39095c, JumpUnknownSourceActivity.this.f39096d, JumpUnknownSourceActivity.this.f39097e)) {
                d.p.a.e.a.c.I(JumpUnknownSourceActivity.this.f39096d, JumpUnknownSourceActivity.this.f39097e);
            } else {
                JumpUnknownSourceActivity jumpUnknownSourceActivity2 = JumpUnknownSourceActivity.this;
                d.p.a.e.a.c.p(jumpUnknownSourceActivity2, jumpUnknownSourceActivity2.f39095c, true);
            }
            d.p.a.e.a.c.f(JumpUnknownSourceActivity.this.f39096d, JumpUnknownSourceActivity.this.f39097e);
            JumpUnknownSourceActivity.this.finish();
        }
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        a();
        k.d().f(this);
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        k.d().f(this);
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        Intent intent = getIntent();
        this.f39094b = intent;
        if (intent != null) {
            this.f39095c = (Intent) intent.getParcelableExtra("intent");
            this.f39096d = intent.getIntExtra("id", -1);
            try {
                this.f39097e = new JSONObject(intent.getStringExtra("config"));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        b();
        d.m mVar = this.f39093a;
        if (mVar != null && !mVar.b()) {
            this.f39093a.a();
        } else if (this.f39093a == null) {
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
        if (this.f39093a != null || this.f39094b == null) {
            return;
        }
        try {
            d.e b2 = e.F().b();
            d.n a2 = b2 != null ? b2.a(this) : null;
            if (a2 == null) {
                a2 = new e.C1880e(this);
            }
            int a3 = l.a(this, "tt_appdownloader_tip");
            int a4 = l.a(this, "tt_appdownloader_label_ok");
            int a5 = l.a(this, "tt_appdownloader_label_cancel");
            String optString = this.f39097e.optString("jump_unknown_source_tips");
            if (TextUtils.isEmpty(optString)) {
                optString = getString(l.a(this, "tt_appdownloader_jump_unknown_source_tips"));
            }
            a2.a(a3).a(optString).b(a4, new c()).a(a5, new b()).c(new a()).a(false);
            this.f39093a = a2.a();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
