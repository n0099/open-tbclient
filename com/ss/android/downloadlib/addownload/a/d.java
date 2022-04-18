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
    public TextView b;
    public TextView c;
    public c d;
    public boolean e;
    public Activity f;
    public String g;
    public String h;
    public String i;

    /* loaded from: classes7.dex */
    public static class a {
        public Activity a;
        public String b;
        public String c;
        public String d;
        public boolean e;
        public c f;

        public a(Activity activity) {
            this.a = activity;
        }

        public a a(String str) {
            this.b = str;
            return this;
        }

        public a b(String str) {
            this.c = str;
            return this;
        }

        public a c(String str) {
            this.d = str;
            return this;
        }

        public a a(boolean z) {
            this.e = z;
            return this;
        }

        public a a(c cVar) {
            this.f = cVar;
            return this;
        }

        public d a() {
            return new d(this.a, this.b, this.c, this.d, this.e, this.f);
        }
    }

    public d(@NonNull Activity activity, String str, String str2, String str3, boolean z, @NonNull c cVar) {
        super(activity, R.style.obfuscated_res_0x7f100417);
        this.f = activity;
        this.d = cVar;
        this.g = str;
        this.h = str2;
        this.i = str3;
        setCanceledOnTouchOutside(z);
        d();
    }

    private void d() {
        setContentView(LayoutInflater.from(this.f.getApplicationContext()).inflate(a(), (ViewGroup) null));
        this.a = (TextView) findViewById(b());
        this.b = (TextView) findViewById(c());
        this.c = (TextView) findViewById(R.id.obfuscated_res_0x7f091407);
        if (!TextUtils.isEmpty(this.h)) {
            this.a.setText(this.h);
        }
        if (!TextUtils.isEmpty(this.i)) {
            this.b.setText(this.i);
        }
        if (!TextUtils.isEmpty(this.g)) {
            this.c.setText(this.g);
        }
        this.a.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.a.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                d.this.e();
            }
        });
        this.b.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.a.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                d.this.f();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.e = true;
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        dismiss();
    }

    public int a() {
        return R.layout.obfuscated_res_0x7f0d084b;
    }

    public int b() {
        return R.id.obfuscated_res_0x7f0906cb;
    }

    public int c() {
        return R.id.obfuscated_res_0x7f0904a0;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        if (!this.f.isFinishing()) {
            this.f.finish();
        }
        if (this.e) {
            this.d.a();
        } else {
            this.d.b();
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
