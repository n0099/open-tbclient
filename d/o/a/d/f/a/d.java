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
    public TextView f70599e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f70600f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f70601g;

    /* renamed from: h  reason: collision with root package name */
    public d.o.a.d.f.a.c f70602h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f70603i;
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
        public Activity f70606a;

        /* renamed from: b  reason: collision with root package name */
        public String f70607b;

        /* renamed from: c  reason: collision with root package name */
        public String f70608c;

        /* renamed from: d  reason: collision with root package name */
        public String f70609d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f70610e;

        /* renamed from: f  reason: collision with root package name */
        public d.o.a.d.f.a.c f70611f;

        public c(Activity activity) {
            this.f70606a = activity;
        }

        public c a(d.o.a.d.f.a.c cVar) {
            this.f70611f = cVar;
            return this;
        }

        public c b(String str) {
            this.f70607b = str;
            return this;
        }

        public c c(boolean z) {
            this.f70610e = z;
            return this;
        }

        public d d() {
            return new d(this.f70606a, this.f70607b, this.f70608c, this.f70609d, this.f70610e, this.f70611f);
        }

        public c e(String str) {
            this.f70608c = str;
            return this;
        }

        public c f(String str) {
            this.f70609d = str;
            return this;
        }
    }

    public d(@NonNull Activity activity, String str, String str2, String str3, boolean z, @NonNull d.o.a.d.f.a.c cVar) {
        super(activity, d.o.a.d.d.ttdownloader_translucent_dialog);
        this.j = activity;
        this.f70602h = cVar;
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
        if (this.f70603i) {
            this.f70602h.a();
        } else {
            this.f70602h.b();
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
        this.f70599e = (TextView) findViewById(c());
        this.f70600f = (TextView) findViewById(e());
        this.f70601g = (TextView) findViewById(d.o.a.d.b.message_tv);
        if (!TextUtils.isEmpty(this.l)) {
            this.f70599e.setText(this.l);
        }
        if (!TextUtils.isEmpty(this.m)) {
            this.f70600f.setText(this.m);
        }
        if (!TextUtils.isEmpty(this.k)) {
            this.f70601g.setText(this.k);
        }
        this.f70599e.setOnClickListener(new a());
        this.f70600f.setOnClickListener(new b());
    }

    public final void g() {
        this.f70603i = true;
        dismiss();
    }

    public final void h() {
        dismiss();
    }
}
