package d.a.m0.f.i.j;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.swan.game.ad.component.AdScrollView;
import d.a.m0.f.i.d;
import d.a.m0.f.i.e;
import d.a.m0.f.i.f;
import d.a.m0.f.i.h;
/* loaded from: classes3.dex */
public class a extends Dialog {

    /* renamed from: e  reason: collision with root package name */
    public C1035a f50460e;

    /* renamed from: d.a.m0.f.i.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1035a {

        /* renamed from: a  reason: collision with root package name */
        public b f50461a;

        /* renamed from: b  reason: collision with root package name */
        public final a f50462b;

        /* renamed from: c  reason: collision with root package name */
        public Context f50463c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f50464d = false;

        /* renamed from: e  reason: collision with root package name */
        public int f50465e;

        /* renamed from: d.a.m0.f.i.j.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class View$OnClickListenerC1036a implements View.OnClickListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DialogInterface.OnClickListener f50466e;

            public View$OnClickListenerC1036a(DialogInterface.OnClickListener onClickListener) {
                this.f50466e = onClickListener;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                C1035a.this.f50462b.b(-1);
                C1035a.this.f50462b.dismiss();
                DialogInterface.OnClickListener onClickListener = this.f50466e;
                if (onClickListener != null) {
                    onClickListener.onClick(C1035a.this.f50462b, -1);
                }
            }
        }

        /* renamed from: d.a.m0.f.i.j.a$a$b */
        /* loaded from: classes3.dex */
        public class b implements View.OnClickListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DialogInterface.OnClickListener f50468e;

            public b(DialogInterface.OnClickListener onClickListener) {
                this.f50468e = onClickListener;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                C1035a.this.f50462b.b(-2);
                C1035a.this.f50462b.dismiss();
                DialogInterface.OnClickListener onClickListener = this.f50468e;
                if (onClickListener != null) {
                    onClickListener.onClick(C1035a.this.f50462b, -2);
                }
            }
        }

        public C1035a(Context context) {
            this.f50461a = null;
            a e2 = e(context);
            this.f50462b = e2;
            e2.c(this);
            this.f50463c = context;
            this.f50465e = context.getResources().getDimensionPixelSize(d.a.m0.f.i.c.swan_ad_dialog_btns_height);
            if (this.f50462b.getWindow() != null) {
                this.f50461a = new b((ViewGroup) this.f50462b.getWindow().getDecorView());
            }
        }

        public a a() {
            this.f50462b.setCancelable(this.f50461a.k.booleanValue());
            if (this.f50461a.k.booleanValue()) {
                this.f50462b.setCanceledOnTouchOutside(false);
            }
            this.f50462b.setOnCancelListener(this.f50461a.l);
            this.f50462b.setOnDismissListener(this.f50461a.m);
            this.f50462b.setOnShowListener(this.f50461a.n);
            DialogInterface.OnKeyListener onKeyListener = this.f50461a.p;
            if (onKeyListener != null) {
                this.f50462b.setOnKeyListener(onKeyListener);
            }
            q();
            b bVar = this.f50461a;
            c cVar = bVar.z;
            if (cVar != null) {
                cVar.a(this.f50462b, bVar);
            }
            this.f50462b.c(this);
            return this.f50462b;
        }

        public Resources b() {
            return this.f50463c.getResources();
        }

        public C1035a c(boolean z) {
            this.f50461a.f50470a.setVisibility(z ? 8 : 0);
            return this;
        }

        public TextView d() {
            int i2;
            TextView textView;
            TextView textView2 = this.f50461a.f50474e;
            if (textView2 == null || textView2.getVisibility() != 0) {
                i2 = 0;
                textView = null;
            } else {
                textView = this.f50461a.f50474e;
                i2 = 1;
            }
            TextView textView3 = this.f50461a.f50475f;
            if (textView3 != null && textView3.getVisibility() == 0) {
                i2++;
                textView = this.f50461a.f50475f;
            }
            TextView textView4 = this.f50461a.f50476g;
            if (textView4 != null && textView4.getVisibility() == 0) {
                i2++;
                textView = this.f50461a.f50476g;
            }
            if (i2 != 1) {
                return null;
            }
            return textView;
        }

        public a e(Context context) {
            return new a(context, h.AdNoTitleDialog);
        }

        public C1035a f(int i2, int i3, int i4, int i5) {
            this.f50461a.A.setPadding(i2, i3, i4, i5);
            return this;
        }

        public C1035a g(String str) {
            if (this.f50461a.f50473d.getVisibility() != 0) {
                this.f50461a.f50473d.setVisibility(0);
            }
            if (str != null) {
                this.f50461a.f50472c.setText(str);
                h();
            }
            return this;
        }

        public final void h() {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.f50465e);
            layoutParams.addRule(3, e.dialog_message_content);
            this.f50461a.t.setLayoutParams(layoutParams);
        }

        public C1035a i(int i2, DialogInterface.OnClickListener onClickListener) {
            j(this.f50463c.getText(i2), onClickListener);
            return this;
        }

        public C1035a j(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            if (TextUtils.isEmpty(charSequence)) {
                this.f50461a.f50475f.setVisibility(8);
                if (this.f50461a.f50474e.getVisibility() == 0) {
                    this.f50461a.f50478i.setVisibility(8);
                }
                return this;
            }
            this.f50461a.f50475f.setVisibility(0);
            if (this.f50461a.f50474e.getVisibility() == 0) {
                this.f50461a.f50478i.setVisibility(0);
            }
            this.f50461a.f50475f.setText(charSequence);
            this.f50461a.f50475f.setOnClickListener(new b(onClickListener));
            return this;
        }

        public C1035a k(DialogInterface.OnDismissListener onDismissListener) {
            this.f50461a.m = onDismissListener;
            return this;
        }

        public C1035a l(int i2, DialogInterface.OnClickListener onClickListener) {
            m(this.f50463c.getText(i2), onClickListener);
            return this;
        }

        public C1035a m(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            if (TextUtils.isEmpty(charSequence)) {
                this.f50461a.f50474e.setVisibility(8);
                if (this.f50461a.f50475f.getVisibility() == 0) {
                    this.f50461a.f50478i.setVisibility(8);
                }
                return this;
            }
            this.f50461a.f50474e.setVisibility(0);
            if (this.f50461a.f50475f.getVisibility() == 0) {
                this.f50461a.f50478i.setVisibility(0);
            }
            this.f50461a.f50474e.setText(charSequence);
            this.f50461a.f50474e.setOnClickListener(new View$OnClickListenerC1036a(onClickListener));
            return this;
        }

        public C1035a n(int i2) {
            o(b().getColor(i2));
            return this;
        }

        public C1035a o(int i2) {
            b bVar = this.f50461a;
            bVar.w = i2;
            bVar.f50474e.setTextColor(i2);
            return this;
        }

        public a p() {
            a a2 = a();
            if (this.f50464d && a2.getWindow() != null) {
                a2.getWindow().setType(2003);
            }
            try {
                a2.show();
            } catch (WindowManager.BadTokenException unused) {
            }
            return a2;
        }

        public final void q() {
            int color = b().getColor(d.a.m0.f.i.b.swan_ad_dialog_title_text_color);
            int color2 = b().getColor(d.a.m0.f.i.b.swan_ad_dialog_btn_text_color);
            int color3 = b().getColor(d.a.m0.f.i.b.swan_ad_dialog_btn_text_color);
            int color4 = b().getColor(d.a.m0.f.i.b.swan_ad_box_dialog_message_text_color);
            int color5 = b().getColor(d.a.m0.f.i.b.swan_ad_dialog_gray);
            RelativeLayout relativeLayout = this.f50461a.r;
            Resources b2 = b();
            int i2 = this.f50461a.C;
            if (i2 == -1) {
                i2 = d.swan_ad_dialog_bg_white;
            }
            relativeLayout.setBackground(b2.getDrawable(i2));
            this.f50461a.f50471b.setTextColor(color);
            this.f50461a.f50472c.setTextColor(color4);
            b bVar = this.f50461a;
            TextView textView = bVar.f50474e;
            int i3 = bVar.w;
            if (i3 != color3) {
                color3 = i3;
            }
            textView.setTextColor(color3);
            b bVar2 = this.f50461a;
            int i4 = bVar2.x;
            if (i4 != color2) {
                bVar2.f50475f.setTextColor(i4);
            } else if (bVar2.y != -1) {
                bVar2.f50475f.setTextColor(b().getColorStateList(this.f50461a.y));
            } else {
                bVar2.f50475f.setTextColor(color2);
            }
            this.f50461a.f50476g.setTextColor(color2);
            if (this.f50461a.D != -1) {
                color5 = b().getColor(this.f50461a.D);
            }
            this.f50461a.f50477h.setBackgroundColor(color5);
            this.f50461a.f50478i.setBackgroundColor(color5);
            this.f50461a.j.setBackgroundColor(color5);
            this.f50461a.f50474e.setBackground(b().getDrawable(d.swan_ad_alertdialog_button_day_bg_right_selector));
            this.f50461a.f50475f.setBackground(b().getDrawable(d.swan_ad_alertdialog_button_day_bg_left_selector));
            this.f50461a.f50476g.setBackground(b().getDrawable(d.swan_ad_alertdialog_button_day_bg_all_selector));
            TextView d2 = d();
            if (d2 != null) {
                d2.setBackground(this.f50461a.E ? b().getDrawable(d.swan_ad_alertdialog_button_day_bg_all_selector) : null);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b {
        public FrameLayout A;
        public View B;

        /* renamed from: a  reason: collision with root package name */
        public LinearLayout f50470a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f50471b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f50472c;

        /* renamed from: d  reason: collision with root package name */
        public LinearLayout f50473d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f50474e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f50475f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f50476g;

        /* renamed from: h  reason: collision with root package name */
        public View f50477h;

        /* renamed from: i  reason: collision with root package name */
        public View f50478i;
        public View j;
        public DialogInterface.OnCancelListener l;
        public DialogInterface.OnDismissListener m;
        public DialogInterface.OnShowListener n;
        public FrameLayout o;
        public DialogInterface.OnKeyListener p;
        public ImageView q;
        public RelativeLayout r;
        public AdScrollView s;
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
            this.f50470a = (LinearLayout) viewGroup.findViewById(e.title_panel);
            this.f50471b = (TextView) viewGroup.findViewById(e.dialog_title);
            this.f50472c = (TextView) viewGroup.findViewById(e.dialog_message);
            this.f50473d = (LinearLayout) viewGroup.findViewById(e.dialog_message_content);
            this.f50474e = (TextView) viewGroup.findViewById(e.positive_button);
            this.f50475f = (TextView) viewGroup.findViewById(e.negative_button);
            this.f50476g = (TextView) viewGroup.findViewById(e.neutral_button);
            this.f50478i = viewGroup.findViewById(e.divider3);
            this.j = viewGroup.findViewById(e.divider4);
            this.o = (FrameLayout) viewGroup.findViewById(e.dialog_custom_content);
            this.q = (ImageView) viewGroup.findViewById(e.dialog_icon);
            this.r = (RelativeLayout) viewGroup.findViewById(e.searchbox_alert_dialog);
            this.f50477h = viewGroup.findViewById(e.divider2);
            this.s = (AdScrollView) viewGroup.findViewById(e.message_scrollview);
            this.t = (LinearLayout) viewGroup.findViewById(e.btn_panel);
            this.u = viewGroup.findViewById(e.dialog_customPanel);
            this.A = (FrameLayout) viewGroup.findViewById(e.dialog_root);
            this.B = viewGroup.findViewById(e.nightmode_mask);
            int color = this.v.getResources().getColor(d.a.m0.f.i.b.swan_ad_dialog_btn_text_color);
            this.w = color;
            this.x = color;
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a(a aVar, b bVar);
    }

    public a(Context context, int i2) {
        super(context, i2);
        a();
    }

    public void a() {
        setContentView(f.ng_game_alert_dialog);
        Window window = getWindow();
        if (window != null) {
            window.setLayout(-1, -1);
        }
    }

    public void b(int i2) {
    }

    public void c(C1035a c1035a) {
        this.f50460e = c1035a;
    }

    public void d(String str) {
        C1035a c1035a = this.f50460e;
        if (c1035a != null) {
            c1035a.g(str);
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
    }
}
