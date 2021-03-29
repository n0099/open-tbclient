package d.b.g0.a.q1.b.b;

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
import com.baidu.android.app.event.EventBusWrapper;
import com.baidu.swan.apps.res.ui.SwanAppScrollView;
import d.b.g0.a.i2.h0;
import d.b.g0.a.k;
/* loaded from: classes2.dex */
public class g extends d.b.g0.a.q1.b.b.c {

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f45574g = k.f45051a;

    /* renamed from: f  reason: collision with root package name */
    public a f45575f;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final b f45576a;

        /* renamed from: b  reason: collision with root package name */
        public final g f45577b;

        /* renamed from: c  reason: collision with root package name */
        public Context f45578c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f45579d = false;

        /* renamed from: e  reason: collision with root package name */
        public int f45580e;

        /* renamed from: d.b.g0.a.q1.b.b.g$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class View$OnClickListenerC0763a implements View.OnClickListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DialogInterface.OnClickListener f45581e;

            public View$OnClickListenerC0763a(DialogInterface.OnClickListener onClickListener) {
                this.f45581e = onClickListener;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.f45577b.e(-1);
                a.this.f45577b.dismiss();
                DialogInterface.OnClickListener onClickListener = this.f45581e;
                if (onClickListener != null) {
                    onClickListener.onClick(a.this.f45577b, -1);
                }
            }
        }

        /* loaded from: classes2.dex */
        public class b implements View.OnClickListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f45583e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ DialogInterface.OnClickListener f45584f;

            public b(int i, DialogInterface.OnClickListener onClickListener) {
                this.f45583e = i;
                this.f45584f = onClickListener;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.f45577b.e(this.f45583e);
                a.this.f45577b.dismiss();
                this.f45584f.onClick(a.this.f45577b, this.f45583e);
            }
        }

        /* loaded from: classes2.dex */
        public class c implements View.OnClickListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DialogInterface.OnClickListener f45586e;

            public c(DialogInterface.OnClickListener onClickListener) {
                this.f45586e = onClickListener;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.f45577b.e(-2);
                a.this.f45577b.dismiss();
                DialogInterface.OnClickListener onClickListener = this.f45586e;
                if (onClickListener != null) {
                    onClickListener.onClick(a.this.f45577b, -2);
                }
            }
        }

        /* loaded from: classes2.dex */
        public class d implements View.OnClickListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DialogInterface.OnClickListener f45588e;

            public d(DialogInterface.OnClickListener onClickListener) {
                this.f45588e = onClickListener;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.f45577b.e(-3);
                a.this.f45577b.dismiss();
                DialogInterface.OnClickListener onClickListener = this.f45588e;
                if (onClickListener != null) {
                    onClickListener.onClick(a.this.f45577b, -3);
                }
            }
        }

        public a(Context context) {
            g h2 = h(context);
            this.f45577b = h2;
            h2.f(this);
            this.f45576a = new b((ViewGroup) this.f45577b.getWindow().getDecorView());
            this.f45578c = context;
            this.f45580e = context.getResources().getDimensionPixelSize(d.b.g0.a.d.aiapps_dialog_btns_height);
        }

        public a A(int i) {
            this.f45576a.a(i);
            return this;
        }

        public final void B() {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.f45580e);
            layoutParams.addRule(3, d.b.g0.a.f.dialog_message_content);
            this.f45576a.u.setLayoutParams(layoutParams);
        }

        public a C(int i, DialogInterface.OnClickListener onClickListener) {
            D(this.f45578c.getText(i), onClickListener);
            return this;
        }

        public a D(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            if (TextUtils.isEmpty(charSequence)) {
                this.f45576a.f45595f.setVisibility(8);
                if (this.f45576a.f45594e.getVisibility() == 0) {
                    this.f45576a.i.setVisibility(8);
                }
                return this;
            }
            this.f45576a.f45595f.setVisibility(0);
            if (this.f45576a.f45594e.getVisibility() == 0) {
                this.f45576a.i.setVisibility(0);
            }
            this.f45576a.f45595f.setText(charSequence);
            this.f45576a.f45595f.setOnClickListener(new c(onClickListener));
            return this;
        }

        public a E(int i) {
            H(this.f45578c.getResources().getColor(i));
            return this;
        }

        public a F(String str, int i) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    H(Color.parseColor(str));
                    return this;
                } catch (IllegalArgumentException e2) {
                    if (g.f45574g) {
                        e2.printStackTrace();
                    }
                }
            }
            if (i > 0) {
                E(i);
            }
            return this;
        }

        public a G(int i) {
            this.f45576a.z = i;
            return this;
        }

        public a H(int i) {
            this.f45576a.y = i;
            return this;
        }

        public a I(int i, DialogInterface.OnClickListener onClickListener) {
            J(this.f45578c.getText(i), onClickListener);
            return this;
        }

        public a J(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            this.f45576a.f45596g.setVisibility(0);
            if (this.f45576a.f45594e.getVisibility() == 0) {
                this.f45576a.j.setVisibility(0);
            }
            this.f45576a.f45596g.setText(charSequence);
            this.f45576a.f45596g.setOnClickListener(new d(onClickListener));
            return this;
        }

        public a K(boolean z) {
            this.f45576a.D.setVisibility(z ? 0 : 8);
            return this;
        }

        public a L(DialogInterface.OnCancelListener onCancelListener) {
            this.f45576a.l = onCancelListener;
            return this;
        }

        public a M(DialogInterface.OnDismissListener onDismissListener) {
            this.f45576a.m = onDismissListener;
            return this;
        }

        public a N(DialogInterface.OnShowListener onShowListener) {
            this.f45576a.n = onShowListener;
            return this;
        }

        public a O(int i, DialogInterface.OnClickListener onClickListener) {
            P(this.f45578c.getText(i), onClickListener);
            return this;
        }

        public a P(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            if (TextUtils.isEmpty(charSequence)) {
                this.f45576a.f45594e.setVisibility(8);
                if (this.f45576a.f45595f.getVisibility() == 0) {
                    this.f45576a.i.setVisibility(8);
                }
                return this;
            }
            this.f45576a.f45594e.setVisibility(0);
            if (this.f45576a.f45595f.getVisibility() == 0) {
                this.f45576a.i.setVisibility(0);
            }
            this.f45576a.f45594e.setText(charSequence);
            this.f45576a.f45594e.setOnClickListener(new View$OnClickListenerC0763a(onClickListener));
            return this;
        }

        public a Q(int i) {
            S(d().getColor(i));
            return this;
        }

        public a R(String str, int i) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    S(Color.parseColor(str));
                    return this;
                } catch (IllegalArgumentException e2) {
                    if (g.f45574g) {
                        e2.printStackTrace();
                    }
                }
            }
            if (i > 0) {
                Q(i);
            }
            return this;
        }

        public a S(int i) {
            b bVar = this.f45576a;
            bVar.x = i;
            bVar.f45594e.setTextColor(i);
            return this;
        }

        public a T(boolean z) {
            this.f45576a.G = z;
            return this;
        }

        public a U(int i) {
            this.f45576a.f45591b.setText(this.f45578c.getText(i));
            return this;
        }

        public a V(CharSequence charSequence) {
            if (!TextUtils.isEmpty(charSequence)) {
                this.f45576a.f45591b.setText(charSequence);
            } else {
                f(true);
            }
            return this;
        }

        public a W(View view) {
            this.f45576a.p.removeAllViews();
            this.f45576a.p.addView(view);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.f45580e);
            layoutParams.addRule(3, d.b.g0.a.f.dialog_customPanel);
            this.f45576a.u.setLayoutParams(layoutParams);
            return this;
        }

        public g X() {
            g c2 = c();
            if (this.f45579d) {
                c2.getWindow().setType(2003);
            }
            try {
                c2.show();
            } catch (WindowManager.BadTokenException e2) {
                if (g.f45574g) {
                    e2.printStackTrace();
                }
            }
            EventBusWrapper.post(new d.b.g0.a.q1.b.b.a("show"));
            return c2;
        }

        @Deprecated
        public g Y(boolean z) {
            return X();
        }

        public final void Z() {
            int color = d().getColor(d.b.g0.a.c.aiapps_dialog_title_text_color);
            int color2 = d().getColor(d.b.g0.a.c.aiapps_dialog_btn_text_color);
            int color3 = d().getColor(d.b.g0.a.c.aiapps_dialog_btn_text_color);
            int color4 = d().getColor(d.b.g0.a.c.aiapps_box_dialog_message_text_color);
            int color5 = d().getColor(d.b.g0.a.c.aiapps_dialog_gray);
            RelativeLayout relativeLayout = this.f45576a.s;
            Resources d2 = d();
            int i = this.f45576a.E;
            if (i == -1) {
                i = d.b.g0.a.e.aiapps_dialog_bg_white;
            }
            relativeLayout.setBackground(d2.getDrawable(i));
            this.f45576a.f45591b.setTextColor(color);
            this.f45576a.f45592c.setTextColor(color4);
            b bVar = this.f45576a;
            TextView textView = bVar.f45594e;
            int i2 = bVar.x;
            if (i2 != color3) {
                color3 = i2;
            }
            textView.setTextColor(color3);
            b bVar2 = this.f45576a;
            int i3 = bVar2.y;
            if (i3 != color2) {
                bVar2.f45595f.setTextColor(i3);
            } else if (bVar2.z != -1) {
                bVar2.f45595f.setTextColor(d().getColorStateList(this.f45576a.z));
            } else {
                bVar2.f45595f.setTextColor(color2);
            }
            this.f45576a.f45596g.setTextColor(color2);
            if (this.f45576a.F != -1) {
                color5 = d().getColor(this.f45576a.F);
            }
            this.f45576a.f45597h.setBackgroundColor(color5);
            this.f45576a.i.setBackgroundColor(color5);
            this.f45576a.j.setBackgroundColor(color5);
            this.f45576a.f45594e.setBackground(d().getDrawable(d.b.g0.a.e.aiapp_alertdialog_button_day_bg_right_selector));
            this.f45576a.f45595f.setBackground(d().getDrawable(d.b.g0.a.e.aiapp_alertdialog_button_day_bg_left_selector));
            this.f45576a.f45596g.setBackground(d().getDrawable(d.b.g0.a.e.aiapp_alertdialog_button_day_bg_all_selector));
            TextView g2 = g();
            if (g2 != null) {
                g2.setBackground(this.f45576a.G ? d().getDrawable(d.b.g0.a.e.aiapp_alertdialog_button_day_bg_all_selector) : null);
            }
        }

        public a a() {
            if (h0.C()) {
                r(this.f45578c.getResources().getDimensionPixelSize(d.b.g0.a.d.aiapps_dialog_landscape_default_width));
                A(this.f45578c.getResources().getDimensionPixelSize(d.b.g0.a.d.aiapps_dialog_landscape_content_default_height));
                return this;
            }
            return this;
        }

        public a b() {
            ((ViewGroup.MarginLayoutParams) this.f45576a.o.getLayoutParams()).setMargins(0, 0, 0, 0);
            return this;
        }

        public g c() {
            this.f45577b.setCancelable(this.f45576a.k.booleanValue());
            if (this.f45576a.k.booleanValue()) {
                this.f45577b.setCanceledOnTouchOutside(false);
            }
            this.f45577b.setOnCancelListener(this.f45576a.l);
            this.f45577b.setOnDismissListener(this.f45576a.m);
            this.f45577b.setOnShowListener(this.f45576a.n);
            DialogInterface.OnKeyListener onKeyListener = this.f45576a.q;
            if (onKeyListener != null) {
                this.f45577b.setOnKeyListener(onKeyListener);
            }
            Z();
            b bVar = this.f45576a;
            c cVar = bVar.A;
            if (cVar != null) {
                cVar.a(this.f45577b, bVar);
            }
            this.f45577b.f(this);
            return this.f45577b;
        }

        public Resources d() {
            return this.f45578c.getResources();
        }

        public ViewGroup e() {
            return this.f45576a.p;
        }

        public a f(boolean z) {
            this.f45576a.f45590a.setVisibility(z ? 8 : 0);
            return this;
        }

        public TextView g() {
            int i;
            TextView textView;
            TextView textView2 = this.f45576a.f45594e;
            if (textView2 == null || textView2.getVisibility() != 0) {
                i = 0;
                textView = null;
            } else {
                textView = this.f45576a.f45594e;
                i = 1;
            }
            TextView textView3 = this.f45576a.f45595f;
            if (textView3 != null && textView3.getVisibility() == 0) {
                i++;
                textView = this.f45576a.f45595f;
            }
            TextView textView4 = this.f45576a.f45596g;
            if (textView4 != null && textView4.getVisibility() == 0) {
                i++;
                textView = this.f45576a.f45596g;
            }
            if (i != 1) {
                return null;
            }
            return textView;
        }

        public g h(Context context) {
            return new g(context, d.b.g0.a.i.NoTitleDialog);
        }

        public a i(boolean z) {
            ViewGroup.LayoutParams layoutParams = this.f45576a.v.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, z ? 0 : this.f45578c.getResources().getDimensionPixelSize(d.b.g0.a.d.aiapps_dialog_content_margin_top), 0, 0);
            }
            return this;
        }

        public a j() {
            this.f45576a.B.setPadding(0, 0, 0, 0);
            return this;
        }

        public a k(boolean z) {
            this.f45576a.u.setVisibility(z ? 0 : 8);
            return this;
        }

        public void l(View view, int i, DialogInterface.OnClickListener onClickListener) {
            if (view == null || onClickListener == null) {
                return;
            }
            view.setOnClickListener(new b(i, onClickListener));
        }

        public a m(boolean z) {
            this.f45576a.k = Boolean.valueOf(z);
            return this;
        }

        public a n(c cVar) {
            this.f45576a.A = cVar;
            return this;
        }

        public a o(int i) {
            this.f45576a.F = i;
            return this;
        }

        public a p(int i) {
            b bVar = this.f45576a;
            bVar.E = i;
            bVar.s.setBackgroundResource(i);
            return this;
        }

        public void q(int i) {
            this.f45576a.s.getLayoutParams().height = i;
            this.f45576a.s.requestLayout();
        }

        public void r(int i) {
            this.f45576a.s.getLayoutParams().width = i;
            this.f45576a.s.requestLayout();
        }

        public a s(int i, int i2, int i3, int i4) {
            this.f45576a.C.setPadding(i, i2, i3, i4);
            return this;
        }

        public a t(int i) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, i);
            layoutParams.addRule(2, d.b.g0.a.f.btn_panel);
            this.f45576a.f45597h.setLayoutParams(layoutParams);
            return this;
        }

        public a u(boolean z) {
            if (z) {
                this.f45576a.f45597h.setVisibility(0);
            } else {
                this.f45576a.f45597h.setVisibility(8);
            }
            return this;
        }

        public a v(int i) {
            this.f45576a.r.setImageResource(i);
            return this;
        }

        public a w(int i) {
            if (this.f45576a.f45593d.getVisibility() != 0) {
                this.f45576a.f45593d.setVisibility(0);
            }
            this.f45576a.f45592c.setText(this.f45578c.getText(i));
            B();
            return this;
        }

        public a x(Spanned spanned) {
            if (this.f45576a.f45593d.getVisibility() != 0) {
                this.f45576a.f45593d.setVisibility(0);
            }
            if (spanned != null) {
                this.f45576a.f45592c.setMovementMethod(LinkMovementMethod.getInstance());
                this.f45576a.f45592c.setText(spanned);
                B();
            }
            return this;
        }

        public a y(String str) {
            if (this.f45576a.f45593d.getVisibility() != 0) {
                this.f45576a.f45593d.setVisibility(0);
            }
            if (str != null) {
                this.f45576a.f45592c.setText(str);
                B();
            }
            return this;
        }

        public a z() {
            this.f45576a.f45592c.setGravity(3);
            return this;
        }
    }

    /* loaded from: classes2.dex */
    public static class b {
        public c A;
        public FrameLayout B;
        public FrameLayout C;
        public View D;

        /* renamed from: a  reason: collision with root package name */
        public LinearLayout f45590a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f45591b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f45592c;

        /* renamed from: d  reason: collision with root package name */
        public LinearLayout f45593d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f45594e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f45595f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f45596g;

        /* renamed from: h  reason: collision with root package name */
        public View f45597h;
        public View i;
        public View j;
        public DialogInterface.OnCancelListener l;
        public DialogInterface.OnDismissListener m;
        public DialogInterface.OnShowListener n;
        public View o;
        public FrameLayout p;
        public DialogInterface.OnKeyListener q;
        public ImageView r;
        public RelativeLayout s;
        public SwanAppScrollView t;
        public LinearLayout u;
        public View v;
        public ViewGroup w;
        public int x;
        public int y;
        public Boolean k = Boolean.TRUE;
        public int z = -1;
        public int E = -1;
        public int F = -1;
        public boolean G = true;

        public b(ViewGroup viewGroup) {
            this.w = viewGroup;
            this.C = (FrameLayout) viewGroup.findViewById(d.b.g0.a.f.dialog_root);
            this.f45590a = (LinearLayout) viewGroup.findViewById(d.b.g0.a.f.title_panel);
            this.f45591b = (TextView) viewGroup.findViewById(d.b.g0.a.f.dialog_title);
            this.f45592c = (TextView) viewGroup.findViewById(d.b.g0.a.f.dialog_message);
            this.f45593d = (LinearLayout) viewGroup.findViewById(d.b.g0.a.f.dialog_message_content);
            this.f45594e = (TextView) viewGroup.findViewById(d.b.g0.a.f.positive_button);
            this.f45595f = (TextView) viewGroup.findViewById(d.b.g0.a.f.negative_button);
            this.f45596g = (TextView) viewGroup.findViewById(d.b.g0.a.f.neutral_button);
            this.i = viewGroup.findViewById(d.b.g0.a.f.divider3);
            this.j = viewGroup.findViewById(d.b.g0.a.f.divider4);
            this.o = viewGroup.findViewById(d.b.g0.a.f.dialog_customPanel);
            this.p = (FrameLayout) viewGroup.findViewById(d.b.g0.a.f.dialog_custom_content);
            this.r = (ImageView) viewGroup.findViewById(d.b.g0.a.f.dialog_icon);
            this.s = (RelativeLayout) viewGroup.findViewById(d.b.g0.a.f.searchbox_alert_dialog);
            this.f45597h = viewGroup.findViewById(d.b.g0.a.f.divider2);
            this.t = (SwanAppScrollView) viewGroup.findViewById(d.b.g0.a.f.message_scrollview);
            this.u = (LinearLayout) viewGroup.findViewById(d.b.g0.a.f.btn_panel);
            this.v = viewGroup.findViewById(d.b.g0.a.f.dialog_customPanel);
            this.B = (FrameLayout) viewGroup.findViewById(d.b.g0.a.f.dialog_root);
            this.D = viewGroup.findViewById(d.b.g0.a.f.nightmode_mask);
            if (d.b.g0.a.i2.c.k() || d.b.g0.a.i2.c.l()) {
                int dimensionPixelSize = this.f45592c.getResources().getDimensionPixelSize(d.b.g0.a.d.aiapps_dialog_text_padding);
                this.f45592c.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
            }
            int color = this.w.getResources().getColor(d.b.g0.a.c.aiapps_dialog_btn_text_color);
            this.x = color;
            this.y = color;
        }

        public void a(int i) {
            this.t.setMaxHeight(i);
        }
    }

    /* loaded from: classes2.dex */
    public interface c {
        void a(g gVar, b bVar);
    }

    public g(Context context, int i) {
        super(context, i);
        d();
    }

    public a c() {
        return this.f45575f;
    }

    public void d() {
        setContentView(d.b.g0.a.g.aiapps_alert_dialog);
        getWindow().setLayout(-1, -1);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        EventBusWrapper.post(new d.b.g0.a.q1.b.b.a("hide"));
    }

    public void e(int i) {
    }

    public void f(a aVar) {
        this.f45575f = aVar;
    }
}
