package j.a.a.e.q.g;

import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
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
import j.a.a.e.f;
import j.a.a.e.g;
import j.a.a.e.i;
import j.a.a.e.p.q;
import kotlin.jvm.internal.Intrinsics;
import tv.athena.revenue.payui.model.PayFlowType;
import tv.athena.revenue.payui.model.PayViewInfo;
import tv.athena.revenue.payui.view.IViewEventListener;
import tv.athena.revenue.payui.view.dialog.CancelType;
import tv.athena.revenue.payui.view.dialog.PayDialogType;
import tv.athena.revenue.payui.view.dialog.SafeDismissDialog;
/* loaded from: classes4.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "CenterDialogManager";

    /* renamed from: b  reason: collision with root package name */
    public static final b f64815b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static final class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PayDialogType f64816e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Dialog f64817f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ IViewEventListener f64818g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ j.a.a.e.q.g.c f64819h;

        public a(PayDialogType payDialogType, Dialog dialog, IViewEventListener iViewEventListener, j.a.a.e.q.g.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {payDialogType, dialog, iViewEventListener, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64816e = payDialogType;
            this.f64817f = dialog;
            this.f64818g = iViewEventListener;
            this.f64819h = cVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                b bVar = b.f64815b;
                String str = b.a;
                RLog.info(str, "empty click payDialogType:" + this.f64816e.name());
                PayViewInfo payViewInfo = new PayViewInfo();
                payViewInfo.clickArea = CancelType.EMPTY_AREA_CLICK;
                payViewInfo.payDialogType = this.f64816e;
                payViewInfo.viewDialog = this.f64817f;
                IViewEventListener iViewEventListener = this.f64818g;
                if (iViewEventListener == null || !iViewEventListener.onInterceptView(payViewInfo)) {
                    j.a.a.e.q.g.c cVar = this.f64819h;
                    if (cVar != null) {
                        cVar.a(CancelType.EMPTY_AREA_CLICK);
                    }
                    this.f64817f.dismiss();
                }
            }
        }
    }

    /* renamed from: j.a.a.e.q.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static final class View$OnClickListenerC2294b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PayDialogType f64820e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Dialog f64821f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ IViewEventListener f64822g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ j.a.a.e.q.g.c f64823h;

        public View$OnClickListenerC2294b(PayDialogType payDialogType, Dialog dialog, IViewEventListener iViewEventListener, j.a.a.e.q.g.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {payDialogType, dialog, iViewEventListener, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64820e = payDialogType;
            this.f64821f = dialog;
            this.f64822g = iViewEventListener;
            this.f64823h = cVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                b bVar = b.f64815b;
                String str = b.a;
                RLog.info(str, "btn close payDialogType:" + this.f64820e.name());
                PayViewInfo payViewInfo = new PayViewInfo();
                payViewInfo.clickArea = CancelType.BUTTOM_AREA_CLICK;
                payViewInfo.payDialogType = this.f64820e;
                payViewInfo.viewDialog = this.f64821f;
                IViewEventListener iViewEventListener = this.f64822g;
                if (iViewEventListener == null || !iViewEventListener.onInterceptView(payViewInfo)) {
                    j.a.a.e.q.g.c cVar = this.f64823h;
                    if (cVar != null) {
                        cVar.a(CancelType.BUTTOM_AREA_CLICK);
                    }
                    this.f64821f.dismiss();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class c implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j.a.a.e.q.g.c f64824e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SafeDismissDialog f64825f;

        public c(j.a.a.e.q.g.c cVar, SafeDismissDialog safeDismissDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, safeDismissDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64824e = cVar;
            this.f64825f = safeDismissDialog;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                j.a.a.e.q.g.c cVar = this.f64824e;
                if (cVar != null) {
                    cVar.a(CancelType.ON_DIALOG_DISMISS);
                }
                b.f64815b.c(this.f64825f);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class d implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j.a.a.e.q.g.c f64826e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SafeDismissDialog f64827f;

        public d(j.a.a.e.q.g.c cVar, SafeDismissDialog safeDismissDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, safeDismissDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64826e = cVar;
            this.f64827f = safeDismissDialog;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                j.a.a.e.q.g.c cVar = this.f64826e;
                if (cVar != null) {
                    cVar.a(CancelType.ON_DIALOG_CANCEL);
                }
                b.f64815b.c(this.f64827f);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class e implements DialogInterface.OnKeyListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j.a.a.e.q.g.c f64828e;

        public e(j.a.a.e.q.g.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64828e = cVar;
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            j.a.a.e.q.g.c cVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, dialogInterface, i2, keyEvent)) == null) {
                b bVar = b.f64815b;
                String str = b.a;
                RLog.info(str, "onKey keyCode:" + i2);
                if (keyEvent.getAction() == 0 && i2 == 4 && (cVar = this.f64828e) != null) {
                    if (cVar == null) {
                        Intrinsics.throwNpe();
                    }
                    if (cVar.b(dialogInterface)) {
                        return true;
                    }
                }
                return false;
            }
            return invokeLIL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2070741942, "Lj/a/a/e/q/g/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2070741942, "Lj/a/a/e/q/g/b;");
                return;
            }
        }
        f64815b = new b();
    }

    public b() {
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

    public final void c(Dialog dialog) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, dialog) == null) || dialog == null) {
            return;
        }
        Window window = dialog.getWindow();
        Intrinsics.checkExpressionValueIsNotNull(window, "dialog.getWindow()");
        ViewGroup viewGroup = (ViewGroup) window.findViewById(f.root_loading);
        ImageView imageView = (ImageView) window.findViewById(f.iv_loading_circle);
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
            RLog.debug(a, "hideDialogLoading->oldRotateAnimator.cancel()");
        }
    }

    public final void d(Context context, String str, View view, j.a.a.e.q.g.c cVar, IViewEventListener iViewEventListener, PayDialogType payDialogType, Dialog dialog) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, str, view, cVar, iViewEventListener, payDialogType, dialog}) == null) {
            Window window = dialog.getWindow();
            Intrinsics.checkExpressionValueIsNotNull(window, "centerDialog.getWindow()");
            window.setGravity(17);
            WindowManager.LayoutParams attributes = window.getAttributes();
            Intrinsics.checkExpressionValueIsNotNull(attributes, "window.getAttributes()");
            attributes.width = -2;
            attributes.height = -2;
            window.setAttributes(attributes);
            window.setWindowAnimations(i.PayUi_Dialog_Window_Center_Anim);
            window.setContentView(g.pay_ui_center_dialog_pay_common);
            View findViewById = window.findViewById(f.tv_title);
            Intrinsics.checkExpressionValueIsNotNull(findViewById, "window.findViewById<TextView>(R.id.tv_title)");
            ((TextView) findViewById).setText(str);
            window.findViewById(f.rl_root).setOnClickListener(new a(payDialogType, dialog, iViewEventListener, cVar));
            ((Button) window.findViewById(f.btn_close)).setOnClickListener(new View$OnClickListenerC2294b(payDialogType, dialog, iViewEventListener, cVar));
            ((ViewGroup) window.findViewById(f.container)).addView(view);
        }
    }

    public final Dialog e(Context context, String str, View view, j.a.a.e.q.g.c cVar, IViewEventListener iViewEventListener, PayDialogType payDialogType, PayFlowType payFlowType) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{context, str, view, cVar, iViewEventListener, payDialogType, payFlowType})) == null) {
            if (!q.a.a(context)) {
                RLog.info(a, "showDialog ActivityInvalid....");
                return null;
            }
            SafeDismissDialog safeDismissDialog = new SafeDismissDialog(context, i.PayUi_Pay_Common_Dialg, payFlowType);
            safeDismissDialog.setCancelable(true);
            safeDismissDialog.setCanceledOnTouchOutside(false);
            safeDismissDialog.show();
            safeDismissDialog.setOnDismissListener(new c(cVar, safeDismissDialog));
            safeDismissDialog.setOnCancelListener(new d(cVar, safeDismissDialog));
            safeDismissDialog.setOnKeyListener(new e(cVar));
            d(context, str, view, cVar, iViewEventListener, payDialogType, safeDismissDialog);
            return safeDismissDialog;
        }
        return (Dialog) invokeCommon.objValue;
    }
}
