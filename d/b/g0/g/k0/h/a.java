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
    public RelativeLayout f48648a;

    /* renamed from: b  reason: collision with root package name */
    public EditText f48649b;

    /* renamed from: c  reason: collision with root package name */
    public EditText f48650c;

    /* renamed from: d  reason: collision with root package name */
    public RelativeLayout f48651d;

    /* renamed from: e  reason: collision with root package name */
    public Button f48652e;

    /* renamed from: g  reason: collision with root package name */
    public a.f f48654g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.g0.g.s.c f48655h;

    /* renamed from: f  reason: collision with root package name */
    public boolean f48653f = false;
    public View.OnClickListener i = new View$OnClickListenerC0985a();
    public TextWatcher j = new b();
    public TextView.OnEditorActionListener k = new c();

    /* renamed from: d.b.g0.g.k0.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC0985a implements View.OnClickListener {
        public View$OnClickListenerC0985a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f48650c == null || !a.this.f48653f) {
                return;
            }
            if (a.this.f48654g != null) {
                a.this.f48654g.a(a.this.f48650c.getText().toString());
            }
            if (a.this.f48655h == null || a.this.f48655h.f48958d || a.this.f48654g == null) {
                return;
            }
            a.this.f48654g.d();
            a.this.m("");
        }
    }

    /* loaded from: classes3.dex */
    public class b implements TextWatcher {

        /* renamed from: d.b.g0.g.k0.h.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0986a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Editable f48658e;

            public RunnableC0986a(Editable editable) {
                this.f48658e = editable;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (TextUtils.isEmpty(this.f48658e.toString())) {
                    a.this.f48652e.setEnabled(false);
                } else if (a.this.f48652e.isEnabled()) {
                } else {
                    a.this.f48652e.setEnabled(true);
                }
            }
        }

        public b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (a.this.f48654g != null) {
                a.this.f48654g.c(editable.toString());
            }
            a.this.f48652e.post(new RunnableC0986a(editable));
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
            if (a.this.f48655h == null || a.this.f48655h.f48959e != i || a.this.f48650c == null || !a.this.f48653f) {
                return false;
            }
            if (a.this.f48654g != null) {
                a.this.f48654g.a(a.this.f48650c.getText().toString());
            }
            if (a.this.f48655h.f48958d || a.this.f48654g == null) {
                return true;
            }
            a.this.f48654g.d();
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
            a.this.f48652e.setEnabled(false);
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.g.s.c f48662e;

        public e(d.b.g0.g.s.c cVar) {
            this.f48662e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            int length;
            try {
                if (a.this.f48650c.getText().length() <= this.f48662e.f48955a.length()) {
                    length = a.this.f48650c.getText().length();
                } else {
                    length = this.f48662e.f48955a.length();
                }
                a.this.f48650c.setSelection(length);
            } catch (Exception e2) {
                if (k.f45443a) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48664e;

        public f(String str) {
            this.f48664e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f48650c.setSelection(this.f48664e.length());
        }
    }

    public a(Context context) {
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(context).inflate(g.aiapps_ai_games_input_view, (ViewGroup) null);
        this.f48648a = relativeLayout;
        this.f48649b = (EditText) relativeLayout.findViewById(d.b.g0.a.f.ai_games_virtual_input_et);
        this.f48651d = (RelativeLayout) this.f48648a.findViewById(d.b.g0.a.f.ai_games_real_input_container);
        this.f48650c = (EditText) this.f48648a.findViewById(d.b.g0.a.f.ai_games_real_input_et);
        Button button = (Button) this.f48648a.findViewById(d.b.g0.a.f.ai_games_input_send_btn);
        this.f48652e = button;
        button.setOnClickListener(this.i);
        this.f48650c.addTextChangedListener(this.j);
        this.f48650c.setOnEditorActionListener(this.k);
        this.f48652e.post(new d());
    }

    public View f() {
        return this.f48648a;
    }

    public boolean g() {
        return this.f48653f;
    }

    public void h() {
        EditText editText;
        EditText editText2;
        InputMethodManager inputMethodManager = (InputMethodManager) AppRuntime.getAppContext().getSystemService("input_method");
        if (!inputMethodManager.isActive() || (editText = this.f48650c) == null) {
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(editText.getApplicationWindowToken(), 0);
        this.f48653f = false;
        this.f48649b.setVisibility(8);
        this.f48651d.setVisibility(8);
        a.f fVar = this.f48654g;
        if (fVar == null || (editText2 = this.f48650c) == null) {
            return;
        }
        fVar.b(editText2.getText().toString());
    }

    public void i(a.f fVar) {
        this.f48654g = fVar;
    }

    public void j(d.b.g0.g.s.c cVar) {
        this.f48655h = cVar;
        if (this.f48650c == null || cVar == null) {
            return;
        }
        if (!TextUtils.isEmpty(cVar.f48955a)) {
            this.f48650c.setText(cVar.f48955a);
            if (cVar.f48956b > 0) {
                if (!TextUtils.isEmpty(cVar.f48955a) && cVar.f48955a.length() > cVar.f48956b) {
                    cVar.f48956b = cVar.f48955a.length();
                }
                this.f48650c.setFilters(new InputFilter[]{new InputFilter.LengthFilter(cVar.f48956b)});
            }
            this.f48650c.postDelayed(new e(cVar), 300L);
        } else {
            this.f48650c.setText("");
        }
        this.f48652e.setEnabled(!TextUtils.isEmpty(cVar.f48955a));
        if (cVar.f48957c) {
            this.f48650c.setMinLines(1);
            this.f48650c.setInputType(131073);
            this.f48652e.setText(cVar.f48960f);
            return;
        }
        this.f48650c.setMaxLines(1);
        this.f48650c.setInputType(1);
    }

    public void k(int i) {
        this.f48651d.setVisibility(0);
        this.f48650c.setFocusableInTouchMode(true);
        this.f48650c.requestFocus();
        this.f48649b.setVisibility(8);
        this.f48653f = true;
        a.f fVar = this.f48654g;
        if (fVar != null) {
            fVar.e(i);
        }
    }

    public boolean l() {
        if (this.f48653f) {
            return false;
        }
        this.f48649b.setVisibility(0);
        this.f48651d.setVisibility(8);
        this.f48649b.setFocusableInTouchMode(true);
        this.f48649b.requestFocus();
        ((InputMethodManager) AppRuntime.getAppContext().getSystemService("input_method")).showSoftInput(this.f48649b, 0);
        return true;
    }

    public boolean m(String str) {
        EditText editText;
        if (!this.f48653f || (editText = this.f48650c) == null) {
            return false;
        }
        editText.setText(str);
        this.f48650c.postDelayed(new f(str), 300L);
        return true;
    }
}
