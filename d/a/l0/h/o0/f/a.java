package d.a.l0.h.o0.f;

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
import d.a.l0.a.k;
import d.a.l0.h.u.a;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public RelativeLayout f51232a;

    /* renamed from: b  reason: collision with root package name */
    public EditText f51233b;

    /* renamed from: c  reason: collision with root package name */
    public EditText f51234c;

    /* renamed from: d  reason: collision with root package name */
    public RelativeLayout f51235d;

    /* renamed from: e  reason: collision with root package name */
    public Button f51236e;

    /* renamed from: g  reason: collision with root package name */
    public a.f f51238g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.l0.h.u.c f51239h;

    /* renamed from: f  reason: collision with root package name */
    public boolean f51237f = false;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f51240i = new View$OnClickListenerC1096a();
    public TextWatcher j = new b();
    public TextView.OnEditorActionListener k = new c();

    /* renamed from: d.a.l0.h.o0.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC1096a implements View.OnClickListener {
        public View$OnClickListenerC1096a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f51234c == null || !a.this.f51237f) {
                return;
            }
            if (a.this.f51238g != null) {
                a.this.f51238g.c(a.this.f51234c.getText().toString());
            }
            if (a.this.f51239h == null || a.this.f51239h.f51374d || a.this.f51238g == null) {
                return;
            }
            a.this.f51238g.a();
            a.this.m("");
        }
    }

    /* loaded from: classes3.dex */
    public class b implements TextWatcher {

        /* renamed from: d.a.l0.h.o0.f.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC1097a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Editable f51243e;

            public RunnableC1097a(Editable editable) {
                this.f51243e = editable;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (TextUtils.isEmpty(this.f51243e.toString())) {
                    a.this.f51236e.setEnabled(false);
                } else if (a.this.f51236e.isEnabled()) {
                } else {
                    a.this.f51236e.setEnabled(true);
                }
            }
        }

        public b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (a.this.f51238g != null) {
                a.this.f51238g.e(editable.toString());
            }
            a.this.f51236e.post(new RunnableC1097a(editable));
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
            if (a.this.f51239h == null || a.this.f51239h.f51375e != i2 || a.this.f51234c == null || !a.this.f51237f) {
                return false;
            }
            if (a.this.f51238g != null) {
                a.this.f51238g.c(a.this.f51234c.getText().toString());
            }
            if (a.this.f51239h.f51374d || a.this.f51238g == null) {
                return true;
            }
            a.this.f51238g.a();
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
            a.this.f51236e.setEnabled(false);
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.h.u.c f51247e;

        public e(d.a.l0.h.u.c cVar) {
            this.f51247e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            int length;
            try {
                if (a.this.f51234c.getText().length() <= this.f51247e.f51371a.length()) {
                    length = a.this.f51234c.getText().length();
                } else {
                    length = this.f51247e.f51371a.length();
                }
                a.this.f51234c.setSelection(length);
            } catch (Exception e2) {
                if (k.f46875a) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f51249e;

        public f(String str) {
            this.f51249e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f51234c.setSelection(this.f51249e.length());
        }
    }

    @SuppressLint({"InflateParams"})
    public a(Context context) {
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(context).inflate(d.a.l0.f.f.aiapps_ai_games_input_view, (ViewGroup) null);
        this.f51232a = relativeLayout;
        this.f51233b = (EditText) relativeLayout.findViewById(d.a.l0.f.e.ai_games_virtual_input_et);
        this.f51235d = (RelativeLayout) this.f51232a.findViewById(d.a.l0.f.e.ai_games_real_input_container);
        this.f51234c = (EditText) this.f51232a.findViewById(d.a.l0.f.e.ai_games_real_input_et);
        Button button = (Button) this.f51232a.findViewById(d.a.l0.f.e.ai_games_input_send_btn);
        this.f51236e = button;
        button.setOnClickListener(this.f51240i);
        this.f51234c.addTextChangedListener(this.j);
        this.f51234c.setOnEditorActionListener(this.k);
        this.f51236e.post(new d());
    }

    public View f() {
        return this.f51232a;
    }

    public boolean g() {
        return this.f51237f;
    }

    public void h() {
        EditText editText;
        EditText editText2;
        InputMethodManager inputMethodManager = (InputMethodManager) AppRuntime.getAppContext().getSystemService("input_method");
        if (!inputMethodManager.isActive() || (editText = this.f51234c) == null) {
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(editText.getApplicationWindowToken(), 0);
        this.f51237f = false;
        this.f51233b.setVisibility(8);
        this.f51235d.setVisibility(8);
        a.f fVar = this.f51238g;
        if (fVar == null || (editText2 = this.f51234c) == null) {
            return;
        }
        fVar.d(editText2.getText().toString());
    }

    public void i(a.f fVar) {
        this.f51238g = fVar;
    }

    public void j(d.a.l0.h.u.c cVar) {
        this.f51239h = cVar;
        if (this.f51234c == null || cVar == null) {
            return;
        }
        if (!TextUtils.isEmpty(cVar.f51371a)) {
            this.f51234c.setText(cVar.f51371a);
            if (cVar.f51372b > 0) {
                if (!TextUtils.isEmpty(cVar.f51371a) && cVar.f51371a.length() > cVar.f51372b) {
                    cVar.f51372b = cVar.f51371a.length();
                }
                this.f51234c.setFilters(new InputFilter[]{new InputFilter.LengthFilter(cVar.f51372b)});
            }
            this.f51234c.postDelayed(new e(cVar), 300L);
        } else {
            this.f51234c.setText("");
        }
        this.f51236e.setEnabled(!TextUtils.isEmpty(cVar.f51371a));
        if (cVar.f51373c) {
            this.f51234c.setMinLines(1);
            this.f51234c.setInputType(131073);
            this.f51236e.setText(cVar.f51376f);
            return;
        }
        this.f51234c.setMaxLines(1);
        this.f51234c.setInputType(1);
    }

    public void k(int i2) {
        this.f51235d.setVisibility(0);
        this.f51234c.setFocusableInTouchMode(true);
        this.f51234c.requestFocus();
        this.f51233b.setVisibility(8);
        this.f51237f = true;
        a.f fVar = this.f51238g;
        if (fVar != null) {
            fVar.b(i2);
        }
    }

    public boolean l() {
        if (this.f51237f) {
            return false;
        }
        this.f51233b.setVisibility(0);
        this.f51235d.setVisibility(8);
        this.f51233b.setFocusableInTouchMode(true);
        this.f51233b.requestFocus();
        ((InputMethodManager) AppRuntime.getAppContext().getSystemService("input_method")).showSoftInput(this.f51233b, 0);
        return true;
    }

    public boolean m(String str) {
        EditText editText;
        if (!this.f51237f || (editText = this.f51234c) == null) {
            return false;
        }
        editText.setText(str);
        this.f51234c.postDelayed(new f(str), 300L);
        return true;
    }
}
