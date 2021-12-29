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
/* loaded from: classes3.dex */
public class d extends Dialog {
    public TextView a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f61759b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f61760c;

    /* renamed from: d  reason: collision with root package name */
    public c f61761d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f61762e;

    /* renamed from: f  reason: collision with root package name */
    public Activity f61763f;

    /* renamed from: g  reason: collision with root package name */
    public String f61764g;

    /* renamed from: h  reason: collision with root package name */
    public String f61765h;

    /* renamed from: i  reason: collision with root package name */
    public String f61766i;

    /* loaded from: classes3.dex */
    public static class a {
        public Activity a;

        /* renamed from: b  reason: collision with root package name */
        public String f61767b;

        /* renamed from: c  reason: collision with root package name */
        public String f61768c;

        /* renamed from: d  reason: collision with root package name */
        public String f61769d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f61770e;

        /* renamed from: f  reason: collision with root package name */
        public c f61771f;

        public a(Activity activity) {
            this.a = activity;
        }

        public a a(String str) {
            this.f61767b = str;
            return this;
        }

        public a b(String str) {
            this.f61768c = str;
            return this;
        }

        public a c(String str) {
            this.f61769d = str;
            return this;
        }

        public a a(boolean z) {
            this.f61770e = z;
            return this;
        }

        public a a(c cVar) {
            this.f61771f = cVar;
            return this;
        }

        public d a() {
            return new d(this.a, this.f61767b, this.f61768c, this.f61769d, this.f61770e, this.f61771f);
        }
    }

    public d(@NonNull Activity activity, String str, String str2, String str3, boolean z, @NonNull c cVar) {
        super(activity, R.style.ttdownloader_translucent_dialog);
        this.f61763f = activity;
        this.f61761d = cVar;
        this.f61764g = str;
        this.f61765h = str2;
        this.f61766i = str3;
        setCanceledOnTouchOutside(z);
        d();
    }

    private void d() {
        setContentView(LayoutInflater.from(this.f61763f.getApplicationContext()).inflate(a(), (ViewGroup) null));
        this.a = (TextView) findViewById(b());
        this.f61759b = (TextView) findViewById(c());
        this.f61760c = (TextView) findViewById(R.id.message_tv);
        if (!TextUtils.isEmpty(this.f61765h)) {
            this.a.setText(this.f61765h);
        }
        if (!TextUtils.isEmpty(this.f61766i)) {
            this.f61759b.setText(this.f61766i);
        }
        if (!TextUtils.isEmpty(this.f61764g)) {
            this.f61760c.setText(this.f61764g);
        }
        this.a.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.a.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.e();
            }
        });
        this.f61759b.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.a.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.f();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f61762e = true;
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
        if (!this.f61763f.isFinishing()) {
            this.f61763f.finish();
        }
        if (this.f61762e) {
            this.f61761d.a();
        } else {
            this.f61761d.b();
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
