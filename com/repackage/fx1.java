package com.repackage;

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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.face.platform.ConstPath;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.component.components.textarea.SwanEditText;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.textarea.ShowConfirmBarLayout;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class fx1 extends aw1<SwanEditText, gx1> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SwanAppActivity i;
    public c02 j;
    public int k;
    public i l;
    public String m;
    public int n;
    public ShowConfirmBarLayout o;
    public boolean p;
    public int q;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gx1 a;
        public final /* synthetic */ SwanEditText b;
        public final /* synthetic */ fx1 c;

        public a(fx1 fx1Var, gx1 gx1Var, SwanEditText swanEditText) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fx1Var, gx1Var, swanEditText};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = fx1Var;
            this.a = gx1Var;
            this.b = swanEditText;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.c.i != null) {
                    InputMethodManager inputMethodManager = (InputMethodManager) this.c.i.getSystemService("input_method");
                    if (inputMethodManager == null || !this.a.P) {
                        return;
                    }
                    this.b.setFocusable(true);
                    this.b.setFocusableInTouchMode(true);
                    this.b.requestFocus();
                    inputMethodManager.showSoftInput(this.b, 0);
                    return;
                }
                nx1.a("Component-TextArea", "activity is null, set textarea attr failed");
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements SwanEditText.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanEditText a;
        public final /* synthetic */ fx1 b;

        public b(fx1 fx1Var, SwanEditText swanEditText) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fx1Var, swanEditText};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = fx1Var;
            this.a = swanEditText;
        }

        @Override // com.baidu.swan.apps.component.components.textarea.SwanEditText.a
        public void a(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
                this.b.F0(this.a, "selection");
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanEditText a;
        public final /* synthetic */ fx1 b;

        public c(fx1 fx1Var, SwanEditText swanEditText) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fx1Var, swanEditText};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = fx1Var;
            this.a = swanEditText;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, editable) == null) && this.a.hasFocus()) {
                ux1.i("Component-TextArea", "send input callback");
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
            if (!(interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) || this.a.getLineCount() <= 0) {
                return;
            }
            if (this.b.q != this.a.getLineCount()) {
                ux1.i("Component-TextArea", "send line change callback");
                this.b.F0(this.a, "linechange");
            }
            int i4 = i3 - i2;
            if (i2 != i4) {
                this.b.G0(this.a, "input", i2 > i4 ? '\b' : charSequence.charAt((i + i4) - 1));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanEditText a;
        public final /* synthetic */ fx1 b;

        public d(fx1 fx1Var, SwanEditText swanEditText) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fx1Var, swanEditText};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = fx1Var;
            this.a = swanEditText;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, view2, z) == null) {
                if (jw1.h) {
                    Log.d("Component-TextArea", "onFocusChange:" + z);
                }
                if (z) {
                    if (this.b.k != 0) {
                        this.b.F0(this.a, AddFriendActivityConfig.TYPE_FOCUS);
                    }
                    this.b.J0();
                    return;
                }
                this.b.F0(this.a, ConstPath.KEY_BLUR);
                this.b.I0();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements hc3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanEditText a;
        public final /* synthetic */ SwanAppActivity b;
        public final /* synthetic */ View c;
        public final /* synthetic */ fx1 d;

        /* loaded from: classes6.dex */
        public class a implements ShowConfirmBarLayout.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ gx1 a;
            public final /* synthetic */ e b;

            public a(e eVar, gx1 gx1Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar, gx1Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = eVar;
                this.a = gx1Var;
            }

            @Override // com.baidu.swan.apps.textarea.ShowConfirmBarLayout.b
            public void onClick(View view2) {
                InputMethodManager inputMethodManager;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    if (!this.a.X && (inputMethodManager = (InputMethodManager) this.b.b.getSystemService("input_method")) != null) {
                        inputMethodManager.hideSoftInputFromWindow(this.b.a.getWindowToken(), 0);
                    }
                    ux1.i("Component-TextArea", "send confirm change callback");
                    e eVar = this.b;
                    eVar.d.F0(eVar.a, "confirm");
                }
            }
        }

        public e(fx1 fx1Var, SwanEditText swanEditText, SwanAppActivity swanAppActivity, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fx1Var, swanEditText, swanAppActivity, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = fx1Var;
            this.a = swanEditText;
            this.b = swanAppActivity;
            this.c = view2;
        }

        @Override // com.repackage.hc3
        public void a(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i) == null) {
                if (this.d.k != 0) {
                    this.d.k = 0;
                    if (this.d.j.w3().getScrollY() > 0) {
                        this.d.j.w3().setScrollY(0);
                        this.d.p = false;
                    }
                    if (this.d.o != null && this.d.o.getVisibility() == 0) {
                        ((FrameLayout) this.c.findViewById(16908290)).removeView(this.d.o);
                        this.d.o = null;
                    }
                }
                if (this.a.hasFocus()) {
                    this.a.clearFocus();
                    if (jw1.h) {
                        Log.d("Component-TextArea", "clearFocus");
                    }
                }
            }
        }

        @Override // com.repackage.hc3
        public void b(String str, int i) {
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i) == null) {
                gx1 gx1Var = (gx1) this.d.n();
                bn1 i3 = hm2.U().i();
                if (this.d.k == i || !this.a.hasFocus() || i3 == null) {
                    return;
                }
                this.d.k = i;
                this.d.n = this.a.getHeight();
                this.d.F0(this.a, AddFriendActivityConfig.TYPE_FOCUS);
                boolean z = gx1Var.T;
                if (gx1Var.S) {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                    i2 = le3.g(38.0f);
                    if (this.d.o == null) {
                        this.d.o = new ShowConfirmBarLayout(this.b);
                        this.d.o.setOnConfirmButtonClickListener(new a(this, gx1Var));
                        layoutParams.topMargin = ((this.c.getHeight() - i) - i2) - ee3.c();
                        ((FrameLayout) this.c.findViewById(16908290)).addView(this.d.o, layoutParams);
                    }
                } else {
                    i2 = 0;
                }
                if (z) {
                    int webViewScrollY = !gx1Var.R ? i3.getWebViewScrollY() : 0;
                    ar2 ar2Var = gx1Var.h;
                    int height = ((this.d.j.w3().getHeight() - (ar2Var != null ? ar2Var.e() : 0)) - this.a.getHeight()) + webViewScrollY;
                    int i4 = gx1Var.E;
                    if (height - i4 < i) {
                        this.d.p = true;
                        if (i4 > height) {
                            this.d.j.w3().setScrollY(i + i2);
                            return;
                        } else {
                            this.d.j.w3().setScrollY((i - height) + i4 + i2);
                            return;
                        }
                    }
                    this.d.p = false;
                }
            }
        }

        @Override // com.repackage.hc3
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || this.d.q == this.a.getLineCount()) {
                return;
            }
            ux1.i("Component-TextArea", "send line change callback");
            this.d.F0(this.a, "linechange");
            this.d.E0(this.a, str);
        }
    }

    /* loaded from: classes6.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanEditText a;
        public final /* synthetic */ String b;
        public final /* synthetic */ fx1 c;

        public f(fx1 fx1Var, SwanEditText swanEditText, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fx1Var, swanEditText, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = fx1Var;
            this.a = swanEditText;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a == null) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            String obj = this.a.getTag().toString();
            if (!TextUtils.equals(obj, ((gx1) this.c.n()).b)) {
                nx1.a("Component-TextArea", "changeTextAreaStatus with different id");
            }
            int D0 = this.c.D0(this.a);
            try {
                jSONObject.put("eventName", this.b);
                jSONObject.put("value", this.a.getText().toString());
                jSONObject.put(Constants.EXTRA_CONFIG_CURSOR, this.a.getSelectionStart());
                jSONObject.put("selectionStart", this.a.getSelectionStart());
                jSONObject.put("selectionEnd", this.a.getSelectionEnd());
                jSONObject.put("lineCount", this.a.getLineCount());
                jSONObject.put("height", "" + le3.O(D0));
                jSONObject.put("keyboardHeight", "" + le3.O((float) this.c.k));
            } catch (JSONException e) {
                if (jw1.h) {
                    e.printStackTrace();
                }
            }
            if (jw1.h) {
                Log.d("Component-TextArea", "changeTextAreaStatus:" + jSONObject.toString());
            }
            this.c.l.a(obj, this.c.m, jSONObject);
        }
    }

    /* loaded from: classes6.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanEditText a;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;
        public final /* synthetic */ fx1 d;

        public g(fx1 fx1Var, SwanEditText swanEditText, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fx1Var, swanEditText, str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = fx1Var;
            this.a = swanEditText;
            this.b = str;
            this.c = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a == null) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            String obj = this.a.getTag().toString();
            if (!TextUtils.equals(obj, ((gx1) this.d.n()).b)) {
                nx1.a("Component-TextArea", "changeTextAreaStatus with different id");
            }
            int D0 = this.d.D0(this.a);
            try {
                jSONObject.put("eventName", this.b);
                jSONObject.put("value", this.a.getText().toString());
                jSONObject.put(Constants.EXTRA_CONFIG_CURSOR, this.a.getSelectionStart());
                jSONObject.put("selectionStart", this.a.getSelectionStart());
                jSONObject.put("selectionEnd", this.a.getSelectionEnd());
                jSONObject.put("lineCount", this.a.getLineCount());
                jSONObject.put("height", "" + le3.O(D0));
                jSONObject.put("keyboardHeight", "" + le3.O((float) this.d.k));
                jSONObject.put("keyCode", this.c);
            } catch (JSONException e) {
                if (jw1.h) {
                    e.printStackTrace();
                }
            }
            if (jw1.h) {
                Log.d("Component-TextArea", "changeTextAreaStatus:" + jSONObject.toString());
            }
            this.d.l.a(obj, this.d.m, jSONObject);
        }
    }

    /* loaded from: classes6.dex */
    public class h implements TextView.OnEditorActionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanEditText a;
        public final /* synthetic */ gx1 b;
        public final /* synthetic */ fx1 c;

        public h(fx1 fx1Var, SwanEditText swanEditText, gx1 gx1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fx1Var, swanEditText, gx1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = fx1Var;
            this.a = swanEditText;
            this.b = gx1Var;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, textView, i, keyEvent)) == null) {
                if (i >= 2 && i <= 7) {
                    this.c.F0(this.a, "confirm");
                }
                return this.b.X;
            }
            return invokeLIL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public interface i {
        void a(String str, String str2, JSONObject jSONObject);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fx1(@Nullable Context context, @NonNull gx1 gx1Var, @NonNull SwanAppActivity swanAppActivity, @NonNull c02 c02Var, @NonNull i iVar) {
        super(context, gx1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, gx1Var, swanAppActivity, c02Var, iVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (bw1) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.p = false;
        this.q = 1;
        this.i = swanAppActivity;
        this.j = c02Var;
        this.l = iVar;
    }

    public final int D0(SwanEditText swanEditText) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, swanEditText)) == null) {
            gx1 gx1Var = (gx1) n();
            int lineCount = swanEditText.getLineCount();
            int lineHeight = swanEditText.getLineHeight();
            int i2 = gx1Var.U;
            int i3 = gx1Var.V;
            int height = swanEditText.getHeight();
            if (gx1Var.Q) {
                int paddingTop = (lineHeight * lineCount) + swanEditText.getPaddingTop() + swanEditText.getPaddingBottom();
                if (i3 < i2) {
                    i3 = i2;
                }
                return paddingTop <= i2 ? i2 : paddingTop >= i3 ? i3 : paddingTop;
            }
            return height;
        }
        return invokeL.intValue;
    }

    public final void E0(SwanEditText swanEditText, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, swanEditText, str) == null) {
            gx1 gx1Var = (gx1) n();
            if (!TextUtils.equals(str, gx1Var.b)) {
                nx1.a("Component-TextArea", "keyBoardShow with different id");
            }
            boolean z = gx1Var.T;
            if (!swanEditText.hasFocus() || gx1Var.R) {
                return;
            }
            if (this.k > 0 && z && this.p) {
                int scrollY = this.j.w3().getScrollY() + (swanEditText.getHeight() - this.n);
                if (scrollY > 0) {
                    this.j.w3().setScrollY(scrollY);
                } else {
                    this.j.w3().setScrollY(0);
                }
            }
            this.n = swanEditText.getHeight();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final void F0(SwanEditText swanEditText, String str) {
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, swanEditText, str) == null) {
            switch (str.hashCode()) {
                case -1715965556:
                    if (str.equals("selection")) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3027047:
                    if (str.equals(ConstPath.KEY_BLUR)) {
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
                    if (str.equals("input")) {
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
                ((gx1) n()).m(swanEditText.getHeight());
            } else if (c2 == 1) {
                ((gx1) n()).j(swanEditText.getText().toString());
            } else if (c2 == 2) {
                ((gx1) n()).q(true);
            } else if (c2 == 3) {
                ((gx1) n()).q(false);
            } else if (c2 == 4) {
                ((gx1) n()).l(swanEditText.getSelectionStart(), swanEditText.getSelectionEnd());
            }
            oe3.a0(new f(this, swanEditText, str));
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final void G0(SwanEditText swanEditText, String str, int i2) {
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048581, this, swanEditText, str, i2) == null) {
            switch (str.hashCode()) {
                case -1715965556:
                    if (str.equals("selection")) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3027047:
                    if (str.equals(ConstPath.KEY_BLUR)) {
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
                    if (str.equals("input")) {
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
                ((gx1) n()).m(swanEditText.getHeight());
            } else if (c2 == 1) {
                ((gx1) n()).j(swanEditText.getText().toString());
            } else if (c2 == 2) {
                ((gx1) n()).q(true);
            } else if (c2 == 3) {
                ((gx1) n()).q(false);
            } else if (c2 == 4) {
                ((gx1) n()).l(swanEditText.getSelectionStart(), swanEditText.getSelectionEnd());
            }
            oe3.a0(new g(this, swanEditText, str, i2));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.aw1, com.repackage.fw1, com.repackage.hw1, com.repackage.jw1
    @NonNull
    /* renamed from: H0 */
    public mx1 k(@NonNull gx1 gx1Var, @NonNull gx1 gx1Var2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, gx1Var, gx1Var2)) == null) {
            mx1 k = super.k(gx1Var, gx1Var2);
            if (!TextUtils.equals(gx1Var.L, gx1Var2.L)) {
                k.b(14);
            }
            if (gx1Var.M != gx1Var2.M) {
                k.b(14);
            }
            if (!TextUtils.equals(gx1Var.N, gx1Var2.N)) {
                k.b(14);
            }
            if (!TextUtils.equals(gx1Var.O, gx1Var2.O)) {
                k.b(14);
            }
            if (gx1Var.W != gx1Var2.W) {
                k.b(15);
            }
            return k;
        }
        return (mx1) invokeLL.objValue;
    }

    public final void I0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            SwanAppActivity activity = hm2.U().getActivity();
            if (activity == null) {
                ux1.o("Component-TextArea", "activity is null when close input");
                return;
            }
            if (jw1.h) {
                Log.d("Component-TextArea", "forceCloseKeyboard");
            }
            vd3.a(activity, activity.getWindow().getDecorView().getWindowToken());
        }
    }

    public final void J0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            SwanAppActivity activity = hm2.U().getActivity();
            if (activity == null) {
                ux1.o("Component-TextArea", "activity is null when open input");
                return;
            }
            if (jw1.h) {
                Log.d("Component-TextArea", "forceOpenKeyboard");
            }
            vd3.b(activity, true);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.jw1
    @NonNull
    /* renamed from: K0 */
    public SwanEditText v(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, context)) == null) ? new SwanEditText(context) : (SwanEditText) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.jw1
    /* renamed from: L0 */
    public void A(@NonNull SwanEditText swanEditText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, swanEditText) == null) {
            super.A(swanEditText);
            gx1 gx1Var = (gx1) n();
            swanEditText.setTag(gx1Var.b);
            swanEditText.setInputType(262144);
            swanEditText.setSingleLine(false);
            swanEditText.setHorizontallyScrolling(false);
            this.m = gx1Var.e;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.aw1
    /* renamed from: M0 */
    public void a0(@NonNull SwanEditText swanEditText, @NonNull gx1 gx1Var, @NonNull mx1 mx1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048588, this, swanEditText, gx1Var, mx1Var) == null) {
            super.T(swanEditText, gx1Var, mx1Var);
            if (mx1Var.a(14)) {
                Q0(swanEditText, gx1Var);
            }
            boolean z = !t();
            if (z) {
                swanEditText.setMinHeight(gx1Var.U);
                swanEditText.setMaxHeight(gx1Var.V);
            }
            oe3.a0(new a(this, gx1Var, swanEditText));
            if (mx1Var.a(15)) {
                P0(swanEditText, gx1Var);
            }
            if (z) {
                V0(swanEditText, this.i);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.aw1
    /* renamed from: N0 */
    public boolean c0(@NonNull SwanEditText swanEditText, @NonNull gx1 gx1Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, swanEditText, gx1Var)) == null) {
            if (TextUtils.isEmpty(gx1Var.I) || "default".equals(gx1Var.I)) {
                return false;
            }
            boolean c0 = super.c0(swanEditText, gx1Var);
            if (c0) {
                swanEditText.setOnEditorActionListener(new h(this, swanEditText, gx1Var));
            }
            return c0;
        }
        return invokeLL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.aw1
    /* renamed from: O0 */
    public void d0(@NonNull SwanEditText swanEditText, @NonNull gx1 gx1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, swanEditText, gx1Var) == null) {
            Editable text = swanEditText.getText();
            int length = text != null ? text.length() : 0;
            if (gx1Var.P) {
                int i2 = gx1Var.F;
                if (i2 <= length && i2 >= 0) {
                    swanEditText.setSelection(i2);
                } else {
                    swanEditText.setSelection(length);
                }
            }
        }
    }

    public final void P0(@NonNull SwanEditText swanEditText, @NonNull gx1 gx1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, swanEditText, gx1Var) == null) {
            if (jw1.h) {
                Log.d("Component-TextArea", "renderDisable");
            }
            swanEditText.setEnabled(!gx1Var.W);
        }
    }

    public final void Q0(@NonNull SwanEditText swanEditText, @NonNull gx1 gx1Var) {
        StyleSpan styleSpan;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, swanEditText, gx1Var) == null) {
            if (jw1.h) {
                Log.d("Component-TextArea", "renderPlaceHolder");
            }
            SpannableString spannableString = new SpannableString(gx1Var.L);
            String str = gx1Var.N;
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
            spannableString.setSpan(styleSpan, 0, gx1Var.L.length(), 33);
            spannableString.setSpan(new ForegroundColorSpan(SwanAppConfigData.t(gx1Var.O)), 0, gx1Var.L.length(), 33);
            spannableString.setSpan(new AbsoluteSizeSpan(gx1Var.M, true), 0, gx1Var.L.length(), 33);
            swanEditText.setHint(spannableString);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.aw1
    /* renamed from: R0 */
    public void f0(@NonNull SwanEditText swanEditText, @NonNull gx1 gx1Var) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, swanEditText, gx1Var) == null) {
            Editable text = swanEditText.getText();
            int length = text != null ? text.length() : 0;
            int i3 = gx1Var.H;
            if (i3 > length || i3 <= 0 || (i2 = gx1Var.G) > i3 || i2 <= 0 || !gx1Var.P || swanEditText.hasFocus()) {
                return;
            }
            swanEditText.setSelection(gx1Var.G, gx1Var.H);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.fw1
    /* renamed from: S0 */
    public void U(@NonNull SwanEditText swanEditText, @NonNull gx1 gx1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, swanEditText, gx1Var) == null) {
            if (jw1.h) {
                Log.d("Component-TextArea", "renderText");
            }
            if (TextUtils.equals(swanEditText.getText(), gx1Var.t)) {
                return;
            }
            swanEditText.setLineSpacing(gx1Var.y, 1.0f);
            swanEditText.setText(gx1Var.t);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.fw1
    /* renamed from: T0 */
    public void X(@NonNull SwanEditText swanEditText, @NonNull gx1 gx1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048598, this, swanEditText, gx1Var) == null) {
            super.Y(swanEditText, gx1Var, 48);
        }
    }

    public void U0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, str) == null) {
            if (!TextUtils.equals(((gx1) n()).b, str)) {
                nx1.a("Component-TextArea", "sendLineChangeEvent with different id");
            }
            SwanEditText swanEditText = (SwanEditText) q();
            if (swanEditText == null) {
                nx1.a("Component-TextArea", "sendLineChangeEvent with a null editText");
            } else {
                F0(swanEditText, "linechange");
            }
        }
    }

    public final void V0(SwanEditText swanEditText, @NonNull SwanAppActivity swanAppActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048601, this, swanEditText, swanAppActivity) == null) {
            swanEditText.setSelectListener(new b(this, swanEditText));
            swanEditText.addTextChangedListener(new c(this, swanEditText));
            swanEditText.setOnFocusChangeListener(new d(this, swanEditText));
            ic3.g(((gx1) n()).b, swanAppActivity, new e(this, swanEditText, swanAppActivity, swanAppActivity.getWindow().getDecorView()));
        }
    }
}
