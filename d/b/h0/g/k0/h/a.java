package d.b.h0.g.k0.h;

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
import d.b.h0.a.g;
import d.b.h0.a.k;
import d.b.h0.g.s.a;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public RelativeLayout f48977a;

    /* renamed from: b  reason: collision with root package name */
    public EditText f48978b;

    /* renamed from: c  reason: collision with root package name */
    public EditText f48979c;

    /* renamed from: d  reason: collision with root package name */
    public RelativeLayout f48980d;

    /* renamed from: e  reason: collision with root package name */
    public Button f48981e;

    /* renamed from: g  reason: collision with root package name */
    public a.f f48983g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.h0.g.s.c f48984h;

    /* renamed from: f  reason: collision with root package name */
    public boolean f48982f = false;
    public View.OnClickListener i = new View$OnClickListenerC1005a();
    public TextWatcher j = new b();
    public TextView.OnEditorActionListener k = new c();

    /* renamed from: d.b.h0.g.k0.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC1005a implements View.OnClickListener {
        public View$OnClickListenerC1005a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f48979c == null || !a.this.f48982f) {
                return;
            }
            if (a.this.f48983g != null) {
                a.this.f48983g.a(a.this.f48979c.getText().toString());
            }
            if (a.this.f48984h == null || a.this.f48984h.f49287d || a.this.f48983g == null) {
                return;
            }
            a.this.f48983g.d();
            a.this.m("");
        }
    }

    /* loaded from: classes3.dex */
    public class b implements TextWatcher {

        /* renamed from: d.b.h0.g.k0.h.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC1006a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Editable f48987e;

            public RunnableC1006a(Editable editable) {
                this.f48987e = editable;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (TextUtils.isEmpty(this.f48987e.toString())) {
                    a.this.f48981e.setEnabled(false);
                } else if (a.this.f48981e.isEnabled()) {
                } else {
                    a.this.f48981e.setEnabled(true);
                }
            }
        }

        public b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (a.this.f48983g != null) {
                a.this.f48983g.c(editable.toString());
            }
            a.this.f48981e.post(new RunnableC1006a(editable));
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* loaded from: classes3.dex */
    public class c implements TextView.OnEditorActionListener {
        public c() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (a.this.f48984h == null || a.this.f48984h.f49288e != i || a.this.f48979c == null || !a.this.f48982f) {
                return false;
            }
            if (a.this.f48983g != null) {
                a.this.f48983g.a(a.this.f48979c.getText().toString());
            }
            if (a.this.f48984h.f49287d || a.this.f48983g == null) {
                return true;
            }
            a.this.f48983g.d();
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
            a.this.f48981e.setEnabled(false);
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.g.s.c f48991e;

        public e(d.b.h0.g.s.c cVar) {
            this.f48991e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            int length;
            try {
                if (a.this.f48979c.getText().length() <= this.f48991e.f49284a.length()) {
                    length = a.this.f48979c.getText().length();
                } else {
                    length = this.f48991e.f49284a.length();
                }
                a.this.f48979c.setSelection(length);
            } catch (Exception e2) {
                if (k.f45772a) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48993e;

        public f(String str) {
            this.f48993e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f48979c.setSelection(this.f48993e.length());
        }
    }

    public a(Context context) {
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(context).inflate(g.aiapps_ai_games_input_view, (ViewGroup) null);
        this.f48977a = relativeLayout;
        this.f48978b = (EditText) relativeLayout.findViewById(d.b.h0.a.f.ai_games_virtual_input_et);
        this.f48980d = (RelativeLayout) this.f48977a.findViewById(d.b.h0.a.f.ai_games_real_input_container);
        this.f48979c = (EditText) this.f48977a.findViewById(d.b.h0.a.f.ai_games_real_input_et);
        Button button = (Button) this.f48977a.findViewById(d.b.h0.a.f.ai_games_input_send_btn);
        this.f48981e = button;
        button.setOnClickListener(this.i);
        this.f48979c.addTextChangedListener(this.j);
        this.f48979c.setOnEditorActionListener(this.k);
        this.f48981e.post(new d());
    }

    public View f() {
        return this.f48977a;
    }

    public boolean g() {
        return this.f48982f;
    }

    public void h() {
        EditText editText;
        EditText editText2;
        InputMethodManager inputMethodManager = (InputMethodManager) AppRuntime.getAppContext().getSystemService("input_method");
        if (!inputMethodManager.isActive() || (editText = this.f48979c) == null) {
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(editText.getApplicationWindowToken(), 0);
        this.f48982f = false;
        this.f48978b.setVisibility(8);
        this.f48980d.setVisibility(8);
        a.f fVar = this.f48983g;
        if (fVar == null || (editText2 = this.f48979c) == null) {
            return;
        }
        fVar.b(editText2.getText().toString());
    }

    public void i(a.f fVar) {
        this.f48983g = fVar;
    }

    public void j(d.b.h0.g.s.c cVar) {
        this.f48984h = cVar;
        if (this.f48979c == null || cVar == null) {
            return;
        }
        if (!TextUtils.isEmpty(cVar.f49284a)) {
            this.f48979c.setText(cVar.f49284a);
            if (cVar.f49285b > 0) {
                if (!TextUtils.isEmpty(cVar.f49284a) && cVar.f49284a.length() > cVar.f49285b) {
                    cVar.f49285b = cVar.f49284a.length();
                }
                this.f48979c.setFilters(new InputFilter[]{new InputFilter.LengthFilter(cVar.f49285b)});
            }
            this.f48979c.postDelayed(new e(cVar), 300L);
        } else {
            this.f48979c.setText("");
        }
        this.f48981e.setEnabled(!TextUtils.isEmpty(cVar.f49284a));
        if (cVar.f49286c) {
            this.f48979c.setMinLines(1);
            this.f48979c.setInputType(131073);
            this.f48981e.setText(cVar.f49289f);
            return;
        }
        this.f48979c.setMaxLines(1);
        this.f48979c.setInputType(1);
    }

    public void k(int i) {
        this.f48980d.setVisibility(0);
        this.f48979c.setFocusableInTouchMode(true);
        this.f48979c.requestFocus();
        this.f48978b.setVisibility(8);
        this.f48982f = true;
        a.f fVar = this.f48983g;
        if (fVar != null) {
            fVar.e(i);
        }
    }

    public boolean l() {
        if (this.f48982f) {
            return false;
        }
        this.f48978b.setVisibility(0);
        this.f48980d.setVisibility(8);
        this.f48978b.setFocusableInTouchMode(true);
        this.f48978b.requestFocus();
        ((InputMethodManager) AppRuntime.getAppContext().getSystemService("input_method")).showSoftInput(this.f48978b, 0);
        return true;
    }

    public boolean m(String str) {
        EditText editText;
        if (!this.f48982f || (editText = this.f48979c) == null) {
            return false;
        }
        editText.setText(str);
        this.f48979c.postDelayed(new f(str), 300L);
        return true;
    }
}
