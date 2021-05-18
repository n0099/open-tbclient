package d.a.i0.a.z1.b.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
/* loaded from: classes3.dex */
public class i extends c {

    /* renamed from: f  reason: collision with root package name */
    public a f45940f;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final b f45941a;

        /* renamed from: b  reason: collision with root package name */
        public final i f45942b;

        /* renamed from: c  reason: collision with root package name */
        public Context f45943c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f45944d = false;

        /* renamed from: d.a.i0.a.z1.b.b.i$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class View$OnClickListenerC0923a implements View.OnClickListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DialogInterface.OnClickListener f45945e;

            public View$OnClickListenerC0923a(DialogInterface.OnClickListener onClickListener) {
                this.f45945e = onClickListener;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.f45942b.dismiss();
                DialogInterface.OnClickListener onClickListener = this.f45945e;
                if (onClickListener != null) {
                    onClickListener.onClick(a.this.f45942b, -1);
                }
            }
        }

        /* loaded from: classes3.dex */
        public class b implements View.OnClickListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DialogInterface.OnClickListener f45947e;

            public b(DialogInterface.OnClickListener onClickListener) {
                this.f45947e = onClickListener;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.f45942b.dismiss();
                DialogInterface.OnClickListener onClickListener = this.f45947e;
                if (onClickListener != null) {
                    onClickListener.onClick(a.this.f45942b, -2);
                }
            }
        }

        public a(Context context) {
            i b2 = b(context);
            this.f45942b = b2;
            b2.d(this);
            this.f45941a = new b((ViewGroup) this.f45942b.getWindow().getDecorView());
            this.f45943c = context;
        }

        public i a() {
            this.f45942b.setOnCancelListener(this.f45941a.f45954f);
            this.f45942b.setOnDismissListener(this.f45941a.f45955g);
            this.f45942b.setOnShowListener(this.f45941a.f45956h);
            this.f45942b.d(this);
            return this.f45942b;
        }

        public abstract i b(Context context);

        public a c(boolean z) {
            this.f45942b.setCanceledOnTouchOutside(z);
            return this;
        }

        public a d(int i2, DialogInterface.OnClickListener onClickListener) {
            e(this.f45943c.getText(i2), onClickListener);
            return this;
        }

        public a e(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            this.f45941a.f45950b.setText(charSequence);
            this.f45941a.f45950b.setOnClickListener(new b(onClickListener));
            return this;
        }

        public a f(DialogInterface.OnCancelListener onCancelListener) {
            this.f45941a.f45954f = onCancelListener;
            return this;
        }

        public a g(String str) {
            this.f45941a.f45951c.setText(str);
            return this;
        }

        public a h(int i2, DialogInterface.OnClickListener onClickListener) {
            i(this.f45943c.getText(i2), onClickListener);
            return this;
        }

        public a i(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            this.f45941a.f45949a.setText(charSequence);
            this.f45941a.f45949a.setOnClickListener(new View$OnClickListenerC0923a(onClickListener));
            return this;
        }

        public a j(View view) {
            this.f45941a.f45953e.removeAllViews();
            this.f45941a.f45953e.addView(view);
            return this;
        }

        public i k() {
            i a2 = a();
            if (this.f45944d) {
                a2.getWindow().setType(2003);
            }
            try {
                a2.show();
            } catch (WindowManager.BadTokenException unused) {
            }
            return a2;
        }
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public TextView f45949a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f45950b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f45951c;

        /* renamed from: d  reason: collision with root package name */
        public View f45952d;

        /* renamed from: e  reason: collision with root package name */
        public FrameLayout f45953e;

        /* renamed from: f  reason: collision with root package name */
        public DialogInterface.OnCancelListener f45954f;

        /* renamed from: g  reason: collision with root package name */
        public DialogInterface.OnDismissListener f45955g;

        /* renamed from: h  reason: collision with root package name */
        public DialogInterface.OnShowListener f45956h;

        /* renamed from: i  reason: collision with root package name */
        public FrameLayout f45957i;
        public FrameLayout j;
        public View k;
        public ViewGroup l;
        public RelativeLayout m;
        public LinearLayout n;
        public View o;

        @SuppressLint({"CutPasteId"})
        public b(ViewGroup viewGroup) {
            this.l = viewGroup;
            this.j = (FrameLayout) viewGroup.findViewById(d.a.i0.a.f.dialog_root);
            this.f45951c = (TextView) viewGroup.findViewById(d.a.i0.a.f.title_picker);
            this.f45949a = (TextView) viewGroup.findViewById(d.a.i0.a.f.positive_button);
            this.f45950b = (TextView) viewGroup.findViewById(d.a.i0.a.f.negative_button);
            this.f45952d = viewGroup.findViewById(d.a.i0.a.f.dialog_customPanel);
            this.f45953e = (FrameLayout) viewGroup.findViewById(d.a.i0.a.f.dialog_custom_content);
            this.m = (RelativeLayout) viewGroup.findViewById(d.a.i0.a.f.searchbox_alert_dialog);
            this.n = (LinearLayout) viewGroup.findViewById(d.a.i0.a.f.btn_panel);
            this.o = viewGroup.findViewById(d.a.i0.a.f.dialog_customPanel);
            this.f45957i = (FrameLayout) viewGroup.findViewById(d.a.i0.a.f.dialog_root);
            this.k = viewGroup.findViewById(d.a.i0.a.f.nightmode_mask);
        }
    }

    public i(Context context, int i2) {
        super(context, i2);
        c();
    }

    public a b() {
        return this.f45940f;
    }

    public void c() {
        setContentView(d.a.i0.a.g.swanapp_picker_dialog);
        getWindow().setLayout(-1, -2);
        getWindow().setGravity(80);
        a(false);
    }

    public void d(a aVar) {
        this.f45940f = aVar;
    }
}
