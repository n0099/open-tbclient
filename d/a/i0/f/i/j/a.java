package d.a.i0.f.i.j;

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
import d.a.i0.f.i.d;
import d.a.i0.f.i.e;
import d.a.i0.f.i.f;
import d.a.i0.f.i.h;
/* loaded from: classes3.dex */
public class a extends Dialog {

    /* renamed from: e  reason: collision with root package name */
    public C0965a f46502e;

    /* renamed from: d.a.i0.f.i.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0965a {

        /* renamed from: a  reason: collision with root package name */
        public b f46503a;

        /* renamed from: b  reason: collision with root package name */
        public final a f46504b;

        /* renamed from: c  reason: collision with root package name */
        public Context f46505c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f46506d = false;

        /* renamed from: e  reason: collision with root package name */
        public int f46507e;

        /* renamed from: d.a.i0.f.i.j.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class View$OnClickListenerC0966a implements View.OnClickListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DialogInterface.OnClickListener f46508e;

            public View$OnClickListenerC0966a(DialogInterface.OnClickListener onClickListener) {
                this.f46508e = onClickListener;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                C0965a.this.f46504b.b(-1);
                C0965a.this.f46504b.dismiss();
                DialogInterface.OnClickListener onClickListener = this.f46508e;
                if (onClickListener != null) {
                    onClickListener.onClick(C0965a.this.f46504b, -1);
                }
            }
        }

        /* renamed from: d.a.i0.f.i.j.a$a$b */
        /* loaded from: classes3.dex */
        public class b implements View.OnClickListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DialogInterface.OnClickListener f46510e;

            public b(DialogInterface.OnClickListener onClickListener) {
                this.f46510e = onClickListener;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                C0965a.this.f46504b.b(-2);
                C0965a.this.f46504b.dismiss();
                DialogInterface.OnClickListener onClickListener = this.f46510e;
                if (onClickListener != null) {
                    onClickListener.onClick(C0965a.this.f46504b, -2);
                }
            }
        }

        public C0965a(Context context) {
            this.f46503a = null;
            a e2 = e(context);
            this.f46504b = e2;
            e2.c(this);
            this.f46505c = context;
            this.f46507e = context.getResources().getDimensionPixelSize(d.a.i0.f.i.c.swan_ad_dialog_btns_height);
            if (this.f46504b.getWindow() != null) {
                this.f46503a = new b((ViewGroup) this.f46504b.getWindow().getDecorView());
            }
        }

        public a a() {
            this.f46504b.setCancelable(this.f46503a.k.booleanValue());
            if (this.f46503a.k.booleanValue()) {
                this.f46504b.setCanceledOnTouchOutside(false);
            }
            this.f46504b.setOnCancelListener(this.f46503a.l);
            this.f46504b.setOnDismissListener(this.f46503a.m);
            this.f46504b.setOnShowListener(this.f46503a.n);
            DialogInterface.OnKeyListener onKeyListener = this.f46503a.p;
            if (onKeyListener != null) {
                this.f46504b.setOnKeyListener(onKeyListener);
            }
            q();
            b bVar = this.f46503a;
            c cVar = bVar.z;
            if (cVar != null) {
                cVar.a(this.f46504b, bVar);
            }
            this.f46504b.c(this);
            return this.f46504b;
        }

        public Resources b() {
            return this.f46505c.getResources();
        }

        public C0965a c(boolean z) {
            this.f46503a.f46512a.setVisibility(z ? 8 : 0);
            return this;
        }

        public TextView d() {
            int i2;
            TextView textView;
            TextView textView2 = this.f46503a.f46516e;
            if (textView2 == null || textView2.getVisibility() != 0) {
                i2 = 0;
                textView = null;
            } else {
                textView = this.f46503a.f46516e;
                i2 = 1;
            }
            TextView textView3 = this.f46503a.f46517f;
            if (textView3 != null && textView3.getVisibility() == 0) {
                i2++;
                textView = this.f46503a.f46517f;
            }
            TextView textView4 = this.f46503a.f46518g;
            if (textView4 != null && textView4.getVisibility() == 0) {
                i2++;
                textView = this.f46503a.f46518g;
            }
            if (i2 != 1) {
                return null;
            }
            return textView;
        }

        public a e(Context context) {
            return new a(context, h.AdNoTitleDialog);
        }

        public C0965a f(int i2, int i3, int i4, int i5) {
            this.f46503a.A.setPadding(i2, i3, i4, i5);
            return this;
        }

        public C0965a g(String str) {
            if (this.f46503a.f46515d.getVisibility() != 0) {
                this.f46503a.f46515d.setVisibility(0);
            }
            if (str != null) {
                this.f46503a.f46514c.setText(str);
                h();
            }
            return this;
        }

        public final void h() {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.f46507e);
            layoutParams.addRule(3, e.dialog_message_content);
            this.f46503a.t.setLayoutParams(layoutParams);
        }

        public C0965a i(int i2, DialogInterface.OnClickListener onClickListener) {
            j(this.f46505c.getText(i2), onClickListener);
            return this;
        }

        public C0965a j(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            if (TextUtils.isEmpty(charSequence)) {
                this.f46503a.f46517f.setVisibility(8);
                if (this.f46503a.f46516e.getVisibility() == 0) {
                    this.f46503a.f46520i.setVisibility(8);
                }
                return this;
            }
            this.f46503a.f46517f.setVisibility(0);
            if (this.f46503a.f46516e.getVisibility() == 0) {
                this.f46503a.f46520i.setVisibility(0);
            }
            this.f46503a.f46517f.setText(charSequence);
            this.f46503a.f46517f.setOnClickListener(new b(onClickListener));
            return this;
        }

        public C0965a k(DialogInterface.OnDismissListener onDismissListener) {
            this.f46503a.m = onDismissListener;
            return this;
        }

        public C0965a l(int i2, DialogInterface.OnClickListener onClickListener) {
            m(this.f46505c.getText(i2), onClickListener);
            return this;
        }

        public C0965a m(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            if (TextUtils.isEmpty(charSequence)) {
                this.f46503a.f46516e.setVisibility(8);
                if (this.f46503a.f46517f.getVisibility() == 0) {
                    this.f46503a.f46520i.setVisibility(8);
                }
                return this;
            }
            this.f46503a.f46516e.setVisibility(0);
            if (this.f46503a.f46517f.getVisibility() == 0) {
                this.f46503a.f46520i.setVisibility(0);
            }
            this.f46503a.f46516e.setText(charSequence);
            this.f46503a.f46516e.setOnClickListener(new View$OnClickListenerC0966a(onClickListener));
            return this;
        }

        public C0965a n(int i2) {
            o(b().getColor(i2));
            return this;
        }

        public C0965a o(int i2) {
            b bVar = this.f46503a;
            bVar.w = i2;
            bVar.f46516e.setTextColor(i2);
            return this;
        }

        public a p() {
            a a2 = a();
            if (this.f46506d && a2.getWindow() != null) {
                a2.getWindow().setType(2003);
            }
            try {
                a2.show();
            } catch (WindowManager.BadTokenException unused) {
            }
            return a2;
        }

        public final void q() {
            int color = b().getColor(d.a.i0.f.i.b.swan_ad_dialog_title_text_color);
            int color2 = b().getColor(d.a.i0.f.i.b.swan_ad_dialog_btn_text_color);
            int color3 = b().getColor(d.a.i0.f.i.b.swan_ad_dialog_btn_text_color);
            int color4 = b().getColor(d.a.i0.f.i.b.swan_ad_box_dialog_message_text_color);
            int color5 = b().getColor(d.a.i0.f.i.b.swan_ad_dialog_gray);
            RelativeLayout relativeLayout = this.f46503a.r;
            Resources b2 = b();
            int i2 = this.f46503a.C;
            if (i2 == -1) {
                i2 = d.swan_ad_dialog_bg_white;
            }
            relativeLayout.setBackground(b2.getDrawable(i2));
            this.f46503a.f46513b.setTextColor(color);
            this.f46503a.f46514c.setTextColor(color4);
            b bVar = this.f46503a;
            TextView textView = bVar.f46516e;
            int i3 = bVar.w;
            if (i3 != color3) {
                color3 = i3;
            }
            textView.setTextColor(color3);
            b bVar2 = this.f46503a;
            int i4 = bVar2.x;
            if (i4 != color2) {
                bVar2.f46517f.setTextColor(i4);
            } else if (bVar2.y != -1) {
                bVar2.f46517f.setTextColor(b().getColorStateList(this.f46503a.y));
            } else {
                bVar2.f46517f.setTextColor(color2);
            }
            this.f46503a.f46518g.setTextColor(color2);
            if (this.f46503a.D != -1) {
                color5 = b().getColor(this.f46503a.D);
            }
            this.f46503a.f46519h.setBackgroundColor(color5);
            this.f46503a.f46520i.setBackgroundColor(color5);
            this.f46503a.j.setBackgroundColor(color5);
            this.f46503a.f46516e.setBackground(b().getDrawable(d.swan_ad_alertdialog_button_day_bg_right_selector));
            this.f46503a.f46517f.setBackground(b().getDrawable(d.swan_ad_alertdialog_button_day_bg_left_selector));
            this.f46503a.f46518g.setBackground(b().getDrawable(d.swan_ad_alertdialog_button_day_bg_all_selector));
            TextView d2 = d();
            if (d2 != null) {
                d2.setBackground(this.f46503a.E ? b().getDrawable(d.swan_ad_alertdialog_button_day_bg_all_selector) : null);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b {
        public FrameLayout A;
        public View B;

        /* renamed from: a  reason: collision with root package name */
        public LinearLayout f46512a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f46513b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f46514c;

        /* renamed from: d  reason: collision with root package name */
        public LinearLayout f46515d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f46516e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f46517f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f46518g;

        /* renamed from: h  reason: collision with root package name */
        public View f46519h;

        /* renamed from: i  reason: collision with root package name */
        public View f46520i;
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
            this.f46512a = (LinearLayout) viewGroup.findViewById(e.title_panel);
            this.f46513b = (TextView) viewGroup.findViewById(e.dialog_title);
            this.f46514c = (TextView) viewGroup.findViewById(e.dialog_message);
            this.f46515d = (LinearLayout) viewGroup.findViewById(e.dialog_message_content);
            this.f46516e = (TextView) viewGroup.findViewById(e.positive_button);
            this.f46517f = (TextView) viewGroup.findViewById(e.negative_button);
            this.f46518g = (TextView) viewGroup.findViewById(e.neutral_button);
            this.f46520i = viewGroup.findViewById(e.divider3);
            this.j = viewGroup.findViewById(e.divider4);
            this.o = (FrameLayout) viewGroup.findViewById(e.dialog_custom_content);
            this.q = (ImageView) viewGroup.findViewById(e.dialog_icon);
            this.r = (RelativeLayout) viewGroup.findViewById(e.searchbox_alert_dialog);
            this.f46519h = viewGroup.findViewById(e.divider2);
            this.s = (AdScrollView) viewGroup.findViewById(e.message_scrollview);
            this.t = (LinearLayout) viewGroup.findViewById(e.btn_panel);
            this.u = viewGroup.findViewById(e.dialog_customPanel);
            this.A = (FrameLayout) viewGroup.findViewById(e.dialog_root);
            this.B = viewGroup.findViewById(e.nightmode_mask);
            int color = this.v.getResources().getColor(d.a.i0.f.i.b.swan_ad_dialog_btn_text_color);
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

    public void c(C0965a c0965a) {
        this.f46502e = c0965a;
    }

    public void d(String str) {
        C0965a c0965a = this.f46502e;
        if (c0965a != null) {
            c0965a.g(str);
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
    }
}
