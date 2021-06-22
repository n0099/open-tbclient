package d.a.m0.a.z1.b.b;

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
    public a f49898f;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final b f49899a;

        /* renamed from: b  reason: collision with root package name */
        public final i f49900b;

        /* renamed from: c  reason: collision with root package name */
        public Context f49901c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f49902d = false;

        /* renamed from: d.a.m0.a.z1.b.b.i$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class View$OnClickListenerC0993a implements View.OnClickListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DialogInterface.OnClickListener f49903e;

            public View$OnClickListenerC0993a(DialogInterface.OnClickListener onClickListener) {
                this.f49903e = onClickListener;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.f49900b.dismiss();
                DialogInterface.OnClickListener onClickListener = this.f49903e;
                if (onClickListener != null) {
                    onClickListener.onClick(a.this.f49900b, -1);
                }
            }
        }

        /* loaded from: classes3.dex */
        public class b implements View.OnClickListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DialogInterface.OnClickListener f49905e;

            public b(DialogInterface.OnClickListener onClickListener) {
                this.f49905e = onClickListener;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.f49900b.dismiss();
                DialogInterface.OnClickListener onClickListener = this.f49905e;
                if (onClickListener != null) {
                    onClickListener.onClick(a.this.f49900b, -2);
                }
            }
        }

        public a(Context context) {
            i b2 = b(context);
            this.f49900b = b2;
            b2.d(this);
            this.f49899a = new b((ViewGroup) this.f49900b.getWindow().getDecorView());
            this.f49901c = context;
        }

        public i a() {
            this.f49900b.setOnCancelListener(this.f49899a.f49912f);
            this.f49900b.setOnDismissListener(this.f49899a.f49913g);
            this.f49900b.setOnShowListener(this.f49899a.f49914h);
            this.f49900b.d(this);
            return this.f49900b;
        }

        public abstract i b(Context context);

        public a c(boolean z) {
            this.f49900b.setCanceledOnTouchOutside(z);
            return this;
        }

        public a d(int i2, DialogInterface.OnClickListener onClickListener) {
            e(this.f49901c.getText(i2), onClickListener);
            return this;
        }

        public a e(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            this.f49899a.f49908b.setText(charSequence);
            this.f49899a.f49908b.setOnClickListener(new b(onClickListener));
            return this;
        }

        public a f(DialogInterface.OnCancelListener onCancelListener) {
            this.f49899a.f49912f = onCancelListener;
            return this;
        }

        public a g(String str) {
            this.f49899a.f49909c.setText(str);
            return this;
        }

        public a h(int i2, DialogInterface.OnClickListener onClickListener) {
            i(this.f49901c.getText(i2), onClickListener);
            return this;
        }

        public a i(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            this.f49899a.f49907a.setText(charSequence);
            this.f49899a.f49907a.setOnClickListener(new View$OnClickListenerC0993a(onClickListener));
            return this;
        }

        public a j(View view) {
            this.f49899a.f49911e.removeAllViews();
            this.f49899a.f49911e.addView(view);
            return this;
        }

        public i k() {
            i a2 = a();
            if (this.f49902d) {
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
        public TextView f49907a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f49908b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f49909c;

        /* renamed from: d  reason: collision with root package name */
        public View f49910d;

        /* renamed from: e  reason: collision with root package name */
        public FrameLayout f49911e;

        /* renamed from: f  reason: collision with root package name */
        public DialogInterface.OnCancelListener f49912f;

        /* renamed from: g  reason: collision with root package name */
        public DialogInterface.OnDismissListener f49913g;

        /* renamed from: h  reason: collision with root package name */
        public DialogInterface.OnShowListener f49914h;

        /* renamed from: i  reason: collision with root package name */
        public FrameLayout f49915i;
        public FrameLayout j;
        public View k;
        public ViewGroup l;
        public RelativeLayout m;
        public LinearLayout n;
        public View o;

        @SuppressLint({"CutPasteId"})
        public b(ViewGroup viewGroup) {
            this.l = viewGroup;
            this.j = (FrameLayout) viewGroup.findViewById(d.a.m0.a.f.dialog_root);
            this.f49909c = (TextView) viewGroup.findViewById(d.a.m0.a.f.title_picker);
            this.f49907a = (TextView) viewGroup.findViewById(d.a.m0.a.f.positive_button);
            this.f49908b = (TextView) viewGroup.findViewById(d.a.m0.a.f.negative_button);
            this.f49910d = viewGroup.findViewById(d.a.m0.a.f.dialog_customPanel);
            this.f49911e = (FrameLayout) viewGroup.findViewById(d.a.m0.a.f.dialog_custom_content);
            this.m = (RelativeLayout) viewGroup.findViewById(d.a.m0.a.f.searchbox_alert_dialog);
            this.n = (LinearLayout) viewGroup.findViewById(d.a.m0.a.f.btn_panel);
            this.o = viewGroup.findViewById(d.a.m0.a.f.dialog_customPanel);
            this.f49915i = (FrameLayout) viewGroup.findViewById(d.a.m0.a.f.dialog_root);
            this.k = viewGroup.findViewById(d.a.m0.a.f.nightmode_mask);
        }
    }

    public i(Context context, int i2) {
        super(context, i2);
        c();
    }

    public a b() {
        return this.f49898f;
    }

    public void c() {
        setContentView(d.a.m0.a.g.swanapp_picker_dialog);
        getWindow().setLayout(-1, -2);
        getWindow().setGravity(80);
        a(false);
    }

    public void d(a aVar) {
        this.f49898f = aVar;
    }
}
