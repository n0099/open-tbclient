package com.ss.android.downloadlib.addownload.a;

import android.app.Activity;
import android.app.Dialog;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.R;
/* loaded from: classes4.dex */
public class d extends Dialog {
    public TextView a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f59464b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f59465c;

    /* renamed from: d  reason: collision with root package name */
    public c f59466d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f59467e;

    /* renamed from: f  reason: collision with root package name */
    public Activity f59468f;

    /* renamed from: g  reason: collision with root package name */
    public String f59469g;

    /* renamed from: h  reason: collision with root package name */
    public String f59470h;

    /* renamed from: i  reason: collision with root package name */
    public String f59471i;

    /* loaded from: classes4.dex */
    public static class a {
        public Activity a;

        /* renamed from: b  reason: collision with root package name */
        public String f59472b;

        /* renamed from: c  reason: collision with root package name */
        public String f59473c;

        /* renamed from: d  reason: collision with root package name */
        public String f59474d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f59475e;

        /* renamed from: f  reason: collision with root package name */
        public c f59476f;

        public a(Activity activity) {
            this.a = activity;
        }

        public a a(String str) {
            this.f59472b = str;
            return this;
        }

        public a b(String str) {
            this.f59473c = str;
            return this;
        }

        public a c(String str) {
            this.f59474d = str;
            return this;
        }

        public a a(boolean z) {
            this.f59475e = z;
            return this;
        }

        public a a(c cVar) {
            this.f59476f = cVar;
            return this;
        }

        public d a() {
            return new d(this.a, this.f59472b, this.f59473c, this.f59474d, this.f59475e, this.f59476f);
        }
    }

    public d(@NonNull Activity activity, String str, String str2, String str3, boolean z, @NonNull c cVar) {
        super(activity, R.style.ttdownloader_translucent_dialog);
        this.f59468f = activity;
        this.f59466d = cVar;
        this.f59469g = str;
        this.f59470h = str2;
        this.f59471i = str3;
        setCanceledOnTouchOutside(z);
        d();
    }

    private void d() {
        setContentView(LayoutInflater.from(this.f59468f.getApplicationContext()).inflate(a(), (ViewGroup) null));
        this.a = (TextView) findViewById(b());
        this.f59464b = (TextView) findViewById(c());
        this.f59465c = (TextView) findViewById(R.id.message_tv);
        if (!TextUtils.isEmpty(this.f59470h)) {
            this.a.setText(this.f59470h);
        }
        if (!TextUtils.isEmpty(this.f59471i)) {
            this.f59464b.setText(this.f59471i);
        }
        if (!TextUtils.isEmpty(this.f59469g)) {
            this.f59465c.setText(this.f59469g);
        }
        this.a.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.a.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.e();
            }
        });
        this.f59464b.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.a.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.f();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f59467e = true;
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        dismiss();
    }

    public int c() {
        return R.id.cancel_tv;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        if (!this.f59468f.isFinishing()) {
            this.f59468f.finish();
        }
        if (this.f59467e) {
            this.f59466d.a();
        } else {
            this.f59466d.b();
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchKeyEvent(@NonNull KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public int a() {
        return R.layout.ttdownloader_dialog_select_operation;
    }

    public int b() {
        return R.id.confirm_tv;
    }
}
