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
public final class c {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "CenterDialogManager";

    /* renamed from: b  reason: collision with root package name */
    public static final c f45242b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static final class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PayDialogType a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Dialog f45243b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ IViewEventListener f45244c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ h.a.a.e.i.g.d f45245d;

        public a(PayDialogType payDialogType, Dialog dialog, IViewEventListener iViewEventListener, h.a.a.e.i.g.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {payDialogType, dialog, iViewEventListener, dVar};
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
            this.f45243b = dialog;
            this.f45244c = iViewEventListener;
            this.f45245d = dVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c cVar = c.f45242b;
                String str = c.a;
                RLog.info(str, "empty click payDialogType:" + this.a.name());
                PayViewInfo payViewInfo = new PayViewInfo();
                payViewInfo.clickArea = CancelType.EMPTY_AREA_CLICK;
                payViewInfo.payDialogType = this.a;
                payViewInfo.viewDialog = this.f45243b;
                IViewEventListener iViewEventListener = this.f45244c;
                if (iViewEventListener == null || !iViewEventListener.onInterceptView(payViewInfo)) {
                    h.a.a.e.i.g.d dVar = this.f45245d;
                    if (dVar != null) {
                        dVar.a(CancelType.EMPTY_AREA_CLICK);
                    }
                    this.f45243b.dismiss();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PayDialogType a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Dialog f45246b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ IViewEventListener f45247c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ h.a.a.e.i.g.d f45248d;

        public b(PayDialogType payDialogType, Dialog dialog, IViewEventListener iViewEventListener, h.a.a.e.i.g.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {payDialogType, dialog, iViewEventListener, dVar};
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
            this.f45246b = dialog;
            this.f45247c = iViewEventListener;
            this.f45248d = dVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c cVar = c.f45242b;
                String str = c.a;
                RLog.info(str, "btn close payDialogType:" + this.a.name());
                PayViewInfo payViewInfo = new PayViewInfo();
                payViewInfo.clickArea = CancelType.BUTTOM_AREA_CLICK;
                payViewInfo.payDialogType = this.a;
                payViewInfo.viewDialog = this.f45246b;
                IViewEventListener iViewEventListener = this.f45247c;
                if (iViewEventListener == null || !iViewEventListener.onInterceptView(payViewInfo)) {
                    h.a.a.e.i.g.d dVar = this.f45248d;
                    if (dVar != null) {
                        dVar.a(CancelType.BUTTOM_AREA_CLICK);
                    }
                    this.f45246b.dismiss();
                }
            }
        }
    }

    /* renamed from: h.a.a.e.i.g.c$c  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class DialogInterface$OnDismissListenerC2156c implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h.a.a.e.i.g.d a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g f45249b;

        public DialogInterface$OnDismissListenerC2156c(h.a.a.e.i.g.d dVar, g gVar) {
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
            this.f45249b = gVar;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                h.a.a.e.i.g.d dVar = this.a;
                if (dVar != null) {
                    dVar.a(CancelType.ON_DIALOG_DISMISS);
                }
                c.f45242b.c(this.f45249b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class d implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h.a.a.e.i.g.d a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g f45250b;

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
            this.f45250b = gVar;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                h.a.a.e.i.g.d dVar = this.a;
                if (dVar != null) {
                    dVar.a(CancelType.ON_DIALOG_CANCEL);
                }
                c.f45242b.c(this.f45250b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class e implements DialogInterface.OnKeyListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h.a.a.e.i.g.d a;

        public e(h.a.a.e.i.g.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
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
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            h.a.a.e.i.g.d dVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, dialogInterface, i, keyEvent)) == null) {
                c cVar = c.f45242b;
                String str = c.a;
                RLog.info(str, "onKey keyCode:" + i);
                if (keyEvent.getAction() == 0 && i == 4 && (dVar = this.a) != null) {
                    if (dVar == null) {
                        Intrinsics.throwNpe();
                    }
                    if (dVar.b(dialogInterface)) {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1442141281, "Lh/a/a/e/i/g/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1442141281, "Lh/a/a/e/i/g/c;");
                return;
            }
        }
        f45242b = new c();
    }

    public c() {
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

    public final void c(Dialog dialog) {
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
            RLog.debug(a, "hideDialogLoading->oldRotateAnimator.cancel()");
        }
    }

    public final void d(Context context, String str, View view, h.a.a.e.i.g.d dVar, IViewEventListener iViewEventListener, PayDialogType payDialogType, Dialog dialog) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, str, view, dVar, iViewEventListener, payDialogType, dialog}) == null) {
            Window window = dialog.getWindow();
            Intrinsics.checkExpressionValueIsNotNull(window, "centerDialog.getWindow()");
            window.setGravity(17);
            WindowManager.LayoutParams attributes = window.getAttributes();
            Intrinsics.checkExpressionValueIsNotNull(attributes, "window.getAttributes()");
            attributes.width = -2;
            attributes.height = -2;
            window.setAttributes(attributes);
            window.setWindowAnimations(R.style.obfuscated_res_0x7f10014b);
            window.setContentView(R.layout.obfuscated_res_0x7f0d065d);
            View findViewById = window.findViewById(R.id.obfuscated_res_0x7f09221e);
            Intrinsics.checkExpressionValueIsNotNull(findViewById, "window.findViewById<TextView>(R.id.tv_title)");
            ((TextView) findViewById).setText(str);
            window.findViewById(R.id.obfuscated_res_0x7f091ad6).setOnClickListener(new a(payDialogType, dialog, iViewEventListener, dVar));
            ((Button) window.findViewById(R.id.obfuscated_res_0x7f09040d)).setOnClickListener(new b(payDialogType, dialog, iViewEventListener, dVar));
            ((ViewGroup) window.findViewById(R.id.obfuscated_res_0x7f0906c9)).addView(view);
        }
    }

    public final Dialog e(Context context, String str, View view, h.a.a.e.i.g.d dVar, IViewEventListener iViewEventListener, PayDialogType payDialogType, PayFlowType payFlowType) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{context, str, view, dVar, iViewEventListener, payDialogType, payFlowType})) == null) {
            if (!q.a.a(context)) {
                RLog.info(a, "showDialog ActivityInvalid....");
                return null;
            }
            g gVar = new g(context, R.style.obfuscated_res_0x7f10014e, payFlowType);
            gVar.setCancelable(true);
            gVar.setCanceledOnTouchOutside(false);
            gVar.show();
            gVar.setOnDismissListener(new DialogInterface$OnDismissListenerC2156c(dVar, gVar));
            gVar.setOnCancelListener(new d(dVar, gVar));
            gVar.setOnKeyListener(new e(dVar));
            d(context, str, view, dVar, iViewEventListener, payDialogType, gVar);
            return gVar;
        }
        return (Dialog) invokeCommon.objValue;
    }
}
