package d.a.i0.h.o0.f;

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
import d.a.i0.a.k;
import d.a.i0.h.u.a;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public RelativeLayout f47382a;

    /* renamed from: b  reason: collision with root package name */
    public EditText f47383b;

    /* renamed from: c  reason: collision with root package name */
    public EditText f47384c;

    /* renamed from: d  reason: collision with root package name */
    public RelativeLayout f47385d;

    /* renamed from: e  reason: collision with root package name */
    public Button f47386e;

    /* renamed from: g  reason: collision with root package name */
    public a.f f47388g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.i0.h.u.c f47389h;

    /* renamed from: f  reason: collision with root package name */
    public boolean f47387f = false;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f47390i = new View$OnClickListenerC1029a();
    public TextWatcher j = new b();
    public TextView.OnEditorActionListener k = new c();

    /* renamed from: d.a.i0.h.o0.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC1029a implements View.OnClickListener {
        public View$OnClickListenerC1029a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f47384c == null || !a.this.f47387f) {
                return;
            }
            if (a.this.f47388g != null) {
                a.this.f47388g.c(a.this.f47384c.getText().toString());
            }
            if (a.this.f47389h == null || a.this.f47389h.f47524d || a.this.f47388g == null) {
                return;
            }
            a.this.f47388g.a();
            a.this.m("");
        }
    }

    /* loaded from: classes3.dex */
    public class b implements TextWatcher {

        /* renamed from: d.a.i0.h.o0.f.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC1030a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Editable f47393e;

            public RunnableC1030a(Editable editable) {
                this.f47393e = editable;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (TextUtils.isEmpty(this.f47393e.toString())) {
                    a.this.f47386e.setEnabled(false);
                } else if (a.this.f47386e.isEnabled()) {
                } else {
                    a.this.f47386e.setEnabled(true);
                }
            }
        }

        public b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (a.this.f47388g != null) {
                a.this.f47388g.e(editable.toString());
            }
            a.this.f47386e.post(new RunnableC1030a(editable));
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
            if (a.this.f47389h == null || a.this.f47389h.f47525e != i2 || a.this.f47384c == null || !a.this.f47387f) {
                return false;
            }
            if (a.this.f47388g != null) {
                a.this.f47388g.c(a.this.f47384c.getText().toString());
            }
            if (a.this.f47389h.f47524d || a.this.f47388g == null) {
                return true;
            }
            a.this.f47388g.a();
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
            a.this.f47386e.setEnabled(false);
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.h.u.c f47397e;

        public e(d.a.i0.h.u.c cVar) {
            this.f47397e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            int length;
            try {
                if (a.this.f47384c.getText().length() <= this.f47397e.f47521a.length()) {
                    length = a.this.f47384c.getText().length();
                } else {
                    length = this.f47397e.f47521a.length();
                }
                a.this.f47384c.setSelection(length);
            } catch (Exception e2) {
                if (k.f43025a) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f47399e;

        public f(String str) {
            this.f47399e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f47384c.setSelection(this.f47399e.length());
        }
    }

    @SuppressLint({"InflateParams"})
    public a(Context context) {
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(context).inflate(d.a.i0.f.f.aiapps_ai_games_input_view, (ViewGroup) null);
        this.f47382a = relativeLayout;
        this.f47383b = (EditText) relativeLayout.findViewById(d.a.i0.f.e.ai_games_virtual_input_et);
        this.f47385d = (RelativeLayout) this.f47382a.findViewById(d.a.i0.f.e.ai_games_real_input_container);
        this.f47384c = (EditText) this.f47382a.findViewById(d.a.i0.f.e.ai_games_real_input_et);
        Button button = (Button) this.f47382a.findViewById(d.a.i0.f.e.ai_games_input_send_btn);
        this.f47386e = button;
        button.setOnClickListener(this.f47390i);
        this.f47384c.addTextChangedListener(this.j);
        this.f47384c.setOnEditorActionListener(this.k);
        this.f47386e.post(new d());
    }

    public View f() {
        return this.f47382a;
    }

    public boolean g() {
        return this.f47387f;
    }

    public void h() {
        EditText editText;
        EditText editText2;
        InputMethodManager inputMethodManager = (InputMethodManager) AppRuntime.getAppContext().getSystemService("input_method");
        if (!inputMethodManager.isActive() || (editText = this.f47384c) == null) {
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(editText.getApplicationWindowToken(), 0);
        this.f47387f = false;
        this.f47383b.setVisibility(8);
        this.f47385d.setVisibility(8);
        a.f fVar = this.f47388g;
        if (fVar == null || (editText2 = this.f47384c) == null) {
            return;
        }
        fVar.d(editText2.getText().toString());
    }

    public void i(a.f fVar) {
        this.f47388g = fVar;
    }

    public void j(d.a.i0.h.u.c cVar) {
        this.f47389h = cVar;
        if (this.f47384c == null || cVar == null) {
            return;
        }
        if (!TextUtils.isEmpty(cVar.f47521a)) {
            this.f47384c.setText(cVar.f47521a);
            if (cVar.f47522b > 0) {
                if (!TextUtils.isEmpty(cVar.f47521a) && cVar.f47521a.length() > cVar.f47522b) {
                    cVar.f47522b = cVar.f47521a.length();
                }
                this.f47384c.setFilters(new InputFilter[]{new InputFilter.LengthFilter(cVar.f47522b)});
            }
            this.f47384c.postDelayed(new e(cVar), 300L);
        } else {
            this.f47384c.setText("");
        }
        this.f47386e.setEnabled(!TextUtils.isEmpty(cVar.f47521a));
        if (cVar.f47523c) {
            this.f47384c.setMinLines(1);
            this.f47384c.setInputType(131073);
            this.f47386e.setText(cVar.f47526f);
            return;
        }
        this.f47384c.setMaxLines(1);
        this.f47384c.setInputType(1);
    }

    public void k(int i2) {
        this.f47385d.setVisibility(0);
        this.f47384c.setFocusableInTouchMode(true);
        this.f47384c.requestFocus();
        this.f47383b.setVisibility(8);
        this.f47387f = true;
        a.f fVar = this.f47388g;
        if (fVar != null) {
            fVar.b(i2);
        }
    }

    public boolean l() {
        if (this.f47387f) {
            return false;
        }
        this.f47383b.setVisibility(0);
        this.f47385d.setVisibility(8);
        this.f47383b.setFocusableInTouchMode(true);
        this.f47383b.requestFocus();
        ((InputMethodManager) AppRuntime.getAppContext().getSystemService("input_method")).showSoftInput(this.f47383b, 0);
        return true;
    }

    public boolean m(String str) {
        EditText editText;
        if (!this.f47387f || (editText = this.f47384c) == null) {
            return false;
        }
        editText.setText(str);
        this.f47384c.postDelayed(new f(str), 300L);
        return true;
    }
}
