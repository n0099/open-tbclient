package j.a.a.e.o.g;

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
import j.a.a.e.g;
import j.a.a.e.n.n;
import kotlin.jvm.internal.Intrinsics;
import tv.athena.revenue.payui.model.PayViewInfo;
import tv.athena.revenue.payui.view.IViewEventListener;
import tv.athena.revenue.payui.view.dialog.CancelType;
import tv.athena.revenue.payui.view.dialog.PayDialogType;
import tv.athena.revenue.payui.view.dialog.SafeDismissDialog;
/* loaded from: classes3.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "CenterDialogManager";

    /* renamed from: b  reason: collision with root package name */
    public static final b f64248b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static final class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PayDialogType f64249e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Dialog f64250f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ IViewEventListener f64251g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ j.a.a.e.o.g.c f64252h;

        public a(PayDialogType payDialogType, Dialog dialog, IViewEventListener iViewEventListener, j.a.a.e.o.g.c cVar) {
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
            this.f64249e = payDialogType;
            this.f64250f = dialog;
            this.f64251g = iViewEventListener;
            this.f64252h = cVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                b bVar = b.f64248b;
                String str = b.a;
                RLog.info(str, "empty click payDialogType:" + this.f64249e.name());
                PayViewInfo payViewInfo = new PayViewInfo();
                payViewInfo.clickArea = CancelType.EMPTY_AREA_CLICK;
                payViewInfo.payDialogType = this.f64249e;
                payViewInfo.viewDialog = this.f64250f;
                IViewEventListener iViewEventListener = this.f64251g;
                if (iViewEventListener == null || !iViewEventListener.onInterceptView(payViewInfo)) {
                    j.a.a.e.o.g.c cVar = this.f64252h;
                    if (cVar != null) {
                        cVar.a(CancelType.EMPTY_AREA_CLICK);
                    }
                    this.f64250f.dismiss();
                }
            }
        }
    }

    /* renamed from: j.a.a.e.o.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class View$OnClickListenerC2225b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PayDialogType f64253e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Dialog f64254f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ IViewEventListener f64255g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ j.a.a.e.o.g.c f64256h;

        public View$OnClickListenerC2225b(PayDialogType payDialogType, Dialog dialog, IViewEventListener iViewEventListener, j.a.a.e.o.g.c cVar) {
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
            this.f64253e = payDialogType;
            this.f64254f = dialog;
            this.f64255g = iViewEventListener;
            this.f64256h = cVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                b bVar = b.f64248b;
                String str = b.a;
                RLog.info(str, "btn close payDialogType:" + this.f64253e.name());
                PayViewInfo payViewInfo = new PayViewInfo();
                payViewInfo.clickArea = CancelType.BUTTOM_AREA_CLICK;
                payViewInfo.payDialogType = this.f64253e;
                payViewInfo.viewDialog = this.f64254f;
                IViewEventListener iViewEventListener = this.f64255g;
                if (iViewEventListener == null || !iViewEventListener.onInterceptView(payViewInfo)) {
                    j.a.a.e.o.g.c cVar = this.f64256h;
                    if (cVar != null) {
                        cVar.a(CancelType.BUTTOM_AREA_CLICK);
                    }
                    this.f64254f.dismiss();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class c implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j.a.a.e.o.g.c f64257e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SafeDismissDialog f64258f;

        public c(j.a.a.e.o.g.c cVar, SafeDismissDialog safeDismissDialog) {
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
            this.f64257e = cVar;
            this.f64258f = safeDismissDialog;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                j.a.a.e.o.g.c cVar = this.f64257e;
                if (cVar != null) {
                    cVar.a(CancelType.ON_DIALOG_DISMISS);
                }
                b.f64248b.c(this.f64258f);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class d implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j.a.a.e.o.g.c f64259e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SafeDismissDialog f64260f;

        public d(j.a.a.e.o.g.c cVar, SafeDismissDialog safeDismissDialog) {
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
            this.f64259e = cVar;
            this.f64260f = safeDismissDialog;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                j.a.a.e.o.g.c cVar = this.f64259e;
                if (cVar != null) {
                    cVar.a(CancelType.ON_DIALOG_CANCEL);
                }
                b.f64248b.c(this.f64260f);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class e implements DialogInterface.OnKeyListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j.a.a.e.o.g.c f64261e;

        public e(j.a.a.e.o.g.c cVar) {
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
            this.f64261e = cVar;
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            j.a.a.e.o.g.c cVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, dialogInterface, i2, keyEvent)) == null) {
                b bVar = b.f64248b;
                String str = b.a;
                RLog.info(str, "onKey keyCode:" + i2);
                if (keyEvent.getAction() == 0 && i2 == 4 && (cVar = this.f64261e) != null) {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2013483640, "Lj/a/a/e/o/g/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2013483640, "Lj/a/a/e/o/g/b;");
                return;
            }
        }
        f64248b = new b();
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
            RLog.debug(a, "hideDialogLoading->oldRotateAnimator.cancel()");
        }
    }

    public final void d(Context context, String str, View view, j.a.a.e.o.g.c cVar, IViewEventListener iViewEventListener, PayDialogType payDialogType, Dialog dialog) {
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
            window.setWindowAnimations(g.PayUi_Dialog_Window_Center_Anim);
            window.setContentView(j.a.a.e.e.pay_ui_center_dialog_pay_common);
            View findViewById = window.findViewById(j.a.a.e.d.tv_title);
            Intrinsics.checkExpressionValueIsNotNull(findViewById, "window.findViewById<TextView>(R.id.tv_title)");
            ((TextView) findViewById).setText(str);
            window.findViewById(j.a.a.e.d.rl_root).setOnClickListener(new a(payDialogType, dialog, iViewEventListener, cVar));
            ((Button) window.findViewById(j.a.a.e.d.btn_close)).setOnClickListener(new View$OnClickListenerC2225b(payDialogType, dialog, iViewEventListener, cVar));
            ((ViewGroup) window.findViewById(j.a.a.e.d.container)).addView(view);
        }
    }

    public final Dialog e(Context context, String str, View view, j.a.a.e.o.g.c cVar, IViewEventListener iViewEventListener, PayDialogType payDialogType) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{context, str, view, cVar, iViewEventListener, payDialogType})) == null) {
            if (!n.a.a(context)) {
                RLog.info(a, "showDialog ActivityInvalid....");
                return null;
            }
            SafeDismissDialog safeDismissDialog = new SafeDismissDialog(context, g.PayUi_Pay_Common_Dialg);
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
