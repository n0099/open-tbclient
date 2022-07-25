package com.repackage;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
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
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import tv.athena.revenue.payui.model.PayFlowType;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.model.PayViewInfo;
import tv.athena.revenue.payui.view.IViewEventListener;
import tv.athena.revenue.payui.view.dialog.CancelType;
import tv.athena.revenue.payui.view.dialog.PayDialogType;
/* loaded from: classes5.dex */
public final class e0a {
    public static /* synthetic */ Interceptable $ic;
    public static final e0a a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static final class a implements InputFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        public a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.text.InputFilter
        /* renamed from: a */
        public final String filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{charSequence, Integer.valueOf(i), Integer.valueOf(i2), spanned, Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
                if (Intrinsics.areEqual(charSequence, ".")) {
                    if (spanned.toString().length() == 0) {
                        return "0.";
                    }
                }
                if (StringsKt__StringsKt.contains$default((CharSequence) spanned.toString(), (CharSequence) ".", false, 2, (Object) null)) {
                    int indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) spanned.toString(), ".", 0, false, 6, (Object) null);
                    String obj = spanned.toString();
                    if (obj != null) {
                        String substring = obj.substring(indexOf$default);
                        Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.String).substring(startIndex)");
                        if (substring.length() == this.a + 1) {
                            return "";
                        }
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                    }
                }
                return null;
            }
            return (String) invokeCommon.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static final class b implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d0a a;

        public b(d0a d0aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d0aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d0aVar;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface dialogInterface) {
            d0a d0aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) || (d0aVar = this.a) == null) {
                return;
            }
            d0aVar.a(CancelType.ON_DIALOG_DISMISS);
        }
    }

    /* loaded from: classes5.dex */
    public static final class c implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d0a a;

        public c(d0a d0aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d0aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d0aVar;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface dialogInterface) {
            d0a d0aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) || (d0aVar = this.a) == null) {
                return;
            }
            d0aVar.a(CancelType.ON_DIALOG_CANCEL);
        }
    }

    /* loaded from: classes5.dex */
    public static final class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PayDialogType a;
        public final /* synthetic */ zz9 b;
        public final /* synthetic */ IViewEventListener c;
        public final /* synthetic */ d0a d;

        public d(PayDialogType payDialogType, zz9 zz9Var, IViewEventListener iViewEventListener, d0a d0aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {payDialogType, zz9Var, iViewEventListener, d0aVar};
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
            this.b = zz9Var;
            this.c = iViewEventListener;
            this.d = d0aVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                PayViewInfo payViewInfo = new PayViewInfo();
                payViewInfo.clickArea = CancelType.EMPTY_AREA_CLICK;
                payViewInfo.payDialogType = this.a;
                payViewInfo.viewDialog = this.b;
                IViewEventListener iViewEventListener = this.c;
                if (iViewEventListener == null || !iViewEventListener.onInterceptView(payViewInfo)) {
                    d0a d0aVar = this.d;
                    if (d0aVar != null) {
                        d0aVar.a(CancelType.EMPTY_AREA_CLICK);
                    }
                    this.b.dismiss();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class e implements TextView.OnEditorActionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EditText a;
        public final /* synthetic */ d0a b;
        public final /* synthetic */ Activity c;
        public final /* synthetic */ zz9 d;
        public final /* synthetic */ TextView e;

        public e(EditText editText, d0a d0aVar, Activity activity, zz9 zz9Var, TextView textView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {editText, d0aVar, activity, zz9Var, textView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = editText;
            this.b = d0aVar;
            this.c = activity;
            this.d = zz9Var;
            this.e = textView;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, textView, i, keyEvent)) == null) {
                if (i == 6) {
                    e0a e0aVar = e0a.a;
                    EditText etInput = this.a;
                    Intrinsics.checkExpressionValueIsNotNull(etInput, "etInput");
                    boolean e = e0aVar.e(etInput.getText().toString());
                    if (e) {
                        if (this.b != null) {
                            EditText etInput2 = this.a;
                            Intrinsics.checkExpressionValueIsNotNull(etInput2, "etInput");
                            int c = e0a.a.c(this.c, etInput2.getText().toString());
                            if (c > 0) {
                                this.b.b(c);
                                cz9.a(this.c, this.a);
                            } else {
                                RLog.error("InputDialogManager", "tOnEditorAction amount <= 0", new Object[0]);
                            }
                        }
                        this.d.dismiss();
                    }
                    this.e.setTextColor(this.c.getResources().getColor(e ? R.color.obfuscated_res_0x7f0608a5 : R.color.obfuscated_res_0x7f0608a8));
                }
                return false;
            }
            return invokeLIL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public static final class f implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TextView a;
        public final /* synthetic */ TextView b;
        public final /* synthetic */ EditText c;
        public final /* synthetic */ TextView d;
        public final /* synthetic */ Activity e;

        public f(TextView textView, TextView textView2, EditText editText, TextView textView3, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {textView, textView2, editText, textView3, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = textView;
            this.b = textView2;
            this.c = editText;
            this.d = textView3;
            this.e = activity;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            double c;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                if (editable != null && !Intrinsics.areEqual(editable.toString(), "")) {
                    if (!Intrinsics.areEqual(editable.toString(), "0")) {
                        boolean e = e0a.a.e(editable.toString());
                        TextView btnOk = this.b;
                        Intrinsics.checkExpressionValueIsNotNull(btnOk, "btnOk");
                        btnOk.setEnabled(e);
                        if (mz9.c(editable.toString()) >= 10000) {
                            String str = mz9.a(c / 10000.0f) + (char) 19975;
                            TextView tvInputAmount = this.a;
                            Intrinsics.checkExpressionValueIsNotNull(tvInputAmount, "tvInputAmount");
                            tvInputAmount.setText(str);
                        } else {
                            TextView tvInputAmount2 = this.a;
                            Intrinsics.checkExpressionValueIsNotNull(tvInputAmount2, "tvInputAmount");
                            tvInputAmount2.setText(editable);
                        }
                        this.d.setTextColor(this.e.getResources().getColor(e ? R.color.obfuscated_res_0x7f0608a5 : R.color.obfuscated_res_0x7f0608a8));
                        return;
                    }
                    this.c.setText("");
                    TextView btnOk2 = this.b;
                    Intrinsics.checkExpressionValueIsNotNull(btnOk2, "btnOk");
                    btnOk2.setEnabled(false);
                    return;
                }
                TextView tvInputAmount3 = this.a;
                Intrinsics.checkExpressionValueIsNotNull(tvInputAmount3, "tvInputAmount");
                tvInputAmount3.setText("");
                TextView btnOk3 = this.b;
                Intrinsics.checkExpressionValueIsNotNull(btnOk3, "btnOk");
                btnOk3.setEnabled(false);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EditText a;
        public final /* synthetic */ Activity b;

        public g(EditText editText, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {editText, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = editText;
            this.b = activity;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.requestFocus();
                Activity activity = this.b;
                if (activity == null) {
                    throw new TypeCastException("null cannot be cast to non-null type android.app.Activity");
                }
                cz9.b(activity, this.a);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PayDialogType a;
        public final /* synthetic */ zz9 b;
        public final /* synthetic */ IViewEventListener c;
        public final /* synthetic */ d0a d;

        public h(PayDialogType payDialogType, zz9 zz9Var, IViewEventListener iViewEventListener, d0a d0aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {payDialogType, zz9Var, iViewEventListener, d0aVar};
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
            this.b = zz9Var;
            this.c = iViewEventListener;
            this.d = d0aVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                PayViewInfo payViewInfo = new PayViewInfo();
                payViewInfo.clickArea = CancelType.BUTTOM_AREA_CLICK;
                payViewInfo.payDialogType = this.a;
                payViewInfo.viewDialog = this.b;
                IViewEventListener iViewEventListener = this.c;
                if (iViewEventListener == null || !iViewEventListener.onInterceptView(payViewInfo)) {
                    d0a d0aVar = this.d;
                    if (d0aVar != null) {
                        d0aVar.a(CancelType.BUTTOM_AREA_CLICK);
                    }
                    this.b.dismiss();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d0a a;
        public final /* synthetic */ EditText b;
        public final /* synthetic */ Activity c;
        public final /* synthetic */ zz9 d;

        public i(d0a d0aVar, EditText editText, Activity activity, zz9 zz9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d0aVar, editText, activity, zz9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d0aVar;
            this.b = editText;
            this.c = activity;
            this.d = zz9Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a != null) {
                    EditText etInput = this.b;
                    Intrinsics.checkExpressionValueIsNotNull(etInput, "etInput");
                    int c = e0a.a.c(this.c, etInput.getText().toString());
                    if (c > 0) {
                        this.a.b(c);
                        cz9.a(this.c, this.b);
                    } else {
                        RLog.error("InputDialogManager", "btnOk amount <= 0", new Object[0]);
                    }
                }
                this.d.dismiss();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755790053, "Lcom/repackage/e0a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755790053, "Lcom/repackage/e0a;");
                return;
            }
        }
        a = new e0a();
    }

    public e0a() {
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

    public final int c(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, str)) == null) {
            if (str == null) {
                Toast.makeText(context, (int) R.string.obfuscated_res_0x7f0f0d5c, 1).show();
                return 0;
            }
            int length = str.length() - 1;
            int i2 = 0;
            boolean z = false;
            while (i2 <= length) {
                boolean z2 = str.charAt(!z ? i2 : length) <= ' ';
                if (z) {
                    if (!z2) {
                        break;
                    }
                    length--;
                } else if (z2) {
                    i2++;
                } else {
                    z = true;
                }
            }
            try {
                int parseInt = Integer.parseInt(str.subSequence(i2, length + 1).toString());
                if (parseInt <= 0) {
                    Toast.makeText(context, (int) R.string.obfuscated_res_0x7f0f0d5c, 1).show();
                    return 0;
                } else if (parseInt > 500000) {
                    Toast.makeText(context, (int) R.string.obfuscated_res_0x7f0f0d5b, 1).show();
                    return 0;
                } else {
                    return parseInt;
                }
            } catch (Exception unused) {
                Toast.makeText(context, (int) R.string.obfuscated_res_0x7f0f0d5c, 1).show();
                return 0;
            }
        }
        return invokeLL.intValue;
    }

    public final InputFilter d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? new a(i2) : (InputFilter) invokeI.objValue;
    }

    public final boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            double c2 = mz9.c(str);
            return c2 >= 0.1d && c2 <= 500000.0d;
        }
        return invokeL.booleanValue;
    }

    public final Dialog f(Activity activity, d0a d0aVar, IViewEventListener iViewEventListener, PayDialogType payDialogType, PayUIKitConfig payUIKitConfig, PayFlowType payFlowType) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{activity, d0aVar, iViewEventListener, payDialogType, payUIKitConfig, payFlowType})) == null) {
            if (!pz9.a.a(activity)) {
                RLog.error("InputDialogManager", "showSimpleNumberInputDialog ActivityInvalid....", new Object[0]);
                return null;
            }
            zz9 zz9Var = new zz9(activity, R.style.obfuscated_res_0x7f10014e, payFlowType);
            zz9Var.setCancelable(true);
            zz9Var.setCanceledOnTouchOutside(true);
            zz9Var.show();
            zz9Var.setOnDismissListener(new b(d0aVar));
            zz9Var.setOnCancelListener(new c(d0aVar));
            Window window = zz9Var.getWindow();
            View inflate = LayoutInflater.from(new ContextThemeWrapper(activity, nz9.a.a(payUIKitConfig))).inflate(R.layout.obfuscated_res_0x7f0d0666, (ViewGroup) null, false);
            if (window == null) {
                Intrinsics.throwNpe();
            }
            window.setContentView(inflate);
            window.clearFlags(131072);
            window.setSoftInputMode(21);
            window.setWindowAnimations(R.style.obfuscated_res_0x7f10014b);
            WindowManager.LayoutParams attributes = window.getAttributes();
            Intrinsics.checkExpressionValueIsNotNull(attributes, "window.getAttributes()");
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
            window.findViewById(R.id.obfuscated_res_0x7f091b35).setOnClickListener(new d(payDialogType, zz9Var, iViewEventListener, d0aVar));
            TextView textView = (TextView) window.findViewById(R.id.obfuscated_res_0x7f092201);
            TextView textView2 = (TextView) window.findViewById(R.id.obfuscated_res_0x7f092246);
            EditText etInput = (EditText) window.findViewById(R.id.obfuscated_res_0x7f0908e5);
            TextView btnOk = (TextView) window.findViewById(R.id.obfuscated_res_0x7f090426);
            Intrinsics.checkExpressionValueIsNotNull(btnOk, "btnOk");
            btnOk.setEnabled(false);
            Button button = (Button) window.findViewById(R.id.obfuscated_res_0x7f090409);
            String string = activity.getResources().getString(R.string.obfuscated_res_0x7f0f0d5a);
            Intrinsics.checkExpressionValueIsNotNull(string, "mContext.getResources().…_ui_string_custom_amount)");
            Intrinsics.checkExpressionValueIsNotNull(etInput, "etInput");
            etInput.setHint(string);
            etInput.setFilters(new InputFilter[]{new InputFilter.LengthFilter(8), d(2)});
            etInput.setOnEditorActionListener(new e(etInput, d0aVar, activity, zz9Var, textView));
            etInput.addTextChangedListener(new f(textView2, btnOk, etInput, textView, activity));
            etInput.postDelayed(new g(etInput, activity), 100L);
            button.setOnClickListener(new h(payDialogType, zz9Var, iViewEventListener, d0aVar));
            btnOk.setOnClickListener(new i(d0aVar, etInput, activity, zz9Var));
            return zz9Var;
        }
        return (Dialog) invokeCommon.objValue;
    }
}
