package j.a.a.e.o.d;

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
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.model.PayViewInfo;
import tv.athena.revenue.payui.view.IViewEventListener;
import tv.athena.revenue.payui.view.dialog.AutoHideSoftInputDialog;
import tv.athena.revenue.payui.view.dialog.CancelType;
import tv.athena.revenue.payui.view.dialog.PayDialogType;
/* loaded from: classes2.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final c f78963a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static final class a implements InputFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f78964e;

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
            this.f78964e = i2;
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
                        if (substring.length() == this.f78964e + 1) {
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

    /* loaded from: classes2.dex */
    public static final class b implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j.a.a.e.o.d.b f78965e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ AutoHideSoftInputDialog f78966f;

        public b(j.a.a.e.o.d.b bVar, AutoHideSoftInputDialog autoHideSoftInputDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, autoHideSoftInputDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f78965e = bVar;
            this.f78966f = autoHideSoftInputDialog;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                j.a.a.e.o.d.b bVar = this.f78965e;
                if (bVar != null) {
                    bVar.a(CancelType.ON_DIALOG_DISMISS);
                }
                this.f78966f.dismiss();
            }
        }
    }

    /* renamed from: j.a.a.e.o.d.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class DialogInterface$OnCancelListenerC2148c implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AutoHideSoftInputDialog f78967e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ j.a.a.e.o.d.b f78968f;

        public DialogInterface$OnCancelListenerC2148c(AutoHideSoftInputDialog autoHideSoftInputDialog, j.a.a.e.o.d.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {autoHideSoftInputDialog, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f78967e = autoHideSoftInputDialog;
            this.f78968f = bVar;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.f78967e.dismiss();
                j.a.a.e.o.d.b bVar = this.f78968f;
                if (bVar != null) {
                    bVar.a(CancelType.ON_DIALOG_CANCEL);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PayDialogType f78969e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ AutoHideSoftInputDialog f78970f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ IViewEventListener f78971g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ j.a.a.e.o.d.b f78972h;

        public d(PayDialogType payDialogType, AutoHideSoftInputDialog autoHideSoftInputDialog, IViewEventListener iViewEventListener, j.a.a.e.o.d.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {payDialogType, autoHideSoftInputDialog, iViewEventListener, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f78969e = payDialogType;
            this.f78970f = autoHideSoftInputDialog;
            this.f78971g = iViewEventListener;
            this.f78972h = bVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                PayViewInfo payViewInfo = new PayViewInfo();
                payViewInfo.clickArea = CancelType.EMPTY_AREA_CLICK;
                payViewInfo.payDialogType = this.f78969e;
                payViewInfo.viewDialog = this.f78970f;
                IViewEventListener iViewEventListener = this.f78971g;
                if (iViewEventListener == null || !iViewEventListener.onInterceptView(payViewInfo)) {
                    j.a.a.e.o.d.b bVar = this.f78972h;
                    if (bVar != null) {
                        bVar.a(CancelType.EMPTY_AREA_CLICK);
                    }
                    this.f78970f.dismiss();
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class e implements TextView.OnEditorActionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EditText f78973a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ j.a.a.e.o.d.b f78974b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Activity f78975c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ AutoHideSoftInputDialog f78976d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TextView f78977e;

        public e(EditText editText, j.a.a.e.o.d.b bVar, Activity activity, AutoHideSoftInputDialog autoHideSoftInputDialog, TextView textView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {editText, bVar, activity, autoHideSoftInputDialog, textView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f78973a = editText;
            this.f78974b = bVar;
            this.f78975c = activity;
            this.f78976d = autoHideSoftInputDialog;
            this.f78977e = textView;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, textView, i2, keyEvent)) == null) {
                if (i2 == 6) {
                    c cVar = c.f78963a;
                    EditText etInput = this.f78973a;
                    Intrinsics.checkExpressionValueIsNotNull(etInput, "etInput");
                    boolean e2 = cVar.e(etInput.getText().toString());
                    if (e2) {
                        if (this.f78974b != null) {
                            EditText etInput2 = this.f78973a;
                            Intrinsics.checkExpressionValueIsNotNull(etInput2, "etInput");
                            int c2 = c.f78963a.c(this.f78975c, etInput2.getText().toString());
                            if (c2 > 0) {
                                this.f78974b.b(c2);
                                j.a.a.e.n.d.a(this.f78975c, this.f78973a);
                            } else {
                                RLog.error("DialogUtils", "tOnEditorAction amount <= 0", new Object[0]);
                            }
                        }
                        this.f78976d.dismiss();
                    }
                    this.f78977e.setTextColor(this.f78975c.getResources().getColor(e2 ? j.a.a.e.a.pay_ui_color_858585 : j.a.a.e.a.pay_ui_color_FF3355));
                }
                return false;
            }
            return invokeLIL.booleanValue;
        }
    }

    /* loaded from: classes2.dex */
    public static final class f implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TextView f78978e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TextView f78979f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ EditText f78980g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ TextView f78981h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Activity f78982i;

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
            this.f78978e = textView;
            this.f78979f = textView2;
            this.f78980g = editText;
            this.f78981h = textView3;
            this.f78982i = activity;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            double b2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                if (editable != null && !Intrinsics.areEqual(editable.toString(), "")) {
                    if (!Intrinsics.areEqual(editable.toString(), "0")) {
                        boolean e2 = c.f78963a.e(editable.toString());
                        TextView btnOk = this.f78979f;
                        Intrinsics.checkExpressionValueIsNotNull(btnOk, "btnOk");
                        btnOk.setEnabled(e2);
                        if (j.a.a.e.n.g.b(editable.toString()) >= 10000) {
                            String str = j.a.a.e.n.g.a(b2 / 10000.0f) + (char) 19975;
                            TextView tvInputAmount = this.f78978e;
                            Intrinsics.checkExpressionValueIsNotNull(tvInputAmount, "tvInputAmount");
                            tvInputAmount.setText(str);
                        } else {
                            TextView tvInputAmount2 = this.f78978e;
                            Intrinsics.checkExpressionValueIsNotNull(tvInputAmount2, "tvInputAmount");
                            tvInputAmount2.setText(editable);
                        }
                        this.f78981h.setTextColor(this.f78982i.getResources().getColor(e2 ? j.a.a.e.a.pay_ui_color_858585 : j.a.a.e.a.pay_ui_color_FF3355));
                        return;
                    }
                    this.f78980g.setText("");
                    TextView btnOk2 = this.f78979f;
                    Intrinsics.checkExpressionValueIsNotNull(btnOk2, "btnOk");
                    btnOk2.setEnabled(false);
                    return;
                }
                TextView tvInputAmount3 = this.f78978e;
                Intrinsics.checkExpressionValueIsNotNull(tvInputAmount3, "tvInputAmount");
                tvInputAmount3.setText("");
                TextView btnOk3 = this.f78979f;
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

    /* loaded from: classes2.dex */
    public static final class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ EditText f78983e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Activity f78984f;

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
            this.f78983e = editText;
            this.f78984f = activity;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f78983e.requestFocus();
                Activity activity = this.f78984f;
                if (activity == null) {
                    throw new TypeCastException("null cannot be cast to non-null type android.app.Activity");
                }
                j.a.a.e.n.d.b(activity, this.f78983e);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PayDialogType f78985e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ AutoHideSoftInputDialog f78986f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ IViewEventListener f78987g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ j.a.a.e.o.d.b f78988h;

        public h(PayDialogType payDialogType, AutoHideSoftInputDialog autoHideSoftInputDialog, IViewEventListener iViewEventListener, j.a.a.e.o.d.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {payDialogType, autoHideSoftInputDialog, iViewEventListener, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f78985e = payDialogType;
            this.f78986f = autoHideSoftInputDialog;
            this.f78987g = iViewEventListener;
            this.f78988h = bVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                PayViewInfo payViewInfo = new PayViewInfo();
                payViewInfo.clickArea = CancelType.BUTTOM_AREA_CLICK;
                payViewInfo.payDialogType = this.f78985e;
                payViewInfo.viewDialog = this.f78986f;
                IViewEventListener iViewEventListener = this.f78987g;
                if (iViewEventListener == null || !iViewEventListener.onInterceptView(payViewInfo)) {
                    j.a.a.e.o.d.b bVar = this.f78988h;
                    if (bVar != null) {
                        bVar.a(CancelType.BUTTOM_AREA_CLICK);
                    }
                    this.f78986f.dismiss();
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j.a.a.e.o.d.b f78989e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ EditText f78990f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Activity f78991g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ AutoHideSoftInputDialog f78992h;

        public i(j.a.a.e.o.d.b bVar, EditText editText, Activity activity, AutoHideSoftInputDialog autoHideSoftInputDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, editText, activity, autoHideSoftInputDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f78989e = bVar;
            this.f78990f = editText;
            this.f78991g = activity;
            this.f78992h = autoHideSoftInputDialog;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f78989e != null) {
                    EditText etInput = this.f78990f;
                    Intrinsics.checkExpressionValueIsNotNull(etInput, "etInput");
                    int c2 = c.f78963a.c(this.f78991g, etInput.getText().toString());
                    if (c2 > 0) {
                        this.f78989e.b(c2);
                        j.a.a.e.n.d.a(this.f78991g, this.f78990f);
                    } else {
                        RLog.error("DialogUtils", "btnOk amount <= 0", new Object[0]);
                    }
                }
                this.f78992h.dismiss();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2013394298, "Lj/a/a/e/o/d/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2013394298, "Lj/a/a/e/o/d/c;");
                return;
            }
        }
        f78963a = new c();
    }

    public c() {
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
                Toast.makeText(context, j.a.a.e.f.pay_ui_string_pls_input_correct_recharge_amount, 1).show();
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
                    Toast.makeText(context, j.a.a.e.f.pay_ui_string_pls_input_correct_recharge_amount, 1).show();
                    return 0;
                } else if (parseInt > 500000) {
                    Toast.makeText(context, j.a.a.e.f.pay_ui_string_pay_error_oversize, 1).show();
                    return 0;
                } else {
                    return parseInt;
                }
            } catch (Exception unused) {
                Toast.makeText(context, j.a.a.e.f.pay_ui_string_pls_input_correct_recharge_amount, 1).show();
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
            double b2 = j.a.a.e.n.g.b(str);
            return b2 >= 0.1d && b2 <= 500000.0d;
        }
        return invokeL.booleanValue;
    }

    public final Dialog f(Activity activity, j.a.a.e.o.d.b bVar, IViewEventListener iViewEventListener, PayDialogType payDialogType, PayUIKitConfig payUIKitConfig) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048579, this, activity, bVar, iViewEventListener, payDialogType, payUIKitConfig)) == null) {
            if (!j.a.a.e.n.i.f78937a.a(activity)) {
                RLog.error("DialogUtils", "showSimpleNumberInputDialog ActivityInvalid....", new Object[0]);
                return null;
            }
            AutoHideSoftInputDialog autoHideSoftInputDialog = new AutoHideSoftInputDialog(activity, j.a.a.e.g.PayUi_Number_Input_Dialog);
            autoHideSoftInputDialog.setCancelable(true);
            autoHideSoftInputDialog.setCanceledOnTouchOutside(true);
            autoHideSoftInputDialog.show();
            autoHideSoftInputDialog.setOnDismissListener(new b(bVar, autoHideSoftInputDialog));
            autoHideSoftInputDialog.setOnCancelListener(new DialogInterface$OnCancelListenerC2148c(autoHideSoftInputDialog, bVar));
            Window window = autoHideSoftInputDialog.getWindow();
            View inflate = LayoutInflater.from(new ContextThemeWrapper(activity, j.a.a.e.n.h.f78936a.a(payUIKitConfig))).inflate(j.a.a.e.e.pay_ui_dialog_input_number, (ViewGroup) null, false);
            if (window == null) {
                Intrinsics.throwNpe();
            }
            window.setContentView(inflate);
            window.clearFlags(131072);
            window.setSoftInputMode(21);
            window.setWindowAnimations(j.a.a.e.g.PayUi_Dialog_Window_Anim);
            WindowManager.LayoutParams attributes = window.getAttributes();
            Intrinsics.checkExpressionValueIsNotNull(attributes, "window\n                .getAttributes()");
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
            window.findViewById(j.a.a.e.d.rl_root).setOnClickListener(new d(payDialogType, autoHideSoftInputDialog, iViewEventListener, bVar));
            TextView textView = (TextView) window.findViewById(j.a.a.e.d.tv_amount_hint);
            TextView textView2 = (TextView) window.findViewById(j.a.a.e.d.tv_input_amount);
            EditText etInput = (EditText) window.findViewById(j.a.a.e.d.et_input_text);
            TextView btnOk = (TextView) window.findViewById(j.a.a.e.d.btn_pay);
            Intrinsics.checkExpressionValueIsNotNull(btnOk, "btnOk");
            btnOk.setEnabled(false);
            Button button = (Button) window.findViewById(j.a.a.e.d.btn_close);
            String string = activity.getResources().getString(j.a.a.e.f.pay_ui_string_custom_amount);
            Intrinsics.checkExpressionValueIsNotNull(string, "mContext.getResources().…_ui_string_custom_amount)");
            Intrinsics.checkExpressionValueIsNotNull(etInput, "etInput");
            etInput.setHint(string);
            etInput.setFilters(new InputFilter[]{new InputFilter.LengthFilter(8), d(2)});
            etInput.setOnEditorActionListener(new e(etInput, bVar, activity, autoHideSoftInputDialog, textView));
            etInput.addTextChangedListener(new f(textView2, btnOk, etInput, textView, activity));
            etInput.postDelayed(new g(etInput, activity), 100L);
            button.setOnClickListener(new h(payDialogType, autoHideSoftInputDialog, iViewEventListener, bVar));
            btnOk.setOnClickListener(new i(bVar, etInput, activity, autoHideSoftInputDialog));
            return autoHideSoftInputDialog;
        }
        return (Dialog) invokeLLLLL.objValue;
    }
}
