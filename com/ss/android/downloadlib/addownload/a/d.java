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
/* loaded from: classes7.dex */
public class d extends Dialog {
    public TextView a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f42732b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f42733c;

    /* renamed from: d  reason: collision with root package name */
    public c f42734d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f42735e;

    /* renamed from: f  reason: collision with root package name */
    public Activity f42736f;

    /* renamed from: g  reason: collision with root package name */
    public String f42737g;

    /* renamed from: h  reason: collision with root package name */
    public String f42738h;
    public String i;

    /* loaded from: classes7.dex */
    public static class a {
        public Activity a;

        /* renamed from: b  reason: collision with root package name */
        public String f42739b;

        /* renamed from: c  reason: collision with root package name */
        public String f42740c;

        /* renamed from: d  reason: collision with root package name */
        public String f42741d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f42742e;

        /* renamed from: f  reason: collision with root package name */
        public c f42743f;

        public a(Activity activity) {
            this.a = activity;
        }

        public a a(String str) {
            this.f42739b = str;
            return this;
        }

        public a b(String str) {
            this.f42740c = str;
            return this;
        }

        public a c(String str) {
            this.f42741d = str;
            return this;
        }

        public a a(boolean z) {
            this.f42742e = z;
            return this;
        }

        public a a(c cVar) {
            this.f42743f = cVar;
            return this;
        }

        public d a() {
            return new d(this.a, this.f42739b, this.f42740c, this.f42741d, this.f42742e, this.f42743f);
        }
    }

    public d(@NonNull Activity activity, String str, String str2, String str3, boolean z, @NonNull c cVar) {
        super(activity, R.style.obfuscated_res_0x7f100415);
        this.f42736f = activity;
        this.f42734d = cVar;
        this.f42737g = str;
        this.f42738h = str2;
        this.i = str3;
        setCanceledOnTouchOutside(z);
        d();
    }

    private void d() {
        setContentView(LayoutInflater.from(this.f42736f.getApplicationContext()).inflate(a(), (ViewGroup) null));
        this.a = (TextView) findViewById(b());
        this.f42732b = (TextView) findViewById(c());
        this.f42733c = (TextView) findViewById(R.id.obfuscated_res_0x7f09140d);
        if (!TextUtils.isEmpty(this.f42738h)) {
            this.a.setText(this.f42738h);
        }
        if (!TextUtils.isEmpty(this.i)) {
            this.f42732b.setText(this.i);
        }
        if (!TextUtils.isEmpty(this.f42737g)) {
            this.f42733c.setText(this.f42737g);
        }
        this.a.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.a.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.e();
            }
        });
        this.f42732b.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.a.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.f();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f42735e = true;
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        dismiss();
    }

    public int a() {
        return R.layout.obfuscated_res_0x7f0d0854;
    }

    public int b() {
        return R.id.obfuscated_res_0x7f0906c2;
    }

    public int c() {
        return R.id.obfuscated_res_0x7f090498;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        if (!this.f42736f.isFinishing()) {
            this.f42736f.finish();
        }
        if (this.f42735e) {
            this.f42734d.a();
        } else {
            this.f42734d.b();
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
