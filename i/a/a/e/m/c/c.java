package i.a.a.e.m.c;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
/* loaded from: classes8.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final c f68901a = new c();

    /* loaded from: classes8.dex */
    public static final class a implements InputFilter {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f68902e;

        public a(int i2) {
            this.f68902e = i2;
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
                    if (substring.length() == this.f68902e + 1) {
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
        public final /* synthetic */ i.a.a.e.m.c.b f68903e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ i.a.a.e.m.c.a f68904f;

        public b(i.a.a.e.m.c.b bVar, i.a.a.e.m.c.a aVar) {
            this.f68903e = bVar;
            this.f68904f = aVar;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface dialogInterface) {
            i.a.a.e.m.c.b bVar = this.f68903e;
            if (bVar != null) {
                bVar.cancel();
            }
            this.f68904f.dismiss();
        }
    }

    /* renamed from: i.a.a.e.m.c.c$c  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class DialogInterface$OnCancelListenerC1945c implements DialogInterface.OnCancelListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i.a.a.e.m.c.a f68905e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ i.a.a.e.m.c.b f68906f;

        public DialogInterface$OnCancelListenerC1945c(i.a.a.e.m.c.a aVar, i.a.a.e.m.c.b bVar) {
            this.f68905e = aVar;
            this.f68906f = bVar;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface dialogInterface) {
            this.f68905e.dismiss();
            i.a.a.e.m.c.b bVar = this.f68906f;
            if (bVar != null) {
                bVar.cancel();
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class d implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i.a.a.e.m.c.a f68907e;

        public d(i.a.a.e.m.c.a aVar) {
            this.f68907e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.f68907e.dismiss();
        }
    }

    /* loaded from: classes8.dex */
    public static final class e implements TextView.OnEditorActionListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EditText f68908a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ i.a.a.e.m.c.b f68909b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Activity f68910c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ i.a.a.e.m.c.a f68911d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TextView f68912e;

        public e(EditText editText, i.a.a.e.m.c.b bVar, Activity activity, i.a.a.e.m.c.a aVar, TextView textView) {
            this.f68908a = editText;
            this.f68909b = bVar;
            this.f68910c = activity;
            this.f68911d = aVar;
            this.f68912e = textView;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
            if (i2 == 6) {
                c cVar = c.f68901a;
                EditText etInput = this.f68908a;
                Intrinsics.checkExpressionValueIsNotNull(etInput, "etInput");
                boolean e2 = cVar.e(etInput.getText().toString());
                if (e2) {
                    if (this.f68909b != null) {
                        EditText etInput2 = this.f68908a;
                        Intrinsics.checkExpressionValueIsNotNull(etInput2, "etInput");
                        int c2 = c.f68901a.c(this.f68910c, etInput2.getText().toString());
                        if (c2 > 0) {
                            this.f68909b.a(c2);
                            i.a.a.e.l.c.a(this.f68910c, this.f68908a);
                        } else {
                            d.r.b.a.a.f.d.d.e("DialogUtils", "tOnEditorAction amount <= 0", new Object[0]);
                        }
                    }
                    this.f68911d.dismiss();
                }
                this.f68912e.setTextColor(this.f68910c.getResources().getColor(e2 ? i.a.a.e.a.color_858585 : i.a.a.e.a.color_FF3355));
            }
            return false;
        }
    }

    /* loaded from: classes8.dex */
    public static final class f implements TextWatcher {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TextView f68913e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TextView f68914f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ EditText f68915g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ TextView f68916h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Activity f68917i;

        public f(TextView textView, TextView textView2, EditText editText, TextView textView3, Activity activity) {
            this.f68913e = textView;
            this.f68914f = textView2;
            this.f68915g = editText;
            this.f68916h = textView3;
            this.f68917i = activity;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            double b2;
            if (editable != null && !Intrinsics.areEqual(editable.toString(), "")) {
                if (!Intrinsics.areEqual(editable.toString(), "0")) {
                    boolean e2 = c.f68901a.e(editable.toString());
                    TextView btnOk = this.f68914f;
                    Intrinsics.checkExpressionValueIsNotNull(btnOk, "btnOk");
                    btnOk.setEnabled(e2);
                    if (i.a.a.e.l.d.b(editable.toString()) >= 10000) {
                        String str = i.a.a.e.l.d.a(b2 / 10000.0f) + (char) 19975;
                        TextView tvInputAmount = this.f68913e;
                        Intrinsics.checkExpressionValueIsNotNull(tvInputAmount, "tvInputAmount");
                        tvInputAmount.setText(str);
                    } else {
                        TextView tvInputAmount2 = this.f68913e;
                        Intrinsics.checkExpressionValueIsNotNull(tvInputAmount2, "tvInputAmount");
                        tvInputAmount2.setText(editable);
                    }
                    this.f68916h.setTextColor(this.f68917i.getResources().getColor(e2 ? i.a.a.e.a.color_858585 : i.a.a.e.a.color_FF3355));
                    return;
                }
                this.f68915g.setText("");
                TextView btnOk2 = this.f68914f;
                Intrinsics.checkExpressionValueIsNotNull(btnOk2, "btnOk");
                btnOk2.setEnabled(false);
                return;
            }
            TextView tvInputAmount3 = this.f68913e;
            Intrinsics.checkExpressionValueIsNotNull(tvInputAmount3, "tvInputAmount");
            tvInputAmount3.setText("");
            TextView btnOk3 = this.f68914f;
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
        public final /* synthetic */ EditText f68918e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Activity f68919f;

        public g(EditText editText, Activity activity) {
            this.f68918e = editText;
            this.f68919f = activity;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f68918e.requestFocus();
            Activity activity = this.f68919f;
            if (activity == null) {
                throw new TypeCastException("null cannot be cast to non-null type android.app.Activity");
            }
            i.a.a.e.l.c.b(activity, this.f68918e);
        }
    }

    /* loaded from: classes8.dex */
    public static final class h implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i.a.a.e.m.c.b f68920e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ i.a.a.e.m.c.a f68921f;

        public h(i.a.a.e.m.c.b bVar, i.a.a.e.m.c.a aVar) {
            this.f68920e = bVar;
            this.f68921f = aVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            i.a.a.e.m.c.b bVar = this.f68920e;
            if (bVar != null) {
                bVar.cancel();
            }
            this.f68921f.dismiss();
        }
    }

    /* loaded from: classes8.dex */
    public static final class i implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i.a.a.e.m.c.b f68922e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ EditText f68923f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Activity f68924g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ i.a.a.e.m.c.a f68925h;

        public i(i.a.a.e.m.c.b bVar, EditText editText, Activity activity, i.a.a.e.m.c.a aVar) {
            this.f68922e = bVar;
            this.f68923f = editText;
            this.f68924g = activity;
            this.f68925h = aVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (this.f68922e != null) {
                EditText etInput = this.f68923f;
                Intrinsics.checkExpressionValueIsNotNull(etInput, "etInput");
                int c2 = c.f68901a.c(this.f68924g, etInput.getText().toString());
                if (c2 > 0) {
                    this.f68922e.a(c2);
                    i.a.a.e.l.c.a(this.f68924g, this.f68923f);
                } else {
                    d.r.b.a.a.f.d.d.e("DialogUtils", "btnOk amount <= 0", new Object[0]);
                }
            }
            this.f68925h.dismiss();
        }
    }

    public final int c(Context context, String str) {
        if (str == null) {
            Toast.makeText(context, i.a.a.e.e.yy_string_pls_input_correct_recharge_amount, 1).show();
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
                Toast.makeText(context, i.a.a.e.e.yy_string_pls_input_correct_recharge_amount, 1).show();
                return 0;
            } else if (parseInt > 500000) {
                Toast.makeText(context, i.a.a.e.e.yy_string_pay_error_oversize, 1).show();
                return 0;
            } else {
                return parseInt;
            }
        } catch (Exception unused) {
            Toast.makeText(context, i.a.a.e.e.yy_string_pls_input_correct_recharge_amount, 1).show();
            return 0;
        }
    }

    public final InputFilter d(int i2) {
        return new a(i2);
    }

    public final boolean e(String str) {
        double b2 = i.a.a.e.l.d.b(str);
        return b2 >= 0.1d && b2 <= 500000.0d;
    }

    public final Dialog f(Activity activity, i.a.a.e.m.c.b bVar) {
        if (!i.a.a.e.l.e.f68885a.a(activity)) {
            d.r.b.a.a.f.d.d.e("DialogUtils", "showSimpleNumberInputDialog ActivityInvalid....", new Object[0]);
            return null;
        }
        i.a.a.e.m.c.a aVar = new i.a.a.e.m.c.a(activity, i.a.a.e.f.YY_Number_Input_Dialog);
        aVar.setCancelable(true);
        aVar.setCanceledOnTouchOutside(true);
        aVar.show();
        aVar.setOnDismissListener(new b(bVar, aVar));
        aVar.setOnCancelListener(new DialogInterface$OnCancelListenerC1945c(aVar, bVar));
        Window window = aVar.getWindow();
        if (window == null) {
            Intrinsics.throwNpe();
        }
        window.setContentView(i.a.a.e.d.yy_dialog_input_number);
        window.clearFlags(131072);
        window.setSoftInputMode(21);
        window.setWindowAnimations(i.a.a.e.f.YY_Dialog_Window_Anim);
        WindowManager.LayoutParams attributes = window.getAttributes();
        Intrinsics.checkExpressionValueIsNotNull(attributes, "window\n                .getAttributes()");
        attributes.width = -1;
        attributes.height = -2;
        window.setAttributes(attributes);
        window.findViewById(i.a.a.e.c.rl_root).setOnClickListener(new d(aVar));
        TextView textView = (TextView) window.findViewById(i.a.a.e.c.tv_amount_hint);
        TextView textView2 = (TextView) window.findViewById(i.a.a.e.c.tv_input_amount);
        EditText etInput = (EditText) window.findViewById(i.a.a.e.c.et_input_text);
        TextView btnOk = (TextView) window.findViewById(i.a.a.e.c.btn_pay);
        Intrinsics.checkExpressionValueIsNotNull(btnOk, "btnOk");
        btnOk.setEnabled(false);
        Button button = (Button) window.findViewById(i.a.a.e.c.btn_close);
        String string = activity.getResources().getString(i.a.a.e.e.string_custom_amount);
        Intrinsics.checkExpressionValueIsNotNull(string, "mContext.getResources().…ing.string_custom_amount)");
        Intrinsics.checkExpressionValueIsNotNull(etInput, "etInput");
        etInput.setHint(string);
        etInput.setFilters(new InputFilter[]{new InputFilter.LengthFilter(8), d(2)});
        etInput.setOnEditorActionListener(new e(etInput, bVar, activity, aVar, textView));
        etInput.addTextChangedListener(new f(textView2, btnOk, etInput, textView, activity));
        etInput.postDelayed(new g(etInput, activity), 100L);
        button.setOnClickListener(new h(bVar, aVar));
        btnOk.setOnClickListener(new i(bVar, etInput, activity, aVar));
        return aVar;
    }
}
