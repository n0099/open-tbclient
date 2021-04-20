package com.ss.android.socialbase.appdownloader.view;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import d.o.a.e.a.d;
import d.o.a.e.a.e;
import d.o.a.e.a.k;
import d.o.a.e.a.l;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class JumpUnknownSourceActivity extends Activity {

    /* renamed from: a  reason: collision with root package name */
    public d.m f38998a;

    /* renamed from: b  reason: collision with root package name */
    public Intent f38999b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public Intent f39000c;

    /* renamed from: d  reason: collision with root package name */
    public int f39001d;

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f39002e;

    /* loaded from: classes6.dex */
    public class a implements DialogInterface.OnCancelListener {
        public a() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (JumpUnknownSourceActivity.this.f39000c != null) {
                JumpUnknownSourceActivity jumpUnknownSourceActivity = JumpUnknownSourceActivity.this;
                d.o.a.e.a.c.p(jumpUnknownSourceActivity, jumpUnknownSourceActivity.f39000c, true);
            }
            d.o.a.e.a.c.B(JumpUnknownSourceActivity.this.f39001d, JumpUnknownSourceActivity.this.f39002e);
            JumpUnknownSourceActivity.this.finish();
        }
    }

    /* loaded from: classes6.dex */
    public class b implements DialogInterface.OnClickListener {
        public b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            if (JumpUnknownSourceActivity.this.f39000c != null) {
                JumpUnknownSourceActivity jumpUnknownSourceActivity = JumpUnknownSourceActivity.this;
                d.o.a.e.a.c.p(jumpUnknownSourceActivity, jumpUnknownSourceActivity.f39000c, true);
            }
            d.o.a.e.a.c.B(JumpUnknownSourceActivity.this.f39001d, JumpUnknownSourceActivity.this.f39002e);
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
            if (d.o.a.e.a.c.n(jumpUnknownSourceActivity, jumpUnknownSourceActivity.f39000c, JumpUnknownSourceActivity.this.f39001d, JumpUnknownSourceActivity.this.f39002e)) {
                d.o.a.e.a.c.I(JumpUnknownSourceActivity.this.f39001d, JumpUnknownSourceActivity.this.f39002e);
            } else {
                JumpUnknownSourceActivity jumpUnknownSourceActivity2 = JumpUnknownSourceActivity.this;
                d.o.a.e.a.c.p(jumpUnknownSourceActivity2, jumpUnknownSourceActivity2.f39000c, true);
            }
            d.o.a.e.a.c.f(JumpUnknownSourceActivity.this.f39001d, JumpUnknownSourceActivity.this.f39002e);
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
        this.f38999b = intent;
        if (intent != null) {
            this.f39000c = (Intent) intent.getParcelableExtra("intent");
            this.f39001d = intent.getIntExtra("id", -1);
            try {
                this.f39002e = new JSONObject(intent.getStringExtra("config"));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        b();
        d.m mVar = this.f38998a;
        if (mVar != null && !mVar.b()) {
            this.f38998a.a();
        } else if (this.f38998a == null) {
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
        if (this.f38998a != null || this.f38999b == null) {
            return;
        }
        try {
            d.e b2 = e.F().b();
            d.n a2 = b2 != null ? b2.a(this) : null;
            if (a2 == null) {
                a2 = new e.C1876e(this);
            }
            int a3 = l.a(this, "tt_appdownloader_tip");
            int a4 = l.a(this, "tt_appdownloader_label_ok");
            int a5 = l.a(this, "tt_appdownloader_label_cancel");
            String optString = this.f39002e.optString("jump_unknown_source_tips");
            if (TextUtils.isEmpty(optString)) {
                optString = getString(l.a(this, "tt_appdownloader_jump_unknown_source_tips"));
            }
            a2.a(a3).a(optString).b(a4, new c()).a(a5, new b()).c(new a()).a(false);
            this.f38998a = a2.a();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
