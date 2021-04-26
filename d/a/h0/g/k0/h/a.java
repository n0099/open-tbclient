package d.a.h0.g.k0.h;

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
import d.a.h0.a.g;
import d.a.h0.a.k;
import d.a.h0.g.s.a;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public RelativeLayout f46452a;

    /* renamed from: b  reason: collision with root package name */
    public EditText f46453b;

    /* renamed from: c  reason: collision with root package name */
    public EditText f46454c;

    /* renamed from: d  reason: collision with root package name */
    public RelativeLayout f46455d;

    /* renamed from: e  reason: collision with root package name */
    public Button f46456e;

    /* renamed from: g  reason: collision with root package name */
    public a.f f46458g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.h0.g.s.c f46459h;

    /* renamed from: f  reason: collision with root package name */
    public boolean f46457f = false;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f46460i = new View$OnClickListenerC0944a();
    public TextWatcher j = new b();
    public TextView.OnEditorActionListener k = new c();

    /* renamed from: d.a.h0.g.k0.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC0944a implements View.OnClickListener {
        public View$OnClickListenerC0944a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f46454c == null || !a.this.f46457f) {
                return;
            }
            if (a.this.f46458g != null) {
                a.this.f46458g.c(a.this.f46454c.getText().toString());
            }
            if (a.this.f46459h == null || a.this.f46459h.f46782d || a.this.f46458g == null) {
                return;
            }
            a.this.f46458g.a();
            a.this.m("");
        }
    }

    /* loaded from: classes3.dex */
    public class b implements TextWatcher {

        /* renamed from: d.a.h0.g.k0.h.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0945a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Editable f46463e;

            public RunnableC0945a(Editable editable) {
                this.f46463e = editable;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (TextUtils.isEmpty(this.f46463e.toString())) {
                    a.this.f46456e.setEnabled(false);
                } else if (a.this.f46456e.isEnabled()) {
                } else {
                    a.this.f46456e.setEnabled(true);
                }
            }
        }

        public b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (a.this.f46458g != null) {
                a.this.f46458g.e(editable.toString());
            }
            a.this.f46456e.post(new RunnableC0945a(editable));
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
            if (a.this.f46459h == null || a.this.f46459h.f46783e != i2 || a.this.f46454c == null || !a.this.f46457f) {
                return false;
            }
            if (a.this.f46458g != null) {
                a.this.f46458g.c(a.this.f46454c.getText().toString());
            }
            if (a.this.f46459h.f46782d || a.this.f46458g == null) {
                return true;
            }
            a.this.f46458g.a();
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
            a.this.f46456e.setEnabled(false);
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.g.s.c f46467e;

        public e(d.a.h0.g.s.c cVar) {
            this.f46467e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            int length;
            try {
                if (a.this.f46454c.getText().length() <= this.f46467e.f46779a.length()) {
                    length = a.this.f46454c.getText().length();
                } else {
                    length = this.f46467e.f46779a.length();
                }
                a.this.f46454c.setSelection(length);
            } catch (Exception e2) {
                if (k.f43101a) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f46469e;

        public f(String str) {
            this.f46469e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f46454c.setSelection(this.f46469e.length());
        }
    }

    public a(Context context) {
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(context).inflate(g.aiapps_ai_games_input_view, (ViewGroup) null);
        this.f46452a = relativeLayout;
        this.f46453b = (EditText) relativeLayout.findViewById(d.a.h0.a.f.ai_games_virtual_input_et);
        this.f46455d = (RelativeLayout) this.f46452a.findViewById(d.a.h0.a.f.ai_games_real_input_container);
        this.f46454c = (EditText) this.f46452a.findViewById(d.a.h0.a.f.ai_games_real_input_et);
        Button button = (Button) this.f46452a.findViewById(d.a.h0.a.f.ai_games_input_send_btn);
        this.f46456e = button;
        button.setOnClickListener(this.f46460i);
        this.f46454c.addTextChangedListener(this.j);
        this.f46454c.setOnEditorActionListener(this.k);
        this.f46456e.post(new d());
    }

    public View f() {
        return this.f46452a;
    }

    public boolean g() {
        return this.f46457f;
    }

    public void h() {
        EditText editText;
        EditText editText2;
        InputMethodManager inputMethodManager = (InputMethodManager) AppRuntime.getAppContext().getSystemService("input_method");
        if (!inputMethodManager.isActive() || (editText = this.f46454c) == null) {
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(editText.getApplicationWindowToken(), 0);
        this.f46457f = false;
        this.f46453b.setVisibility(8);
        this.f46455d.setVisibility(8);
        a.f fVar = this.f46458g;
        if (fVar == null || (editText2 = this.f46454c) == null) {
            return;
        }
        fVar.d(editText2.getText().toString());
    }

    public void i(a.f fVar) {
        this.f46458g = fVar;
    }

    public void j(d.a.h0.g.s.c cVar) {
        this.f46459h = cVar;
        if (this.f46454c == null || cVar == null) {
            return;
        }
        if (!TextUtils.isEmpty(cVar.f46779a)) {
            this.f46454c.setText(cVar.f46779a);
            if (cVar.f46780b > 0) {
                if (!TextUtils.isEmpty(cVar.f46779a) && cVar.f46779a.length() > cVar.f46780b) {
                    cVar.f46780b = cVar.f46779a.length();
                }
                this.f46454c.setFilters(new InputFilter[]{new InputFilter.LengthFilter(cVar.f46780b)});
            }
            this.f46454c.postDelayed(new e(cVar), 300L);
        } else {
            this.f46454c.setText("");
        }
        this.f46456e.setEnabled(!TextUtils.isEmpty(cVar.f46779a));
        if (cVar.f46781c) {
            this.f46454c.setMinLines(1);
            this.f46454c.setInputType(131073);
            this.f46456e.setText(cVar.f46784f);
            return;
        }
        this.f46454c.setMaxLines(1);
        this.f46454c.setInputType(1);
    }

    public void k(int i2) {
        this.f46455d.setVisibility(0);
        this.f46454c.setFocusableInTouchMode(true);
        this.f46454c.requestFocus();
        this.f46453b.setVisibility(8);
        this.f46457f = true;
        a.f fVar = this.f46458g;
        if (fVar != null) {
            fVar.b(i2);
        }
    }

    public boolean l() {
        if (this.f46457f) {
            return false;
        }
        this.f46453b.setVisibility(0);
        this.f46455d.setVisibility(8);
        this.f46453b.setFocusableInTouchMode(true);
        this.f46453b.requestFocus();
        ((InputMethodManager) AppRuntime.getAppContext().getSystemService("input_method")).showSoftInput(this.f46453b, 0);
        return true;
    }

    public boolean m(String str) {
        EditText editText;
        if (!this.f46457f || (editText = this.f46454c) == null) {
            return false;
        }
        editText.setText(str);
        this.f46454c.postDelayed(new f(str), 300L);
        return true;
    }
}
