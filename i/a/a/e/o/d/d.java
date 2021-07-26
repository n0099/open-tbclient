package i.a.a.e.o.d;

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
import java.lang.ref.WeakReference;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringsKt;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.model.PayViewInfo;
import tv.athena.revenue.payui.view.IViewEventListener;
import tv.athena.revenue.payui.view.dialog.CancelType;
import tv.athena.revenue.payui.view.dialog.PayDialogType;
/* loaded from: classes9.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final d f73379a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public static final class a implements InputFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f73380e;

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
            this.f73380e = i2;
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
                        if (substring.length() == this.f73380e + 1) {
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

    /* loaded from: classes9.dex */
    public static final class b implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef f73381e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef f73382f;

        public b(Ref.ObjectRef objectRef, Ref.ObjectRef objectRef2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {objectRef, objectRef2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f73381e = objectRef;
            this.f73382f = objectRef2;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                WeakReference weakReference = (WeakReference) this.f73381e.element;
                if ((weakReference != null ? (i.a.a.e.o.d.c) weakReference.get() : null) != null) {
                    WeakReference weakReference2 = (WeakReference) this.f73381e.element;
                    i.a.a.e.o.d.c cVar = weakReference2 != null ? (i.a.a.e.o.d.c) weakReference2.get() : null;
                    if (cVar == null) {
                        Intrinsics.throwNpe();
                    }
                    cVar.a(CancelType.ON_DIALOG_DISMISS);
                }
                WeakReference weakReference3 = (WeakReference) this.f73382f.element;
                if ((weakReference3 != null ? (Dialog) weakReference3.get() : null) != null) {
                    WeakReference weakReference4 = (WeakReference) this.f73382f.element;
                    Dialog dialog = weakReference4 != null ? (Dialog) weakReference4.get() : null;
                    if (dialog == null) {
                        Intrinsics.throwNpe();
                    }
                    dialog.dismiss();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public static final class c implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef f73383e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef f73384f;

        public c(Ref.ObjectRef objectRef, Ref.ObjectRef objectRef2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {objectRef, objectRef2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f73383e = objectRef;
            this.f73384f = objectRef2;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                WeakReference weakReference = (WeakReference) this.f73383e.element;
                if ((weakReference != null ? (Dialog) weakReference.get() : null) != null) {
                    WeakReference weakReference2 = (WeakReference) this.f73383e.element;
                    Dialog dialog = weakReference2 != null ? (Dialog) weakReference2.get() : null;
                    if (dialog == null) {
                        Intrinsics.throwNpe();
                    }
                    dialog.dismiss();
                }
                WeakReference weakReference3 = (WeakReference) this.f73384f.element;
                if ((weakReference3 != null ? (i.a.a.e.o.d.c) weakReference3.get() : null) != null) {
                    WeakReference weakReference4 = (WeakReference) this.f73384f.element;
                    i.a.a.e.o.d.c cVar = weakReference4 != null ? (i.a.a.e.o.d.c) weakReference4.get() : null;
                    if (cVar == null) {
                        Intrinsics.throwNpe();
                    }
                    cVar.a(CancelType.ON_DIALOG_CANCEL);
                }
            }
        }
    }

    /* renamed from: i.a.a.e.o.d.d$d  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static final class View$OnClickListenerC2087d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PayDialogType f73385e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ i.a.a.e.o.d.a f73386f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ IViewEventListener f73387g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ i.a.a.e.o.d.c f73388h;

        public View$OnClickListenerC2087d(PayDialogType payDialogType, i.a.a.e.o.d.a aVar, IViewEventListener iViewEventListener, i.a.a.e.o.d.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {payDialogType, aVar, iViewEventListener, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f73385e = payDialogType;
            this.f73386f = aVar;
            this.f73387g = iViewEventListener;
            this.f73388h = cVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                PayViewInfo payViewInfo = new PayViewInfo();
                payViewInfo.clickArea = CancelType.EMPTY_AREA_CLICK;
                payViewInfo.payDialogType = this.f73385e;
                payViewInfo.viewDialog = this.f73386f;
                IViewEventListener iViewEventListener = this.f73387g;
                if (iViewEventListener == null || !iViewEventListener.onInterceptView(payViewInfo)) {
                    i.a.a.e.o.d.c cVar = this.f73388h;
                    if (cVar != null) {
                        cVar.a(CancelType.EMPTY_AREA_CLICK);
                    }
                    this.f73386f.dismiss();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public static final class e implements TextView.OnEditorActionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EditText f73389a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ i.a.a.e.o.d.c f73390b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Activity f73391c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ i.a.a.e.o.d.a f73392d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TextView f73393e;

        public e(EditText editText, i.a.a.e.o.d.c cVar, Activity activity, i.a.a.e.o.d.a aVar, TextView textView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {editText, cVar, activity, aVar, textView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f73389a = editText;
            this.f73390b = cVar;
            this.f73391c = activity;
            this.f73392d = aVar;
            this.f73393e = textView;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, textView, i2, keyEvent)) == null) {
                if (i2 == 6) {
                    d dVar = d.f73379a;
                    EditText etInput = this.f73389a;
                    Intrinsics.checkExpressionValueIsNotNull(etInput, "etInput");
                    boolean e2 = dVar.e(etInput.getText().toString());
                    if (e2) {
                        if (this.f73390b != null) {
                            EditText etInput2 = this.f73389a;
                            Intrinsics.checkExpressionValueIsNotNull(etInput2, "etInput");
                            int c2 = d.f73379a.c(this.f73391c, etInput2.getText().toString());
                            if (c2 > 0) {
                                this.f73390b.b(c2);
                                i.a.a.e.n.c.a(this.f73391c, this.f73389a);
                            } else {
                                RLog.error("DialogUtils", "tOnEditorAction amount <= 0", new Object[0]);
                            }
                        }
                        this.f73392d.dismiss();
                    }
                    this.f73393e.setTextColor(this.f73391c.getResources().getColor(e2 ? i.a.a.e.a.pay_ui_color_858585 : i.a.a.e.a.pay_ui_color_FF3355));
                }
                return false;
            }
            return invokeLIL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public static final class f implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TextView f73394e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TextView f73395f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ EditText f73396g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ TextView f73397h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Activity f73398i;

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
            this.f73394e = textView;
            this.f73395f = textView2;
            this.f73396g = editText;
            this.f73397h = textView3;
            this.f73398i = activity;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            double b2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                if (editable != null && !Intrinsics.areEqual(editable.toString(), "")) {
                    if (!Intrinsics.areEqual(editable.toString(), "0")) {
                        boolean e2 = d.f73379a.e(editable.toString());
                        TextView btnOk = this.f73395f;
                        Intrinsics.checkExpressionValueIsNotNull(btnOk, "btnOk");
                        btnOk.setEnabled(e2);
                        if (i.a.a.e.n.f.b(editable.toString()) >= 10000) {
                            String str = i.a.a.e.n.f.a(b2 / 10000.0f) + (char) 19975;
                            TextView tvInputAmount = this.f73394e;
                            Intrinsics.checkExpressionValueIsNotNull(tvInputAmount, "tvInputAmount");
                            tvInputAmount.setText(str);
                        } else {
                            TextView tvInputAmount2 = this.f73394e;
                            Intrinsics.checkExpressionValueIsNotNull(tvInputAmount2, "tvInputAmount");
                            tvInputAmount2.setText(editable);
                        }
                        this.f73397h.setTextColor(this.f73398i.getResources().getColor(e2 ? i.a.a.e.a.pay_ui_color_858585 : i.a.a.e.a.pay_ui_color_FF3355));
                        return;
                    }
                    this.f73396g.setText("");
                    TextView btnOk2 = this.f73395f;
                    Intrinsics.checkExpressionValueIsNotNull(btnOk2, "btnOk");
                    btnOk2.setEnabled(false);
                    return;
                }
                TextView tvInputAmount3 = this.f73394e;
                Intrinsics.checkExpressionValueIsNotNull(tvInputAmount3, "tvInputAmount");
                tvInputAmount3.setText("");
                TextView btnOk3 = this.f73395f;
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

    /* loaded from: classes9.dex */
    public static final class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ EditText f73399e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Activity f73400f;

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
            this.f73399e = editText;
            this.f73400f = activity;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f73399e.requestFocus();
                Activity activity = this.f73400f;
                if (activity == null) {
                    throw new TypeCastException("null cannot be cast to non-null type android.app.Activity");
                }
                i.a.a.e.n.c.b(activity, this.f73399e);
            }
        }
    }

    /* loaded from: classes9.dex */
    public static final class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PayDialogType f73401e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ i.a.a.e.o.d.a f73402f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ IViewEventListener f73403g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ i.a.a.e.o.d.c f73404h;

        public h(PayDialogType payDialogType, i.a.a.e.o.d.a aVar, IViewEventListener iViewEventListener, i.a.a.e.o.d.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {payDialogType, aVar, iViewEventListener, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f73401e = payDialogType;
            this.f73402f = aVar;
            this.f73403g = iViewEventListener;
            this.f73404h = cVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                PayViewInfo payViewInfo = new PayViewInfo();
                payViewInfo.clickArea = CancelType.BUTTOM_AREA_CLICK;
                payViewInfo.payDialogType = this.f73401e;
                payViewInfo.viewDialog = this.f73402f;
                IViewEventListener iViewEventListener = this.f73403g;
                if (iViewEventListener == null || !iViewEventListener.onInterceptView(payViewInfo)) {
                    i.a.a.e.o.d.c cVar = this.f73404h;
                    if (cVar != null) {
                        cVar.a(CancelType.BUTTOM_AREA_CLICK);
                    }
                    this.f73402f.dismiss();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public static final class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i.a.a.e.o.d.c f73405e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ EditText f73406f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Activity f73407g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ i.a.a.e.o.d.a f73408h;

        public i(i.a.a.e.o.d.c cVar, EditText editText, Activity activity, i.a.a.e.o.d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, editText, activity, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f73405e = cVar;
            this.f73406f = editText;
            this.f73407g = activity;
            this.f73408h = aVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f73405e != null) {
                    EditText etInput = this.f73406f;
                    Intrinsics.checkExpressionValueIsNotNull(etInput, "etInput");
                    int c2 = d.f73379a.c(this.f73407g, etInput.getText().toString());
                    if (c2 > 0) {
                        this.f73405e.b(c2);
                        i.a.a.e.n.c.a(this.f73407g, this.f73406f);
                    } else {
                        RLog.error("DialogUtils", "btnOk amount <= 0", new Object[0]);
                    }
                }
                this.f73408h.dismiss();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1776014342, "Li/a/a/e/o/d/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1776014342, "Li/a/a/e/o/d/d;");
                return;
            }
        }
        f73379a = new d();
    }

    public d() {
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
            double b2 = i.a.a.e.n.f.b(str);
            return b2 >= 0.1d && b2 <= 500000.0d;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: T */
    /* JADX DEBUG: Multi-variable search result rejected for r5v1, resolved type: T */
    /* JADX DEBUG: Multi-variable search result rejected for r5v12, resolved type: T */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [T, java.lang.ref.WeakReference] */
    public final Dialog f(Activity activity, i.a.a.e.o.d.c cVar, IViewEventListener iViewEventListener, PayDialogType payDialogType, PayUIKitConfig payUIKitConfig) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048579, this, activity, cVar, iViewEventListener, payDialogType, payUIKitConfig)) == null) {
            if (!i.a.a.e.n.h.f73352a.a(activity)) {
                RLog.error("DialogUtils", "showSimpleNumberInputDialog ActivityInvalid....", new Object[0]);
                return null;
            }
            i.a.a.e.o.d.a aVar = new i.a.a.e.o.d.a(activity, i.a.a.e.g.PayUi_Number_Input_Dialog);
            aVar.setCancelable(true);
            aVar.setCanceledOnTouchOutside(true);
            aVar.show();
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = new WeakReference(aVar);
            Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            objectRef2.element = cVar != null ? new WeakReference(cVar) : 0;
            aVar.setOnDismissListener(new b(objectRef2, objectRef));
            aVar.setOnCancelListener(new c(objectRef, objectRef2));
            Window window = aVar.getWindow();
            View inflate = LayoutInflater.from(new ContextThemeWrapper(activity, i.a.a.e.n.g.f73351a.a(payUIKitConfig))).inflate(i.a.a.e.e.pay_ui_dialog_input_number, (ViewGroup) null, false);
            if (window == null) {
                Intrinsics.throwNpe();
            }
            window.setContentView(inflate);
            window.clearFlags(131072);
            window.setSoftInputMode(21);
            window.setWindowAnimations(i.a.a.e.g.PayUi_Dialog_Window_Anim);
            WindowManager.LayoutParams attributes = window.getAttributes();
            Intrinsics.checkExpressionValueIsNotNull(attributes, "window\n                .getAttributes()");
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
            window.findViewById(i.a.a.e.d.rl_root).setOnClickListener(new View$OnClickListenerC2087d(payDialogType, aVar, iViewEventListener, cVar));
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
            etInput.setOnEditorActionListener(new e(etInput, cVar, activity, aVar, textView));
            etInput.addTextChangedListener(new f(textView2, btnOk, etInput, textView, activity));
            etInput.postDelayed(new g(etInput, activity), 100L);
            button.setOnClickListener(new h(payDialogType, aVar, iViewEventListener, cVar));
            btnOk.setOnClickListener(new i(cVar, etInput, activity, aVar));
            return aVar;
        }
        return (Dialog) invokeLLLLL.objValue;
    }
}
