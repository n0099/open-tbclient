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
    public RelativeLayout f47558a;

    /* renamed from: b  reason: collision with root package name */
    public EditText f47559b;

    /* renamed from: c  reason: collision with root package name */
    public EditText f47560c;

    /* renamed from: d  reason: collision with root package name */
    public RelativeLayout f47561d;

    /* renamed from: e  reason: collision with root package name */
    public Button f47562e;

    /* renamed from: g  reason: collision with root package name */
    public a.f f47564g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.l0.h.u.c f47565h;

    /* renamed from: f  reason: collision with root package name */
    public boolean f47563f = false;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f47566i = new View$OnClickListenerC1040a();
    public TextWatcher j = new b();
    public TextView.OnEditorActionListener k = new c();

    /* renamed from: d.a.l0.h.o0.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC1040a implements View.OnClickListener {
        public View$OnClickListenerC1040a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f47560c == null || !a.this.f47563f) {
                return;
            }
            if (a.this.f47564g != null) {
                a.this.f47564g.c(a.this.f47560c.getText().toString());
            }
            if (a.this.f47565h == null || a.this.f47565h.f47700d || a.this.f47564g == null) {
                return;
            }
            a.this.f47564g.a();
            a.this.m("");
        }
    }

    /* loaded from: classes3.dex */
    public class b implements TextWatcher {

        /* renamed from: d.a.l0.h.o0.f.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC1041a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Editable f47569e;

            public RunnableC1041a(Editable editable) {
                this.f47569e = editable;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (TextUtils.isEmpty(this.f47569e.toString())) {
                    a.this.f47562e.setEnabled(false);
                } else if (a.this.f47562e.isEnabled()) {
                } else {
                    a.this.f47562e.setEnabled(true);
                }
            }
        }

        public b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (a.this.f47564g != null) {
                a.this.f47564g.e(editable.toString());
            }
            a.this.f47562e.post(new RunnableC1041a(editable));
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
            if (a.this.f47565h == null || a.this.f47565h.f47701e != i2 || a.this.f47560c == null || !a.this.f47563f) {
                return false;
            }
            if (a.this.f47564g != null) {
                a.this.f47564g.c(a.this.f47560c.getText().toString());
            }
            if (a.this.f47565h.f47700d || a.this.f47564g == null) {
                return true;
            }
            a.this.f47564g.a();
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
            a.this.f47562e.setEnabled(false);
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.h.u.c f47573e;

        public e(d.a.l0.h.u.c cVar) {
            this.f47573e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            int length;
            try {
                if (a.this.f47560c.getText().length() <= this.f47573e.f47697a.length()) {
                    length = a.this.f47560c.getText().length();
                } else {
                    length = this.f47573e.f47697a.length();
                }
                a.this.f47560c.setSelection(length);
            } catch (Exception e2) {
                if (k.f43199a) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f47575e;

        public f(String str) {
            this.f47575e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f47560c.setSelection(this.f47575e.length());
        }
    }

    @SuppressLint({"InflateParams"})
    public a(Context context) {
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(context).inflate(d.a.l0.f.f.aiapps_ai_games_input_view, (ViewGroup) null);
        this.f47558a = relativeLayout;
        this.f47559b = (EditText) relativeLayout.findViewById(d.a.l0.f.e.ai_games_virtual_input_et);
        this.f47561d = (RelativeLayout) this.f47558a.findViewById(d.a.l0.f.e.ai_games_real_input_container);
        this.f47560c = (EditText) this.f47558a.findViewById(d.a.l0.f.e.ai_games_real_input_et);
        Button button = (Button) this.f47558a.findViewById(d.a.l0.f.e.ai_games_input_send_btn);
        this.f47562e = button;
        button.setOnClickListener(this.f47566i);
        this.f47560c.addTextChangedListener(this.j);
        this.f47560c.setOnEditorActionListener(this.k);
        this.f47562e.post(new d());
    }

    public View f() {
        return this.f47558a;
    }

    public boolean g() {
        return this.f47563f;
    }

    public void h() {
        EditText editText;
        EditText editText2;
        InputMethodManager inputMethodManager = (InputMethodManager) AppRuntime.getAppContext().getSystemService("input_method");
        if (!inputMethodManager.isActive() || (editText = this.f47560c) == null) {
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(editText.getApplicationWindowToken(), 0);
        this.f47563f = false;
        this.f47559b.setVisibility(8);
        this.f47561d.setVisibility(8);
        a.f fVar = this.f47564g;
        if (fVar == null || (editText2 = this.f47560c) == null) {
            return;
        }
        fVar.d(editText2.getText().toString());
    }

    public void i(a.f fVar) {
        this.f47564g = fVar;
    }

    public void j(d.a.l0.h.u.c cVar) {
        this.f47565h = cVar;
        if (this.f47560c == null || cVar == null) {
            return;
        }
        if (!TextUtils.isEmpty(cVar.f47697a)) {
            this.f47560c.setText(cVar.f47697a);
            if (cVar.f47698b > 0) {
                if (!TextUtils.isEmpty(cVar.f47697a) && cVar.f47697a.length() > cVar.f47698b) {
                    cVar.f47698b = cVar.f47697a.length();
                }
                this.f47560c.setFilters(new InputFilter[]{new InputFilter.LengthFilter(cVar.f47698b)});
            }
            this.f47560c.postDelayed(new e(cVar), 300L);
        } else {
            this.f47560c.setText("");
        }
        this.f47562e.setEnabled(!TextUtils.isEmpty(cVar.f47697a));
        if (cVar.f47699c) {
            this.f47560c.setMinLines(1);
            this.f47560c.setInputType(131073);
            this.f47562e.setText(cVar.f47702f);
            return;
        }
        this.f47560c.setMaxLines(1);
        this.f47560c.setInputType(1);
    }

    public void k(int i2) {
        this.f47561d.setVisibility(0);
        this.f47560c.setFocusableInTouchMode(true);
        this.f47560c.requestFocus();
        this.f47559b.setVisibility(8);
        this.f47563f = true;
        a.f fVar = this.f47564g;
        if (fVar != null) {
            fVar.b(i2);
        }
    }

    public boolean l() {
        if (this.f47563f) {
            return false;
        }
        this.f47559b.setVisibility(0);
        this.f47561d.setVisibility(8);
        this.f47559b.setFocusableInTouchMode(true);
        this.f47559b.requestFocus();
        ((InputMethodManager) AppRuntime.getAppContext().getSystemService("input_method")).showSoftInput(this.f47559b, 0);
        return true;
    }

    public boolean m(String str) {
        EditText editText;
        if (!this.f47563f || (editText = this.f47560c) == null) {
            return false;
        }
        editText.setText(str);
        this.f47560c.postDelayed(new f(str), 300L);
        return true;
    }
}
