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
import com.repackage.zh2;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class qv1 extends nu1<SwanEditText, rv1> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SwanAppActivity i;
    public py1 j;
    public zh2 k;
    public int l;

    /* loaded from: classes6.dex */
    public class a extends ec2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanEditText a;
        public final /* synthetic */ qv1 b;

        public a(qv1 qv1Var, SwanEditText swanEditText) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qv1Var, swanEditText};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = qv1Var;
            this.a = swanEditText;
        }

        @Override // com.repackage.ec2, com.repackage.fc2
        public void b() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.b.k == null) {
                return;
            }
            this.b.k.dismiss();
            this.b.p0(this.a);
        }

        @Override // com.repackage.ec2, com.repackage.fc2
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

    /* loaded from: classes6.dex */
    public class b implements zh2.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanEditText a;
        public final /* synthetic */ rv1 b;
        public final /* synthetic */ ec2 c;
        public final /* synthetic */ qv1 d;

        public b(qv1 qv1Var, SwanEditText swanEditText, rv1 rv1Var, ec2 ec2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qv1Var, swanEditText, rv1Var, ec2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = qv1Var;
            this.a = swanEditText;
            this.b = rv1Var;
            this.c = ec2Var;
        }

        @Override // com.repackage.zh2.d
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (wu1.h) {
                    Log.d("Component-Input", "numeric keyboard onKeyboardHide");
                }
                this.d.y0(this.a);
                this.d.i.unregisterCallback(this.c);
            }
        }

        @Override // com.repackage.zh2.d
        public void b(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                if (wu1.h) {
                    Log.d("Component-Input", "numeric keyboard onKeyboardShow");
                }
                qv1 qv1Var = this.d;
                qv1Var.z0(qv1Var.i, this.a, this.b, i);
                this.d.i.registerCallback(this.c);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements TextView.OnEditorActionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rv1 a;
        public final /* synthetic */ SwanEditText b;
        public final /* synthetic */ qv1 c;

        public c(qv1 qv1Var, rv1 rv1Var, SwanEditText swanEditText) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qv1Var, rv1Var, swanEditText};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = qv1Var;
            this.a = rv1Var;
            this.b = swanEditText;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, textView, i, keyEvent)) == null) {
                vh2.d(uh2.d().c(), this.c.l);
                if (this.a.M) {
                    return true;
                }
                this.b.clearFocus();
                return false;
            }
            return invokeLIL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class d implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanEditText a;
        public final /* synthetic */ qv1 b;

        public d(qv1 qv1Var, SwanEditText swanEditText) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qv1Var, swanEditText};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = qv1Var;
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
            vh2.c((rv1) this.b.n(), this.a, i2 > i3 ? '\b' : charSequence.charAt((i + i3) - 1));
        }
    }

    /* loaded from: classes6.dex */
    public class e implements View.OnFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rv1 a;
        public final /* synthetic */ SwanEditText b;
        public final /* synthetic */ qv1 c;

        public e(qv1 qv1Var, rv1 rv1Var, SwanEditText swanEditText) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qv1Var, rv1Var, swanEditText};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = qv1Var;
            this.a = rv1Var;
            this.b = swanEditText;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, view2, z) == null) {
                if (wu1.h) {
                    Log.d("Component-Input", "onFocusChange:" + z);
                }
                if (z) {
                    return;
                }
                hw1.i("Component-Input", "send blur callback");
                if (!TextUtils.equals("text", this.a.L) && this.c.k != null) {
                    this.c.k.dismiss();
                }
                vh2.b(this.b, this.c.l);
                this.c.p0(this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements ua3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanEditText a;
        public final /* synthetic */ SwanAppActivity b;
        public final /* synthetic */ rv1 c;
        public final /* synthetic */ View d;
        public final /* synthetic */ qv1 e;

        public f(qv1 qv1Var, SwanEditText swanEditText, SwanAppActivity swanAppActivity, rv1 rv1Var, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qv1Var, swanEditText, swanAppActivity, rv1Var, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = qv1Var;
            this.a = swanEditText;
            this.b = swanAppActivity;
            this.c = rv1Var;
            this.d = view2;
        }

        @Override // com.repackage.ua3
        public void a(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i) == null) {
                this.e.y0(this.a);
                wa3.i().k(this.d);
            }
        }

        @Override // com.repackage.ua3
        public void b(String str, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i) == null) && this.a.hasFocus()) {
                this.e.z0(this.b, this.a, this.c, i);
            }
        }

        @Override // com.repackage.ua3
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface g {
        void a(String str, JSONObject jSONObject);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qv1(@Nullable Context context, @NonNull rv1 rv1Var, @NonNull SwanAppActivity swanAppActivity, @NonNull py1 py1Var, @NonNull g gVar) {
        super(context, rv1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, rv1Var, swanAppActivity, py1Var, gVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (ou1) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = swanAppActivity;
        this.j = py1Var;
        vh2.a(gVar);
    }

    public final void A0(SwanEditText swanEditText, rv1 rv1Var, SwanAppActivity swanAppActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, swanEditText, rv1Var, swanAppActivity) == null) {
            swanEditText.setOnEditorActionListener(new c(this, rv1Var, swanEditText));
            d dVar = new d(this, swanEditText);
            swanEditText.setOnFocusChangeListener(new e(this, rv1Var, swanEditText));
            if (TextUtils.equals("text", rv1Var.L)) {
                View decorView = swanAppActivity.getWindow().getDecorView();
                wa3.i().l(decorView, rv1Var.b, new f(this, swanEditText, swanAppActivity, rv1Var, decorView));
            }
            uh2.d().f(dVar);
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
                if (wu1.h) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public final void p0(@Nullable SwanEditText swanEditText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, swanEditText) == null) {
            SwanAppActivity activity = uk2.U().getActivity();
            if (activity == null) {
                hw1.o("Component-Input", "activity is null when close input");
                return;
            }
            ic3.a(activity, activity.getWindow().getDecorView().getWindowToken());
            if (swanEditText == null) {
                return;
            }
            swanEditText.setOnFocusChangeListener(null);
            hw1.i("Component-Input", "remove input");
            if (B().a()) {
                hw1.i("Component-Input", "remove input success");
            } else {
                hw1.o("Component-Input", "remove input fail");
            }
            uh2.d().b();
        }
    }

    public final void q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            p0(uh2.d().c());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.wu1
    @NonNull
    /* renamed from: r0 */
    public SwanEditText v(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, context)) == null) {
            q0();
            return uh2.d().a(context);
        }
        return (SwanEditText) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.wu1
    /* renamed from: s0 */
    public void A(@NonNull SwanEditText swanEditText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, swanEditText) == null) {
            super.A(swanEditText);
            rv1 rv1Var = (rv1) n();
            swanEditText.setText(rv1Var.t);
            int i = 1;
            swanEditText.setSingleLine(true);
            swanEditText.setTag(rv1Var.e);
            if (!TextUtils.equals("text", rv1Var.L)) {
                String str = rv1Var.L;
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
                this.k = new zh2(this.i, swanEditText, i, rv1Var.D);
                this.k.e(new b(this, swanEditText, rv1Var, new a(this, swanEditText)));
                this.k.f();
            }
            if (rv1Var.J) {
                swanEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.nu1
    /* renamed from: t0 */
    public void a0(@NonNull SwanEditText swanEditText, @NonNull rv1 rv1Var, @NonNull zv1 zv1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048591, this, swanEditText, rv1Var, zv1Var) == null) {
            boolean t = t();
            if (t) {
                swanEditText.removeTextChangedListener(uh2.d().e());
            }
            super.T(swanEditText, rv1Var, zv1Var);
            if (t) {
                swanEditText.addTextChangedListener(uh2.d().e());
            } else {
                A0(swanEditText, rv1Var, this.i);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.uu1
    /* renamed from: u0 */
    public void R(@NonNull SwanEditText swanEditText, @NonNull rv1 rv1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, swanEditText, rv1Var) == null) {
            if (wu1.h) {
                Log.d("Component-Input", "renderPadding");
            }
            swanEditText.setPadding(0, -6, 0, 0);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.su1
    /* renamed from: v0 */
    public void U(@NonNull SwanEditText swanEditText, @NonNull rv1 rv1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, swanEditText, rv1Var) == null) {
            if (wu1.h) {
                Log.d("Component-Input", "renderText");
            }
            if (t()) {
                super.U(swanEditText, rv1Var);
                try {
                    swanEditText.setSelection(rv1Var.t.length());
                } catch (IndexOutOfBoundsException e2) {
                    if (wu1.h) {
                        e2.printStackTrace();
                    }
                    aw1.a("Component-Input", "value is invalid, out of max length");
                }
            } else if (TextUtils.equals(swanEditText.getText(), rv1Var.t)) {
            } else {
                aw1.a("Component-Input", "insert input: set text must before render");
                super.U(swanEditText, rv1Var);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.su1
    /* renamed from: w0 */
    public void W(@NonNull SwanEditText swanEditText, @NonNull rv1 rv1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048595, this, swanEditText, rv1Var) == null) {
            if (wu1.h) {
                Log.d("Component-Input", "renderTextStyleFontWeight");
            }
            String str = rv1Var.A;
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
                super.W(swanEditText, rv1Var);
            } else {
                swanEditText.setTypeface(Typeface.SANS_SERIF, 3);
            }
        }
    }

    @Override // com.repackage.wu1
    public void x(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            super.x(z);
            if (!z) {
                aw1.a("Component-Input", "attach fail");
            }
            SwanEditText swanEditText = (SwanEditText) q();
            if (swanEditText == null) {
                aw1.a("Component-Input", "onAttached with null editText");
                swanEditText = uh2.d().c();
            }
            swanEditText.setFocusable(true);
            swanEditText.setFocusableInTouchMode(true);
            swanEditText.requestFocus();
            if (TextUtils.equals(((rv1) n()).L, "text")) {
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
    @Override // com.repackage.su1
    /* renamed from: x0 */
    public void X(@NonNull SwanEditText swanEditText, @NonNull rv1 rv1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, swanEditText, rv1Var) == null) {
            Y(swanEditText, rv1Var, 16);
        }
    }

    public final void y0(@NonNull SwanEditText swanEditText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, swanEditText) == null) {
            if (wu1.h) {
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

    @Override // com.repackage.wu1
    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            super.z();
        }
    }

    public final void z0(@NonNull SwanAppActivity swanAppActivity, @NonNull SwanEditText swanEditText, rv1 rv1Var, int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(1048600, this, swanAppActivity, swanEditText, rv1Var, i) == null) {
            ol1 i3 = uk2.U().i();
            if (wu1.h) {
                Log.d("Component-Input", "scrollUpWhenKeyboardShow, mKeyboardHeight：" + this.l + "，keyboardHeight : " + i);
            }
            if (this.l == i || i3 == null) {
                return;
            }
            this.l = i;
            vh2.f(swanEditText, i);
            if (rv1Var.N) {
                if (rv1Var.h == null) {
                    rv1Var.h = new np2();
                }
                int webViewScrollY = i3.getWebViewScrollY();
                int height = swanEditText.getHeight();
                if (height == 0) {
                    height = rv1Var.h.c();
                }
                int height2 = ((this.j.w3().getHeight() - rv1Var.h.e()) - height) + webViewScrollY + yc3.k(swanAppActivity);
                int i4 = rv1Var.E;
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
