package com.repackage;

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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.component.components.textarea.SwanEditText;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.zi2;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class qw1 extends nv1<SwanEditText, rw1> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SwanAppActivity i;
    public pz1 j;
    public zi2 k;
    public int l;

    /* loaded from: classes7.dex */
    public class a extends ed2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanEditText a;
        public final /* synthetic */ qw1 b;

        public a(qw1 qw1Var, SwanEditText swanEditText) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qw1Var, swanEditText};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = qw1Var;
            this.a = swanEditText;
        }

        @Override // com.repackage.ed2, com.repackage.fd2
        public void b() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.b.k == null) {
                return;
            }
            this.b.k.dismiss();
            this.b.p0(this.a);
        }

        @Override // com.repackage.ed2, com.repackage.fd2
        public boolean onKeyDown(int i, KeyEvent keyEvent) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, keyEvent)) == null) {
                if (i != 4 || this.b.k == null) {
                    return false;
                }
                this.b.k.dismiss();
                this.b.p0(this.a);
                return true;
            }
            return invokeIL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b implements zi2.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanEditText a;
        public final /* synthetic */ rw1 b;
        public final /* synthetic */ ed2 c;
        public final /* synthetic */ qw1 d;

        public b(qw1 qw1Var, SwanEditText swanEditText, rw1 rw1Var, ed2 ed2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qw1Var, swanEditText, rw1Var, ed2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = qw1Var;
            this.a = swanEditText;
            this.b = rw1Var;
            this.c = ed2Var;
        }

        @Override // com.repackage.zi2.d
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (wv1.h) {
                    Log.d("Component-Input", "numeric keyboard onKeyboardHide");
                }
                this.d.y0(this.a);
                this.d.i.F0(this.c);
            }
        }

        @Override // com.repackage.zi2.d
        public void b(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                if (wv1.h) {
                    Log.d("Component-Input", "numeric keyboard onKeyboardShow");
                }
                qw1 qw1Var = this.d;
                qw1Var.z0(qw1Var.i, this.a, this.b, i);
                this.d.i.t0(this.c);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements TextView.OnEditorActionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rw1 a;
        public final /* synthetic */ SwanEditText b;
        public final /* synthetic */ qw1 c;

        public c(qw1 qw1Var, rw1 rw1Var, SwanEditText swanEditText) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qw1Var, rw1Var, swanEditText};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = qw1Var;
            this.a = rw1Var;
            this.b = swanEditText;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, textView, i, keyEvent)) == null) {
                vi2.d(ui2.d().c(), this.c.l);
                if (this.a.M) {
                    return true;
                }
                this.b.clearFocus();
                return false;
            }
            return invokeLIL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class d implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanEditText a;
        public final /* synthetic */ qw1 b;

        public d(qw1 qw1Var, SwanEditText swanEditText) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qw1Var, swanEditText};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = qw1Var;
            this.a = swanEditText;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) || i2 == i3) {
                return;
            }
            vi2.c((rw1) this.b.n(), this.a, i2 > i3 ? '\b' : charSequence.charAt((i + i3) - 1));
        }
    }

    /* loaded from: classes7.dex */
    public class e implements View.OnFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rw1 a;
        public final /* synthetic */ SwanEditText b;
        public final /* synthetic */ qw1 c;

        public e(qw1 qw1Var, rw1 rw1Var, SwanEditText swanEditText) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qw1Var, rw1Var, swanEditText};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = qw1Var;
            this.a = rw1Var;
            this.b = swanEditText;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, view2, z) == null) {
                if (wv1.h) {
                    Log.d("Component-Input", "onFocusChange:" + z);
                }
                if (z) {
                    return;
                }
                hx1.i("Component-Input", "send blur callback");
                if (!TextUtils.equals("text", this.a.L) && this.c.k != null) {
                    this.c.k.dismiss();
                }
                vi2.b(this.b, this.c.l);
                this.c.p0(this.b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements ub3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanEditText a;
        public final /* synthetic */ SwanAppActivity b;
        public final /* synthetic */ rw1 c;
        public final /* synthetic */ View d;
        public final /* synthetic */ qw1 e;

        public f(qw1 qw1Var, SwanEditText swanEditText, SwanAppActivity swanAppActivity, rw1 rw1Var, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qw1Var, swanEditText, swanAppActivity, rw1Var, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = qw1Var;
            this.a = swanEditText;
            this.b = swanAppActivity;
            this.c = rw1Var;
            this.d = view2;
        }

        @Override // com.repackage.ub3
        public void a(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i) == null) {
                this.e.y0(this.a);
                wb3.i().k(this.d);
            }
        }

        @Override // com.repackage.ub3
        public void b(String str, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i) == null) && this.a.hasFocus()) {
                this.e.z0(this.b, this.a, this.c, i);
            }
        }

        @Override // com.repackage.ub3
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface g {
        void a(String str, JSONObject jSONObject);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qw1(@Nullable Context context, @NonNull rw1 rw1Var, @NonNull SwanAppActivity swanAppActivity, @NonNull pz1 pz1Var, @NonNull g gVar) {
        super(context, rw1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, rw1Var, swanAppActivity, pz1Var, gVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (ov1) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = swanAppActivity;
        this.j = pz1Var;
        vi2.a(gVar);
    }

    public final void A0(SwanEditText swanEditText, rw1 rw1Var, SwanAppActivity swanAppActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, swanEditText, rw1Var, swanAppActivity) == null) {
            swanEditText.setOnEditorActionListener(new c(this, rw1Var, swanEditText));
            d dVar = new d(this, swanEditText);
            swanEditText.setOnFocusChangeListener(new e(this, rw1Var, swanEditText));
            if (TextUtils.equals("text", rw1Var.L)) {
                View decorView = swanAppActivity.getWindow().getDecorView();
                wb3.i().l(decorView, rw1Var.b, new f(this, swanEditText, swanAppActivity, rw1Var, decorView));
            }
            ui2.d().f(dVar);
            swanEditText.addTextChangedListener(dVar);
        }
    }

    public final void B0(SwanEditText swanEditText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, swanEditText) == null) {
            try {
                Method method = SwanEditText.class.getMethod("setShowSoftInputOnFocus", Boolean.TYPE);
                method.setAccessible(true);
                method.invoke(swanEditText, Boolean.FALSE);
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e2) {
                if (wv1.h) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public final void p0(@Nullable SwanEditText swanEditText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, swanEditText) == null) {
            SwanAppActivity activity = ul2.U().getActivity();
            if (activity == null) {
                hx1.o("Component-Input", "activity is null when close input");
                return;
            }
            id3.a(activity, activity.getWindow().getDecorView().getWindowToken());
            if (swanEditText == null) {
                return;
            }
            swanEditText.setOnFocusChangeListener(null);
            hx1.i("Component-Input", "remove input");
            if (B().a()) {
                hx1.i("Component-Input", "remove input success");
            } else {
                hx1.o("Component-Input", "remove input fail");
            }
            ui2.d().b();
        }
    }

    public final void q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            p0(ui2.d().c());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.wv1
    @NonNull
    /* renamed from: r0 */
    public SwanEditText v(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, context)) == null) {
            q0();
            return ui2.d().a(context);
        }
        return (SwanEditText) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.wv1
    /* renamed from: s0 */
    public void A(@NonNull SwanEditText swanEditText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, swanEditText) == null) {
            super.A(swanEditText);
            rw1 rw1Var = (rw1) n();
            swanEditText.setText(rw1Var.t);
            int i = 1;
            swanEditText.setSingleLine(true);
            swanEditText.setTag(rw1Var.e);
            if (!TextUtils.equals("text", rw1Var.L)) {
                String str = rw1Var.L;
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
                this.k = new zi2(this.i, swanEditText, i, rw1Var.D);
                this.k.e(new b(this, swanEditText, rw1Var, new a(this, swanEditText)));
                this.k.f();
            }
            if (rw1Var.J) {
                swanEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.nv1
    /* renamed from: t0 */
    public void a0(@NonNull SwanEditText swanEditText, @NonNull rw1 rw1Var, @NonNull zw1 zw1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048591, this, swanEditText, rw1Var, zw1Var) == null) {
            boolean t = t();
            if (t) {
                swanEditText.removeTextChangedListener(ui2.d().e());
            }
            super.T(swanEditText, rw1Var, zw1Var);
            if (t) {
                swanEditText.addTextChangedListener(ui2.d().e());
            } else {
                A0(swanEditText, rw1Var, this.i);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.uv1
    /* renamed from: u0 */
    public void R(@NonNull SwanEditText swanEditText, @NonNull rw1 rw1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, swanEditText, rw1Var) == null) {
            if (wv1.h) {
                Log.d("Component-Input", "renderPadding");
            }
            swanEditText.setPadding(0, -6, 0, 0);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.sv1
    /* renamed from: v0 */
    public void U(@NonNull SwanEditText swanEditText, @NonNull rw1 rw1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, swanEditText, rw1Var) == null) {
            if (wv1.h) {
                Log.d("Component-Input", "renderText");
            }
            if (t()) {
                super.U(swanEditText, rw1Var);
                try {
                    swanEditText.setSelection(rw1Var.t.length());
                } catch (IndexOutOfBoundsException e2) {
                    if (wv1.h) {
                        e2.printStackTrace();
                    }
                    ax1.a("Component-Input", "value is invalid, out of max length");
                }
            } else if (TextUtils.equals(swanEditText.getText(), rw1Var.t)) {
            } else {
                ax1.a("Component-Input", "insert input: set text must before render");
                super.U(swanEditText, rw1Var);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.sv1
    /* renamed from: w0 */
    public void W(@NonNull SwanEditText swanEditText, @NonNull rw1 rw1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048595, this, swanEditText, rw1Var) == null) {
            if (wv1.h) {
                Log.d("Component-Input", "renderTextStyleFontWeight");
            }
            String str = rw1Var.A;
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
                super.W(swanEditText, rw1Var);
            } else {
                swanEditText.setTypeface(Typeface.SANS_SERIF, 3);
            }
        }
    }

    @Override // com.repackage.wv1
    public void x(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            super.x(z);
            if (!z) {
                ax1.a("Component-Input", "attach fail");
            }
            SwanEditText swanEditText = (SwanEditText) q();
            if (swanEditText == null) {
                ax1.a("Component-Input", "onAttached with null editText");
                swanEditText = ui2.d().c();
            }
            swanEditText.setFocusable(true);
            swanEditText.setFocusableInTouchMode(true);
            swanEditText.requestFocus();
            if (TextUtils.equals(((rw1) n()).L, "text")) {
                InputMethodManager inputMethodManager = (InputMethodManager) this.i.getSystemService("input_method");
                if (inputMethodManager != null) {
                    inputMethodManager.showSoftInput(swanEditText, 0);
                }
            } else if (Build.VERSION.SDK_INT >= 21) {
                swanEditText.setShowSoftInputOnFocus(false);
            } else {
                B0(swanEditText);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.sv1
    /* renamed from: x0 */
    public void X(@NonNull SwanEditText swanEditText, @NonNull rw1 rw1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, swanEditText, rw1Var) == null) {
            Y(swanEditText, rw1Var, 16);
        }
    }

    public final void y0(@NonNull SwanEditText swanEditText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, swanEditText) == null) {
            if (wv1.h) {
                Log.d("Component-Input", "scrollBackWhenKeyboardHide, mKeyboardHeight：" + this.l);
            }
            if (this.l != 0) {
                this.l = 0;
                swanEditText.clearFocus();
                if (this.j.x3().getScrollY() > 0) {
                    this.j.x3().setScrollY(0);
                }
            }
        }
    }

    @Override // com.repackage.wv1
    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            super.z();
        }
    }

    public final void z0(@NonNull SwanAppActivity swanAppActivity, @NonNull SwanEditText swanEditText, rw1 rw1Var, int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(1048600, this, swanAppActivity, swanEditText, rw1Var, i) == null) {
            om1 i3 = ul2.U().i();
            if (wv1.h) {
                Log.d("Component-Input", "scrollUpWhenKeyboardShow, mKeyboardHeight：" + this.l + "，keyboardHeight : " + i);
            }
            if (this.l == i || i3 == null) {
                return;
            }
            this.l = i;
            vi2.f(swanEditText, i);
            if (rw1Var.N) {
                if (rw1Var.h == null) {
                    rw1Var.h = new nq2();
                }
                int webViewScrollY = i3.getWebViewScrollY();
                int height = swanEditText.getHeight();
                if (height == 0) {
                    height = rw1Var.h.c();
                }
                int height2 = ((this.j.x3().getHeight() - rw1Var.h.e()) - height) + webViewScrollY + yd3.k(swanAppActivity);
                int i4 = rw1Var.E;
                if (i4 > height2) {
                    i4 = height2;
                }
                int i5 = height2 - i;
                int scrollY = this.j.x3().getScrollY();
                if (i5 < 0) {
                    i2 = i4 - i5;
                } else {
                    if (i4 > i5) {
                        scrollY = i4 - i5;
                    }
                    i2 = scrollY;
                }
                this.j.x3().setScrollY(i2);
            }
        }
    }
}
