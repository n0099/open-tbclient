package d.a.i0.a.c0.c.f;

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
import d.a.i0.a.v2.n0;
import d.a.i0.a.v2.x;
import d.a.i0.a.z0.f.b;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class a extends d.a.i0.a.c0.a.a.a<SwanEditText, d.a.i0.a.c0.c.f.b> {

    /* renamed from: i  reason: collision with root package name */
    public SwanAppActivity f40692i;
    public d.a.i0.a.h0.g.f j;
    public d.a.i0.a.z0.f.b k;
    public int l;

    /* renamed from: d.a.i0.a.c0.c.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0562a extends d.a.i0.a.t0.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SwanEditText f40693a;

        public C0562a(SwanEditText swanEditText) {
            this.f40693a = swanEditText;
        }

        @Override // d.a.i0.a.t0.a, d.a.i0.a.t0.b
        public void b() {
            if (a.this.k != null) {
                a.this.k.dismiss();
                a.this.r0(this.f40693a);
            }
        }

        @Override // d.a.i0.a.t0.a, d.a.i0.a.t0.b
        public boolean onKeyDown(int i2, KeyEvent keyEvent) {
            if (i2 != 4 || a.this.k == null) {
                return false;
            }
            a.this.k.dismiss();
            a.this.r0(this.f40693a);
            return true;
        }
    }

    /* loaded from: classes2.dex */
    public class b implements b.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SwanEditText f40695a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.c0.c.f.b f40696b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.t0.a f40697c;

        public b(SwanEditText swanEditText, d.a.i0.a.c0.c.f.b bVar, d.a.i0.a.t0.a aVar) {
            this.f40695a = swanEditText;
            this.f40696b = bVar;
            this.f40697c = aVar;
        }

        @Override // d.a.i0.a.z0.f.b.d
        public void a() {
            if (d.a.i0.a.c0.b.a.f40658h) {
                Log.d("Component-Input", "numeric keyboard onKeyboardHide");
            }
            a.this.A0(this.f40695a);
            a.this.f40692i.unregisterCallback(this.f40697c);
        }

        @Override // d.a.i0.a.z0.f.b.d
        public void b(int i2) {
            if (d.a.i0.a.c0.b.a.f40658h) {
                Log.d("Component-Input", "numeric keyboard onKeyboardShow");
            }
            a aVar = a.this;
            aVar.B0(aVar.f40692i, this.f40695a, this.f40696b, i2);
            a.this.f40692i.registerCallback(this.f40697c);
        }
    }

    /* loaded from: classes2.dex */
    public class c implements TextView.OnEditorActionListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.c0.c.f.b f40699a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SwanEditText f40700b;

        public c(d.a.i0.a.c0.c.f.b bVar, SwanEditText swanEditText) {
            this.f40699a = bVar;
            this.f40700b = swanEditText;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
            d.a.i0.a.z0.c.d(d.a.i0.a.z0.b.d().c(), a.this.l);
            if (this.f40699a.P) {
                return true;
            }
            this.f40700b.clearFocus();
            return false;
        }
    }

    /* loaded from: classes2.dex */
    public class d implements TextWatcher {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanEditText f40702e;

        public d(a aVar, SwanEditText swanEditText) {
            this.f40702e = swanEditText;
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
                d.a.i0.a.z0.c.c(this.f40702e, i3 > i4 ? '\b' : charSequence.charAt((i2 + i4) - 1));
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e implements View.OnFocusChangeListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.c0.c.f.b f40703e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SwanEditText f40704f;

        public e(d.a.i0.a.c0.c.f.b bVar, SwanEditText swanEditText) {
            this.f40703e = bVar;
            this.f40704f = swanEditText;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (d.a.i0.a.c0.b.a.f40658h) {
                Log.d("Component-Input", "onFocusChange:" + z);
            }
            if (z) {
                return;
            }
            d.a.i0.a.e0.d.g("Component-Input", "send blur callback");
            if (!TextUtils.equals("text", this.f40703e.O) && a.this.k != null) {
                a.this.k.dismiss();
            }
            d.a.i0.a.z0.c.b(this.f40704f, a.this.l);
            a.this.r0(this.f40704f);
        }
    }

    /* loaded from: classes2.dex */
    public class f implements d.a.i0.a.p2.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SwanEditText f40706a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SwanAppActivity f40707b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.c0.c.f.b f40708c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ View f40709d;

        public f(SwanEditText swanEditText, SwanAppActivity swanAppActivity, d.a.i0.a.c0.c.f.b bVar, View view) {
            this.f40706a = swanEditText;
            this.f40707b = swanAppActivity;
            this.f40708c = bVar;
            this.f40709d = view;
        }

        @Override // d.a.i0.a.p2.a
        public void a(String str, int i2) {
            a.this.A0(this.f40706a);
            d.a.i0.a.p2.c.i().k(this.f40709d);
        }

        @Override // d.a.i0.a.p2.a
        public void b(String str, int i2) {
            if (this.f40706a.hasFocus()) {
                a.this.B0(this.f40707b, this.f40706a, this.f40708c, i2);
            }
        }

        @Override // d.a.i0.a.p2.a
        public void c(String str) {
        }
    }

    /* loaded from: classes2.dex */
    public interface g {
        void a(String str, JSONObject jSONObject);
    }

    public a(@Nullable Context context, @NonNull d.a.i0.a.c0.c.f.b bVar, @NonNull SwanAppActivity swanAppActivity, @NonNull d.a.i0.a.h0.g.f fVar, @NonNull g gVar) {
        super(context, bVar);
        this.f40692i = swanAppActivity;
        this.j = fVar;
        d.a.i0.a.z0.c.a(gVar);
    }

    @Override // d.a.i0.a.c0.b.a
    public void A() {
        super.A();
    }

    public final void A0(@NonNull SwanEditText swanEditText) {
        if (d.a.i0.a.c0.b.a.f40658h) {
            Log.d("Component-Input", "scrollBackWhenKeyboardHide, mKeyboardHeight：" + this.l);
        }
        if (this.l != 0) {
            this.l = 0;
            swanEditText.clearFocus();
            if (this.j.k3().getScrollY() > 0) {
                this.j.k3().setScrollY(0);
            }
        }
    }

    public final void B0(@NonNull SwanAppActivity swanAppActivity, @NonNull SwanEditText swanEditText, d.a.i0.a.c0.c.f.b bVar, int i2) {
        int i3;
        d.a.i0.a.p.e.c h2 = d.a.i0.a.g1.f.V().h();
        if (d.a.i0.a.c0.b.a.f40658h) {
            Log.d("Component-Input", "scrollUpWhenKeyboardShow, mKeyboardHeight：" + this.l + "，keyboardHeight : " + i2);
        }
        if (this.l == i2 || h2 == null) {
            return;
        }
        this.l = i2;
        d.a.i0.a.z0.c.f(swanEditText, i2);
        if (bVar.Q) {
            if (bVar.l == null) {
                bVar.l = new d.a.i0.a.l1.e.a.a();
            }
            int webViewScrollY = h2.getWebViewScrollY();
            int height = swanEditText.getHeight();
            if (height == 0) {
                height = bVar.l.d();
            }
            int height2 = ((this.j.k3().getHeight() - bVar.l.f()) - height) + webViewScrollY + n0.k(swanAppActivity);
            int i4 = bVar.H;
            if (i4 > height2) {
                i4 = height2;
            }
            int i5 = height2 - i2;
            int scrollY = this.j.k3().getScrollY();
            if (i5 < 0) {
                i3 = i4 - i5;
            } else {
                if (i4 > i5) {
                    scrollY = i4 - i5;
                }
                i3 = scrollY;
            }
            this.j.k3().setScrollY(i3);
        }
    }

    public final void C0(SwanEditText swanEditText, d.a.i0.a.c0.c.f.b bVar, SwanAppActivity swanAppActivity) {
        swanEditText.setOnEditorActionListener(new c(bVar, swanEditText));
        d dVar = new d(this, swanEditText);
        swanEditText.setOnFocusChangeListener(new e(bVar, swanEditText));
        if (TextUtils.equals("text", bVar.O)) {
            View decorView = swanAppActivity.getWindow().getDecorView();
            d.a.i0.a.p2.c.i().l(decorView, bVar.f40671f, new f(swanEditText, swanAppActivity, bVar, decorView));
        }
        d.a.i0.a.z0.b.d().f(dVar);
        swanEditText.addTextChangedListener(dVar);
    }

    public final void D0(SwanEditText swanEditText) {
        try {
            Method method = SwanEditText.class.getMethod("setShowSoftInputOnFocus", Boolean.TYPE);
            method.setAccessible(true);
            method.invoke(swanEditText, Boolean.FALSE);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e2) {
            if (d.a.i0.a.c0.b.a.f40658h) {
                e2.printStackTrace();
            }
        }
    }

    public final void r0(@Nullable SwanEditText swanEditText) {
        SwanAppActivity activity = d.a.i0.a.g1.f.V().getActivity();
        if (activity == null) {
            d.a.i0.a.e0.d.l("Component-Input", "activity is null when close input");
            return;
        }
        x.a(activity, activity.getWindow().getDecorView().getWindowToken());
        if (swanEditText == null) {
            return;
        }
        swanEditText.setOnFocusChangeListener(null);
        d.a.i0.a.e0.d.g("Component-Input", "remove input");
        if (C().a()) {
            d.a.i0.a.e0.d.g("Component-Input", "remove input success");
        } else {
            d.a.i0.a.e0.d.l("Component-Input", "remove input fail");
        }
        d.a.i0.a.z0.b.d().b();
    }

    public final void s0() {
        r0(d.a.i0.a.z0.b.d().c());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i0.a.c0.b.a
    @NonNull
    /* renamed from: t0 */
    public SwanEditText v(@NonNull Context context) {
        s0();
        return d.a.i0.a.z0.b.d().a(context);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i0.a.c0.b.a
    /* renamed from: u0 */
    public void B(@NonNull SwanEditText swanEditText) {
        super.B(swanEditText);
        d.a.i0.a.c0.c.f.b bVar = (d.a.i0.a.c0.c.f.b) n();
        swanEditText.setText(bVar.x);
        int i2 = 1;
        swanEditText.setSingleLine(true);
        swanEditText.setTag(bVar.f40674i);
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
            this.k = new d.a.i0.a.z0.f.b(this.f40692i, swanEditText, i2, bVar.G);
            this.k.e(new b(swanEditText, bVar, new C0562a(swanEditText)));
            this.k.f();
        }
        if (bVar.M) {
            swanEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i0.a.c0.a.c.b
    /* renamed from: v0 */
    public void V(@NonNull SwanEditText swanEditText, @NonNull d.a.i0.a.c0.c.f.b bVar, @NonNull d.a.i0.a.c0.f.b bVar2) {
        boolean t = t();
        if (t) {
            swanEditText.removeTextChangedListener(d.a.i0.a.z0.b.d().e());
        }
        super.c0(swanEditText, bVar, bVar2);
        if (t) {
            swanEditText.addTextChangedListener(d.a.i0.a.z0.b.d().e());
        } else {
            C0(swanEditText, bVar, this.f40692i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i0.a.c0.a.d.a
    /* renamed from: w0 */
    public void T(@NonNull SwanEditText swanEditText, @NonNull d.a.i0.a.c0.c.f.b bVar) {
        if (d.a.i0.a.c0.b.a.f40658h) {
            Log.d("Component-Input", "renderPadding");
        }
        swanEditText.setPadding(0, -6, 0, 0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i0.a.c0.a.c.b
    /* renamed from: x0 */
    public void W(@NonNull SwanEditText swanEditText, @NonNull d.a.i0.a.c0.c.f.b bVar) {
        if (d.a.i0.a.c0.b.a.f40658h) {
            Log.d("Component-Input", "renderText");
        }
        if (t()) {
            super.W(swanEditText, bVar);
            try {
                swanEditText.setSelection(bVar.x.length());
            } catch (IndexOutOfBoundsException e2) {
                if (d.a.i0.a.c0.b.a.f40658h) {
                    e2.printStackTrace();
                }
                d.a.i0.a.c0.g.a.a("Component-Input", "value is invalid, out of max length");
            }
        } else if (TextUtils.equals(swanEditText.getText(), bVar.x)) {
        } else {
            d.a.i0.a.c0.g.a.a("Component-Input", "insert input: set text must before render");
            super.W(swanEditText, bVar);
        }
    }

    @Override // d.a.i0.a.c0.b.a
    public void y(boolean z) {
        super.y(z);
        if (!z) {
            d.a.i0.a.c0.g.a.a("Component-Input", "attach fail");
        }
        SwanEditText swanEditText = (SwanEditText) q();
        if (swanEditText == null) {
            d.a.i0.a.c0.g.a.a("Component-Input", "onAttached with null editText");
            swanEditText = d.a.i0.a.z0.b.d().c();
        }
        swanEditText.setFocusable(true);
        swanEditText.setFocusableInTouchMode(true);
        swanEditText.requestFocus();
        if (TextUtils.equals(((d.a.i0.a.c0.c.f.b) n()).O, "text")) {
            InputMethodManager inputMethodManager = (InputMethodManager) this.f40692i.getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.showSoftInput(swanEditText, 0);
            }
        } else if (Build.VERSION.SDK_INT >= 21) {
            swanEditText.setShowSoftInputOnFocus(false);
        } else {
            D0(swanEditText);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i0.a.c0.a.c.b
    /* renamed from: y0 */
    public void Y(@NonNull SwanEditText swanEditText, @NonNull d.a.i0.a.c0.c.f.b bVar) {
        if (d.a.i0.a.c0.b.a.f40658h) {
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i0.a.c0.a.c.b
    /* renamed from: z0 */
    public void Z(@NonNull SwanEditText swanEditText, @NonNull d.a.i0.a.c0.c.f.b bVar) {
        a0(swanEditText, bVar, 16);
    }
}
