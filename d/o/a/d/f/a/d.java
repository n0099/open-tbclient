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
/* loaded from: classes6.dex */
public class d extends Dialog {

    /* renamed from: e  reason: collision with root package name */
    public TextView f65980e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f65981f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f65982g;

    /* renamed from: h  reason: collision with root package name */
    public d.o.a.d.f.a.c f65983h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f65984i;
    public Activity j;
    public String k;
    public String l;
    public String m;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.g();
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.h();
        }
    }

    /* loaded from: classes6.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public Activity f65987a;

        /* renamed from: b  reason: collision with root package name */
        public String f65988b;

        /* renamed from: c  reason: collision with root package name */
        public String f65989c;

        /* renamed from: d  reason: collision with root package name */
        public String f65990d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f65991e;

        /* renamed from: f  reason: collision with root package name */
        public d.o.a.d.f.a.c f65992f;

        public c(Activity activity) {
            this.f65987a = activity;
        }

        public c a(d.o.a.d.f.a.c cVar) {
            this.f65992f = cVar;
            return this;
        }

        public c b(String str) {
            this.f65988b = str;
            return this;
        }

        public c c(boolean z) {
            this.f65991e = z;
            return this;
        }

        public d d() {
            return new d(this.f65987a, this.f65988b, this.f65989c, this.f65990d, this.f65991e, this.f65992f);
        }

        public c e(String str) {
            this.f65989c = str;
            return this;
        }

        public c f(String str) {
            this.f65990d = str;
            return this;
        }
    }

    public d(@NonNull Activity activity, String str, String str2, String str3, boolean z, @NonNull d.o.a.d.f.a.c cVar) {
        super(activity, d.o.a.d.d.ttdownloader_translucent_dialog);
        this.j = activity;
        this.f65983h = cVar;
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
        if (this.f65984i) {
            this.f65983h.a();
        } else {
            this.f65983h.b();
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
        this.f65980e = (TextView) findViewById(c());
        this.f65981f = (TextView) findViewById(e());
        this.f65982g = (TextView) findViewById(d.o.a.d.b.message_tv);
        if (!TextUtils.isEmpty(this.l)) {
            this.f65980e.setText(this.l);
        }
        if (!TextUtils.isEmpty(this.m)) {
            this.f65981f.setText(this.m);
        }
        if (!TextUtils.isEmpty(this.k)) {
            this.f65982g.setText(this.k);
        }
        this.f65980e.setOnClickListener(new a());
        this.f65981f.setOnClickListener(new b());
    }

    public final void g() {
        this.f65984i = true;
        dismiss();
    }

    public final void h() {
        dismiss();
    }
}
