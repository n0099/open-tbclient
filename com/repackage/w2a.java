package com.repackage;

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
import kotlin.jvm.internal.Intrinsics;
import tv.athena.revenue.payui.model.PayFlowType;
import tv.athena.revenue.payui.model.PayViewInfo;
import tv.athena.revenue.payui.view.IViewEventListener;
import tv.athena.revenue.payui.view.dialog.CancelType;
import tv.athena.revenue.payui.view.dialog.PayDialogType;
/* loaded from: classes7.dex */
public final class w2a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "BottomDialogManager";
    public static final w2a b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static final class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PayDialogType a;
        public final /* synthetic */ y2a b;
        public final /* synthetic */ Dialog c;
        public final /* synthetic */ IViewEventListener d;

        public a(PayDialogType payDialogType, y2a y2aVar, Dialog dialog, IViewEventListener iViewEventListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {payDialogType, y2aVar, dialog, iViewEventListener};
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
            this.b = y2aVar;
            this.c = dialog;
            this.d = iViewEventListener;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                w2a w2aVar = w2a.b;
                String str = w2a.a;
                RLog.info(str, "empty click payDialogType:" + this.a.name());
                y2a y2aVar = this.b;
                if (y2aVar != null) {
                    if (y2aVar == null) {
                        Intrinsics.throwNpe();
                    }
                    if (y2aVar.b(this.c)) {
                        w2a w2aVar2 = w2a.b;
                        String str2 = w2a.a;
                        RLog.info(str2, "empty click intercept " + this.a.name());
                        return;
                    }
                }
                PayViewInfo payViewInfo = new PayViewInfo();
                payViewInfo.clickArea = CancelType.EMPTY_AREA_CLICK;
                payViewInfo.payDialogType = this.a;
                payViewInfo.viewDialog = this.c;
                IViewEventListener iViewEventListener = this.d;
                if (iViewEventListener != null && iViewEventListener.onInterceptView(payViewInfo)) {
                    w2a w2aVar3 = w2a.b;
                    String str3 = w2a.a;
                    RLog.info(str3, "empty click onInterceptView " + this.a.name());
                    return;
                }
                y2a y2aVar2 = this.b;
                if (y2aVar2 != null) {
                    y2aVar2.a(CancelType.EMPTY_AREA_CLICK);
                }
                this.c.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PayDialogType a;
        public final /* synthetic */ y2a b;
        public final /* synthetic */ Dialog c;
        public final /* synthetic */ IViewEventListener d;

        public b(PayDialogType payDialogType, y2a y2aVar, Dialog dialog, IViewEventListener iViewEventListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {payDialogType, y2aVar, dialog, iViewEventListener};
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
            this.b = y2aVar;
            this.c = dialog;
            this.d = iViewEventListener;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                w2a w2aVar = w2a.b;
                String str = w2a.a;
                RLog.info(str, "btn close payDialogType:" + this.a.name());
                y2a y2aVar = this.b;
                if (y2aVar != null) {
                    if (y2aVar == null) {
                        Intrinsics.throwNpe();
                    }
                    if (y2aVar.b(this.c)) {
                        w2a w2aVar2 = w2a.b;
                        String str2 = w2a.a;
                        RLog.info(str2, "btn close intercept :" + this.a.name());
                        return;
                    }
                }
                PayViewInfo payViewInfo = new PayViewInfo();
                payViewInfo.clickArea = CancelType.BUTTOM_AREA_CLICK;
                payViewInfo.payDialogType = this.a;
                payViewInfo.viewDialog = this.c;
                IViewEventListener iViewEventListener = this.d;
                if (iViewEventListener != null && iViewEventListener.onInterceptView(payViewInfo)) {
                    w2a w2aVar3 = w2a.b;
                    String str3 = w2a.a;
                    RLog.info(str3, "btn close onInterceptView :" + this.a.name());
                    return;
                }
                y2a y2aVar2 = this.b;
                if (y2aVar2 != null) {
                    y2aVar2.a(CancelType.BUTTOM_AREA_CLICK);
                }
                this.c.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class c implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y2a a;
        public final /* synthetic */ b3a b;

        public c(y2a y2aVar, b3a b3aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y2aVar, b3aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = y2aVar;
            this.b = b3aVar;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                y2a y2aVar = this.a;
                if (y2aVar != null) {
                    y2aVar.a(CancelType.ON_DIALOG_DISMISS);
                }
                w2a.b.b(this.b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class d implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y2a a;
        public final /* synthetic */ b3a b;

        public d(y2a y2aVar, b3a b3aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y2aVar, b3aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = y2aVar;
            this.b = b3aVar;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                y2a y2aVar = this.a;
                if (y2aVar != null) {
                    y2aVar.a(CancelType.ON_DIALOG_CANCEL);
                }
                w2a.b.b(this.b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class e implements DialogInterface.OnKeyListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PayDialogType a;
        public final /* synthetic */ y2a b;

        public e(PayDialogType payDialogType, y2a y2aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {payDialogType, y2aVar};
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
            this.b = y2aVar;
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            y2a y2aVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, dialogInterface, i, keyEvent)) == null) {
                w2a w2aVar = w2a.b;
                String str = w2a.a;
                RLog.info(str, "onKey keyCode:" + i + " dialogType:" + this.a.name());
                if (keyEvent.getAction() == 0 && i == 4 && (y2aVar = this.b) != null) {
                    if (y2aVar == null) {
                        Intrinsics.throwNpe();
                    }
                    if (y2aVar.b(dialogInterface)) {
                        w2a w2aVar2 = w2a.b;
                        String str2 = w2a.a;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755251893, "Lcom/repackage/w2a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755251893, "Lcom/repackage/w2a;");
                return;
            }
        }
        b = new w2a();
    }

    public w2a() {
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
        ViewGroup viewGroup = (ViewGroup) window.findViewById(R.id.obfuscated_res_0x7f091ad4);
        ImageView imageView = (ImageView) window.findViewById(R.id.obfuscated_res_0x7f090faa);
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

    public final void c(Context context, String str, View view2, y2a y2aVar, IViewEventListener iViewEventListener, PayDialogType payDialogType, Dialog dialog) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, str, view2, y2aVar, iViewEventListener, payDialogType, dialog}) == null) {
            Window window = dialog.getWindow();
            Intrinsics.checkExpressionValueIsNotNull(window, "bottomDialog.getWindow()");
            window.setGravity(80);
            WindowManager.LayoutParams attributes = window.getAttributes();
            Intrinsics.checkExpressionValueIsNotNull(attributes, "window.getAttributes()");
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
            window.setWindowAnimations(R.style.obfuscated_res_0x7f10014a);
            window.setContentView(R.layout.obfuscated_res_0x7f0d0640);
            View findViewById = window.findViewById(R.id.obfuscated_res_0x7f0921ff);
            Intrinsics.checkExpressionValueIsNotNull(findViewById, "window.findViewById<TextView>(R.id.tv_title)");
            ((TextView) findViewById).setText(str);
            window.findViewById(R.id.obfuscated_res_0x7f091ac4).setOnClickListener(new a(payDialogType, y2aVar, dialog, iViewEventListener));
            ((Button) window.findViewById(R.id.obfuscated_res_0x7f09040d)).setOnClickListener(new b(payDialogType, y2aVar, dialog, iViewEventListener));
            ((ViewGroup) window.findViewById(R.id.obfuscated_res_0x7f0906b0)).addView(view2);
        }
    }

    public final Dialog d(Context context, String str, View view2, y2a y2aVar, IViewEventListener iViewEventListener, PayDialogType payDialogType, PayFlowType payFlowType) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{context, str, view2, y2aVar, iViewEventListener, payDialogType, payFlowType})) == null) {
            if (!l2a.a.a(context)) {
                RLog.info(a, "showSimpleNumberInputDialog ActivityInvalid....");
                return null;
            }
            b3a b3aVar = new b3a(context, R.style.obfuscated_res_0x7f10014e, payFlowType);
            b3aVar.setCancelable(true);
            b3aVar.setCanceledOnTouchOutside(true);
            b3aVar.show();
            b3aVar.setOnDismissListener(new c(y2aVar, b3aVar));
            b3aVar.setOnCancelListener(new d(y2aVar, b3aVar));
            b3aVar.setOnKeyListener(new e(payDialogType, y2aVar));
            c(context, str, view2, y2aVar, iViewEventListener, payDialogType, b3aVar);
            return b3aVar;
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
        ViewGroup viewGroup = (ViewGroup) window.findViewById(R.id.obfuscated_res_0x7f091ad4);
        ImageView imageView = (ImageView) window.findViewById(R.id.obfuscated_res_0x7f090faa);
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
