package i.a.a.e.o.g;

import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.KeyEvent;
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
import i.a.a.e.n.n;
import kotlin.jvm.internal.Intrinsics;
import tv.athena.revenue.payui.model.PayViewInfo;
import tv.athena.revenue.payui.view.IViewEventListener;
import tv.athena.revenue.payui.view.dialog.CancelType;
import tv.athena.revenue.payui.view.dialog.PayDialogType;
import tv.athena.revenue.payui.view.dialog.SafeDismissDialog;
/* loaded from: classes2.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f73319a = "BottomDialogManager";

    /* renamed from: b  reason: collision with root package name */
    public static final a f73320b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: i.a.a.e.o.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class View$OnClickListenerC2110a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PayDialogType f73321e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ i.a.a.e.o.g.c f73322f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Dialog f73323g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ IViewEventListener f73324h;

        public View$OnClickListenerC2110a(PayDialogType payDialogType, i.a.a.e.o.g.c cVar, Dialog dialog, IViewEventListener iViewEventListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {payDialogType, cVar, dialog, iViewEventListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f73321e = payDialogType;
            this.f73322f = cVar;
            this.f73323g = dialog;
            this.f73324h = iViewEventListener;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                a aVar = a.f73320b;
                String str = a.f73319a;
                RLog.info(str, "empty click payDialogType:" + this.f73321e.name());
                i.a.a.e.o.g.c cVar = this.f73322f;
                if (cVar != null) {
                    if (cVar == null) {
                        Intrinsics.throwNpe();
                    }
                    if (cVar.b(this.f73323g)) {
                        a aVar2 = a.f73320b;
                        String str2 = a.f73319a;
                        RLog.info(str2, "empty click intercept " + this.f73321e.name());
                        return;
                    }
                }
                PayViewInfo payViewInfo = new PayViewInfo();
                payViewInfo.clickArea = CancelType.EMPTY_AREA_CLICK;
                payViewInfo.payDialogType = this.f73321e;
                payViewInfo.viewDialog = this.f73323g;
                IViewEventListener iViewEventListener = this.f73324h;
                if (iViewEventListener != null && iViewEventListener.onInterceptView(payViewInfo)) {
                    a aVar3 = a.f73320b;
                    String str3 = a.f73319a;
                    RLog.info(str3, "empty click onInterceptView " + this.f73321e.name());
                    return;
                }
                i.a.a.e.o.g.c cVar2 = this.f73322f;
                if (cVar2 != null) {
                    cVar2.a(CancelType.EMPTY_AREA_CLICK);
                }
                this.f73323g.dismiss();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PayDialogType f73325e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ i.a.a.e.o.g.c f73326f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Dialog f73327g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ IViewEventListener f73328h;

        public b(PayDialogType payDialogType, i.a.a.e.o.g.c cVar, Dialog dialog, IViewEventListener iViewEventListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {payDialogType, cVar, dialog, iViewEventListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f73325e = payDialogType;
            this.f73326f = cVar;
            this.f73327g = dialog;
            this.f73328h = iViewEventListener;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                a aVar = a.f73320b;
                String str = a.f73319a;
                RLog.info(str, "btn close payDialogType:" + this.f73325e.name());
                i.a.a.e.o.g.c cVar = this.f73326f;
                if (cVar != null) {
                    if (cVar == null) {
                        Intrinsics.throwNpe();
                    }
                    if (cVar.b(this.f73327g)) {
                        a aVar2 = a.f73320b;
                        String str2 = a.f73319a;
                        RLog.info(str2, "btn close intercept :" + this.f73325e.name());
                        return;
                    }
                }
                PayViewInfo payViewInfo = new PayViewInfo();
                payViewInfo.clickArea = CancelType.BUTTOM_AREA_CLICK;
                payViewInfo.payDialogType = this.f73325e;
                payViewInfo.viewDialog = this.f73327g;
                IViewEventListener iViewEventListener = this.f73328h;
                if (iViewEventListener != null && iViewEventListener.onInterceptView(payViewInfo)) {
                    a aVar3 = a.f73320b;
                    String str3 = a.f73319a;
                    RLog.info(str3, "btn close onInterceptView :" + this.f73325e.name());
                    return;
                }
                i.a.a.e.o.g.c cVar2 = this.f73326f;
                if (cVar2 != null) {
                    cVar2.a(CancelType.BUTTOM_AREA_CLICK);
                }
                this.f73327g.dismiss();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class c implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i.a.a.e.o.g.c f73329e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SafeDismissDialog f73330f;

        public c(i.a.a.e.o.g.c cVar, SafeDismissDialog safeDismissDialog) {
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
            this.f73329e = cVar;
            this.f73330f = safeDismissDialog;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                i.a.a.e.o.g.c cVar = this.f73329e;
                if (cVar != null) {
                    cVar.a(CancelType.ON_DIALOG_DISMISS);
                }
                a.f73320b.b(this.f73330f);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class d implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i.a.a.e.o.g.c f73331e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SafeDismissDialog f73332f;

        public d(i.a.a.e.o.g.c cVar, SafeDismissDialog safeDismissDialog) {
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
            this.f73331e = cVar;
            this.f73332f = safeDismissDialog;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                i.a.a.e.o.g.c cVar = this.f73331e;
                if (cVar != null) {
                    cVar.a(CancelType.ON_DIALOG_CANCEL);
                }
                a.f73320b.b(this.f73332f);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class e implements DialogInterface.OnKeyListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PayDialogType f73333e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ i.a.a.e.o.g.c f73334f;

        public e(PayDialogType payDialogType, i.a.a.e.o.g.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {payDialogType, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f73333e = payDialogType;
            this.f73334f = cVar;
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            i.a.a.e.o.g.c cVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, dialogInterface, i2, keyEvent)) == null) {
                a aVar = a.f73320b;
                String str = a.f73319a;
                RLog.info(str, "onKey keyCode:" + i2 + " dialogType:" + this.f73333e.name());
                if (keyEvent.getAction() == 0 && i2 == 4 && (cVar = this.f73334f) != null) {
                    if (cVar == null) {
                        Intrinsics.throwNpe();
                    }
                    if (cVar.b(dialogInterface)) {
                        a aVar2 = a.f73320b;
                        String str2 = a.f73319a;
                        RLog.info(str2, "onKey intercept " + this.f73333e.name());
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1775925062, "Li/a/a/e/o/g/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1775925062, "Li/a/a/e/o/g/a;");
                return;
            }
        }
        f73320b = new a();
    }

    public a() {
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
            RLog.debug(f73319a, "hideDialogLoading oldRotateAnimator cancel()");
        }
    }

    public final void c(Context context, String str, View view, i.a.a.e.o.g.c cVar, IViewEventListener iViewEventListener, PayDialogType payDialogType, Dialog dialog) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, str, view, cVar, iViewEventListener, payDialogType, dialog}) == null) {
            Window window = dialog.getWindow();
            Intrinsics.checkExpressionValueIsNotNull(window, "bottomDialog.getWindow()");
            window.setGravity(80);
            WindowManager.LayoutParams attributes = window.getAttributes();
            Intrinsics.checkExpressionValueIsNotNull(attributes, "window.getAttributes()");
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
            window.setWindowAnimations(g.PayUi_Dialog_Window_Anim);
            window.setContentView(i.a.a.e.e.pay_ui_bottom_dialog_pay_common);
            View findViewById = window.findViewById(i.a.a.e.d.tv_title);
            Intrinsics.checkExpressionValueIsNotNull(findViewById, "window.findViewById<TextView>(R.id.tv_title)");
            ((TextView) findViewById).setText(str);
            window.findViewById(i.a.a.e.d.rl_root).setOnClickListener(new View$OnClickListenerC2110a(payDialogType, cVar, dialog, iViewEventListener));
            ((Button) window.findViewById(i.a.a.e.d.btn_close)).setOnClickListener(new b(payDialogType, cVar, dialog, iViewEventListener));
            ((ViewGroup) window.findViewById(i.a.a.e.d.container)).addView(view);
        }
    }

    public final Dialog d(Context context, String str, View view, i.a.a.e.o.g.c cVar, IViewEventListener iViewEventListener, PayDialogType payDialogType) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{context, str, view, cVar, iViewEventListener, payDialogType})) == null) {
            if (!n.f73285a.a(context)) {
                RLog.info(f73319a, "showSimpleNumberInputDialog ActivityInvalid....");
                return null;
            }
            SafeDismissDialog safeDismissDialog = new SafeDismissDialog(context, g.PayUi_Pay_Common_Dialg);
            safeDismissDialog.setCancelable(true);
            safeDismissDialog.setCanceledOnTouchOutside(true);
            safeDismissDialog.show();
            safeDismissDialog.setOnDismissListener(new c(cVar, safeDismissDialog));
            safeDismissDialog.setOnCancelListener(new d(cVar, safeDismissDialog));
            safeDismissDialog.setOnKeyListener(new e(payDialogType, cVar));
            c(context, str, view, cVar, iViewEventListener, payDialogType, safeDismissDialog);
            return safeDismissDialog;
        }
        return (Dialog) invokeCommon.objValue;
    }

    public final void e(Dialog dialog) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, dialog) == null) || dialog == null) {
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
            RLog.debug(f73319a, "showDialogLoading oldRotateAnimator cancel()");
        }
        viewGroup.setVisibility(0);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "rotation", 0.0f, 360.0f);
        Intrinsics.checkExpressionValueIsNotNull(ofFloat, "ObjectAnimator.ofFloat(i…le, \"rotation\", 0f, 360f)");
        ofFloat.setDuration(1000L);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.setRepeatCount(-1);
        ofFloat.start();
        imageView.setTag(ofFloat);
        RLog.debug(f73319a, "showDialogLoading mRotateAnimator start()");
    }
}
