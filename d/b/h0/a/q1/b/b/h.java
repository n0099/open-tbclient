package d.b.h0.a.q1.b.b;

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
public class h extends c {

    /* renamed from: f  reason: collision with root package name */
    public a f46319f;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final b f46320a;

        /* renamed from: b  reason: collision with root package name */
        public final h f46321b;

        /* renamed from: c  reason: collision with root package name */
        public Context f46322c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f46323d = false;

        /* renamed from: d.b.h0.a.q1.b.b.h$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class View$OnClickListenerC0796a implements View.OnClickListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DialogInterface.OnClickListener f46324e;

            public View$OnClickListenerC0796a(DialogInterface.OnClickListener onClickListener) {
                this.f46324e = onClickListener;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.f46321b.dismiss();
                DialogInterface.OnClickListener onClickListener = this.f46324e;
                if (onClickListener != null) {
                    onClickListener.onClick(a.this.f46321b, -1);
                }
            }
        }

        /* loaded from: classes3.dex */
        public class b implements View.OnClickListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DialogInterface.OnClickListener f46326e;

            public b(DialogInterface.OnClickListener onClickListener) {
                this.f46326e = onClickListener;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.f46321b.dismiss();
                DialogInterface.OnClickListener onClickListener = this.f46326e;
                if (onClickListener != null) {
                    onClickListener.onClick(a.this.f46321b, -2);
                }
            }
        }

        public a(Context context) {
            h b2 = b(context);
            this.f46321b = b2;
            b2.d(this);
            this.f46320a = new b((ViewGroup) this.f46321b.getWindow().getDecorView());
            this.f46322c = context;
        }

        public h a() {
            this.f46321b.setOnCancelListener(this.f46320a.f46332e);
            this.f46321b.setOnDismissListener(this.f46320a.f46333f);
            this.f46321b.setOnShowListener(this.f46320a.f46334g);
            this.f46321b.d(this);
            return this.f46321b;
        }

        public abstract h b(Context context);

        public a c(boolean z) {
            this.f46321b.setCanceledOnTouchOutside(z);
            return this;
        }

        public a d(int i, DialogInterface.OnClickListener onClickListener) {
            e(this.f46322c.getText(i), onClickListener);
            return this;
        }

        public a e(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            this.f46320a.f46329b.setText(charSequence);
            this.f46320a.f46329b.setOnClickListener(new b(onClickListener));
            return this;
        }

        public a f(DialogInterface.OnCancelListener onCancelListener) {
            this.f46320a.f46332e = onCancelListener;
            return this;
        }

        public a g(int i, DialogInterface.OnClickListener onClickListener) {
            h(this.f46322c.getText(i), onClickListener);
            return this;
        }

        public a h(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            this.f46320a.f46328a.setText(charSequence);
            this.f46320a.f46328a.setOnClickListener(new View$OnClickListenerC0796a(onClickListener));
            return this;
        }

        public a i(View view) {
            this.f46320a.f46331d.removeAllViews();
            this.f46320a.f46331d.addView(view);
            return this;
        }

        public h j() {
            h a2 = a();
            if (this.f46323d) {
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
        public TextView f46328a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f46329b;

        /* renamed from: c  reason: collision with root package name */
        public View f46330c;

        /* renamed from: d  reason: collision with root package name */
        public FrameLayout f46331d;

        /* renamed from: e  reason: collision with root package name */
        public DialogInterface.OnCancelListener f46332e;

        /* renamed from: f  reason: collision with root package name */
        public DialogInterface.OnDismissListener f46333f;

        /* renamed from: g  reason: collision with root package name */
        public DialogInterface.OnShowListener f46334g;

        /* renamed from: h  reason: collision with root package name */
        public FrameLayout f46335h;
        public FrameLayout i;
        public View j;
        public ViewGroup k;
        public RelativeLayout l;
        public LinearLayout m;
        public View n;

        @SuppressLint({"CutPasteId"})
        public b(ViewGroup viewGroup) {
            this.k = viewGroup;
            this.i = (FrameLayout) viewGroup.findViewById(d.b.h0.a.f.dialog_root);
            this.f46328a = (TextView) viewGroup.findViewById(d.b.h0.a.f.positive_button);
            this.f46329b = (TextView) viewGroup.findViewById(d.b.h0.a.f.negative_button);
            this.f46330c = viewGroup.findViewById(d.b.h0.a.f.dialog_customPanel);
            this.f46331d = (FrameLayout) viewGroup.findViewById(d.b.h0.a.f.dialog_custom_content);
            this.l = (RelativeLayout) viewGroup.findViewById(d.b.h0.a.f.searchbox_alert_dialog);
            this.m = (LinearLayout) viewGroup.findViewById(d.b.h0.a.f.btn_panel);
            this.n = viewGroup.findViewById(d.b.h0.a.f.dialog_customPanel);
            this.f46335h = (FrameLayout) viewGroup.findViewById(d.b.h0.a.f.dialog_root);
            this.j = viewGroup.findViewById(d.b.h0.a.f.nightmode_mask);
        }
    }

    public h(Context context, int i) {
        super(context, i);
        c();
    }

    public a b() {
        return this.f46319f;
    }

    public void c() {
        setContentView(d.b.h0.a.g.swanapp_picker_dialog);
        getWindow().setLayout(-1, -2);
        getWindow().setGravity(80);
        a(false);
    }

    public void d(a aVar) {
        this.f46319f = aVar;
    }
}
