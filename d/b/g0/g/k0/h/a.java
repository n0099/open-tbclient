package d.b.g0.g.k0.h;

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
import d.b.g0.a.g;
import d.b.g0.a.k;
import d.b.g0.g.s.a;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public RelativeLayout f48256a;

    /* renamed from: b  reason: collision with root package name */
    public EditText f48257b;

    /* renamed from: c  reason: collision with root package name */
    public EditText f48258c;

    /* renamed from: d  reason: collision with root package name */
    public RelativeLayout f48259d;

    /* renamed from: e  reason: collision with root package name */
    public Button f48260e;

    /* renamed from: g  reason: collision with root package name */
    public a.f f48262g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.g0.g.s.c f48263h;

    /* renamed from: f  reason: collision with root package name */
    public boolean f48261f = false;
    public View.OnClickListener i = new View$OnClickListenerC0973a();
    public TextWatcher j = new b();
    public TextView.OnEditorActionListener k = new c();

    /* renamed from: d.b.g0.g.k0.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC0973a implements View.OnClickListener {
        public View$OnClickListenerC0973a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f48258c == null || !a.this.f48261f) {
                return;
            }
            if (a.this.f48262g != null) {
                a.this.f48262g.a(a.this.f48258c.getText().toString());
            }
            if (a.this.f48263h == null || a.this.f48263h.f48566d || a.this.f48262g == null) {
                return;
            }
            a.this.f48262g.d();
            a.this.m("");
        }
    }

    /* loaded from: classes3.dex */
    public class b implements TextWatcher {

        /* renamed from: d.b.g0.g.k0.h.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0974a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Editable f48266e;

            public RunnableC0974a(Editable editable) {
                this.f48266e = editable;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (TextUtils.isEmpty(this.f48266e.toString())) {
                    a.this.f48260e.setEnabled(false);
                } else if (a.this.f48260e.isEnabled()) {
                } else {
                    a.this.f48260e.setEnabled(true);
                }
            }
        }

        public b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (a.this.f48262g != null) {
                a.this.f48262g.c(editable.toString());
            }
            a.this.f48260e.post(new RunnableC0974a(editable));
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
            if (a.this.f48263h == null || a.this.f48263h.f48567e != i || a.this.f48258c == null || !a.this.f48261f) {
                return false;
            }
            if (a.this.f48262g != null) {
                a.this.f48262g.a(a.this.f48258c.getText().toString());
            }
            if (a.this.f48263h.f48566d || a.this.f48262g == null) {
                return true;
            }
            a.this.f48262g.d();
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
            a.this.f48260e.setEnabled(false);
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.g.s.c f48270e;

        public e(d.b.g0.g.s.c cVar) {
            this.f48270e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            int length;
            try {
                if (a.this.f48258c.getText().length() <= this.f48270e.f48563a.length()) {
                    length = a.this.f48258c.getText().length();
                } else {
                    length = this.f48270e.f48563a.length();
                }
                a.this.f48258c.setSelection(length);
            } catch (Exception e2) {
                if (k.f45051a) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48272e;

        public f(String str) {
            this.f48272e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f48258c.setSelection(this.f48272e.length());
        }
    }

    public a(Context context) {
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(context).inflate(g.aiapps_ai_games_input_view, (ViewGroup) null);
        this.f48256a = relativeLayout;
        this.f48257b = (EditText) relativeLayout.findViewById(d.b.g0.a.f.ai_games_virtual_input_et);
        this.f48259d = (RelativeLayout) this.f48256a.findViewById(d.b.g0.a.f.ai_games_real_input_container);
        this.f48258c = (EditText) this.f48256a.findViewById(d.b.g0.a.f.ai_games_real_input_et);
        Button button = (Button) this.f48256a.findViewById(d.b.g0.a.f.ai_games_input_send_btn);
        this.f48260e = button;
        button.setOnClickListener(this.i);
        this.f48258c.addTextChangedListener(this.j);
        this.f48258c.setOnEditorActionListener(this.k);
        this.f48260e.post(new d());
    }

    public View f() {
        return this.f48256a;
    }

    public boolean g() {
        return this.f48261f;
    }

    public void h() {
        EditText editText;
        EditText editText2;
        InputMethodManager inputMethodManager = (InputMethodManager) AppRuntime.getAppContext().getSystemService("input_method");
        if (!inputMethodManager.isActive() || (editText = this.f48258c) == null) {
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(editText.getApplicationWindowToken(), 0);
        this.f48261f = false;
        this.f48257b.setVisibility(8);
        this.f48259d.setVisibility(8);
        a.f fVar = this.f48262g;
        if (fVar == null || (editText2 = this.f48258c) == null) {
            return;
        }
        fVar.b(editText2.getText().toString());
    }

    public void i(a.f fVar) {
        this.f48262g = fVar;
    }

    public void j(d.b.g0.g.s.c cVar) {
        this.f48263h = cVar;
        if (this.f48258c == null || cVar == null) {
            return;
        }
        if (!TextUtils.isEmpty(cVar.f48563a)) {
            this.f48258c.setText(cVar.f48563a);
            if (cVar.f48564b > 0) {
                if (!TextUtils.isEmpty(cVar.f48563a) && cVar.f48563a.length() > cVar.f48564b) {
                    cVar.f48564b = cVar.f48563a.length();
                }
                this.f48258c.setFilters(new InputFilter[]{new InputFilter.LengthFilter(cVar.f48564b)});
            }
            this.f48258c.postDelayed(new e(cVar), 300L);
        } else {
            this.f48258c.setText("");
        }
        this.f48260e.setEnabled(!TextUtils.isEmpty(cVar.f48563a));
        if (cVar.f48565c) {
            this.f48258c.setMinLines(1);
            this.f48258c.setInputType(131073);
            this.f48260e.setText(cVar.f48568f);
            return;
        }
        this.f48258c.setMaxLines(1);
        this.f48258c.setInputType(1);
    }

    public void k(int i) {
        this.f48259d.setVisibility(0);
        this.f48258c.setFocusableInTouchMode(true);
        this.f48258c.requestFocus();
        this.f48257b.setVisibility(8);
        this.f48261f = true;
        a.f fVar = this.f48262g;
        if (fVar != null) {
            fVar.e(i);
        }
    }

    public boolean l() {
        if (this.f48261f) {
            return false;
        }
        this.f48257b.setVisibility(0);
        this.f48259d.setVisibility(8);
        this.f48257b.setFocusableInTouchMode(true);
        this.f48257b.requestFocus();
        ((InputMethodManager) AppRuntime.getAppContext().getSystemService("input_method")).showSoftInput(this.f48257b, 0);
        return true;
    }

    public boolean m(String str) {
        EditText editText;
        if (!this.f48261f || (editText = this.f48258c) == null) {
            return false;
        }
        editText.setText(str);
        this.f48258c.postDelayed(new f(str), 300L);
        return true;
    }
}
