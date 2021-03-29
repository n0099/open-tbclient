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
/* loaded from: classes2.dex */
public class h extends c {

    /* renamed from: f  reason: collision with root package name */
    public a f45598f;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final b f45599a;

        /* renamed from: b  reason: collision with root package name */
        public final h f45600b;

        /* renamed from: c  reason: collision with root package name */
        public Context f45601c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f45602d = false;

        /* renamed from: d.b.g0.a.q1.b.b.h$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class View$OnClickListenerC0764a implements View.OnClickListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DialogInterface.OnClickListener f45603e;

            public View$OnClickListenerC0764a(DialogInterface.OnClickListener onClickListener) {
                this.f45603e = onClickListener;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.f45600b.dismiss();
                DialogInterface.OnClickListener onClickListener = this.f45603e;
                if (onClickListener != null) {
                    onClickListener.onClick(a.this.f45600b, -1);
                }
            }
        }

        /* loaded from: classes2.dex */
        public class b implements View.OnClickListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DialogInterface.OnClickListener f45605e;

            public b(DialogInterface.OnClickListener onClickListener) {
                this.f45605e = onClickListener;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.f45600b.dismiss();
                DialogInterface.OnClickListener onClickListener = this.f45605e;
                if (onClickListener != null) {
                    onClickListener.onClick(a.this.f45600b, -2);
                }
            }
        }

        public a(Context context) {
            h b2 = b(context);
            this.f45600b = b2;
            b2.d(this);
            this.f45599a = new b((ViewGroup) this.f45600b.getWindow().getDecorView());
            this.f45601c = context;
        }

        public h a() {
            this.f45600b.setOnCancelListener(this.f45599a.f45611e);
            this.f45600b.setOnDismissListener(this.f45599a.f45612f);
            this.f45600b.setOnShowListener(this.f45599a.f45613g);
            this.f45600b.d(this);
            return this.f45600b;
        }

        public abstract h b(Context context);

        public a c(boolean z) {
            this.f45600b.setCanceledOnTouchOutside(z);
            return this;
        }

        public a d(int i, DialogInterface.OnClickListener onClickListener) {
            e(this.f45601c.getText(i), onClickListener);
            return this;
        }

        public a e(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            this.f45599a.f45608b.setText(charSequence);
            this.f45599a.f45608b.setOnClickListener(new b(onClickListener));
            return this;
        }

        public a f(DialogInterface.OnCancelListener onCancelListener) {
            this.f45599a.f45611e = onCancelListener;
            return this;
        }

        public a g(int i, DialogInterface.OnClickListener onClickListener) {
            h(this.f45601c.getText(i), onClickListener);
            return this;
        }

        public a h(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            this.f45599a.f45607a.setText(charSequence);
            this.f45599a.f45607a.setOnClickListener(new View$OnClickListenerC0764a(onClickListener));
            return this;
        }

        public a i(View view) {
            this.f45599a.f45610d.removeAllViews();
            this.f45599a.f45610d.addView(view);
            return this;
        }

        public h j() {
            h a2 = a();
            if (this.f45602d) {
                a2.getWindow().setType(2003);
            }
            try {
                a2.show();
            } catch (WindowManager.BadTokenException unused) {
            }
            return a2;
        }
    }

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public TextView f45607a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f45608b;

        /* renamed from: c  reason: collision with root package name */
        public View f45609c;

        /* renamed from: d  reason: collision with root package name */
        public FrameLayout f45610d;

        /* renamed from: e  reason: collision with root package name */
        public DialogInterface.OnCancelListener f45611e;

        /* renamed from: f  reason: collision with root package name */
        public DialogInterface.OnDismissListener f45612f;

        /* renamed from: g  reason: collision with root package name */
        public DialogInterface.OnShowListener f45613g;

        /* renamed from: h  reason: collision with root package name */
        public FrameLayout f45614h;
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
            this.f45607a = (TextView) viewGroup.findViewById(d.b.g0.a.f.positive_button);
            this.f45608b = (TextView) viewGroup.findViewById(d.b.g0.a.f.negative_button);
            this.f45609c = viewGroup.findViewById(d.b.g0.a.f.dialog_customPanel);
            this.f45610d = (FrameLayout) viewGroup.findViewById(d.b.g0.a.f.dialog_custom_content);
            this.l = (RelativeLayout) viewGroup.findViewById(d.b.g0.a.f.searchbox_alert_dialog);
            this.m = (LinearLayout) viewGroup.findViewById(d.b.g0.a.f.btn_panel);
            this.n = viewGroup.findViewById(d.b.g0.a.f.dialog_customPanel);
            this.f45614h = (FrameLayout) viewGroup.findViewById(d.b.g0.a.f.dialog_root);
            this.j = viewGroup.findViewById(d.b.g0.a.f.nightmode_mask);
        }
    }

    public h(Context context, int i) {
        super(context, i);
        c();
    }

    public a b() {
        return this.f45598f;
    }

    public void c() {
        setContentView(d.b.g0.a.g.swanapp_picker_dialog);
        getWindow().setLayout(-1, -2);
        getWindow().setGravity(80);
        a(false);
    }

    public void d(a aVar) {
        this.f45598f = aVar;
    }
}
