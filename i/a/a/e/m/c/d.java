package i.a.a.e.m.c;

import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import i.a.a.e.f;
import i.a.a.e.l.e;
import kotlin.jvm.internal.Intrinsics;
import tv.athena.revenue.payui.view.dialog.DialogListener;
/* loaded from: classes8.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final String f68926a = "PayCommonDialog";

    /* renamed from: b  reason: collision with root package name */
    public static final d f68927b = new d();

    /* loaded from: classes8.dex */
    public static final class a implements DialogInterface.OnDismissListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DialogListener f68928e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Dialog f68929f;

        public a(DialogListener dialogListener, Dialog dialog) {
            this.f68928e = dialogListener;
            this.f68929f = dialog;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface dialogInterface) {
            DialogListener dialogListener = this.f68928e;
            if (dialogListener != null) {
                dialogListener.a(DialogListener.ClickArea.ON_DIALOG_DISMISS);
            }
            d.f68927b.a(this.f68929f);
        }
    }

    /* loaded from: classes8.dex */
    public static final class b implements DialogInterface.OnCancelListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DialogListener f68930e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Dialog f68931f;

        public b(DialogListener dialogListener, Dialog dialog) {
            this.f68930e = dialogListener;
            this.f68931f = dialog;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface dialogInterface) {
            DialogListener dialogListener = this.f68930e;
            if (dialogListener != null) {
                dialogListener.a(DialogListener.ClickArea.ON_DIALOG_CANCEL);
            }
            d.f68927b.a(this.f68931f);
        }
    }

    /* loaded from: classes8.dex */
    public static final class c implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DialogListener f68932e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Dialog f68933f;

        public c(DialogListener dialogListener, Dialog dialog) {
            this.f68932e = dialogListener;
            this.f68933f = dialog;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            DialogListener dialogListener = this.f68932e;
            if (dialogListener != null) {
                dialogListener.a(DialogListener.ClickArea.EMPTY_AREA);
            }
            this.f68933f.dismiss();
        }
    }

    /* renamed from: i.a.a.e.m.c.d$d  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class View$OnClickListenerC1946d implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DialogListener f68934e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Dialog f68935f;

        public View$OnClickListenerC1946d(DialogListener dialogListener, Dialog dialog) {
            this.f68934e = dialogListener;
            this.f68935f = dialog;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            DialogListener dialogListener = this.f68934e;
            if (dialogListener != null) {
                dialogListener.a(DialogListener.ClickArea.BUTTOM_AREA);
            }
            this.f68935f.dismiss();
        }
    }

    public final void a(Dialog dialog) {
        if (dialog == null) {
            return;
        }
        Window window = dialog.getWindow();
        Intrinsics.checkExpressionValueIsNotNull(window, "dialog.getWindow()");
        ViewGroup viewGroup = (ViewGroup) window.findViewById(i.a.a.e.c.root_loading);
        ImageView imageView = (ImageView) window.findViewById(i.a.a.e.c.iv_loading_circle);
        if (viewGroup == null || imageView == null) {
            return;
        }
        viewGroup.setVisibility(8);
        Object tag = imageView.getTag();
        if (!(tag instanceof ObjectAnimator)) {
            tag = null;
        }
        ObjectAnimator objectAnimator = (ObjectAnimator) tag;
        if (objectAnimator != null) {
            objectAnimator.cancel();
            imageView.setTag(null);
            d.r.b.a.a.f.d.d.b(f68926a, "hideDialogLoading->oldRotateAnimator.cancel()");
        }
    }

    public final Dialog b(Context context, String str, View view, DialogListener dialogListener) {
        if (!e.f68885a.a(context)) {
            d.r.b.a.a.f.d.d.f(f68926a, "showSimpleNumberInputDialog ActivityInvalid....");
            return null;
        }
        Dialog dialog = new Dialog(context, f.YY_Pay_Common_Dialg);
        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(true);
        dialog.show();
        dialog.setOnDismissListener(new a(dialogListener, dialog));
        dialog.setOnCancelListener(new b(dialogListener, dialog));
        Window window = dialog.getWindow();
        Intrinsics.checkExpressionValueIsNotNull(window, "mDialog.getWindow()");
        window.setGravity(80);
        WindowManager.LayoutParams attributes = window.getAttributes();
        Intrinsics.checkExpressionValueIsNotNull(attributes, "window.getAttributes()");
        attributes.width = -1;
        attributes.height = -2;
        window.setAttributes(attributes);
        window.setWindowAnimations(f.YY_Dialog_Window_Anim);
        window.setContentView(i.a.a.e.d.yy_dialog_pay_common);
        window.findViewById(i.a.a.e.c.rl_root).setOnClickListener(new c(dialogListener, dialog));
        ((Button) window.findViewById(i.a.a.e.c.btn_close)).setOnClickListener(new View$OnClickListenerC1946d(dialogListener, dialog));
        ((TextView) window.findViewById(i.a.a.e.c.tv_title)).setText(str);
        ((ViewGroup) window.findViewById(i.a.a.e.c.container)).addView(view);
        return dialog;
    }

    public final void c(Dialog dialog) {
        if (dialog == null) {
            return;
        }
        Window window = dialog.getWindow();
        Intrinsics.checkExpressionValueIsNotNull(window, "dialog.getWindow()");
        ViewGroup viewGroup = (ViewGroup) window.findViewById(i.a.a.e.c.root_loading);
        ImageView imageView = (ImageView) window.findViewById(i.a.a.e.c.iv_loading_circle);
        if (viewGroup == null || imageView == null) {
            return;
        }
        Object tag = imageView.getTag();
        if (!(tag instanceof ObjectAnimator)) {
            tag = null;
        }
        ObjectAnimator objectAnimator = (ObjectAnimator) tag;
        if (objectAnimator != null) {
            objectAnimator.cancel();
            imageView.setTag(null);
            d.r.b.a.a.f.d.d.b(f68926a, "showDialogLoading->oldRotateAnimator.cancel()");
        }
        viewGroup.setVisibility(0);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "rotation", 0.0f, 360.0f);
        Intrinsics.checkExpressionValueIsNotNull(ofFloat, "ObjectAnimator.ofFloat(i…le, \"rotation\", 0f, 360f)");
        ofFloat.setDuration(1000L);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.setRepeatCount(-1);
        ofFloat.start();
        imageView.setTag(ofFloat);
        d.r.b.a.a.f.d.d.b(f68926a, "showDialogLoading->mRotateAnimator.start()");
    }
}
