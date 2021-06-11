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
    public a f49790f;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final b f49791a;

        /* renamed from: b  reason: collision with root package name */
        public final i f49792b;

        /* renamed from: c  reason: collision with root package name */
        public Context f49793c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f49794d = false;

        /* renamed from: d.a.l0.a.z1.b.b.i$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class View$OnClickListenerC0990a implements View.OnClickListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DialogInterface.OnClickListener f49795e;

            public View$OnClickListenerC0990a(DialogInterface.OnClickListener onClickListener) {
                this.f49795e = onClickListener;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.f49792b.dismiss();
                DialogInterface.OnClickListener onClickListener = this.f49795e;
                if (onClickListener != null) {
                    onClickListener.onClick(a.this.f49792b, -1);
                }
            }
        }

        /* loaded from: classes3.dex */
        public class b implements View.OnClickListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DialogInterface.OnClickListener f49797e;

            public b(DialogInterface.OnClickListener onClickListener) {
                this.f49797e = onClickListener;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.f49792b.dismiss();
                DialogInterface.OnClickListener onClickListener = this.f49797e;
                if (onClickListener != null) {
                    onClickListener.onClick(a.this.f49792b, -2);
                }
            }
        }

        public a(Context context) {
            i b2 = b(context);
            this.f49792b = b2;
            b2.d(this);
            this.f49791a = new b((ViewGroup) this.f49792b.getWindow().getDecorView());
            this.f49793c = context;
        }

        public i a() {
            this.f49792b.setOnCancelListener(this.f49791a.f49804f);
            this.f49792b.setOnDismissListener(this.f49791a.f49805g);
            this.f49792b.setOnShowListener(this.f49791a.f49806h);
            this.f49792b.d(this);
            return this.f49792b;
        }

        public abstract i b(Context context);

        public a c(boolean z) {
            this.f49792b.setCanceledOnTouchOutside(z);
            return this;
        }

        public a d(int i2, DialogInterface.OnClickListener onClickListener) {
            e(this.f49793c.getText(i2), onClickListener);
            return this;
        }

        public a e(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            this.f49791a.f49800b.setText(charSequence);
            this.f49791a.f49800b.setOnClickListener(new b(onClickListener));
            return this;
        }

        public a f(DialogInterface.OnCancelListener onCancelListener) {
            this.f49791a.f49804f = onCancelListener;
            return this;
        }

        public a g(String str) {
            this.f49791a.f49801c.setText(str);
            return this;
        }

        public a h(int i2, DialogInterface.OnClickListener onClickListener) {
            i(this.f49793c.getText(i2), onClickListener);
            return this;
        }

        public a i(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            this.f49791a.f49799a.setText(charSequence);
            this.f49791a.f49799a.setOnClickListener(new View$OnClickListenerC0990a(onClickListener));
            return this;
        }

        public a j(View view) {
            this.f49791a.f49803e.removeAllViews();
            this.f49791a.f49803e.addView(view);
            return this;
        }

        public i k() {
            i a2 = a();
            if (this.f49794d) {
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
        public TextView f49799a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f49800b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f49801c;

        /* renamed from: d  reason: collision with root package name */
        public View f49802d;

        /* renamed from: e  reason: collision with root package name */
        public FrameLayout f49803e;

        /* renamed from: f  reason: collision with root package name */
        public DialogInterface.OnCancelListener f49804f;

        /* renamed from: g  reason: collision with root package name */
        public DialogInterface.OnDismissListener f49805g;

        /* renamed from: h  reason: collision with root package name */
        public DialogInterface.OnShowListener f49806h;

        /* renamed from: i  reason: collision with root package name */
        public FrameLayout f49807i;
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
            this.f49801c = (TextView) viewGroup.findViewById(d.a.l0.a.f.title_picker);
            this.f49799a = (TextView) viewGroup.findViewById(d.a.l0.a.f.positive_button);
            this.f49800b = (TextView) viewGroup.findViewById(d.a.l0.a.f.negative_button);
            this.f49802d = viewGroup.findViewById(d.a.l0.a.f.dialog_customPanel);
            this.f49803e = (FrameLayout) viewGroup.findViewById(d.a.l0.a.f.dialog_custom_content);
            this.m = (RelativeLayout) viewGroup.findViewById(d.a.l0.a.f.searchbox_alert_dialog);
            this.n = (LinearLayout) viewGroup.findViewById(d.a.l0.a.f.btn_panel);
            this.o = viewGroup.findViewById(d.a.l0.a.f.dialog_customPanel);
            this.f49807i = (FrameLayout) viewGroup.findViewById(d.a.l0.a.f.dialog_root);
            this.k = viewGroup.findViewById(d.a.l0.a.f.nightmode_mask);
        }
    }

    public i(Context context, int i2) {
        super(context, i2);
        c();
    }

    public a b() {
        return this.f49790f;
    }

    public void c() {
        setContentView(d.a.l0.a.g.swanapp_picker_dialog);
        getWindow().setLayout(-1, -2);
        getWindow().setGravity(80);
        a(false);
    }

    public void d(a aVar) {
        this.f49790f = aVar;
    }
}
