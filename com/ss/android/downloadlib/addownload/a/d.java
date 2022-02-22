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
    public TextView f59631b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f59632c;

    /* renamed from: d  reason: collision with root package name */
    public c f59633d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f59634e;

    /* renamed from: f  reason: collision with root package name */
    public Activity f59635f;

    /* renamed from: g  reason: collision with root package name */
    public String f59636g;

    /* renamed from: h  reason: collision with root package name */
    public String f59637h;

    /* renamed from: i  reason: collision with root package name */
    public String f59638i;

    /* loaded from: classes4.dex */
    public static class a {
        public Activity a;

        /* renamed from: b  reason: collision with root package name */
        public String f59639b;

        /* renamed from: c  reason: collision with root package name */
        public String f59640c;

        /* renamed from: d  reason: collision with root package name */
        public String f59641d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f59642e;

        /* renamed from: f  reason: collision with root package name */
        public c f59643f;

        public a(Activity activity) {
            this.a = activity;
        }

        public a a(String str) {
            this.f59639b = str;
            return this;
        }

        public a b(String str) {
            this.f59640c = str;
            return this;
        }

        public a c(String str) {
            this.f59641d = str;
            return this;
        }

        public a a(boolean z) {
            this.f59642e = z;
            return this;
        }

        public a a(c cVar) {
            this.f59643f = cVar;
            return this;
        }

        public d a() {
            return new d(this.a, this.f59639b, this.f59640c, this.f59641d, this.f59642e, this.f59643f);
        }
    }

    public d(@NonNull Activity activity, String str, String str2, String str3, boolean z, @NonNull c cVar) {
        super(activity, R.style.ttdownloader_translucent_dialog);
        this.f59635f = activity;
        this.f59633d = cVar;
        this.f59636g = str;
        this.f59637h = str2;
        this.f59638i = str3;
        setCanceledOnTouchOutside(z);
        d();
    }

    private void d() {
        setContentView(LayoutInflater.from(this.f59635f.getApplicationContext()).inflate(a(), (ViewGroup) null));
        this.a = (TextView) findViewById(b());
        this.f59631b = (TextView) findViewById(c());
        this.f59632c = (TextView) findViewById(R.id.message_tv);
        if (!TextUtils.isEmpty(this.f59637h)) {
            this.a.setText(this.f59637h);
        }
        if (!TextUtils.isEmpty(this.f59638i)) {
            this.f59631b.setText(this.f59638i);
        }
        if (!TextUtils.isEmpty(this.f59636g)) {
            this.f59632c.setText(this.f59636g);
        }
        this.a.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.a.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.e();
            }
        });
        this.f59631b.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.a.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.f();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f59634e = true;
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
        if (!this.f59635f.isFinishing()) {
            this.f59635f.finish();
        }
        if (this.f59634e) {
            this.f59633d.a();
        } else {
            this.f59633d.b();
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
