package d.a.l0.a.z1.b.b;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import d.a.l0.a.z1.b.b.h;
/* loaded from: classes3.dex */
public class f extends h {

    /* loaded from: classes3.dex */
    public static class a extends h.a {

        /* renamed from: f  reason: collision with root package name */
        public TextView f46078f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f46079g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f46080h;

        /* renamed from: i  reason: collision with root package name */
        public TextView f46081i;
        public LinearLayout j;
        public LinearLayout k;
        public CheckBox l;

        /* renamed from: d.a.l0.a.z1.b.b.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class DialogInterface$OnKeyListenerC0932a implements DialogInterface.OnKeyListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DialogInterface.OnClickListener f46082e;

            public DialogInterface$OnKeyListenerC0932a(DialogInterface.OnClickListener onClickListener) {
                this.f46082e = onClickListener;
            }

            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
                DialogInterface.OnClickListener onClickListener;
                if (keyEvent.getAction() == 1 && i2 == 4 && keyEvent.getRepeatCount() == 0 && (onClickListener = this.f46082e) != null) {
                    onClickListener.onClick(dialogInterface, a.this.c0());
                    return true;
                }
                return false;
            }
        }

        /* loaded from: classes3.dex */
        public class b implements View.OnClickListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DialogInterface.OnClickListener f46084e;

            public b(DialogInterface.OnClickListener onClickListener) {
                this.f46084e = onClickListener;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DialogInterface.OnClickListener onClickListener = this.f46084e;
                if (onClickListener != null) {
                    a aVar = a.this;
                    onClickListener.onClick(aVar.f46094b, aVar.c0());
                }
            }
        }

        /* loaded from: classes3.dex */
        public class c implements View.OnClickListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DialogInterface.OnClickListener f46086e;

            public c(DialogInterface.OnClickListener onClickListener) {
                this.f46086e = onClickListener;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DialogInterface.OnClickListener onClickListener = this.f46086e;
                if (onClickListener != null) {
                    a aVar = a.this;
                    onClickListener.onClick(aVar.f46094b, aVar.c0());
                }
            }
        }

        /* loaded from: classes3.dex */
        public class d implements DialogInterface.OnShowListener {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ DialogInterface.OnShowListener f46088a;

            public d(a aVar, DialogInterface.OnShowListener onShowListener) {
                this.f46088a = onShowListener;
            }

            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                DialogInterface.OnShowListener onShowListener = this.f46088a;
                if (onShowListener != null) {
                    onShowListener.onShow(dialogInterface);
                }
            }
        }

        /* loaded from: classes3.dex */
        public class e implements DialogInterface.OnDismissListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DialogInterface.OnDismissListener f46089e;

            public e(a aVar, DialogInterface.OnDismissListener onDismissListener) {
                this.f46089e = onDismissListener;
            }

            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                DialogInterface.OnDismissListener onDismissListener = this.f46089e;
                if (onDismissListener != null) {
                    onDismissListener.onDismiss(dialogInterface);
                }
            }
        }

        public a(Context context) {
            super(context);
            n(new d.a.l0.a.w2.h.a());
            ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(d.a.l0.a.g.swan_app_auth_hover_dialog, e(), false);
            W(viewGroup);
            this.j = (LinearLayout) viewGroup.findViewById(d.a.l0.a.f.auth_layout);
            this.f46080h = (TextView) viewGroup.findViewById(d.a.l0.a.f.auth_negative_button);
            this.f46081i = (TextView) viewGroup.findViewById(d.a.l0.a.f.auth_positive_button);
            this.k = (LinearLayout) viewGroup.findViewById(d.a.l0.a.f.know_it_layout);
            this.l = (CheckBox) viewGroup.findViewById(d.a.l0.a.f.hover_dialog_not_tips);
            this.f46078f = (TextView) viewGroup.findViewById(d.a.l0.a.f.hover_dialog_title);
            this.f46079g = (TextView) viewGroup.findViewById(d.a.l0.a.f.hover_dialog_tip);
            this.l.setCompoundDrawablesWithIntrinsicBounds(context.getResources().getDrawable(d.a.l0.a.e.swanapp_hover_dialog_tip_selector), (Drawable) null, (Drawable) null, (Drawable) null);
            this.k.setVisibility(8);
            this.j.setVisibility(0);
            this.l.setVisibility(0);
            this.f46094b.setCancelable(false);
        }

        @Override // d.a.l0.a.z1.b.b.h.a
        public /* bridge */ /* synthetic */ h.a N(DialogInterface.OnShowListener onShowListener) {
            j0(onShowListener);
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.z1.b.b.h.a
        /* renamed from: b0 */
        public f c() {
            return (f) super.c();
        }

        public final int c0() {
            return this.l.isChecked() ? 1 : 0;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.z1.b.b.h.a
        /* renamed from: d0 */
        public f h(Context context) {
            return new f(context);
        }

        public a e0(String str) {
            this.f46079g.setText(str);
            return this;
        }

        public a f0(String str) {
            this.f46078f.setText(str);
            return this;
        }

        public a g0(DialogInterface.OnClickListener onClickListener) {
            this.f46080h.setOnClickListener(new b(onClickListener));
            return this;
        }

        public a h0(DialogInterface.OnClickListener onClickListener) {
            super.M(new DialogInterface$OnKeyListenerC0932a(onClickListener));
            return this;
        }

        public a i0(DialogInterface.OnDismissListener onDismissListener) {
            super.L(new e(this, onDismissListener));
            return this;
        }

        public a j0(DialogInterface.OnShowListener onShowListener) {
            super.N(new d(this, onShowListener));
            return this;
        }

        public a k0(DialogInterface.OnClickListener onClickListener) {
            this.f46081i.setOnClickListener(new c(onClickListener));
            return this;
        }
    }

    public f(Context context) {
        super(context, d.a.l0.a.i.SwanAppNoTitleDialog);
        a(false);
        Window window = getWindow();
        if (window != null) {
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setWindowAnimations(d.a.l0.a.i.action_sheet_animation);
        }
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        h.a c2 = c();
        c2.p(d.a.l0.a.e.aiapps_action_sheet_bg);
        c2.f(true);
        c2.k(false);
        c2.j();
        c2.t(false);
    }
}
