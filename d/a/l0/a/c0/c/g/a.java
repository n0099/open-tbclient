package d.a.l0.a.c0.c.g;

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
import d.a.l0.a.v2.n0;
import d.a.l0.a.v2.q0;
import d.a.l0.a.v2.x;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class a extends d.a.l0.a.c0.a.a.a<SwanEditText, d.a.l0.a.c0.c.g.b> {

    /* renamed from: i  reason: collision with root package name */
    public SwanAppActivity f44561i;
    public d.a.l0.a.h0.g.f j;
    public int k;
    public h l;
    public String m;
    public int n;
    public ShowConfirmBarLayout o;
    public boolean p;
    public int q;

    /* renamed from: d.a.l0.a.c0.c.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0630a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.c0.c.g.b f44562e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SwanEditText f44563f;

        public RunnableC0630a(d.a.l0.a.c0.c.g.b bVar, SwanEditText swanEditText) {
            this.f44562e = bVar;
            this.f44563f = swanEditText;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f44561i != null) {
                InputMethodManager inputMethodManager = (InputMethodManager) a.this.f44561i.getSystemService("input_method");
                if (inputMethodManager == null || !this.f44562e.S) {
                    return;
                }
                this.f44563f.setFocusable(true);
                this.f44563f.setFocusableInTouchMode(true);
                this.f44563f.requestFocus();
                inputMethodManager.showSoftInput(this.f44563f, 0);
                return;
            }
            d.a.l0.a.c0.g.a.a("Component-TextArea", "activity is null, set textarea attr failed");
        }
    }

    /* loaded from: classes2.dex */
    public class b implements SwanEditText.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SwanEditText f44565a;

        public b(SwanEditText swanEditText) {
            this.f44565a = swanEditText;
        }

        @Override // com.baidu.swan.apps.component.components.textarea.SwanEditText.a
        public void a(int i2, int i3) {
            a.this.E0(this.f44565a, "selection");
        }
    }

    /* loaded from: classes2.dex */
    public class c implements TextWatcher {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanEditText f44567e;

        public c(SwanEditText swanEditText) {
            this.f44567e = swanEditText;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (this.f44567e.hasFocus()) {
                d.a.l0.a.e0.d.g("Component-TextArea", "send input callback");
                a.this.E0(this.f44567e, Config.INPUT_PART);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            if (this.f44567e.getLineCount() <= 0 || a.this.q == this.f44567e.getLineCount()) {
                return;
            }
            d.a.l0.a.e0.d.g("Component-TextArea", "send line change callback");
            a.this.E0(this.f44567e, "linechange");
        }
    }

    /* loaded from: classes2.dex */
    public class d implements View.OnFocusChangeListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanEditText f44569e;

        public d(SwanEditText swanEditText) {
            this.f44569e = swanEditText;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (d.a.l0.a.c0.b.a.f44508h) {
                Log.d("Component-TextArea", "onFocusChange:" + z);
            }
            if (z) {
                if (a.this.k != 0) {
                    a.this.E0(this.f44569e, AddFriendActivityConfig.TYPE_FOCUS);
                }
                a.this.H0();
                return;
            }
            a.this.E0(this.f44569e, "blur");
            a.this.G0();
        }
    }

    /* loaded from: classes2.dex */
    public class e implements d.a.l0.a.p2.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SwanEditText f44571a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SwanAppActivity f44572b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ View f44573c;

        /* renamed from: d.a.l0.a.c0.c.g.a$e$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0631a implements ShowConfirmBarLayout.b {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d.a.l0.a.c0.c.g.b f44575a;

            public C0631a(d.a.l0.a.c0.c.g.b bVar) {
                this.f44575a = bVar;
            }

            @Override // com.baidu.swan.apps.textarea.ShowConfirmBarLayout.b
            public void onClick(View view) {
                InputMethodManager inputMethodManager;
                if (!this.f44575a.a0 && (inputMethodManager = (InputMethodManager) e.this.f44572b.getSystemService("input_method")) != null) {
                    inputMethodManager.hideSoftInputFromWindow(e.this.f44571a.getWindowToken(), 0);
                }
                d.a.l0.a.e0.d.g("Component-TextArea", "send confirm change callback");
                e eVar = e.this;
                a.this.E0(eVar.f44571a, "confirm");
            }
        }

        public e(SwanEditText swanEditText, SwanAppActivity swanAppActivity, View view) {
            this.f44571a = swanEditText;
            this.f44572b = swanAppActivity;
            this.f44573c = view;
        }

        @Override // d.a.l0.a.p2.a
        public void a(String str, int i2) {
            if (a.this.k != 0) {
                a.this.k = 0;
                if (a.this.j.k3().getScrollY() > 0) {
                    a.this.j.k3().setScrollY(0);
                    a.this.p = false;
                }
                if (a.this.o != null && a.this.o.getVisibility() == 0) {
                    ((FrameLayout) this.f44573c.findViewById(16908290)).removeView(a.this.o);
                    a.this.o = null;
                }
            }
            if (this.f44571a.hasFocus()) {
                this.f44571a.clearFocus();
                if (d.a.l0.a.c0.b.a.f44508h) {
                    Log.d("Component-TextArea", "clearFocus");
                }
            }
        }

        @Override // d.a.l0.a.p2.a
        public void b(String str, int i2) {
            int i3;
            d.a.l0.a.c0.c.g.b bVar = (d.a.l0.a.c0.c.g.b) a.this.n();
            d.a.l0.a.p.e.c h2 = d.a.l0.a.g1.f.V().h();
            if (a.this.k == i2 || !this.f44571a.hasFocus() || h2 == null) {
                return;
            }
            a.this.k = i2;
            a.this.n = this.f44571a.getHeight();
            a.this.E0(this.f44571a, AddFriendActivityConfig.TYPE_FOCUS);
            boolean z = bVar.W;
            if (bVar.V) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                i3 = n0.g(38.0f);
                if (a.this.o == null) {
                    a.this.o = new ShowConfirmBarLayout(this.f44572b);
                    a.this.o.setOnConfirmButtonClickListener(new C0631a(bVar));
                    layoutParams.topMargin = ((this.f44573c.getHeight() - i2) - i3) - n0.s();
                    ((FrameLayout) this.f44573c.findViewById(16908290)).addView(a.this.o, layoutParams);
                }
            } else {
                i3 = 0;
            }
            if (z) {
                int webViewScrollY = !bVar.U ? h2.getWebViewScrollY() : 0;
                d.a.l0.a.l1.e.a.a aVar = bVar.l;
                int height = ((a.this.j.k3().getHeight() - (aVar != null ? aVar.f() : 0)) - this.f44571a.getHeight()) + webViewScrollY;
                int i4 = bVar.H;
                if (height - i4 < i2) {
                    a.this.p = true;
                    if (i4 > height) {
                        a.this.j.k3().setScrollY(i2 + i3);
                        return;
                    } else {
                        a.this.j.k3().setScrollY((i2 - height) + i4 + i3);
                        return;
                    }
                }
                a.this.p = false;
            }
        }

        @Override // d.a.l0.a.p2.a
        public void c(String str) {
            if (a.this.q != this.f44571a.getLineCount()) {
                d.a.l0.a.e0.d.g("Component-TextArea", "send line change callback");
                a.this.E0(this.f44571a, "linechange");
                a.this.D0(this.f44571a, str);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class f implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanEditText f44577e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f44578f;

        public f(SwanEditText swanEditText, String str) {
            this.f44577e = swanEditText;
            this.f44578f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f44577e != null) {
                JSONObject jSONObject = new JSONObject();
                String obj = this.f44577e.getTag().toString();
                if (!TextUtils.equals(obj, ((d.a.l0.a.c0.c.g.b) a.this.n()).f44521f)) {
                    d.a.l0.a.c0.g.a.a("Component-TextArea", "changeTextAreaStatus with different id");
                }
                int C0 = a.this.C0(this.f44577e);
                try {
                    jSONObject.put("eventName", this.f44578f);
                    jSONObject.put("value", this.f44577e.getText().toString());
                    jSONObject.put(Constants.EXTRA_CONFIG_CURSOR, this.f44577e.getSelectionStart());
                    jSONObject.put("selectionStart", this.f44577e.getSelectionStart());
                    jSONObject.put("selectionEnd", this.f44577e.getSelectionEnd());
                    jSONObject.put("lineCount", this.f44577e.getLineCount());
                    jSONObject.put("height", n0.K(C0));
                    jSONObject.put("keyboardHeight", n0.K(a.this.k));
                } catch (JSONException e2) {
                    if (d.a.l0.a.c0.b.a.f44508h) {
                        e2.printStackTrace();
                    }
                }
                if (d.a.l0.a.c0.b.a.f44508h) {
                    Log.d("Component-TextArea", "changeTextAreaStatus:" + jSONObject.toString());
                }
                a.this.l.a(obj, a.this.m, jSONObject);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class g implements TextView.OnEditorActionListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SwanEditText f44580a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.c0.c.g.b f44581b;

        public g(SwanEditText swanEditText, d.a.l0.a.c0.c.g.b bVar) {
            this.f44580a = swanEditText;
            this.f44581b = bVar;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
            if (i2 >= 2 && i2 <= 7) {
                a.this.E0(this.f44580a, "confirm");
            }
            return this.f44581b.a0;
        }
    }

    /* loaded from: classes2.dex */
    public interface h {
        void a(String str, String str2, JSONObject jSONObject);
    }

    public a(@Nullable Context context, @NonNull d.a.l0.a.c0.c.g.b bVar, @NonNull SwanAppActivity swanAppActivity, @NonNull d.a.l0.a.h0.g.f fVar, @NonNull h hVar) {
        super(context, bVar);
        this.p = false;
        this.q = 1;
        this.f44561i = swanAppActivity;
        this.j = fVar;
        this.l = hVar;
    }

    public final int C0(SwanEditText swanEditText) {
        d.a.l0.a.c0.c.g.b bVar = (d.a.l0.a.c0.c.g.b) n();
        int lineCount = swanEditText.getLineCount();
        int lineHeight = swanEditText.getLineHeight();
        int i2 = bVar.X;
        int i3 = bVar.Y;
        int height = swanEditText.getHeight();
        if (bVar.T) {
            int paddingTop = (lineHeight * lineCount) + swanEditText.getPaddingTop() + swanEditText.getPaddingBottom();
            if (i3 < i2) {
                i3 = i2;
            }
            return paddingTop <= i2 ? i2 : paddingTop >= i3 ? i3 : paddingTop;
        }
        return height;
    }

    public final void D0(SwanEditText swanEditText, String str) {
        d.a.l0.a.c0.c.g.b bVar = (d.a.l0.a.c0.c.g.b) n();
        if (!TextUtils.equals(str, bVar.f44521f)) {
            d.a.l0.a.c0.g.a.a("Component-TextArea", "keyBoardShow with different id");
        }
        boolean z = bVar.W;
        if (!swanEditText.hasFocus() || bVar.U) {
            return;
        }
        if (this.k > 0 && z && this.p) {
            int scrollY = this.j.k3().getScrollY() + (swanEditText.getHeight() - this.n);
            if (scrollY > 0) {
                this.j.k3().setScrollY(scrollY);
            } else {
                this.j.k3().setScrollY(0);
            }
        }
        this.n = swanEditText.getHeight();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final void E0(SwanEditText swanEditText, String str) {
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
            ((d.a.l0.a.c0.c.g.b) n()).m(swanEditText.getHeight());
        } else if (c2 == 1) {
            ((d.a.l0.a.c0.c.g.b) n()).j(swanEditText.getText().toString());
        } else if (c2 == 2) {
            ((d.a.l0.a.c0.c.g.b) n()).q(true);
        } else if (c2 == 3) {
            ((d.a.l0.a.c0.c.g.b) n()).q(false);
        } else if (c2 == 4) {
            ((d.a.l0.a.c0.c.g.b) n()).l(swanEditText.getSelectionStart(), swanEditText.getSelectionEnd());
        }
        q0.X(new f(swanEditText, str));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.l0.a.c0.a.a.a, d.a.l0.a.c0.a.c.b, d.a.l0.a.c0.a.d.a, d.a.l0.a.c0.b.a
    @NonNull
    /* renamed from: F0 */
    public d.a.l0.a.c0.f.b k(@NonNull d.a.l0.a.c0.c.g.b bVar, @NonNull d.a.l0.a.c0.c.g.b bVar2) {
        d.a.l0.a.c0.f.b k = super.k(bVar, bVar2);
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

    public final void G0() {
        SwanAppActivity activity = d.a.l0.a.g1.f.V().getActivity();
        if (activity == null) {
            d.a.l0.a.e0.d.l("Component-TextArea", "activity is null when close input");
            return;
        }
        if (d.a.l0.a.c0.b.a.f44508h) {
            Log.d("Component-TextArea", "forceCloseKeyboard");
        }
        x.a(activity, activity.getWindow().getDecorView().getWindowToken());
    }

    public final void H0() {
        SwanAppActivity activity = d.a.l0.a.g1.f.V().getActivity();
        if (activity == null) {
            d.a.l0.a.e0.d.l("Component-TextArea", "activity is null when open input");
            return;
        }
        if (d.a.l0.a.c0.b.a.f44508h) {
            Log.d("Component-TextArea", "forceOpenKeyboard");
        }
        x.b(activity, true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.l0.a.c0.b.a
    @NonNull
    /* renamed from: I0 */
    public SwanEditText v(@NonNull Context context) {
        return new SwanEditText(context);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.l0.a.c0.b.a
    /* renamed from: J0 */
    public void B(@NonNull SwanEditText swanEditText) {
        super.B(swanEditText);
        d.a.l0.a.c0.c.g.b bVar = (d.a.l0.a.c0.c.g.b) n();
        swanEditText.setTag(bVar.f44521f);
        swanEditText.setInputType(262144);
        swanEditText.setSingleLine(false);
        swanEditText.setHorizontallyScrolling(false);
        this.m = bVar.f44524i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.l0.a.c0.a.c.b
    /* renamed from: K0 */
    public void V(@NonNull SwanEditText swanEditText, @NonNull d.a.l0.a.c0.c.g.b bVar, @NonNull d.a.l0.a.c0.f.b bVar2) {
        super.c0(swanEditText, bVar, bVar2);
        if (bVar2.a(14)) {
            O0(swanEditText, bVar);
        }
        boolean z = !t();
        if (z) {
            swanEditText.setMinHeight(bVar.X);
            swanEditText.setMaxHeight(bVar.Y);
        }
        q0.X(new RunnableC0630a(bVar, swanEditText));
        if (bVar2.a(15)) {
            N0(swanEditText, bVar);
        }
        if (z) {
            T0(swanEditText, this.f44561i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.l0.a.c0.a.a.a
    /* renamed from: L0 */
    public boolean e0(@NonNull SwanEditText swanEditText, @NonNull d.a.l0.a.c0.c.g.b bVar) {
        if (TextUtils.isEmpty(bVar.L) || "default".equals(bVar.L)) {
            return false;
        }
        boolean e0 = super.e0(swanEditText, bVar);
        if (e0) {
            swanEditText.setOnEditorActionListener(new g(swanEditText, bVar));
        }
        return e0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.l0.a.c0.a.a.a
    /* renamed from: M0 */
    public void f0(@NonNull SwanEditText swanEditText, @NonNull d.a.l0.a.c0.c.g.b bVar) {
        Editable text = swanEditText.getText();
        int length = text != null ? text.length() : 0;
        if (bVar.S) {
            int i2 = bVar.I;
            if (i2 <= length && i2 >= 0) {
                swanEditText.setSelection(i2);
            } else {
                swanEditText.setSelection(length);
            }
        }
    }

    public final void N0(@NonNull SwanEditText swanEditText, @NonNull d.a.l0.a.c0.c.g.b bVar) {
        if (d.a.l0.a.c0.b.a.f44508h) {
            Log.d("Component-TextArea", "renderDisable");
        }
        swanEditText.setEnabled(!bVar.Z);
    }

    public final void O0(@NonNull SwanEditText swanEditText, @NonNull d.a.l0.a.c0.c.g.b bVar) {
        StyleSpan styleSpan;
        if (d.a.l0.a.c0.b.a.f44508h) {
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
    @Override // d.a.l0.a.c0.a.a.a
    /* renamed from: P0 */
    public void h0(@NonNull SwanEditText swanEditText, @NonNull d.a.l0.a.c0.c.g.b bVar) {
        int i2;
        Editable text = swanEditText.getText();
        int length = text != null ? text.length() : 0;
        int i3 = bVar.K;
        if (i3 > length || i3 <= 0 || (i2 = bVar.J) > i3 || i2 <= 0 || !bVar.S || swanEditText.hasFocus()) {
            return;
        }
        swanEditText.setSelection(bVar.J, bVar.K);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.l0.a.c0.a.c.b
    /* renamed from: Q0 */
    public void W(@NonNull SwanEditText swanEditText, @NonNull d.a.l0.a.c0.c.g.b bVar) {
        if (d.a.l0.a.c0.b.a.f44508h) {
            Log.d("Component-TextArea", "renderText");
        }
        if (TextUtils.equals(swanEditText.getText(), bVar.x)) {
            return;
        }
        swanEditText.setText(bVar.x);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.l0.a.c0.a.c.b
    /* renamed from: R0 */
    public void Z(@NonNull SwanEditText swanEditText, @NonNull d.a.l0.a.c0.c.g.b bVar) {
        super.a0(swanEditText, bVar, 48);
    }

    public void S0(String str) {
        if (!TextUtils.equals(((d.a.l0.a.c0.c.g.b) n()).f44521f, str)) {
            d.a.l0.a.c0.g.a.a("Component-TextArea", "sendLineChangeEvent with different id");
        }
        SwanEditText swanEditText = (SwanEditText) q();
        if (swanEditText == null) {
            d.a.l0.a.c0.g.a.a("Component-TextArea", "sendLineChangeEvent with a null editText");
        } else {
            E0(swanEditText, "linechange");
        }
    }

    public final void T0(SwanEditText swanEditText, @NonNull SwanAppActivity swanAppActivity) {
        swanEditText.setSelectListener(new b(swanEditText));
        swanEditText.addTextChangedListener(new c(swanEditText));
        swanEditText.setOnFocusChangeListener(new d(swanEditText));
        d.a.l0.a.p2.b.g(((d.a.l0.a.c0.c.g.b) n()).f44521f, swanAppActivity, new e(swanEditText, swanAppActivity, swanAppActivity.getWindow().getDecorView()));
    }
}
