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
    public d.m f36679a;

    /* renamed from: b  reason: collision with root package name */
    public Intent f36680b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public Intent f36681c;

    /* renamed from: d  reason: collision with root package name */
    public int f36682d;

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f36683e;

    /* loaded from: classes6.dex */
    public class a implements DialogInterface.OnCancelListener {
        public a() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (JumpUnknownSourceActivity.this.f36681c != null) {
                JumpUnknownSourceActivity jumpUnknownSourceActivity = JumpUnknownSourceActivity.this;
                d.o.a.e.a.c.p(jumpUnknownSourceActivity, jumpUnknownSourceActivity.f36681c, true);
            }
            d.o.a.e.a.c.B(JumpUnknownSourceActivity.this.f36682d, JumpUnknownSourceActivity.this.f36683e);
            JumpUnknownSourceActivity.this.finish();
        }
    }

    /* loaded from: classes6.dex */
    public class b implements DialogInterface.OnClickListener {
        public b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            if (JumpUnknownSourceActivity.this.f36681c != null) {
                JumpUnknownSourceActivity jumpUnknownSourceActivity = JumpUnknownSourceActivity.this;
                d.o.a.e.a.c.p(jumpUnknownSourceActivity, jumpUnknownSourceActivity.f36681c, true);
            }
            d.o.a.e.a.c.B(JumpUnknownSourceActivity.this.f36682d, JumpUnknownSourceActivity.this.f36683e);
            JumpUnknownSourceActivity.this.finish();
        }
    }

    /* loaded from: classes6.dex */
    public class c implements DialogInterface.OnClickListener {
        public c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            JumpUnknownSourceActivity jumpUnknownSourceActivity = JumpUnknownSourceActivity.this;
            if (d.o.a.e.a.c.n(jumpUnknownSourceActivity, jumpUnknownSourceActivity.f36681c, JumpUnknownSourceActivity.this.f36682d, JumpUnknownSourceActivity.this.f36683e)) {
                d.o.a.e.a.c.I(JumpUnknownSourceActivity.this.f36682d, JumpUnknownSourceActivity.this.f36683e);
            } else {
                JumpUnknownSourceActivity jumpUnknownSourceActivity2 = JumpUnknownSourceActivity.this;
                d.o.a.e.a.c.p(jumpUnknownSourceActivity2, jumpUnknownSourceActivity2.f36681c, true);
            }
            d.o.a.e.a.c.f(JumpUnknownSourceActivity.this.f36682d, JumpUnknownSourceActivity.this.f36683e);
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
        this.f36680b = intent;
        if (intent != null) {
            this.f36681c = (Intent) intent.getParcelableExtra("intent");
            this.f36682d = intent.getIntExtra("id", -1);
            try {
                this.f36683e = new JSONObject(intent.getStringExtra("config"));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        b();
        d.m mVar = this.f36679a;
        if (mVar != null && !mVar.b()) {
            this.f36679a.a();
        } else if (this.f36679a == null) {
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
        if (this.f36679a != null || this.f36680b == null) {
            return;
        }
        try {
            d.e b2 = e.F().b();
            d.n a2 = b2 != null ? b2.a(this) : null;
            if (a2 == null) {
                a2 = new e.C1815e(this);
            }
            int a3 = l.a(this, "tt_appdownloader_tip");
            int a4 = l.a(this, "tt_appdownloader_label_ok");
            int a5 = l.a(this, "tt_appdownloader_label_cancel");
            String optString = this.f36683e.optString("jump_unknown_source_tips");
            if (TextUtils.isEmpty(optString)) {
                optString = getString(l.a(this, "tt_appdownloader_jump_unknown_source_tips"));
            }
            a2.a(a3).a(optString).b(a4, new c()).a(a5, new b()).c(new a()).a(false);
            this.f36679a = a2.a();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
