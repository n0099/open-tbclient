package d.a.i0.a.z1.b.b;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.res.ui.SwanAppScrollView;
import d.a.i0.a.k;
import d.a.i0.a.v2.n0;
/* loaded from: classes3.dex */
public class h extends d.a.i0.a.z1.b.b.c {

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f45915g = k.f43025a;

    /* renamed from: f  reason: collision with root package name */
    public a f45916f;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final b f45917a;

        /* renamed from: b  reason: collision with root package name */
        public final h f45918b;

        /* renamed from: c  reason: collision with root package name */
        public Context f45919c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f45920d = false;

        /* renamed from: e  reason: collision with root package name */
        public int f45921e;

        /* renamed from: d.a.i0.a.z1.b.b.h$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class View$OnClickListenerC0922a implements View.OnClickListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DialogInterface.OnClickListener f45922e;

            public View$OnClickListenerC0922a(DialogInterface.OnClickListener onClickListener) {
                this.f45922e = onClickListener;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.f45918b.e(-1);
                a.this.f45918b.dismiss();
                DialogInterface.OnClickListener onClickListener = this.f45922e;
                if (onClickListener != null) {
                    onClickListener.onClick(a.this.f45918b, -1);
                }
            }
        }

        /* loaded from: classes3.dex */
        public class b implements View.OnClickListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f45924e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ DialogInterface.OnClickListener f45925f;

            public b(int i2, DialogInterface.OnClickListener onClickListener) {
                this.f45924e = i2;
                this.f45925f = onClickListener;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.f45918b.e(this.f45924e);
                a.this.f45918b.dismiss();
                this.f45925f.onClick(a.this.f45918b, this.f45924e);
            }
        }

        /* loaded from: classes3.dex */
        public class c implements View.OnClickListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DialogInterface.OnClickListener f45927e;

            public c(DialogInterface.OnClickListener onClickListener) {
                this.f45927e = onClickListener;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.f45918b.e(-2);
                a.this.f45918b.dismiss();
                DialogInterface.OnClickListener onClickListener = this.f45927e;
                if (onClickListener != null) {
                    onClickListener.onClick(a.this.f45918b, -2);
                }
            }
        }

        /* loaded from: classes3.dex */
        public class d implements View.OnClickListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DialogInterface.OnClickListener f45929e;

            public d(DialogInterface.OnClickListener onClickListener) {
                this.f45929e = onClickListener;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.f45918b.e(-3);
                a.this.f45918b.dismiss();
                DialogInterface.OnClickListener onClickListener = this.f45929e;
                if (onClickListener != null) {
                    onClickListener.onClick(a.this.f45918b, -3);
                }
            }
        }

        public a(Context context) {
            h h2 = h(context);
            this.f45918b = h2;
            h2.f(this);
            this.f45917a = new b((ViewGroup) this.f45918b.getWindow().getDecorView());
            this.f45919c = context;
            this.f45921e = context.getResources().getDimensionPixelSize(d.a.i0.a.d.aiapps_dialog_btns_height);
        }

        public final void A() {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.f45921e);
            layoutParams.addRule(3, d.a.i0.a.f.dialog_message_content);
            this.f45917a.t.setLayoutParams(layoutParams);
        }

        public a B(int i2, DialogInterface.OnClickListener onClickListener) {
            C(this.f45919c.getText(i2), onClickListener);
            return this;
        }

        public a C(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            if (TextUtils.isEmpty(charSequence)) {
                this.f45917a.f45936f.setVisibility(8);
                if (this.f45917a.f45935e.getVisibility() == 0) {
                    this.f45917a.f45939i.setVisibility(8);
                }
                return this;
            }
            this.f45917a.f45936f.setVisibility(0);
            if (this.f45917a.f45935e.getVisibility() == 0) {
                this.f45917a.f45939i.setVisibility(0);
            }
            this.f45917a.f45936f.setText(charSequence);
            this.f45917a.f45936f.setOnClickListener(new c(onClickListener));
            return this;
        }

        public a D(int i2) {
            G(this.f45919c.getResources().getColor(i2));
            return this;
        }

        public a E(String str, int i2) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    G(Color.parseColor(str));
                    return this;
                } catch (IllegalArgumentException e2) {
                    if (h.f45915g) {
                        e2.printStackTrace();
                    }
                }
            }
            if (i2 > 0) {
                D(i2);
            }
            return this;
        }

        public a F(int i2) {
            this.f45917a.y = i2;
            return this;
        }

        public a G(int i2) {
            this.f45917a.x = i2;
            return this;
        }

        public a H(int i2, DialogInterface.OnClickListener onClickListener) {
            I(this.f45919c.getText(i2), onClickListener);
            return this;
        }

        public a I(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            this.f45917a.f45937g.setVisibility(0);
            if (this.f45917a.f45935e.getVisibility() == 0) {
                this.f45917a.j.setVisibility(0);
            }
            this.f45917a.f45937g.setText(charSequence);
            this.f45917a.f45937g.setOnClickListener(new d(onClickListener));
            return this;
        }

        public a J(boolean z) {
            this.f45917a.B.setVisibility(z ? 0 : 8);
            return this;
        }

        public a K(DialogInterface.OnCancelListener onCancelListener) {
            this.f45917a.l = onCancelListener;
            return this;
        }

        public a L(DialogInterface.OnDismissListener onDismissListener) {
            this.f45917a.m = onDismissListener;
            return this;
        }

        public a M(DialogInterface.OnKeyListener onKeyListener) {
            this.f45917a.p = onKeyListener;
            return this;
        }

        public a N(DialogInterface.OnShowListener onShowListener) {
            this.f45917a.n = onShowListener;
            return this;
        }

        public a O(int i2, DialogInterface.OnClickListener onClickListener) {
            P(this.f45919c.getText(i2), onClickListener);
            return this;
        }

        public a P(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            if (TextUtils.isEmpty(charSequence)) {
                this.f45917a.f45935e.setVisibility(8);
                if (this.f45917a.f45936f.getVisibility() == 0) {
                    this.f45917a.f45939i.setVisibility(8);
                }
                return this;
            }
            this.f45917a.f45935e.setVisibility(0);
            if (this.f45917a.f45936f.getVisibility() == 0) {
                this.f45917a.f45939i.setVisibility(0);
            }
            this.f45917a.f45935e.setText(charSequence);
            this.f45917a.f45935e.setOnClickListener(new View$OnClickListenerC0922a(onClickListener));
            return this;
        }

        public a Q(int i2) {
            S(d().getColor(i2));
            return this;
        }

        public a R(String str, int i2) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    S(Color.parseColor(str));
                    return this;
                } catch (IllegalArgumentException e2) {
                    if (h.f45915g) {
                        e2.printStackTrace();
                    }
                }
            }
            if (i2 > 0) {
                Q(i2);
            }
            return this;
        }

        public a S(int i2) {
            b bVar = this.f45917a;
            bVar.w = i2;
            bVar.f45935e.setTextColor(i2);
            return this;
        }

        public a T(boolean z) {
            this.f45917a.E = z;
            return this;
        }

        public a U(int i2) {
            this.f45917a.f45932b.setText(this.f45919c.getText(i2));
            return this;
        }

        public a V(CharSequence charSequence) {
            if (!TextUtils.isEmpty(charSequence)) {
                this.f45917a.f45932b.setText(charSequence);
            } else {
                f(true);
            }
            return this;
        }

        public a W(View view) {
            this.f45917a.o.removeAllViews();
            this.f45917a.o.addView(view);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.f45921e);
            layoutParams.addRule(3, d.a.i0.a.f.dialog_customPanel);
            this.f45917a.t.setLayoutParams(layoutParams);
            return this;
        }

        public h X() {
            h c2 = c();
            if (this.f45920d) {
                c2.getWindow().setType(2003);
            }
            try {
                c2.show();
            } catch (WindowManager.BadTokenException e2) {
                if (h.f45915g) {
                    e2.printStackTrace();
                }
            }
            BdEventBus.Companion.getDefault().post(new d.a.i0.a.z1.b.b.a("show"));
            return c2;
        }

        @Deprecated
        public h Y(boolean z) {
            return X();
        }

        public final void Z() {
            int color = d().getColor(d.a.i0.a.c.aiapps_dialog_title_text_color);
            int color2 = d().getColor(d.a.i0.a.c.aiapps_dialog_btn_text_color);
            int color3 = d().getColor(d.a.i0.a.c.aiapps_dialog_btn_text_color);
            int color4 = d().getColor(d.a.i0.a.c.aiapps_box_dialog_message_text_color);
            int color5 = d().getColor(d.a.i0.a.c.aiapps_dialog_gray);
            RelativeLayout relativeLayout = this.f45917a.r;
            Resources d2 = d();
            int i2 = this.f45917a.C;
            if (i2 == -1) {
                i2 = d.a.i0.a.e.aiapps_dialog_bg_white;
            }
            relativeLayout.setBackground(d2.getDrawable(i2));
            this.f45917a.f45932b.setTextColor(color);
            this.f45917a.f45933c.setTextColor(color4);
            b bVar = this.f45917a;
            TextView textView = bVar.f45935e;
            int i3 = bVar.w;
            if (i3 != color3) {
                color3 = i3;
            }
            textView.setTextColor(color3);
            b bVar2 = this.f45917a;
            int i4 = bVar2.x;
            if (i4 != color2) {
                bVar2.f45936f.setTextColor(i4);
            } else if (bVar2.y != -1) {
                bVar2.f45936f.setTextColor(d().getColorStateList(this.f45917a.y));
            } else {
                bVar2.f45936f.setTextColor(color2);
            }
            this.f45917a.f45937g.setTextColor(color2);
            if (this.f45917a.D != -1) {
                color5 = d().getColor(this.f45917a.D);
            }
            this.f45917a.f45938h.setBackgroundColor(color5);
            this.f45917a.f45939i.setBackgroundColor(color5);
            this.f45917a.j.setBackgroundColor(color5);
            this.f45917a.f45935e.setBackground(d().getDrawable(d.a.i0.a.e.aiapp_alertdialog_button_day_bg_right_selector));
            this.f45917a.f45936f.setBackground(d().getDrawable(d.a.i0.a.e.aiapp_alertdialog_button_day_bg_left_selector));
            this.f45917a.f45937g.setBackground(d().getDrawable(d.a.i0.a.e.aiapp_alertdialog_button_day_bg_all_selector));
            TextView g2 = g();
            if (g2 != null) {
                g2.setBackground(this.f45917a.E ? d().getDrawable(d.a.i0.a.e.aiapp_alertdialog_button_day_bg_all_selector) : null);
            }
        }

        public a a() {
            if (n0.F()) {
                r(this.f45919c.getResources().getDimensionPixelSize(d.a.i0.a.d.aiapps_dialog_landscape_default_width));
                z(this.f45919c.getResources().getDimensionPixelSize(d.a.i0.a.d.aiapps_dialog_landscape_content_default_height));
                return this;
            }
            return this;
        }

        public a b() {
            ((ViewGroup.MarginLayoutParams) this.f45917a.u.getLayoutParams()).setMargins(0, 0, 0, 0);
            return this;
        }

        public h c() {
            this.f45918b.setCancelable(this.f45917a.k.booleanValue());
            if (this.f45917a.k.booleanValue()) {
                this.f45918b.setCanceledOnTouchOutside(false);
            }
            this.f45918b.setOnCancelListener(this.f45917a.l);
            this.f45918b.setOnDismissListener(this.f45917a.m);
            this.f45918b.setOnShowListener(this.f45917a.n);
            DialogInterface.OnKeyListener onKeyListener = this.f45917a.p;
            if (onKeyListener != null) {
                this.f45918b.setOnKeyListener(onKeyListener);
            }
            Z();
            b bVar = this.f45917a;
            c cVar = bVar.z;
            if (cVar != null) {
                cVar.a(this.f45918b, bVar);
            }
            this.f45918b.f(this);
            return this.f45918b;
        }

        public Resources d() {
            return this.f45919c.getResources();
        }

        public ViewGroup e() {
            return this.f45917a.o;
        }

        public a f(boolean z) {
            this.f45917a.f45931a.setVisibility(z ? 8 : 0);
            return this;
        }

        public TextView g() {
            int i2;
            TextView textView;
            TextView textView2 = this.f45917a.f45935e;
            if (textView2 == null || textView2.getVisibility() != 0) {
                i2 = 0;
                textView = null;
            } else {
                textView = this.f45917a.f45935e;
                i2 = 1;
            }
            TextView textView3 = this.f45917a.f45936f;
            if (textView3 != null && textView3.getVisibility() == 0) {
                i2++;
                textView = this.f45917a.f45936f;
            }
            TextView textView4 = this.f45917a.f45937g;
            if (textView4 != null && textView4.getVisibility() == 0) {
                i2++;
                textView = this.f45917a.f45937g;
            }
            if (i2 != 1) {
                return null;
            }
            return textView;
        }

        public h h(Context context) {
            return new h(context, d.a.i0.a.i.SwanAppNoTitleDialog);
        }

        public a i(boolean z) {
            ViewGroup.LayoutParams layoutParams = this.f45917a.u.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, z ? 0 : this.f45919c.getResources().getDimensionPixelSize(d.a.i0.a.d.aiapps_dialog_content_margin_top), 0, 0);
            }
            return this;
        }

        public a j() {
            this.f45917a.A.setPadding(0, 0, 0, 0);
            return this;
        }

        public a k(boolean z) {
            this.f45917a.t.setVisibility(z ? 0 : 8);
            return this;
        }

        public void l(View view, int i2, DialogInterface.OnClickListener onClickListener) {
            if (view == null || onClickListener == null) {
                return;
            }
            view.setOnClickListener(new b(i2, onClickListener));
        }

        public a m(boolean z) {
            this.f45917a.k = Boolean.valueOf(z);
            return this;
        }

        public a n(c cVar) {
            this.f45917a.z = cVar;
            return this;
        }

        public a o(int i2) {
            this.f45917a.D = i2;
            return this;
        }

        public a p(int i2) {
            b bVar = this.f45917a;
            bVar.C = i2;
            bVar.r.setBackgroundResource(i2);
            return this;
        }

        public void q(int i2) {
            this.f45917a.r.getLayoutParams().height = i2;
            this.f45917a.r.requestLayout();
        }

        public void r(int i2) {
            this.f45917a.r.getLayoutParams().width = i2;
            this.f45917a.r.requestLayout();
        }

        public a s(int i2) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, i2);
            layoutParams.addRule(2, d.a.i0.a.f.btn_panel);
            this.f45917a.f45938h.setLayoutParams(layoutParams);
            return this;
        }

        public a t(boolean z) {
            if (z) {
                this.f45917a.f45938h.setVisibility(0);
            } else {
                this.f45917a.f45938h.setVisibility(8);
            }
            return this;
        }

        public a u(int i2) {
            this.f45917a.q.setImageResource(i2);
            return this;
        }

        public a v(int i2) {
            if (this.f45917a.f45934d.getVisibility() != 0) {
                this.f45917a.f45934d.setVisibility(0);
            }
            this.f45917a.f45933c.setText(this.f45919c.getText(i2));
            A();
            return this;
        }

        public a w(Spanned spanned) {
            if (this.f45917a.f45934d.getVisibility() != 0) {
                this.f45917a.f45934d.setVisibility(0);
            }
            if (spanned != null) {
                this.f45917a.f45933c.setMovementMethod(LinkMovementMethod.getInstance());
                this.f45917a.f45933c.setText(spanned);
                A();
            }
            return this;
        }

        public a x(String str) {
            if (this.f45917a.f45934d.getVisibility() != 0) {
                this.f45917a.f45934d.setVisibility(0);
            }
            if (str != null) {
                this.f45917a.f45933c.setText(str);
                A();
            }
            return this;
        }

        public a y() {
            this.f45917a.f45933c.setGravity(3);
            return this;
        }

        public a z(int i2) {
            this.f45917a.a(i2);
            return this;
        }
    }

    /* loaded from: classes3.dex */
    public static class b {
        public FrameLayout A;
        public View B;

        /* renamed from: a  reason: collision with root package name */
        public LinearLayout f45931a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f45932b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f45933c;

        /* renamed from: d  reason: collision with root package name */
        public LinearLayout f45934d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f45935e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f45936f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f45937g;

        /* renamed from: h  reason: collision with root package name */
        public View f45938h;

        /* renamed from: i  reason: collision with root package name */
        public View f45939i;
        public View j;
        public DialogInterface.OnCancelListener l;
        public DialogInterface.OnDismissListener m;
        public DialogInterface.OnShowListener n;
        public FrameLayout o;
        public DialogInterface.OnKeyListener p;
        public ImageView q;
        public RelativeLayout r;
        public SwanAppScrollView s;
        public LinearLayout t;
        public View u;
        public ViewGroup v;
        public int w;
        public int x;
        public c z;
        public Boolean k = Boolean.TRUE;
        public int y = -1;
        public int C = -1;
        public int D = -1;
        public boolean E = true;

        public b(ViewGroup viewGroup) {
            this.v = viewGroup;
            this.f45931a = (LinearLayout) viewGroup.findViewById(d.a.i0.a.f.title_panel);
            this.f45932b = (TextView) viewGroup.findViewById(d.a.i0.a.f.dialog_title);
            this.f45933c = (TextView) viewGroup.findViewById(d.a.i0.a.f.dialog_message);
            this.f45934d = (LinearLayout) viewGroup.findViewById(d.a.i0.a.f.dialog_message_content);
            this.f45935e = (TextView) viewGroup.findViewById(d.a.i0.a.f.positive_button);
            this.f45936f = (TextView) viewGroup.findViewById(d.a.i0.a.f.negative_button);
            this.f45937g = (TextView) viewGroup.findViewById(d.a.i0.a.f.neutral_button);
            this.f45939i = viewGroup.findViewById(d.a.i0.a.f.divider3);
            this.j = viewGroup.findViewById(d.a.i0.a.f.divider4);
            this.o = (FrameLayout) viewGroup.findViewById(d.a.i0.a.f.dialog_custom_content);
            this.q = (ImageView) viewGroup.findViewById(d.a.i0.a.f.dialog_icon);
            this.r = (RelativeLayout) viewGroup.findViewById(d.a.i0.a.f.searchbox_alert_dialog);
            this.f45938h = viewGroup.findViewById(d.a.i0.a.f.divider2);
            this.s = (SwanAppScrollView) viewGroup.findViewById(d.a.i0.a.f.message_scrollview);
            this.t = (LinearLayout) viewGroup.findViewById(d.a.i0.a.f.btn_panel);
            this.u = viewGroup.findViewById(d.a.i0.a.f.dialog_customPanel);
            this.A = (FrameLayout) viewGroup.findViewById(d.a.i0.a.f.dialog_root);
            this.B = viewGroup.findViewById(d.a.i0.a.f.nightmode_mask);
            if (d.a.i0.a.v2.d.k() || d.a.i0.a.v2.d.l()) {
                int dimensionPixelSize = this.f45933c.getResources().getDimensionPixelSize(d.a.i0.a.d.aiapps_dialog_text_padding);
                this.f45933c.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
            }
            SwanAppActivity activity = d.a.i0.a.g1.f.V().getActivity();
            if (d.a.i0.t.e.d() && d.a.i0.a.v2.f.d(activity) && d.a.i0.t.e.e(activity)) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) (d.a.i0.t.e.a(activity) * 0.8f), -2);
                layoutParams.gravity = 17;
                this.r.setLayoutParams(layoutParams);
            }
            int color = this.v.getResources().getColor(d.a.i0.a.c.aiapps_dialog_btn_text_color);
            this.w = color;
            this.x = color;
        }

        public void a(int i2) {
            this.s.setMaxHeight(i2);
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a(h hVar, b bVar);
    }

    public h(Context context, int i2) {
        super(context, i2);
        d();
    }

    public a c() {
        return this.f45916f;
    }

    public void d() {
        setContentView(d.a.i0.a.g.aiapps_alert_dialog);
        getWindow().setLayout(-1, -1);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        BdEventBus.Companion.getDefault().post(new d.a.i0.a.z1.b.b.a("hide"));
    }

    public void e(int i2) {
    }

    public void f(a aVar) {
        this.f45916f = aVar;
    }
}
