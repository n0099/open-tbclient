package d.b.g0.a.q1.b.b;

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
    public a f45597f;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final b f45598a;

        /* renamed from: b  reason: collision with root package name */
        public final h f45599b;

        /* renamed from: c  reason: collision with root package name */
        public Context f45600c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f45601d = false;

        /* renamed from: d.b.g0.a.q1.b.b.h$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class View$OnClickListenerC0763a implements View.OnClickListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DialogInterface.OnClickListener f45602e;

            public View$OnClickListenerC0763a(DialogInterface.OnClickListener onClickListener) {
                this.f45602e = onClickListener;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.f45599b.dismiss();
                DialogInterface.OnClickListener onClickListener = this.f45602e;
                if (onClickListener != null) {
                    onClickListener.onClick(a.this.f45599b, -1);
                }
            }
        }

        /* loaded from: classes3.dex */
        public class b implements View.OnClickListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DialogInterface.OnClickListener f45604e;

            public b(DialogInterface.OnClickListener onClickListener) {
                this.f45604e = onClickListener;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.f45599b.dismiss();
                DialogInterface.OnClickListener onClickListener = this.f45604e;
                if (onClickListener != null) {
                    onClickListener.onClick(a.this.f45599b, -2);
                }
            }
        }

        public a(Context context) {
            h b2 = b(context);
            this.f45599b = b2;
            b2.d(this);
            this.f45598a = new b((ViewGroup) this.f45599b.getWindow().getDecorView());
            this.f45600c = context;
        }

        public h a() {
            this.f45599b.setOnCancelListener(this.f45598a.f45610e);
            this.f45599b.setOnDismissListener(this.f45598a.f45611f);
            this.f45599b.setOnShowListener(this.f45598a.f45612g);
            this.f45599b.d(this);
            return this.f45599b;
        }

        public h b(Context context) {
            throw null;
        }

        public a c(boolean z) {
            this.f45599b.setCanceledOnTouchOutside(z);
            return this;
        }

        public a d(int i, DialogInterface.OnClickListener onClickListener) {
            e(this.f45600c.getText(i), onClickListener);
            return this;
        }

        public a e(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            this.f45598a.f45607b.setText(charSequence);
            this.f45598a.f45607b.setOnClickListener(new b(onClickListener));
            return this;
        }

        public a f(DialogInterface.OnCancelListener onCancelListener) {
            this.f45598a.f45610e = onCancelListener;
            return this;
        }

        public a g(int i, DialogInterface.OnClickListener onClickListener) {
            h(this.f45600c.getText(i), onClickListener);
            return this;
        }

        public a h(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            this.f45598a.f45606a.setText(charSequence);
            this.f45598a.f45606a.setOnClickListener(new View$OnClickListenerC0763a(onClickListener));
            return this;
        }

        public a i(View view) {
            this.f45598a.f45609d.removeAllViews();
            this.f45598a.f45609d.addView(view);
            return this;
        }

        public h j() {
            h a2 = a();
            if (this.f45601d) {
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
        public TextView f45606a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f45607b;

        /* renamed from: c  reason: collision with root package name */
        public View f45608c;

        /* renamed from: d  reason: collision with root package name */
        public FrameLayout f45609d;

        /* renamed from: e  reason: collision with root package name */
        public DialogInterface.OnCancelListener f45610e;

        /* renamed from: f  reason: collision with root package name */
        public DialogInterface.OnDismissListener f45611f;

        /* renamed from: g  reason: collision with root package name */
        public DialogInterface.OnShowListener f45612g;

        /* renamed from: h  reason: collision with root package name */
        public FrameLayout f45613h;
        public FrameLayout i;
        public View j;
        public ViewGroup k;
        public RelativeLayout l;
        public LinearLayout m;
        public View n;

        @SuppressLint({"CutPasteId"})
        public b(ViewGroup viewGroup) {
            this.k = viewGroup;
            this.i = (FrameLayout) viewGroup.findViewById(d.b.g0.a.f.dialog_root);
            this.f45606a = (TextView) viewGroup.findViewById(d.b.g0.a.f.positive_button);
            this.f45607b = (TextView) viewGroup.findViewById(d.b.g0.a.f.negative_button);
            this.f45608c = viewGroup.findViewById(d.b.g0.a.f.dialog_customPanel);
            this.f45609d = (FrameLayout) viewGroup.findViewById(d.b.g0.a.f.dialog_custom_content);
            this.l = (RelativeLayout) viewGroup.findViewById(d.b.g0.a.f.searchbox_alert_dialog);
            this.m = (LinearLayout) viewGroup.findViewById(d.b.g0.a.f.btn_panel);
            this.n = viewGroup.findViewById(d.b.g0.a.f.dialog_customPanel);
            this.f45613h = (FrameLayout) viewGroup.findViewById(d.b.g0.a.f.dialog_root);
            this.j = viewGroup.findViewById(d.b.g0.a.f.nightmode_mask);
        }
    }

    public h(Context context, int i) {
        super(context, i);
        c();
    }

    public a b() {
        return this.f45597f;
    }

    public void c() {
        setContentView(d.b.g0.a.g.swanapp_picker_dialog);
        getWindow().setLayout(-1, -2);
        getWindow().setGravity(80);
        a(false);
    }

    public void d(a aVar) {
        this.f45597f = aVar;
    }
}
