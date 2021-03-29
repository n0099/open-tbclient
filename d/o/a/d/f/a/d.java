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
    public TextView f66495e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f66496f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f66497g;

    /* renamed from: h  reason: collision with root package name */
    public d.o.a.d.f.a.c f66498h;
    public boolean i;
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
        public Activity f66501a;

        /* renamed from: b  reason: collision with root package name */
        public String f66502b;

        /* renamed from: c  reason: collision with root package name */
        public String f66503c;

        /* renamed from: d  reason: collision with root package name */
        public String f66504d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f66505e;

        /* renamed from: f  reason: collision with root package name */
        public d.o.a.d.f.a.c f66506f;

        public c(Activity activity) {
            this.f66501a = activity;
        }

        public c a(d.o.a.d.f.a.c cVar) {
            this.f66506f = cVar;
            return this;
        }

        public c b(String str) {
            this.f66502b = str;
            return this;
        }

        public c c(boolean z) {
            this.f66505e = z;
            return this;
        }

        public d d() {
            return new d(this.f66501a, this.f66502b, this.f66503c, this.f66504d, this.f66505e, this.f66506f);
        }

        public c e(String str) {
            this.f66503c = str;
            return this;
        }

        public c f(String str) {
            this.f66504d = str;
            return this;
        }
    }

    public d(@NonNull Activity activity, String str, String str2, String str3, boolean z, @NonNull d.o.a.d.f.a.c cVar) {
        super(activity, d.o.a.d.d.ttdownloader_translucent_dialog);
        this.j = activity;
        this.f66498h = cVar;
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
        if (this.i) {
            this.f66498h.a();
        } else {
            this.f66498h.b();
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
        this.f66495e = (TextView) findViewById(c());
        this.f66496f = (TextView) findViewById(e());
        this.f66497g = (TextView) findViewById(d.o.a.d.b.message_tv);
        if (!TextUtils.isEmpty(this.l)) {
            this.f66495e.setText(this.l);
        }
        if (!TextUtils.isEmpty(this.m)) {
            this.f66496f.setText(this.m);
        }
        if (!TextUtils.isEmpty(this.k)) {
            this.f66497g.setText(this.k);
        }
        this.f66495e.setOnClickListener(new a());
        this.f66496f.setOnClickListener(new b());
    }

    public final void g() {
        this.i = true;
        dismiss();
    }

    public final void h() {
        dismiss();
    }
}
