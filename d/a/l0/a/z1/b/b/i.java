package d.a.l0.a.z1.b.b;

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
    public a f46116f;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final b f46117a;

        /* renamed from: b  reason: collision with root package name */
        public final i f46118b;

        /* renamed from: c  reason: collision with root package name */
        public Context f46119c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f46120d = false;

        /* renamed from: d.a.l0.a.z1.b.b.i$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class View$OnClickListenerC0934a implements View.OnClickListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DialogInterface.OnClickListener f46121e;

            public View$OnClickListenerC0934a(DialogInterface.OnClickListener onClickListener) {
                this.f46121e = onClickListener;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.f46118b.dismiss();
                DialogInterface.OnClickListener onClickListener = this.f46121e;
                if (onClickListener != null) {
                    onClickListener.onClick(a.this.f46118b, -1);
                }
            }
        }

        /* loaded from: classes3.dex */
        public class b implements View.OnClickListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DialogInterface.OnClickListener f46123e;

            public b(DialogInterface.OnClickListener onClickListener) {
                this.f46123e = onClickListener;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.f46118b.dismiss();
                DialogInterface.OnClickListener onClickListener = this.f46123e;
                if (onClickListener != null) {
                    onClickListener.onClick(a.this.f46118b, -2);
                }
            }
        }

        public a(Context context) {
            i b2 = b(context);
            this.f46118b = b2;
            b2.d(this);
            this.f46117a = new b((ViewGroup) this.f46118b.getWindow().getDecorView());
            this.f46119c = context;
        }

        public i a() {
            this.f46118b.setOnCancelListener(this.f46117a.f46130f);
            this.f46118b.setOnDismissListener(this.f46117a.f46131g);
            this.f46118b.setOnShowListener(this.f46117a.f46132h);
            this.f46118b.d(this);
            return this.f46118b;
        }

        public abstract i b(Context context);

        public a c(boolean z) {
            this.f46118b.setCanceledOnTouchOutside(z);
            return this;
        }

        public a d(int i2, DialogInterface.OnClickListener onClickListener) {
            e(this.f46119c.getText(i2), onClickListener);
            return this;
        }

        public a e(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            this.f46117a.f46126b.setText(charSequence);
            this.f46117a.f46126b.setOnClickListener(new b(onClickListener));
            return this;
        }

        public a f(DialogInterface.OnCancelListener onCancelListener) {
            this.f46117a.f46130f = onCancelListener;
            return this;
        }

        public a g(String str) {
            this.f46117a.f46127c.setText(str);
            return this;
        }

        public a h(int i2, DialogInterface.OnClickListener onClickListener) {
            i(this.f46119c.getText(i2), onClickListener);
            return this;
        }

        public a i(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            this.f46117a.f46125a.setText(charSequence);
            this.f46117a.f46125a.setOnClickListener(new View$OnClickListenerC0934a(onClickListener));
            return this;
        }

        public a j(View view) {
            this.f46117a.f46129e.removeAllViews();
            this.f46117a.f46129e.addView(view);
            return this;
        }

        public i k() {
            i a2 = a();
            if (this.f46120d) {
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
        public TextView f46125a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f46126b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f46127c;

        /* renamed from: d  reason: collision with root package name */
        public View f46128d;

        /* renamed from: e  reason: collision with root package name */
        public FrameLayout f46129e;

        /* renamed from: f  reason: collision with root package name */
        public DialogInterface.OnCancelListener f46130f;

        /* renamed from: g  reason: collision with root package name */
        public DialogInterface.OnDismissListener f46131g;

        /* renamed from: h  reason: collision with root package name */
        public DialogInterface.OnShowListener f46132h;

        /* renamed from: i  reason: collision with root package name */
        public FrameLayout f46133i;
        public FrameLayout j;
        public View k;
        public ViewGroup l;
        public RelativeLayout m;
        public LinearLayout n;
        public View o;

        @SuppressLint({"CutPasteId"})
        public b(ViewGroup viewGroup) {
            this.l = viewGroup;
            this.j = (FrameLayout) viewGroup.findViewById(d.a.l0.a.f.dialog_root);
            this.f46127c = (TextView) viewGroup.findViewById(d.a.l0.a.f.title_picker);
            this.f46125a = (TextView) viewGroup.findViewById(d.a.l0.a.f.positive_button);
            this.f46126b = (TextView) viewGroup.findViewById(d.a.l0.a.f.negative_button);
            this.f46128d = viewGroup.findViewById(d.a.l0.a.f.dialog_customPanel);
            this.f46129e = (FrameLayout) viewGroup.findViewById(d.a.l0.a.f.dialog_custom_content);
            this.m = (RelativeLayout) viewGroup.findViewById(d.a.l0.a.f.searchbox_alert_dialog);
            this.n = (LinearLayout) viewGroup.findViewById(d.a.l0.a.f.btn_panel);
            this.o = viewGroup.findViewById(d.a.l0.a.f.dialog_customPanel);
            this.f46133i = (FrameLayout) viewGroup.findViewById(d.a.l0.a.f.dialog_root);
            this.k = viewGroup.findViewById(d.a.l0.a.f.nightmode_mask);
        }
    }

    public i(Context context, int i2) {
        super(context, i2);
        c();
    }

    public a b() {
        return this.f46116f;
    }

    public void c() {
        setContentView(d.a.l0.a.g.swanapp_picker_dialog);
        getWindow().setLayout(-1, -2);
        getWindow().setGravity(80);
        a(false);
    }

    public void d(a aVar) {
        this.f46116f = aVar;
    }
}
