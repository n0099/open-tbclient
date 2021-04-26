package d.a.h0.a.q1.b.b;

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
import d.a.h0.a.i2.h0;
import d.a.h0.a.k;
/* loaded from: classes3.dex */
public class g extends d.a.h0.a.q1.b.b.c {

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f43648g = k.f43101a;

    /* renamed from: f  reason: collision with root package name */
    public a f43649f;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final b f43650a;

        /* renamed from: b  reason: collision with root package name */
        public final g f43651b;

        /* renamed from: c  reason: collision with root package name */
        public Context f43652c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f43653d = false;

        /* renamed from: e  reason: collision with root package name */
        public int f43654e;

        /* renamed from: d.a.h0.a.q1.b.b.g$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class View$OnClickListenerC0734a implements View.OnClickListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DialogInterface.OnClickListener f43655e;

            public View$OnClickListenerC0734a(DialogInterface.OnClickListener onClickListener) {
                this.f43655e = onClickListener;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.f43651b.e(-1);
                a.this.f43651b.dismiss();
                DialogInterface.OnClickListener onClickListener = this.f43655e;
                if (onClickListener != null) {
                    onClickListener.onClick(a.this.f43651b, -1);
                }
            }
        }

        /* loaded from: classes3.dex */
        public class b implements View.OnClickListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f43657e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ DialogInterface.OnClickListener f43658f;

            public b(int i2, DialogInterface.OnClickListener onClickListener) {
                this.f43657e = i2;
                this.f43658f = onClickListener;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.f43651b.e(this.f43657e);
                a.this.f43651b.dismiss();
                this.f43658f.onClick(a.this.f43651b, this.f43657e);
            }
        }

        /* loaded from: classes3.dex */
        public class c implements View.OnClickListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DialogInterface.OnClickListener f43660e;

            public c(DialogInterface.OnClickListener onClickListener) {
                this.f43660e = onClickListener;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.f43651b.e(-2);
                a.this.f43651b.dismiss();
                DialogInterface.OnClickListener onClickListener = this.f43660e;
                if (onClickListener != null) {
                    onClickListener.onClick(a.this.f43651b, -2);
                }
            }
        }

        /* loaded from: classes3.dex */
        public class d implements View.OnClickListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DialogInterface.OnClickListener f43662e;

            public d(DialogInterface.OnClickListener onClickListener) {
                this.f43662e = onClickListener;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.f43651b.e(-3);
                a.this.f43651b.dismiss();
                DialogInterface.OnClickListener onClickListener = this.f43662e;
                if (onClickListener != null) {
                    onClickListener.onClick(a.this.f43651b, -3);
                }
            }
        }

        public a(Context context) {
            g h2 = h(context);
            this.f43651b = h2;
            h2.f(this);
            this.f43650a = new b((ViewGroup) this.f43651b.getWindow().getDecorView());
            this.f43652c = context;
            this.f43654e = context.getResources().getDimensionPixelSize(d.a.h0.a.d.aiapps_dialog_btns_height);
        }

        public a A(int i2) {
            this.f43650a.a(i2);
            return this;
        }

        public final void B() {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.f43654e);
            layoutParams.addRule(3, d.a.h0.a.f.dialog_message_content);
            this.f43650a.u.setLayoutParams(layoutParams);
        }

        public a C(int i2, DialogInterface.OnClickListener onClickListener) {
            D(this.f43652c.getText(i2), onClickListener);
            return this;
        }

        public a D(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            if (TextUtils.isEmpty(charSequence)) {
                this.f43650a.f43669f.setVisibility(8);
                if (this.f43650a.f43668e.getVisibility() == 0) {
                    this.f43650a.f43672i.setVisibility(8);
                }
                return this;
            }
            this.f43650a.f43669f.setVisibility(0);
            if (this.f43650a.f43668e.getVisibility() == 0) {
                this.f43650a.f43672i.setVisibility(0);
            }
            this.f43650a.f43669f.setText(charSequence);
            this.f43650a.f43669f.setOnClickListener(new c(onClickListener));
            return this;
        }

        public a E(int i2) {
            H(this.f43652c.getResources().getColor(i2));
            return this;
        }

        public a F(String str, int i2) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    H(Color.parseColor(str));
                    return this;
                } catch (IllegalArgumentException e2) {
                    if (g.f43648g) {
                        e2.printStackTrace();
                    }
                }
            }
            if (i2 > 0) {
                E(i2);
            }
            return this;
        }

        public a G(int i2) {
            this.f43650a.z = i2;
            return this;
        }

        public a H(int i2) {
            this.f43650a.y = i2;
            return this;
        }

        public a I(int i2, DialogInterface.OnClickListener onClickListener) {
            J(this.f43652c.getText(i2), onClickListener);
            return this;
        }

        public a J(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            this.f43650a.f43670g.setVisibility(0);
            if (this.f43650a.f43668e.getVisibility() == 0) {
                this.f43650a.j.setVisibility(0);
            }
            this.f43650a.f43670g.setText(charSequence);
            this.f43650a.f43670g.setOnClickListener(new d(onClickListener));
            return this;
        }

        public a K(boolean z) {
            this.f43650a.D.setVisibility(z ? 0 : 8);
            return this;
        }

        public a L(DialogInterface.OnCancelListener onCancelListener) {
            this.f43650a.l = onCancelListener;
            return this;
        }

        public a M(DialogInterface.OnDismissListener onDismissListener) {
            this.f43650a.m = onDismissListener;
            return this;
        }

        public a N(DialogInterface.OnShowListener onShowListener) {
            this.f43650a.n = onShowListener;
            return this;
        }

        public a O(int i2, DialogInterface.OnClickListener onClickListener) {
            P(this.f43652c.getText(i2), onClickListener);
            return this;
        }

        public a P(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            if (TextUtils.isEmpty(charSequence)) {
                this.f43650a.f43668e.setVisibility(8);
                if (this.f43650a.f43669f.getVisibility() == 0) {
                    this.f43650a.f43672i.setVisibility(8);
                }
                return this;
            }
            this.f43650a.f43668e.setVisibility(0);
            if (this.f43650a.f43669f.getVisibility() == 0) {
                this.f43650a.f43672i.setVisibility(0);
            }
            this.f43650a.f43668e.setText(charSequence);
            this.f43650a.f43668e.setOnClickListener(new View$OnClickListenerC0734a(onClickListener));
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
                    if (g.f43648g) {
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
            b bVar = this.f43650a;
            bVar.x = i2;
            bVar.f43668e.setTextColor(i2);
            return this;
        }

        public a T(boolean z) {
            this.f43650a.G = z;
            return this;
        }

        public a U(int i2) {
            this.f43650a.f43665b.setText(this.f43652c.getText(i2));
            return this;
        }

        public a V(CharSequence charSequence) {
            if (!TextUtils.isEmpty(charSequence)) {
                this.f43650a.f43665b.setText(charSequence);
            } else {
                f(true);
            }
            return this;
        }

        public a W(View view) {
            this.f43650a.p.removeAllViews();
            this.f43650a.p.addView(view);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.f43654e);
            layoutParams.addRule(3, d.a.h0.a.f.dialog_customPanel);
            this.f43650a.u.setLayoutParams(layoutParams);
            return this;
        }

        public g X() {
            g c2 = c();
            if (this.f43653d) {
                c2.getWindow().setType(2003);
            }
            try {
                c2.show();
            } catch (WindowManager.BadTokenException e2) {
                if (g.f43648g) {
                    e2.printStackTrace();
                }
            }
            EventBusWrapper.post(new d.a.h0.a.q1.b.b.a("show"));
            return c2;
        }

        @Deprecated
        public g Y(boolean z) {
            return X();
        }

        public final void Z() {
            int color = d().getColor(d.a.h0.a.c.aiapps_dialog_title_text_color);
            int color2 = d().getColor(d.a.h0.a.c.aiapps_dialog_btn_text_color);
            int color3 = d().getColor(d.a.h0.a.c.aiapps_dialog_btn_text_color);
            int color4 = d().getColor(d.a.h0.a.c.aiapps_box_dialog_message_text_color);
            int color5 = d().getColor(d.a.h0.a.c.aiapps_dialog_gray);
            RelativeLayout relativeLayout = this.f43650a.s;
            Resources d2 = d();
            int i2 = this.f43650a.E;
            if (i2 == -1) {
                i2 = d.a.h0.a.e.aiapps_dialog_bg_white;
            }
            relativeLayout.setBackground(d2.getDrawable(i2));
            this.f43650a.f43665b.setTextColor(color);
            this.f43650a.f43666c.setTextColor(color4);
            b bVar = this.f43650a;
            TextView textView = bVar.f43668e;
            int i3 = bVar.x;
            if (i3 != color3) {
                color3 = i3;
            }
            textView.setTextColor(color3);
            b bVar2 = this.f43650a;
            int i4 = bVar2.y;
            if (i4 != color2) {
                bVar2.f43669f.setTextColor(i4);
            } else if (bVar2.z != -1) {
                bVar2.f43669f.setTextColor(d().getColorStateList(this.f43650a.z));
            } else {
                bVar2.f43669f.setTextColor(color2);
            }
            this.f43650a.f43670g.setTextColor(color2);
            if (this.f43650a.F != -1) {
                color5 = d().getColor(this.f43650a.F);
            }
            this.f43650a.f43671h.setBackgroundColor(color5);
            this.f43650a.f43672i.setBackgroundColor(color5);
            this.f43650a.j.setBackgroundColor(color5);
            this.f43650a.f43668e.setBackground(d().getDrawable(d.a.h0.a.e.aiapp_alertdialog_button_day_bg_right_selector));
            this.f43650a.f43669f.setBackground(d().getDrawable(d.a.h0.a.e.aiapp_alertdialog_button_day_bg_left_selector));
            this.f43650a.f43670g.setBackground(d().getDrawable(d.a.h0.a.e.aiapp_alertdialog_button_day_bg_all_selector));
            TextView g2 = g();
            if (g2 != null) {
                g2.setBackground(this.f43650a.G ? d().getDrawable(d.a.h0.a.e.aiapp_alertdialog_button_day_bg_all_selector) : null);
            }
        }

        public a a() {
            if (h0.C()) {
                r(this.f43652c.getResources().getDimensionPixelSize(d.a.h0.a.d.aiapps_dialog_landscape_default_width));
                A(this.f43652c.getResources().getDimensionPixelSize(d.a.h0.a.d.aiapps_dialog_landscape_content_default_height));
                return this;
            }
            return this;
        }

        public a b() {
            ((ViewGroup.MarginLayoutParams) this.f43650a.o.getLayoutParams()).setMargins(0, 0, 0, 0);
            return this;
        }

        public g c() {
            this.f43651b.setCancelable(this.f43650a.k.booleanValue());
            if (this.f43650a.k.booleanValue()) {
                this.f43651b.setCanceledOnTouchOutside(false);
            }
            this.f43651b.setOnCancelListener(this.f43650a.l);
            this.f43651b.setOnDismissListener(this.f43650a.m);
            this.f43651b.setOnShowListener(this.f43650a.n);
            DialogInterface.OnKeyListener onKeyListener = this.f43650a.q;
            if (onKeyListener != null) {
                this.f43651b.setOnKeyListener(onKeyListener);
            }
            Z();
            b bVar = this.f43650a;
            c cVar = bVar.A;
            if (cVar != null) {
                cVar.a(this.f43651b, bVar);
            }
            this.f43651b.f(this);
            return this.f43651b;
        }

        public Resources d() {
            return this.f43652c.getResources();
        }

        public ViewGroup e() {
            return this.f43650a.p;
        }

        public a f(boolean z) {
            this.f43650a.f43664a.setVisibility(z ? 8 : 0);
            return this;
        }

        public TextView g() {
            int i2;
            TextView textView;
            TextView textView2 = this.f43650a.f43668e;
            if (textView2 == null || textView2.getVisibility() != 0) {
                i2 = 0;
                textView = null;
            } else {
                textView = this.f43650a.f43668e;
                i2 = 1;
            }
            TextView textView3 = this.f43650a.f43669f;
            if (textView3 != null && textView3.getVisibility() == 0) {
                i2++;
                textView = this.f43650a.f43669f;
            }
            TextView textView4 = this.f43650a.f43670g;
            if (textView4 != null && textView4.getVisibility() == 0) {
                i2++;
                textView = this.f43650a.f43670g;
            }
            if (i2 != 1) {
                return null;
            }
            return textView;
        }

        public g h(Context context) {
            return new g(context, d.a.h0.a.i.NoTitleDialog);
        }

        public a i(boolean z) {
            ViewGroup.LayoutParams layoutParams = this.f43650a.v.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, z ? 0 : this.f43652c.getResources().getDimensionPixelSize(d.a.h0.a.d.aiapps_dialog_content_margin_top), 0, 0);
            }
            return this;
        }

        public a j() {
            this.f43650a.B.setPadding(0, 0, 0, 0);
            return this;
        }

        public a k(boolean z) {
            this.f43650a.u.setVisibility(z ? 0 : 8);
            return this;
        }

        public void l(View view, int i2, DialogInterface.OnClickListener onClickListener) {
            if (view == null || onClickListener == null) {
                return;
            }
            view.setOnClickListener(new b(i2, onClickListener));
        }

        public a m(boolean z) {
            this.f43650a.k = Boolean.valueOf(z);
            return this;
        }

        public a n(c cVar) {
            this.f43650a.A = cVar;
            return this;
        }

        public a o(int i2) {
            this.f43650a.F = i2;
            return this;
        }

        public a p(int i2) {
            b bVar = this.f43650a;
            bVar.E = i2;
            bVar.s.setBackgroundResource(i2);
            return this;
        }

        public void q(int i2) {
            this.f43650a.s.getLayoutParams().height = i2;
            this.f43650a.s.requestLayout();
        }

        public void r(int i2) {
            this.f43650a.s.getLayoutParams().width = i2;
            this.f43650a.s.requestLayout();
        }

        public a s(int i2, int i3, int i4, int i5) {
            this.f43650a.C.setPadding(i2, i3, i4, i5);
            return this;
        }

        public a t(int i2) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, i2);
            layoutParams.addRule(2, d.a.h0.a.f.btn_panel);
            this.f43650a.f43671h.setLayoutParams(layoutParams);
            return this;
        }

        public a u(boolean z) {
            if (z) {
                this.f43650a.f43671h.setVisibility(0);
            } else {
                this.f43650a.f43671h.setVisibility(8);
            }
            return this;
        }

        public a v(int i2) {
            this.f43650a.r.setImageResource(i2);
            return this;
        }

        public a w(int i2) {
            if (this.f43650a.f43667d.getVisibility() != 0) {
                this.f43650a.f43667d.setVisibility(0);
            }
            this.f43650a.f43666c.setText(this.f43652c.getText(i2));
            B();
            return this;
        }

        public a x(Spanned spanned) {
            if (this.f43650a.f43667d.getVisibility() != 0) {
                this.f43650a.f43667d.setVisibility(0);
            }
            if (spanned != null) {
                this.f43650a.f43666c.setMovementMethod(LinkMovementMethod.getInstance());
                this.f43650a.f43666c.setText(spanned);
                B();
            }
            return this;
        }

        public a y(String str) {
            if (this.f43650a.f43667d.getVisibility() != 0) {
                this.f43650a.f43667d.setVisibility(0);
            }
            if (str != null) {
                this.f43650a.f43666c.setText(str);
                B();
            }
            return this;
        }

        public a z() {
            this.f43650a.f43666c.setGravity(3);
            return this;
        }
    }

    /* loaded from: classes3.dex */
    public static class b {
        public c A;
        public FrameLayout B;
        public FrameLayout C;
        public View D;

        /* renamed from: a  reason: collision with root package name */
        public LinearLayout f43664a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f43665b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f43666c;

        /* renamed from: d  reason: collision with root package name */
        public LinearLayout f43667d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f43668e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f43669f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f43670g;

        /* renamed from: h  reason: collision with root package name */
        public View f43671h;

        /* renamed from: i  reason: collision with root package name */
        public View f43672i;
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
            this.C = (FrameLayout) viewGroup.findViewById(d.a.h0.a.f.dialog_root);
            this.f43664a = (LinearLayout) viewGroup.findViewById(d.a.h0.a.f.title_panel);
            this.f43665b = (TextView) viewGroup.findViewById(d.a.h0.a.f.dialog_title);
            this.f43666c = (TextView) viewGroup.findViewById(d.a.h0.a.f.dialog_message);
            this.f43667d = (LinearLayout) viewGroup.findViewById(d.a.h0.a.f.dialog_message_content);
            this.f43668e = (TextView) viewGroup.findViewById(d.a.h0.a.f.positive_button);
            this.f43669f = (TextView) viewGroup.findViewById(d.a.h0.a.f.negative_button);
            this.f43670g = (TextView) viewGroup.findViewById(d.a.h0.a.f.neutral_button);
            this.f43672i = viewGroup.findViewById(d.a.h0.a.f.divider3);
            this.j = viewGroup.findViewById(d.a.h0.a.f.divider4);
            this.o = viewGroup.findViewById(d.a.h0.a.f.dialog_customPanel);
            this.p = (FrameLayout) viewGroup.findViewById(d.a.h0.a.f.dialog_custom_content);
            this.r = (ImageView) viewGroup.findViewById(d.a.h0.a.f.dialog_icon);
            this.s = (RelativeLayout) viewGroup.findViewById(d.a.h0.a.f.searchbox_alert_dialog);
            this.f43671h = viewGroup.findViewById(d.a.h0.a.f.divider2);
            this.t = (SwanAppScrollView) viewGroup.findViewById(d.a.h0.a.f.message_scrollview);
            this.u = (LinearLayout) viewGroup.findViewById(d.a.h0.a.f.btn_panel);
            this.v = viewGroup.findViewById(d.a.h0.a.f.dialog_customPanel);
            this.B = (FrameLayout) viewGroup.findViewById(d.a.h0.a.f.dialog_root);
            this.D = viewGroup.findViewById(d.a.h0.a.f.nightmode_mask);
            if (d.a.h0.a.i2.c.k() || d.a.h0.a.i2.c.l()) {
                int dimensionPixelSize = this.f43666c.getResources().getDimensionPixelSize(d.a.h0.a.d.aiapps_dialog_text_padding);
                this.f43666c.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
            }
            int color = this.w.getResources().getColor(d.a.h0.a.c.aiapps_dialog_btn_text_color);
            this.x = color;
            this.y = color;
        }

        public void a(int i2) {
            this.t.setMaxHeight(i2);
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a(g gVar, b bVar);
    }

    public g(Context context, int i2) {
        super(context, i2);
        d();
    }

    public a c() {
        return this.f43649f;
    }

    public void d() {
        setContentView(d.a.h0.a.g.aiapps_alert_dialog);
        getWindow().setLayout(-1, -1);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        EventBusWrapper.post(new d.a.h0.a.q1.b.b.a("hide"));
    }

    public void e(int i2) {
    }

    public void f(a aVar) {
        this.f43649f = aVar;
    }
}
