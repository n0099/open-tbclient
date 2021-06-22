package i.a.a.e.o.d;

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
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import i.a.a.e.g;
import i.a.a.e.n.h;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import tv.athena.revenue.payui.model.PayViewInfo;
import tv.athena.revenue.payui.view.IViewEventListener;
import tv.athena.revenue.payui.view.dialog.CancelType;
import tv.athena.revenue.payui.view.dialog.PayDialogType;
/* loaded from: classes8.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static final String f72329a = "PayCommonDialog";

    /* renamed from: b  reason: collision with root package name */
    public static final e f72330b = new e();

    /* loaded from: classes8.dex */
    public static final class a implements DialogInterface.OnDismissListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef f72331e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef f72332f;

        public a(Ref.ObjectRef objectRef, Ref.ObjectRef objectRef2) {
            this.f72331e = objectRef;
            this.f72332f = objectRef2;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface dialogInterface) {
            WeakReference weakReference = (WeakReference) this.f72331e.element;
            if ((weakReference != null ? (i.a.a.e.o.d.b) weakReference.get() : null) != null) {
                WeakReference weakReference2 = (WeakReference) this.f72331e.element;
                i.a.a.e.o.d.b bVar = weakReference2 != null ? (i.a.a.e.o.d.b) weakReference2.get() : null;
                if (bVar == null) {
                    Intrinsics.throwNpe();
                }
                bVar.a(CancelType.ON_DIALOG_DISMISS);
            }
            e eVar = e.f72330b;
            WeakReference weakReference3 = (WeakReference) this.f72332f.element;
            eVar.b(weakReference3 != null ? (Dialog) weakReference3.get() : null);
        }
    }

    /* loaded from: classes8.dex */
    public static final class b implements DialogInterface.OnCancelListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef f72333e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef f72334f;

        public b(Ref.ObjectRef objectRef, Ref.ObjectRef objectRef2) {
            this.f72333e = objectRef;
            this.f72334f = objectRef2;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface dialogInterface) {
            WeakReference weakReference = (WeakReference) this.f72333e.element;
            if ((weakReference != null ? (i.a.a.e.o.d.b) weakReference.get() : null) != null) {
                WeakReference weakReference2 = (WeakReference) this.f72333e.element;
                i.a.a.e.o.d.b bVar = weakReference2 != null ? (i.a.a.e.o.d.b) weakReference2.get() : null;
                if (bVar == null) {
                    Intrinsics.throwNpe();
                }
                bVar.a(CancelType.ON_DIALOG_CANCEL);
            }
            e eVar = e.f72330b;
            WeakReference weakReference3 = (WeakReference) this.f72334f.element;
            eVar.b(weakReference3 != null ? (Dialog) weakReference3.get() : null);
        }
    }

    /* loaded from: classes8.dex */
    public static final class c implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PayDialogType f72335e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ f f72336f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ IViewEventListener f72337g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ i.a.a.e.o.d.b f72338h;

        public c(PayDialogType payDialogType, f fVar, IViewEventListener iViewEventListener, i.a.a.e.o.d.b bVar) {
            this.f72335e = payDialogType;
            this.f72336f = fVar;
            this.f72337g = iViewEventListener;
            this.f72338h = bVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            PayViewInfo payViewInfo = new PayViewInfo();
            payViewInfo.clickArea = CancelType.EMPTY_AREA_CLICK;
            payViewInfo.payDialogType = this.f72335e;
            payViewInfo.viewDialog = this.f72336f;
            IViewEventListener iViewEventListener = this.f72337g;
            if (iViewEventListener == null || !iViewEventListener.onInterceptView(payViewInfo)) {
                i.a.a.e.o.d.b bVar = this.f72338h;
                if (bVar != null) {
                    bVar.a(CancelType.EMPTY_AREA_CLICK);
                }
                e eVar = e.f72330b;
                String str = e.f72329a;
                RLog.info(str, "empty click payDialogType:" + this.f72335e.name());
                this.f72336f.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class d implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PayDialogType f72339e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ f f72340f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ IViewEventListener f72341g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ i.a.a.e.o.d.b f72342h;

        public d(PayDialogType payDialogType, f fVar, IViewEventListener iViewEventListener, i.a.a.e.o.d.b bVar) {
            this.f72339e = payDialogType;
            this.f72340f = fVar;
            this.f72341g = iViewEventListener;
            this.f72342h = bVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            PayViewInfo payViewInfo = new PayViewInfo();
            payViewInfo.clickArea = CancelType.BUTTOM_AREA_CLICK;
            payViewInfo.payDialogType = this.f72339e;
            payViewInfo.viewDialog = this.f72340f;
            IViewEventListener iViewEventListener = this.f72341g;
            if (iViewEventListener == null || !iViewEventListener.onInterceptView(payViewInfo)) {
                i.a.a.e.o.d.b bVar = this.f72342h;
                if (bVar != null) {
                    bVar.a(CancelType.BUTTOM_AREA_CLICK);
                }
                e eVar = e.f72330b;
                String str = e.f72329a;
                RLog.info(str, "btn close payDialogType:" + this.f72339e.name());
                this.f72340f.dismiss();
            }
        }
    }

    public final void b(Dialog dialog) {
        if (dialog == null) {
            return;
        }
        Window window = dialog.getWindow();
        Intrinsics.checkExpressionValueIsNotNull(window, "dialog.getWindow()");
        ViewGroup viewGroup = (ViewGroup) window.findViewById(i.a.a.e.d.root_loading);
        ImageView imageView = (ImageView) window.findViewById(i.a.a.e.d.iv_loading_circle);
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
            RLog.debug(f72329a, "hideDialogLoading->oldRotateAnimator.cancel()");
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: T */
    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: T */
    /* JADX DEBUG: Multi-variable search result rejected for r1v13, resolved type: T */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [T, java.lang.ref.WeakReference] */
    public final Dialog c(Context context, String str, View view, i.a.a.e.o.d.b bVar, IViewEventListener iViewEventListener, PayDialogType payDialogType) {
        if (!h.f72272a.a(context)) {
            RLog.info(f72329a, "showSimpleNumberInputDialog ActivityInvalid....");
            return null;
        }
        f fVar = new f(context, g.PayUi_Pay_Common_Dialg);
        fVar.setCancelable(true);
        fVar.setCanceledOnTouchOutside(true);
        fVar.show();
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = new WeakReference(fVar);
        Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        objectRef2.element = bVar != null ? new WeakReference(bVar) : 0;
        fVar.setOnDismissListener(new a(objectRef2, objectRef));
        fVar.setOnCancelListener(new b(objectRef2, objectRef));
        Window window = fVar.getWindow();
        Intrinsics.checkExpressionValueIsNotNull(window, "mDialog.getWindow()");
        window.setGravity(80);
        WindowManager.LayoutParams attributes = window.getAttributes();
        Intrinsics.checkExpressionValueIsNotNull(attributes, "window.getAttributes()");
        attributes.width = -1;
        attributes.height = -2;
        window.setAttributes(attributes);
        window.setWindowAnimations(g.PayUi_Dialog_Window_Anim);
        window.setContentView(i.a.a.e.e.pay_ui_dialog_pay_common);
        window.findViewById(i.a.a.e.d.rl_root).setOnClickListener(new c(payDialogType, fVar, iViewEventListener, bVar));
        ((Button) window.findViewById(i.a.a.e.d.btn_close)).setOnClickListener(new d(payDialogType, fVar, iViewEventListener, bVar));
        ((TextView) window.findViewById(i.a.a.e.d.tv_title)).setText(str);
        ((ViewGroup) window.findViewById(i.a.a.e.d.container)).addView(view);
        return fVar;
    }

    public final void d(Dialog dialog) {
        if (dialog == null) {
            return;
        }
        Window window = dialog.getWindow();
        Intrinsics.checkExpressionValueIsNotNull(window, "dialog.getWindow()");
        ViewGroup viewGroup = (ViewGroup) window.findViewById(i.a.a.e.d.root_loading);
        ImageView imageView = (ImageView) window.findViewById(i.a.a.e.d.iv_loading_circle);
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
            RLog.debug(f72329a, "showDialogLoading->oldRotateAnimator.cancel()");
        }
        viewGroup.setVisibility(0);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "rotation", 0.0f, 360.0f);
        Intrinsics.checkExpressionValueIsNotNull(ofFloat, "ObjectAnimator.ofFloat(i…le, \"rotation\", 0f, 360f)");
        ofFloat.setDuration(1000L);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.setRepeatCount(-1);
        ofFloat.start();
        imageView.setTag(ofFloat);
        RLog.debug(f72329a, "showDialogLoading->mRotateAnimator.start()");
    }
}
