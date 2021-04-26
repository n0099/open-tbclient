package d.a.h0.a.q1.b.b;

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
    public a f43673f;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final b f43674a;

        /* renamed from: b  reason: collision with root package name */
        public final h f43675b;

        /* renamed from: c  reason: collision with root package name */
        public Context f43676c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f43677d = false;

        /* renamed from: d.a.h0.a.q1.b.b.h$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class View$OnClickListenerC0735a implements View.OnClickListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DialogInterface.OnClickListener f43678e;

            public View$OnClickListenerC0735a(DialogInterface.OnClickListener onClickListener) {
                this.f43678e = onClickListener;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.f43675b.dismiss();
                DialogInterface.OnClickListener onClickListener = this.f43678e;
                if (onClickListener != null) {
                    onClickListener.onClick(a.this.f43675b, -1);
                }
            }
        }

        /* loaded from: classes3.dex */
        public class b implements View.OnClickListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DialogInterface.OnClickListener f43680e;

            public b(DialogInterface.OnClickListener onClickListener) {
                this.f43680e = onClickListener;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.f43675b.dismiss();
                DialogInterface.OnClickListener onClickListener = this.f43680e;
                if (onClickListener != null) {
                    onClickListener.onClick(a.this.f43675b, -2);
                }
            }
        }

        public a(Context context) {
            h b2 = b(context);
            this.f43675b = b2;
            b2.d(this);
            this.f43674a = new b((ViewGroup) this.f43675b.getWindow().getDecorView());
            this.f43676c = context;
        }

        public h a() {
            this.f43675b.setOnCancelListener(this.f43674a.f43686e);
            this.f43675b.setOnDismissListener(this.f43674a.f43687f);
            this.f43675b.setOnShowListener(this.f43674a.f43688g);
            this.f43675b.d(this);
            return this.f43675b;
        }

        public abstract h b(Context context);

        public a c(boolean z) {
            this.f43675b.setCanceledOnTouchOutside(z);
            return this;
        }

        public a d(int i2, DialogInterface.OnClickListener onClickListener) {
            e(this.f43676c.getText(i2), onClickListener);
            return this;
        }

        public a e(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            this.f43674a.f43683b.setText(charSequence);
            this.f43674a.f43683b.setOnClickListener(new b(onClickListener));
            return this;
        }

        public a f(DialogInterface.OnCancelListener onCancelListener) {
            this.f43674a.f43686e = onCancelListener;
            return this;
        }

        public a g(int i2, DialogInterface.OnClickListener onClickListener) {
            h(this.f43676c.getText(i2), onClickListener);
            return this;
        }

        public a h(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            this.f43674a.f43682a.setText(charSequence);
            this.f43674a.f43682a.setOnClickListener(new View$OnClickListenerC0735a(onClickListener));
            return this;
        }

        public a i(View view) {
            this.f43674a.f43685d.removeAllViews();
            this.f43674a.f43685d.addView(view);
            return this;
        }

        public h j() {
            h a2 = a();
            if (this.f43677d) {
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
        public TextView f43682a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f43683b;

        /* renamed from: c  reason: collision with root package name */
        public View f43684c;

        /* renamed from: d  reason: collision with root package name */
        public FrameLayout f43685d;

        /* renamed from: e  reason: collision with root package name */
        public DialogInterface.OnCancelListener f43686e;

        /* renamed from: f  reason: collision with root package name */
        public DialogInterface.OnDismissListener f43687f;

        /* renamed from: g  reason: collision with root package name */
        public DialogInterface.OnShowListener f43688g;

        /* renamed from: h  reason: collision with root package name */
        public FrameLayout f43689h;

        /* renamed from: i  reason: collision with root package name */
        public FrameLayout f43690i;
        public View j;
        public ViewGroup k;
        public RelativeLayout l;
        public LinearLayout m;
        public View n;

        @SuppressLint({"CutPasteId"})
        public b(ViewGroup viewGroup) {
            this.k = viewGroup;
            this.f43690i = (FrameLayout) viewGroup.findViewById(d.a.h0.a.f.dialog_root);
            this.f43682a = (TextView) viewGroup.findViewById(d.a.h0.a.f.positive_button);
            this.f43683b = (TextView) viewGroup.findViewById(d.a.h0.a.f.negative_button);
            this.f43684c = viewGroup.findViewById(d.a.h0.a.f.dialog_customPanel);
            this.f43685d = (FrameLayout) viewGroup.findViewById(d.a.h0.a.f.dialog_custom_content);
            this.l = (RelativeLayout) viewGroup.findViewById(d.a.h0.a.f.searchbox_alert_dialog);
            this.m = (LinearLayout) viewGroup.findViewById(d.a.h0.a.f.btn_panel);
            this.n = viewGroup.findViewById(d.a.h0.a.f.dialog_customPanel);
            this.f43689h = (FrameLayout) viewGroup.findViewById(d.a.h0.a.f.dialog_root);
            this.j = viewGroup.findViewById(d.a.h0.a.f.nightmode_mask);
        }
    }

    public h(Context context, int i2) {
        super(context, i2);
        c();
    }

    public a b() {
        return this.f43673f;
    }

    public void c() {
        setContentView(d.a.h0.a.g.swanapp_picker_dialog);
        getWindow().setLayout(-1, -2);
        getWindow().setGravity(80);
        a(false);
    }

    public void d(a aVar) {
        this.f43673f = aVar;
    }
}
