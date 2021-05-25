package d.o.a.d.f.a;

import android.app.Activity;
import android.app.Dialog;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
/* loaded from: classes7.dex */
public class d extends Dialog {

    /* renamed from: e  reason: collision with root package name */
    public TextView f66709e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f66710f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f66711g;

    /* renamed from: h  reason: collision with root package name */
    public d.o.a.d.f.a.c f66712h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f66713i;
    public Activity j;
    public String k;
    public String l;
    public String m;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.g();
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.h();
        }
    }

    /* loaded from: classes7.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public Activity f66716a;

        /* renamed from: b  reason: collision with root package name */
        public String f66717b;

        /* renamed from: c  reason: collision with root package name */
        public String f66718c;

        /* renamed from: d  reason: collision with root package name */
        public String f66719d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f66720e;

        /* renamed from: f  reason: collision with root package name */
        public d.o.a.d.f.a.c f66721f;

        public c(Activity activity) {
            this.f66716a = activity;
        }

        public c a(d.o.a.d.f.a.c cVar) {
            this.f66721f = cVar;
            return this;
        }

        public c b(String str) {
            this.f66717b = str;
            return this;
        }

        public c c(boolean z) {
            this.f66720e = z;
            return this;
        }

        public d d() {
            return new d(this.f66716a, this.f66717b, this.f66718c, this.f66719d, this.f66720e, this.f66721f);
        }

        public c e(String str) {
            this.f66718c = str;
            return this;
        }

        public c f(String str) {
            this.f66719d = str;
            return this;
        }
    }

    public d(@NonNull Activity activity, String str, String str2, String str3, boolean z, @NonNull d.o.a.d.f.a.c cVar) {
        super(activity, d.o.a.d.d.ttdownloader_translucent_dialog);
        this.j = activity;
        this.f66712h = cVar;
        this.k = str;
        this.l = str2;
        this.m = str3;
        setCanceledOnTouchOutside(z);
        f();
    }

    public int a() {
        return d.o.a.d.c.ttdownloader_dialog_select_operation;
    }

    public int c() {
        return d.o.a.d.b.confirm_tv;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        if (!this.j.isFinishing()) {
            this.j.finish();
        }
        if (this.f66713i) {
            this.f66712h.a();
        } else {
            this.f66712h.b();
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchKeyEvent(@NonNull KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public int e() {
        return d.o.a.d.b.cancel_tv;
    }

    public final void f() {
        setContentView(LayoutInflater.from(this.j.getApplicationContext()).inflate(a(), (ViewGroup) null));
        this.f66709e = (TextView) findViewById(c());
        this.f66710f = (TextView) findViewById(e());
        this.f66711g = (TextView) findViewById(d.o.a.d.b.message_tv);
        if (!TextUtils.isEmpty(this.l)) {
            this.f66709e.setText(this.l);
        }
        if (!TextUtils.isEmpty(this.m)) {
            this.f66710f.setText(this.m);
        }
        if (!TextUtils.isEmpty(this.k)) {
            this.f66711g.setText(this.k);
        }
        this.f66709e.setOnClickListener(new a());
        this.f66710f.setOnClickListener(new b());
    }

    public final void g() {
        this.f66713i = true;
        dismiss();
    }

    public final void h() {
        dismiss();
    }
}
