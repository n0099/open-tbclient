package d.b.h0.a.a0.c.f;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.component.components.textarea.SwanEditText;
import d.b.h0.a.i2.h0;
import d.b.h0.a.i2.w;
import d.b.h0.a.t0.f.b;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class a extends d.b.h0.a.a0.a.a.a<SwanEditText, d.b.h0.a.a0.c.f.b> {
    public SwanAppActivity i;
    public d.b.h0.a.e0.l.e j;
    public d.b.h0.a.t0.f.b k;
    public int l;

    /* renamed from: d.b.h0.a.a0.c.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0625a extends d.b.h0.a.o0.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SwanEditText f43849a;

        public C0625a(SwanEditText swanEditText) {
            this.f43849a = swanEditText;
        }

        @Override // d.b.h0.a.o0.a, d.b.h0.a.o0.b
        public void c() {
            if (a.this.k != null) {
                a.this.k.dismiss();
                a.this.s0(this.f43849a);
            }
        }

        @Override // d.b.h0.a.o0.a, d.b.h0.a.o0.b
        public boolean onKeyDown(int i, KeyEvent keyEvent) {
            if (i != 4 || a.this.k == null) {
                return false;
            }
            a.this.k.dismiss();
            a.this.s0(this.f43849a);
            return true;
        }
    }

    /* loaded from: classes2.dex */
    public class b implements b.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SwanEditText f43851a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.a0.c.f.b f43852b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.o0.a f43853c;

        public b(SwanEditText swanEditText, d.b.h0.a.a0.c.f.b bVar, d.b.h0.a.o0.a aVar) {
            this.f43851a = swanEditText;
            this.f43852b = bVar;
            this.f43853c = aVar;
        }

        @Override // d.b.h0.a.t0.f.b.d
        public void a() {
            if (d.b.h0.a.a0.b.a.f43821h) {
                Log.d("Component-Input", "numeric keyboard onKeyboardHide");
            }
            a.this.B0(this.f43851a);
            a.this.i.unregisterCallback(this.f43853c);
        }

        @Override // d.b.h0.a.t0.f.b.d
        public void b(int i) {
            if (d.b.h0.a.a0.b.a.f43821h) {
                Log.d("Component-Input", "numeric keyboard onKeyboardShow");
            }
            a aVar = a.this;
            aVar.C0(aVar.i, this.f43851a, this.f43852b, i);
            a.this.i.registerCallback(this.f43853c);
        }
    }

    /* loaded from: classes2.dex */
    public class c implements TextView.OnEditorActionListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.a0.c.f.b f43855a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SwanEditText f43856b;

        public c(d.b.h0.a.a0.c.f.b bVar, SwanEditText swanEditText) {
            this.f43855a = bVar;
            this.f43856b = swanEditText;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            d.b.h0.a.t0.c.d(d.b.h0.a.t0.b.d().c(), a.this.l);
            if (this.f43855a.P) {
                return true;
            }
            this.f43856b.clearFocus();
            return false;
        }
    }

    /* loaded from: classes2.dex */
    public class d implements TextWatcher {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanEditText f43858e;

        public d(a aVar, SwanEditText swanEditText) {
            this.f43858e = swanEditText;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (i2 != i3) {
                d.b.h0.a.t0.c.c(this.f43858e, i2 > i3 ? '\b' : charSequence.charAt((i + i3) - 1));
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e implements View.OnFocusChangeListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.a0.c.f.b f43859e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SwanEditText f43860f;

        public e(d.b.h0.a.a0.c.f.b bVar, SwanEditText swanEditText) {
            this.f43859e = bVar;
            this.f43860f = swanEditText;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (d.b.h0.a.a0.b.a.f43821h) {
                Log.d("Component-Input", "onFocusChange:" + z);
            }
            if (z) {
                return;
            }
            d.b.h0.a.c0.c.g("Component-Input", "send blur callback");
            if (!TextUtils.equals("text", this.f43859e.O) && a.this.k != null) {
                a.this.k.dismiss();
            }
            d.b.h0.a.t0.c.b(this.f43860f, a.this.l);
            a.this.s0(this.f43860f);
        }
    }

    /* loaded from: classes2.dex */
    public class f implements d.b.h0.a.e2.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SwanEditText f43862a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SwanAppActivity f43863b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.a0.c.f.b f43864c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ View f43865d;

        public f(SwanEditText swanEditText, SwanAppActivity swanAppActivity, d.b.h0.a.a0.c.f.b bVar, View view) {
            this.f43862a = swanEditText;
            this.f43863b = swanAppActivity;
            this.f43864c = bVar;
            this.f43865d = view;
        }

        @Override // d.b.h0.a.e2.a
        public void a(String str) {
        }

        @Override // d.b.h0.a.e2.a
        public void b(String str, int i) {
            a.this.B0(this.f43862a);
            d.b.h0.a.e2.c.i().k(this.f43865d);
        }

        @Override // d.b.h0.a.e2.a
        public void c(String str, int i) {
            if (this.f43862a.hasFocus()) {
                a.this.C0(this.f43863b, this.f43862a, this.f43864c, i);
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface g {
        void a(String str, JSONObject jSONObject);
    }

    public a(@Nullable Context context, @NonNull d.b.h0.a.a0.c.f.b bVar, @NonNull SwanAppActivity swanAppActivity, @NonNull d.b.h0.a.e0.l.e eVar, @NonNull g gVar) {
        super(context, bVar);
        this.i = swanAppActivity;
        this.j = eVar;
        d.b.h0.a.t0.c.a(gVar);
    }

    @Override // d.b.h0.a.a0.b.a
    public void A() {
        super.A();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.h0.a.a0.a.c.a
    /* renamed from: A0 */
    public void a0(@NonNull SwanEditText swanEditText, @NonNull d.b.h0.a.a0.c.f.b bVar) {
        b0(swanEditText, bVar, 16);
    }

    public final void B0(@NonNull SwanEditText swanEditText) {
        if (d.b.h0.a.a0.b.a.f43821h) {
            Log.d("Component-Input", "scrollBackWhenKeyboardHide, mKeyboardHeight：" + this.l);
        }
        if (this.l != 0) {
            this.l = 0;
            swanEditText.clearFocus();
            if (this.j.b3().getScrollY() > 0) {
                this.j.b3().setScrollY(0);
            }
        }
    }

    public final void C0(@NonNull SwanAppActivity swanAppActivity, @NonNull SwanEditText swanEditText, d.b.h0.a.a0.c.f.b bVar, int i) {
        int i2;
        d.b.h0.a.p.d.c o = d.b.h0.a.z0.f.V().o();
        if (d.b.h0.a.a0.b.a.f43821h) {
            Log.d("Component-Input", "scrollUpWhenKeyboardShow, mKeyboardHeight：" + this.l + "，keyboardHeight : " + i);
        }
        if (this.l == i || o == null) {
            return;
        }
        this.l = i;
        d.b.h0.a.t0.c.f(swanEditText, i);
        if (bVar.Q) {
            if (bVar.l == null) {
                bVar.l = new d.b.h0.a.e1.d.a.a();
            }
            int webViewScrollY = o.getWebViewScrollY();
            int height = swanEditText.getHeight();
            if (height == 0) {
                height = bVar.l.d();
            }
            int height2 = ((this.j.b3().getHeight() - bVar.l.f()) - height) + webViewScrollY + h0.i(swanAppActivity);
            int i3 = bVar.H;
            if (i3 > height2) {
                i3 = height2;
            }
            int i4 = height2 - i;
            int scrollY = this.j.b3().getScrollY();
            if (i4 < 0) {
                i2 = i3 - i4;
            } else {
                if (i3 > i4) {
                    scrollY = i3 - i4;
                }
                i2 = scrollY;
            }
            this.j.b3().setScrollY(i2);
        }
    }

    public final void D0(SwanEditText swanEditText, d.b.h0.a.a0.c.f.b bVar, SwanAppActivity swanAppActivity) {
        swanEditText.setOnEditorActionListener(new c(bVar, swanEditText));
        d dVar = new d(this, swanEditText);
        swanEditText.setOnFocusChangeListener(new e(bVar, swanEditText));
        if (TextUtils.equals("text", bVar.O)) {
            View decorView = swanAppActivity.getWindow().getDecorView();
            d.b.h0.a.e2.c.i().l(decorView, bVar.f43834f, new f(swanEditText, swanAppActivity, bVar, decorView));
        }
        d.b.h0.a.t0.b.d().f(dVar);
        swanEditText.addTextChangedListener(dVar);
    }

    public final void E0(SwanEditText swanEditText) {
        try {
            Method method = SwanEditText.class.getMethod("setShowSoftInputOnFocus", Boolean.TYPE);
            method.setAccessible(true);
            method.invoke(swanEditText, Boolean.FALSE);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e2) {
            if (d.b.h0.a.a0.b.a.f43821h) {
                e2.printStackTrace();
            }
        }
    }

    public final void s0(@Nullable SwanEditText swanEditText) {
        SwanAppActivity activity = d.b.h0.a.z0.f.V().getActivity();
        if (activity == null) {
            d.b.h0.a.c0.c.l("Component-Input", "activity is null when close input");
            return;
        }
        w.a(activity, activity.getWindow().getDecorView().getWindowToken());
        if (swanEditText == null) {
            return;
        }
        swanEditText.setOnFocusChangeListener(null);
        d.b.h0.a.c0.c.g("Component-Input", "remove input");
        if (C().a()) {
            d.b.h0.a.c0.c.g("Component-Input", "remove input success");
        } else {
            d.b.h0.a.c0.c.l("Component-Input", "remove input fail");
        }
        d.b.h0.a.t0.b.d().b();
    }

    public final void t0() {
        s0(d.b.h0.a.t0.b.d().c());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.h0.a.a0.b.a
    @NonNull
    /* renamed from: u0 */
    public SwanEditText v(@NonNull Context context) {
        t0();
        return d.b.h0.a.t0.b.d().a(context);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.h0.a.a0.b.a
    /* renamed from: v0 */
    public void B(@NonNull SwanEditText swanEditText) {
        super.B(swanEditText);
        d.b.h0.a.a0.c.f.b bVar = (d.b.h0.a.a0.c.f.b) n();
        swanEditText.setText(bVar.x);
        int i = 1;
        swanEditText.setSingleLine(true);
        swanEditText.setTag(bVar.i);
        if (!TextUtils.equals("text", bVar.O)) {
            String str = bVar.O;
            char c2 = 65535;
            int hashCode = str.hashCode();
            if (hashCode != -1193508181) {
                if (hashCode == 95582509 && str.equals("digit")) {
                    c2 = 0;
                }
            } else if (str.equals("idcard")) {
                c2 = 1;
            }
            if (c2 == 0) {
                i = 2;
            } else if (c2 != 1) {
                i = 0;
            }
            this.k = new d.b.h0.a.t0.f.b(this.i, swanEditText, i, bVar.G);
            this.k.e(new b(swanEditText, bVar, new C0625a(swanEditText)));
            this.k.f();
        }
        if (bVar.M) {
            swanEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.h0.a.a0.a.c.a
    /* renamed from: w0 */
    public void V(@NonNull SwanEditText swanEditText, @NonNull d.b.h0.a.a0.c.f.b bVar, @NonNull d.b.h0.a.a0.f.b bVar2) {
        boolean t = t();
        if (t) {
            swanEditText.removeTextChangedListener(d.b.h0.a.t0.b.d().e());
        }
        super.d0(swanEditText, bVar, bVar2);
        if (t) {
            swanEditText.addTextChangedListener(d.b.h0.a.t0.b.d().e());
        } else {
            D0(swanEditText, bVar, this.i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.h0.a.a0.a.d.a
    /* renamed from: x0 */
    public void T(@NonNull SwanEditText swanEditText, @NonNull d.b.h0.a.a0.c.f.b bVar) {
        if (d.b.h0.a.a0.b.a.f43821h) {
            Log.d("Component-Input", "renderPadding");
        }
        swanEditText.setPadding(0, -6, 0, 0);
    }

    @Override // d.b.h0.a.a0.b.a
    public void y(boolean z) {
        super.y(z);
        if (!z) {
            d.b.h0.a.a0.g.a.a("Component-Input", "attach fail");
        }
        SwanEditText swanEditText = (SwanEditText) q();
        if (swanEditText == null) {
            d.b.h0.a.a0.g.a.a("Component-Input", "onAttached with null editText");
            swanEditText = d.b.h0.a.t0.b.d().c();
        }
        swanEditText.setFocusable(true);
        swanEditText.setFocusableInTouchMode(true);
        swanEditText.requestFocus();
        if (TextUtils.equals(((d.b.h0.a.a0.c.f.b) n()).O, "text")) {
            InputMethodManager inputMethodManager = (InputMethodManager) this.i.getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.showSoftInput(swanEditText, 0);
            }
        } else if (Build.VERSION.SDK_INT >= 21) {
            swanEditText.setShowSoftInputOnFocus(false);
        } else {
            E0(swanEditText);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.h0.a.a0.a.c.a
    /* renamed from: y0 */
    public void W(@NonNull SwanEditText swanEditText, @NonNull d.b.h0.a.a0.c.f.b bVar) {
        if (d.b.h0.a.a0.b.a.f43821h) {
            Log.d("Component-Input", "renderText");
        }
        if (t()) {
            super.W(swanEditText, bVar);
            try {
                swanEditText.setSelection(bVar.x.length());
            } catch (IndexOutOfBoundsException e2) {
                if (d.b.h0.a.a0.b.a.f43821h) {
                    e2.printStackTrace();
                }
                d.b.h0.a.a0.g.a.a("Component-Input", "value is invalid, out of max length");
            }
        } else if (TextUtils.equals(swanEditText.getText(), bVar.x)) {
        } else {
            d.b.h0.a.a0.g.a.a("Component-Input", "insert input: set text must before render");
            super.W(swanEditText, bVar);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.h0.a.a0.a.c.a
    /* renamed from: z0 */
    public void Y(@NonNull SwanEditText swanEditText, @NonNull d.b.h0.a.a0.c.f.b bVar) {
        if (d.b.h0.a.a0.b.a.f43821h) {
            Log.d("Component-Input", "renderTextStyleFontWeight");
        }
        String str = bVar.D;
        char c2 = 65535;
        int hashCode = str.hashCode();
        if (hashCode != -1178781136) {
            if (hashCode == -841373419 && str.equals("boldItalic")) {
                c2 = 1;
            }
        } else if (str.equals("italic")) {
            c2 = 0;
        }
        if (c2 == 0) {
            swanEditText.setTypeface(Typeface.SANS_SERIF, 2);
        } else if (c2 != 1) {
            super.Y(swanEditText, bVar);
        } else {
            swanEditText.setTypeface(Typeface.SANS_SERIF, 3);
        }
    }
}
