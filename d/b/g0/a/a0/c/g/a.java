package d.b.g0.a.a0.c.g;

import android.content.Context;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.component.components.textarea.SwanEditText;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.textarea.ShowConfirmBarLayout;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import d.b.g0.a.i2.h0;
import d.b.g0.a.i2.k0;
import d.b.g0.a.i2.w;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class a extends d.b.g0.a.a0.a.a.a<SwanEditText, d.b.g0.a.a0.c.g.b> {
    public SwanAppActivity i;
    public d.b.g0.a.e0.l.e j;
    public int k;
    public h l;
    public String m;
    public int n;
    public ShowConfirmBarLayout o;
    public boolean p;
    public int q;

    /* renamed from: d.b.g0.a.a0.c.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0593a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.a0.c.g.b f43145e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SwanEditText f43146f;

        public RunnableC0593a(d.b.g0.a.a0.c.g.b bVar, SwanEditText swanEditText) {
            this.f43145e = bVar;
            this.f43146f = swanEditText;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.i != null) {
                InputMethodManager inputMethodManager = (InputMethodManager) a.this.i.getSystemService("input_method");
                if (inputMethodManager == null || !this.f43145e.S) {
                    return;
                }
                this.f43146f.setFocusable(true);
                this.f43146f.setFocusableInTouchMode(true);
                this.f43146f.requestFocus();
                inputMethodManager.showSoftInput(this.f43146f, 0);
                return;
            }
            d.b.g0.a.a0.g.a.a("Component-TextArea", "activity is null, set textarea attr failed");
        }
    }

    /* loaded from: classes3.dex */
    public class b implements SwanEditText.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SwanEditText f43148a;

        public b(SwanEditText swanEditText) {
            this.f43148a = swanEditText;
        }

        @Override // com.baidu.swan.apps.component.components.textarea.SwanEditText.a
        public void a(int i, int i2) {
            a.this.F0(this.f43148a, "selection");
        }
    }

    /* loaded from: classes3.dex */
    public class c implements TextWatcher {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanEditText f43150e;

        public c(SwanEditText swanEditText) {
            this.f43150e = swanEditText;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (this.f43150e.hasFocus()) {
                d.b.g0.a.c0.c.g("Component-TextArea", "send input callback");
                a.this.F0(this.f43150e, Config.INPUT_PART);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (this.f43150e.getLineCount() <= 0 || a.this.q == this.f43150e.getLineCount()) {
                return;
            }
            d.b.g0.a.c0.c.g("Component-TextArea", "send line change callback");
            a.this.F0(this.f43150e, "linechange");
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnFocusChangeListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanEditText f43152e;

        public d(SwanEditText swanEditText) {
            this.f43152e = swanEditText;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (d.b.g0.a.a0.b.a.f43099h) {
                Log.d("Component-TextArea", "onFocusChange:" + z);
            }
            if (z) {
                if (a.this.k != 0) {
                    a.this.F0(this.f43152e, AddFriendActivityConfig.TYPE_FOCUS);
                }
                a.this.I0();
                return;
            }
            a.this.F0(this.f43152e, "blur");
            a.this.H0();
        }
    }

    /* loaded from: classes3.dex */
    public class e implements d.b.g0.a.e2.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SwanEditText f43154a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SwanAppActivity f43155b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ View f43156c;

        /* renamed from: d.b.g0.a.a0.c.g.a$e$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0594a implements ShowConfirmBarLayout.b {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d.b.g0.a.a0.c.g.b f43158a;

            public C0594a(d.b.g0.a.a0.c.g.b bVar) {
                this.f43158a = bVar;
            }

            @Override // com.baidu.swan.apps.textarea.ShowConfirmBarLayout.b
            public void onClick(View view) {
                InputMethodManager inputMethodManager;
                if (!this.f43158a.a0 && (inputMethodManager = (InputMethodManager) e.this.f43155b.getSystemService("input_method")) != null) {
                    inputMethodManager.hideSoftInputFromWindow(e.this.f43154a.getWindowToken(), 0);
                }
                d.b.g0.a.c0.c.g("Component-TextArea", "send confirm change callback");
                e eVar = e.this;
                a.this.F0(eVar.f43154a, "confirm");
            }
        }

        public e(SwanEditText swanEditText, SwanAppActivity swanAppActivity, View view) {
            this.f43154a = swanEditText;
            this.f43155b = swanAppActivity;
            this.f43156c = view;
        }

        @Override // d.b.g0.a.e2.a
        public void a(String str) {
            if (a.this.q != this.f43154a.getLineCount()) {
                d.b.g0.a.c0.c.g("Component-TextArea", "send line change callback");
                a.this.F0(this.f43154a, "linechange");
                a.this.E0(this.f43154a, str);
            }
        }

        @Override // d.b.g0.a.e2.a
        public void b(String str, int i) {
            if (a.this.k != 0) {
                a.this.k = 0;
                if (a.this.j.b3().getScrollY() > 0) {
                    a.this.j.b3().setScrollY(0);
                    a.this.p = false;
                }
                if (a.this.o != null && a.this.o.getVisibility() == 0) {
                    ((FrameLayout) this.f43156c.findViewById(16908290)).removeView(a.this.o);
                    a.this.o = null;
                }
            }
            if (this.f43154a.hasFocus()) {
                this.f43154a.clearFocus();
                if (d.b.g0.a.a0.b.a.f43099h) {
                    Log.d("Component-TextArea", "clearFocus");
                }
            }
        }

        @Override // d.b.g0.a.e2.a
        public void c(String str, int i) {
            int i2;
            d.b.g0.a.a0.c.g.b bVar = (d.b.g0.a.a0.c.g.b) a.this.n();
            d.b.g0.a.p.d.c o = d.b.g0.a.z0.f.V().o();
            if (a.this.k == i || !this.f43154a.hasFocus() || o == null) {
                return;
            }
            a.this.k = i;
            a.this.n = this.f43154a.getHeight();
            a.this.F0(this.f43154a, AddFriendActivityConfig.TYPE_FOCUS);
            boolean z = bVar.W;
            if (bVar.V) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                i2 = h0.f(38.0f);
                if (a.this.o == null) {
                    a.this.o = new ShowConfirmBarLayout(this.f43155b);
                    a.this.o.setOnConfirmButtonClickListener(new C0594a(bVar));
                    layoutParams.topMargin = ((this.f43156c.getHeight() - i) - i2) - h0.q();
                    ((FrameLayout) this.f43156c.findViewById(16908290)).addView(a.this.o, layoutParams);
                }
            } else {
                i2 = 0;
            }
            if (z) {
                int webViewScrollY = !bVar.U ? o.getWebViewScrollY() : 0;
                d.b.g0.a.e1.d.a.a aVar = bVar.l;
                int height = ((a.this.j.b3().getHeight() - (aVar != null ? aVar.f() : 0)) - this.f43154a.getHeight()) + webViewScrollY;
                int i3 = bVar.H;
                if (height - i3 < i) {
                    a.this.p = true;
                    if (i3 > height) {
                        a.this.j.b3().setScrollY(i + i2);
                        return;
                    } else {
                        a.this.j.b3().setScrollY((i - height) + i3 + i2);
                        return;
                    }
                }
                a.this.p = false;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanEditText f43160e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f43161f;

        public f(SwanEditText swanEditText, String str) {
            this.f43160e = swanEditText;
            this.f43161f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f43160e != null) {
                JSONObject jSONObject = new JSONObject();
                String obj = this.f43160e.getTag().toString();
                if (!TextUtils.equals(obj, ((d.b.g0.a.a0.c.g.b) a.this.n()).f43112f)) {
                    d.b.g0.a.a0.g.a.a("Component-TextArea", "changeTextAreaStatus with different id");
                }
                int D0 = a.this.D0(this.f43160e);
                try {
                    jSONObject.put("eventName", this.f43161f);
                    jSONObject.put("value", this.f43160e.getText().toString());
                    jSONObject.put(Constants.EXTRA_CONFIG_CURSOR, this.f43160e.getSelectionStart());
                    jSONObject.put("selectionStart", this.f43160e.getSelectionStart());
                    jSONObject.put("selectionEnd", this.f43160e.getSelectionEnd());
                    jSONObject.put("lineCount", this.f43160e.getLineCount());
                    jSONObject.put("height", h0.H(D0));
                    jSONObject.put("keyboardHeight", h0.H(a.this.k));
                } catch (JSONException e2) {
                    if (d.b.g0.a.a0.b.a.f43099h) {
                        e2.printStackTrace();
                    }
                }
                if (d.b.g0.a.a0.b.a.f43099h) {
                    Log.d("Component-TextArea", "changeTextAreaStatus:" + jSONObject.toString());
                }
                a.this.l.a(obj, a.this.m, jSONObject);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements TextView.OnEditorActionListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SwanEditText f43163a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.a0.c.g.b f43164b;

        public g(SwanEditText swanEditText, d.b.g0.a.a0.c.g.b bVar) {
            this.f43163a = swanEditText;
            this.f43164b = bVar;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (i >= 2 && i <= 7) {
                a.this.F0(this.f43163a, "confirm");
            }
            return this.f43164b.a0;
        }
    }

    /* loaded from: classes3.dex */
    public interface h {
        void a(String str, String str2, JSONObject jSONObject);
    }

    public a(@Nullable Context context, @NonNull d.b.g0.a.a0.c.g.b bVar, @NonNull SwanAppActivity swanAppActivity, @NonNull d.b.g0.a.e0.l.e eVar, @NonNull h hVar) {
        super(context, bVar);
        this.p = false;
        this.q = 1;
        this.i = swanAppActivity;
        this.j = eVar;
        this.l = hVar;
    }

    public final int D0(SwanEditText swanEditText) {
        d.b.g0.a.a0.c.g.b bVar = (d.b.g0.a.a0.c.g.b) n();
        int lineCount = swanEditText.getLineCount();
        int lineHeight = swanEditText.getLineHeight();
        int i = bVar.X;
        int i2 = bVar.Y;
        int height = swanEditText.getHeight();
        if (bVar.T) {
            int paddingTop = (lineHeight * lineCount) + swanEditText.getPaddingTop() + swanEditText.getPaddingBottom();
            if (i2 < i) {
                i2 = i;
            }
            return paddingTop <= i ? i : paddingTop >= i2 ? i2 : paddingTop;
        }
        return height;
    }

    public final void E0(SwanEditText swanEditText, String str) {
        d.b.g0.a.a0.c.g.b bVar = (d.b.g0.a.a0.c.g.b) n();
        if (!TextUtils.equals(str, bVar.f43112f)) {
            d.b.g0.a.a0.g.a.a("Component-TextArea", "keyBoardShow with different id");
        }
        boolean z = bVar.W;
        if (!swanEditText.hasFocus() || bVar.U) {
            return;
        }
        if (this.k > 0 && z && this.p) {
            int scrollY = this.j.b3().getScrollY() + (swanEditText.getHeight() - this.n);
            if (scrollY > 0) {
                this.j.b3().setScrollY(scrollY);
            } else {
                this.j.b3().setScrollY(0);
            }
        }
        this.n = swanEditText.getHeight();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final void F0(SwanEditText swanEditText, String str) {
        char c2;
        switch (str.hashCode()) {
            case -1715965556:
                if (str.equals("selection")) {
                    c2 = 4;
                    break;
                }
                c2 = 65535;
                break;
            case 3027047:
                if (str.equals("blur")) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case 97604824:
                if (str.equals(AddFriendActivityConfig.TYPE_FOCUS)) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case 100358090:
                if (str.equals(Config.INPUT_PART)) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case 259718308:
                if (str.equals("linechange")) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        if (c2 == 0) {
            this.q = swanEditText.getLineCount();
            ((d.b.g0.a.a0.c.g.b) n()).m(swanEditText.getHeight());
        } else if (c2 == 1) {
            ((d.b.g0.a.a0.c.g.b) n()).j(swanEditText.getText().toString());
        } else if (c2 == 2) {
            ((d.b.g0.a.a0.c.g.b) n()).q(true);
        } else if (c2 == 3) {
            ((d.b.g0.a.a0.c.g.b) n()).q(false);
        } else if (c2 == 4) {
            ((d.b.g0.a.a0.c.g.b) n()).l(swanEditText.getSelectionStart(), swanEditText.getSelectionEnd());
        }
        k0.T(new f(swanEditText, str));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.g0.a.a0.a.a.a, d.b.g0.a.a0.a.c.a, d.b.g0.a.a0.a.d.a, d.b.g0.a.a0.b.a
    @NonNull
    /* renamed from: G0 */
    public d.b.g0.a.a0.f.b k(@NonNull d.b.g0.a.a0.c.g.b bVar, @NonNull d.b.g0.a.a0.c.g.b bVar2) {
        d.b.g0.a.a0.f.b k = super.k(bVar, bVar2);
        if (!TextUtils.equals(bVar.O, bVar2.O)) {
            k.b(14);
        }
        if (bVar.P != bVar2.P) {
            k.b(14);
        }
        if (!TextUtils.equals(bVar.Q, bVar2.Q)) {
            k.b(14);
        }
        if (!TextUtils.equals(bVar.R, bVar2.R)) {
            k.b(14);
        }
        if (bVar.Z != bVar2.Z) {
            k.b(15);
        }
        return k;
    }

    public final void H0() {
        SwanAppActivity activity = d.b.g0.a.z0.f.V().getActivity();
        if (activity == null) {
            d.b.g0.a.c0.c.l("Component-TextArea", "activity is null when close input");
            return;
        }
        if (d.b.g0.a.a0.b.a.f43099h) {
            Log.d("Component-TextArea", "forceCloseKeyboard");
        }
        w.a(activity, activity.getWindow().getDecorView().getWindowToken());
    }

    public final void I0() {
        SwanAppActivity activity = d.b.g0.a.z0.f.V().getActivity();
        if (activity == null) {
            d.b.g0.a.c0.c.l("Component-TextArea", "activity is null when open input");
            return;
        }
        if (d.b.g0.a.a0.b.a.f43099h) {
            Log.d("Component-TextArea", "forceOpenKeyboard");
        }
        w.b(activity, true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.g0.a.a0.b.a
    @NonNull
    /* renamed from: J0 */
    public SwanEditText v(@NonNull Context context) {
        return new SwanEditText(context);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.g0.a.a0.b.a
    /* renamed from: K0 */
    public void B(@NonNull SwanEditText swanEditText) {
        super.B(swanEditText);
        d.b.g0.a.a0.c.g.b bVar = (d.b.g0.a.a0.c.g.b) n();
        swanEditText.setTag(bVar.f43112f);
        swanEditText.setInputType(262144);
        swanEditText.setSingleLine(false);
        swanEditText.setHorizontallyScrolling(false);
        this.m = bVar.i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.g0.a.a0.a.c.a
    /* renamed from: L0 */
    public void V(@NonNull SwanEditText swanEditText, @NonNull d.b.g0.a.a0.c.g.b bVar, @NonNull d.b.g0.a.a0.f.b bVar2) {
        super.d0(swanEditText, bVar, bVar2);
        if (bVar2.a(14)) {
            P0(swanEditText, bVar);
        }
        boolean z = !t();
        if (z) {
            swanEditText.setMinHeight(bVar.X);
            swanEditText.setMaxHeight(bVar.Y);
        }
        k0.T(new RunnableC0593a(bVar, swanEditText));
        if (bVar2.a(15)) {
            O0(swanEditText, bVar);
        }
        if (z) {
            V0(swanEditText, this.i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.g0.a.a0.a.a.a
    /* renamed from: M0 */
    public boolean f0(@NonNull SwanEditText swanEditText, @NonNull d.b.g0.a.a0.c.g.b bVar) {
        if (TextUtils.isEmpty(bVar.L) || "default".equals(bVar.L)) {
            return false;
        }
        boolean f0 = super.f0(swanEditText, bVar);
        if (f0) {
            swanEditText.setOnEditorActionListener(new g(swanEditText, bVar));
        }
        return f0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.g0.a.a0.a.a.a
    /* renamed from: N0 */
    public void g0(@NonNull SwanEditText swanEditText, @NonNull d.b.g0.a.a0.c.g.b bVar) {
        Editable text = swanEditText.getText();
        int length = text != null ? text.length() : 0;
        if (bVar.S) {
            int i = bVar.I;
            if (i <= length && i >= 0) {
                swanEditText.setSelection(i);
            } else {
                swanEditText.setSelection(length);
            }
        }
    }

    public final void O0(@NonNull SwanEditText swanEditText, @NonNull d.b.g0.a.a0.c.g.b bVar) {
        if (d.b.g0.a.a0.b.a.f43099h) {
            Log.d("Component-TextArea", "renderDisable");
        }
        swanEditText.setEnabled(!bVar.Z);
    }

    public final void P0(@NonNull SwanEditText swanEditText, @NonNull d.b.g0.a.a0.c.g.b bVar) {
        StyleSpan styleSpan;
        if (d.b.g0.a.a0.b.a.f43099h) {
            Log.d("Component-TextArea", "renderPlaceHolder");
        }
        SpannableString spannableString = new SpannableString(bVar.O);
        String str = bVar.Q;
        char c2 = 65535;
        int hashCode = str.hashCode();
        if (hashCode != -1039745817) {
            if (hashCode == 3029637 && str.equals("bold")) {
                c2 = 1;
            }
        } else if (str.equals("normal")) {
            c2 = 0;
        }
        if (c2 == 0) {
            styleSpan = new StyleSpan(0);
        } else if (c2 != 1) {
            styleSpan = new StyleSpan(0);
        } else {
            styleSpan = new StyleSpan(1);
        }
        spannableString.setSpan(styleSpan, 0, bVar.O.length(), 33);
        spannableString.setSpan(new ForegroundColorSpan(SwanAppConfigData.s(bVar.R)), 0, bVar.O.length(), 33);
        spannableString.setSpan(new AbsoluteSizeSpan(bVar.P, true), 0, bVar.O.length(), 33);
        swanEditText.setHint(spannableString);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.g0.a.a0.a.a.a
    /* renamed from: Q0 */
    public void i0(@NonNull SwanEditText swanEditText, @NonNull d.b.g0.a.a0.c.g.b bVar) {
        int i;
        Editable text = swanEditText.getText();
        int length = text != null ? text.length() : 0;
        int i2 = bVar.K;
        if (i2 > length || i2 <= 0 || (i = bVar.J) > i2 || i <= 0 || !bVar.S || swanEditText.hasFocus()) {
            return;
        }
        swanEditText.setSelection(bVar.J, bVar.K);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.g0.a.a0.a.c.a
    /* renamed from: R0 */
    public void W(@NonNull SwanEditText swanEditText, @NonNull d.b.g0.a.a0.c.g.b bVar) {
        if (d.b.g0.a.a0.b.a.f43099h) {
            Log.d("Component-TextArea", "renderText");
        }
        if (TextUtils.equals(swanEditText.getText(), bVar.x)) {
            return;
        }
        swanEditText.setText(bVar.x);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.g0.a.a0.a.c.a
    /* renamed from: S0 */
    public void Z(@NonNull SwanEditText swanEditText, @NonNull d.b.g0.a.a0.c.g.b bVar) {
        swanEditText.setLineSpacing(bVar.B, 1.0f);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.g0.a.a0.a.c.a
    /* renamed from: T0 */
    public void a0(@NonNull SwanEditText swanEditText, @NonNull d.b.g0.a.a0.c.g.b bVar) {
        super.b0(swanEditText, bVar, 48);
    }

    public void U0(String str) {
        if (!TextUtils.equals(((d.b.g0.a.a0.c.g.b) n()).f43112f, str)) {
            d.b.g0.a.a0.g.a.a("Component-TextArea", "sendLineChangeEvent with different id");
        }
        SwanEditText swanEditText = (SwanEditText) q();
        if (swanEditText == null) {
            d.b.g0.a.a0.g.a.a("Component-TextArea", "sendLineChangeEvent with a null editText");
        } else {
            F0(swanEditText, "linechange");
        }
    }

    public final void V0(SwanEditText swanEditText, @NonNull SwanAppActivity swanAppActivity) {
        swanEditText.setSelectListener(new b(swanEditText));
        swanEditText.addTextChangedListener(new c(swanEditText));
        swanEditText.setOnFocusChangeListener(new d(swanEditText));
        d.b.g0.a.e2.b.g(((d.b.g0.a.a0.c.g.b) n()).f43112f, swanAppActivity, new e(swanEditText, swanAppActivity, swanAppActivity.getWindow().getDecorView()));
    }
}
