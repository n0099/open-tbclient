package d.a.h0.a.a0.c.f;

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
import d.a.h0.a.i2.h0;
import d.a.h0.a.i2.w;
import d.a.h0.a.t0.f.b;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class a extends d.a.h0.a.a0.a.a.a<SwanEditText, d.a.h0.a.a0.c.f.b> {

    /* renamed from: i  reason: collision with root package name */
    public SwanAppActivity f41112i;
    public d.a.h0.a.e0.l.e j;
    public d.a.h0.a.t0.f.b k;
    public int l;

    /* renamed from: d.a.h0.a.a0.c.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0564a extends d.a.h0.a.o0.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SwanEditText f41113a;

        public C0564a(SwanEditText swanEditText) {
            this.f41113a = swanEditText;
        }

        @Override // d.a.h0.a.o0.a, d.a.h0.a.o0.b
        public void b() {
            if (a.this.k != null) {
                a.this.k.dismiss();
                a.this.s0(this.f41113a);
            }
        }

        @Override // d.a.h0.a.o0.a, d.a.h0.a.o0.b
        public boolean onKeyDown(int i2, KeyEvent keyEvent) {
            if (i2 != 4 || a.this.k == null) {
                return false;
            }
            a.this.k.dismiss();
            a.this.s0(this.f41113a);
            return true;
        }
    }

    /* loaded from: classes2.dex */
    public class b implements b.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SwanEditText f41115a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.a0.c.f.b f41116b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.o0.a f41117c;

        public b(SwanEditText swanEditText, d.a.h0.a.a0.c.f.b bVar, d.a.h0.a.o0.a aVar) {
            this.f41115a = swanEditText;
            this.f41116b = bVar;
            this.f41117c = aVar;
        }

        @Override // d.a.h0.a.t0.f.b.d
        public void a() {
            if (d.a.h0.a.a0.b.a.f41079h) {
                Log.d("Component-Input", "numeric keyboard onKeyboardHide");
            }
            a.this.B0(this.f41115a);
            a.this.f41112i.unregisterCallback(this.f41117c);
        }

        @Override // d.a.h0.a.t0.f.b.d
        public void b(int i2) {
            if (d.a.h0.a.a0.b.a.f41079h) {
                Log.d("Component-Input", "numeric keyboard onKeyboardShow");
            }
            a aVar = a.this;
            aVar.C0(aVar.f41112i, this.f41115a, this.f41116b, i2);
            a.this.f41112i.registerCallback(this.f41117c);
        }
    }

    /* loaded from: classes2.dex */
    public class c implements TextView.OnEditorActionListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.a0.c.f.b f41119a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SwanEditText f41120b;

        public c(d.a.h0.a.a0.c.f.b bVar, SwanEditText swanEditText) {
            this.f41119a = bVar;
            this.f41120b = swanEditText;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
            d.a.h0.a.t0.c.d(d.a.h0.a.t0.b.d().c(), a.this.l);
            if (this.f41119a.P) {
                return true;
            }
            this.f41120b.clearFocus();
            return false;
        }
    }

    /* loaded from: classes2.dex */
    public class d implements TextWatcher {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanEditText f41122e;

        public d(a aVar, SwanEditText swanEditText) {
            this.f41122e = swanEditText;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            if (i3 != i4) {
                d.a.h0.a.t0.c.c(this.f41122e, i3 > i4 ? '\b' : charSequence.charAt((i2 + i4) - 1));
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e implements View.OnFocusChangeListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.a0.c.f.b f41123e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SwanEditText f41124f;

        public e(d.a.h0.a.a0.c.f.b bVar, SwanEditText swanEditText) {
            this.f41123e = bVar;
            this.f41124f = swanEditText;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (d.a.h0.a.a0.b.a.f41079h) {
                Log.d("Component-Input", "onFocusChange:" + z);
            }
            if (z) {
                return;
            }
            d.a.h0.a.c0.c.g("Component-Input", "send blur callback");
            if (!TextUtils.equals("text", this.f41123e.O) && a.this.k != null) {
                a.this.k.dismiss();
            }
            d.a.h0.a.t0.c.b(this.f41124f, a.this.l);
            a.this.s0(this.f41124f);
        }
    }

    /* loaded from: classes2.dex */
    public class f implements d.a.h0.a.e2.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SwanEditText f41126a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SwanAppActivity f41127b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.a0.c.f.b f41128c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ View f41129d;

        public f(SwanEditText swanEditText, SwanAppActivity swanAppActivity, d.a.h0.a.a0.c.f.b bVar, View view) {
            this.f41126a = swanEditText;
            this.f41127b = swanAppActivity;
            this.f41128c = bVar;
            this.f41129d = view;
        }

        @Override // d.a.h0.a.e2.a
        public void a(String str, int i2) {
            a.this.B0(this.f41126a);
            d.a.h0.a.e2.c.i().k(this.f41129d);
        }

        @Override // d.a.h0.a.e2.a
        public void b(String str, int i2) {
            if (this.f41126a.hasFocus()) {
                a.this.C0(this.f41127b, this.f41126a, this.f41128c, i2);
            }
        }

        @Override // d.a.h0.a.e2.a
        public void c(String str) {
        }
    }

    /* loaded from: classes2.dex */
    public interface g {
        void a(String str, JSONObject jSONObject);
    }

    public a(@Nullable Context context, @NonNull d.a.h0.a.a0.c.f.b bVar, @NonNull SwanAppActivity swanAppActivity, @NonNull d.a.h0.a.e0.l.e eVar, @NonNull g gVar) {
        super(context, bVar);
        this.f41112i = swanAppActivity;
        this.j = eVar;
        d.a.h0.a.t0.c.a(gVar);
    }

    @Override // d.a.h0.a.a0.b.a
    public void A() {
        super.A();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.h0.a.a0.a.c.a
    /* renamed from: A0 */
    public void a0(@NonNull SwanEditText swanEditText, @NonNull d.a.h0.a.a0.c.f.b bVar) {
        b0(swanEditText, bVar, 16);
    }

    public final void B0(@NonNull SwanEditText swanEditText) {
        if (d.a.h0.a.a0.b.a.f41079h) {
            Log.d("Component-Input", "scrollBackWhenKeyboardHide, mKeyboardHeight：" + this.l);
        }
        if (this.l != 0) {
            this.l = 0;
            swanEditText.clearFocus();
            if (this.j.a3().getScrollY() > 0) {
                this.j.a3().setScrollY(0);
            }
        }
    }

    public final void C0(@NonNull SwanAppActivity swanAppActivity, @NonNull SwanEditText swanEditText, d.a.h0.a.a0.c.f.b bVar, int i2) {
        int i3;
        d.a.h0.a.p.d.c j = d.a.h0.a.z0.f.V().j();
        if (d.a.h0.a.a0.b.a.f41079h) {
            Log.d("Component-Input", "scrollUpWhenKeyboardShow, mKeyboardHeight：" + this.l + "，keyboardHeight : " + i2);
        }
        if (this.l == i2 || j == null) {
            return;
        }
        this.l = i2;
        d.a.h0.a.t0.c.f(swanEditText, i2);
        if (bVar.Q) {
            if (bVar.l == null) {
                bVar.l = new d.a.h0.a.e1.d.a.a();
            }
            int webViewScrollY = j.getWebViewScrollY();
            int height = swanEditText.getHeight();
            if (height == 0) {
                height = bVar.l.d();
            }
            int height2 = ((this.j.a3().getHeight() - bVar.l.f()) - height) + webViewScrollY + h0.i(swanAppActivity);
            int i4 = bVar.H;
            if (i4 > height2) {
                i4 = height2;
            }
            int i5 = height2 - i2;
            int scrollY = this.j.a3().getScrollY();
            if (i5 < 0) {
                i3 = i4 - i5;
            } else {
                if (i4 > i5) {
                    scrollY = i4 - i5;
                }
                i3 = scrollY;
            }
            this.j.a3().setScrollY(i3);
        }
    }

    public final void D0(SwanEditText swanEditText, d.a.h0.a.a0.c.f.b bVar, SwanAppActivity swanAppActivity) {
        swanEditText.setOnEditorActionListener(new c(bVar, swanEditText));
        d dVar = new d(this, swanEditText);
        swanEditText.setOnFocusChangeListener(new e(bVar, swanEditText));
        if (TextUtils.equals("text", bVar.O)) {
            View decorView = swanAppActivity.getWindow().getDecorView();
            d.a.h0.a.e2.c.i().l(decorView, bVar.f41092f, new f(swanEditText, swanAppActivity, bVar, decorView));
        }
        d.a.h0.a.t0.b.d().f(dVar);
        swanEditText.addTextChangedListener(dVar);
    }

    public final void E0(SwanEditText swanEditText) {
        try {
            Method method = SwanEditText.class.getMethod("setShowSoftInputOnFocus", Boolean.TYPE);
            method.setAccessible(true);
            method.invoke(swanEditText, Boolean.FALSE);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e2) {
            if (d.a.h0.a.a0.b.a.f41079h) {
                e2.printStackTrace();
            }
        }
    }

    public final void s0(@Nullable SwanEditText swanEditText) {
        SwanAppActivity activity = d.a.h0.a.z0.f.V().getActivity();
        if (activity == null) {
            d.a.h0.a.c0.c.l("Component-Input", "activity is null when close input");
            return;
        }
        w.a(activity, activity.getWindow().getDecorView().getWindowToken());
        if (swanEditText == null) {
            return;
        }
        swanEditText.setOnFocusChangeListener(null);
        d.a.h0.a.c0.c.g("Component-Input", "remove input");
        if (C().a()) {
            d.a.h0.a.c0.c.g("Component-Input", "remove input success");
        } else {
            d.a.h0.a.c0.c.l("Component-Input", "remove input fail");
        }
        d.a.h0.a.t0.b.d().b();
    }

    public final void t0() {
        s0(d.a.h0.a.t0.b.d().c());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.h0.a.a0.b.a
    @NonNull
    /* renamed from: u0 */
    public SwanEditText v(@NonNull Context context) {
        t0();
        return d.a.h0.a.t0.b.d().a(context);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.h0.a.a0.b.a
    /* renamed from: v0 */
    public void B(@NonNull SwanEditText swanEditText) {
        super.B(swanEditText);
        d.a.h0.a.a0.c.f.b bVar = (d.a.h0.a.a0.c.f.b) n();
        swanEditText.setText(bVar.x);
        int i2 = 1;
        swanEditText.setSingleLine(true);
        swanEditText.setTag(bVar.f41095i);
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
                i2 = 2;
            } else if (c2 != 1) {
                i2 = 0;
            }
            this.k = new d.a.h0.a.t0.f.b(this.f41112i, swanEditText, i2, bVar.G);
            this.k.e(new b(swanEditText, bVar, new C0564a(swanEditText)));
            this.k.f();
        }
        if (bVar.M) {
            swanEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.h0.a.a0.a.c.a
    /* renamed from: w0 */
    public void V(@NonNull SwanEditText swanEditText, @NonNull d.a.h0.a.a0.c.f.b bVar, @NonNull d.a.h0.a.a0.f.b bVar2) {
        boolean t = t();
        if (t) {
            swanEditText.removeTextChangedListener(d.a.h0.a.t0.b.d().e());
        }
        super.d0(swanEditText, bVar, bVar2);
        if (t) {
            swanEditText.addTextChangedListener(d.a.h0.a.t0.b.d().e());
        } else {
            D0(swanEditText, bVar, this.f41112i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.h0.a.a0.a.d.a
    /* renamed from: x0 */
    public void T(@NonNull SwanEditText swanEditText, @NonNull d.a.h0.a.a0.c.f.b bVar) {
        if (d.a.h0.a.a0.b.a.f41079h) {
            Log.d("Component-Input", "renderPadding");
        }
        swanEditText.setPadding(0, -6, 0, 0);
    }

    @Override // d.a.h0.a.a0.b.a
    public void y(boolean z) {
        super.y(z);
        if (!z) {
            d.a.h0.a.a0.g.a.a("Component-Input", "attach fail");
        }
        SwanEditText swanEditText = (SwanEditText) q();
        if (swanEditText == null) {
            d.a.h0.a.a0.g.a.a("Component-Input", "onAttached with null editText");
            swanEditText = d.a.h0.a.t0.b.d().c();
        }
        swanEditText.setFocusable(true);
        swanEditText.setFocusableInTouchMode(true);
        swanEditText.requestFocus();
        if (TextUtils.equals(((d.a.h0.a.a0.c.f.b) n()).O, "text")) {
            InputMethodManager inputMethodManager = (InputMethodManager) this.f41112i.getSystemService("input_method");
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
    @Override // d.a.h0.a.a0.a.c.a
    /* renamed from: y0 */
    public void W(@NonNull SwanEditText swanEditText, @NonNull d.a.h0.a.a0.c.f.b bVar) {
        if (d.a.h0.a.a0.b.a.f41079h) {
            Log.d("Component-Input", "renderText");
        }
        if (t()) {
            super.W(swanEditText, bVar);
            try {
                swanEditText.setSelection(bVar.x.length());
            } catch (IndexOutOfBoundsException e2) {
                if (d.a.h0.a.a0.b.a.f41079h) {
                    e2.printStackTrace();
                }
                d.a.h0.a.a0.g.a.a("Component-Input", "value is invalid, out of max length");
            }
        } else if (TextUtils.equals(swanEditText.getText(), bVar.x)) {
        } else {
            d.a.h0.a.a0.g.a.a("Component-Input", "insert input: set text must before render");
            super.W(swanEditText, bVar);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.h0.a.a0.a.c.a
    /* renamed from: z0 */
    public void Y(@NonNull SwanEditText swanEditText, @NonNull d.a.h0.a.a0.c.f.b bVar) {
        if (d.a.h0.a.a0.b.a.f41079h) {
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
