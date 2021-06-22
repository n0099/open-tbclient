package d.a.m0.h.o0.f;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.searchbox.common.runtime.AppRuntime;
import d.a.m0.a.k;
import d.a.m0.h.u.a;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public RelativeLayout f51340a;

    /* renamed from: b  reason: collision with root package name */
    public EditText f51341b;

    /* renamed from: c  reason: collision with root package name */
    public EditText f51342c;

    /* renamed from: d  reason: collision with root package name */
    public RelativeLayout f51343d;

    /* renamed from: e  reason: collision with root package name */
    public Button f51344e;

    /* renamed from: g  reason: collision with root package name */
    public a.f f51346g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.m0.h.u.c f51347h;

    /* renamed from: f  reason: collision with root package name */
    public boolean f51345f = false;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f51348i = new View$OnClickListenerC1099a();
    public TextWatcher j = new b();
    public TextView.OnEditorActionListener k = new c();

    /* renamed from: d.a.m0.h.o0.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC1099a implements View.OnClickListener {
        public View$OnClickListenerC1099a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f51342c == null || !a.this.f51345f) {
                return;
            }
            if (a.this.f51346g != null) {
                a.this.f51346g.c(a.this.f51342c.getText().toString());
            }
            if (a.this.f51347h == null || a.this.f51347h.f51482d || a.this.f51346g == null) {
                return;
            }
            a.this.f51346g.a();
            a.this.m("");
        }
    }

    /* loaded from: classes3.dex */
    public class b implements TextWatcher {

        /* renamed from: d.a.m0.h.o0.f.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC1100a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Editable f51351e;

            public RunnableC1100a(Editable editable) {
                this.f51351e = editable;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (TextUtils.isEmpty(this.f51351e.toString())) {
                    a.this.f51344e.setEnabled(false);
                } else if (a.this.f51344e.isEnabled()) {
                } else {
                    a.this.f51344e.setEnabled(true);
                }
            }
        }

        public b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (a.this.f51346g != null) {
                a.this.f51346g.e(editable.toString());
            }
            a.this.f51344e.post(new RunnableC1100a(editable));
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }
    }

    /* loaded from: classes3.dex */
    public class c implements TextView.OnEditorActionListener {
        public c() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
            if (a.this.f51347h == null || a.this.f51347h.f51483e != i2 || a.this.f51342c == null || !a.this.f51345f) {
                return false;
            }
            if (a.this.f51346g != null) {
                a.this.f51346g.c(a.this.f51342c.getText().toString());
            }
            if (a.this.f51347h.f51482d || a.this.f51346g == null) {
                return true;
            }
            a.this.f51346g.a();
            a.this.m("");
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f51344e.setEnabled(false);
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.h.u.c f51355e;

        public e(d.a.m0.h.u.c cVar) {
            this.f51355e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            int length;
            try {
                if (a.this.f51342c.getText().length() <= this.f51355e.f51479a.length()) {
                    length = a.this.f51342c.getText().length();
                } else {
                    length = this.f51355e.f51479a.length();
                }
                a.this.f51342c.setSelection(length);
            } catch (Exception e2) {
                if (k.f46983a) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f51357e;

        public f(String str) {
            this.f51357e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f51342c.setSelection(this.f51357e.length());
        }
    }

    @SuppressLint({"InflateParams"})
    public a(Context context) {
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(context).inflate(d.a.m0.f.f.aiapps_ai_games_input_view, (ViewGroup) null);
        this.f51340a = relativeLayout;
        this.f51341b = (EditText) relativeLayout.findViewById(d.a.m0.f.e.ai_games_virtual_input_et);
        this.f51343d = (RelativeLayout) this.f51340a.findViewById(d.a.m0.f.e.ai_games_real_input_container);
        this.f51342c = (EditText) this.f51340a.findViewById(d.a.m0.f.e.ai_games_real_input_et);
        Button button = (Button) this.f51340a.findViewById(d.a.m0.f.e.ai_games_input_send_btn);
        this.f51344e = button;
        button.setOnClickListener(this.f51348i);
        this.f51342c.addTextChangedListener(this.j);
        this.f51342c.setOnEditorActionListener(this.k);
        this.f51344e.post(new d());
    }

    public View f() {
        return this.f51340a;
    }

    public boolean g() {
        return this.f51345f;
    }

    public void h() {
        EditText editText;
        EditText editText2;
        InputMethodManager inputMethodManager = (InputMethodManager) AppRuntime.getAppContext().getSystemService("input_method");
        if (!inputMethodManager.isActive() || (editText = this.f51342c) == null) {
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(editText.getApplicationWindowToken(), 0);
        this.f51345f = false;
        this.f51341b.setVisibility(8);
        this.f51343d.setVisibility(8);
        a.f fVar = this.f51346g;
        if (fVar == null || (editText2 = this.f51342c) == null) {
            return;
        }
        fVar.d(editText2.getText().toString());
    }

    public void i(a.f fVar) {
        this.f51346g = fVar;
    }

    public void j(d.a.m0.h.u.c cVar) {
        this.f51347h = cVar;
        if (this.f51342c == null || cVar == null) {
            return;
        }
        if (!TextUtils.isEmpty(cVar.f51479a)) {
            this.f51342c.setText(cVar.f51479a);
            if (cVar.f51480b > 0) {
                if (!TextUtils.isEmpty(cVar.f51479a) && cVar.f51479a.length() > cVar.f51480b) {
                    cVar.f51480b = cVar.f51479a.length();
                }
                this.f51342c.setFilters(new InputFilter[]{new InputFilter.LengthFilter(cVar.f51480b)});
            }
            this.f51342c.postDelayed(new e(cVar), 300L);
        } else {
            this.f51342c.setText("");
        }
        this.f51344e.setEnabled(!TextUtils.isEmpty(cVar.f51479a));
        if (cVar.f51481c) {
            this.f51342c.setMinLines(1);
            this.f51342c.setInputType(131073);
            this.f51344e.setText(cVar.f51484f);
            return;
        }
        this.f51342c.setMaxLines(1);
        this.f51342c.setInputType(1);
    }

    public void k(int i2) {
        this.f51343d.setVisibility(0);
        this.f51342c.setFocusableInTouchMode(true);
        this.f51342c.requestFocus();
        this.f51341b.setVisibility(8);
        this.f51345f = true;
        a.f fVar = this.f51346g;
        if (fVar != null) {
            fVar.b(i2);
        }
    }

    public boolean l() {
        if (this.f51345f) {
            return false;
        }
        this.f51341b.setVisibility(0);
        this.f51343d.setVisibility(8);
        this.f51341b.setFocusableInTouchMode(true);
        this.f51341b.requestFocus();
        ((InputMethodManager) AppRuntime.getAppContext().getSystemService("input_method")).showSoftInput(this.f51341b, 0);
        return true;
    }

    public boolean m(String str) {
        EditText editText;
        if (!this.f51345f || (editText = this.f51342c) == null) {
            return false;
        }
        editText.setText(str);
        this.f51342c.postDelayed(new f(str), 300L);
        return true;
    }
}
