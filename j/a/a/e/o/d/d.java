package j.a.a.e.o.d;

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
import j.a.a.e.e;
import j.a.a.e.g;
import j.a.a.e.n.i;
import kotlin.jvm.internal.Intrinsics;
import tv.athena.revenue.payui.model.PayViewInfo;
import tv.athena.revenue.payui.view.IViewEventListener;
import tv.athena.revenue.payui.view.dialog.CancelType;
import tv.athena.revenue.payui.view.dialog.PayDialogType;
import tv.athena.revenue.payui.view.dialog.SafeDismissDialog;
/* loaded from: classes2.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f79585a = "PayCommonDialog";

    /* renamed from: b  reason: collision with root package name */
    public static final d f79586b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static final class a implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j.a.a.e.o.d.a f79587e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SafeDismissDialog f79588f;

        public a(j.a.a.e.o.d.a aVar, SafeDismissDialog safeDismissDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, safeDismissDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f79587e = aVar;
            this.f79588f = safeDismissDialog;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                j.a.a.e.o.d.a aVar = this.f79587e;
                if (aVar != null) {
                    aVar.a(CancelType.ON_DIALOG_DISMISS);
                }
                d.f79586b.b(this.f79588f);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class b implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j.a.a.e.o.d.a f79589e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SafeDismissDialog f79590f;

        public b(j.a.a.e.o.d.a aVar, SafeDismissDialog safeDismissDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, safeDismissDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f79589e = aVar;
            this.f79590f = safeDismissDialog;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                j.a.a.e.o.d.a aVar = this.f79589e;
                if (aVar != null) {
                    aVar.a(CancelType.ON_DIALOG_CANCEL);
                }
                d.f79586b.b(this.f79590f);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PayDialogType f79591e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SafeDismissDialog f79592f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ IViewEventListener f79593g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ j.a.a.e.o.d.a f79594h;

        public c(PayDialogType payDialogType, SafeDismissDialog safeDismissDialog, IViewEventListener iViewEventListener, j.a.a.e.o.d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {payDialogType, safeDismissDialog, iViewEventListener, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f79591e = payDialogType;
            this.f79592f = safeDismissDialog;
            this.f79593g = iViewEventListener;
            this.f79594h = aVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                PayViewInfo payViewInfo = new PayViewInfo();
                payViewInfo.clickArea = CancelType.EMPTY_AREA_CLICK;
                payViewInfo.payDialogType = this.f79591e;
                payViewInfo.viewDialog = this.f79592f;
                IViewEventListener iViewEventListener = this.f79593g;
                if (iViewEventListener == null || !iViewEventListener.onInterceptView(payViewInfo)) {
                    j.a.a.e.o.d.a aVar = this.f79594h;
                    if (aVar != null) {
                        aVar.a(CancelType.EMPTY_AREA_CLICK);
                    }
                    d dVar = d.f79586b;
                    String str = d.f79585a;
                    RLog.info(str, "empty click payDialogType:" + this.f79591e.name());
                    this.f79592f.dismiss();
                }
            }
        }
    }

    /* renamed from: j.a.a.e.o.d.d$d  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class View$OnClickListenerC2155d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PayDialogType f79595e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SafeDismissDialog f79596f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ IViewEventListener f79597g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ j.a.a.e.o.d.a f79598h;

        public View$OnClickListenerC2155d(PayDialogType payDialogType, SafeDismissDialog safeDismissDialog, IViewEventListener iViewEventListener, j.a.a.e.o.d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {payDialogType, safeDismissDialog, iViewEventListener, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f79595e = payDialogType;
            this.f79596f = safeDismissDialog;
            this.f79597g = iViewEventListener;
            this.f79598h = aVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                PayViewInfo payViewInfo = new PayViewInfo();
                payViewInfo.clickArea = CancelType.BUTTOM_AREA_CLICK;
                payViewInfo.payDialogType = this.f79595e;
                payViewInfo.viewDialog = this.f79596f;
                IViewEventListener iViewEventListener = this.f79597g;
                if (iViewEventListener == null || !iViewEventListener.onInterceptView(payViewInfo)) {
                    j.a.a.e.o.d.a aVar = this.f79598h;
                    if (aVar != null) {
                        aVar.a(CancelType.BUTTOM_AREA_CLICK);
                    }
                    d dVar = d.f79586b;
                    String str = d.f79585a;
                    RLog.info(str, "btn close payDialogType:" + this.f79595e.name());
                    this.f79596f.dismiss();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2013394329, "Lj/a/a/e/o/d/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2013394329, "Lj/a/a/e/o/d/d;");
                return;
            }
        }
        f79586b = new d();
    }

    public d() {
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
        ViewGroup viewGroup = (ViewGroup) window.findViewById(j.a.a.e.d.root_loading);
        ImageView imageView = (ImageView) window.findViewById(j.a.a.e.d.iv_loading_circle);
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
            RLog.debug(f79585a, "hideDialogLoading->oldRotateAnimator.cancel()");
        }
    }

    public final Dialog c(Context context, String str, View view, j.a.a.e.o.d.a aVar, IViewEventListener iViewEventListener, PayDialogType payDialogType) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, str, view, aVar, iViewEventListener, payDialogType})) == null) {
            if (!i.f79529a.a(context)) {
                RLog.info(f79585a, "showSimpleNumberInputDialog ActivityInvalid....");
                return null;
            }
            SafeDismissDialog safeDismissDialog = new SafeDismissDialog(context, g.PayUi_Pay_Common_Dialg);
            safeDismissDialog.setCancelable(true);
            safeDismissDialog.setCanceledOnTouchOutside(true);
            safeDismissDialog.show();
            safeDismissDialog.setOnDismissListener(new a(aVar, safeDismissDialog));
            safeDismissDialog.setOnCancelListener(new b(aVar, safeDismissDialog));
            Window window = safeDismissDialog.getWindow();
            Intrinsics.checkExpressionValueIsNotNull(window, "mDialog.getWindow()");
            window.setGravity(80);
            WindowManager.LayoutParams attributes = window.getAttributes();
            Intrinsics.checkExpressionValueIsNotNull(attributes, "window.getAttributes()");
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
            window.setWindowAnimations(g.PayUi_Dialog_Window_Anim);
            window.setContentView(e.pay_ui_dialog_pay_common);
            window.findViewById(j.a.a.e.d.rl_root).setOnClickListener(new c(payDialogType, safeDismissDialog, iViewEventListener, aVar));
            ((Button) window.findViewById(j.a.a.e.d.btn_close)).setOnClickListener(new View$OnClickListenerC2155d(payDialogType, safeDismissDialog, iViewEventListener, aVar));
            ((TextView) window.findViewById(j.a.a.e.d.tv_title)).setText(str);
            ((ViewGroup) window.findViewById(j.a.a.e.d.container)).addView(view);
            return safeDismissDialog;
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
        ViewGroup viewGroup = (ViewGroup) window.findViewById(j.a.a.e.d.root_loading);
        ImageView imageView = (ImageView) window.findViewById(j.a.a.e.d.iv_loading_circle);
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
            RLog.debug(f79585a, "showDialogLoading->oldRotateAnimator.cancel()");
        }
        viewGroup.setVisibility(0);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "rotation", 0.0f, 360.0f);
        Intrinsics.checkExpressionValueIsNotNull(ofFloat, "ObjectAnimator.ofFloat(i…le, \"rotation\", 0f, 360f)");
        ofFloat.setDuration(1000L);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.setRepeatCount(-1);
        ofFloat.start();
        imageView.setTag(ofFloat);
        RLog.debug(f79585a, "showDialogLoading->mRotateAnimator.start()");
    }
}
