package h.a.a.e.i.g;

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
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import h.a.a.e.h.q;
import kotlin.jvm.internal.Intrinsics;
import tv.athena.revenue.payui.model.PayFlowType;
import tv.athena.revenue.payui.model.PayViewInfo;
import tv.athena.revenue.payui.view.IViewEventListener;
import tv.athena.revenue.payui.view.dialog.CancelType;
import tv.athena.revenue.payui.view.dialog.PayDialogType;
/* loaded from: classes7.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "BottomDialogManager";

    /* renamed from: b  reason: collision with root package name */
    public static final b f45232b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static final class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PayDialogType a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ h.a.a.e.i.g.d f45233b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Dialog f45234c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ IViewEventListener f45235d;

        public a(PayDialogType payDialogType, h.a.a.e.i.g.d dVar, Dialog dialog, IViewEventListener iViewEventListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {payDialogType, dVar, dialog, iViewEventListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = payDialogType;
            this.f45233b = dVar;
            this.f45234c = dialog;
            this.f45235d = iViewEventListener;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                b bVar = b.f45232b;
                String str = b.a;
                RLog.info(str, "empty click payDialogType:" + this.a.name());
                h.a.a.e.i.g.d dVar = this.f45233b;
                if (dVar != null) {
                    if (dVar == null) {
                        Intrinsics.throwNpe();
                    }
                    if (dVar.b(this.f45234c)) {
                        b bVar2 = b.f45232b;
                        String str2 = b.a;
                        RLog.info(str2, "empty click intercept " + this.a.name());
                        return;
                    }
                }
                PayViewInfo payViewInfo = new PayViewInfo();
                payViewInfo.clickArea = CancelType.EMPTY_AREA_CLICK;
                payViewInfo.payDialogType = this.a;
                payViewInfo.viewDialog = this.f45234c;
                IViewEventListener iViewEventListener = this.f45235d;
                if (iViewEventListener != null && iViewEventListener.onInterceptView(payViewInfo)) {
                    b bVar3 = b.f45232b;
                    String str3 = b.a;
                    RLog.info(str3, "empty click onInterceptView " + this.a.name());
                    return;
                }
                h.a.a.e.i.g.d dVar2 = this.f45233b;
                if (dVar2 != null) {
                    dVar2.a(CancelType.EMPTY_AREA_CLICK);
                }
                this.f45234c.dismiss();
            }
        }
    }

    /* renamed from: h.a.a.e.i.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class View$OnClickListenerC2155b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PayDialogType a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ h.a.a.e.i.g.d f45236b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Dialog f45237c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ IViewEventListener f45238d;

        public View$OnClickListenerC2155b(PayDialogType payDialogType, h.a.a.e.i.g.d dVar, Dialog dialog, IViewEventListener iViewEventListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {payDialogType, dVar, dialog, iViewEventListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = payDialogType;
            this.f45236b = dVar;
            this.f45237c = dialog;
            this.f45238d = iViewEventListener;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                b bVar = b.f45232b;
                String str = b.a;
                RLog.info(str, "btn close payDialogType:" + this.a.name());
                h.a.a.e.i.g.d dVar = this.f45236b;
                if (dVar != null) {
                    if (dVar == null) {
                        Intrinsics.throwNpe();
                    }
                    if (dVar.b(this.f45237c)) {
                        b bVar2 = b.f45232b;
                        String str2 = b.a;
                        RLog.info(str2, "btn close intercept :" + this.a.name());
                        return;
                    }
                }
                PayViewInfo payViewInfo = new PayViewInfo();
                payViewInfo.clickArea = CancelType.BUTTOM_AREA_CLICK;
                payViewInfo.payDialogType = this.a;
                payViewInfo.viewDialog = this.f45237c;
                IViewEventListener iViewEventListener = this.f45238d;
                if (iViewEventListener != null && iViewEventListener.onInterceptView(payViewInfo)) {
                    b bVar3 = b.f45232b;
                    String str3 = b.a;
                    RLog.info(str3, "btn close onInterceptView :" + this.a.name());
                    return;
                }
                h.a.a.e.i.g.d dVar2 = this.f45236b;
                if (dVar2 != null) {
                    dVar2.a(CancelType.BUTTOM_AREA_CLICK);
                }
                this.f45237c.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class c implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h.a.a.e.i.g.d a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g f45239b;

        public c(h.a.a.e.i.g.d dVar, g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
            this.f45239b = gVar;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                h.a.a.e.i.g.d dVar = this.a;
                if (dVar != null) {
                    dVar.a(CancelType.ON_DIALOG_DISMISS);
                }
                b.f45232b.b(this.f45239b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class d implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h.a.a.e.i.g.d a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g f45240b;

        public d(h.a.a.e.i.g.d dVar, g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
            this.f45240b = gVar;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                h.a.a.e.i.g.d dVar = this.a;
                if (dVar != null) {
                    dVar.a(CancelType.ON_DIALOG_CANCEL);
                }
                b.f45232b.b(this.f45240b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class e implements DialogInterface.OnKeyListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PayDialogType a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ h.a.a.e.i.g.d f45241b;

        public e(PayDialogType payDialogType, h.a.a.e.i.g.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {payDialogType, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = payDialogType;
            this.f45241b = dVar;
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            h.a.a.e.i.g.d dVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, dialogInterface, i, keyEvent)) == null) {
                b bVar = b.f45232b;
                String str = b.a;
                RLog.info(str, "onKey keyCode:" + i + " dialogType:" + this.a.name());
                if (keyEvent.getAction() == 0 && i == 4 && (dVar = this.f45241b) != null) {
                    if (dVar == null) {
                        Intrinsics.throwNpe();
                    }
                    if (dVar.b(dialogInterface)) {
                        b bVar2 = b.f45232b;
                        String str2 = b.a;
                        RLog.info(str2, "onKey intercept " + this.a.name());
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1442141312, "Lh/a/a/e/i/g/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1442141312, "Lh/a/a/e/i/g/b;");
                return;
            }
        }
        f45232b = new b();
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
        ViewGroup viewGroup = (ViewGroup) window.findViewById(R.id.obfuscated_res_0x7f091ae6);
        ImageView imageView = (ImageView) window.findViewById(R.id.obfuscated_res_0x7f090fe1);
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
            RLog.debug(a, "hideDialogLoading oldRotateAnimator cancel()");
        }
    }

    public final void c(Context context, String str, View view, h.a.a.e.i.g.d dVar, IViewEventListener iViewEventListener, PayDialogType payDialogType, Dialog dialog) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, str, view, dVar, iViewEventListener, payDialogType, dialog}) == null) {
            Window window = dialog.getWindow();
            Intrinsics.checkExpressionValueIsNotNull(window, "bottomDialog.getWindow()");
            window.setGravity(80);
            WindowManager.LayoutParams attributes = window.getAttributes();
            Intrinsics.checkExpressionValueIsNotNull(attributes, "window.getAttributes()");
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
            window.setWindowAnimations(R.style.obfuscated_res_0x7f10014a);
            window.setContentView(R.layout.obfuscated_res_0x7f0d065c);
            View findViewById = window.findViewById(R.id.obfuscated_res_0x7f09221e);
            Intrinsics.checkExpressionValueIsNotNull(findViewById, "window.findViewById<TextView>(R.id.tv_title)");
            ((TextView) findViewById).setText(str);
            window.findViewById(R.id.obfuscated_res_0x7f091ad6).setOnClickListener(new a(payDialogType, dVar, dialog, iViewEventListener));
            ((Button) window.findViewById(R.id.obfuscated_res_0x7f09040d)).setOnClickListener(new View$OnClickListenerC2155b(payDialogType, dVar, dialog, iViewEventListener));
            ((ViewGroup) window.findViewById(R.id.obfuscated_res_0x7f0906c9)).addView(view);
        }
    }

    public final Dialog d(Context context, String str, View view, h.a.a.e.i.g.d dVar, IViewEventListener iViewEventListener, PayDialogType payDialogType, PayFlowType payFlowType) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{context, str, view, dVar, iViewEventListener, payDialogType, payFlowType})) == null) {
            if (!q.a.a(context)) {
                RLog.info(a, "showSimpleNumberInputDialog ActivityInvalid....");
                return null;
            }
            g gVar = new g(context, R.style.obfuscated_res_0x7f10014e, payFlowType);
            gVar.setCancelable(true);
            gVar.setCanceledOnTouchOutside(true);
            gVar.show();
            gVar.setOnDismissListener(new c(dVar, gVar));
            gVar.setOnCancelListener(new d(dVar, gVar));
            gVar.setOnKeyListener(new e(payDialogType, dVar));
            c(context, str, view, dVar, iViewEventListener, payDialogType, gVar);
            return gVar;
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
        ViewGroup viewGroup = (ViewGroup) window.findViewById(R.id.obfuscated_res_0x7f091ae6);
        ImageView imageView = (ImageView) window.findViewById(R.id.obfuscated_res_0x7f090fe1);
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
            RLog.debug(a, "showDialogLoading oldRotateAnimator cancel()");
        }
        viewGroup.setVisibility(0);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "rotation", 0.0f, 360.0f);
        Intrinsics.checkExpressionValueIsNotNull(ofFloat, "ObjectAnimator.ofFloat(i…le, \"rotation\", 0f, 360f)");
        ofFloat.setDuration(1000L);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.setRepeatCount(-1);
        ofFloat.start();
        imageView.setTag(ofFloat);
        RLog.debug(a, "showDialogLoading mRotateAnimator start()");
    }
}
