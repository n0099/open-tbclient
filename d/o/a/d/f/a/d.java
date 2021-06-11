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
    public TextView f70495e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f70496f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f70497g;

    /* renamed from: h  reason: collision with root package name */
    public d.o.a.d.f.a.c f70498h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f70499i;
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
        public Activity f70502a;

        /* renamed from: b  reason: collision with root package name */
        public String f70503b;

        /* renamed from: c  reason: collision with root package name */
        public String f70504c;

        /* renamed from: d  reason: collision with root package name */
        public String f70505d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f70506e;

        /* renamed from: f  reason: collision with root package name */
        public d.o.a.d.f.a.c f70507f;

        public c(Activity activity) {
            this.f70502a = activity;
        }

        public c a(d.o.a.d.f.a.c cVar) {
            this.f70507f = cVar;
            return this;
        }

        public c b(String str) {
            this.f70503b = str;
            return this;
        }

        public c c(boolean z) {
            this.f70506e = z;
            return this;
        }

        public d d() {
            return new d(this.f70502a, this.f70503b, this.f70504c, this.f70505d, this.f70506e, this.f70507f);
        }

        public c e(String str) {
            this.f70504c = str;
            return this;
        }

        public c f(String str) {
            this.f70505d = str;
            return this;
        }
    }

    public d(@NonNull Activity activity, String str, String str2, String str3, boolean z, @NonNull d.o.a.d.f.a.c cVar) {
        super(activity, d.o.a.d.d.ttdownloader_translucent_dialog);
        this.j = activity;
        this.f70498h = cVar;
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
        if (this.f70499i) {
            this.f70498h.a();
        } else {
            this.f70498h.b();
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
        this.f70495e = (TextView) findViewById(c());
        this.f70496f = (TextView) findViewById(e());
        this.f70497g = (TextView) findViewById(d.o.a.d.b.message_tv);
        if (!TextUtils.isEmpty(this.l)) {
            this.f70495e.setText(this.l);
        }
        if (!TextUtils.isEmpty(this.m)) {
            this.f70496f.setText(this.m);
        }
        if (!TextUtils.isEmpty(this.k)) {
            this.f70497g.setText(this.k);
        }
        this.f70495e.setOnClickListener(new a());
        this.f70496f.setOnClickListener(new b());
    }

    public final void g() {
        this.f70499i = true;
        dismiss();
    }

    public final void h() {
        dismiss();
    }
}
