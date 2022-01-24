package j.a.a.e.q.g;

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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import j.a.a.e.p.n;
import j.a.a.e.p.o;
import j.a.a.e.p.q;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import tv.athena.revenue.payui.model.PayFlowType;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.model.PayViewInfo;
import tv.athena.revenue.payui.view.IViewEventListener;
import tv.athena.revenue.payui.view.dialog.AutoHideSoftInputDialog;
import tv.athena.revenue.payui.view.dialog.CancelType;
import tv.athena.revenue.payui.view.dialog.PayDialogType;
/* loaded from: classes4.dex */
public final class e {
    public static /* synthetic */ Interceptable $ic;
    public static final e a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static final class a implements InputFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f62444e;

        public a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62444e = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.text.InputFilter
        /* renamed from: a */
        public final String filter(CharSequence charSequence, int i2, int i3, Spanned spanned, int i4, int i5) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{charSequence, Integer.valueOf(i2), Integer.valueOf(i3), spanned, Integer.valueOf(i4), Integer.valueOf(i5)})) == null) {
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
                        if (substring.length() == this.f62444e + 1) {
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

    /* loaded from: classes4.dex */
    public static final class b implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j.a.a.e.q.g.d f62445e;

        public b(j.a.a.e.q.g.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62445e = dVar;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface dialogInterface) {
            j.a.a.e.q.g.d dVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) || (dVar = this.f62445e) == null) {
                return;
            }
            dVar.a(CancelType.ON_DIALOG_DISMISS);
        }
    }

    /* loaded from: classes4.dex */
    public static final class c implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j.a.a.e.q.g.d f62446e;

        public c(j.a.a.e.q.g.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62446e = dVar;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface dialogInterface) {
            j.a.a.e.q.g.d dVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) || (dVar = this.f62446e) == null) {
                return;
            }
            dVar.a(CancelType.ON_DIALOG_CANCEL);
        }
    }

    /* loaded from: classes4.dex */
    public static final class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PayDialogType f62447e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ AutoHideSoftInputDialog f62448f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ IViewEventListener f62449g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ j.a.a.e.q.g.d f62450h;

        public d(PayDialogType payDialogType, AutoHideSoftInputDialog autoHideSoftInputDialog, IViewEventListener iViewEventListener, j.a.a.e.q.g.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {payDialogType, autoHideSoftInputDialog, iViewEventListener, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62447e = payDialogType;
            this.f62448f = autoHideSoftInputDialog;
            this.f62449g = iViewEventListener;
            this.f62450h = dVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                PayViewInfo payViewInfo = new PayViewInfo();
                payViewInfo.clickArea = CancelType.EMPTY_AREA_CLICK;
                payViewInfo.payDialogType = this.f62447e;
                payViewInfo.viewDialog = this.f62448f;
                IViewEventListener iViewEventListener = this.f62449g;
                if (iViewEventListener == null || !iViewEventListener.onInterceptView(payViewInfo)) {
                    j.a.a.e.q.g.d dVar = this.f62450h;
                    if (dVar != null) {
                        dVar.a(CancelType.EMPTY_AREA_CLICK);
                    }
                    this.f62448f.dismiss();
                }
            }
        }
    }

    /* renamed from: j.a.a.e.q.g.e$e  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static final class C2318e implements TextView.OnEditorActionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EditText a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ j.a.a.e.q.g.d f62451b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Activity f62452c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ AutoHideSoftInputDialog f62453d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TextView f62454e;

        public C2318e(EditText editText, j.a.a.e.q.g.d dVar, Activity activity, AutoHideSoftInputDialog autoHideSoftInputDialog, TextView textView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {editText, dVar, activity, autoHideSoftInputDialog, textView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = editText;
            this.f62451b = dVar;
            this.f62452c = activity;
            this.f62453d = autoHideSoftInputDialog;
            this.f62454e = textView;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, textView, i2, keyEvent)) == null) {
                if (i2 == 6) {
                    e eVar = e.a;
                    EditText etInput = this.a;
                    Intrinsics.checkExpressionValueIsNotNull(etInput, "etInput");
                    boolean e2 = eVar.e(etInput.getText().toString());
                    if (e2) {
                        if (this.f62451b != null) {
                            EditText etInput2 = this.a;
                            Intrinsics.checkExpressionValueIsNotNull(etInput2, "etInput");
                            int c2 = e.a.c(this.f62452c, etInput2.getText().toString());
                            if (c2 > 0) {
                                this.f62451b.b(c2);
                                j.a.a.e.p.d.a(this.f62452c, this.a);
                            } else {
                                RLog.error("InputDialogManager", "tOnEditorAction amount <= 0", new Object[0]);
                            }
                        }
                        this.f62453d.dismiss();
                    }
                    this.f62454e.setTextColor(this.f62452c.getResources().getColor(e2 ? j.a.a.e.c.pay_ui_color_858585 : j.a.a.e.c.pay_ui_color_FF3355));
                }
                return false;
            }
            return invokeLIL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public static final class f implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TextView f62455e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TextView f62456f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ EditText f62457g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ TextView f62458h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Activity f62459i;

        public f(TextView textView, TextView textView2, EditText editText, TextView textView3, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {textView, textView2, editText, textView3, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62455e = textView;
            this.f62456f = textView2;
            this.f62457g = editText;
            this.f62458h = textView3;
            this.f62459i = activity;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            double c2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                if (editable != null && !Intrinsics.areEqual(editable.toString(), "")) {
                    if (!Intrinsics.areEqual(editable.toString(), "0")) {
                        boolean e2 = e.a.e(editable.toString());
                        TextView btnOk = this.f62456f;
                        Intrinsics.checkExpressionValueIsNotNull(btnOk, "btnOk");
                        btnOk.setEnabled(e2);
                        if (n.c(editable.toString()) >= 10000) {
                            String str = n.a(c2 / 10000.0f) + (char) 19975;
                            TextView tvInputAmount = this.f62455e;
                            Intrinsics.checkExpressionValueIsNotNull(tvInputAmount, "tvInputAmount");
                            tvInputAmount.setText(str);
                        } else {
                            TextView tvInputAmount2 = this.f62455e;
                            Intrinsics.checkExpressionValueIsNotNull(tvInputAmount2, "tvInputAmount");
                            tvInputAmount2.setText(editable);
                        }
                        this.f62458h.setTextColor(this.f62459i.getResources().getColor(e2 ? j.a.a.e.c.pay_ui_color_858585 : j.a.a.e.c.pay_ui_color_FF3355));
                        return;
                    }
                    this.f62457g.setText("");
                    TextView btnOk2 = this.f62456f;
                    Intrinsics.checkExpressionValueIsNotNull(btnOk2, "btnOk");
                    btnOk2.setEnabled(false);
                    return;
                }
                TextView tvInputAmount3 = this.f62455e;
                Intrinsics.checkExpressionValueIsNotNull(tvInputAmount3, "tvInputAmount");
                tvInputAmount3.setText("");
                TextView btnOk3 = this.f62456f;
                Intrinsics.checkExpressionValueIsNotNull(btnOk3, "btnOk");
                btnOk3.setEnabled(false);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i2, i3, i4) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ EditText f62460e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Activity f62461f;

        public g(EditText editText, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {editText, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62460e = editText;
            this.f62461f = activity;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f62460e.requestFocus();
                Activity activity = this.f62461f;
                if (activity == null) {
                    throw new TypeCastException("null cannot be cast to non-null type android.app.Activity");
                }
                j.a.a.e.p.d.b(activity, this.f62460e);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PayDialogType f62462e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ AutoHideSoftInputDialog f62463f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ IViewEventListener f62464g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ j.a.a.e.q.g.d f62465h;

        public h(PayDialogType payDialogType, AutoHideSoftInputDialog autoHideSoftInputDialog, IViewEventListener iViewEventListener, j.a.a.e.q.g.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {payDialogType, autoHideSoftInputDialog, iViewEventListener, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62462e = payDialogType;
            this.f62463f = autoHideSoftInputDialog;
            this.f62464g = iViewEventListener;
            this.f62465h = dVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                PayViewInfo payViewInfo = new PayViewInfo();
                payViewInfo.clickArea = CancelType.BUTTOM_AREA_CLICK;
                payViewInfo.payDialogType = this.f62462e;
                payViewInfo.viewDialog = this.f62463f;
                IViewEventListener iViewEventListener = this.f62464g;
                if (iViewEventListener == null || !iViewEventListener.onInterceptView(payViewInfo)) {
                    j.a.a.e.q.g.d dVar = this.f62465h;
                    if (dVar != null) {
                        dVar.a(CancelType.BUTTOM_AREA_CLICK);
                    }
                    this.f62463f.dismiss();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j.a.a.e.q.g.d f62466e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ EditText f62467f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Activity f62468g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ AutoHideSoftInputDialog f62469h;

        public i(j.a.a.e.q.g.d dVar, EditText editText, Activity activity, AutoHideSoftInputDialog autoHideSoftInputDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, editText, activity, autoHideSoftInputDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62466e = dVar;
            this.f62467f = editText;
            this.f62468g = activity;
            this.f62469h = autoHideSoftInputDialog;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f62466e != null) {
                    EditText etInput = this.f62467f;
                    Intrinsics.checkExpressionValueIsNotNull(etInput, "etInput");
                    int c2 = e.a.c(this.f62468g, etInput.getText().toString());
                    if (c2 > 0) {
                        this.f62466e.b(c2);
                        j.a.a.e.p.d.a(this.f62468g, this.f62467f);
                    } else {
                        RLog.error("InputDialogManager", "btnOk amount <= 0", new Object[0]);
                    }
                }
                this.f62469h.dismiss();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2070742035, "Lj/a/a/e/q/g/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2070742035, "Lj/a/a/e/q/g/e;");
                return;
            }
        }
        a = new e();
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

    public final int c(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, str)) == null) {
            if (str == null) {
                Toast.makeText(context, j.a.a.e.h.pay_ui_string_pls_input_correct_recharge_amount, 1).show();
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
                    Toast.makeText(context, j.a.a.e.h.pay_ui_string_pls_input_correct_recharge_amount, 1).show();
                    return 0;
                } else if (parseInt > 500000) {
                    Toast.makeText(context, j.a.a.e.h.pay_ui_string_pay_error_oversize, 1).show();
                    return 0;
                } else {
                    return parseInt;
                }
            } catch (Exception unused) {
                Toast.makeText(context, j.a.a.e.h.pay_ui_string_pls_input_correct_recharge_amount, 1).show();
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
            double c2 = n.c(str);
            return c2 >= 0.1d && c2 <= 500000.0d;
        }
        return invokeL.booleanValue;
    }

    public final Dialog f(Activity activity, j.a.a.e.q.g.d dVar, IViewEventListener iViewEventListener, PayDialogType payDialogType, PayUIKitConfig payUIKitConfig, PayFlowType payFlowType) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{activity, dVar, iViewEventListener, payDialogType, payUIKitConfig, payFlowType})) == null) {
            if (!q.a.a(activity)) {
                RLog.error("InputDialogManager", "showSimpleNumberInputDialog ActivityInvalid....", new Object[0]);
                return null;
            }
            AutoHideSoftInputDialog autoHideSoftInputDialog = new AutoHideSoftInputDialog(activity, j.a.a.e.i.PayUi_Number_Input_Dialog, payFlowType);
            autoHideSoftInputDialog.setCancelable(true);
            autoHideSoftInputDialog.setCanceledOnTouchOutside(true);
            autoHideSoftInputDialog.show();
            autoHideSoftInputDialog.setOnDismissListener(new b(dVar));
            autoHideSoftInputDialog.setOnCancelListener(new c(dVar));
            Window window = autoHideSoftInputDialog.getWindow();
            View inflate = LayoutInflater.from(new ContextThemeWrapper(activity, o.a.a(payUIKitConfig))).inflate(j.a.a.e.g.pay_ui_dialog_input_number, (ViewGroup) null, false);
            if (window == null) {
                Intrinsics.throwNpe();
            }
            window.setContentView(inflate);
            window.clearFlags(131072);
            window.setSoftInputMode(21);
            window.setWindowAnimations(j.a.a.e.i.PayUi_Dialog_Window_Anim);
            WindowManager.LayoutParams attributes = window.getAttributes();
            Intrinsics.checkExpressionValueIsNotNull(attributes, "window.getAttributes()");
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
            window.findViewById(j.a.a.e.f.rl_root).setOnClickListener(new d(payDialogType, autoHideSoftInputDialog, iViewEventListener, dVar));
            TextView textView = (TextView) window.findViewById(j.a.a.e.f.tv_amount_hint);
            TextView textView2 = (TextView) window.findViewById(j.a.a.e.f.tv_input_amount);
            EditText etInput = (EditText) window.findViewById(j.a.a.e.f.et_input_text);
            TextView btnOk = (TextView) window.findViewById(j.a.a.e.f.btn_pay);
            Intrinsics.checkExpressionValueIsNotNull(btnOk, "btnOk");
            btnOk.setEnabled(false);
            Button button = (Button) window.findViewById(j.a.a.e.f.btn_close);
            String string = activity.getResources().getString(j.a.a.e.h.pay_ui_string_custom_amount);
            Intrinsics.checkExpressionValueIsNotNull(string, "mContext.getResources().…_ui_string_custom_amount)");
            Intrinsics.checkExpressionValueIsNotNull(etInput, "etInput");
            etInput.setHint(string);
            etInput.setFilters(new InputFilter[]{new InputFilter.LengthFilter(8), d(2)});
            etInput.setOnEditorActionListener(new C2318e(etInput, dVar, activity, autoHideSoftInputDialog, textView));
            etInput.addTextChangedListener(new f(textView2, btnOk, etInput, textView, activity));
            etInput.postDelayed(new g(etInput, activity), 100L);
            button.setOnClickListener(new h(payDialogType, autoHideSoftInputDialog, iViewEventListener, dVar));
            btnOk.setOnClickListener(new i(dVar, etInput, activity, autoHideSoftInputDialog));
            return autoHideSoftInputDialog;
        }
        return (Dialog) invokeCommon.objValue;
    }
}
