package i.a.a.e.o.g;

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
import i.a.a.e.n.k;
import i.a.a.e.n.l;
import i.a.a.e.n.n;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.model.PayViewInfo;
import tv.athena.revenue.payui.view.IViewEventListener;
import tv.athena.revenue.payui.view.dialog.AutoHideSoftInputDialog;
import tv.athena.revenue.payui.view.dialog.CancelType;
import tv.athena.revenue.payui.view.dialog.PayDialogType;
/* loaded from: classes3.dex */
public final class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final e f72431a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static final class a implements InputFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f72432e;

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
            this.f72432e = i2;
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
                        if (substring.length() == this.f72432e + 1) {
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

    /* loaded from: classes3.dex */
    public static final class b implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i.a.a.e.o.g.d f72433e;

        public b(i.a.a.e.o.g.d dVar) {
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
            this.f72433e = dVar;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface dialogInterface) {
            i.a.a.e.o.g.d dVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) || (dVar = this.f72433e) == null) {
                return;
            }
            dVar.a(CancelType.ON_DIALOG_DISMISS);
        }
    }

    /* loaded from: classes3.dex */
    public static final class c implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i.a.a.e.o.g.d f72434e;

        public c(i.a.a.e.o.g.d dVar) {
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
            this.f72434e = dVar;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface dialogInterface) {
            i.a.a.e.o.g.d dVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) || (dVar = this.f72434e) == null) {
                return;
            }
            dVar.a(CancelType.ON_DIALOG_CANCEL);
        }
    }

    /* loaded from: classes3.dex */
    public static final class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PayDialogType f72435e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ AutoHideSoftInputDialog f72436f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ IViewEventListener f72437g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ i.a.a.e.o.g.d f72438h;

        public d(PayDialogType payDialogType, AutoHideSoftInputDialog autoHideSoftInputDialog, IViewEventListener iViewEventListener, i.a.a.e.o.g.d dVar) {
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
            this.f72435e = payDialogType;
            this.f72436f = autoHideSoftInputDialog;
            this.f72437g = iViewEventListener;
            this.f72438h = dVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                PayViewInfo payViewInfo = new PayViewInfo();
                payViewInfo.clickArea = CancelType.EMPTY_AREA_CLICK;
                payViewInfo.payDialogType = this.f72435e;
                payViewInfo.viewDialog = this.f72436f;
                IViewEventListener iViewEventListener = this.f72437g;
                if (iViewEventListener == null || !iViewEventListener.onInterceptView(payViewInfo)) {
                    i.a.a.e.o.g.d dVar = this.f72438h;
                    if (dVar != null) {
                        dVar.a(CancelType.EMPTY_AREA_CLICK);
                    }
                    this.f72436f.dismiss();
                }
            }
        }
    }

    /* renamed from: i.a.a.e.o.g.e$e  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C2076e implements TextView.OnEditorActionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EditText f72439a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ i.a.a.e.o.g.d f72440b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Activity f72441c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ AutoHideSoftInputDialog f72442d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TextView f72443e;

        public C2076e(EditText editText, i.a.a.e.o.g.d dVar, Activity activity, AutoHideSoftInputDialog autoHideSoftInputDialog, TextView textView) {
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
            this.f72439a = editText;
            this.f72440b = dVar;
            this.f72441c = activity;
            this.f72442d = autoHideSoftInputDialog;
            this.f72443e = textView;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, textView, i2, keyEvent)) == null) {
                if (i2 == 6) {
                    e eVar = e.f72431a;
                    EditText etInput = this.f72439a;
                    Intrinsics.checkExpressionValueIsNotNull(etInput, "etInput");
                    boolean e2 = eVar.e(etInput.getText().toString());
                    if (e2) {
                        if (this.f72440b != null) {
                            EditText etInput2 = this.f72439a;
                            Intrinsics.checkExpressionValueIsNotNull(etInput2, "etInput");
                            int c2 = e.f72431a.c(this.f72441c, etInput2.getText().toString());
                            if (c2 > 0) {
                                this.f72440b.b(c2);
                                i.a.a.e.n.d.a(this.f72441c, this.f72439a);
                            } else {
                                RLog.error("InputDialogManager", "tOnEditorAction amount <= 0", new Object[0]);
                            }
                        }
                        this.f72442d.dismiss();
                    }
                    this.f72443e.setTextColor(this.f72441c.getResources().getColor(e2 ? i.a.a.e.a.pay_ui_color_858585 : i.a.a.e.a.pay_ui_color_FF3355));
                }
                return false;
            }
            return invokeLIL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public static final class f implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TextView f72444e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TextView f72445f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ EditText f72446g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ TextView f72447h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Activity f72448i;

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
            this.f72444e = textView;
            this.f72445f = textView2;
            this.f72446g = editText;
            this.f72447h = textView3;
            this.f72448i = activity;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            double c2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                if (editable != null && !Intrinsics.areEqual(editable.toString(), "")) {
                    if (!Intrinsics.areEqual(editable.toString(), "0")) {
                        boolean e2 = e.f72431a.e(editable.toString());
                        TextView btnOk = this.f72445f;
                        Intrinsics.checkExpressionValueIsNotNull(btnOk, "btnOk");
                        btnOk.setEnabled(e2);
                        if (k.c(editable.toString()) >= 10000) {
                            String str = k.a(c2 / 10000.0f) + (char) 19975;
                            TextView tvInputAmount = this.f72444e;
                            Intrinsics.checkExpressionValueIsNotNull(tvInputAmount, "tvInputAmount");
                            tvInputAmount.setText(str);
                        } else {
                            TextView tvInputAmount2 = this.f72444e;
                            Intrinsics.checkExpressionValueIsNotNull(tvInputAmount2, "tvInputAmount");
                            tvInputAmount2.setText(editable);
                        }
                        this.f72447h.setTextColor(this.f72448i.getResources().getColor(e2 ? i.a.a.e.a.pay_ui_color_858585 : i.a.a.e.a.pay_ui_color_FF3355));
                        return;
                    }
                    this.f72446g.setText("");
                    TextView btnOk2 = this.f72445f;
                    Intrinsics.checkExpressionValueIsNotNull(btnOk2, "btnOk");
                    btnOk2.setEnabled(false);
                    return;
                }
                TextView tvInputAmount3 = this.f72444e;
                Intrinsics.checkExpressionValueIsNotNull(tvInputAmount3, "tvInputAmount");
                tvInputAmount3.setText("");
                TextView btnOk3 = this.f72445f;
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

    /* loaded from: classes3.dex */
    public static final class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ EditText f72449e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Activity f72450f;

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
            this.f72449e = editText;
            this.f72450f = activity;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f72449e.requestFocus();
                Activity activity = this.f72450f;
                if (activity == null) {
                    throw new TypeCastException("null cannot be cast to non-null type android.app.Activity");
                }
                i.a.a.e.n.d.b(activity, this.f72449e);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PayDialogType f72451e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ AutoHideSoftInputDialog f72452f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ IViewEventListener f72453g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ i.a.a.e.o.g.d f72454h;

        public h(PayDialogType payDialogType, AutoHideSoftInputDialog autoHideSoftInputDialog, IViewEventListener iViewEventListener, i.a.a.e.o.g.d dVar) {
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
            this.f72451e = payDialogType;
            this.f72452f = autoHideSoftInputDialog;
            this.f72453g = iViewEventListener;
            this.f72454h = dVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                PayViewInfo payViewInfo = new PayViewInfo();
                payViewInfo.clickArea = CancelType.BUTTOM_AREA_CLICK;
                payViewInfo.payDialogType = this.f72451e;
                payViewInfo.viewDialog = this.f72452f;
                IViewEventListener iViewEventListener = this.f72453g;
                if (iViewEventListener == null || !iViewEventListener.onInterceptView(payViewInfo)) {
                    i.a.a.e.o.g.d dVar = this.f72454h;
                    if (dVar != null) {
                        dVar.a(CancelType.BUTTOM_AREA_CLICK);
                    }
                    this.f72452f.dismiss();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i.a.a.e.o.g.d f72455e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ EditText f72456f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Activity f72457g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ AutoHideSoftInputDialog f72458h;

        public i(i.a.a.e.o.g.d dVar, EditText editText, Activity activity, AutoHideSoftInputDialog autoHideSoftInputDialog) {
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
            this.f72455e = dVar;
            this.f72456f = editText;
            this.f72457g = activity;
            this.f72458h = autoHideSoftInputDialog;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f72455e != null) {
                    EditText etInput = this.f72456f;
                    Intrinsics.checkExpressionValueIsNotNull(etInput, "etInput");
                    int c2 = e.f72431a.c(this.f72457g, etInput.getText().toString());
                    if (c2 > 0) {
                        this.f72455e.b(c2);
                        i.a.a.e.n.d.a(this.f72457g, this.f72456f);
                    } else {
                        RLog.error("InputDialogManager", "btnOk amount <= 0", new Object[0]);
                    }
                }
                this.f72458h.dismiss();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1775924938, "Li/a/a/e/o/g/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1775924938, "Li/a/a/e/o/g/e;");
                return;
            }
        }
        f72431a = new e();
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
                Toast.makeText(context, i.a.a.e.f.pay_ui_string_pls_input_correct_recharge_amount, 1).show();
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
                    Toast.makeText(context, i.a.a.e.f.pay_ui_string_pls_input_correct_recharge_amount, 1).show();
                    return 0;
                } else if (parseInt > 500000) {
                    Toast.makeText(context, i.a.a.e.f.pay_ui_string_pay_error_oversize, 1).show();
                    return 0;
                } else {
                    return parseInt;
                }
            } catch (Exception unused) {
                Toast.makeText(context, i.a.a.e.f.pay_ui_string_pls_input_correct_recharge_amount, 1).show();
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
            double c2 = k.c(str);
            return c2 >= 0.1d && c2 <= 500000.0d;
        }
        return invokeL.booleanValue;
    }

    public final Dialog f(Activity activity, i.a.a.e.o.g.d dVar, IViewEventListener iViewEventListener, PayDialogType payDialogType, PayUIKitConfig payUIKitConfig) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048579, this, activity, dVar, iViewEventListener, payDialogType, payUIKitConfig)) == null) {
            if (!n.f72366a.a(activity)) {
                RLog.error("InputDialogManager", "showSimpleNumberInputDialog ActivityInvalid....", new Object[0]);
                return null;
            }
            AutoHideSoftInputDialog autoHideSoftInputDialog = new AutoHideSoftInputDialog(activity, i.a.a.e.g.PayUi_Number_Input_Dialog);
            autoHideSoftInputDialog.setCancelable(true);
            autoHideSoftInputDialog.setCanceledOnTouchOutside(true);
            autoHideSoftInputDialog.show();
            autoHideSoftInputDialog.setOnDismissListener(new b(dVar));
            autoHideSoftInputDialog.setOnCancelListener(new c(dVar));
            Window window = autoHideSoftInputDialog.getWindow();
            View inflate = LayoutInflater.from(new ContextThemeWrapper(activity, l.f72365a.a(payUIKitConfig))).inflate(i.a.a.e.e.pay_ui_dialog_input_number, (ViewGroup) null, false);
            if (window == null) {
                Intrinsics.throwNpe();
            }
            window.setContentView(inflate);
            window.clearFlags(131072);
            window.setSoftInputMode(21);
            window.setWindowAnimations(i.a.a.e.g.PayUi_Dialog_Window_Anim);
            WindowManager.LayoutParams attributes = window.getAttributes();
            Intrinsics.checkExpressionValueIsNotNull(attributes, "window.getAttributes()");
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
            window.findViewById(i.a.a.e.d.rl_root).setOnClickListener(new d(payDialogType, autoHideSoftInputDialog, iViewEventListener, dVar));
            TextView textView = (TextView) window.findViewById(i.a.a.e.d.tv_amount_hint);
            TextView textView2 = (TextView) window.findViewById(i.a.a.e.d.tv_input_amount);
            EditText etInput = (EditText) window.findViewById(i.a.a.e.d.et_input_text);
            TextView btnOk = (TextView) window.findViewById(i.a.a.e.d.btn_pay);
            Intrinsics.checkExpressionValueIsNotNull(btnOk, "btnOk");
            btnOk.setEnabled(false);
            Button button = (Button) window.findViewById(i.a.a.e.d.btn_close);
            String string = activity.getResources().getString(i.a.a.e.f.pay_ui_string_custom_amount);
            Intrinsics.checkExpressionValueIsNotNull(string, "mContext.getResources().…_ui_string_custom_amount)");
            Intrinsics.checkExpressionValueIsNotNull(etInput, "etInput");
            etInput.setHint(string);
            etInput.setFilters(new InputFilter[]{new InputFilter.LengthFilter(8), d(2)});
            etInput.setOnEditorActionListener(new C2076e(etInput, dVar, activity, autoHideSoftInputDialog, textView));
            etInput.addTextChangedListener(new f(textView2, btnOk, etInput, textView, activity));
            etInput.postDelayed(new g(etInput, activity), 100L);
            button.setOnClickListener(new h(payDialogType, autoHideSoftInputDialog, iViewEventListener, dVar));
            btnOk.setOnClickListener(new i(dVar, etInput, activity, autoHideSoftInputDialog));
            return autoHideSoftInputDialog;
        }
        return (Dialog) invokeLLLLL.objValue;
    }
}
