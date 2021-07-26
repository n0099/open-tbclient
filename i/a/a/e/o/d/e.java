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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes9.dex */
public final class e {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f73409a = "PayCommonDialog";

    /* renamed from: b  reason: collision with root package name */
    public static final e f73410b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public static final class a implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef f73411e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef f73412f;

        public a(Ref.ObjectRef objectRef, Ref.ObjectRef objectRef2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {objectRef, objectRef2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f73411e = objectRef;
            this.f73412f = objectRef2;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                WeakReference weakReference = (WeakReference) this.f73411e.element;
                if ((weakReference != null ? (i.a.a.e.o.d.b) weakReference.get() : null) != null) {
                    WeakReference weakReference2 = (WeakReference) this.f73411e.element;
                    i.a.a.e.o.d.b bVar = weakReference2 != null ? (i.a.a.e.o.d.b) weakReference2.get() : null;
                    if (bVar == null) {
                        Intrinsics.throwNpe();
                    }
                    bVar.a(CancelType.ON_DIALOG_DISMISS);
                }
                e eVar = e.f73410b;
                WeakReference weakReference3 = (WeakReference) this.f73412f.element;
                eVar.b(weakReference3 != null ? (Dialog) weakReference3.get() : null);
            }
        }
    }

    /* loaded from: classes9.dex */
    public static final class b implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef f73413e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef f73414f;

        public b(Ref.ObjectRef objectRef, Ref.ObjectRef objectRef2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {objectRef, objectRef2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f73413e = objectRef;
            this.f73414f = objectRef2;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                WeakReference weakReference = (WeakReference) this.f73413e.element;
                if ((weakReference != null ? (i.a.a.e.o.d.b) weakReference.get() : null) != null) {
                    WeakReference weakReference2 = (WeakReference) this.f73413e.element;
                    i.a.a.e.o.d.b bVar = weakReference2 != null ? (i.a.a.e.o.d.b) weakReference2.get() : null;
                    if (bVar == null) {
                        Intrinsics.throwNpe();
                    }
                    bVar.a(CancelType.ON_DIALOG_CANCEL);
                }
                e eVar = e.f73410b;
                WeakReference weakReference3 = (WeakReference) this.f73414f.element;
                eVar.b(weakReference3 != null ? (Dialog) weakReference3.get() : null);
            }
        }
    }

    /* loaded from: classes9.dex */
    public static final class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PayDialogType f73415e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ f f73416f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ IViewEventListener f73417g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ i.a.a.e.o.d.b f73418h;

        public c(PayDialogType payDialogType, f fVar, IViewEventListener iViewEventListener, i.a.a.e.o.d.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {payDialogType, fVar, iViewEventListener, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f73415e = payDialogType;
            this.f73416f = fVar;
            this.f73417g = iViewEventListener;
            this.f73418h = bVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                PayViewInfo payViewInfo = new PayViewInfo();
                payViewInfo.clickArea = CancelType.EMPTY_AREA_CLICK;
                payViewInfo.payDialogType = this.f73415e;
                payViewInfo.viewDialog = this.f73416f;
                IViewEventListener iViewEventListener = this.f73417g;
                if (iViewEventListener == null || !iViewEventListener.onInterceptView(payViewInfo)) {
                    i.a.a.e.o.d.b bVar = this.f73418h;
                    if (bVar != null) {
                        bVar.a(CancelType.EMPTY_AREA_CLICK);
                    }
                    e eVar = e.f73410b;
                    String str = e.f73409a;
                    RLog.info(str, "empty click payDialogType:" + this.f73415e.name());
                    this.f73416f.dismiss();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public static final class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PayDialogType f73419e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ f f73420f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ IViewEventListener f73421g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ i.a.a.e.o.d.b f73422h;

        public d(PayDialogType payDialogType, f fVar, IViewEventListener iViewEventListener, i.a.a.e.o.d.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {payDialogType, fVar, iViewEventListener, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f73419e = payDialogType;
            this.f73420f = fVar;
            this.f73421g = iViewEventListener;
            this.f73422h = bVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                PayViewInfo payViewInfo = new PayViewInfo();
                payViewInfo.clickArea = CancelType.BUTTOM_AREA_CLICK;
                payViewInfo.payDialogType = this.f73419e;
                payViewInfo.viewDialog = this.f73420f;
                IViewEventListener iViewEventListener = this.f73421g;
                if (iViewEventListener == null || !iViewEventListener.onInterceptView(payViewInfo)) {
                    i.a.a.e.o.d.b bVar = this.f73422h;
                    if (bVar != null) {
                        bVar.a(CancelType.BUTTOM_AREA_CLICK);
                    }
                    e eVar = e.f73410b;
                    String str = e.f73409a;
                    RLog.info(str, "btn close payDialogType:" + this.f73419e.name());
                    this.f73420f.dismiss();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1776014311, "Li/a/a/e/o/d/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1776014311, "Li/a/a/e/o/d/e;");
                return;
            }
        }
        f73410b = new e();
    }

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public final void b(Dialog dialog) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, dialog) == null) || dialog == null) {
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
            RLog.debug(f73409a, "hideDialogLoading->oldRotateAnimator.cancel()");
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v10, resolved type: T */
    /* JADX DEBUG: Multi-variable search result rejected for r1v22, resolved type: T */
    /* JADX DEBUG: Multi-variable search result rejected for r1v9, resolved type: T */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [T, java.lang.ref.WeakReference] */
    public final Dialog c(Context context, String str, View view, i.a.a.e.o.d.b bVar, IViewEventListener iViewEventListener, PayDialogType payDialogType) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, str, view, bVar, iViewEventListener, payDialogType})) == null) {
            if (!h.f73352a.a(context)) {
                RLog.info(f73409a, "showSimpleNumberInputDialog ActivityInvalid....");
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
        return (Dialog) invokeCommon.objValue;
    }

    public final void d(Dialog dialog) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dialog) == null) || dialog == null) {
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
            RLog.debug(f73409a, "showDialogLoading->oldRotateAnimator.cancel()");
        }
        viewGroup.setVisibility(0);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "rotation", 0.0f, 360.0f);
        Intrinsics.checkExpressionValueIsNotNull(ofFloat, "ObjectAnimator.ofFloat(i…le, \"rotation\", 0f, 360f)");
        ofFloat.setDuration(1000L);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.setRepeatCount(-1);
        ofFloat.start();
        imageView.setTag(ofFloat);
        RLog.debug(f73409a, "showDialogLoading->mRotateAnimator.start()");
    }
}
