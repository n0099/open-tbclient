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
import com.repackage.aj2;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class rw1 extends ov1<SwanEditText, sw1> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SwanAppActivity i;
    public qz1 j;
    public aj2 k;
    public int l;

    /* loaded from: classes7.dex */
    public class a extends fd2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanEditText a;
        public final /* synthetic */ rw1 b;

        public a(rw1 rw1Var, SwanEditText swanEditText) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rw1Var, swanEditText};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = rw1Var;
            this.a = swanEditText;
        }

        @Override // com.repackage.fd2, com.repackage.gd2
        public void b() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.b.k == null) {
                return;
            }
            this.b.k.dismiss();
            this.b.p0(this.a);
        }

        @Override // com.repackage.fd2, com.repackage.gd2
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
    public class b implements aj2.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanEditText a;
        public final /* synthetic */ sw1 b;
        public final /* synthetic */ fd2 c;
        public final /* synthetic */ rw1 d;

        public b(rw1 rw1Var, SwanEditText swanEditText, sw1 sw1Var, fd2 fd2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rw1Var, swanEditText, sw1Var, fd2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = rw1Var;
            this.a = swanEditText;
            this.b = sw1Var;
            this.c = fd2Var;
        }

        @Override // com.repackage.aj2.d
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (xv1.h) {
                    Log.d("Component-Input", "numeric keyboard onKeyboardHide");
                }
                this.d.y0(this.a);
                this.d.i.F0(this.c);
            }
        }

        @Override // com.repackage.aj2.d
        public void b(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                if (xv1.h) {
                    Log.d("Component-Input", "numeric keyboard onKeyboardShow");
                }
                rw1 rw1Var = this.d;
                rw1Var.z0(rw1Var.i, this.a, this.b, i);
                this.d.i.t0(this.c);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements TextView.OnEditorActionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sw1 a;
        public final /* synthetic */ SwanEditText b;
        public final /* synthetic */ rw1 c;

        public c(rw1 rw1Var, sw1 sw1Var, SwanEditText swanEditText) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rw1Var, sw1Var, swanEditText};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = rw1Var;
            this.a = sw1Var;
            this.b = swanEditText;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, textView, i, keyEvent)) == null) {
                wi2.d(vi2.d().c(), this.c.l);
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
        public final /* synthetic */ rw1 b;

        public d(rw1 rw1Var, SwanEditText swanEditText) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rw1Var, swanEditText};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = rw1Var;
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
            wi2.c((sw1) this.b.n(), this.a, i2 > i3 ? '\b' : charSequence.charAt((i + i3) - 1));
        }
    }

    /* loaded from: classes7.dex */
    public class e implements View.OnFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sw1 a;
        public final /* synthetic */ SwanEditText b;
        public final /* synthetic */ rw1 c;

        public e(rw1 rw1Var, sw1 sw1Var, SwanEditText swanEditText) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rw1Var, sw1Var, swanEditText};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = rw1Var;
            this.a = sw1Var;
            this.b = swanEditText;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, view2, z) == null) {
                if (xv1.h) {
                    Log.d("Component-Input", "onFocusChange:" + z);
                }
                if (z) {
                    return;
                }
                ix1.i("Component-Input", "send blur callback");
                if (!TextUtils.equals("text", this.a.L) && this.c.k != null) {
                    this.c.k.dismiss();
                }
                wi2.b(this.b, this.c.l);
                this.c.p0(this.b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements vb3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanEditText a;
        public final /* synthetic */ SwanAppActivity b;
        public final /* synthetic */ sw1 c;
        public final /* synthetic */ View d;
        public final /* synthetic */ rw1 e;

        public f(rw1 rw1Var, SwanEditText swanEditText, SwanAppActivity swanAppActivity, sw1 sw1Var, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rw1Var, swanEditText, swanAppActivity, sw1Var, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = rw1Var;
            this.a = swanEditText;
            this.b = swanAppActivity;
            this.c = sw1Var;
            this.d = view2;
        }

        @Override // com.repackage.vb3
        public void a(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i) == null) {
                this.e.y0(this.a);
                xb3.i().k(this.d);
            }
        }

        @Override // com.repackage.vb3
        public void b(String str, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i) == null) && this.a.hasFocus()) {
                this.e.z0(this.b, this.a, this.c, i);
            }
        }

        @Override // com.repackage.vb3
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
    public rw1(@Nullable Context context, @NonNull sw1 sw1Var, @NonNull SwanAppActivity swanAppActivity, @NonNull qz1 qz1Var, @NonNull g gVar) {
        super(context, sw1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, sw1Var, swanAppActivity, qz1Var, gVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (pv1) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = swanAppActivity;
        this.j = qz1Var;
        wi2.a(gVar);
    }

    public final void A0(SwanEditText swanEditText, sw1 sw1Var, SwanAppActivity swanAppActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, swanEditText, sw1Var, swanAppActivity) == null) {
            swanEditText.setOnEditorActionListener(new c(this, sw1Var, swanEditText));
            d dVar = new d(this, swanEditText);
            swanEditText.setOnFocusChangeListener(new e(this, sw1Var, swanEditText));
            if (TextUtils.equals("text", sw1Var.L)) {
                View decorView = swanAppActivity.getWindow().getDecorView();
                xb3.i().l(decorView, sw1Var.b, new f(this, swanEditText, swanAppActivity, sw1Var, decorView));
            }
            vi2.d().f(dVar);
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
                if (xv1.h) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public final void p0(@Nullable SwanEditText swanEditText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, swanEditText) == null) {
            SwanAppActivity activity = vl2.U().getActivity();
            if (activity == null) {
                ix1.o("Component-Input", "activity is null when close input");
                return;
            }
            jd3.a(activity, activity.getWindow().getDecorView().getWindowToken());
            if (swanEditText == null) {
                return;
            }
            swanEditText.setOnFocusChangeListener(null);
            ix1.i("Component-Input", "remove input");
            if (B().a()) {
                ix1.i("Component-Input", "remove input success");
            } else {
                ix1.o("Component-Input", "remove input fail");
            }
            vi2.d().b();
        }
    }

    public final void q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            p0(vi2.d().c());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.xv1
    @NonNull
    /* renamed from: r0 */
    public SwanEditText v(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, context)) == null) {
            q0();
            return vi2.d().a(context);
        }
        return (SwanEditText) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.xv1
    /* renamed from: s0 */
    public void A(@NonNull SwanEditText swanEditText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, swanEditText) == null) {
            super.A(swanEditText);
            sw1 sw1Var = (sw1) n();
            swanEditText.setText(sw1Var.t);
            int i = 1;
            swanEditText.setSingleLine(true);
            swanEditText.setTag(sw1Var.e);
            if (!TextUtils.equals("text", sw1Var.L)) {
                String str = sw1Var.L;
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
                this.k = new aj2(this.i, swanEditText, i, sw1Var.D);
                this.k.e(new b(this, swanEditText, sw1Var, new a(this, swanEditText)));
                this.k.f();
            }
            if (sw1Var.J) {
                swanEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.ov1
    /* renamed from: t0 */
    public void a0(@NonNull SwanEditText swanEditText, @NonNull sw1 sw1Var, @NonNull ax1 ax1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048591, this, swanEditText, sw1Var, ax1Var) == null) {
            boolean t = t();
            if (t) {
                swanEditText.removeTextChangedListener(vi2.d().e());
            }
            super.T(swanEditText, sw1Var, ax1Var);
            if (t) {
                swanEditText.addTextChangedListener(vi2.d().e());
            } else {
                A0(swanEditText, sw1Var, this.i);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.vv1
    /* renamed from: u0 */
    public void R(@NonNull SwanEditText swanEditText, @NonNull sw1 sw1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, swanEditText, sw1Var) == null) {
            if (xv1.h) {
                Log.d("Component-Input", "renderPadding");
            }
            swanEditText.setPadding(0, -6, 0, 0);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.tv1
    /* renamed from: v0 */
    public void U(@NonNull SwanEditText swanEditText, @NonNull sw1 sw1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, swanEditText, sw1Var) == null) {
            if (xv1.h) {
                Log.d("Component-Input", "renderText");
            }
            if (t()) {
                super.U(swanEditText, sw1Var);
                try {
                    swanEditText.setSelection(sw1Var.t.length());
                } catch (IndexOutOfBoundsException e2) {
                    if (xv1.h) {
                        e2.printStackTrace();
                    }
                    bx1.a("Component-Input", "value is invalid, out of max length");
                }
            } else if (TextUtils.equals(swanEditText.getText(), sw1Var.t)) {
            } else {
                bx1.a("Component-Input", "insert input: set text must before render");
                super.U(swanEditText, sw1Var);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.tv1
    /* renamed from: w0 */
    public void W(@NonNull SwanEditText swanEditText, @NonNull sw1 sw1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048595, this, swanEditText, sw1Var) == null) {
            if (xv1.h) {
                Log.d("Component-Input", "renderTextStyleFontWeight");
            }
            String str = sw1Var.A;
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
                super.W(swanEditText, sw1Var);
            } else {
                swanEditText.setTypeface(Typeface.SANS_SERIF, 3);
            }
        }
    }

    @Override // com.repackage.xv1
    public void x(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            super.x(z);
            if (!z) {
                bx1.a("Component-Input", "attach fail");
            }
            SwanEditText swanEditText = (SwanEditText) q();
            if (swanEditText == null) {
                bx1.a("Component-Input", "onAttached with null editText");
                swanEditText = vi2.d().c();
            }
            swanEditText.setFocusable(true);
            swanEditText.setFocusableInTouchMode(true);
            swanEditText.requestFocus();
            if (TextUtils.equals(((sw1) n()).L, "text")) {
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
    @Override // com.repackage.tv1
    /* renamed from: x0 */
    public void X(@NonNull SwanEditText swanEditText, @NonNull sw1 sw1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, swanEditText, sw1Var) == null) {
            Y(swanEditText, sw1Var, 16);
        }
    }

    public final void y0(@NonNull SwanEditText swanEditText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, swanEditText) == null) {
            if (xv1.h) {
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

    @Override // com.repackage.xv1
    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            super.z();
        }
    }

    public final void z0(@NonNull SwanAppActivity swanAppActivity, @NonNull SwanEditText swanEditText, sw1 sw1Var, int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(1048600, this, swanAppActivity, swanEditText, sw1Var, i) == null) {
            pm1 i3 = vl2.U().i();
            if (xv1.h) {
                Log.d("Component-Input", "scrollUpWhenKeyboardShow, mKeyboardHeight：" + this.l + "，keyboardHeight : " + i);
            }
            if (this.l == i || i3 == null) {
                return;
            }
            this.l = i;
            wi2.f(swanEditText, i);
            if (sw1Var.N) {
                if (sw1Var.h == null) {
                    sw1Var.h = new oq2();
                }
                int webViewScrollY = i3.getWebViewScrollY();
                int height = swanEditText.getHeight();
                if (height == 0) {
                    height = sw1Var.h.c();
                }
                int height2 = ((this.j.x3().getHeight() - sw1Var.h.e()) - height) + webViewScrollY + zd3.k(swanAppActivity);
                int i4 = sw1Var.E;
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
