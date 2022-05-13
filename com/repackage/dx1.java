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
import com.repackage.mj2;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class dx1 extends aw1<SwanEditText, ex1> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SwanAppActivity i;
    public c02 j;
    public mj2 k;
    public int l;

    /* loaded from: classes5.dex */
    public class a extends rd2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanEditText a;
        public final /* synthetic */ dx1 b;

        public a(dx1 dx1Var, SwanEditText swanEditText) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dx1Var, swanEditText};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = dx1Var;
            this.a = swanEditText;
        }

        @Override // com.repackage.rd2, com.repackage.sd2
        public void b() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.b.k == null) {
                return;
            }
            this.b.k.dismiss();
            this.b.p0(this.a);
        }

        @Override // com.repackage.rd2, com.repackage.sd2
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

    /* loaded from: classes5.dex */
    public class b implements mj2.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanEditText a;
        public final /* synthetic */ ex1 b;
        public final /* synthetic */ rd2 c;
        public final /* synthetic */ dx1 d;

        public b(dx1 dx1Var, SwanEditText swanEditText, ex1 ex1Var, rd2 rd2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dx1Var, swanEditText, ex1Var, rd2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = dx1Var;
            this.a = swanEditText;
            this.b = ex1Var;
            this.c = rd2Var;
        }

        @Override // com.repackage.mj2.d
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (jw1.h) {
                    Log.d("Component-Input", "numeric keyboard onKeyboardHide");
                }
                this.d.y0(this.a);
                this.d.i.unregisterCallback(this.c);
            }
        }

        @Override // com.repackage.mj2.d
        public void b(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                if (jw1.h) {
                    Log.d("Component-Input", "numeric keyboard onKeyboardShow");
                }
                dx1 dx1Var = this.d;
                dx1Var.z0(dx1Var.i, this.a, this.b, i);
                this.d.i.registerCallback(this.c);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements TextView.OnEditorActionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ex1 a;
        public final /* synthetic */ SwanEditText b;
        public final /* synthetic */ dx1 c;

        public c(dx1 dx1Var, ex1 ex1Var, SwanEditText swanEditText) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dx1Var, ex1Var, swanEditText};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = dx1Var;
            this.a = ex1Var;
            this.b = swanEditText;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, textView, i, keyEvent)) == null) {
                ij2.d(hj2.d().c(), this.c.l);
                if (this.a.M) {
                    return true;
                }
                this.b.clearFocus();
                return false;
            }
            return invokeLIL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class d implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanEditText a;
        public final /* synthetic */ dx1 b;

        public d(dx1 dx1Var, SwanEditText swanEditText) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dx1Var, swanEditText};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = dx1Var;
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
            ij2.c((ex1) this.b.n(), this.a, i2 > i3 ? '\b' : charSequence.charAt((i + i3) - 1));
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ex1 a;
        public final /* synthetic */ SwanEditText b;
        public final /* synthetic */ dx1 c;

        public e(dx1 dx1Var, ex1 ex1Var, SwanEditText swanEditText) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dx1Var, ex1Var, swanEditText};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = dx1Var;
            this.a = ex1Var;
            this.b = swanEditText;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, view2, z) == null) {
                if (jw1.h) {
                    Log.d("Component-Input", "onFocusChange:" + z);
                }
                if (z) {
                    return;
                }
                ux1.i("Component-Input", "send blur callback");
                if (!TextUtils.equals("text", this.a.L) && this.c.k != null) {
                    this.c.k.dismiss();
                }
                ij2.b(this.b, this.c.l);
                this.c.p0(this.b);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements hc3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanEditText a;
        public final /* synthetic */ SwanAppActivity b;
        public final /* synthetic */ ex1 c;
        public final /* synthetic */ View d;
        public final /* synthetic */ dx1 e;

        public f(dx1 dx1Var, SwanEditText swanEditText, SwanAppActivity swanAppActivity, ex1 ex1Var, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dx1Var, swanEditText, swanAppActivity, ex1Var, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = dx1Var;
            this.a = swanEditText;
            this.b = swanAppActivity;
            this.c = ex1Var;
            this.d = view2;
        }

        @Override // com.repackage.hc3
        public void a(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i) == null) {
                this.e.y0(this.a);
                jc3.i().k(this.d);
            }
        }

        @Override // com.repackage.hc3
        public void b(String str, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i) == null) && this.a.hasFocus()) {
                this.e.z0(this.b, this.a, this.c, i);
            }
        }

        @Override // com.repackage.hc3
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface g {
        void a(String str, JSONObject jSONObject);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dx1(@Nullable Context context, @NonNull ex1 ex1Var, @NonNull SwanAppActivity swanAppActivity, @NonNull c02 c02Var, @NonNull g gVar) {
        super(context, ex1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, ex1Var, swanAppActivity, c02Var, gVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (bw1) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = swanAppActivity;
        this.j = c02Var;
        ij2.a(gVar);
    }

    public final void A0(SwanEditText swanEditText, ex1 ex1Var, SwanAppActivity swanAppActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, swanEditText, ex1Var, swanAppActivity) == null) {
            swanEditText.setOnEditorActionListener(new c(this, ex1Var, swanEditText));
            d dVar = new d(this, swanEditText);
            swanEditText.setOnFocusChangeListener(new e(this, ex1Var, swanEditText));
            if (TextUtils.equals("text", ex1Var.L)) {
                View decorView = swanAppActivity.getWindow().getDecorView();
                jc3.i().l(decorView, ex1Var.b, new f(this, swanEditText, swanAppActivity, ex1Var, decorView));
            }
            hj2.d().f(dVar);
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
                if (jw1.h) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public final void p0(@Nullable SwanEditText swanEditText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, swanEditText) == null) {
            SwanAppActivity activity = hm2.U().getActivity();
            if (activity == null) {
                ux1.o("Component-Input", "activity is null when close input");
                return;
            }
            vd3.a(activity, activity.getWindow().getDecorView().getWindowToken());
            if (swanEditText == null) {
                return;
            }
            swanEditText.setOnFocusChangeListener(null);
            ux1.i("Component-Input", "remove input");
            if (B().a()) {
                ux1.i("Component-Input", "remove input success");
            } else {
                ux1.o("Component-Input", "remove input fail");
            }
            hj2.d().b();
        }
    }

    public final void q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            p0(hj2.d().c());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.jw1
    @NonNull
    /* renamed from: r0 */
    public SwanEditText v(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, context)) == null) {
            q0();
            return hj2.d().a(context);
        }
        return (SwanEditText) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.jw1
    /* renamed from: s0 */
    public void A(@NonNull SwanEditText swanEditText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, swanEditText) == null) {
            super.A(swanEditText);
            ex1 ex1Var = (ex1) n();
            swanEditText.setText(ex1Var.t);
            int i = 1;
            swanEditText.setSingleLine(true);
            swanEditText.setTag(ex1Var.e);
            if (!TextUtils.equals("text", ex1Var.L)) {
                String str = ex1Var.L;
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
                this.k = new mj2(this.i, swanEditText, i, ex1Var.D);
                this.k.e(new b(this, swanEditText, ex1Var, new a(this, swanEditText)));
                this.k.f();
            }
            if (ex1Var.J) {
                swanEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.aw1
    /* renamed from: t0 */
    public void a0(@NonNull SwanEditText swanEditText, @NonNull ex1 ex1Var, @NonNull mx1 mx1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048591, this, swanEditText, ex1Var, mx1Var) == null) {
            boolean t = t();
            if (t) {
                swanEditText.removeTextChangedListener(hj2.d().e());
            }
            super.T(swanEditText, ex1Var, mx1Var);
            if (t) {
                swanEditText.addTextChangedListener(hj2.d().e());
            } else {
                A0(swanEditText, ex1Var, this.i);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.hw1
    /* renamed from: u0 */
    public void R(@NonNull SwanEditText swanEditText, @NonNull ex1 ex1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, swanEditText, ex1Var) == null) {
            if (jw1.h) {
                Log.d("Component-Input", "renderPadding");
            }
            swanEditText.setPadding(0, -6, 0, 0);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.fw1
    /* renamed from: v0 */
    public void U(@NonNull SwanEditText swanEditText, @NonNull ex1 ex1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, swanEditText, ex1Var) == null) {
            if (jw1.h) {
                Log.d("Component-Input", "renderText");
            }
            if (t()) {
                super.U(swanEditText, ex1Var);
                try {
                    swanEditText.setSelection(ex1Var.t.length());
                } catch (IndexOutOfBoundsException e2) {
                    if (jw1.h) {
                        e2.printStackTrace();
                    }
                    nx1.a("Component-Input", "value is invalid, out of max length");
                }
            } else if (TextUtils.equals(swanEditText.getText(), ex1Var.t)) {
            } else {
                nx1.a("Component-Input", "insert input: set text must before render");
                super.U(swanEditText, ex1Var);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.fw1
    /* renamed from: w0 */
    public void W(@NonNull SwanEditText swanEditText, @NonNull ex1 ex1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048595, this, swanEditText, ex1Var) == null) {
            if (jw1.h) {
                Log.d("Component-Input", "renderTextStyleFontWeight");
            }
            String str = ex1Var.A;
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
                super.W(swanEditText, ex1Var);
            } else {
                swanEditText.setTypeface(Typeface.SANS_SERIF, 3);
            }
        }
    }

    @Override // com.repackage.jw1
    public void x(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            super.x(z);
            if (!z) {
                nx1.a("Component-Input", "attach fail");
            }
            SwanEditText swanEditText = (SwanEditText) q();
            if (swanEditText == null) {
                nx1.a("Component-Input", "onAttached with null editText");
                swanEditText = hj2.d().c();
            }
            swanEditText.setFocusable(true);
            swanEditText.setFocusableInTouchMode(true);
            swanEditText.requestFocus();
            if (TextUtils.equals(((ex1) n()).L, "text")) {
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
    @Override // com.repackage.fw1
    /* renamed from: x0 */
    public void X(@NonNull SwanEditText swanEditText, @NonNull ex1 ex1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, swanEditText, ex1Var) == null) {
            Y(swanEditText, ex1Var, 16);
        }
    }

    public final void y0(@NonNull SwanEditText swanEditText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, swanEditText) == null) {
            if (jw1.h) {
                Log.d("Component-Input", "scrollBackWhenKeyboardHide, mKeyboardHeight：" + this.l);
            }
            if (this.l != 0) {
                this.l = 0;
                swanEditText.clearFocus();
                if (this.j.w3().getScrollY() > 0) {
                    this.j.w3().setScrollY(0);
                }
            }
        }
    }

    @Override // com.repackage.jw1
    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            super.z();
        }
    }

    public final void z0(@NonNull SwanAppActivity swanAppActivity, @NonNull SwanEditText swanEditText, ex1 ex1Var, int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(1048600, this, swanAppActivity, swanEditText, ex1Var, i) == null) {
            bn1 i3 = hm2.U().i();
            if (jw1.h) {
                Log.d("Component-Input", "scrollUpWhenKeyboardShow, mKeyboardHeight：" + this.l + "，keyboardHeight : " + i);
            }
            if (this.l == i || i3 == null) {
                return;
            }
            this.l = i;
            ij2.f(swanEditText, i);
            if (ex1Var.N) {
                if (ex1Var.h == null) {
                    ex1Var.h = new ar2();
                }
                int webViewScrollY = i3.getWebViewScrollY();
                int height = swanEditText.getHeight();
                if (height == 0) {
                    height = ex1Var.h.c();
                }
                int height2 = ((this.j.w3().getHeight() - ex1Var.h.e()) - height) + webViewScrollY + le3.k(swanAppActivity);
                int i4 = ex1Var.E;
                if (i4 > height2) {
                    i4 = height2;
                }
                int i5 = height2 - i;
                int scrollY = this.j.w3().getScrollY();
                if (i5 < 0) {
                    i2 = i4 - i5;
                } else {
                    if (i4 > i5) {
                        scrollY = i4 - i5;
                    }
                    i2 = scrollY;
                }
                this.j.w3().setScrollY(i2);
            }
        }
    }
}
