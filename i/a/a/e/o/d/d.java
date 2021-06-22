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
/* loaded from: classes8.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final d f72299a = new d();

    /* loaded from: classes8.dex */
    public static final class a implements InputFilter {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f72300e;

        public a(int i2) {
            this.f72300e = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.text.InputFilter
        /* renamed from: a */
        public final String filter(CharSequence charSequence, int i2, int i3, Spanned spanned, int i4, int i5) {
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
                    if (substring.length() == this.f72300e + 1) {
                        return "";
                    }
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
            }
            return null;
        }
    }

    /* loaded from: classes8.dex */
    public static final class b implements DialogInterface.OnDismissListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef f72301e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef f72302f;

        public b(Ref.ObjectRef objectRef, Ref.ObjectRef objectRef2) {
            this.f72301e = objectRef;
            this.f72302f = objectRef2;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface dialogInterface) {
            WeakReference weakReference = (WeakReference) this.f72301e.element;
            if ((weakReference != null ? (i.a.a.e.o.d.c) weakReference.get() : null) != null) {
                WeakReference weakReference2 = (WeakReference) this.f72301e.element;
                i.a.a.e.o.d.c cVar = weakReference2 != null ? (i.a.a.e.o.d.c) weakReference2.get() : null;
                if (cVar == null) {
                    Intrinsics.throwNpe();
                }
                cVar.a(CancelType.ON_DIALOG_DISMISS);
            }
            WeakReference weakReference3 = (WeakReference) this.f72302f.element;
            if ((weakReference3 != null ? (Dialog) weakReference3.get() : null) != null) {
                WeakReference weakReference4 = (WeakReference) this.f72302f.element;
                Dialog dialog = weakReference4 != null ? (Dialog) weakReference4.get() : null;
                if (dialog == null) {
                    Intrinsics.throwNpe();
                }
                dialog.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class c implements DialogInterface.OnCancelListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef f72303e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef f72304f;

        public c(Ref.ObjectRef objectRef, Ref.ObjectRef objectRef2) {
            this.f72303e = objectRef;
            this.f72304f = objectRef2;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface dialogInterface) {
            WeakReference weakReference = (WeakReference) this.f72303e.element;
            if ((weakReference != null ? (Dialog) weakReference.get() : null) != null) {
                WeakReference weakReference2 = (WeakReference) this.f72303e.element;
                Dialog dialog = weakReference2 != null ? (Dialog) weakReference2.get() : null;
                if (dialog == null) {
                    Intrinsics.throwNpe();
                }
                dialog.dismiss();
            }
            WeakReference weakReference3 = (WeakReference) this.f72304f.element;
            if ((weakReference3 != null ? (i.a.a.e.o.d.c) weakReference3.get() : null) != null) {
                WeakReference weakReference4 = (WeakReference) this.f72304f.element;
                i.a.a.e.o.d.c cVar = weakReference4 != null ? (i.a.a.e.o.d.c) weakReference4.get() : null;
                if (cVar == null) {
                    Intrinsics.throwNpe();
                }
                cVar.a(CancelType.ON_DIALOG_CANCEL);
            }
        }
    }

    /* renamed from: i.a.a.e.o.d.d$d  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class View$OnClickListenerC1999d implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PayDialogType f72305e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ i.a.a.e.o.d.a f72306f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ IViewEventListener f72307g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ i.a.a.e.o.d.c f72308h;

        public View$OnClickListenerC1999d(PayDialogType payDialogType, i.a.a.e.o.d.a aVar, IViewEventListener iViewEventListener, i.a.a.e.o.d.c cVar) {
            this.f72305e = payDialogType;
            this.f72306f = aVar;
            this.f72307g = iViewEventListener;
            this.f72308h = cVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            PayViewInfo payViewInfo = new PayViewInfo();
            payViewInfo.clickArea = CancelType.EMPTY_AREA_CLICK;
            payViewInfo.payDialogType = this.f72305e;
            payViewInfo.viewDialog = this.f72306f;
            IViewEventListener iViewEventListener = this.f72307g;
            if (iViewEventListener == null || !iViewEventListener.onInterceptView(payViewInfo)) {
                i.a.a.e.o.d.c cVar = this.f72308h;
                if (cVar != null) {
                    cVar.a(CancelType.EMPTY_AREA_CLICK);
                }
                this.f72306f.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class e implements TextView.OnEditorActionListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EditText f72309a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ i.a.a.e.o.d.c f72310b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Activity f72311c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ i.a.a.e.o.d.a f72312d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TextView f72313e;

        public e(EditText editText, i.a.a.e.o.d.c cVar, Activity activity, i.a.a.e.o.d.a aVar, TextView textView) {
            this.f72309a = editText;
            this.f72310b = cVar;
            this.f72311c = activity;
            this.f72312d = aVar;
            this.f72313e = textView;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
            if (i2 == 6) {
                d dVar = d.f72299a;
                EditText etInput = this.f72309a;
                Intrinsics.checkExpressionValueIsNotNull(etInput, "etInput");
                boolean e2 = dVar.e(etInput.getText().toString());
                if (e2) {
                    if (this.f72310b != null) {
                        EditText etInput2 = this.f72309a;
                        Intrinsics.checkExpressionValueIsNotNull(etInput2, "etInput");
                        int c2 = d.f72299a.c(this.f72311c, etInput2.getText().toString());
                        if (c2 > 0) {
                            this.f72310b.b(c2);
                            i.a.a.e.n.c.a(this.f72311c, this.f72309a);
                        } else {
                            RLog.error("DialogUtils", "tOnEditorAction amount <= 0", new Object[0]);
                        }
                    }
                    this.f72312d.dismiss();
                }
                this.f72313e.setTextColor(this.f72311c.getResources().getColor(e2 ? i.a.a.e.a.pay_ui_color_858585 : i.a.a.e.a.pay_ui_color_FF3355));
            }
            return false;
        }
    }

    /* loaded from: classes8.dex */
    public static final class f implements TextWatcher {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TextView f72314e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TextView f72315f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ EditText f72316g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ TextView f72317h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Activity f72318i;

        public f(TextView textView, TextView textView2, EditText editText, TextView textView3, Activity activity) {
            this.f72314e = textView;
            this.f72315f = textView2;
            this.f72316g = editText;
            this.f72317h = textView3;
            this.f72318i = activity;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            double b2;
            if (editable != null && !Intrinsics.areEqual(editable.toString(), "")) {
                if (!Intrinsics.areEqual(editable.toString(), "0")) {
                    boolean e2 = d.f72299a.e(editable.toString());
                    TextView btnOk = this.f72315f;
                    Intrinsics.checkExpressionValueIsNotNull(btnOk, "btnOk");
                    btnOk.setEnabled(e2);
                    if (i.a.a.e.n.f.b(editable.toString()) >= 10000) {
                        String str = i.a.a.e.n.f.a(b2 / 10000.0f) + (char) 19975;
                        TextView tvInputAmount = this.f72314e;
                        Intrinsics.checkExpressionValueIsNotNull(tvInputAmount, "tvInputAmount");
                        tvInputAmount.setText(str);
                    } else {
                        TextView tvInputAmount2 = this.f72314e;
                        Intrinsics.checkExpressionValueIsNotNull(tvInputAmount2, "tvInputAmount");
                        tvInputAmount2.setText(editable);
                    }
                    this.f72317h.setTextColor(this.f72318i.getResources().getColor(e2 ? i.a.a.e.a.pay_ui_color_858585 : i.a.a.e.a.pay_ui_color_FF3355));
                    return;
                }
                this.f72316g.setText("");
                TextView btnOk2 = this.f72315f;
                Intrinsics.checkExpressionValueIsNotNull(btnOk2, "btnOk");
                btnOk2.setEnabled(false);
                return;
            }
            TextView tvInputAmount3 = this.f72314e;
            Intrinsics.checkExpressionValueIsNotNull(tvInputAmount3, "tvInputAmount");
            tvInputAmount3.setText("");
            TextView btnOk3 = this.f72315f;
            Intrinsics.checkExpressionValueIsNotNull(btnOk3, "btnOk");
            btnOk3.setEnabled(false);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }
    }

    /* loaded from: classes8.dex */
    public static final class g implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ EditText f72319e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Activity f72320f;

        public g(EditText editText, Activity activity) {
            this.f72319e = editText;
            this.f72320f = activity;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f72319e.requestFocus();
            Activity activity = this.f72320f;
            if (activity == null) {
                throw new TypeCastException("null cannot be cast to non-null type android.app.Activity");
            }
            i.a.a.e.n.c.b(activity, this.f72319e);
        }
    }

    /* loaded from: classes8.dex */
    public static final class h implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PayDialogType f72321e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ i.a.a.e.o.d.a f72322f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ IViewEventListener f72323g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ i.a.a.e.o.d.c f72324h;

        public h(PayDialogType payDialogType, i.a.a.e.o.d.a aVar, IViewEventListener iViewEventListener, i.a.a.e.o.d.c cVar) {
            this.f72321e = payDialogType;
            this.f72322f = aVar;
            this.f72323g = iViewEventListener;
            this.f72324h = cVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            PayViewInfo payViewInfo = new PayViewInfo();
            payViewInfo.clickArea = CancelType.BUTTOM_AREA_CLICK;
            payViewInfo.payDialogType = this.f72321e;
            payViewInfo.viewDialog = this.f72322f;
            IViewEventListener iViewEventListener = this.f72323g;
            if (iViewEventListener == null || !iViewEventListener.onInterceptView(payViewInfo)) {
                i.a.a.e.o.d.c cVar = this.f72324h;
                if (cVar != null) {
                    cVar.a(CancelType.BUTTOM_AREA_CLICK);
                }
                this.f72322f.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class i implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i.a.a.e.o.d.c f72325e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ EditText f72326f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Activity f72327g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ i.a.a.e.o.d.a f72328h;

        public i(i.a.a.e.o.d.c cVar, EditText editText, Activity activity, i.a.a.e.o.d.a aVar) {
            this.f72325e = cVar;
            this.f72326f = editText;
            this.f72327g = activity;
            this.f72328h = aVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (this.f72325e != null) {
                EditText etInput = this.f72326f;
                Intrinsics.checkExpressionValueIsNotNull(etInput, "etInput");
                int c2 = d.f72299a.c(this.f72327g, etInput.getText().toString());
                if (c2 > 0) {
                    this.f72325e.b(c2);
                    i.a.a.e.n.c.a(this.f72327g, this.f72326f);
                } else {
                    RLog.error("DialogUtils", "btnOk amount <= 0", new Object[0]);
                }
            }
            this.f72328h.dismiss();
        }
    }

    public final int c(Context context, String str) {
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

    public final InputFilter d(int i2) {
        return new a(i2);
    }

    public final boolean e(String str) {
        double b2 = i.a.a.e.n.f.b(str);
        return b2 >= 0.1d && b2 <= 500000.0d;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: T */
    /* JADX DEBUG: Multi-variable search result rejected for r5v1, resolved type: T */
    /* JADX DEBUG: Multi-variable search result rejected for r5v12, resolved type: T */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [T, java.lang.ref.WeakReference] */
    public final Dialog f(Activity activity, i.a.a.e.o.d.c cVar, IViewEventListener iViewEventListener, PayDialogType payDialogType, PayUIKitConfig payUIKitConfig) {
        if (!i.a.a.e.n.h.f72272a.a(activity)) {
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
        View inflate = LayoutInflater.from(new ContextThemeWrapper(activity, i.a.a.e.n.g.f72271a.a(payUIKitConfig))).inflate(i.a.a.e.e.pay_ui_dialog_input_number, (ViewGroup) null, false);
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
        window.findViewById(i.a.a.e.d.rl_root).setOnClickListener(new View$OnClickListenerC1999d(payDialogType, aVar, iViewEventListener, cVar));
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
}
