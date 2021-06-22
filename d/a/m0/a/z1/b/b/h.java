package d.a.m0.a.z1.b.b;

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
import d.a.m0.a.k;
import d.a.m0.a.v2.n0;
/* loaded from: classes3.dex */
public class h extends d.a.m0.a.z1.b.b.c {

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f49873g = k.f46983a;

    /* renamed from: f  reason: collision with root package name */
    public a f49874f;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final b f49875a;

        /* renamed from: b  reason: collision with root package name */
        public final h f49876b;

        /* renamed from: c  reason: collision with root package name */
        public Context f49877c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f49878d = false;

        /* renamed from: e  reason: collision with root package name */
        public int f49879e;

        /* renamed from: d.a.m0.a.z1.b.b.h$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class View$OnClickListenerC0992a implements View.OnClickListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DialogInterface.OnClickListener f49880e;

            public View$OnClickListenerC0992a(DialogInterface.OnClickListener onClickListener) {
                this.f49880e = onClickListener;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.f49876b.e(-1);
                a.this.f49876b.dismiss();
                DialogInterface.OnClickListener onClickListener = this.f49880e;
                if (onClickListener != null) {
                    onClickListener.onClick(a.this.f49876b, -1);
                }
            }
        }

        /* loaded from: classes3.dex */
        public class b implements View.OnClickListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f49882e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ DialogInterface.OnClickListener f49883f;

            public b(int i2, DialogInterface.OnClickListener onClickListener) {
                this.f49882e = i2;
                this.f49883f = onClickListener;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.f49876b.e(this.f49882e);
                a.this.f49876b.dismiss();
                this.f49883f.onClick(a.this.f49876b, this.f49882e);
            }
        }

        /* loaded from: classes3.dex */
        public class c implements View.OnClickListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DialogInterface.OnClickListener f49885e;

            public c(DialogInterface.OnClickListener onClickListener) {
                this.f49885e = onClickListener;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.f49876b.e(-2);
                a.this.f49876b.dismiss();
                DialogInterface.OnClickListener onClickListener = this.f49885e;
                if (onClickListener != null) {
                    onClickListener.onClick(a.this.f49876b, -2);
                }
            }
        }

        /* loaded from: classes3.dex */
        public class d implements View.OnClickListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DialogInterface.OnClickListener f49887e;

            public d(DialogInterface.OnClickListener onClickListener) {
                this.f49887e = onClickListener;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.f49876b.e(-3);
                a.this.f49876b.dismiss();
                DialogInterface.OnClickListener onClickListener = this.f49887e;
                if (onClickListener != null) {
                    onClickListener.onClick(a.this.f49876b, -3);
                }
            }
        }

        public a(Context context) {
            h h2 = h(context);
            this.f49876b = h2;
            h2.f(this);
            this.f49875a = new b((ViewGroup) this.f49876b.getWindow().getDecorView());
            this.f49877c = context;
            this.f49879e = context.getResources().getDimensionPixelSize(d.a.m0.a.d.aiapps_dialog_btns_height);
        }

        public final void A() {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.f49879e);
            layoutParams.addRule(3, d.a.m0.a.f.dialog_message_content);
            this.f49875a.t.setLayoutParams(layoutParams);
        }

        public a B(int i2, DialogInterface.OnClickListener onClickListener) {
            C(this.f49877c.getText(i2), onClickListener);
            return this;
        }

        public a C(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            if (TextUtils.isEmpty(charSequence)) {
                this.f49875a.f49894f.setVisibility(8);
                if (this.f49875a.f49893e.getVisibility() == 0) {
                    this.f49875a.f49897i.setVisibility(8);
                }
                return this;
            }
            this.f49875a.f49894f.setVisibility(0);
            if (this.f49875a.f49893e.getVisibility() == 0) {
                this.f49875a.f49897i.setVisibility(0);
            }
            this.f49875a.f49894f.setText(charSequence);
            this.f49875a.f49894f.setOnClickListener(new c(onClickListener));
            return this;
        }

        public a D(int i2) {
            G(this.f49877c.getResources().getColor(i2));
            return this;
        }

        public a E(String str, int i2) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    G(Color.parseColor(str));
                    return this;
                } catch (IllegalArgumentException e2) {
                    if (h.f49873g) {
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
            this.f49875a.y = i2;
            return this;
        }

        public a G(int i2) {
            this.f49875a.x = i2;
            return this;
        }

        public a H(int i2, DialogInterface.OnClickListener onClickListener) {
            I(this.f49877c.getText(i2), onClickListener);
            return this;
        }

        public a I(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            this.f49875a.f49895g.setVisibility(0);
            if (this.f49875a.f49893e.getVisibility() == 0) {
                this.f49875a.j.setVisibility(0);
            }
            this.f49875a.f49895g.setText(charSequence);
            this.f49875a.f49895g.setOnClickListener(new d(onClickListener));
            return this;
        }

        public a J(boolean z) {
            this.f49875a.B.setVisibility(z ? 0 : 8);
            return this;
        }

        public a K(DialogInterface.OnCancelListener onCancelListener) {
            this.f49875a.l = onCancelListener;
            return this;
        }

        public a L(DialogInterface.OnDismissListener onDismissListener) {
            this.f49875a.m = onDismissListener;
            return this;
        }

        public a M(DialogInterface.OnKeyListener onKeyListener) {
            this.f49875a.p = onKeyListener;
            return this;
        }

        public a N(DialogInterface.OnShowListener onShowListener) {
            this.f49875a.n = onShowListener;
            return this;
        }

        public a O(int i2, DialogInterface.OnClickListener onClickListener) {
            P(this.f49877c.getText(i2), onClickListener);
            return this;
        }

        public a P(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            if (TextUtils.isEmpty(charSequence)) {
                this.f49875a.f49893e.setVisibility(8);
                if (this.f49875a.f49894f.getVisibility() == 0) {
                    this.f49875a.f49897i.setVisibility(8);
                }
                return this;
            }
            this.f49875a.f49893e.setVisibility(0);
            if (this.f49875a.f49894f.getVisibility() == 0) {
                this.f49875a.f49897i.setVisibility(0);
            }
            this.f49875a.f49893e.setText(charSequence);
            this.f49875a.f49893e.setOnClickListener(new View$OnClickListenerC0992a(onClickListener));
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
                    if (h.f49873g) {
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
            b bVar = this.f49875a;
            bVar.w = i2;
            bVar.f49893e.setTextColor(i2);
            return this;
        }

        public a T(boolean z) {
            this.f49875a.E = z;
            return this;
        }

        public a U(int i2) {
            this.f49875a.f49890b.setText(this.f49877c.getText(i2));
            return this;
        }

        public a V(CharSequence charSequence) {
            if (!TextUtils.isEmpty(charSequence)) {
                this.f49875a.f49890b.setText(charSequence);
            } else {
                f(true);
            }
            return this;
        }

        public a W(View view) {
            this.f49875a.o.removeAllViews();
            this.f49875a.o.addView(view);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.f49879e);
            layoutParams.addRule(3, d.a.m0.a.f.dialog_customPanel);
            this.f49875a.t.setLayoutParams(layoutParams);
            return this;
        }

        public h X() {
            h c2 = c();
            if (this.f49878d) {
                c2.getWindow().setType(2003);
            }
            try {
                c2.show();
            } catch (WindowManager.BadTokenException e2) {
                if (h.f49873g) {
                    e2.printStackTrace();
                }
            }
            BdEventBus.Companion.getDefault().post(new d.a.m0.a.z1.b.b.a("show"));
            return c2;
        }

        @Deprecated
        public h Y(boolean z) {
            return X();
        }

        public final void Z() {
            int color = d().getColor(d.a.m0.a.c.aiapps_dialog_title_text_color);
            int color2 = d().getColor(d.a.m0.a.c.aiapps_dialog_btn_text_color);
            int color3 = d().getColor(d.a.m0.a.c.aiapps_dialog_btn_text_color);
            int color4 = d().getColor(d.a.m0.a.c.aiapps_box_dialog_message_text_color);
            int color5 = d().getColor(d.a.m0.a.c.aiapps_dialog_gray);
            RelativeLayout relativeLayout = this.f49875a.r;
            Resources d2 = d();
            int i2 = this.f49875a.C;
            if (i2 == -1) {
                i2 = d.a.m0.a.e.aiapps_dialog_bg_white;
            }
            relativeLayout.setBackground(d2.getDrawable(i2));
            this.f49875a.f49890b.setTextColor(color);
            this.f49875a.f49891c.setTextColor(color4);
            b bVar = this.f49875a;
            TextView textView = bVar.f49893e;
            int i3 = bVar.w;
            if (i3 != color3) {
                color3 = i3;
            }
            textView.setTextColor(color3);
            b bVar2 = this.f49875a;
            int i4 = bVar2.x;
            if (i4 != color2) {
                bVar2.f49894f.setTextColor(i4);
            } else if (bVar2.y != -1) {
                bVar2.f49894f.setTextColor(d().getColorStateList(this.f49875a.y));
            } else {
                bVar2.f49894f.setTextColor(color2);
            }
            this.f49875a.f49895g.setTextColor(color2);
            if (this.f49875a.D != -1) {
                color5 = d().getColor(this.f49875a.D);
            }
            this.f49875a.f49896h.setBackgroundColor(color5);
            this.f49875a.f49897i.setBackgroundColor(color5);
            this.f49875a.j.setBackgroundColor(color5);
            this.f49875a.f49893e.setBackground(d().getDrawable(d.a.m0.a.e.aiapp_alertdialog_button_day_bg_right_selector));
            this.f49875a.f49894f.setBackground(d().getDrawable(d.a.m0.a.e.aiapp_alertdialog_button_day_bg_left_selector));
            this.f49875a.f49895g.setBackground(d().getDrawable(d.a.m0.a.e.aiapp_alertdialog_button_day_bg_all_selector));
            TextView g2 = g();
            if (g2 != null) {
                g2.setBackground(this.f49875a.E ? d().getDrawable(d.a.m0.a.e.aiapp_alertdialog_button_day_bg_all_selector) : null);
            }
        }

        public a a() {
            if (n0.F()) {
                r(this.f49877c.getResources().getDimensionPixelSize(d.a.m0.a.d.aiapps_dialog_landscape_default_width));
                z(this.f49877c.getResources().getDimensionPixelSize(d.a.m0.a.d.aiapps_dialog_landscape_content_default_height));
                return this;
            }
            return this;
        }

        public a b() {
            ((ViewGroup.MarginLayoutParams) this.f49875a.u.getLayoutParams()).setMargins(0, 0, 0, 0);
            return this;
        }

        public h c() {
            this.f49876b.setCancelable(this.f49875a.k.booleanValue());
            if (this.f49875a.k.booleanValue()) {
                this.f49876b.setCanceledOnTouchOutside(false);
            }
            this.f49876b.setOnCancelListener(this.f49875a.l);
            this.f49876b.setOnDismissListener(this.f49875a.m);
            this.f49876b.setOnShowListener(this.f49875a.n);
            DialogInterface.OnKeyListener onKeyListener = this.f49875a.p;
            if (onKeyListener != null) {
                this.f49876b.setOnKeyListener(onKeyListener);
            }
            Z();
            b bVar = this.f49875a;
            c cVar = bVar.z;
            if (cVar != null) {
                cVar.a(this.f49876b, bVar);
            }
            this.f49876b.f(this);
            return this.f49876b;
        }

        public Resources d() {
            return this.f49877c.getResources();
        }

        public ViewGroup e() {
            return this.f49875a.o;
        }

        public a f(boolean z) {
            this.f49875a.f49889a.setVisibility(z ? 8 : 0);
            return this;
        }

        public TextView g() {
            int i2;
            TextView textView;
            TextView textView2 = this.f49875a.f49893e;
            if (textView2 == null || textView2.getVisibility() != 0) {
                i2 = 0;
                textView = null;
            } else {
                textView = this.f49875a.f49893e;
                i2 = 1;
            }
            TextView textView3 = this.f49875a.f49894f;
            if (textView3 != null && textView3.getVisibility() == 0) {
                i2++;
                textView = this.f49875a.f49894f;
            }
            TextView textView4 = this.f49875a.f49895g;
            if (textView4 != null && textView4.getVisibility() == 0) {
                i2++;
                textView = this.f49875a.f49895g;
            }
            if (i2 != 1) {
                return null;
            }
            return textView;
        }

        public h h(Context context) {
            return new h(context, d.a.m0.a.i.SwanAppNoTitleDialog);
        }

        public a i(boolean z) {
            ViewGroup.LayoutParams layoutParams = this.f49875a.u.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, z ? 0 : this.f49877c.getResources().getDimensionPixelSize(d.a.m0.a.d.aiapps_dialog_content_margin_top), 0, 0);
            }
            return this;
        }

        public a j() {
            this.f49875a.A.setPadding(0, 0, 0, 0);
            return this;
        }

        public a k(boolean z) {
            this.f49875a.t.setVisibility(z ? 0 : 8);
            return this;
        }

        public void l(View view, int i2, DialogInterface.OnClickListener onClickListener) {
            if (view == null || onClickListener == null) {
                return;
            }
            view.setOnClickListener(new b(i2, onClickListener));
        }

        public a m(boolean z) {
            this.f49875a.k = Boolean.valueOf(z);
            return this;
        }

        public a n(c cVar) {
            this.f49875a.z = cVar;
            return this;
        }

        public a o(int i2) {
            this.f49875a.D = i2;
            return this;
        }

        public a p(int i2) {
            b bVar = this.f49875a;
            bVar.C = i2;
            bVar.r.setBackgroundResource(i2);
            return this;
        }

        public void q(int i2) {
            this.f49875a.r.getLayoutParams().height = i2;
            this.f49875a.r.requestLayout();
        }

        public void r(int i2) {
            this.f49875a.r.getLayoutParams().width = i2;
            this.f49875a.r.requestLayout();
        }

        public a s(int i2) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, i2);
            layoutParams.addRule(2, d.a.m0.a.f.btn_panel);
            this.f49875a.f49896h.setLayoutParams(layoutParams);
            return this;
        }

        public a t(boolean z) {
            if (z) {
                this.f49875a.f49896h.setVisibility(0);
            } else {
                this.f49875a.f49896h.setVisibility(8);
            }
            return this;
        }

        public a u(int i2) {
            this.f49875a.q.setImageResource(i2);
            return this;
        }

        public a v(int i2) {
            if (this.f49875a.f49892d.getVisibility() != 0) {
                this.f49875a.f49892d.setVisibility(0);
            }
            this.f49875a.f49891c.setText(this.f49877c.getText(i2));
            A();
            return this;
        }

        public a w(Spanned spanned) {
            if (this.f49875a.f49892d.getVisibility() != 0) {
                this.f49875a.f49892d.setVisibility(0);
            }
            if (spanned != null) {
                this.f49875a.f49891c.setMovementMethod(LinkMovementMethod.getInstance());
                this.f49875a.f49891c.setText(spanned);
                A();
            }
            return this;
        }

        public a x(String str) {
            if (this.f49875a.f49892d.getVisibility() != 0) {
                this.f49875a.f49892d.setVisibility(0);
            }
            if (str != null) {
                this.f49875a.f49891c.setText(str);
                A();
            }
            return this;
        }

        public a y() {
            this.f49875a.f49891c.setGravity(3);
            return this;
        }

        public a z(int i2) {
            this.f49875a.a(i2);
            return this;
        }
    }

    /* loaded from: classes3.dex */
    public static class b {
        public FrameLayout A;
        public View B;

        /* renamed from: a  reason: collision with root package name */
        public LinearLayout f49889a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f49890b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f49891c;

        /* renamed from: d  reason: collision with root package name */
        public LinearLayout f49892d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f49893e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f49894f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f49895g;

        /* renamed from: h  reason: collision with root package name */
        public View f49896h;

        /* renamed from: i  reason: collision with root package name */
        public View f49897i;
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
            this.f49889a = (LinearLayout) viewGroup.findViewById(d.a.m0.a.f.title_panel);
            this.f49890b = (TextView) viewGroup.findViewById(d.a.m0.a.f.dialog_title);
            this.f49891c = (TextView) viewGroup.findViewById(d.a.m0.a.f.dialog_message);
            this.f49892d = (LinearLayout) viewGroup.findViewById(d.a.m0.a.f.dialog_message_content);
            this.f49893e = (TextView) viewGroup.findViewById(d.a.m0.a.f.positive_button);
            this.f49894f = (TextView) viewGroup.findViewById(d.a.m0.a.f.negative_button);
            this.f49895g = (TextView) viewGroup.findViewById(d.a.m0.a.f.neutral_button);
            this.f49897i = viewGroup.findViewById(d.a.m0.a.f.divider3);
            this.j = viewGroup.findViewById(d.a.m0.a.f.divider4);
            this.o = (FrameLayout) viewGroup.findViewById(d.a.m0.a.f.dialog_custom_content);
            this.q = (ImageView) viewGroup.findViewById(d.a.m0.a.f.dialog_icon);
            this.r = (RelativeLayout) viewGroup.findViewById(d.a.m0.a.f.searchbox_alert_dialog);
            this.f49896h = viewGroup.findViewById(d.a.m0.a.f.divider2);
            this.s = (SwanAppScrollView) viewGroup.findViewById(d.a.m0.a.f.message_scrollview);
            this.t = (LinearLayout) viewGroup.findViewById(d.a.m0.a.f.btn_panel);
            this.u = viewGroup.findViewById(d.a.m0.a.f.dialog_customPanel);
            this.A = (FrameLayout) viewGroup.findViewById(d.a.m0.a.f.dialog_root);
            this.B = viewGroup.findViewById(d.a.m0.a.f.nightmode_mask);
            if (d.a.m0.a.v2.d.k() || d.a.m0.a.v2.d.l()) {
                int dimensionPixelSize = this.f49891c.getResources().getDimensionPixelSize(d.a.m0.a.d.aiapps_dialog_text_padding);
                this.f49891c.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
            }
            SwanAppActivity activity = d.a.m0.a.g1.f.V().getActivity();
            if (d.a.m0.t.e.d() && d.a.m0.a.v2.f.d(activity) && d.a.m0.t.e.e(activity)) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) (d.a.m0.t.e.a(activity) * 0.8f), -2);
                layoutParams.gravity = 17;
                this.r.setLayoutParams(layoutParams);
            }
            int color = this.v.getResources().getColor(d.a.m0.a.c.aiapps_dialog_btn_text_color);
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
        return this.f49874f;
    }

    public void d() {
        setContentView(d.a.m0.a.g.aiapps_alert_dialog);
        getWindow().setLayout(-1, -1);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        BdEventBus.Companion.getDefault().post(new d.a.m0.a.z1.b.b.a("hide"));
    }

    public void e(int i2) {
    }

    public void f(a aVar) {
        this.f49874f = aVar;
    }
}
