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
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class d extends Dialog {
    public TextView a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f57981b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f57982c;

    /* renamed from: d  reason: collision with root package name */
    public c f57983d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f57984e;

    /* renamed from: f  reason: collision with root package name */
    public Activity f57985f;

    /* renamed from: g  reason: collision with root package name */
    public String f57986g;

    /* renamed from: h  reason: collision with root package name */
    public String f57987h;

    /* renamed from: i  reason: collision with root package name */
    public String f57988i;

    /* loaded from: classes8.dex */
    public static class a {
        public Activity a;

        /* renamed from: b  reason: collision with root package name */
        public String f57989b;

        /* renamed from: c  reason: collision with root package name */
        public String f57990c;

        /* renamed from: d  reason: collision with root package name */
        public String f57991d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f57992e;

        /* renamed from: f  reason: collision with root package name */
        public c f57993f;

        public a(Activity activity) {
            this.a = activity;
        }

        public a a(String str) {
            this.f57989b = str;
            return this;
        }

        public a b(String str) {
            this.f57990c = str;
            return this;
        }

        public a c(String str) {
            this.f57991d = str;
            return this;
        }

        public a a(boolean z) {
            this.f57992e = z;
            return this;
        }

        public a a(c cVar) {
            this.f57993f = cVar;
            return this;
        }

        public d a() {
            return new d(this.a, this.f57989b, this.f57990c, this.f57991d, this.f57992e, this.f57993f);
        }
    }

    public d(@NonNull Activity activity, String str, String str2, String str3, boolean z, @NonNull c cVar) {
        super(activity, R.style.ttdownloader_translucent_dialog);
        this.f57985f = activity;
        this.f57983d = cVar;
        this.f57986g = str;
        this.f57987h = str2;
        this.f57988i = str3;
        setCanceledOnTouchOutside(z);
        d();
    }

    private void d() {
        setContentView(LayoutInflater.from(this.f57985f.getApplicationContext()).inflate(a(), (ViewGroup) null));
        this.a = (TextView) findViewById(b());
        this.f57981b = (TextView) findViewById(c());
        this.f57982c = (TextView) findViewById(R.id.message_tv);
        if (!TextUtils.isEmpty(this.f57987h)) {
            this.a.setText(this.f57987h);
        }
        if (!TextUtils.isEmpty(this.f57988i)) {
            this.f57981b.setText(this.f57988i);
        }
        if (!TextUtils.isEmpty(this.f57986g)) {
            this.f57982c.setText(this.f57986g);
        }
        this.a.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.a.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.e();
            }
        });
        this.f57981b.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.a.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.f();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f57984e = true;
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        dismiss();
    }

    public int a() {
        return R.layout.ttdownloader_dialog_select_operation;
    }

    public int b() {
        return R.id.confirm_tv;
    }

    public int c() {
        return R.id.cancel_tv;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        if (!this.f57985f.isFinishing()) {
            this.f57985f.finish();
        }
        if (this.f57984e) {
            this.f57983d.a();
        } else {
            this.f57983d.b();
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchKeyEvent(@NonNull KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }
}
