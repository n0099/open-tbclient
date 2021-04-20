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
    public a f45990f;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final b f45991a;

        /* renamed from: b  reason: collision with root package name */
        public final h f45992b;

        /* renamed from: c  reason: collision with root package name */
        public Context f45993c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f45994d = false;

        /* renamed from: d.b.g0.a.q1.b.b.h$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class View$OnClickListenerC0776a implements View.OnClickListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DialogInterface.OnClickListener f45995e;

            public View$OnClickListenerC0776a(DialogInterface.OnClickListener onClickListener) {
                this.f45995e = onClickListener;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.f45992b.dismiss();
                DialogInterface.OnClickListener onClickListener = this.f45995e;
                if (onClickListener != null) {
                    onClickListener.onClick(a.this.f45992b, -1);
                }
            }
        }

        /* loaded from: classes3.dex */
        public class b implements View.OnClickListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DialogInterface.OnClickListener f45997e;

            public b(DialogInterface.OnClickListener onClickListener) {
                this.f45997e = onClickListener;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.f45992b.dismiss();
                DialogInterface.OnClickListener onClickListener = this.f45997e;
                if (onClickListener != null) {
                    onClickListener.onClick(a.this.f45992b, -2);
                }
            }
        }

        public a(Context context) {
            h b2 = b(context);
            this.f45992b = b2;
            b2.d(this);
            this.f45991a = new b((ViewGroup) this.f45992b.getWindow().getDecorView());
            this.f45993c = context;
        }

        public h a() {
            this.f45992b.setOnCancelListener(this.f45991a.f46003e);
            this.f45992b.setOnDismissListener(this.f45991a.f46004f);
            this.f45992b.setOnShowListener(this.f45991a.f46005g);
            this.f45992b.d(this);
            return this.f45992b;
        }

        public abstract h b(Context context);

        public a c(boolean z) {
            this.f45992b.setCanceledOnTouchOutside(z);
            return this;
        }

        public a d(int i, DialogInterface.OnClickListener onClickListener) {
            e(this.f45993c.getText(i), onClickListener);
            return this;
        }

        public a e(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            this.f45991a.f46000b.setText(charSequence);
            this.f45991a.f46000b.setOnClickListener(new b(onClickListener));
            return this;
        }

        public a f(DialogInterface.OnCancelListener onCancelListener) {
            this.f45991a.f46003e = onCancelListener;
            return this;
        }

        public a g(int i, DialogInterface.OnClickListener onClickListener) {
            h(this.f45993c.getText(i), onClickListener);
            return this;
        }

        public a h(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            this.f45991a.f45999a.setText(charSequence);
            this.f45991a.f45999a.setOnClickListener(new View$OnClickListenerC0776a(onClickListener));
            return this;
        }

        public a i(View view) {
            this.f45991a.f46002d.removeAllViews();
            this.f45991a.f46002d.addView(view);
            return this;
        }

        public h j() {
            h a2 = a();
            if (this.f45994d) {
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
        public TextView f45999a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f46000b;

        /* renamed from: c  reason: collision with root package name */
        public View f46001c;

        /* renamed from: d  reason: collision with root package name */
        public FrameLayout f46002d;

        /* renamed from: e  reason: collision with root package name */
        public DialogInterface.OnCancelListener f46003e;

        /* renamed from: f  reason: collision with root package name */
        public DialogInterface.OnDismissListener f46004f;

        /* renamed from: g  reason: collision with root package name */
        public DialogInterface.OnShowListener f46005g;

        /* renamed from: h  reason: collision with root package name */
        public FrameLayout f46006h;
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
            this.f45999a = (TextView) viewGroup.findViewById(d.b.g0.a.f.positive_button);
            this.f46000b = (TextView) viewGroup.findViewById(d.b.g0.a.f.negative_button);
            this.f46001c = viewGroup.findViewById(d.b.g0.a.f.dialog_customPanel);
            this.f46002d = (FrameLayout) viewGroup.findViewById(d.b.g0.a.f.dialog_custom_content);
            this.l = (RelativeLayout) viewGroup.findViewById(d.b.g0.a.f.searchbox_alert_dialog);
            this.m = (LinearLayout) viewGroup.findViewById(d.b.g0.a.f.btn_panel);
            this.n = viewGroup.findViewById(d.b.g0.a.f.dialog_customPanel);
            this.f46006h = (FrameLayout) viewGroup.findViewById(d.b.g0.a.f.dialog_root);
            this.j = viewGroup.findViewById(d.b.g0.a.f.nightmode_mask);
        }
    }

    public h(Context context, int i) {
        super(context, i);
        c();
    }

    public a b() {
        return this.f45990f;
    }

    public void c() {
        setContentView(d.b.g0.a.g.swanapp_picker_dialog);
        getWindow().setLayout(-1, -2);
        getWindow().setGravity(80);
        a(false);
    }

    public void d(a aVar) {
        this.f45990f = aVar;
    }
}
