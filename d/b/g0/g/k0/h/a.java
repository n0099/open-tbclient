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
    public RelativeLayout f48255a;

    /* renamed from: b  reason: collision with root package name */
    public EditText f48256b;

    /* renamed from: c  reason: collision with root package name */
    public EditText f48257c;

    /* renamed from: d  reason: collision with root package name */
    public RelativeLayout f48258d;

    /* renamed from: e  reason: collision with root package name */
    public Button f48259e;

    /* renamed from: g  reason: collision with root package name */
    public a.f f48261g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.g0.g.s.c f48262h;

    /* renamed from: f  reason: collision with root package name */
    public boolean f48260f = false;
    public View.OnClickListener i = new View$OnClickListenerC0972a();
    public TextWatcher j = new b();
    public TextView.OnEditorActionListener k = new c();

    /* renamed from: d.b.g0.g.k0.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC0972a implements View.OnClickListener {
        public View$OnClickListenerC0972a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f48257c == null || !a.this.f48260f) {
                return;
            }
            if (a.this.f48261g != null) {
                a.this.f48261g.a(a.this.f48257c.getText().toString());
            }
            if (a.this.f48262h == null || a.this.f48262h.f48565d || a.this.f48261g == null) {
                return;
            }
            a.this.f48261g.d();
            a.this.m("");
        }
    }

    /* loaded from: classes3.dex */
    public class b implements TextWatcher {

        /* renamed from: d.b.g0.g.k0.h.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0973a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Editable f48265e;

            public RunnableC0973a(Editable editable) {
                this.f48265e = editable;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (TextUtils.isEmpty(this.f48265e.toString())) {
                    a.this.f48259e.setEnabled(false);
                } else if (a.this.f48259e.isEnabled()) {
                } else {
                    a.this.f48259e.setEnabled(true);
                }
            }
        }

        public b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (a.this.f48261g != null) {
                a.this.f48261g.c(editable.toString());
            }
            a.this.f48259e.post(new RunnableC0973a(editable));
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
            if (a.this.f48262h == null || a.this.f48262h.f48566e != i || a.this.f48257c == null || !a.this.f48260f) {
                return false;
            }
            if (a.this.f48261g != null) {
                a.this.f48261g.a(a.this.f48257c.getText().toString());
            }
            if (a.this.f48262h.f48565d || a.this.f48261g == null) {
                return true;
            }
            a.this.f48261g.d();
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
            a.this.f48259e.setEnabled(false);
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.g.s.c f48269e;

        public e(d.b.g0.g.s.c cVar) {
            this.f48269e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            int length;
            try {
                if (a.this.f48257c.getText().length() <= this.f48269e.f48562a.length()) {
                    length = a.this.f48257c.getText().length();
                } else {
                    length = this.f48269e.f48562a.length();
                }
                a.this.f48257c.setSelection(length);
            } catch (Exception e2) {
                if (k.f45050a) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48271e;

        public f(String str) {
            this.f48271e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f48257c.setSelection(this.f48271e.length());
        }
    }

    public a(Context context) {
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(context).inflate(g.aiapps_ai_games_input_view, (ViewGroup) null);
        this.f48255a = relativeLayout;
        this.f48256b = (EditText) relativeLayout.findViewById(d.b.g0.a.f.ai_games_virtual_input_et);
        this.f48258d = (RelativeLayout) this.f48255a.findViewById(d.b.g0.a.f.ai_games_real_input_container);
        this.f48257c = (EditText) this.f48255a.findViewById(d.b.g0.a.f.ai_games_real_input_et);
        Button button = (Button) this.f48255a.findViewById(d.b.g0.a.f.ai_games_input_send_btn);
        this.f48259e = button;
        button.setOnClickListener(this.i);
        this.f48257c.addTextChangedListener(this.j);
        this.f48257c.setOnEditorActionListener(this.k);
        this.f48259e.post(new d());
    }

    public View f() {
        return this.f48255a;
    }

    public boolean g() {
        return this.f48260f;
    }

    public void h() {
        EditText editText;
        EditText editText2;
        InputMethodManager inputMethodManager = (InputMethodManager) AppRuntime.getAppContext().getSystemService("input_method");
        if (!inputMethodManager.isActive() || (editText = this.f48257c) == null) {
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(editText.getApplicationWindowToken(), 0);
        this.f48260f = false;
        this.f48256b.setVisibility(8);
        this.f48258d.setVisibility(8);
        a.f fVar = this.f48261g;
        if (fVar == null || (editText2 = this.f48257c) == null) {
            return;
        }
        fVar.b(editText2.getText().toString());
    }

    public void i(a.f fVar) {
        this.f48261g = fVar;
    }

    public void j(d.b.g0.g.s.c cVar) {
        this.f48262h = cVar;
        if (this.f48257c == null || cVar == null) {
            return;
        }
        if (!TextUtils.isEmpty(cVar.f48562a)) {
            this.f48257c.setText(cVar.f48562a);
            if (cVar.f48563b > 0) {
                if (!TextUtils.isEmpty(cVar.f48562a) && cVar.f48562a.length() > cVar.f48563b) {
                    cVar.f48563b = cVar.f48562a.length();
                }
                this.f48257c.setFilters(new InputFilter[]{new InputFilter.LengthFilter(cVar.f48563b)});
            }
            this.f48257c.postDelayed(new e(cVar), 300L);
        } else {
            this.f48257c.setText("");
        }
        this.f48259e.setEnabled(!TextUtils.isEmpty(cVar.f48562a));
        if (cVar.f48564c) {
            this.f48257c.setMinLines(1);
            this.f48257c.setInputType(131073);
            this.f48259e.setText(cVar.f48567f);
            return;
        }
        this.f48257c.setMaxLines(1);
        this.f48257c.setInputType(1);
    }

    public void k(int i) {
        this.f48258d.setVisibility(0);
        this.f48257c.setFocusableInTouchMode(true);
        this.f48257c.requestFocus();
        this.f48256b.setVisibility(8);
        this.f48260f = true;
        a.f fVar = this.f48261g;
        if (fVar != null) {
            fVar.e(i);
        }
    }

    public boolean l() {
        if (this.f48260f) {
            return false;
        }
        this.f48256b.setVisibility(0);
        this.f48258d.setVisibility(8);
        this.f48256b.setFocusableInTouchMode(true);
        this.f48256b.requestFocus();
        ((InputMethodManager) AppRuntime.getAppContext().getSystemService("input_method")).showSoftInput(this.f48256b, 0);
        return true;
    }

    public boolean m(String str) {
        EditText editText;
        if (!this.f48260f || (editText = this.f48257c) == null) {
            return false;
        }
        editText.setText(str);
        this.f48257c.postDelayed(new f(str), 300L);
        return true;
    }
}
